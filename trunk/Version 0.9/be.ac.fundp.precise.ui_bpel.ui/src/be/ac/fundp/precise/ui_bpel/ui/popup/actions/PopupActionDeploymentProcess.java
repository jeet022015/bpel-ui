package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.IOException;

import org.eclipse.bpel.model.Process;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;

import be.ac.fundp.precise.ui_bpel.transformations.bpel.BPEL_Transformator;
import be.ac.fundp.precise.ui_bpel.webclient.deployment.ConfigurationException;
import be.ac.fundp.precise.ui_bpel.webclient.deployment.DeploymentManager;

/**
 * This class implements the popup action to generate the AUI from the UI-BPEL
 * model.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class PopupActionDeploymentProcess extends PopupActionWithProcessRepresentation {

	private IFolder homeFolder;

	@Override
	public void run(IAction action) {
		homeFolder = (IFolder)getBpelFile().getParent();
		Process process = loadBPEL();
		IProgressMonitor progressMonitor = new NullProgressMonitor();
		
		DeploymentManager deployer;
		try {
			IFolder folder = homeFolder.getFolder("deployer");
			if (!folder.exists()){
				folder.create(true, true, progressMonitor);
			}
//			else {
//				for (IResource content : folder.members()) {
//					content.delete(IResource.FOLDER, progressMonitor);
//				}
//			}
			folder.refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);
			IFile f = getBpelFile();
			BPEL_Transformator bpelTrans = new BPEL_Transformator(f.getRawLocation().toOSString());
			bpelTrans.transform(folder.getRawLocation().toFile());
			deployer = new DeploymentManager(folder.getRawLocation().toFile());
			//IFolder deploymentFolder = deployer.setup();
//			WriterUiBpel newWriter = new WriterUiBpel(process, getBpelFile(), deploymentFolder);
//			newWriter.write((BPELResource) getBpelResource(), Collections.<String,String>emptyMap());
			deployer.createZipFile(folder.getRawLocation().toFile());
			deployer.deploy();
			MessageDialog.openInformation(getShell(), "BPEL Extensions UI Plug-in",
					"The process " + process.getName()+" was well deployed.");
		} catch (ConfigurationException e) {
			MessageDialog.openInformation(getShell(), "ERROR: BPEL Extensions UI Plug-in",
					e.getMessage());
		} catch (CoreException e) {
			MessageDialog.openInformation(getShell(), "ERROR: BPEL Extensions UI Plug-in",
					e.getMessage());
		} catch (IOException e) {
			MessageDialog.openInformation(getShell(), "ERROR: BPEL Extensions UI Plug-in",
					e.getMessage());
		}
		
	}
}