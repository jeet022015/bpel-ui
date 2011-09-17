package be.ac.fundp.precise.ui_bpel.ui.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.ui.util.WSDLImportHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Import;
import org.eclipse.wst.wsdl.WSDLFactory;
import org.eclipse.wst.wsdl.WSDLPackage;

public class WSDLImportHelperUI extends WSDLImportHelper{
	
	public static final String WSDL_PREFIX_KIND = "wsdl";

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
	
	protected static void addImport(String namespace, Definition importingDefinition,
		URI importingUri, Definition importedDefinition, URI importedUri) {
		System.out.println("importedUri1: "+importedUri);
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
			System.out.println("locationURI1: "+locationURI);

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
