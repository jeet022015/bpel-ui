package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.XSD2XMLGenerator;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDTypeDefinition;
import org.w3c.dom.Element;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

public class WriterUiBpel extends BPELWriter {

	private static final String EMPTY_STRING = null;
	private static final String HEAD_STRING =  "xmlns:s1=\"http://www.w3.org/2001/XMLSchema-instance\" " +
 		    "xmlns:s2=\"http://www.w3.org/2001/XMLSchema\" " +
 		    "s1:type=\"s2:string\">";
	private static final String NL = System.getProperty("line.separator");
	
	private BpelUIUtil bpel;
	
	public WriterUiBpel(Process process, IResource iFile) {
		super();
		//FIXME choose better names
		String arg1 = "";
		String arg2 = "";
		String arg3 = "";
		bpel = BpelUIUtil.getInstace();
		for (Import processImp : process.getImports()) {
			if (process.getTargetNamespace().equals(processImp.getNamespace())){
				IFolder folder = (IFolder) iFile.getParent();
				IFile file = folder.getFile(processImp.getLocation());
				arg1 = file.getFullPath().toString();
				file = folder.getFile("UiManager.wsdl");
				arg2 = file.getFullPath().toString();
				file = folder.getFile("UserEventListener.wsdl");
				arg3 = file.getFullPath().toString();
			}
		}
		bpel.configureProcess(arg1, arg2, arg3, process);
	}
	
	public void write(BPELResource resource, OutputStream out, Map<?, ?> args)
			throws IOException {
		super.write(resource, out, args);
		bpel.importNewWSDL();
	}
	
	protected Element process2XML(Process process) {
		if (!process.getImports().contains(bpel.getImportBPEL())) {
			process.getImports().add(bpel.getImportBPEL());
		}
		return super.process2XML(process);
	}

	protected Element variables2XML(Variables variables) {
		variables.getChildren().addAll(bpel.getUiVariables());
		return super.variables2XML(variables);
	}

	protected Element partnerLinks2XML(PartnerLinks partnerLinks) {
		if (!partnerLinks.getChildren().contains(bpel.getPartnerLinkBPEL())) {
			partnerLinks.getChildren().add(bpel.getPartnerLinkBPEL());
		}
		return super.partnerLinks2XML(partnerLinks);
	}

	protected Element extensionActivity2XML(ExtensionActivity activity) {

		if (activity instanceof DataSelectionUI) {
			return dealWithDataSelectionUI((DataSelectionUI) activity);
		} else if (activity instanceof DataOutputUI) {
			return dealWithDataOutputUI((DataOutputUI) activity);
		} else if (activity instanceof DataInputUI) {
			return dealWithDataInputUI((DataInputUI) activity);
		}

		return super.extensionActivity2XML(activity);
	}

	private Element dealWithDataOutputUI(DataOutputUI activity) {

		Sequence s = BPELFactory.eINSTANCE.createSequence();
		
		Variable[] vars = bpel.getVariableForDataInt(activity);
		
		Variable inputVar = vars[0];
		
		//String prefix = BPELUtils.getNamespacePrefix(inputVar, inputVar.getMessageType().getQName().getNamespaceURI())+":";
		//TODO when should I do it?
		String prefix = "";

		Assign assignbBefore = BPELFactory.eINSTANCE.createAssign();
		assignbBefore.setName("DataOutputConfiguration");
		
		Operation inputOperation = bpel.getOutputOperation();
		
		//================== Initialization =====================

		Copy initCopy = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		To t = createToPart(inputVar, inputOperation);
		createDefaultInitializer(null, f, t, activity.getOutputItem().size());
		initCopy.setFrom(f);
		initCopy.setTo(t);
		
		//================== ROLE =====================
		String role = activity.getRoles().size() > 1 ? activity.getRoles().get(0) : "roleDefault";

		Copy roleCopy = createCopyRole(inputVar, prefix, inputOperation, role);
		
		//================== ID =====================
		
		Copy idCoppy = createCopyId(activity.getId(), inputVar, prefix, inputOperation);
		
		//================== COPY DATA ITEM =====================
		int cont = 1;
		List<Copy> dataItemCopies = new LinkedList<Copy>();
		for (DataItem di : activity.getOutputItem()) {
			Part p = (Part) inputOperation.getInput().getMessage().getPart("parameters");
			Copy c = createDataItemBeforeCopy(inputVar, prefix, p, cont, di, "data", "data");
			dataItemCopies.add(c);
			cont++;
		}

		//================== Configuring the ASSIGN BEFORE =====================
		
		assignbBefore.getCopy().add(initCopy);
		assignbBefore.getCopy().add(roleCopy);
		assignbBefore.getCopy().add(idCoppy);
		assignbBefore.getCopy().addAll(dataItemCopies);
		
		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataOutput");
		i.setInputVariable(inputVar);
		i.setOperation(inputOperation);
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		
		//================== Configuring the SEQUENCE =====================
		s.getActivities().add(assignbBefore);
		s.getActivities().add(i);

		return super.sequence2XML(s);
	}

	private Copy createDataItemBeforeCopy(Variable inputVar, String prefix,
			Part p, int cont, DataItem di, String primaryNode, String secondaryNode) {
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		String expression = "$"+di.getVariable().getName();
		Expression fromExpr = BPELFactory.eINSTANCE.createExpression();
		f.setExpression(fromExpr);
		fromExpr.setBody(expression);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+primaryNode+"["+cont+"]/"+secondaryNode);
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		t.setPart(p);
		
		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	private To createToPart(Variable inputVar, Operation inputOperation) {
		To t = BPELFactory.eINSTANCE.createTo();
		t.setVariable(inputVar);
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		return t;
	}

	private Copy createCopyId(String id, Variable inputVar,
			String prefix, Operation inputOperation) {		
		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+id+"'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+"userInteracId");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		//FIXME Get the name from some other way or create a constant
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	private Copy createCopyRole(Variable inputVar, String prefix,
			Operation inputOperation, String role) {
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+role+"'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+"role");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		//FIXME Get the name from some other way or create a constant
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	private Element dealWithDataSelectionUI(DataSelectionUI activity) {
		Sequence s = BPELFactory.eINSTANCE.createSequence();
		
		Variable[] vars = bpel.getVariableForDataInt(activity);
		
		Variable inputVar = vars[0].getName().startsWith(BpelUIUtil.DATA_SELECTION_REQUEST) ? vars[0] : vars[1];
		Variable outputVar = vars[0].getName().startsWith(BpelUIUtil.DATA_SELECTION_REPONSE) ? vars[0] : vars[1];

		Assign assignBefore = BPELFactory.eINSTANCE.createAssign();
		assignBefore.setName("DataSelectionConfiguration");
		
		//String prefix = BPELUtils.getNamespacePrefix(inputVar, inputVar.getMessageType().getQName().getNamespaceURI())+":";
		//TODO when should i do it?
		String prefix = "";
		
		Operation inputOperation = bpel.getSelectionOperation();
		
		//================== Initialization =====================

		Copy initCopy = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		To t = createToPart(inputVar, inputOperation);
		createDefaultInitializer(null, f, t, activity.getInputItem().size());
		initCopy.setFrom(f);
		initCopy.setTo(t);
		assignBefore.getCopy().add(initCopy);
		
		//================== ROLE =====================
		String role = activity.getRoles().size() > 1 ? activity.getRoles().get(0) : "roleDefault";

		Copy roleCopy = createCopyRole(inputVar, prefix, inputOperation, role);
		assignBefore.getCopy().add(roleCopy);
		
		//================== ID =====================
		Copy idCoppy = createCopyId(activity.getId(), inputVar, prefix, inputOperation);
		assignBefore.getCopy().add(idCoppy);
		
		//================== COPY DATA ITEM =====================
		int cont = 1;
		List<Copy> dataItemCopiesBefore = new LinkedList<Copy>();
		for (DataItem di : activity.getInputItem()) {
			Part p = (Part) inputOperation.getInput().getMessage().getPart("parameters");
			Copy c = createDataItemBeforeCopy(inputVar, prefix, p, cont, di, "data", "data");
			dataItemCopiesBefore.add(c);
			cont++;
		}
		
		if (dataItemCopiesBefore.size() > 0)
			assignBefore.getCopy().addAll(dataItemCopiesBefore);

		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataSelection");
		i.setInputVariable(inputVar);
		i.setOutputVariable(outputVar);
		i.setOperation(inputOperation);
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		
		//================== COPY DATA ITEM =====================
		List<Copy> dataItemCopiesAfter = new LinkedList<Copy>();
		cont = 1;
		for (DataItem di : activity.getOutputItem()) {
			Part p = (Part) inputOperation.getOutput().getMessage().getPart("parameters");
			Copy c = createDataItemCopy(outputVar, prefix, p, cont, di, "return", "data");
			cont++;
			dataItemCopiesAfter.add(c);
		}
		
		s.getActivities().add(assignBefore);
		s.getActivities().add(i);
		
		if (dataItemCopiesAfter.size() > 0) {
			Assign after = BPELFactory.eINSTANCE.createAssign();
			after.setName("ResponseToDataItems");
			after.getCopy().addAll(dataItemCopiesAfter);
			s.getActivities().add(after);
		}

		return super.sequence2XML(s);
	}

	private Element dealWithDataInputUI(DataInputUI activity) {
		
		Sequence s = BPELFactory.eINSTANCE.createSequence();
		
		Variable[] vars = bpel.getVariableForDataInt(activity);
		
		Variable inputVar = vars[0].getName().startsWith(BpelUIUtil.DATA_INPUT_REQUEST) ? vars[0] : vars[1];
		Variable outputVar = vars[0].getName().startsWith(BpelUIUtil.DATA_INPUT_REPONSE) ? vars[0] : vars[1];
		
		//String prefix = BPELUtils.getNamespacePrefix(inputVar, inputVar.getMessageType().getQName().getNamespaceURI());
		//TODO when do I must to do it?
		//definition.getPrefix
		//Ask it from BpelUIUtil
		String prefix = "";

		Assign assignBefore = BPELFactory.eINSTANCE.createAssign();
		assignBefore.setName("DataInputConfiguration");
		
		Operation inputOperation = bpel.getInputOperation();
		
		//================== Initialization =====================

		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		To t = createToPart(inputVar, inputOperation);
		createDefaultInitializer(null, f, t, 0);
		c.setFrom(f);
		c.setTo(t);
		assignBefore.getCopy().add(c);
				
		//================== ROLE =====================
		String role = activity.getRoles().size() > 1 ? activity.getRoles().get(0) : "roleDefault";

		c = createCopyRole(inputVar, prefix, inputOperation, role);
		assignBefore.getCopy().add(c);
		
		//================== ID =====================
		
		Copy idCoppy = createCopyId(activity.getId(), inputVar, prefix, inputOperation);
		assignBefore.getCopy().add(idCoppy);

		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataInput");
		i.setInputVariable(inputVar);
		i.setOutputVariable(outputVar);
		i.setOperation(inputOperation);
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		
		//================== COPY DATA ITEM =====================
		List<Copy> copies = new LinkedList<Copy>();
		int cont = 1;
		for (DataItem di : activity.getInputItem()) {
			Part p = (Part) inputOperation.getOutput().getMessage().getPart("parameters");
			c = createDataItemCopy(outputVar, prefix, p, cont, di, "data", "data");
			cont++;
			copies.add(c);
		}
		
		//================== Configuring the SEQUENCE =====================
		s.getActivities().add(assignBefore);
		s.getActivities().add(i);
		
		if (copies.size() > 0) {
			Assign assignaAfter = BPELFactory.eINSTANCE.createAssign();
			assignaAfter.setName("ResponseToDataItems");
			assignaAfter.getCopy().addAll(copies);
			s.getActivities().add(assignaAfter);
		}

		return super.sequence2XML(s);
	}

	private Copy createDataItemCopy(Variable outputVar, String prefix,
			Part part, int cont, DataItem di, String primaryNode, String secondaryNode) {
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+primaryNode+"["+cont+"]/"+prefix+secondaryNode);
		f.setQuery(toQuery);
		f.setVariable(outputVar);
		f.setPart(part);

		To t = BPELFactory.eINSTANCE.createTo();
		t.setVariable(di.getVariable());
		
		c.setFrom(f);
		c.setTo(t);
		return c;
	}
	
	
	/**
	 * Construct an appropriate XML literal initializer for the given "from" and "to" parts
	 *  
	 * @param bpelEditor
	 * @param from
	 * @param to
	 * @return
	 */
	public static String createDefaultInitializer(BPELEditor bpelEditor, From from, To to, int dataItems) {
		String literal = EMPTY_STRING;
		if ( from!=null && to!=null) {
			literal = from.getLiteral();
			if (literal==null || literal.isEmpty()) {
				literal = createDefaultInitializer(bpelEditor, to.getVariable(), to.getPart(), dataItems);
				from.setLiteral(literal);
			}
		}
		return literal;
	}
	
	/**
	 * Construct an appropriate XML literal initializer for the given variable and message part.
	 *  
	 * @param bpelEditor
	 * @param var - the variable to be initialized
	 * @param part - if the variable is defined as a message, this is the message part
	 *               otherwise null
	 * @return - XML string representing an intializer for the given variable
     * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	 * @see https://jira.jboss.org/browse/JBIDE-7351
	 */
	public static String createDefaultInitializer(BPELEditor bpelEditor, Variable var, Part part, int dataItems) {
		String fromString = EMPTY_STRING;
		try {
			String rootElement = null;
			String uriWSDL = null;

			// Variable is defined using "messageType"
			Message msg = (Message)var.getMessageType();
			if (msg != null) {
				if (msg.eIsProxy()) {
					//FIXME it works???
					//msg = (Message)EmfModelQuery.resolveProxy(bpelEditor.getProcess(), msg);
				}
				if (part==null) {
					Map parts = msg.getParts();
					if (parts!=null && !parts.isEmpty()) {
						Map.Entry entry = (Map.Entry)parts.entrySet().iterator().next();
						part = (Part)entry.getValue();
					}
				}
				if (part!=null) {
					XSDElementDeclaration declaration = part.getElementDeclaration();
					if (declaration != null) {
						uriWSDL = declaration.getSchema().getSchemaLocation();
						rootElement = declaration.getName();
					}
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
		}
		catch (Exception e) {
		}
		//fromString = fromString.replaceAll("", "");
		
		//TODO this regex is just to String type
		//this code replace the any xsi:type="anyType" by the representation of string
		//HEAD_STRING+ "Data" +tail
		String finalSt = fromString;
		Pattern pattern = Pattern.compile("<[a-zA-Z]*:?data>.*</[a-zA-Z]*:?data>", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(fromString);
		if (matcher.find()){
			String myShit = matcher.group();
			String tail = ("</"+ myShit.split("data")[1].replaceAll("\\s|<|>|"+NL, "") + "data>").trim();
			String head = myShit.replaceAll("xsi:type=\"anyType\"/>", HEAD_STRING+ "Data" +tail);
			
			String body = "";
			
			for (int i = 0; i < dataItems; i++) {
				body += head;
			}
			
			finalSt = pattern.split(fromString)[0] + body + pattern.split(fromString)[1];
		}
		return finalSt;
	}
}
