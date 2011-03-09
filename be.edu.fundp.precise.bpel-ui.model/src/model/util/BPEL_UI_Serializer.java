package model.util;

import javax.xml.namespace.QName;

import model.DataInputUI;
import model.DataOutputUI;
import model.DataSelectionUI;
import model.ModelPackage;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.extensions.BPELActivitySerializer;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class BPEL_UI_Serializer implements BPELActivitySerializer{
	
	private Element activityElement;

	public void marshall(QName elementType, Activity activity, Node parentNode,
			Process process, BPELWriter bpelWriter) {
		Document document = parentNode.getOwnerDocument();

		activityElement = null;
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

	private void dataSelectionUISerialization(QName elementType,
			Activity activity, Node parentNode, Process process,
			Document document) {
		if(activityElement == null){
			// create a new DOM element for our Activity
			activityElement = document.createElementNS(elementType.getNamespaceURI(),
					ExtensionsampleConstants.ND_DATA_SELECTION_UI);
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
			Element activityElement = document.createElementNS(elementType.getNamespaceURI(),
					ExtensionsampleConstants.ND_DATA_OUTPUT_UI);
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
			Element activityElement = document.createElementNS(elementType.getNamespaceURI(),
					ExtensionsampleConstants.ND_DATA_INPUT_UI);
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
