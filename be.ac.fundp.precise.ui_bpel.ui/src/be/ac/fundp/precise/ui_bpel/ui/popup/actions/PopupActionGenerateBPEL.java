package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
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
			IFile f = getBpelFile();
			
			IProgressMonitor progressMonitor = new NullProgressMonitor();
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			
			IProject project = f.getProject();
			IProject newProject = root.getProject(project.getName()+"-executable"+projectCounter++);
			if (!newProject.exists())
				newProject.create(progressMonitor);
			newProject.open(progressMonitor);
			IFolder folder = newProject.getFolder("bpelContent");
			if (!folder.exists()){
				folder.create(true, true, progressMonitor);
			} else {
				for (IResource content : folder.members()) {
					content.delete(IResource.FOLDER, progressMonitor);
				}
				folder.refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);
			}
			folder.refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);
			
			IProjectDescription description = project.getDescription();
			newProject.setDescription(description, progressMonitor);
			
			newWriter = new WriterUiBpel(process, f, folder);
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