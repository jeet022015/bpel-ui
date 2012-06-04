package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.eclipse.bpel.model.Process;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.wst.wsdl.internal.impl.wsdl4j.WSDLReaderImpl;

import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.AUIGenerator;
import be.ac.fundp.precise.ui_bpel.ui.transformation.deployment.AuiDeploymentManager;

/**
 * This class implements the popup action to generate the AUI from the UI-BPEL
 * model.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class PopupActionAuiDeployment extends PopupActionWithProcessRepresentation {

	/**
	 * Run.
	 *
	 * @param action the action
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {

		// load BPEL,WSDL,XSDs
		Process process = loadBPEL();

		createAuiModel(process);

		MessageDialog.openInformation(getShell(), "BPEL Extensions UI Plug-in",
				"Generated AUI for the Process: " + process.getName());
	}

	/**
	 * Creates the aui model.
	 *
	 * @param process the process
	 */
	private void createAuiModel(Process process) {
		
		IFile f = getBpelFile();
		IFolder folder = (IFolder) f.getParent();
		IProject project = f.getProject();
		try {
			AUIGenerator auiGen = new AUIGenerator(folder, process);
			Map<String, File> path = auiGen.saveModels();
			
			AuiDeploymentManager aui = new AuiDeploymentManager(project.getName(), path, auiGen.getConf());
			aui.deploy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
	}
}