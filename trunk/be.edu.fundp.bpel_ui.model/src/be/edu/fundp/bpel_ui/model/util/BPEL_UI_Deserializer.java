package be.edu.fundp.bpel_ui.model.util;

import java.util.Map;

import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.extensions.BPELActivityDeserializer;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.bpel.model.util.ImportResolver;
import org.eclipse.bpel.model.util.ImportResolverRegistry;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import be.edu.fundp.bpel_ui.model.ModelFactory;
import be.edu.fundp.bpel_ui.model.NewPick;

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
		 * New Pick
		 */
		if (BPEL_UI_Constants.ND_NEW_PICK.equals(elementType.getLocalPart())) {

			// create a new SampleSimpleActivity model object if not already created
			NewPick pick;
			Element pickElement = (Element)node;
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
			if (activity instanceof NewPick) {
				pick = (NewPick)activity;
			}
			else {
				pick = ModelFactory.eINSTANCE
					.createNewPick();

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
	     				//OnAlarm onAlarm = xml2OnAlarm( pickInstanceElement );
	     				
	     				//pick.getAlarm().add(onAlarm);
	     			}     	
					else if (pickInstanceElement.getLocalName().equals("onMessage")) {
	     				//OnMessage onMessage = xml2OnMessage(pickInstanceElement);
		     			
	     				//pick.getMessages().add(onMessage);
	     			}
					else if (pickInstanceElement.getLocalName().equals("userInteraction")) {
	     				//OnMessage onMessage = xml2OnMessage(pickInstanceElement);
		     			
	     				//pick.getMessages().add(onMessage);
	     			}
	           }
	        }
	        
	        //setStandardAttributes(pickElement, pick);

			return pick;
		}

		System.err.println("Cannot handle this kind of element");
		return null;
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
