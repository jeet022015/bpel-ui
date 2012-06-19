package be.ac.fundp.precise.ui_bpel.transformations.bpel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.xml.sax.SAXException;

public class BPEL_Transformator {

	private File originalFolder;

	private Process process;

	private List<File> externalWsdls = new LinkedList<File>();

	private File mainWsdl;

	private File uiManagerWsdl;

	private File processOperationWsdl;

	private Resource bpelResource;

	public BPEL_Transformator(String bpelPath) {
		File bpelFile = new File(bpelPath);
		originalFolder = bpelFile.getParentFile();
		process = loadProcess(bpelPath);
		for (Import anImport : process.getImports()) {
			File importFile = new File(originalFolder + File.separator
					+ anImport.getLocation());
			if (!anImport.getNamespace().equals(process.getTargetNamespace()))
				externalWsdls.add(importFile);
			else
				mainWsdl = importFile;
		}
		uiManagerWsdl = getWsdlManagerFromPlugin("/resources/",
				"UiManager.wsdl");
		processOperationWsdl = getWsdlManagerFromPlugin("/resources/",
				"ProcessOperations.wsdl");
	}

	private File getWsdlManagerFromPlugin(String root, String fileName) {
		URL url = this.getClass().getResource(root + fileName);
		File opwsdl = null;
		try {
			opwsdl = File.createTempFile(fileName, ".wsdl");
			InputStream inputStream = url.openStream();
			OutputStream outputStream = new FileOutputStream(opwsdl);

			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			inputStream.close();
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return opwsdl;

	}

	private Process loadProcess(String bpelPath) {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createFileURI(bpelPath);
		bpelResource = resourceSet.getResource(uri, true);
		try {
			bpelResource.load(Collections.EMPTY_MAP);
			EList<EObject> contents = bpelResource.getContents();
			if (!contents.isEmpty()) {
				return (Process) contents.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void transform(File outputFolder) {
		if (!outputFolder.isDirectory()) {
			System.out.println("directory");
			return;
		}
		try {
			copyExternalWsdls(outputFolder);
			
			File f = new File(originalFolder+ File.separator+"deploy.xml");
			DeployFileTrans dft = new DeployFileTrans(f);
			dft.setup(outputFolder);
			
			File newUiManagerWsdl = copyUiBPELWsdl(outputFolder, uiManagerWsdl,
					"UiManager.wsdl");
			File newProcessOperationWsdl = copyUiBPELWsdl(outputFolder,
					processOperationWsdl, "ProcessOperations.wsdl");

			ProcessWsdlManager wsdlManager = new ProcessWsdlManager(process,
					mainWsdl);
			wsdlManager.addPartnerWsdl("UiManager", newUiManagerWsdl);
			wsdlManager.addPartnerWsdl("ProcessOperation",
					newProcessOperationWsdl);
			File newProcessWsdl = wsdlManager.parseTo(outputFolder);

			OutputStream outputStream = new FileOutputStream(outputFolder
					+ File.separator + process.getName() + ".bpel");
			UI_BPELWriter writer = new UI_BPELWriter(newProcessWsdl,
					(BPELResource) bpelResource);
			writer.addPartner("UiManager", newUiManagerWsdl, false);
			writer.addPartner("ProcessOperation", newProcessOperationWsdl,
					true);
			writer.write(outputStream, Collections.<String, String> emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	private File copyUiBPELWsdl(File outputFolder, File wsdlFile,
			String wsdlName) throws IOException {
		InputStream inputStream = new FileInputStream(wsdlFile);
		File newWsdlFile = new File(outputFolder + File.separator + wsdlName);
		OutputStream outputStream = new FileOutputStream(newWsdlFile);
		copyStream(inputStream, outputStream);
		return newWsdlFile;
	}

	private void copyExternalWsdls(File outputFolder) throws IOException {
		for (File anExternalWsdl : externalWsdls) {
			InputStream inputStream = new FileInputStream(anExternalWsdl);
			OutputStream outputStream = new FileOutputStream(outputFolder
					+ File.separator + anExternalWsdl.getName());
			copyStream(inputStream, outputStream);
		}
	}

	private void copyStream(InputStream inputStream, OutputStream outputStream)
			throws FileNotFoundException, IOException {
		int read = 0;
		byte[] bytes = new byte[1024];
		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}

		inputStream.close();
		outputStream.flush();
		outputStream.close();
	}

}
