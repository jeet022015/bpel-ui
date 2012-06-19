package be.ac.fundp.precise.ui_bpel.transformations.bpel;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DeployFileTrans {
	
	private File deployFile;

	public DeployFileTrans (File deployFile){
		this.deployFile = deployFile;
	}

	public void setup(File outputFolder) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// Create instance of DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Get the DocumentBuilder
		DocumentBuilder docBuilder = factory.newDocumentBuilder();

		// Using existing XML Document
		Document doc = docBuilder.parse(deployFile);

		// create the root element
		Element root = doc.getDocumentElement();

		root.setAttribute("xmlns:UiManager", "http://fundp.ac.be/UiManager/");
		// xmlns:ProcessOperations="http://precise.fundp.ac.be/ProcessOperations/"
		root.setAttribute("xmlns:ProcessOperations",
				"http://precise.fundp.ac.be/ProcessOperations/");

		Node processNode = root.getElementsByTagName("process").item(0);

		Element invokeElement = doc.createElement("invoke");
		//invokeElement.setAttribute("partnerLink", "UiManagerPartnerLink");
		invokeElement.setAttribute("partnerLink", "UiManager");
		Element serviceElement = doc.createElement("service");
		serviceElement.setAttribute("name", "UiManager:UiManager");
		serviceElement.setAttribute("port", "UiManagerSOAP");
		invokeElement.appendChild(serviceElement);
		processNode.appendChild(invokeElement);

		Element provideElement = doc.createElement("provide");
		provideElement.setAttribute("partnerLink", "ProcessOperation");
		// provideElement.setAttribute("partnerLink", "UserEventPartnerLink");
		Element serviceProvideElement = doc.createElement("service");
		// serviceProvideElement.setAttribute("name",
		// "UserEventListener:UserEventListener");
		serviceProvideElement.setAttribute("name",
				"ProcessOperations:ProcessOperations");
		// serviceProvideElement.setAttribute("port", "UserEventListenerSOAP");
		serviceProvideElement.setAttribute("port", "ProcessOperationsSOAP");
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

		InputStream inputStream = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));

		File newWsld = new File(outputFolder + File.separator
				+ deployFile.getName());
		OutputStream outputStream = new FileOutputStream(newWsld);
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
