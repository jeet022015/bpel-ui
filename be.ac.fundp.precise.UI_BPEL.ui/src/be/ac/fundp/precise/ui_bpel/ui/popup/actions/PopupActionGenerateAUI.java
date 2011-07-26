package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.bpel.model.Process;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
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
		m.put("aui", new XMIResourceFactoryImpl());
		
		IFile f = getBpelFile();
		IFolder folder = (IFolder) f.getParent();
		IFile file = folder.getFile("AUI_Model.aui");
		try {
			if (!file.exists()) {
				byte[] bytes = "".getBytes();
			    InputStream source = new ByteArrayInputStream(bytes);
			    file.create(source, IResource.NONE, null);
			}
			IPath fullProcessPath = file.getFullPath();
			URI uri = URI.createPlatformResourceURI(fullProcessPath.toString(), false);
			Resource auiResource = getResourceSet().createResource(uri);
			
			auiResource.getContents().clear();
			auiResource.getContents().add(model);
	
			// Now save the content.
			auiResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}