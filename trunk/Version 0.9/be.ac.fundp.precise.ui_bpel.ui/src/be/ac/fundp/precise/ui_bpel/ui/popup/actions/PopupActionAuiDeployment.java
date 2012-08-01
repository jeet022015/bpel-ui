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

import be.ac.fundp.precise.ui_bpel.transformation.aui.AUIGenerator;
import be.ac.fundp.precise.ui_bpel.webclient.deployment.AuiDeploymentManager;

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

		try {
			createAuiModel(process);
		} catch (IOException e) {
			MessageDialog.openInformation(getShell(), "BPEL Extensions UI Plug-in",
					"ERROR: " + e.getMessage());
			e.printStackTrace();
			return;
		} catch (ParserConfigurationException e) {
			MessageDialog.openInformation(getShell(), "BPEL Extensions UI Plug-in",
					"ERROR: " + e.getMessage());
			e.printStackTrace();
			return;
		} catch (TransformerException e) {
			MessageDialog.openInformation(getShell(), "BPEL Extensions UI Plug-in",
					"ERROR: " + e.getMessage());
			e.printStackTrace();
			return;
		} catch (CoreException e) {
			MessageDialog.openInformation(getShell(), "BPEL Extensions UI Plug-in",
					"ERROR: " + e.getMessage());
			e.printStackTrace();
			return;
		}

		MessageDialog.openInformation(getShell(), "BPEL Extensions UI Plug-in",
				"Generated AUI for the Process: " + process.getName());
	}

	/**
	 * Creates the aui model.
	 *
	 * @param process the process
	 * @throws CoreException 
	 * @throws TransformerException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 */
	private void createAuiModel(Process process) throws IOException, ParserConfigurationException, TransformerException, CoreException {
		
		IFile f = getBpelFile();
		IFolder folder = (IFolder) f.getParent();
		IProject project = f.getProject();
		AUIGenerator auiGen = new AUIGenerator(folder, process);
		Map<String, File> path = auiGen.saveModels();
		
		AuiDeploymentManager aui = new AuiDeploymentManager(project.getName(), path, auiGen.getConf().getRolesMap());
		aui.deploy();
		
	}
}