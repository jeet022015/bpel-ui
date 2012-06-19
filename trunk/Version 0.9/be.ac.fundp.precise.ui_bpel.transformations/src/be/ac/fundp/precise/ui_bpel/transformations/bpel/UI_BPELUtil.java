package be.ac.fundp.precise.ui_bpel.transformations.bpel;

import org.eclipse.bpel.model.resource.BPELResourceSetImpl;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.wst.wsdl.Definition;

public class UI_BPELUtil {

	private static final String WSLD_NAME = "wsdl";

	public static Definition attemptLoadWSDL(URI uri, ResourceSet resourceSet) {
		Resource resource = null;
		BPELResourceSetImpl fHackedResourceSet = BPELUtils
				.slightlyHackedResourceSet(resourceSet);
		resource = fHackedResourceSet.getResource(uri, true, WSLD_NAME);

		// Bugzilla 324164
		if (resource != null && resource.getErrors().isEmpty()
				&& resource.isLoaded()) {
			return (Definition) resource.getContents().get(0);
		}
		return null;
	}
}
