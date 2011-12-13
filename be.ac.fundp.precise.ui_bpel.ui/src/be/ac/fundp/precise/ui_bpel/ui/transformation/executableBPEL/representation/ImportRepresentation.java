package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.representation;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Import;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.util.WSDLConstants;

import be.ac.fundp.precise.ui_bpel.ui.util.WSDLImportHelperUI;

// TODO: Auto-generated Javadoc
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
		URI schemaURI = URI.createURI(myWsdl.getLocation());
		imp.setLocation(schemaURI
				.deresolve(resource.getURI(), true, true, true).toString());

		// importType (the WSDL kind)
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
