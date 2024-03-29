package model.util;

import java.util.Map;

import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;

import model.DataInputUI;
import model.DataOutputUI;
import model.DataSelectionUI;
import model.ModelFactory;
import model.ModelPackage;
import model.NewPick;
import model.OnUserEvent;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.extensions.BPELActivityDeserializer;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BPEL_UIDeserializer extends BPELReader implements BPELActivityDeserializer{

	public Activity unmarshall(QName elementType, Node node, Activity activity,
			Process process, Map nsMap, ExtensionRegistry extReg, URI uri,
			BPELReader bpelReader) {
		
		if (BPEL_UI_Constants.ND_NEW_PICK.equals(elementType.getLocalPart())) {
			NewPick newPick = deserializeNewPick(node, activity,
					process, bpelReader);
			return newPick;
		}
		
		//TODO merge with DataInput
		if (BPEL_UI_Constants.ND_DATA_SELECTION_UI.equals(elementType.getLocalPart())) {
			DataSelectionUI aDataSelectionUI = deserializeDataSelectionUI(node, activity,
					process);
			return aDataSelectionUI;
		}

		if (BPEL_UI_Constants.ND_DATA_INPUT_UI.equals(elementType.getLocalPart())) {
			DataInputUI aDataInputUI = deserializeDataInputUI(node, activity,
					process);
			return aDataInputUI;
		}
		
		if (BPEL_UI_Constants.ND_DATA_OUTPUT_UI.equals(elementType.getLocalPart())) {
			DataOutputUI aDataOutputtUI = deserializeDataOutputUI(node, activity,
					process);
			return aDataOutputtUI;
		}
		System.err.println("Cannot handle this kind of element");
		return null;
	}
	
	private NewPick deserializeNewPick(Node node, Activity activity,
			Process process, BPELReader bpelReader) {
		NewPick pick;
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
		if (activity instanceof NewPick) {
			pick = (NewPick)activity;
		}
		else {
			pick = ModelFactory.eINSTANCE
				.createNewPick();

			// attach the DOM node to our new activity
			pick.setElement((Element) node);
		}
		
		Element pickElement = (Element) node;
		
		// Set name
		Attr name = pickElement.getAttributeNode("name");
		
		if (name != null && name.getSpecified())
			pick.setName(name.getValue());
		
		// Set createInstance
		Attr createInstance = pickElement.getAttributeNode("createInstance");
		
		if (createInstance != null && createInstance.getSpecified()) 
       		pick.setCreateInstance(Boolean.valueOf(createInstance.getValue().equals("yes") ? "True":"False"));  	
	
        NodeList pickElements = pickElement.getChildNodes();
        
        Element pickInstanceElement = null;

		if (pickElements != null && pickElements.getLength() > 0) {

			for (int i = 0; i < pickElements.getLength(); i++) {
				if (pickElements.item(i).getNodeType() != Node.ELEMENT_NODE)
					continue;

				pickInstanceElement = (Element) pickElements.item(i);

				if (pickInstanceElement.getLocalName().equals("onAlarm")) {
					OnAlarm onAlarm = xml2OnAlarm(pickInstanceElement);

					pick.getAlarm().add(onAlarm);
				} else if (pickInstanceElement.getLocalName().equals(
						"onMessage")) {
					OnMessage onMessage = xml2OnMessage(pickInstanceElement);

					pick.getMessages().add(onMessage);
				} else if (pickInstanceElement.getLocalName().equals(
						"onUserEvent")) {
					OnUserEvent onUserEvent = xml2OnUserEvent(pickInstanceElement);

					pick.getUserInteracion().add(onUserEvent);
				}
			}
		}
        //TODO I need it?
        //setStandardAttributes(pickElement, pick);

		return pick;
	}

	private OnUserEvent xml2OnUserEvent(Element pickInstanceElement) {
		OnUserEvent onMessage = ModelFactory.eINSTANCE.createOnUserEvent();
 		onMessage.setElement(pickInstanceElement);
 		//TODO create the On User Event
 		
		// Save all the references to external namespaces		
		//saveNamespacePrefix(onMessage, pickInstanceElement);
		return onMessage;
	}

	private DataSelectionUI deserializeDataSelectionUI(Node node,
			Activity activity, Process process) {
		// create a new aDataInputUI model object if not already created
		DataSelectionUI aDataSelectionUI;
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
		if (activity instanceof DataSelectionUI) {
			aDataSelectionUI = (DataSelectionUI)activity;
		}
		else {
			aDataSelectionUI = ModelFactory.eINSTANCE
				.createDataSelectionUI();

			// attach the DOM node to our new activity
			aDataSelectionUI.setElement((Element) node);
		}
		
		// handle the MaxCardinality
		String attName2 = ModelPackage.eINSTANCE
			.getDataSelectionUI_MaxCardinality().getName();
		String varName = ((Element) node).getAttribute(attName2);
		if (varName != null && !varName.equals("")) {
			aDataSelectionUI.setMaxCardinality(Integer.parseInt(varName));
		}
		
		// handle the MinCardinality
		attName2 = ModelPackage.eINSTANCE
			.getDataSelectionUI_MinCardinality().getName();
		varName = ((Element) node).getAttribute(attName2);
		if (varName != null && !varName.equals("")) {
			aDataSelectionUI.setMinCardinality(Integer.parseInt(varName));
		}
		
		// handle the selectable 
		//TODO make in conformance with Invoke
		attName2 = ModelPackage.eINSTANCE
			.getDataSelectionUI_Selectable().getName();
		varName = ((Element) node).getAttribute(attName2);
		if (varName != null && !varName.equals("")) {
			//TODO this code don't consider the Scope variables
			EList<Variable> vars = process.getVariables().getChildren();
			for (Variable var : vars) {
				if (var.getName().equals(varName)){
					aDataSelectionUI.setSelectable(var);
				}
				
			}
			
		}
		
		// handle the userValidation
		attName2 = ModelPackage.eINSTANCE
			.getDataInputUI_UserValidation().getName();
		if (((Element) node).getAttribute(attName2) != null) {
			aDataSelectionUI.setUserValidation(Boolean.parseBoolean(((Element) node)
					.getAttribute(attName2)));
		}
		
		// handle the child activity
		//TODO make in conformance with Invoke
		attName2 = ModelPackage.eINSTANCE
			.getDataInputUI_InputVariable().getName();
		varName = ((Element) node).getAttribute(attName2);
		if (varName != null) {
			//TODO this code don't consider the Scope variables
			EList<Variable> vars = process.getVariables().getChildren();
			for (Variable var : vars) {
				if (var.getName().equals(varName)){
					aDataSelectionUI.setInputVariable(var);
				}
				
			}
			
		}
		
		return aDataSelectionUI;
	}

	private DataOutputUI deserializeDataOutputUI(Node node, Activity activity,
			Process process) {
		// create a new aDataInputUI model object if not already created
		DataOutputUI aDataOutputUI;
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
		if (activity instanceof DataInputUI) {
			aDataOutputUI = (DataOutputUI)activity;
		}
		else {
			aDataOutputUI = ModelFactory.eINSTANCE
				.createDataOutputUI();

			// attach the DOM node to our new activity
			aDataOutputUI.setElement((Element) node);
		}
		
		// handle the output variable
		//TODO make in conformance with Invoke
		String attName2 = ModelPackage.eINSTANCE
			.getDataOutputUI_OutputVariable().getName();
		String varName = ((Element) node).getAttribute(attName2);
		if (varName != null) {
			//TODO this code don't consider the Scope variables
			EList<Variable> vars = process.getVariables().getChildren();
			for (Variable var : vars) {
				if (var.getName().equals(varName)){
					aDataOutputUI.setOutputVariable(var);
				}
				
			}
			
		}
		return aDataOutputUI;
	}

	private DataInputUI deserializeDataInputUI(Node node, Activity activity,
			Process process) {
		// create a new aDataInputUI model object if not already created
		DataInputUI aDataInputUI;
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
		if (activity instanceof DataInputUI) {
			aDataInputUI = (DataInputUI)activity;
		}
		else {
			aDataInputUI = ModelFactory.eINSTANCE
				.createDataInputUI();

			// attach the DOM node to our new activity
			aDataInputUI.setElement((Element) node);
		}

		// handle the userValidation
		String attName = ModelPackage.eINSTANCE
			.getDataInputUI_UserValidation().getName();
		if (((Element) node).getAttribute(attName) != null) {
			aDataInputUI.setUserValidation(Boolean.parseBoolean(((Element) node)
					.getAttribute(attName)));
		}
		
		// handle the child activity
		//TODO make in conformance with Invoke
		String attName2 = ModelPackage.eINSTANCE
			.getDataInputUI_InputVariable().getName();
		String varName = ((Element) node).getAttribute(attName2);
		if (varName != null) {
			//TODO this code don't consider the Scope variables
			EList<Variable> vars = process.getVariables().getChildren();
			for (Variable var : vars) {
				if (var.getName().equals(varName)){
					aDataInputUI.setInputVariable(var);
				}
				
			}
			
		}
		return aDataInputUI;
	}

}
