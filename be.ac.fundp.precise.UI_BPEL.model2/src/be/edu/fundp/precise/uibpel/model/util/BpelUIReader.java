package be.edu.fundp.precise.uibpel.model.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.emf.ecore.resource.Resource;
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

public class BpelUIReader extends BPELReader{
	
	BPELReader myInnerReader;

	protected ScopeUI xml2ScopeUI(Element scopeElement) {
		ScopeUI scope = ModelFactory.eINSTANCE
				.createScopeUI();
		// attach the DOM node to our new activity
		scope.setElement(scopeElement);
		//if (scopeElement == null) {
		//	return scope;
		//}

		Attr name = scopeElement.getAttributeNode("name");
		
		if (name != null && name.getSpecified()) {
			scope.setName(name.getValue());
		}
				
		Attr isolated = scopeElement.getAttributeNode("isolated");
		
		if (isolated != null && isolated.getSpecified())
			scope.setIsolated( Boolean.valueOf( isolated.getValue().equals("yes")));
		
		// Handle attribute exitOnStandardFault
		Attr exitOnStandardFault = scopeElement.getAttributeNode("exitOnStandardFault");
		if (exitOnStandardFault != null && exitOnStandardFault.getSpecified())
			scope.setExitOnStandardFault( Boolean.valueOf( exitOnStandardFault.getValue().equals("yes")));
				
		// Handle Variables element
		Element variablesElement = getBPELChildElementByLocalName(scopeElement, "variables");
		if (variablesElement != null) {
			Variables variables = xml2Variables(variablesElement);
			scope.setVariables(variables);
		}
				
		// Handle CorrelationSet element
		Element correlationSetsElement = getBPELChildElementByLocalName(scopeElement, "correlationSets");
		if (correlationSetsElement != null) {
			CorrelationSets correlationSets = xml2CorrelationSets(correlationSetsElement);
			scope.setCorrelationSets(correlationSets);
		}
		
		// Handle PartnerLinks element
		Element partnerLinksElement = getBPELChildElementByLocalName(scopeElement, "partnerLinks");
		if (partnerLinksElement != null) {
			PartnerLinks partnerLinks = xml2PartnerLinks(partnerLinksElement);
			scope.setPartnerLinks(partnerLinks);
		}
		
		// MessageExchanges element
		Element messageExchangesElement = getBPELChildElementByLocalName(scopeElement, "messageExchanges");
		if (messageExchangesElement != null) {
			MessageExchanges messageExchanges = xml2MessageExchanges(messageExchangesElement);
			scope.setMessageExchanges(messageExchanges);
		}
				
		// Handle FaultHandler element
        Element faultHandlerElement = getBPELChildElementByLocalName(scopeElement, "faultHandlers");
        if (faultHandlerElement != null) {               		
			FaultHandler faultHandler =	xml2FaultHandler(faultHandlerElement); 
			scope.setFaultHandlers(faultHandler);
        }

		// Handle CompensationHandler element
		setCompensationHandler(scopeElement, scope);
		
		// Handler TerminationHandler element
		Element terminationHandlerElement = getBPELChildElementByLocalName(scopeElement, "terminationHandler");
		if (terminationHandlerElement != null) {
			TerminationHandler terminationHandler = xml2TerminationHandler(terminationHandlerElement);
			scope.setTerminationHandler(terminationHandler);
		}
		
		// Handler EventHandler element
		//IT IS MINE
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
           	   	             	
               	activityElement = (Element)scopeElements.item(i); 
               
				if (activityElement.getLocalName().equals("faultHandlers") || 
					activityElement.getLocalName().equals("compensationHandler"))
				{
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

	protected void setEventHandlerUI(Element element, BPELExtensibleElement extensibleElement) {
		List<Element> eventHandlerElements = getBPELUiChildElementsByLocalName(element, "eventUiHandler");
        
		if (eventHandlerElements.size() > 0) {
			EventHandler eventHandler =	xml2EventUIHandler(eventHandlerElements.get(0)); 

			if (extensibleElement instanceof Process) ((Process)extensibleElement).setEventHandlers(eventHandler);
			else if (extensibleElement instanceof Scope) ((Scope)extensibleElement).setEventHandlers(eventHandler);
		}
	}

	/**
     * Returns a list of child nodes of <code>parentElement</code> that are
     * {@link Element}s with a BPEL namespace that have the given <code>localName</code>.
     * Returns an empty list if no matching elements are found.
     * 
	 * @param parentElement  the element to find the children of
	 * @param localName  the localName to match against
	 * @return a node list of the matching children of parentElement
     */
	protected List<Element> getBPELUiChildElementsByLocalName(Element parentElement, String localName) {
		List<Element> list = new ArrayList<Element>();
		NodeList children = parentElement.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (localName.equals(node.getLocalName()) && BpelUiUtils.isBpelUiElement(node)) {
                list.add((Element) node);
			}
		}
		return list;
	}

	protected EventHandler xml2EventUIHandler(Element eventHandlerElement) {
		EventHandlerUI eventHandler = ModelFactory.eINSTANCE.createEventHandlerUI();
		eventHandler.setElement(eventHandlerElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(eventHandler, eventHandlerElement);			
	
		NodeList eventHandlerElements = eventHandlerElement.getChildNodes();        
		Element eventHandlerInstanceElement = null;
		if (eventHandlerElements != null && eventHandlerElements.getLength() > 0) {
          
			for (int i = 0; i < eventHandlerElements.getLength(); i++) {
				if (eventHandlerElements.item(i).getNodeType() != Node.ELEMENT_NODE)
					continue;           	   	             
			   	eventHandlerInstanceElement = (Element)eventHandlerElements.item(i);
               
				if (eventHandlerInstanceElement.getLocalName().equals("onAlarm")) {
					OnAlarm onAlarm = xml2OnAlarm(eventHandlerInstanceElement);     				
					eventHandler.getAlarm().add(onAlarm);
				}   
				else if (eventHandlerInstanceElement.getLocalName().equals("onEvent")) {
					OnEvent onEvent = xml2OnEvent(eventHandlerInstanceElement);	     				
					eventHandler.getEvents().add(onEvent);
				}
				else if (eventHandlerInstanceElement.getLocalName().equals("onUserEvent")) {
					OnUserEvent onUserEvent = xml2OnUserEvent(eventHandlerInstanceElement);     				
					eventHandler.getUserInteraction().add(onUserEvent);
				}
			}
		}       
		
		//xml2ExtensibleElement(eventHandler, eventHandlerElement); 
		return eventHandler;
	}

	protected OnUserEvent xml2OnUserEvent(Element pickInstanceElement) {
		// create a new DataOutputUI model object if not already created
		OnUserEvent sa = ModelFactory.eINSTANCE
			.createOnUserEvent();
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

	protected DataInputUI xml2DataInputUI(Activity activity, Element saElement, Process process) {
		// create a new DataInputUI model object if not already created
		DataInputUI sa;
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
		if (activity instanceof DataInputUI) {
			sa = (DataInputUI)activity;
		}
		else {
			sa = ModelFactory.eINSTANCE
				.createDataInputUI();
			// attach the DOM node to our new activity
			sa.setElement(saElement);
		}
		//readDataItems(activity, saElement, process, sa);
		readInputDataItems(sa, saElement, process);
		
		// handle the ID
		setID(saElement, sa);
		//TODO It Works?
		setUserRole(saElement, sa);
		return sa;
	}

	private void readInputDataItems(DataInputUI activity, Element saElement,
			Process process) {
		NodeList dataItemElements = saElement.getChildNodes();
        
        Element dataItemElement = null;

		if (dataItemElements != null && dataItemElements.getLength() > 0) {
          
           for (int i = 0; i < dataItemElements.getLength(); i++) {
				if (dataItemElements.item(i).getNodeType() != Node.ELEMENT_NODE)
           	   	  continue;
           	   	             	
               dataItemElement = (Element)dataItemElements.item(i);
               
				if (dataItemElement.getLocalName().equals(BpelUiConstants.ND_INPUT_ITEM)) {
					DataItem dataItem = xml2DataItem(activity, process,dataItemElement);
 					activity.getInputItem().add(dataItem);
				}
           }
        }
	}

	private DataItem xml2DataItem(Activity activity, Process process, Element dataItemElement) {
		DataItem aDataItem = ModelFactory.eINSTANCE
				.createDataItem();
		aDataItem.setElement(dataItemElement);
		// handle the SampleExtensionAttribute
		String inputVarName = dataItemElement.getAttribute(
				ModelPackage.eINSTANCE.
				getDataItem_Variable().getName());
		if (inputVarName!=null && !"".equals(inputVarName.trim())) {
			//TODO FIX IT
			//Variable[] vars = ModelHelper.getVisibleVariables(activity.getContainer());
			//Set<Variable> myVars = getMyVars(activity);
			//TODO deal with Scope Variables
			for (Variable variable : process.getVariables().getChildren()) {
				if (inputVarName.equals(variable.getName())) {
					aDataItem.setVariable(variable);
					break;
				}
			}
		}
		
		// handle the SampleExtensionAttribute
		String dataType = ModelPackage.eINSTANCE
				.getDataItem_Type().getName();
		if (dataItemElement.getAttribute(dataType) != null) {
			aDataItem.setType(DataType.get(dataItemElement.getAttribute(dataType)));
		}
		return aDataItem;
	}

	private void setUserRole(Element saElement, UserInteraction sa) {
		NodeList userRoles = saElement.getChildNodes();        
		Element userRoleElement = null;
		if (userRoles != null && userRoles.getLength() > 0) {
          
			for (int i = 0; i < userRoles.getLength(); i++) {
				if (userRoles.item(i).getNodeType() != Node.ELEMENT_NODE)
					continue;           	   	             
			   	userRoleElement = (Element)userRoles.item(i);
				if (userRoleElement.getLocalName().equals(BpelUiConstants.ND_USER_ROLE)) {
					
					// handle the SampleExtensionAttribute
					String attName = ModelPackage.eINSTANCE
							.getUserInteraction_Roles().getName();
					if (userRoleElement.getAttribute(attName) != null) {
						sa.getRoles().add(userRoleElement.getAttribute(attName));
					}
				}
			}
		}
	}

	private void setID(Element saElement, UserInteraction sa) {
		String attName = ModelPackage.eINSTANCE
				.getUserInteraction_Id().getName();
		if (saElement.getAttribute(attName) != null) {
			sa.setId(saElement.getAttribute(attName));
			BpelUiUtils.setId(saElement.getAttribute(attName));
		}
	}

	protected DataOutputUI xml2DataOutputUI(Activity activity, Element saElement,
			Process process) {
		DataOutputUI sa;
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
		if (activity instanceof DataOutputUI) {
			sa = (DataOutputUI)activity;
		}
		else {
			sa = ModelFactory.eINSTANCE
				.createDataOutputUI();
			// attach the DOM node to our new activity
			sa.setElement(saElement);
		}
		
		readOutputDataItems(sa, saElement, process);
		
		// handle the ID
		setID(saElement, sa);
		
		//TODO It Works?
		setUserRole(saElement, sa);
		return sa;
	}

	private void readOutputDataItems(DataOutputUI sa, Element saElement, Process process) {
		NodeList dataItemElements = saElement.getChildNodes();
        Element dataItemElement = null;
		if (dataItemElements != null && dataItemElements.getLength() > 0) {
          
           for (int i = 0; i < dataItemElements.getLength(); i++) {
				if (dataItemElements.item(i).getNodeType() != Node.ELEMENT_NODE)
           	   	  continue;
           	   	             	
               dataItemElement = (Element)dataItemElements.item(i);
               
               	//TODO Refactory here
				if (dataItemElement.getLocalName().equals(BpelUiConstants.ND_OUTPUT_ITEM)) {
					DataItem dataItem = xml2DataItem(sa, process,dataItemElement);
 					sa.getOutputItem().add(dataItem);
				}
           }
        }
	}

	protected DataSelectionUI xml2DataSelectionUI(Activity activity, Element saElement,
			Process process) {
		DataSelectionUI sa;
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
		if (activity instanceof DataSelectionUI) {
			sa = (DataSelectionUI)activity;
		}
		else {
			sa = ModelFactory.eINSTANCE
				.createDataSelectionUI();

			// attach the DOM node to our new activity
			sa.setElement(saElement);
		}
		
		setMaxCard(saElement, sa);
		
		setMinCardin(saElement, sa);
		
		readOutputDataItems(sa, saElement, process);
		readInputDataItems(sa, saElement, process);
		
		// handle the ID
		setID(saElement, sa);
		
		//TODO It Works?
		setUserRole(saElement, sa);
		
		return sa;
	}

	private void setMinCardin(Element saElement, DataSelectionUI sa) {
		// handle the MaxCardinality
		String attName = ModelPackage.eINSTANCE
				.getDataSelectionUI_MinCardinality().getName();
		if (saElement.getAttribute(attName) != null) {
			sa.setMinCardinality(Integer.parseInt(saElement.getAttribute(attName)));
		}
	}

	private void setMaxCard(Element saElement, DataSelectionUI sa) {
		// handle the MaxCardinality
		String attName = ModelPackage.eINSTANCE
				.getDataSelectionUI_MaxCardinality().getName();
		if (saElement.getAttribute(attName) != null) {
			sa.setMaxCardinality(Integer.parseInt(saElement.getAttribute(attName)));
		}
	}

	public Activity xml2PickUI(Activity activity, Element pickElement,
			Process process) {
		PickUI pick;
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
		if(activity != null && activity instanceof PickUI){
			pick = (PickUI)activity;
		}else {
			pick = ModelFactory.eINSTANCE
				.createPickUI();
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
       		pick.setCreateInstance(Boolean.valueOf(createInstance.getValue().equals("yes") ? "True":"False"));  	
	
        NodeList pickElements = pickElement.getChildNodes();
        
        Element pickInstanceElement = null;

		if (pickElements != null && pickElements.getLength() > 0) {
          
           for (int i = 0; i < pickElements.getLength(); i++) {
				if (pickElements.item(i).getNodeType() != Node.ELEMENT_NODE)
           	   	  continue;
           	   	             	
               pickInstanceElement = (Element)pickElements.item(i);
               
				if (pickInstanceElement.getLocalName().equals("onAlarm")) {
     				OnAlarm onAlarm = xml2OnAlarm( pickInstanceElement );
     				pick.getAlarm().add(onAlarm);
     			}     	
				else if (pickInstanceElement.getLocalName().equals("onMessage")) {
     				OnMessage onMessage = xml2OnMessage(pickInstanceElement);	
    	 			pick.getMessages().add(onMessage);
     			}
				else if (pickInstanceElement.getLocalName().equals(BpelUiConstants.ND_ON_USER_EVENT)) {
 					OnUserEvent onUserEvent = xml2OnUserEvent(pickInstanceElement);
 					pick.getUserInteraction().add(onUserEvent);
				}
           }
        }
        
        setStandardAttributes(pickElement, pick);

		return pick;
	}

	public void setInnerReader(BPELReader bpelReader) {
		myInnerReader = bpelReader;
	}
	
	public Resource getResource () {
		return myInnerReader.getResource();
	}

}
