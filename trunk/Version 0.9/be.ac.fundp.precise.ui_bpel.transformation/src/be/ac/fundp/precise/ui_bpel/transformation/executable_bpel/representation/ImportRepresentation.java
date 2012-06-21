package be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.representation;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Import;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.util.WSDLConstants;

import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.util.WSDLImportHelperUI;
/**
 * The Class ImportRepresentation.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class ImportRepresentation {
	
	/** The import bpel. */
	private Import importBPEL;
	
	/** The my wsdl. */
	private Definition myWsdl;
	
	/**
	 * Instantiates a new import representation.
	 *
	 * @param myWsdl the my wsdl
	 * @param processWSDl the process ws dl
	 * @param processResource the process resource
	 */
	public ImportRepresentation(Definition myWsdl, Definition processWSDl, Resource processResource){
		this.myWsdl = myWsdl;
		importBPEL = createImportInProcess(processResource);
		if (!processWSDl.getImports().keySet().contains(myWsdl.getTargetNamespace()))
			WSDLImportHelperUI.addImportAndNamespace(processWSDl, myWsdl);
	}

	/**
	 * Creates the import in process.
	 *
	 * @param resource the resource
	 * @return the import
	 */
	private Import createImportInProcess(Resource resource) {

		Import imp = BPELFactory.eINSTANCE.createImport();

		// namespace
		String t = myWsdl.getTargetNamespace();
		if (t != null) {
			imp.setNamespace(t);
		}
		
		// location
		URI schemaURI = URI.createPlatformPluginURI(myWsdl.getLocation(), true);
		imp.setLocation(schemaURI.lastSegment());
		imp.setImportType(WSDLConstants.WSDL_NAMESPACE_URI);

		return imp;
	}

	/**
	 * Gets the import.
	 *
	 * @return the import
	 */
	public Import getImport() {
		return importBPEL;
	}
}