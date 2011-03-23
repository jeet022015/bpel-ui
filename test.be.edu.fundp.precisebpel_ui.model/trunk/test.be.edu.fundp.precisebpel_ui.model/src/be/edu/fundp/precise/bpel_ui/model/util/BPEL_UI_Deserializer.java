package be.edu.fundp.precise.bpel_ui.model.util;

import java.util.Map;

import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.extensions.BPELActivityDeserializer;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.bpel.model.util.ImportResolver;
import org.eclipse.bpel.model.util.ImportResolverRegistry;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import be.edu.fundp.precise.bpel_ui.model.DataInputUI;
import be.edu.fundp.precise.bpel_ui.model.DataOutputUI;
import be.edu.fundp.precise.bpel_ui.model.DataSelectionUI;
import be.edu.fundp.precise.bpel_ui.model.ModelFactory;
import be.edu.fundp.precise.bpel_ui.model.ModelPackage;
import be.edu.fundp.precise.bpel_ui.model.OnUserEvent;
import be.edu.fundp.precise.bpel_ui.model.PickUI;
import be.edu.fundp.precise.bpel_ui.model.UserEventType;

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
	               //System.out.println("pickInstanceElement = "+pickInstanceElement.getLocalName());
	               
					if (pickInstanceElement.getLocalName().equals(BPEL_UI_Constants.ND_ON_USER_EVENT)) {
	     					OnUserEvent onUserEvent = xml2OnUserEvent(pickInstanceElement, activity, bpelReader);
	     					sa.getUserInteraction().add(onUserEvent);
	     			}     
	           }
	        }

			return sa;
		}
		
		System.err.println("Cannot handle this kind of element");
		return null;
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
