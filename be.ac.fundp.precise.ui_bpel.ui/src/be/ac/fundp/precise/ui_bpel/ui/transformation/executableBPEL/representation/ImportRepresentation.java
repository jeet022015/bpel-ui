package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.representation;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Import;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.util.WSDLConstants;

import be.ac.fundp.precise.ui_bpel.ui.util.WSDLImportHelperUI;

public class ImportRepresentation {
	
	private Import importBPEL;
	private Definition myWsdl;
	
	public ImportRepresentation(Definition myWsdl, Definition processWSDl, Resource processResource){
		this.myWsdl = myWsdl;
		importBPEL = createImportInProcess(processResource);
		WSDLImportHelperUI.addImportAndNamespace(processWSDl, myWsdl);
	}

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

	public Import getImport() {
		return importBPEL;
	}
}
