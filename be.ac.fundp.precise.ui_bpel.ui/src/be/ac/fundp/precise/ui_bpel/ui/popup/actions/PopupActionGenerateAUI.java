package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.eclipse.bpel.model.Process;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionDelegate;

import be.ac.fundp.precise.ui_bpel.transformation.aui.AUIGenerator;

/**
 * This class implements the popup action to generate the AUI from the UI-BPEL
 * model.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class PopupActionGenerateAUI extends PopupActionWithProcessRepresentation {
	
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
		try {
			AUIGenerator auiGen = new AUIGenerator(folder, process);
			auiGen.saveModels();
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