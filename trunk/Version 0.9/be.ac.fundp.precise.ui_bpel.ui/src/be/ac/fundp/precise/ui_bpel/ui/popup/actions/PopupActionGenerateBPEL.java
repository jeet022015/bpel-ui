package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import org.eclipse.bpel.model.Process;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionDelegate;

import be.ac.fundp.precise.ui_bpel.transformations.bpel.BPEL_Transformator;

/**
 * This class implements the pop-up action to generate the executable BPEL
 *  from the UI-BPEL model.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class PopupActionGenerateBPEL extends PopupActionWithProcessRepresentation {

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
			IProject newProject = root.getProject(project.getName()+"-executable");
			if (!newProject.exists())
				newProject.create(progressMonitor);
			else {
				newProject.delete(true, progressMonitor);
				newProject.create(progressMonitor);
			}
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
			
			IProjectDescription description = project.getDescription();
			newProject.setDescription(description, progressMonitor);
			
			BPEL_Transformator bpelTrans = new BPEL_Transformator(f.getRawLocation().toOSString());
			bpelTrans.transform(folder.getRawLocation().toFile());
			
			newProject.refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);

			MessageDialog.openInformation(getShell(), "BPEL Extensions UI Plug-in",
					"Generated Executable BPEL for the Process: " + process.getName());
		} catch (Exception e) {
			MessageDialog.openInformation(getShell(), "BPEL Extensions UI Plug-in",
					"The generation was interrupted by a " + e.getMessage() + ". Try restart the Eclipse application.");
			e.printStackTrace();
		}
	}

}