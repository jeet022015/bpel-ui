package be.edu.fundp.precise.uibpel.model.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.impl.OnEventImpl;
import org.eclipse.bpel.model.proxy.MessageProxy;
import org.eclipse.bpel.model.proxy.PartnerLinkProxy;
import org.eclipse.bpel.model.proxy.XSDElementDeclarationProxy;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.bpel.model.resource.BPELVariableResolver;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.PortType;
import org.eclipse.xsd.XSDElementDeclaration;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;
import be.edu.fundp.precise.uibpel.model.DataType;
import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.ModelFactory;
import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.PickUI;
import be.edu.fundp.precise.uibpel.model.ScopeUI;
import be.edu.fundp.precise.uibpel.model.UserInteraction;
import be.edu.fundp.precise.uibpel.model.UserRole;

/**
 * The Class BpelUIReader.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class BpelUIReader extends BPELReader {

	/** The my inner reader. */
	BPELReader myInnerReader;

	/** The v resolver. */
	BPELVariableResolver vResolver = new BPELVariableResolver();

	/** The my inner process. */
	Process myInnerProcess;

	/**
	 * Xml2 scope ui.
	 *
	 * @param scopeElement the scope element
	 * @return the scope ui
	 */
	protected ScopeUI xml2ScopeUI(Element scopeElement) {
		ScopeUI scope = ModelFactory.eINSTANCE.createScopeUI();
		// attach the DOM node to our new activity
		scope.setElement(scopeElement);
		// if (scopeElement == null) {
		// return scope;
		// }

		Attr name = scopeElement.getAttributeNode("name");

		if (name != null && name.getSpecified()) {
			scope.setName(name.getValue());
		}

		Attr isolated = scopeElement.getAttributeNode("isolated");

		if (isolated != null && isolated.getSpecified())
			scope.setIsolated(Boolean
					.valueOf(isolated.getValue().equals("yes")));

		// Handle attribute exitOnStandardFault
		Attr exitOnStandardFault = scopeElement
				.getAttributeNode("exitOnStandardFault");
		if (exitOnStandardFault != null && exitOnStandardFault.getSpecified())
			scope.setExitOnStandardFault(Boolean.valueOf(exitOnStandardFault
					.getValue().equals("yes")));

		// Handle Variables element
		Element variablesElement = getBPELChildElementByLocalName(scopeElement,
				"variables");
		if (variablesElement != null) {
			Variables variables = xml2Variables(variablesElement);
			scope.setVariables(variables);
		}

		// Handle CorrelationSet element
		Element correlationSetsElement = getBPELChildElementByLocalName(
				scopeElement, "correlationSets");
		if (correlationSetsElement != null) {
			CorrelationSets correlationSets = xml2CorrelationSets(correlationSetsElement);
			scope.setCorrelationSets(correlationSets);
		}

		// Handle PartnerLinks element
		Element partnerLinksElement = getBPELChildElementByLocalName(
				scopeElement, "partnerLinks");
		if (partnerLinksElement != null) {
			PartnerLinks partnerLinks = xml2PartnerLinks(partnerLinksElement);
			scope.setPartnerLinks(partnerLinks);
		}

		// MessageExchanges element
		Element messageExchangesElement = getBPELChildElementByLocalName(
				scopeElement, "messageExchanges");
		if (messageExchangesElement != null) {
			MessageExchanges messageExchanges = xml2MessageExchanges(messageExchangesElement);
			scope.setMessageExchanges(messageExchanges);
		}

		// Handle FaultHandler element
		Element faultHandlerElement = getBPELChildElementByLocalName(
				scopeElement, "faultHandlers");
		if (faultHandlerElement != null) {
			FaultHandler faultHandler = xml2FaultHandler(faultHandlerElement);
			scope.setFaultHandlers(faultHandler);
		}

		// Handle CompensationHandler element
		setCompensationHandler(scopeElement, scope);

		// Handler TerminationHandler element
		Element terminationHandlerElement = getBPELChildElementByLocalName(
				scopeElement, "terminationHandler");
		if (terminationHandlerElement != null) {
			TerminationHandler terminationHandler = xml2TerminationHandler(terminationHandlerElement);
			scope.setTerminationHandler(terminationHandler);
		}

		// Handler EventHandler element
		// IT IS MINE
		setEventHandlerUI(scopeElement, scope);

		setStandardAttributes(scopeElement, scope);

		// Handle activities
		NodeList scopeElements = scopeElement.getChildNodes();

		Element activityElement = null;

		if (scopeElements != null && scopeElements.getLength() > 0) {

			for (int i = 0; i < scopeElements.getLength(); i++) {
				if (scopeElements.item(i).getNodeType() != Node.ELEMENT_NODE) {
					continue;
				}

				activityElement = (Element) scopeElements.item(i);

				if (activityElement.getLocalName().equals("faultHandlers")
						|| activityElement.getLocalName().equals(
								"compensationHandler")) {
					continue;
				}

				Activity activity = myInnerReader.xml2Activity(activityElement);
				if (activity != null) {
					scope.setActivity(activity);
					break;
				}
			}
		}

		return scope;
	}

	/**
	 * Sets the event handler ui.
	 *
	 * @param element the element
	 * @param extensibleElement the extensible element
	 */
	protected void setEventHandlerUI(Element element,
			BPELExtensibleElement extensibleElement) {
		List<Element> eventHandlerElements = getBPELUiChildElementsByLocalName(
				element, "eventUiHandler");

		if (eventHandlerElements.size() > 0) {
			EventHandler eventHandler = xml2EventUIHandler(eventHandlerElements
					.get(0));

			if (extensibleElement instanceof Process)
				((Process) extensibleElement).setEventHandlers(eventHandler);
			else if (extensibleElement instanceof Scope)
				((Scope) extensibleElement).setEventHandlers(eventHandler);
		}
	}

	/**
	 * Returns a list of child nodes of <code>parentElement</code> that are.
	 *
	 * @param parentElement the element to find the children of
	 * @param localName the localName to match against
	 * @return a node list of the matching children of parentElement
	 * {@link Element}s with a BPEL namespace that have the given
	 * <code>localName</code>. Returns an empty list if no matching elements are
	 * found.
	 */
	protected List<Element> getBPELUiChildElementsByLocalName(
			Element parentElement, String localName) {
		List<Element> list = new ArrayList<Element>();
		NodeList children = parentElement.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (localName.equals(node.getLocalName())
					&& BpelUiUtils.isBpelUiElement(node)) {
				list.add((Element) node);
			}
		}
		return list;
	}

	/**
	 * Xml2 event ui handler.
	 *
	 * @param eventHandlerElement the event handler element
	 * @return the event handler
	 */
	protected EventHandler xml2EventUIHandler(Element eventHandlerElement) {
		EventHandlerUI eventHandler = ModelFactory.eINSTANCE
				.createEventHandlerUI();
		eventHandler.setElement(eventHandlerElement);

		// Save all the references to external namespaces
		saveNamespacePrefix(eventHandler, eventHandlerElement);

		NodeList eventHandlerElements = eventHandlerElement.getChildNodes();
		Element eventHandlerInstanceElement = null;
		if (eventHandlerElements != null
				&& eventHandlerElements.getLength() > 0) {

			for (int i = 0; i < eventHandlerElements.getLength(); i++) {
				if (eventHandlerElements.item(i).getNodeType() != Node.ELEMENT_NODE)
					continue;
				eventHandlerInstanceElement = (Element) eventHandlerElements
						.item(i);

				if (eventHandlerInstanceElement.getLocalName()
						.equals("onAlarm")) {
					OnAlarm onAlarm = xml2OnAlarm(eventHandlerInstanceElement);
					eventHandler.getAlarm().add(onAlarm);
				} else if (eventHandlerInstanceElement.getLocalName().equals(
						"onEvent")) {
					OnEvent onEvent = xml2OnEvent(eventHandlerInstanceElement);
					eventHandler.getEvents().add(onEvent);
				} else if (eventHandlerInstanceElement.getLocalName().equals(
						"onUserEvent")) {
					OnUserEvent onUserEvent = xml2OnUserEvent(eventHandlerInstanceElement);
					eventHandler.getUserInteraction().add(onUserEvent);
				}
			}
		}
		return eventHandler;
	}

	/**
	 * Xml2 on user event.
	 *
	 * @param pickInstanceElement the pick instance element
	 * @return the on user event
	 */
	protected OnUserEvent xml2OnUserEvent(Element pickInstanceElement) {
		// create a new DataOutputUI model object if not already created
		OnUserEvent sa = ModelFactory.eINSTANCE.createOnUserEvent();
		sa.setElement(pickInstanceElement);

		setID(pickInstanceElement, sa);
		setUserRole(pickInstanceElement, sa);

		// handle the child activity
		NodeList childElements = pickInstanceElement.getChildNodes();
		Element activityElement = null;
		if (childElements != null && childElements.getLength() > 0) {
			for (int i = 0; i < childElements.getLength(); i++) {
				// the only element node is the child activity
				if ((childElements.item(i).getNodeType() == Node.ELEMENT_NODE)) {
					activityElement = (Element) childElements.item(i);
					Activity childActivity = xml2Activity(activityElement);
					if (childActivity != null) {
						sa.setActivity(childActivity);
					}
				}
			}
		}
		return sa;
	}

	/**
	 * Xml2 data input ui.
	 *
	 * @param activity the activity
	 * @param saElement the sa element
	 * @param process the process
	 * @return the data input ui
	 */
	protected DataInputUI xml2DataInputUI(Activity activity, Element saElement,
			Process process) {
		DataInputUI sa = ModelFactory.eINSTANCE.createDataInputUI();
		sa.setElement(saElement);

		setID(saElement, sa);
		setUserRole(saElement, sa);
		setCreateInstance(saElement, sa);
		return sa;
	}

	/**
	 * Read input data items.
	 *
	 * @param activity the activity
	 * @param saElement the sa element
	 */
	public void readInputDataItems(DataInputUI activity, Element saElement) {
		NodeList dataItemElements = saElement.getChildNodes();

		Element dataItemElement = null;

		if (dataItemElements != null && dataItemElements.getLength() > 0) {

			for (int i = 0; i < dataItemElements.getLength(); i++) {
				if (dataItemElements.item(i).getNodeType() != Node.ELEMENT_NODE)
					continue;

				dataItemElement = (Element) dataItemElements.item(i);

				if (dataItemElement.getLocalName().equals(
						BpelUiConstants.ND_INPUT_ITEM)) {
					DataItem dataItem = xml2DataItem(activity, dataItemElement);
					activity.getInputItem().add(dataItem);
				}
			}
		}
	}

	/**
	 * Xml2 data item.
	 *
	 * @param activity the activity
	 * @param dataItemElement the data item element
	 * @return the data item
	 */
	private DataItem xml2DataItem(Activity activity, Element dataItemElement) {
		DataItem aDataItem = ModelFactory.eINSTANCE.createDataItem();
		aDataItem.setElement(dataItemElement);
		String inputVarName = dataItemElement
				.getAttribute(ModelPackage.eINSTANCE.getDataItem_Variable()
						.getName());
		if (inputVarName != null && !"".equals(inputVarName.trim())) {
			Variable v = getVariable(activity, inputVarName);
			aDataItem.setVariable(v);
		}

		String dataType = ModelPackage.eINSTANCE.getDataItem_Type().getName();
		if (dataItemElement.getAttribute(dataType) != null) {
			aDataItem.setType(DataType.get(dataItemElement
					.getAttribute(dataType)));
		}
		return aDataItem;
	}

	/**
	 * Sets the user role.
	 *
	 * @param saElement the sa element
	 * @param sa the sa
	 */
	private void setUserRole(Element saElement, UserInteraction sa) {
		NodeList userRoles = saElement.getChildNodes();
		Element userRoleElement = null;
		if (userRoles != null && userRoles.getLength() > 0) {

			for (int i = 0; i < userRoles.getLength(); i++) {
				if (userRoles.item(i).getNodeType() != Node.ELEMENT_NODE)
					continue;
				userRoleElement = (Element) userRoles.item(i);
				if (userRoleElement.getLocalName().equals(
						BpelUiConstants.ND_USER_ROLE)) {

					// handle the SampleExtensionAttribute
					String attName = ModelPackage.eINSTANCE
							.getUserRole_RoleId().getName();
					if (userRoleElement.getAttribute(attName) != null) {
						UserRole ur = ModelFactory.eINSTANCE.createUserRole();
						ur.setRoleId(userRoleElement.getAttribute(attName));
						sa.getUserRoles().add(ur);
					}
				}
			}
		}
	}

	/**
	 * Sets the id.
	 *
	 * @param saElement the sa element
	 * @param sa the sa
	 */
	private void setID(Element saElement, UserInteraction sa) {
		String attName = ModelPackage.eINSTANCE.getUserInteraction_Id()
				.getName();
		if (saElement.getAttribute(attName) != null) {
			sa.setId(saElement.getAttribute(attName));
			BpelUiUtils.setId(saElement.getAttribute(attName));
		}
	}

	/**
	 * Xml2 data output ui.
	 *
	 * @param activity the activity
	 * @param saElement the sa element
	 * @param process the process
	 * @return the data output ui
	 */
	protected DataOutputUI xml2DataOutputUI(Activity activity,
			Element saElement, Process process) {
		DataOutputUI sa = ModelFactory.eINSTANCE.createDataOutputUI();
		sa.setElement(saElement);
		setID(saElement, sa);
		setUserRole(saElement, sa);
		setCreateInstance(saElement, sa);
		return sa;
	}

	/**
	 * Read output data items.
	 *
	 * @param sa the sa
	 * @param saElement the sa element
	 */
	public void readOutputDataItems(DataOutputUI sa, Element saElement) {
		NodeList dataItemElements = saElement.getChildNodes();
		Element dataItemElement = null;
		if (dataItemElements != null && dataItemElements.getLength() > 0) {

			for (int i = 0; i < dataItemElements.getLength(); i++) {
				if (dataItemElements.item(i).getNodeType() != Node.ELEMENT_NODE)
					continue;

				dataItemElement = (Element) dataItemElements.item(i);
				if (dataItemElement.getLocalName().equals(
						BpelUiConstants.ND_OUTPUT_ITEM)) {
					DataItem dataItem = xml2DataItem(sa, dataItemElement);
					sa.getOutputItem().add(dataItem);
				}
			}
		}
	}

	/**
	 * Xml2 data selection ui.
	 *
	 * @param activity the activity
	 * @param saElement the sa element
	 * @param process the process
	 * @return the data selection ui
	 */
	protected DataSelectionUI xml2DataSelectionUI(Activity activity,
			Element saElement, Process process) {
		DataSelectionUI sa = ModelFactory.eINSTANCE.createDataSelectionUI();
		sa.setElement(saElement);
		setMaxCard(saElement, sa);
		setMinCardin(saElement, sa);
		setID(saElement, sa);
		setUserRole(saElement, sa);
		setCreateInstance(saElement, sa);
		return sa;
	}

	/**
	 * Sets the min cardin.
	 *
	 * @param saElement the sa element
	 * @param sa the sa
	 */
	private void setMinCardin(Element saElement, DataSelectionUI sa) {
		// handle the MaxCardinality
		String attName = ModelPackage.eINSTANCE
				.getDataSelectionUI_MinCardinality().getName();
		if (saElement.getAttribute(attName) != null) {
			sa.setMinCardinality(Integer.parseInt(saElement
					.getAttribute(attName)));
		}
	}

	/**
	 * Sets the max card.
	 *
	 * @param saElement the sa element
	 * @param sa the sa
	 */
	private void setMaxCard(Element saElement, DataSelectionUI sa) {
		// handle the MaxCardinality
		String attName = ModelPackage.eINSTANCE
				.getDataSelectionUI_MaxCardinality().getName();
		if (saElement.getAttribute(attName) != null) {
			sa.setMaxCardinality(Integer.parseInt(saElement
					.getAttribute(attName)));
		}
	}


	/**
	 * Sets the create instance.
	 *
	 * @param activity the activity
	 * @param saElement the sa element
	 */
	public void setCreateInstance(Element saElement, UserInteraction activity) {
		String inputVarName = saElement
				.getAttribute(ModelPackage.eINSTANCE.getUserInteraction_CreateInstance()
						.getName());
		if (inputVarName != null && !"".equals(inputVarName.trim())) {
			activity.setCreateInstance(Boolean.parseBoolean(inputVarName));
		}
	}

	/**
	 * Xml2 pick ui.
	 *
	 * @param activity the activity
	 * @param pickElement the pick element
	 * @param process the process
	 * @return the activity
	 */
	public Activity xml2PickUI(Activity activity, Element pickElement,
			Process process) {
		PickUI pick;
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
		if (activity != null && activity instanceof PickUI) {
			pick = (PickUI) activity;
		} else {
			pick = ModelFactory.eINSTANCE.createPickUI();
			// attach the DOM node to our new activity
			pick.setElement(pickElement);
		}

		// Set name
		Attr name = pickElement.getAttributeNode("name");

		if (name != null && name.getSpecified())
			pick.setName(name.getValue());

		// Set createInstance
		Attr createInstance = pickElement.getAttributeNode("createInstance");

		if (createInstance != null && createInstance.getSpecified())
			pick.setCreateInstance(Boolean.valueOf(createInstance.getValue()
					.equals("yes") ? "True" : "False"));

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
						BpelUiConstants.ND_ON_USER_EVENT)) {
					OnUserEvent onUserEvent = xml2OnUserEvent(pickInstanceElement);
					pick.getUserInteraction().add(onUserEvent);
				}
			}
		}

		setStandardAttributes(pickElement, pick);

		return pick;
	}

	/**
	 * Sets a PartnerLink element for a given EObject. The given activity
	 * element must contain an attribute named "partnerLink".
	 *
	 * @param activityElement the DOM element of the activity
	 * @param eObject the EObject in which to set the partner link
	 * @param reference the reference
	 */
	@Override
	protected void setPartnerLink(Element activityElement,
			final EObject eObject, final EReference reference) {
		if (!activityElement.hasAttribute("partnerLink")) {
			return;
		}

		final String partnerLinkName = activityElement
				.getAttribute("partnerLink");
		// We must do this as a post load runnable because the partner link
		// might not
		// exist yet.
		PartnerLink targetPartnerLink = BPELUtils.getPartnerLink(eObject,
				partnerLinkName);
		if (targetPartnerLink == null) {
			targetPartnerLink = new PartnerLinkProxy(getResource().getURI(),
					partnerLinkName);
		}
		eObject.eSet(reference, targetPartnerLink);
	}

	/**
	 * Sets name, portType, operation, partner, variable, messageType and
	 * correlation for a given PartnerActivity object.
	 *
	 * @param activityElement the activity element
	 * @param onEvent the on event
	 */
	@Override
	protected void setOperationParmsOnEvent(final Element activityElement,
			final OnEvent onEvent) {
		// Set partnerLink
		setPartnerLink(activityElement, onEvent,
				BPELPackage.eINSTANCE.getOnEvent_PartnerLink());

		// Set portType
		PortType portType = null;
		if (activityElement.hasAttribute("portType")) {
			portType = BPELUtils.getPortType(getResource().getURI(),
					activityElement, "portType");
			onEvent.setPortType(portType);
		}

		// Set operation
		if (activityElement.hasAttribute("operation")) {
			if (portType != null) {
				onEvent.setOperation(BPELUtils.getOperation(getResource()
						.getURI(), portType, activityElement, "operation"));
			} else {
				((OnEventImpl) onEvent).setOperationName(activityElement
						.getAttribute("operation"));
			}
		}

		// Set variable
		if (activityElement.hasAttribute("variable")) {
			Variable variable = BPELFactory.eINSTANCE.createVariable();

			// Set name
			String name = activityElement.getAttribute("variable");
			variable.setName(name);
			onEvent.setVariable(variable);
			// Don't set the message type of the variable, this will happen
			// in the next step.
		}

		// Set message type
		if (activityElement.hasAttribute("messageType")) {
			QName qName = BPELUtils.createAttributeValue(activityElement,
					"messageType");
			Message messageType = new MessageProxy(getResource().getURI(),
					qName);
			onEvent.setMessageType(messageType);
		}

		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=336003
		// "element" attribute was missing from original model
		// Set xsd element
		if (activityElement.hasAttribute("element")) {
			QName qName = BPELUtils.createAttributeValue(activityElement,
					"element");
			XSDElementDeclaration element = new XSDElementDeclarationProxy(
					getResource().getURI(), qName);
			onEvent.setXSDElement(element);
		} else {
			onEvent.setXSDElement(null);
		}

		// Set correlations
		Element correlationsElement = getBPELChildElementByLocalName(
				activityElement, "correlations");
		if (correlationsElement != null) {
			Correlations correlations = xml2Correlations(correlationsElement);
			onEvent.setCorrelations(correlations);
		}
	}

	/**
	 * Sets the inner reader.
	 *
	 * @param bpelReader the new inner reader
	 */
	public void setInnerReader(BPELReader bpelReader) {
		myInnerReader = bpelReader;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELReader#getResource()
	 */
	public Resource getResource() {
		return myInnerReader.getResource();
	}

	/**
	 * My pass2.
	 */
	public void myPass2() {
		pass2();

	}

	/**
	 * Gets the inner reader.
	 *
	 * @return the inner reader
	 */
	public BPELReader getInnerReader() {
		return myInnerReader;
	}

	/**
	 * Sets the inner process.
	 *
	 * @param process the new inner process
	 */
	public void setInnerProcess(Process process) {
		myInnerProcess = process;
	}

	/**
	 * Gets the inner process.
	 *
	 * @return the inner process
	 */
	public Process getInnerProcess() {
		return myInnerProcess;
	}

}
