package be.ac.fundp.precise.ui_bpel.ui.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.ui.util.WSDLImportHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Import;
import org.eclipse.wst.wsdl.WSDLFactory;
import org.eclipse.wst.wsdl.WSDLPackage;

// TODO: Auto-generated Javadoc
/**
 * The Class WSDLImportHelperUI.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class WSDLImportHelperUI extends WSDLImportHelper{
	
	/** The Constant WSDL_PREFIX_KIND. */
	public static final String WSDL_PREFIX_KIND = "wsdl";
	
	/** The Constant XMLNS_XSD. */
	public static final String XMLNS_XSD = "http://www.w3.org/2001/XMLSchema";

	/**
	 * Adds the tooling namespaces.
	 *
	 * @param definition the definition
	 */
	public static void addToolingNamespaces(Definition definition) {
		WSDLImportHelper.addToolingNamespaces(definition);
		addNamespace(definition, XMLNS_XSD, "xsd");

//		if (getEnclosingDefinition().getPrefix(MessagepropertiesConstants.NAMESPACE) == null) {
		//	getEnclosingDefinition().addNamespace(MessagepropertiesPackage.eNS_PREFIX, MessagepropertiesConstants.NAMESPACE);
		// }
//		if (definition.getNamespace(PartnerlinktypePackage.eNS_PREFIX) == null) {
		// definition.addNamespace(PartnerlinktypePackage.eNS_PREFIX,
		// PartnerlinktypePackage.eNS_URI);
		// }
//		if (definition.getNamespace(MessagepropertiesPackage.eNS_PREFIX) == null) {
		// definition.addNamespace(MessagepropertiesPackage.eNS_PREFIX,
		// MessagepropertiesPackage.eNS_URI);
		// }
	}
	
	/**
	 * Adds the import and namespace.
	 *
	 * @param definition the definition
	 * @param importedDefinition the imported definition
	 */
	public static void addImportAndNamespace(Definition definition, Definition importedDefinition)
	{
		if (importedDefinition == null || definition == null) return;
		if (definition == importedDefinition)  return;

		String namespace = importedDefinition.getTargetNamespace();
		// TODO LOGTHIS: need better error handling here!
		if (namespace == null)  return;

		addNamespace(definition, namespace, WSDL_PREFIX_KIND);
		addImport(namespace, definition, definition.eResource().getURI(), importedDefinition,
			importedDefinition.eResource().getURI());
	}
	
	/**
	 * Adds the import.
	 *
	 * @param namespace the namespace
	 * @param importingDefinition the importing definition
	 * @param importingUri the importing uri
	 * @param importedDefinition the imported definition
	 * @param importedUri the imported uri
	 */
	protected static void addImport(String namespace, Definition importingDefinition,
		URI importingUri, Definition importedDefinition, URI importedUri) {
		WSDLFactory wsdlFactory = WSDLPackage.eINSTANCE.getWSDLFactory();
		List<Import> imports = importingDefinition.getImports(namespace);
		if (imports == null) {
			imports = new ArrayList<Import>();
		}
		boolean found = false;
		for (int i = 0; i < imports.size() && !found; i++) {
			Import _import = imports.get(i);
			if (_import.getEDefinition() == importedDefinition) {
				found = true;
			}
		}
		if (!found) {
			String locationURI = createBuildPathRelativeReference(importingUri, importedUri);

			if (locationURI != null && locationURI.length() != 0) {
				// Create and add the import to the definition
				Import _import = wsdlFactory.createImport();
				_import.setEDefinition(importedDefinition);
				_import.setLocationURI(locationURI);
				_import.setNamespaceURI(namespace);
				importingDefinition.addImport(_import);
			} else {
				// TODO handle errors here?
				throw new IllegalStateException();
			}
		}
	}
	
	/**
	 * Creates the build path relative reference.
	 *
	 * @param sourceURI the source uri
	 * @param targetURI the target uri
	 * @return the string
	 */
	public static String createBuildPathRelativeReference(URI sourceURI, URI targetURI) {
		if (sourceURI == null || targetURI == null)
			throw new IllegalArgumentException();

		// BaseURI source = new BaseURI(sourceURI);
		// return source.getRelativeURI(targetURI);
		// TODO: this is probably bogus.
		if (targetURI.isFile()) {
			return targetURI.toString();
		}
		String result = targetURI.deresolve(sourceURI, true, true, true).toFileString();
		// When absolute URLs
		return (result == null ? targetURI.toString() : result);
	}

}
