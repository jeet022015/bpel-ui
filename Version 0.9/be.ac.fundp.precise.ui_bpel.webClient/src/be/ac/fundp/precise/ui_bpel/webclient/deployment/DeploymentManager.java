package be.ac.fundp.precise.ui_bpel.webclient.deployment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMText;
import org.apache.axiom.soap.SOAP12Constants;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.commons.codec.binary.Base64;
import org.eclipse.core.runtime.CoreException;

/**
 * The Class DeploymentManager does the management of files in order to
 * deploy a process in a ode Apache server.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class DeploymentManager {

	private File homeFolder;
	private File zipFile;

	public DeploymentManager (File homeFolder) throws ConfigurationException, CoreException {
		this.homeFolder = homeFolder;
//		IProject project = homeFolder.getProject();		
//		IPath contentPath = homeFolder.getProjectRelativePath().append("deploy.xml");
//		IFile r = project.getFile(contentPath);
//
//		if (!homeFolder.exists() && !(homeFolder instanceof IFolder)){
//			throw new ConfigurationException();
//		}
//		if (!r.exists() || !(r instanceof IFile)){
//			throw new ConfigurationException();
//		}
//
//		deployXML = (IFile)r;
//		IPath folderPath = homeFolder.getProjectRelativePath().append("aux");
//		auxFolder = project.getFolder(folderPath);
//		IProgressMonitor progressMonitor = new NullProgressMonitor();
//		if (!auxFolder.exists()){
//			auxFolder.create(true, true, progressMonitor);
//		} else {
//			for (IResource content : auxFolder.members()) {
//				content.delete(IResource.FOLDER, progressMonitor);
//			}
//			auxFolder.refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);
//		}
	}
//
//	/**
//	 * The method setup add the correct elements to the final deploy file in order
//	 * to allow the communication between the process and the UI Manager.
//	 *
//	 * @return the folder where the deployable process must be created
//	 * @throws ParserConfigurationException the parser configuration exception
//	 * @throws SAXException the deploy' XML is bad formated.
//	 * @throws IOException Signals that an I/O exception has occurred.
//	 * @throws TransformerException An XML transformation exception has occurred.
//	 * @throws CoreException the process' XML is bad formated.
//	 */
//	public IFolder setup() throws ParserConfigurationException, 
//				SAXException, IOException, TransformerException, CoreException {
//		File file = deployXML.getRawLocation().makeAbsolute().toFile(); 
//
//		// Create instance of DocumentBuilderFactory
//		DocumentBuilderFactory factory = DocumentBuilderFactory
//				.newInstance();
//
//		// Get the DocumentBuilder
//		DocumentBuilder docBuilder = factory.newDocumentBuilder();
//
//		// Using existing XML Document
//		Document doc = docBuilder.parse(file);
//
//		// create the root element
//		Element root = doc.getDocumentElement();
//		
//		root.setAttribute("xmlns:UiManager", "http://fundp.ac.be/UiManager/");
//		//xmlns:ProcessOperations="http://precise.fundp.ac.be/ProcessOperations/"
//		root.setAttribute("xmlns:ProcessOperations", "http://precise.fundp.ac.be/ProcessOperations/");
//
//		Node processNode = root.getElementsByTagName("process").item(0);
//		
//		Element invokeElement = doc.createElement("invoke");
//		invokeElement.setAttribute("partnerLink", "UiManagerPartnerLink");
//		Element serviceElement = doc.createElement("service");
//		serviceElement.setAttribute("name", "UiManager:UiManager");
//		serviceElement.setAttribute("port", "UiManagerSOAP");
//		invokeElement.appendChild(serviceElement);
//		processNode.appendChild(invokeElement);
//		
//		Element provideElement = doc.createElement("provide");
//		provideElement.setAttribute("partnerLink", "ProcessOperation");
//		//provideElement.setAttribute("partnerLink", "UserEventPartnerLink");
//		Element serviceProvideElement = doc.createElement("service");
//		//serviceProvideElement.setAttribute("name", "UserEventListener:UserEventListener");
//		serviceProvideElement.setAttribute("name", "ProcessOperations:ProcessOperations");
//		//serviceProvideElement.setAttribute("port", "UserEventListenerSOAP");
//		serviceProvideElement.setAttribute("port", "ProcessOperationsSOAP");
//		provideElement.appendChild(serviceProvideElement);
//		processNode.appendChild(provideElement);
//
//		// set up a transformer
//		TransformerFactory transfac = TransformerFactory.newInstance();
//		Transformer trans = transfac.newTransformer();
//
//		// create string from xml tree
//		StringWriter sw = new StringWriter();
//		StreamResult result = new StreamResult(sw);
//		DOMSource source = new DOMSource(doc);
//		trans.transform(source, result);
//		String xmlString = sw.toString();
//		
//		InputStream is = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
//
//		IProgressMonitor progressMonitor = new NullProgressMonitor();
//		IFile auxDeployXML = auxFolder.getFile("deploy.xml");
//		if (auxDeployXML.exists()) {
//			auxDeployXML.delete(true, progressMonitor);
//		}
//		auxDeployXML.create(is, true, progressMonitor);
//		auxDeployXML.refreshLocal(IResource.DEPTH_INFINITE, null);
//		
//		return auxFolder;
//	}

	/**
	 * This method creates the zip file to be deployed.
	 * @throws IOException 
	 */
	public void createZipFile(File outFolder) throws IOException{	    
//		IFile r = null;
	    byte[] buf = new byte[1024];
	    
//	    try {
	        // Create the ZIP file
	        String target = "target.zip";
//	        IProject project = auxFolder.getProject();		
//			IPath contentPath = auxFolder.getProjectRelativePath().append(target);
//			r = project.getFile(contentPath);
//			IProgressMonitor progressMonitor = new NullProgressMonitor();
//			if (r.exists()) {
//				r.delete(true, progressMonitor);
//			}
//			r.create(new ByteArrayInputStream(new byte[0]), true, progressMonitor);
//	        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(r.getLocation().toOSString()));
	        zipFile  = new File(outFolder + File.separator + target);
	        
	        //ZipOutputStream out = new ZipOutputStream(new FileOutputStream(r.getLocation().toOSString()));
	        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
	        for (File innerFile : homeFolder.listFiles()) {
	        	FileInputStream in = new FileInputStream(innerFile);
	        	out.putNextEntry(new ZipEntry(innerFile.getName()));
	        	
	        	int len;
	            while ((len = in.read(buf)) > 0) {
	                out.write(buf, 0, len);
	            }
	            out.closeEntry();
	            in.close();
			}
	        
	        out.close();
	    
	        // Compress the files
//	        for (IResource aResource : auxFolder.members()) {
//	        	if (aResource.getName().equals(target))
//	        		continue;
//
//	            FileInputStream in = new FileInputStream(aResource.getLocation().toOSString());
//	    
//	            // Add ZIP entry to output stream.
//	            out.putNextEntry(new ZipEntry(aResource.getName()));
//	    
//	            // Transfer bytes from the file to the ZIP file
//	            int len;
//	            while ((len = in.read(buf)) > 0) {
//	                out.write(buf, 0, len);
//	            }
//	    
//	            // Complete the entry
//	            out.closeEntry();
//	            in.close();
//	        }
//	    
//	        // Complete the ZIP file
//	        out.close();
//	        r.refreshLocal(IResource.DEPTH_INFINITE, null);
//	    } catch (IOException e) {
//	    	e.printStackTrace();
//	    }
//	    if (r != null)
//	    	deployFile = r;
	}

	/**
	 * this method deploy the process in an Apache Ode server.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ConfigurationException an error occurred during the deployment process.
	 */
	@SuppressWarnings("unused")
	public void deploy() throws IOException, ConfigurationException {
		//File file = new File(deployFile.getLocation().toOSString());
		String packageName = "COnfigue";
		FileInputStream fin = new FileInputStream(zipFile);
		byte bytes[] = new byte[(int) zipFile.length()];
		fin.read(bytes);

		if (!Base64.isArrayByteBase64(bytes)) {
			byte[] encodedBytes = Base64.encodeBase64(bytes);
			String encodedString = new String(encodedBytes);
			Options opts = new Options();
			opts.setAction("http://www.apache.org/ode/deployapi/DeploymentPortType/deployRequest");
			opts.setSoapVersionURI(SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);
			opts.setProperty(Constants.Configuration.HTTP_METHOD,
					Constants.Configuration.HTTP_METHOD_POST);
			opts.setTo(new EndpointReference(
					"http://localhost:8080/ode/processes/DeploymentService"));
//			opts.setTo(new EndpointReference(
//					"http://138.48.32.93:8080/ode/processes/DeploymentService"));

			OMElement payload = null;
			OMFactory omFactory = OMAbstractFactory.getOMFactory();
			OMNamespace ns = omFactory.createOMNamespace(
					"http://www.apache.org/ode/pmapi", "p");
			payload = omFactory.createOMElement("deploy", ns);
			OMElement name = omFactory.createOMElement("name", ns);
			OMElement packageCont = omFactory.createOMElement("package", ns);
			OMElement zipEle = omFactory.createOMElement("zip", ns);
			if (packageName != null && encodedString != null) {
				OMText nameText = omFactory.createOMText(name, packageName);
				OMText packageText = omFactory.createOMText(zipEle,
						encodedString);
				packageCont.addChild(zipEle);
				payload.addChild(name);
				payload.addChild(packageCont);

				// creating service client
				ServiceClient sc = new ServiceClient();
				sc.setOptions(opts);

				OMElement responseMsg = sc.sendReceive(payload);
				String body = responseMsg.toString();
				if (body.indexOf("name") > 0) {
					System.out.println("Package deployed successfully!");
				} else {
					ConfigurationException error = new ConfigurationException();
					error.setConfMessage("Package deployement failed!");
					throw error;
				}
			} else {
				ConfigurationException error = new ConfigurationException();
				error.setConfMessage("No package Name specified!");
				throw error;
			}
		} else {
			ConfigurationException error = new ConfigurationException();
			error.setConfMessage("Base64 encoded string not supported!");
			throw error;
		}
	}
}
