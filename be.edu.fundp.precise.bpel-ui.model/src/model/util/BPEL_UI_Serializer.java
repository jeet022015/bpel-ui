package model.util;

import javax.xml.namespace.QName;

import model.DataInputUI;
import model.DataOutputUI;
import model.DataSelectionUI;
import model.ModelPackage;
import model.NewPick;
import model.OnUserEvent;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.extensions.BPELActivitySerializer;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.bpel.model.util.BPELUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class BPEL_UI_Serializer extends BPELWriter implements BPELActivitySerializer{
	
	private Element activityElement;

	public void marshall(QName elementType, Activity activity, Node parentNode,
			Process process, BPELWriter bpelWriter) {
		Document document = parentNode.getOwnerDocument();

		activityElement = null;
		/*
		 * DataSelectionUI
		 */
		//TODO user strategy pattern here
		if (activity instanceof NewPick) {
			newPickSerialization(elementType, (NewPick) activity, parentNode,
					process, document);
		}
		/*
		 * DataSelectionUI
		 */
		//TODO user strategy pattern here
		if (activity instanceof DataSelectionUI) {
			dataSelectionUISerialization(elementType, activity, parentNode,
					process, document);
		}
		/*
		 * DataInputUI
		 */
		//TODO user strategy pattern here
		if (activity instanceof DataInputUI) {
			dataInputUISerialization(elementType, activity, parentNode,
					process, document);
		}
		/*
		 * DataOutputUI
		 */
		//TODO user strategy pattern here
		if (activity instanceof DataOutputUI) {
			dataOutputUISerialization(elementType, activity, parentNode,
					process, document);
		}
	}
	
	private void newPickSerialization(QName elementType, NewPick activity,
			Node parentNode, Process process, Document document) {
		if(activityElement == null){
			// create a new DOM element for our Activity
			activityElement = document.createElementNS(elementType.getNamespaceURI(),
					BPEL_UI_Constants.ND_NEW_PICK);
			activityElement.setPrefix(ExtensionSampleUtils.addNamespace(process));
		}
		
		if (activity.isSetCreateInstance()) {
			activityElement.setAttribute("createInstance", BPELUtils
					.boolean2XML(activity.getCreateInstance()));
		}
		for (Object next : activity.getMessages()) {
			activityElement.appendChild(onMessage2XML((OnMessage) next));
		}
		for (Object next : activity.getAlarm()) {
			activityElement.appendChild(onAlarm2XML((OnAlarm) next));
		}
		for (Object next : activity.getUserInteracion()) {
			activityElement.appendChild(onUserInteracion2XML((OnUserEvent) next, document, elementType, process));
		}
		addCommonActivityItems(activityElement, activity);
	}

	private Node onUserInteracion2XML(OnUserEvent onMsg, Document document, QName elementType, Process process) {
		//Element onMessageElement = createBPELElement("onMessage");
		// create a new DOM element for our Activity
		//TODO I don't know how it works
		Element onMessageElement = document.createElementNS(elementType.getNamespaceURI(),
					BPEL_UI_Constants.ND_NEW_PICK);
		activityElement.setPrefix(ExtensionSampleUtils.addNamespace(process));
		if (onMsg.getVariable() != null
				&& onMsg.getVariable().getName() != null) {
			onMessageElement.setAttribute("variable", onMsg.getVariable()
					.getName());
		}
		if (onMsg.getActivity() != null) {
			onMessageElement.appendChild(activity2XML(onMsg.getActivity()));
		}
		// handle the SampleExtensionAttribute
		if (onMsg.getID() != null) {
			String attName = ModelPackage.eINSTANCE
					.getOnUserEvent_ID().getName();
			onMessageElement.setAttribute(attName, onMsg.getID());
		}
		// handle the SampleExtensionAttribute
		if (onMsg.getType() != null) {
			String attName = ModelPackage.eINSTANCE
					.getOnUserEvent_Type().getName();
			onMessageElement.setAttribute(attName, onMsg.getType().getLiteral());
		}
		//TODO USER ROLE
		// TODO: Why do we have this? I don't think OnMessage is extensible.
		extensibleElement2XML(onMsg, onMessageElement);
		return onMessageElement;
	}

	private void dataSelectionUISerialization(QName elementType,
			Activity activity, Node parentNode, Process process,
			Document document) {
		if(activityElement == null){
			// create a new DOM element for our Activity
			activityElement = document.createElementNS(elementType.getNamespaceURI(),
					BPEL_UI_Constants.ND_DATA_SELECTION_UI);
			activityElement.setPrefix(ExtensionSampleUtils.addNamespace(process));
		}
		
		// handle the Selectable
		Variable outputVar = ((DataSelectionUI) activity).getSelectable();
		String attName2 = ModelPackage.eINSTANCE
			.getDataSelectionUI_Selectable().getName();
		if (outputVar != null) {
			//TODO get the Variable from someplace
			activityElement.setAttribute(attName2, outputVar.getName());
		}
		
		// handle the maxCardinality
		int maxCardinality = ((DataSelectionUI) activity).getMaxCardinality();
		attName2 = ModelPackage.eINSTANCE
			.getDataSelectionUI_MaxCardinality().getName();
		if (outputVar != null) {
			activityElement.setAttribute(attName2, Integer.toString(maxCardinality));
		}
		
		// handle the minCardinality
		int minCardinality = ((DataSelectionUI) activity).getMinCardinality();
		attName2 = ModelPackage.eINSTANCE
			.getDataSelectionUI_MinCardinality().getName();
		if (outputVar != null) {
			activityElement.setAttribute(attName2, Integer.toString(minCardinality));
		}

		// insert the DOM element into the DOM tree
		parentNode.appendChild(activityElement);
	}

	private void dataOutputUISerialization(QName elementType,
			Activity activity, Node parentNode, Process process,
			Document document) {
		if(activityElement == null){
			// create a new DOM element for our Activity
			activityElement = document.createElementNS(elementType.getNamespaceURI(),
					BPEL_UI_Constants.ND_DATA_OUTPUT_UI);
			activityElement.setPrefix(ExtensionSampleUtils.addNamespace(process));
		}
		
		// handle the InputVariable
		Variable outputVar = ((DataOutputUI) activity).getOutputVariable();
		String attName2 = ModelPackage.eINSTANCE
			.getDataOutputUI_OutputVariable().getName();
		if (outputVar != null) {
			//TODO get the Variable from someplace
			activityElement.setAttribute(attName2, outputVar.getName());
		}

		// insert the DOM element into the DOM tree
		parentNode.appendChild(activityElement);
	}

	private void dataInputUISerialization(QName elementType, Activity activity,
			Node parentNode, Process process, Document document) {
		if(activityElement == null){
			// create a new DOM element for our Activity
			activityElement = document.createElementNS(elementType.getNamespaceURI(),
					BPEL_UI_Constants.ND_DATA_INPUT_UI);
			activityElement.setPrefix(ExtensionSampleUtils.addNamespace(process));
		}

		// handle the userValidation
		String attName = ModelPackage.eINSTANCE
				.getDataInputUI_UserValidation().getName();
		activityElement.setAttribute(attName, Boolean.toString(((DataInputUI) activity)
				.isUserValidation()));
		
		// handle the InputVariable
		Variable inputVar = ((DataInputUI) activity).getInputVariable();
		String attName2 = ModelPackage.eINSTANCE
			.getDataInputUI_InputVariable().getName();
		if (inputVar != null) {
			//TODO get the Variable from someplace
			activityElement.setAttribute(attName2, inputVar.getName());
		}

		// insert the DOM element into the DOM tree
		parentNode.appendChild(activityElement);
	}

}
