package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionDelegate;

import be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.WriterUiBpel;

/**
 * This class implements the pop-up action to generate the executable BPEL
 *  from the UI-BPEL model.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class PopupActionGenerateBPEL extends PopupActionWithProcessRepresentation {

	/** The new writer. */
	private WriterUiBpel newWriter;
	
	protected int projectCounter = 1;
	
	/**
	 * This Method perform the actions to generate the executable process.
	 *
	 * @param action Eclipse IAction
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		
		// load BPEL,WSDL,XSDs
		Process process = loadBPEL();
		try {
			//TODO It should not be here.
			IFile f = getBpelFile();
			newWriter = new WriterUiBpel(process, f);
			newWriter.write((BPELResource) getBpelResource(), Collections.<String,String>emptyMap());
			
			MessageDialog.openInformation(getShell(), "BPEL Extensions UI Sample Plug-in",
					"Generated Executable BPEL for the Process: " + process.getName());
		} catch (IOException e) {
			MessageDialog.openInformation(getShell(), "BPEL Extensions UI Sample Plug-in",
					"The generation was interrupted by a " + e.getMessage() + ". Try restart the Eclipse application.");
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}