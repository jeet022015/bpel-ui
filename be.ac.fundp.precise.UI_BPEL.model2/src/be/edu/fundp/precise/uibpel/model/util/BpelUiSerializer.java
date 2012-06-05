package be.edu.fundp.precise.uibpel.model.util;

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.extensions.BPELActivitySerializer;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.emf.common.util.EList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;
import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.ScopeUI;
import be.edu.fundp.precise.uibpel.model.UserInteraction;
import be.edu.fundp.precise.uibpel.model.UserRole;

/*
 * Bug 120110 - this class has been updated to include a Variable
 * reference for the SampleSimpleActivity and a Variable definition
 * for the SampleStructuredActivity.
 */
/**
 * The Class BpelUiSerializer.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class BpelUiSerializer implements BPELActivitySerializer {

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.extensions.BPELActivitySerializer#marshall(javax.xml.namespace.QName, org.eclipse.bpel.model.Activity, org.w3c.dom.Node, org.eclipse.bpel.model.Process, org.eclipse.bpel.model.resource.BPELWriter)
	 */
	@Override
	public void marshall(QName elementType, Activity activity,
			Node parentNode, Process process,
			BPELWriter bpelWriter) {

		Document document = parentNode.getOwnerDocument();
		Element saElement = null;
		
		//TODO put it inside my writer
		
		/*
		 * ScopeUI
		 */
		if (activity instanceof ScopeUI) {
			ScopeUI sa = (ScopeUI)activity;

			if(saElement == null){
				// create a new DOM element for our Activity
				saElement = document.createElementNS(elementType.getNamespaceURI(),
						BpelUiConstants.ND_SCOPE_UI);
				saElement.setPrefix(BpelUiUtils.addNamespace(process));
			}
			if (sa.getEventHandlers() != null)
				saElement.appendChild(eventUIHandler2XML((EventHandlerUI) sa
						.getEventHandlers(), document, elementType.getNamespaceURI(), process, bpelWriter));
		}

		/*
		 * DataSelectionUI
		 */
		if (activity instanceof DataSelectionUI) {
			DataSelectionUI sa = (DataSelectionUI)activity;

			if(saElement == null){
				// create a new DOM element for our Activity
				saElement = document.createElementNS(elementType.getNamespaceURI(),
						BpelUiConstants.ND_DATA_SELECTION_UI);
				saElement.setPrefix(BpelUiUtils.addNamespace(process));
			}

			String attMaxCardi = ModelPackage.eINSTANCE
				.getDataSelectionUI_MaxCardinality().getName();
			saElement.setAttribute(attMaxCardi, Integer.toString(sa.getMaxCardinality()));
			
			String attMinCardi = ModelPackage.eINSTANCE
				.getDataSelectionUI_MinCardinality().getName();
			saElement.setAttribute(attMinCardi, Integer.toString(sa.getMinCardinality()));
		}
		
		/*
		 * DataInputUI
		 */
		if (activity instanceof DataInputUI) {
			DataInputUI sa = (DataInputUI)activity;

			if(saElement == null){
				// create a new DOM element for our Activity
				saElement = document.createElementNS(elementType.getNamespaceURI(),
						BpelUiConstants.ND_DATA_INPUT_UI);
				saElement.setPrefix(BpelUiUtils.addNamespace(process));
			}
			
			String attCreateInstance = ModelPackage.eINSTANCE
					.getDataInputUI_CreateInstance().getName();
			saElement.setAttribute(attCreateInstance, String.valueOf(sa.isCreateInstance()));
			
			EList<DataItem> roles = sa.getInputItem();
			for (DataItem dataItem : roles) {
				saElement.appendChild(dataItem2XML(dataItem,
						document,elementType.getNamespaceURI(),process,
						BpelUiConstants.ND_INPUT_ITEM));
			}
		}
		
		/*
		 * DataOutputUI
		 */
		if (activity instanceof DataOutputUI) {
			DataOutputUI sa = (DataOutputUI)activity;

			if(saElement == null){
				// create a new DOM element for our Activity
				saElement = document.createElementNS(elementType.getNamespaceURI(),
						BpelUiConstants.ND_DATA_OUTPUT_UI);
				saElement.setPrefix(BpelUiUtils.addNamespace(process));
			}

			EList<DataItem> roles = sa.getOutputItem();
			for (DataItem dataItem : roles) {
				saElement.appendChild(dataItem2XML(dataItem,
						document,elementType.getNamespaceURI(),process,
						BpelUiConstants.ND_OUTPUT_ITEM));
			}
		}
		
		/*
		 * UserInteraction
		 */
		if (activity instanceof UserInteraction) {
			UserInteraction sa = (UserInteraction)activity;
			if(saElement != null){
				String attMaxCardi = ModelPackage.eINSTANCE
						.getUserInteraction_Id().getName();
				//TODO Maybe it is bugged
				if (sa.getId() != null && !"".equals(sa.getId()) && BpelUiUtils.isHigherId(sa.getId())){
					saElement.setAttribute(attMaxCardi, sa.getId());
					BpelUiUtils.setId(sa.getId());
				}
				else 
					saElement.setAttribute(attMaxCardi, Integer.toString(BpelUiUtils.getNewId()));
				
				EList<UserRole> roles = sa.getUserRoles();
				for (UserRole role : roles) {
					saElement.appendChild(userRole2XML(role,
							document,elementType.getNamespaceURI(),process,
							BpelUiConstants.ND_USER_ROLE));
				}
			}
		}
		
		//NEVER DELETE IT NETO!!!!
		// insert the DOM element into the DOM tree
		parentNode.appendChild(saElement);
	}

	/**
	 * User role2 xml.
	 *
	 * @param role the role
	 * @param document the document
	 * @param namespaceURI the namespace uri
	 * @param process the process
	 * @param ndUserRole the nd user role
	 * @return the node
	 */
	private Node userRole2XML(UserRole role, Document document,
			String namespaceURI, Process process, String ndUserRole) {
		Element saElement = document.createElementNS(namespaceURI, ndUserRole);
		saElement.setPrefix(BpelUiUtils.addNamespace(process));
		
		if (role.getRoleId() != null) {
			saElement.setAttribute(ModelPackage.eINSTANCE.
					getUserRole_RoleId().getName(), role.getRoleId());
		}
		return saElement;
	}

	/**
	 * Event ui handler2 xml.
	 *
	 * @param eventHandler the event handler
	 * @param document the document
	 * @param elementType the element type
	 * @param process the process
	 * @param bpelWriter the bpel writer
	 * @return the node
	 */
	public Node eventUIHandler2XML(EventHandlerUI eventHandler,
			Document document, String elementType, Process process,
			BPELWriter bpelWriter) {
		BpelUIWriter myBpelUIWriter;
		if (bpelWriter instanceof BpelUIWriter)
			myBpelUIWriter = (BpelUIWriter) bpelWriter;
		else
			myBpelUIWriter =  new BpelUIWriter(bpelWriter.getResource(),document);
		
		Element eventHandlerElement = document.createElementNS(elementType,
				BpelUiConstants.ND_EVENT_UI_HANDLER);
		eventHandlerElement.setPrefix(BpelUiUtils.addNamespace(process));

		for (Iterator<?> it = eventHandler.getUserInteraction().iterator(); it.hasNext();) {
			OnUserEvent onUserEvent = (OnUserEvent) it.next();
			eventHandlerElement.appendChild(onUserEvent2XML(onUserEvent, document, elementType, process, bpelWriter));
		}
		// TODO: For backwards compatibility with 1.1 we should serialize
		// OnMessages here.
		for (Iterator<?> it = eventHandler.getEvents().iterator(); it.hasNext();) {
			OnEvent onEvent = (OnEvent) it.next();
			eventHandlerElement.appendChild(myBpelUIWriter.onEvent2XML(onEvent));
		}
		for (Iterator<?> it = eventHandler.getAlarm().iterator(); it.hasNext();) {
			OnAlarm onAlarm = (OnAlarm) it.next();
			eventHandlerElement.appendChild(myBpelUIWriter.onAlarm2XML(onAlarm));
		}
		// serialize local namespace prefixes to XML
		//serializePrefixes(eventHandler, eventHandlerElement);
		//bpelWriter.extensibleElement2XML(eventHandler, eventHandlerElement);
		return eventHandlerElement;
	}

	/**
	 * On user event2 xml.
	 *
	 * @param onUserEvent the on user event
	 * @param document the document
	 * @param elementType the element type
	 * @param process the process
	 * @param bpelWriter the bpel writer
	 * @return the node
	 */
	public Node onUserEvent2XML(OnUserEvent onUserEvent, Document document,
			String elementType, Process process, BPELWriter bpelWriter) {
		// create a new DOM element for our Activity
		Element saElement = document.createElementNS(elementType,
				BpelUiConstants.ND_ON_USER_EVENT);
		saElement.setPrefix(BpelUiUtils.addNamespace(process));

		if (onUserEvent.getActivity() != null) {
			saElement.appendChild(bpelWriter.activity2XML(onUserEvent.getActivity()));
		}
		
		if (onUserEvent.getId() != null) {
			saElement.setAttribute("id", onUserEvent.getId());
		}
		// serialize local namespace prefixes to XML
		//serializePrefixes(eventHandler, eventHandlerElement);
		//bpelWriter.extensibleElement2XML(eventHandler, eventHandlerElement);
		return saElement;
	}

	/**
	 * Data item2 xml.
	 *
	 * @param dataItem the data item
	 * @param document the document
	 * @param namespaceURI the namespace uri
	 * @param process the process
	 * @param name the name
	 * @return the node
	 */
	public Node dataItem2XML(DataItem dataItem, Document document,
			String namespaceURI, Process process, String name) {
		Element saElement = document.createElementNS(namespaceURI, name);
		saElement.setPrefix(BpelUiUtils.addNamespace(process));
		
		if (dataItem.getType() != null) {
			saElement.setAttribute(ModelPackage.eINSTANCE.
					getDataItem_Type().getName(), dataItem.getType().getLiteral());
		}
		if (dataItem.getVariable() != null) {
			saElement.setAttribute(ModelPackage.eINSTANCE.
					getDataItem_Variable().getName(), dataItem.getVariable().getName());
		}
		return saElement;
	}

	/**
	 * User role2 xml.
	 *
	 * @param element the element
	 * @param staticDoc the static doc
	 * @param namespace the namespace
	 * @param process the process
	 * @param bpelUIWriter the bpel ui writer
	 * @return the element
	 */
	public Element userRole2XML(UserRole element, Document staticDoc,
			String namespace, Process process, BpelUIWriter bpelUIWriter) {
		Element saElement = staticDoc.createElementNS(namespace, BpelUiConstants.ND_USER_ROLE);
		saElement.setPrefix(BpelUiUtils.addNamespace(process));
		
		if (element.getRoleId() != null) {
			saElement.setAttribute(ModelPackage.eINSTANCE.
					getUserRole_RoleId().getName(), element.getRoleId());
		}
		return saElement;
	}
}
