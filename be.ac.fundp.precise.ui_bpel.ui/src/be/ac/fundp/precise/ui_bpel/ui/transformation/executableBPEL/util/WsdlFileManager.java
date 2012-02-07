package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.util;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;

import be.ac.fundp.precise.ui_bpel.ui.Activator;

public class WsdlFileManager {
	
	protected IFolder baseFolder;
	
	public WsdlFileManager (IFolder folder){
		baseFolder = folder;
	}
	
	public String getUiManagerPath(){
		IFile file = baseFolder.getFile("UiManager.wsdl");
		if (!file.exists()){
			try {
				copyWsdlManagerFromPlugin(file, "wsdl/UiManager.wsdl");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return file.getFullPath().toString();
	}
	
	public String getUserEventListenerPath(){
		IFile file = baseFolder.getFile("UserEventListener.wsdl");
		if (!file.exists()){
			try {
				copyWsdlManagerFromPlugin(file, "wsdl/UserEventListener.wsdl");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return file.getFullPath().toString();
	}

	private void copyWsdlManagerFromPlugin(IFile file, String pathWSDL) throws IOException, CoreException {
		InputStream inputStream = FileLocator.openStream(
			    Activator.getDefault().getBundle(), new Path(pathWSDL), false);
		file.create(inputStream, true, null);
//		DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file.getFullPath().toString())));
//		int c;
//		while((c = inputStream.read()) != -1) {
//			outputStream.writeByte(c);
//		}
//		inputStream.close();
//		outputStream.close();
		
	}

}
