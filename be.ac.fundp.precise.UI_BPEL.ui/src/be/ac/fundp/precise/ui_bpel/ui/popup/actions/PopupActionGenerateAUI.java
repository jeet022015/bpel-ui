package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.bpel.model.Process;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionDelegate;
import org.usixml.aui.auiPackage.AbstractUIModel;

import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.AUIGenerator;

public class PopupActionGenerateAUI extends PopupActionWithProcessRepresentation {
	
	private AUIGenerator auiGen = new AUIGenerator();

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {

		// load BPEL,WSDL,XSDs
		Process process = loadBPEL();

		createAuiModel(process);

		MessageDialog.openInformation(getShell(), "BPEL Extensions UI Sample Plug-in",
				"Generated AUI for the Process: " + process.getName());
	}

	private void createAuiModel(Process process) {
		
		AbstractUIModel model = auiGen.createAUI(process);
		
		// Register the XMI resource factory for the .website extension
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("model", new XMIResourceFactoryImpl());

		// Create a resource
		String path = getBpelFile().getParent().getFullPath().toOSString()+IPath.SEPARATOR+"AUI.model";
		Resource resource = getResourceSet().createResource(URI
				.createURI("platform:/resource"+path));

		resource.getContents().add(model);

		// Now save the content.
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}