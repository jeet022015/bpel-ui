package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

import be.ac.fundp.precise.ui_bpel.ui.Activator;

/**
 * This class manage the creation of the files to derive a executable
 * process.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class ExecutableBpelFileManager {
	
	private static final String USER_EVENT_LISTENER_WSDL = "UserEventListener.wsdl";

	private static final String UI_MANAGER_WSDL = "UiManager.wsdl";

	/** The base folder. */
	protected IFolder baseFolder;
	
	/** The process folder. */
	protected IFolder processFolder;
	
	/** The default file name. */
	protected String newFileName = "UIBPEL_Process.bpel";
	
	/**
	 * Instantiates a new wsdl file manager.
	 *
	 * @param folder the folder
	 * @throws CoreException the core exception
	 */
	public ExecutableBpelFileManager (IFolder folder) throws CoreException{
		IFolder coordFolder = folder.getFolder("executable-artifacts");
		NullProgressMonitor progressMonitor = new NullProgressMonitor();
		if (coordFolder.exists()){
			for (IResource content : coordFolder.members()) {
				content.delete(IResource.FOLDER, progressMonitor);
			}
			coordFolder.refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);
		}else{
			coordFolder.create(true, true, progressMonitor);
		}
		baseFolder = coordFolder;
		processFolder = folder;
	}
	
	/**
	 * Gets the path to the new ui manager WSDL.
	 *
	 * @return the ui manager path
	 */
	public String getUiManagerPath(){
		IFile file = baseFolder.getFile(UI_MANAGER_WSDL);
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
	
	/**
	 * Gets the path to the new user event listenner WSDL.
	 *
	 * @return the user event listener path
	 */
	public String getUserEventListenerPath(){
		IFile file = baseFolder.getFile(USER_EVENT_LISTENER_WSDL);
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

	/**
	 * Copy wsdl manager from plugin.
	 *
	 * @param file the file
	 * @param pathWSDL the path wsdl
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws CoreException the core exception
	 */
	private void copyWsdlManagerFromPlugin(IFile file, String pathWSDL) throws IOException, CoreException {
		InputStream inputStream = FileLocator.openStream(
			    Activator.getDefault().getBundle(), new Path(pathWSDL), false);
		file.create(inputStream, true, null);
		
	}

	/**
	 * Gets the copy process wsd ls.
	 *
	 * @param location the location
	 * @return the copy process wsd ls
	 * @throws CoreException the core exception
	 */
	public void getCopyProcessWSDLs(String location) throws CoreException {
		
		//TODO fix it, these locations cannot appear in the process.
		if (location.equals(UI_MANAGER_WSDL) || location.equals(USER_EVENT_LISTENER_WSDL) ){
			return;
		}
		
		IFile originalWsdlFile = processFolder.getFile(location);
		IFile newWsdlFile = baseFolder.getFile(location);
		newWsdlFile.create(originalWsdlFile.getContents(), true, null);
	}

	/**
	 * Gets the path of a wsdl in the directory where the files will be 
	 * generated.
	 *
	 * @param location the location
	 * @return the wsdl path
	 */
	public String getWsdlPath(String location) {
		newFileName = location;
		IFile processFile = baseFolder.getFile(location);
		return processFile.getFullPath().toString();
	}

	/**
	 * Gets the output stream the the executable BPEL process.
	 *
	 * @return the output stream
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public OutputStream getOutputStream() throws IOException {
		ExtensibleURIConverterImpl converter = new ExtensibleURIConverterImpl();
		IFile file = baseFolder.getFile("UIBPEL_Process.bpel");
		IPath fullProcessPath = file.getFullPath();
		URI uri = URI.createPlatformResourceURI(fullProcessPath.toString(), false);
		return new BufferedOutputStream(converter.createOutputStream(uri));
	}

}
