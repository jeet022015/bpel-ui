package be.edu.fundp.bpel_ui.model.util;

import java.util.Map;

import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.model.Variables;
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
import be.edu.fundp.bpel_ui.model.NewScope;

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
		if (BPEL_UI_Constants.ND_NEW_SCOPE.equals(elementType.getLocalPart())) {

			// create a new SampleSimpleActivity model object if not already created
			NewScope scope;
			Element scopeElement = (Element)node;
			
			if (activity instanceof NewScope) {
				scope = (NewScope)activity;
			}
			else {
				scope = ModelFactory.eINSTANCE
					.createNewScope();

				// attach the DOM node to our new activity
				scope.setElement(scopeElement);
			}
			
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
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
			//Element variablesElement = getBPELChildElementByLocalName(scopeElement, "variables");
			//if (variablesElement != null) {
			//	Variables variables = xml2Variables(variablesElement);
			//	scope.setVariables(variables);
			//}
					
			// Handle CorrelationSet element
			//Element correlationSetsElement = getBPELChildElementByLocalName(scopeElement, "correlationSets");
			//if (correlationSetsElement != null) {
			//	CorrelationSets correlationSets = xml2CorrelationSets(correlationSetsElement);
			//	scope.setCorrelationSets(correlationSets);
			//}
			
			// Handle PartnerLinks element
			//Element partnerLinksElement = getBPELChildElementByLocalName(scopeElement, "partnerLinks");
			//if (partnerLinksElement != null) {
			//	PartnerLinks partnerLinks = xml2PartnerLinks(partnerLinksElement);
			//	scope.setPartnerLinks(partnerLinks);
			//}
			
			// MessageExchanges element
			//Element messageExchangesElement = getBPELChildElementByLocalName(scopeElement, "messageExchanges");
			//if (messageExchangesElement != null) {
			//	MessageExchanges messageExchanges = xml2MessageExchanges(messageExchangesElement);
			//	scope.setMessageExchanges(messageExchanges);
			//}
					
			// Handle FaultHandler element
	        //Element faultHandlerElement = getBPELChildElementByLocalName(scopeElement, "faultHandlers");
	        //if (faultHandlerElement != null) {               		
			//	FaultHandler faultHandler =	xml2FaultHandler(faultHandlerElement); 
			//	scope.setFaultHandlers(faultHandler);
	        //}

			// Handle CompensationHandler element
			//setCompensationHandler(scopeElement, scope);
			
			// Handler TerminationHandler element
			//Element terminationHandlerElement = getBPELChildElementByLocalName(scopeElement, "terminationHandler");
			//if (terminationHandlerElement != null) {
			//	TerminationHandler terminationHandler = xml2TerminationHandler(terminationHandlerElement);
			//	scope.setTerminationHandler(terminationHandler);
			//}
			
			// Handler EventHandler element
			//setEventHandler(scopeElement, scope);
			
			//setStandardAttributes(scopeElement, scope);

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
	               
	               Activity activity2 = bpelReader.xml2Activity(activityElement);
	               if (activity != null) { 
	               		//scope.setActivity(activity2);
	               		break;
	               }
	           }
	        }
			return scope;
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
