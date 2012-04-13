package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.IOException;
import java.util.Collections;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.xml.sax.SAXException;

import be.ac.fundp.precise.ui_bpel.ui.transformation.deployment.ConfigurationException;
import be.ac.fundp.precise.ui_bpel.ui.transformation.deployment.DeploymentManager;
import be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.WriterUiBpel;

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
		//Check files
		//Transform the UI-BPEL in BPEL
		//Put everything in a auxiliary folder
		//Deploy test
		homeFolder = (IFolder)getBpelFile().getParent();
		Process process = loadBPEL();
		
		DeploymentManager deployer;
		try {
			deployer = new DeploymentManager(homeFolder, getShell());
			IFolder deploymentFolder = deployer.setup();
			WriterUiBpel newWriter = new WriterUiBpel(process, getBpelFile(), deploymentFolder);
			newWriter.write((BPELResource) getBpelResource(), Collections.<String,String>emptyMap());
			deployer.createZipFile();
			deployer.deploy();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}
}