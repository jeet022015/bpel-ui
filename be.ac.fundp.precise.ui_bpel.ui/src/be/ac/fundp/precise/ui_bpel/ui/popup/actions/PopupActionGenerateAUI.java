package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.AUIGenerator;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.AbstractUIModel;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.XML_Engine;

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
		IFile mediatorFile = folder.getFile("UI-AUIC_Mapping.xml");
		try {
			IPath fullProcessPath = mediatorFile.getFullPath();
			URI uri2 = URI.createPlatformResourceURI(fullProcessPath.toString(), false);
			OutputStream out2 = new BufferedOutputStream(converter.createOutputStream(uri2));
			
			AUIGenerator auiGen = new AUIGenerator(out2);
			Map<String, AbstractUIModel> model = auiGen.createAUI(process);
			
			for (String role : model.keySet()) {
				IFile roleAuiFile = folder.getFile("AUI_Model-"+role+".aui");
				IPath fullAuiFilePath = roleAuiFile.getFullPath();
				URI auiFileUri = URI.createPlatformResourceURI(fullAuiFilePath.toString(), false);
				
				OutputStream out3 = new BufferedOutputStream(converter.createOutputStream(auiFileUri));
				
				AbstractUIModel roleModel = model.get(role);
				XML_Engine engine = new XML_Engine();
				engine.serialize(roleModel, out3);
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