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

import auiPackage.AbstractCompoundIU;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

public class MediatorConfigurator {
	
	//private JSONArray json;
	private Element rootElement;
	private Document doc;
	private OutputStream out;
	
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
	
	public void createDataInputConf(AbstractCompoundIU comp, DataInputUI inputActivity){
		Element staff = doc.createElement("DataInput");
		rootElement.appendChild(staff);
		
		Attr attr = doc.createAttribute("UIid");
		attr.setValue(inputActivity.getId());
		staff.setAttributeNode(attr);
		
		attr = doc.createAttribute("ComponentID");
		attr.setValue(Integer.toString(comp.getId()));
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
	
	public void finalize() throws TransformerException {
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(out);

		transformer.transform(source, result);
	}

	public void createDataOutputConf(AbstractCompoundIU comp,
			DataOutputUI activity) {
		Element staff = doc.createElement("DataOutput");
		rootElement.appendChild(staff);
		
		Attr attr = doc.createAttribute("UIid");
		attr.setValue(activity.getId());
		staff.setAttributeNode(attr);
		
		attr = doc.createAttribute("ComponentID");
		attr.setValue(Integer.toString(comp.getId()));
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

	public void createDataSelectionConf(AbstractCompoundIU comp,
			DataSelectionUI activity) {
		Element staff = doc.createElement("DataSelection");
		rootElement.appendChild(staff);
		
		Attr attr = doc.createAttribute("UIid");
		attr.setValue(activity.getId());
		staff.setAttributeNode(attr);
		
		attr = doc.createAttribute("ComponentID");
		attr.setValue(Integer.toString(comp.getId()));
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
