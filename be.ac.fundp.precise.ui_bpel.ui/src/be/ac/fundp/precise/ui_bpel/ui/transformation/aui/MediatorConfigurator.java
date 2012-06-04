package be.ac.fundp.precise.ui_bpel.ui.transformation.aui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// TODO: Auto-generated Javadoc
/**
 * The Class MediatorConfigurator.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class MediatorConfigurator {
	
	//protected Map<String, String> cui2ui = new HashMap<String, String>();
	protected Map<String, Map<String, String>> roleMapping = new HashMap<String, Map<String, String>>();
	
	/**
	 * Instantiates a new mediator configurator.
	 *
	 * @param outstream the outstream
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public MediatorConfigurator () throws ParserConfigurationException{
		
	}
	
	/**
	 * Creates the data input conf.
	 *
	 * @param comp the comp
	 * @param inputActivity the input activity
	 */
	public void createDataInputConf(String roleId, String activityId, String uiId){
		Map<String, String> mapping = roleMapping.get(roleId);
		if (mapping == null || mapping.isEmpty()){
			mapping = new HashMap<String, String>();
			roleMapping.put(roleId, mapping);
		}
		mapping.put(activityId, uiId);
	}

	/**
	 * Creates the data output conf.
	 *
	 * @param comp the comp
	 * @param activity the activity
	 */
	public void createDataOutputConf(String roleId, String activityId, String uiId){
		Map<String, String> mapping = roleMapping.get(roleId);
		if (mapping == null || mapping.isEmpty()){
			mapping = new HashMap<String, String>();
			roleMapping.put(roleId, mapping);
		}
		mapping.put(activityId, uiId);
	}

	/**
	 * Creates the data selection conf.
	 *
	 * @param comp the comp
	 * @param activity the activity
	 */
	public void createDataSelectionConf(String roleId, String activityId, String uiId){
		Map<String, String> mapping = roleMapping.get(roleId);
		if (mapping == null || mapping.isEmpty()){
			mapping = new HashMap<String, String>();
			roleMapping.put(roleId, mapping);
		}
		mapping.put(activityId, uiId);
	}
	
	public Map<String, String> getMappingUI(String roleId){
		return roleMapping.get(roleId);
	}
	
	public String saveXML(String path) throws ParserConfigurationException, FileNotFoundException, TransformerException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("mediation");
		doc.appendChild(rootElement);
		
		Attr attr = doc.createAttribute("minCardi");
		attr.setValue("test");
		Element staff = doc.createElement("DataSelection");
		staff.setAttributeNode(attr);
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream(""));

		transformer.transform(source, result);
		return "";
	}
}
