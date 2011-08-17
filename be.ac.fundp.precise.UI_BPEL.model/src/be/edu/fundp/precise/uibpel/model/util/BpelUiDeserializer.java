package be.edu.fundp.precise.uibpel.model.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.extensions.BPELActivityDeserializer;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.WSDLElement;
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

/*
 * Bug 120110 - this class has been updated to include a Variable
 * reference for the SampleSimpleActivity and a Variable definition
 * for the SampleStructuredActivity.
 */
public class BpelUiDeserializer implements BPELActivityDeserializer {
		
	Set <Integer> codes = new HashSet<Integer>();
	BpelUIReader inBpelUIReader = new BpelUIReader();
	
	@Override
	public Activity unmarshall(QName elementType, Node node, Activity activity, Process process,
			Map nsMap, ExtensionRegistry extReg, URI uri, BPELReader bpelReader) {
	
		if (codes.contains(node.hashCode())) {
			return null;
		}
		codes.add(node.hashCode());
		/*
		 * DataInputUI
		 */
		if (BpelUiConstants.ND_DATA_INPUT_UI.equals(elementType.getLocalPart())) {

			// create a new SampleSimpleActivity model object if not already created
			DataInputUI sa;
			Element saElement = (Element)node;
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
			
			// handle variable name: find this variable is in a visible scope
			String inputVarName = saElement.getAttribute(
					ModelPackage.eINSTANCE.
					getDataInputUI_InputVariable().getName());
			if (inputVarName!=null && !"".equals(inputVarName.trim())) {
				Variable[] vars = ModelHelper.getVisibleVariables(activity.getContainer());
				//Set<Variable> myVars = getMyVars(activity);
				//TODO deal with Scope Variables
				for (Variable variable : process.getVariables().getChildren()) {
					if (inputVarName.equals(variable.getName())) {
						sa.setInputVariable(variable);
						break;
					}
				}
			}
			
			// handle the ID
			String attName = ModelPackage.eINSTANCE
					.getUsableEntity_Id().getName();
			if (saElement.getAttribute(attName) != null) {
				sa.setId(saElement.getAttribute(attName));
				BpelUiUtils.setId(saElement.getAttribute(attName));
			}
			
			//TODO It Works?
			setUserRole(saElement, sa);
			
			//TODO It Works?
			setDataItem(saElement, sa);
			//return inBpelUIReader.xml2DataInputUI(activity,saElement, process);
			return sa;
		}
		
		/*
		 * DataOutputUI
		 */
		if (BpelUiConstants.ND_DATA_OUTPUT_UI.equals(elementType.getLocalPart())) {

			// create a new SampleSimpleActivity model object if not already created
			DataOutputUI sa;
			Element saElement = (Element)node;
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
			
			// handle variable name: find this variable is in a visible scope
			String outputVarName = saElement.getAttribute(
					ModelPackage.eINSTANCE.
					getDataOutputUI_OutputVariable().getName());
			if (outputVarName!=null && !"".equals(outputVarName.trim())) {
				//Variable[] vars = ModelHelper.getVisibleVariables(activity);
				for (Variable variable : process.getVariables().getChildren()) {
					if (outputVarName.equals(variable.getName())) {
						sa.setOutputVariable(variable);
						break;
					}
				}
			}
			
			// handle the ID
			String attName = ModelPackage.eINSTANCE
					.getUsableEntity_Id().getName();
			if (saElement.getAttribute(attName) != null) {
				sa.setId(saElement.getAttribute(attName));
				BpelUiUtils.setId(saElement.getAttribute(attName));
			}
			
			//TODO It Works?
			setUserRole(saElement, sa);
			
			//TODO It Works?
			setDataItem(saElement, sa);

			return sa;
		}
		
		/*
		 * DataSelectionUI
		 */
		if (BpelUiConstants.ND_DATA_SELECTION_UI.equals(elementType.getLocalPart())) {

			// create a new SampleSimpleActivity model object if not already created
			DataSelectionUI sa;
			Element saElement = (Element)node;
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
			
			// handle the MaxCardinality
			String attName = ModelPackage.eINSTANCE
					.getDataSelectionUI_MaxCardinality().getName();
			if (saElement.getAttribute(attName) != null) {
				sa.setMaxCardinality(Integer.parseInt(saElement.getAttribute(attName)));
			}
			
			// handle the MaxCardinality
			attName = ModelPackage.eINSTANCE
					.getDataSelectionUI_MinCardinality().getName();
			if (saElement.getAttribute(attName) != null) {
				sa.setMinCardinality(Integer.parseInt(saElement.getAttribute(attName)));
			}
			
			// handle variable name: find this variable is in a visible scope
			String outputVarName = saElement.getAttribute(
					ModelPackage.eINSTANCE.
					getDataOutputUI_OutputVariable().getName());
			if (outputVarName!=null && !"".equals(outputVarName.trim())) {
				//Variable[] vars = ModelHelper.getVisibleVariables(activity);
				for (Variable variable : process.getVariables().getChildren()) {
					if (outputVarName.equals(variable.getName())) {
						sa.setOutputVariable(variable);
						break;
					}
				}
			}
			
			// handle variable name: find this variable is in a visible scope
			String inputVarName = saElement.getAttribute(
					ModelPackage.eINSTANCE.
					getDataInputUI_InputVariable().getName());
			if (inputVarName!=null && !"".equals(inputVarName.trim())) {
				//Variable[] vars = ModelHelper.getVisibleVariables(activity);
				for (Variable variable : process.getVariables().getChildren()) {
					if (inputVarName.equals(variable.getName())) {
						sa.setInputVariable(variable);
						break;
					}
				}
			}
			
			// handle the ID
			attName = ModelPackage.eINSTANCE
					.getUsableEntity_Id().getName();
			if (saElement.getAttribute(attName) != null) {
				sa.setId(saElement.getAttribute(attName));
				BpelUiUtils.setId(saElement.getAttribute(attName));
			}
			
			//TODO It Works?
			setUserRole(saElement, sa);
			
			//TODO It Works?
			setDataItem(saElement, sa);
			return sa;
		}
		
		/*
		 * PickUI
		 */
		if (BpelUiConstants.ND_PICK_UI.equals(elementType.getLocalPart())) {

			// create a new DataOutputUI model object if not already created
			PickUI sa;
			Element saElement = (Element)node;
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
			if(activity != null && activity instanceof PickUI){
				sa = (PickUI)activity;
			}else {
				sa = ModelFactory.eINSTANCE
					.createPickUI();
				// attach the DOM node to our new activity
				sa.setElement(saElement);
			}
			
			NodeList pickElements = saElement.getChildNodes();
	        
	        Element pickInstanceElement = null;

			if (pickElements != null && pickElements.getLength() > 0) {
	          
	           for (int i = 0; i < pickElements.getLength(); i++) {
					if (pickElements.item(i).getNodeType() != Node.ELEMENT_NODE)
	           	   	  continue;
	           	   	             	
	               pickInstanceElement = (Element)pickElements.item(i);
	               
					if (pickInstanceElement.getLocalName().equals(BpelUiConstants.ND_ON_USER_EVENT)) {
	     					OnUserEvent onUserEvent = xml2OnUserEvent(pickInstanceElement, activity, bpelReader);
	     					sa.getUserInteraction().add(onUserEvent);
	     			}     
	           }
	        }

			return sa;
		}
		
		/*
		 * Scope
		 */
		if (BpelUiConstants.ND_SCOPE_UI.equals(elementType.getLocalPart())) {
			Element saElement = (Element)node;
			return inBpelUIReader.xml2ScopeUI(saElement);
		}

		System.err.println("Cannot handle this kind of element");
		return null;
	}

	private void setEventHandler(Element element, Activity extensibleElement, BPELReader bpelReader) {
		List<Element> eventHandlerElements = getBPELChildElementsByLocalName(element, "eventHandlers");
        
		if (eventHandlerElements.size() > 0) {
			EventHandler eventHandler =	xml2EventHandler(eventHandlerElements.get(0), extensibleElement, bpelReader); 

			if (extensibleElement instanceof Process) ((Process)extensibleElement).setEventHandlers(eventHandler);
				else if (extensibleElement instanceof Scope) ((Scope)extensibleElement).setEventHandlers(eventHandler);
		}
	}

	private EventHandler xml2EventHandler(Element eventHandlerElement, Activity extensibleElement, BPELReader bpelReader) {
		EventHandlerUI eventHandler = ModelFactory.eINSTANCE.createEventHandlerUI();
		eventHandler.setElement(eventHandlerElement);
		
		// Save all the references to external namespaces		
		//saveNamespacePrefix(eventHandler, eventHandlerElement);			
	
		NodeList eventHandlerElements = eventHandlerElement.getChildNodes();        
		Element eventHandlerInstanceElement = null;
		if (eventHandlerElements != null && eventHandlerElements.getLength() > 0) {
          
			for (int i = 0; i < eventHandlerElements.getLength(); i++) {
				if (eventHandlerElements.item(i).getNodeType() != Node.ELEMENT_NODE)
					continue;           	   	             
			   	eventHandlerInstanceElement = (Element)eventHandlerElements.item(i);
               
				if (eventHandlerInstanceElement.getLocalName().equals("onUserEvent")) {
					OnUserEvent onUserEvent = xml2OnUserEvent(eventHandlerInstanceElement, extensibleElement, bpelReader);     				
					eventHandler.getUserInteraction().add(onUserEvent);
				}
			}
		}
		return eventHandler;
	}

	private OnUserEvent xml2OnUserEvent(Element pickInstanceElement, Activity activity, BPELReader bpelReader) {
		// create a new DataOutputUI model object if not already created
		OnUserEvent sa = ModelFactory.eINSTANCE
			.createOnUserEvent();
		sa.setElement(pickInstanceElement);
		
		// handle the ID
		String attName = ModelPackage.eINSTANCE
				.getUsableEntity_Id().getName();
		if (pickInstanceElement.getAttribute(attName) != null) {
			sa.setId(pickInstanceElement.getAttribute(attName));
		}
		
		// handle the child activity
		NodeList childElements = pickInstanceElement.getChildNodes();
		Element activityElement = null;
		if (childElements != null && childElements.getLength() > 0) {
			for (int i = 0; i < childElements.getLength(); i++) {
				// the only element node is the child activity
				if ((childElements.item(i).getNodeType() == Node.ELEMENT_NODE)) {
					activityElement = (Element) childElements.item(i);
					Activity childActivity = bpelReader.xml2Activity(activityElement);
					if (childActivity != null) {
						sa.setActivity(childActivity);
					}
				}
			}
		}
		
		//setUserRole(pickInstanceElement, (UserInteraction) sa);
		
		return sa;
	}

	private List<Element> getBPELChildElementsByLocalName(Element parentElement, String localName) {
		List<Element> list = new ArrayList<Element>();
		NodeList children = parentElement.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (localName.equals(node.getLocalName()) && BPELUtils.isBPELElement(node)) {
                list.add((Element) node);
			}
		}
		return list;
	}

	private Set<Variable> getMyVars(WSDLElement context) {
		Set<Variable> list = new HashSet<Variable>();
		
		EObject refObj = context;		
		if (refObj instanceof Process) {
			Process process = (Process) refObj;
			Variables variables = process.getVariables();
			if (variables != null){
				list.addAll(variables.getChildren());
				return list;
			}
			
		} else if (refObj instanceof Scope) {
			Scope scope = (Scope) refObj;
			Variables variables = scope.getVariables();
			if (variables != null){
				list.addAll(variables.getChildren());
				return list;
			}
		}			
		list.addAll(getMyVars(context.getContainer()));
		return list;
	}

	private void setDataItem(Element saElement, UserInteraction sa) {
		NodeList userRoles = saElement.getChildNodes();        
		Element userRoleElement = null;
		if (userRoles != null && userRoles.getLength() > 0) {
			for (int i = 0; i < userRoles.getLength(); i++) {
				if (userRoles.item(i).getNodeType() != Node.ELEMENT_NODE)
					continue;
				userRoleElement = (Element)userRoles.item(i);
				if (userRoleElement.getLocalName().equals("dataItem")) {
					DataItem aDataItem = ModelFactory.eINSTANCE
							.createDataItem();
					aDataItem.setElement(userRoleElement);
					// handle the SampleExtensionAttribute
					String dataDesc = ModelPackage.eINSTANCE
							.getDataItem_Description().getName();
					if (userRoleElement.getAttribute(dataDesc) != null) {
						aDataItem.setDescription(userRoleElement.getAttribute(dataDesc));
					}
					
					// handle the SampleExtensionAttribute
					String dataType = ModelPackage.eINSTANCE
							.getDataItem_Type().getName();
					if (userRoleElement.getAttribute(dataType) != null) {
						aDataItem.setType(DataType.STRING_TYPE);
					}
					sa.getData().add(aDataItem);
				}
			}
		}
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
							.getUsableEntity_Roles().getName();
					if (userRoleElement.getAttribute(attName) != null) {
						sa.getRoles().add(userRoleElement.getAttribute(attName));
					}
				}
			}
		}
	}

}
