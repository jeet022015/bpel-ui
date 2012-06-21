package be.ac.fundp.precise.ui_bpel.transformations.bpel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.model.Process;
import org.eclipse.emf.common.util.URI;
import org.eclipse.wst.wsdl.BindingOperation;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Port;
import org.eclipse.wst.wsdl.Service;

import be.ac.fundp.precise.ui_bpel.transformations.bpel.wsdl.DataOperationInWsdl;

public class ProcessWsdlManager {

	protected File originalWsdl;
	protected List<Operation> relatedOperations;
	protected File[] otherWsdlfiles;
	protected Process process;
	protected Map<String, File> relatedPatern = new HashMap<String, File>();

	public ProcessWsdlManager(Process process, File mainWsdl) {
		originalWsdl = mainWsdl;
		this.process = process;
		relatedOperations = new LinkedList<Operation>();
	}

	private List<Operation> getOperations(Definition relatedWsdl) {
		List<Operation> operations = new LinkedList<Operation>();
		Service s1 = (Service) relatedWsdl.getEServices().get(0);
		Port p1 = (Port) s1.getEPorts().get(0);
		for (Object op : p1.getBinding().getBindingOperations()) {
			BindingOperation opera = (BindingOperation) op;
			operations.add(opera.getEOperation());
		}
		return operations;
	}

	public File parseTo(File outputFolder) throws IOException {
		File newWsdl = copyOriginal(outputFolder);
		URI uri = URI.createFileURI(newWsdl.getCanonicalPath());
		Definition processWSDl = UI_BPELUtil.attemptLoadWSDL(uri, process
				.eResource().getResourceSet());

		WSDLImportHelperUI.addToolingNamespaces(processWSDl);

		saveProcessWSDL(processWSDl);

		DataOperationInWsdl dataOp = new DataOperationInWsdl(processWSDl);

		for (String paternKey : relatedPatern.keySet()) {
			File relatedFile = relatedPatern.get(paternKey)
					.getCanonicalFile();
			//uri = URI.createFileURI(relatedPatern.get(paternKey)
			//		.getCanonicalPath());
			uri = URI.createFileURI(relatedFile.getCanonicalPath());
			Definition relatedWSDl = UI_BPELUtil.attemptLoadWSDL(uri, process
					.eResource().getResourceSet());
			
			System.out.println("paternKey="+paternKey);
			relatedWSDl.setLocation(relatedFile.getName());
			System.out.println("Location="+relatedWSDl.getLocation());
			WSDLImportHelperUI.addImportAndNamespace(processWSDl, relatedWSDl);
			saveProcessWSDL(processWSDl);
			dataOp.addPartnerLinkType(paternKey, relatedWSDl);
		}

		saveProcessWSDL(processWSDl);

		for (Operation relatedOperation : relatedOperations) {
			dataOp.addDataOperation(relatedOperation);
		}

		saveProcessWSDL(processWSDl);
		return newWsdl;
	}

	private void saveProcessWSDL(Definition processWSDl) {
		try {
			processWSDl.eResource().save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private File copyOriginal(File outputFolder) throws IOException {
		InputStream inputStream = new FileInputStream(originalWsdl);
		File newWsld = new File(outputFolder + File.separator
				+ originalWsdl.getName());
		OutputStream outputStream = new FileOutputStream(outputFolder
				+ File.separator + originalWsdl.getName());
		int read = 0;
		byte[] bytes = new byte[1024];
		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}

		inputStream.close();
		outputStream.flush();
		outputStream.close();
		return newWsld;
	}

	public void addPartnerWsdl(String string, File newWsdlFile)
			throws IOException {
		URI uri = URI.createFileURI(newWsdlFile.getCanonicalPath());
		Definition relatedWsdl = UI_BPELUtil.attemptLoadWSDL(uri, process
				.eResource().getResourceSet());
		relatedOperations.addAll(getOperations(relatedWsdl));
		relatedPatern.put(string, newWsdlFile);
	}

}
