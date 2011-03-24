package be.edu.fundp.precise.bpel_ui.model.util;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.extensions.BPELActivitySerializer;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.wst.wsdl.WSDLElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import be.edu.fundp.precise.bpel_ui.model.BPEL_UI_Entity;
import be.edu.fundp.precise.bpel_ui.model.DataInputUI;
import be.edu.fundp.precise.bpel_ui.model.DataOutputUI;
import be.edu.fundp.precise.bpel_ui.model.DataSelectionUI;
import be.edu.fundp.precise.bpel_ui.model.ModelPackage;
import be.edu.fundp.precise.bpel_ui.model.OnUserEvent;
import be.edu.fundp.precise.bpel_ui.model.PickUI;

/*
 * Bug 120110 - this class has been updated to include a Variable
 * reference for the SampleSimpleActivity and a Variable definition
 * for the SampleStructuredActivity.
 */
public class BPEL_UI_Serializer implements BPELActivitySerializer {

	@Override
	public Element marshall(QName elementType, Activity activity, Node parentNode, Process process,
			BPELWriter bpelWriter) {

		Document document = parentNode.getOwnerDocument();
		Element saElement = null;

		/*
		 * PickUI
		 */
		if (activity instanceof PickUI) {
			PickUI sa = (PickUI)activity;

			if(saElement == null){
				// create a new DOM element for our Activity
				saElement = document.createElementNS(elementType.getNamespaceURI(),
						BPEL_UI_Constants.ND_PICK_UI);
				saElement.setPrefix(BPEL_UI_Utils.addNamespace(process));
			}

			EList<OnUserEvent> events = sa.getUserInteraction();
			for (OnUserEvent onUserEvent : events) {
				saElement.appendChild(onUserEvent2XML(onUserEvent,document,elementType,process,bpelWriter));
			}

			
		}
		/*
		 * DataInputUI
		 */
		if (activity instanceof DataSelectionUI) {
			DataSelectionUI sa = (DataSelectionUI)activity;

			if(saElement == null){
				// create a new DOM element for our Activity
				saElement = document.createElementNS(elementType.getNamespaceURI(),
						BPEL_UI_Constants.ND_DATA_SELECTION_UI);
				saElement.setPrefix(BPEL_UI_Utils.addNamespace(process));
			}

			String attName = ModelPackage.eINSTANCE
				.getDataSelectionUI_MaxCardinality().getName();
			saElement.setAttribute(attName, Integer.toString(sa.getMaxCardinality()));
			
			attName = ModelPackage.eINSTANCE
				.getDataSelectionUI_MinCardinality().getName();
			saElement.setAttribute(attName, Integer.toString(sa.getMinCardinality()));

			
		}
		
		/*
		 * DataInputUI
		 */
		if (activity instanceof DataInputUI) {
			DataInputUI sa = (DataInputUI)activity;

			if(saElement == null){
			// create a new DOM element for our Activity
				saElement = document.createElementNS(elementType.getNamespaceURI(),
					BPEL_UI_Constants.ND_DATA_INPUT_UI);
				saElement.setPrefix(BPEL_UI_Utils.addNamespace(process));
			}

			// handle the InputVariable
			if (sa.getInputVariable() != null) {
				String name = sa.getInputVariable().getName();
				if (name != null && !"".equals(name.trim()))
					saElement.setAttribute(ModelPackage.eINSTANCE.
							getDataInputUI_InputVariable().getName(), name);
			}
			
			//TODO and the User Role

			// insert the DOM element into the DOM tree
			//parentNode.appendChild(saElement);
		}
		
		/*
		 * DataOutputUI
		 */
		if (activity instanceof DataOutputUI) {
			DataOutputUI sa = (DataOutputUI)activity;

			if(saElement == null){
			// create a new DOM element for our Activity
				saElement = document.createElementNS(elementType.getNamespaceURI(),
					BPEL_UI_Constants.ND_DATA_OUTPUT_UI);
				saElement.setPrefix(BPEL_UI_Utils.addNamespace(process));
			}

			// handle the InputVariable
			if (sa.getOutputVariable() != null) {
				String name = sa.getOutputVariable().getName();
				if (name != null && !"".equals(name.trim()))
					saElement.setAttribute(ModelPackage.eINSTANCE.
							getDataOutputUI_OutputVariable().getName(), name);
			}
			
			//TODO and the User Role

			// insert the DOM element into the DOM tree
			//parentNode.appendChild(saElement);
		}
		
		// insert the DOM element into the DOM tree
		//parentNode.appendChild(saElement);
		return saElement;
	}

	private Node onUserEvent2XML(OnUserEvent onUserEvent, Document document, QName elementType, Process process, BPELWriter bpelWriter) {
		// create a new DOM element for our Activity
		Element saElement = document.createElementNS(elementType.getNamespaceURI(),
				BPEL_UI_Constants.ND_ON_USER_EVENT);
		saElement.setPrefix(BPEL_UI_Utils.addNamespace(process));
		
		if (onUserEvent.getVariable() != null
				&& onUserEvent.getVariable().getName() != null) {
			saElement.setAttribute("variable", onUserEvent.getVariable()
					.getName());
		}

		if (onUserEvent.getActivity() != null) {
			saElement.appendChild(bpelWriter.activity2XML(onUserEvent.getActivity()));
		}
		
		if (onUserEvent.getId() != null) {
			saElement.setAttribute("id", onUserEvent.getId());
		}
		
		if (onUserEvent.getType() != null) {
			saElement.setAttribute("type", onUserEvent.getType().getLiteral());
		}
		return saElement;
	}

	@Override
	public boolean isSerializable(Activity activity) {
		if(activity instanceof BPEL_UI_Entity)
			return true;
		return false;
	}

	@Override
	public Element marshallInternalElement(QName qName, Node parentNode,
			WSDLElement element, Process process, BPELWriter bpelWriter) {
		Element saElement = null;
		/*
		 * PickUI
		 */
		if (element instanceof OnUserEvent) {
			OnUserEvent sa = (OnUserEvent)element;
			Document document = parentNode.getOwnerDocument();
			//it works?
			saElement = (Element) onUserEvent2XML(sa,document,qName,process,bpelWriter);
			return saElement;

			
		}
		return null;
	}

}
