package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELResource;
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

//		if (process != null) {
//			EList<Import> imports = process.getImports();
//			Iterator<Import> importIterator = imports.iterator();
//			while (importIterator.hasNext()) {
//				Import current = importIterator.next();
//				String relPath = current.getLocation();
//			}
//		}

		try {
			//String path = bpelFile.getParent().getFullPath().toOSString()+IPath.SEPARATOR+"newBPEL.test";
			String path ="/Users/Neto/Documents/runtime-EclipseApplication/NewUiBpel/bpelContent/newBPEL.test";
			//File f = bpelFile.getFullPath().toFile();
			//File f = new File (path);
			OutputStream out = new BufferedOutputStream( new FileOutputStream(path));
			Map<?, ?> args =  new HashMap();
			newWriter.write((BPELResource) getBpelFile(), out, args);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//createAuiModel(process);

		MessageDialog.openInformation(getShell(), "BPEL Extensions UI Sample Plug-in",
				"Generated AUI for the Process: " + process.getName());
	}

}