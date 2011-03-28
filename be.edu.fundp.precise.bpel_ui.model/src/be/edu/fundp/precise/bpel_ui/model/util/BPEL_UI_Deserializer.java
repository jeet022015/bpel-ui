package be.edu.fundp.precise.bpel_ui.model.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.extensions.BPELActivityDeserializer;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ImportResolver;
import org.eclipse.bpel.model.util.ImportResolverRegistry;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsd.util.XSDConstants;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import be.edu.fundp.precise.bpel_ui.model.DataInputUI;
import be.edu.fundp.precise.bpel_ui.model.DataOutputUI;
import be.edu.fundp.precise.bpel_ui.model.DataSelectionUI;
import be.edu.fundp.precise.bpel_ui.model.EventHandlerUI;
import be.edu.fundp.precise.bpel_ui.model.ModelFactory;
import be.edu.fundp.precise.bpel_ui.model.ModelPackage;
import be.edu.fundp.precise.bpel_ui.model.OnUserEvent;
import be.edu.fundp.precise.bpel_ui.model.PickUI;
import be.edu.fundp.precise.bpel_ui.model.ScopeUI;
import be.edu.fundp.precise.bpel_ui.model.UserEventType;
import be.edu.fundp.precise.bpel_ui.model.UserInteraction;
import be.edu.fundp.precise.bpel_ui.model.UserRole;

/*
 * Bug 120110 - this class has been updated to include a Variable
 * reference for the SampleSimpleActivity and a Variable definition
 * for the SampleStructuredActivity.
 */
public class BPEL_UI_Deserializer implements BPELActivityDeserializer {

	@Override
	public Activity unmarshall(QName elementType, Node node, Activity activity, Process process,
			Map nsMap, ExtensionRegistry extReg, URI uri, BPELReader bpelReader) {
		
		/*
		 * DataInputUI
		 */
		if (BPEL_UI_Constants.ND_DATA_SELECTION_UI.equals(elementType.getLocalPart())) {

			// create a new DataInputUI model object if not already created
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
			
			// handle variable name: find this variable is in a visible scope
			String value = saElement.getAttribute("inputVariable");
			if (value!=null && !"".equals(value.trim())) {
				Variable[] vars = ModelHelper.getVisibleVariables(activity);
				for (int i=vars.length-1; i>=0; --i) {
					if (value.equals(vars[i].getName())) {
						sa.setInputVariable(vars[i]);
						break;
					}
				}
			}
			
			// handle variable name: find this variable is in a visible scope
			value = saElement.getAttribute("outputVariable");
			if (value!=null && !"".equals(value.trim())) {
				Variable[] vars = ModelHelper.getVisibleVariables(activity);
				for (int i=vars.length-1; i>=0; --i) {
					if (value.equals(vars[i].getName())) {
						sa.setOutputVariable(vars[i]);
						break;
					}
				}
			}
			
			setUserRole(saElement, sa);
			
			//TODO UserRole

			return sa;
		}
		
		/*
		 * DataInputUI
		 */
		if (BPEL_UI_Constants.ND_DATA_INPUT_UI.equals(elementType.getLocalPart())) {

			// create a new DataInputUI model object if not already created
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
			String value = saElement.getAttribute("inputVariable");
			if (value!=null && !"".equals(value.trim())) {
				Variable[] vars = ModelHelper.getVisibleVariables(activity);
				for (int i=vars.length-1; i>=0; --i) {
					if (value.equals(vars[i].getName())) {
						sa.setInputVariable(vars[i]);
						break;
					}
				}
			}
			
			setUserRole(saElement, sa);

			return sa;
		}
		
		/*
		 * DataOutputUI
		 */
		if (BPEL_UI_Constants.ND_DATA_OUTPUT_UI.equals(elementType.getLocalPart())) {

			// create a new DataOutputUI model object if not already created
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
			String value = saElement.getAttribute("outputVariable");
			if (value!=null && !"".equals(value.trim())) {
				Variable[] vars = ModelHelper.getVisibleVariables(activity);
				for (int i=vars.length-1; i>=0; --i) {
					if (value.equals(vars[i].getName())) {
						sa.setOutputVariable(vars[i]);
						break;
					}
				}
			}
			setUserRole(saElement, sa);

			return sa;
		}
		
		/*
		 * PickUI
		 */
		if (BPEL_UI_Constants.ND_PICK_UI.equals(elementType.getLocalPart())) {

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
	               
					if (pickInstanceElement.getLocalName().equals(BPEL_UI_Constants.ND_ON_USER_EVENT)) {
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
		if (BPEL_UI_Constants.ND_SCOPE_UI.equals(elementType.getLocalPart())) {

			// create a new DataOutputUI model object if not already created
			ScopeUI sa;
			Element saElement = (Element)node;
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
			if(activity != null && activity instanceof ScopeUI){
				sa = (ScopeUI)activity;
			}else {
				sa = ModelFactory.eINSTANCE
					.createScopeUI();
				// attach the DOM node to our new activity
				sa.setElement(saElement);
			}
			
			// Handler EventHandler element
			setEventHandler(saElement, sa, bpelReader);

			return sa;
		}
		
		System.err.println("Cannot handle this kind of element");
		return null;
	}

	private void setUserRole(Element saElement, UserInteraction sa) {
		NodeList userRoles = saElement.getChildNodes();        
		Element userRoleElement = null;
		if (userRoles != null && userRoles.getLength() > 0) {
          
			for (int i = 0; i < userRoles.getLength(); i++) {
				if (userRoles.item(i).getNodeType() != Node.ELEMENT_NODE)
					continue;           	   	             
			   	userRoleElement = (Element)userRoles.item(i);
				if (userRoleElement.getLocalName().equals("userRole")) {
					UserRole aUserRole = ModelFactory.eINSTANCE
							.createUserRole();
					// handle the SampleExtensionAttribute
					String attName = ModelPackage.eINSTANCE
							.getUserRole_Id().getName();
					if (userRoleElement.getAttribute(attName) != null) {
						aUserRole.setId(userRoleElement.getAttribute(attName));
					}
					sa.getRole().add(aUserRole);
				}
			}
		}
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
		saveNamespacePrefix(eventHandler, eventHandlerElement);			
	
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

	private void saveNamespacePrefix(EObject eObject, Element element) {
		Map<String,String> nsMap = null; // lazy init since it may require a new map
		NamedNodeMap attrs = element.getAttributes();
		
		for (int i=0; i < attrs.getLength(); i++) {
			Attr attr = (Attr) attrs.item(i);        
			// XML namespace attributes use the reserved namespace "http://www.w3.org/2000/xmlns/". 
			if (XSDConstants.XMLNS_URI_2000.equals(attr.getNamespaceURI())) {
				if (nsMap == null) {
					nsMap = BPELUtils.getNamespaceMap(eObject);
				}
				nsMap.put(BPELUtils.getNSPrefixMapKey(attr.getLocalName()), attr.getValue());
			}
		}
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

	private OnUserEvent xml2OnUserEvent(Element pickInstanceElement, Activity activity, BPELReader bpelReader) {
		// create a new DataOutputUI model object if not already created
		OnUserEvent sa = ModelFactory.eINSTANCE
			.createOnUserEvent();
		sa.setElement(pickInstanceElement);
		
		// handle the ID
		String attName = ModelPackage.eINSTANCE
				.getOnUserEvent_Id().getName();
		if (pickInstanceElement.getAttribute(attName) != null) {
			sa.setId(pickInstanceElement.getAttribute(attName));
		}
		
		// handle the Type
		attName = ModelPackage.eINSTANCE
				.getOnUserEvent_Type().getName();
		if (pickInstanceElement.getAttribute(attName) != null) {
			sa.setType(UserEventType.getByName(pickInstanceElement.getAttribute(attName)));
		}
		
		// handle variable name: find this variable is in a visible scope
		String value = pickInstanceElement.getAttribute("variable");
		if (value!=null && !"".equals(value.trim())) {
			Variable[] vars = ModelHelper.getVisibleVariables(activity);
			for (int i=vars.length-1; i>=0; --i) {
				if (value.equals(vars[i].getName())) {
					sa.setVariable(vars[i]);
					break;
				}
			}
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

	static EObject scanImports( Process process, QName qname , String refType ) {
		
		EObject result = null;
		
		for(Object n : process.getImports()) {
            Import imp = (Import) n;                                    
            if (imp.getLocation() == null ) {
            	continue;
            }
            
    	    ImportResolver[] resolvers = ImportResolverRegistry.INSTANCE.getResolvers(imp.getImportType());
    	    for(ImportResolver r : resolvers) {
                result = r.resolve(imp, qname, null, refType);
                if (result != null) {
                	return result;
                }                
            }
    	    
        } 
        
        return null;
	}

}
