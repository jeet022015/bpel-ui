package be.ac.fundp.precise.ui_bpel.transformation.executable_bpel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.adapters.INamespaceMap;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.XSD2XMLGenerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDTypeDefinition;

import be.edu.fundp.precise.uibpel.model.DataType;

public class ExecutableTransUtil {

	/** The Constant HEAD_STRING. */
	protected static final String HEAD_STRING =  "xmlns:s1=\"http://www.w3.org/2001/XMLSchema-instance\" " +
 		    "xmlns:s2=\"http://www.w3.org/2001/XMLSchema\" " +
 		    "s1:type=\"s2:string\">";

	/** The Constant NL. */
	protected static final String NL = System.getProperty("line.separator");
	
	protected static Map<String, String> mapperType = new HashMap<String, String>();
	
	static {
		mapperType.put(DataType.STRING_TYPE.getLiteral(), HEAD_STRING);
	}
	
	/**
	 * Construct an appropriate XML literal initializer for the given variable and message part.
	 *
	 * @param bpelEditor the bpel editor
	 * @param var - the variable to be initialized
	 * @param part - if the variable is defined as a message, this is the message part
	 * otherwise null
	 * @param dataItems the data items
	 * @return - XML string representing an intializer for the given variable
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	 * @see https://jira.jboss.org/browse/JBIDE-7351
	 */
	@SuppressWarnings("rawtypes")
	public static String createDefaultInitializer(Variable var, Part part, String[] dataItemTypes) {
		String fromString = "";
		try {
			String rootElement = null;
			String uriWSDL = null;

			Message msg = (Message)var.getMessageType();
			if (msg != null)
				if (part==null) {
					Map<?, ?> parts = msg.getParts();
					if (parts!=null && !parts.isEmpty()) {
						Map.Entry entry = (Map.Entry)parts.entrySet().iterator().next();
						part = (Part)entry.getValue();
					}
				} else {
					XSDElementDeclaration declaration = part.getElementDeclaration();
					if (declaration != null) {
						uriWSDL = declaration.getSchema().getSchemaLocation();
						rootElement = declaration.getName();
					}
				}

			// Variable is defined using "type"
			XSDTypeDefinition type = var.getType();
			if (type != null) {
				QName qname = new QName(type.getTargetNamespace(), type.getName());
				rootElement = qname.getLocalPart();
				uriWSDL = type.eResource().getURI().toString();
			}

			// Variable is defined using "element"
			XSDElementDeclaration element = var.getXSDElement();
			if (element != null) {
				QName qname = new QName(element.getTargetNamespace(), element
						.getName());
				rootElement = qname.getLocalPart();
				uriWSDL = element.eResource().getURI().toString();
			}

			XSD2XMLGenerator generator = new XSD2XMLGenerator(uriWSDL, rootElement);
			fromString = generator.createXML();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//this code replace the any xsi:type="anyType" by the representation of string
		//HEAD_STRING+ "Data" +tail
		String finalSt = fromString;
		Pattern pattern = Pattern.compile("<[a-zA-Z]*:?data>.*</[a-zA-Z]*:?data>", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(fromString);
		if (matcher.find()){
			String myShit = matcher.group();
			String tail = ("</"+ myShit.split("data")[1].replaceAll("\\s|<|>|"+NL, "") + "data>").trim();
			
			
			String body = "";
			
			for (String aDataItemType : dataItemTypes) {
				String mappedType = mapperType.get(aDataItemType);
				String head = myShit.replaceAll("xsi:type=\"anyType\"/>", mappedType +tail);
				body += head;
			}
			
			finalSt = pattern.split(fromString)[0] + body + pattern.split(fromString)[1];
		}
		return finalSt;
	}

	public static String qNameToString(EObject eObject, QName qname, Process process) {
		EObject context = eObject;
		List<String> prefixes = null;
		String namespace = qname.getNamespaceURI();

		if (namespace == null || namespace.length() == 0) {
			return qname.getLocalPart();
		}

		// Transform BPEL namespaces to the latest version so that
		// references to the old namespace are not serialized.
		if (BPELConstants.isBPELNamespace(namespace)) {
			namespace = BPELConstants.NAMESPACE;
		}
		while (context != null) {
			INamespaceMap<String, String> prefixNSMap = BPELUtils
					.getNamespaceMap(context);
			prefixes = prefixNSMap.getReverse(namespace);
			if (!prefixes.isEmpty()) {
				String prefix = prefixes.get(0);
				if (!prefix.equals(""))
					return prefix + ":" + qname.getLocalPart();
				else
					return qname.getLocalPart();
			}
			context = context.eContainer();
		}
		// if a prefix is not found for the namespaceURI, create a new
		// prefix
		return addNewRootPrefix("ns", namespace, process) + ":" + qname.getLocalPart();
	}
	
	/**
	 * Adds the new root prefix.
	 *
	 * @param basePrefix the base prefix
	 * @param namespace the namespace
	 * @return the string
	 */
	private static String addNewRootPrefix(String basePrefix, String namespace, Process process) {
		INamespaceMap<String, String> nsMap = BPELUtils
				.getNamespaceMap(process);

		List<String> prefixes = nsMap.getReverse(namespace);
		if (prefixes.isEmpty()) {
			int i = 0;
			String prefix = basePrefix;
			while (nsMap.containsKey(prefix)) {
				prefix = basePrefix + i;
				i++;
			}
			nsMap.put(prefix, namespace);
			return prefix;
		} else {
			return prefixes.get(0);
		}
	}
}
