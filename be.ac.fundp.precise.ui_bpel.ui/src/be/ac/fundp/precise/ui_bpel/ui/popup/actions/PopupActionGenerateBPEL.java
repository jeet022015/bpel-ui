package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionDelegate;

import be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.WriterUiBpel;

public class PopupActionGenerateBPEL extends PopupActionWithProcessRepresentation {

	private WriterUiBpel newWriter;
	private ExtensibleURIConverterImpl converter;
	
	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		
		converter = new ExtensibleURIConverterImpl();

		// load BPEL,WSDL,XSDs
		Process process = loadBPEL();
		newWriter = new WriterUiBpel(process, getBpelFile());

		try {
			IFile f = getBpelFile();
			IFolder folder = (IFolder) f.getParent();
			IFile file = folder.getFile("UIBPEL_Process.bpel");
			IPath fullProcessPath = file.getFullPath();
			URI uri = URI.createPlatformResourceURI(fullProcessPath.toString(), false);
			OutputStream out = new BufferedOutputStream(converter.createOutputStream(uri));
			newWriter.write((BPELResource) getBpelResource(), out, null);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		MessageDialog.openInformation(getShell(), "BPEL Extensions UI Sample Plug-in",
				"Generated Executable BPEL for the Process: " + process.getName());
	}

}