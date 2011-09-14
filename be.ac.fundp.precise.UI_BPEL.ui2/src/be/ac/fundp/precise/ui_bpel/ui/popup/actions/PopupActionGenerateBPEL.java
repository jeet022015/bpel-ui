package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionDelegate;

import be.ac.fundp.precise.ui_bpel.ui.transformation.executBPEL.WriterUiBpel;

public class PopupActionGenerateBPEL extends PopupActionWithProcessRepresentation {

	private WriterUiBpel newWriter;
	
	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {

		// load BPEL,WSDL,XSDs
		Process process = loadBPEL();
		newWriter = new WriterUiBpel(process);

		try {
			IFile f = getBpelFile();
			IFolder folder = (IFolder) f.getParent();
			IFile file = folder.getFile("UIBPEL_Process.bpel");
			if (!file.exists()) {
				byte[] bytes = "".getBytes();
			    InputStream source = new ByteArrayInputStream(bytes);
			    file.create(source, IResource.NONE, null);
			}
			File realFile = file.getLocation().toFile();
			OutputStream out = new BufferedOutputStream( new FileOutputStream(realFile));
			//Map<?, ?> args =  new HashMap();
			//newWriter.write((BPELResource) getBpelResource(), out, args);
			newWriter.write((BPELResource) getBpelResource(), out, null);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}

		MessageDialog.openInformation(getShell(), "BPEL Extensions UI Sample Plug-in",
				"Generated Executable BPEL for the Process: " + process.getName());
	}

}