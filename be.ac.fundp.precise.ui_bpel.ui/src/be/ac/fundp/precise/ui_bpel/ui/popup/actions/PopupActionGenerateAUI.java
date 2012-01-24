package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.eclipse.bpel.model.Process;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionDelegate;

import auiPackage.AbstractUIModel;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.AUIGenerator;

/**
 * This class implements the popup action to generate the AUI from the UI-BPEL
 * model.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class PopupActionGenerateAUI extends PopupActionWithProcessRepresentation {
	
	/** The converter. */
	private ExtensibleURIConverterImpl converter;
	
	/**
	 * Run.
	 *
	 * @param action the action
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {

		converter = new ExtensibleURIConverterImpl();
		
		// load BPEL,WSDL,XSDs
		Process process = loadBPEL();

		createAuiModel(process);

		MessageDialog.openInformation(getShell(), "BPEL Extensions UI Sample Plug-in",
				"Generated AUI for the Process: " + process.getName());
	}

	/**
	 * Creates the aui model.
	 *
	 * @param process the process
	 */
	private void createAuiModel(Process process) {
		
		// Register the XMI resource factory for the .website extension
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("aui", new XMIResourceFactoryImpl());
		
		IFile f = getBpelFile();
		IFolder folder = (IFolder) f.getParent();
		//IFile auiFile = folder.getFile("AUI_Model.aui");
		IFile mediatorFile = folder.getFile("UI-AUIC_Mapping.xml");
		try {
			//IPath fullProcessPath = auiFile.getFullPath();
			//URI uri = URI.createPlatformResourceURI(fullProcessPath.toString(), false);
			//OutputStream out1 = new BufferedOutputStream(converter.createOutputStream(uri));
			
			
			IPath fullProcessPath = mediatorFile.getFullPath();
			URI uri2 = URI.createPlatformResourceURI(fullProcessPath.toString(), false);
			OutputStream out2 = new BufferedOutputStream(converter.createOutputStream(uri2));
			
			//File realFile = mediatorFile.getLocation().toFile();
			//OutputStream out = new BufferedOutputStream( new FileOutputStream(realFile));
			AUIGenerator auiGen = new AUIGenerator(out2);
			Map<String, AbstractUIModel> model = auiGen.createAUI(process);
			
			//IPath fullProcessPath = auiFile.getFullPath();
			//URI uri = URI.createPlatformResourceURI(fullProcessPath.toString(), false);
			for (String role : model.keySet()) {
				IFile roleAuiFile = folder.getFile("AUI_Model-"+role+".aui");
				IPath fullAuiFilePath = roleAuiFile.getFullPath();
				URI auiFileUri = URI.createPlatformResourceURI(fullAuiFilePath.toString(), false);
				Resource auiResource = getResourceSet().createResource(auiFileUri);
				
				auiResource.getContents().clear();
				auiResource.getContents().add(model.get(role));
		
				// Now save the content.
				auiResource.save(Collections.EMPTY_MAP);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}