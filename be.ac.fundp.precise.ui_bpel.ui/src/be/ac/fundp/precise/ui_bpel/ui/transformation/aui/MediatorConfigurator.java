package be.ac.fundp.precise.ui_bpel.ui.transformation.aui;

import java.io.OutputStream;

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

import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.AbstractComponentIU;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

// TODO: Auto-generated Javadoc
/**
 * The Class MediatorConfigurator.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class MediatorConfigurator {
	
	//private JSONArray json;
	/** The root element. */
	private Element rootElement;
	
	/** The doc. */
	private Document doc;
	
	/** The out. */
	private OutputStream out;
	
	/**
	 * Instantiates a new mediator configurator.
	 *
	 * @param outstream the outstream
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public MediatorConfigurator (OutputStream outstream) throws ParserConfigurationException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		doc = docBuilder.newDocument();
		rootElement = doc.createElement("mediation");
		doc.appendChild(rootElement);
		out = outstream;
	}
	
	/**
	 * Creates the data input conf.
	 *
	 * @param comp the comp
	 * @param inputActivity the input activity
	 */
	public void createDataInputConf(AbstractComponentIU comp, DataInputUI inputActivity){
		Element staff = doc.createElement("DataInput");
		rootElement.appendChild(staff);
		
		Attr attr = doc.createAttribute("UIid");
		attr.setValue(inputActivity.getId());
		staff.setAttributeNode(attr);
		
		attr = doc.createAttribute("ComponentID");
		attr.setValue(comp.getId());
		staff.setAttributeNode(attr);
		
		attr = doc.createAttribute("role");
		//TODO deal with role
		attr.setValue("----");
		staff.setAttributeNode(attr);
		
		Element data = doc.createElement("data");
		staff.appendChild(data);
		for (DataItem dataItem : inputActivity.getInputItem()) {
			Element elemDataItem = doc.createElement("dataItem");
			data.appendChild(elemDataItem);
			
			attr = doc.createAttribute("id");
			attr.setValue(dataItem.getVariable().getName());
			elemDataItem.setAttributeNode(attr);
			
			attr = doc.createAttribute("type");
			attr.setValue(dataItem.getType().getName());
			elemDataItem.setAttributeNode(attr);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws TransformerException {
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(out);

		transformer.transform(source, result);
	}

	/**
	 * Creates the data output conf.
	 *
	 * @param comp the comp
	 * @param activity the activity
	 */
	public void createDataOutputConf(AbstractComponentIU comp,
			DataOutputUI activity) {
		Element staff = doc.createElement("DataOutput");
		rootElement.appendChild(staff);
		
		Attr attr = doc.createAttribute("UIid");
		attr.setValue(activity.getId());
		staff.setAttributeNode(attr);
		
		attr = doc.createAttribute("ComponentID");
		attr.setValue(comp.getId());
		staff.setAttributeNode(attr);
		
		attr = doc.createAttribute("role");
		//TODO deal with role
		attr.setValue("----");
		staff.setAttributeNode(attr);
		
		Element data = doc.createElement("data");
		staff.appendChild(data);
		for (DataItem dataItem : activity.getOutputItem()) {
			Element elemDataItem = doc.createElement("dataItem");
			data.appendChild(elemDataItem);
			
			attr = doc.createAttribute("id");
			attr.setValue(dataItem.getVariable().getName());
			elemDataItem.setAttributeNode(attr);
			
			attr = doc.createAttribute("type");
			attr.setValue(dataItem.getType().getName());
			elemDataItem.setAttributeNode(attr);
		}
	}

	/**
	 * Creates the data selection conf.
	 *
	 * @param comp the comp
	 * @param activity the activity
	 */
	public void createDataSelectionConf(AbstractComponentIU comp,
			DataSelectionUI activity) {
		Element staff = doc.createElement("DataSelection");
		rootElement.appendChild(staff);
		
		Attr attr = doc.createAttribute("UIid");
		attr.setValue(activity.getId());
		staff.setAttributeNode(attr);
		
		attr = doc.createAttribute("ComponentID");
		attr.setValue(comp.getId());
		staff.setAttributeNode(attr);
		
		attr = doc.createAttribute("role");
		//TODO deal with role
		attr.setValue("----");
		staff.setAttributeNode(attr);
		
		Element data = doc.createElement("data");
		staff.appendChild(data);
		for (DataItem dataItem : activity.getInputItem()) {
			Element elemDataItem = doc.createElement("dataItem");
			data.appendChild(elemDataItem);
			
			attr = doc.createAttribute("id");
			attr.setValue(dataItem.getVariable().getName());
			elemDataItem.setAttributeNode(attr);
			
			attr = doc.createAttribute("type");
			attr.setValue(dataItem.getType().getName());
			elemDataItem.setAttributeNode(attr);
		}
		
		attr = doc.createAttribute("minCardi");
		attr.setValue(Integer.toString(activity.getMinCardinality()));
		staff.setAttributeNode(attr);
		
		attr = doc.createAttribute("maxCardi");
		attr.setValue(Integer.toString(activity.getMaxCardinality()));
		staff.setAttributeNode(attr);
	}
}
