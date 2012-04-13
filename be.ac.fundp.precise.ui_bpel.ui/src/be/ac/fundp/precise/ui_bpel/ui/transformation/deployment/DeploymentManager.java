package be.ac.fundp.precise.ui_bpel.ui.transformation.deployment;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMText;
import org.apache.axiom.soap.SOAP12Constants;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.commons.codec.binary.Base64;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Shell;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DeploymentManager {

	private IFile deployXML;
	private IFolder auxFolder;
	private IFile deployFile;

	public DeploymentManager (IFolder homeFolder, Shell shell) throws ConfigurationException, CoreException {
		
		IProject project = homeFolder.getProject();		
		IPath contentPath = homeFolder.getProjectRelativePath().append("deploy.xml");
		IFile r = project.getFile(contentPath);

		if (!homeFolder.exists() && !(homeFolder instanceof IFolder)){
			throw new ConfigurationException();
		}
		if (!r.exists() || !(r instanceof IFile)){
			throw new ConfigurationException();
		}

		deployXML = (IFile)r;
		IPath folderPath = homeFolder.getProjectRelativePath().append("aux");
		auxFolder = project.getFolder(folderPath);
		IProgressMonitor progressMonitor = new NullProgressMonitor();
		if (!auxFolder.exists()){
			System.out.println("not exists!");
			auxFolder.create(true, true, progressMonitor);
		} else {
			System.out.println("exists!");
			for (IResource content : auxFolder.members()) {
				content.delete(IResource.FOLDER, progressMonitor);
			}
			auxFolder.refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);
		}
	}

	public IFolder setup() throws ParserConfigurationException, 
				SAXException, IOException, TransformerException, CoreException {
		File file = deployXML.getRawLocation().makeAbsolute().toFile(); 

		// Create instance of DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();

		// Get the DocumentBuilder
		DocumentBuilder docBuilder = factory.newDocumentBuilder();

		// Using existing XML Document
		Document doc = docBuilder.parse(file);

		// create the root element
		Element root = doc.getDocumentElement();
		
		root.setAttribute("xmlns:UiManager", "http://fundp.ac.be/UiManager/");
		root.setAttribute("xmlns:UserEventListener", "http://precise.fundp.ac.be/UserEventListener/");

		Node processNode = root.getElementsByTagName("process").item(0);
		
		Element invokeElement = doc.createElement("invoke");
		invokeElement.setAttribute("partnerLink", "UiManagerPartnerLink");
		Element serviceElement = doc.createElement("service");
		serviceElement.setAttribute("name", "UiManager:UiManager");
		serviceElement.setAttribute("port", "UiManagerSOAP");
		invokeElement.appendChild(serviceElement);
		processNode.appendChild(invokeElement);
		
		Element provideElement = doc.createElement("provide");
		provideElement.setAttribute("partnerLink", "UserEventPartnerLink");
		Element serviceProvideElement = doc.createElement("service");
		serviceProvideElement.setAttribute("name", "UserEventListener:UserEventListener");
		serviceProvideElement.setAttribute("port", "UserEventListenerSOAP");
		provideElement.appendChild(serviceProvideElement);
		processNode.appendChild(provideElement);

		// set up a transformer
		TransformerFactory transfac = TransformerFactory.newInstance();
		Transformer trans = transfac.newTransformer();

		// create string from xml tree
		StringWriter sw = new StringWriter();
		StreamResult result = new StreamResult(sw);
		DOMSource source = new DOMSource(doc);
		trans.transform(source, result);
		String xmlString = sw.toString();
		
		InputStream is = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));

		IProgressMonitor progressMonitor = new NullProgressMonitor();
		IFile auxDeployXML = auxFolder.getFile("deploy.xml");
		if (auxDeployXML.exists()) {
			auxDeployXML.delete(true, progressMonitor);
		}
		auxDeployXML.create(is, true, progressMonitor);
		auxDeployXML.refreshLocal(IResource.DEPTH_INFINITE, null);
		
		return auxFolder;
	}

	public void createZipFile() throws CoreException {	    
		IFile r = null;
	    byte[] buf = new byte[1024];
	    
	    try {
	        // Create the ZIP file
	        String target = "target.zip";
	        IProject project = auxFolder.getProject();		
			IPath contentPath = auxFolder.getProjectRelativePath().append(target);
			r = project.getFile(contentPath);
			IProgressMonitor progressMonitor = new NullProgressMonitor();
			if (r.exists()) {
				r.delete(true, progressMonitor);
			}
			r.create(new ByteArrayInputStream(new byte[0]), true, progressMonitor);
	        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(r.getLocation().toOSString()));
	    
	        // Compress the files
	        for (IResource aResource : auxFolder.members()) {
	        	if (aResource.getName().equals(target))
	        		continue;

	            FileInputStream in = new FileInputStream(aResource.getLocation().toOSString());
	    
	            // Add ZIP entry to output stream.
	            out.putNextEntry(new ZipEntry(aResource.getName()));
	    
	            // Transfer bytes from the file to the ZIP file
	            int len;
	            while ((len = in.read(buf)) > 0) {
	                out.write(buf, 0, len);
	            }
	    
	            // Complete the entry
	            out.closeEntry();
	            in.close();
	        }
	    
	        // Complete the ZIP file
	        out.close();
	        r.refreshLocal(IResource.DEPTH_INFINITE, null);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    if (r != null)
	    	deployFile = r;
	}

	public void deploy() throws IOException {
		File file = new File(deployFile.getLocation().toOSString());
		String packageName = "COnfigue";
		FileInputStream fin = new FileInputStream(file);
		byte bytes[] = new byte[(int) file.length()];
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

				try {
					// invoke service
					OMElement responseMsg = sc.sendReceive(payload);
					String body = responseMsg.toString();
					if (body.indexOf("name") > 0) {
						System.out.println("Package deployed successfully!");
					} else {
						System.out.println("Package deployement failed!");
					}
				} catch (AxisFault axisFault) {
					System.out.println(axisFault.getMessage());
				}
			} else {
				System.out.println("No package Name specified!");
			}
		} else {
			System.out
					.println("TODO: Implement Base64 encoded string support!");
		}
	}
}
