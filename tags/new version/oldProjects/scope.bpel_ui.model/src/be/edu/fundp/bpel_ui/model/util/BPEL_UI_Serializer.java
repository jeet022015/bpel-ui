package be.edu.fundp.bpel_ui.model.util;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.extensions.BPELActivitySerializer;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import be.edu.fundp.bpel_ui.model.NewPick;
import be.edu.fundp.bpel_ui.model.NewScope;
import be.edu.fundp.bpel_ui.model.OnUserEvent;
import be.edu.fundp.bpel_ui.model.impl.NewEventHandlerImpl;

/*
 * Bug 120110 - this class has been updated to include a Variable
 * reference for the SampleSimpleActivity and a Variable definition
 * for the SampleStructuredActivity.
 */
public class BPEL_UI_Serializer implements BPELActivitySerializer {

	@Override
	public void marshall(QName elementType, Activity activity, Node parentNode, Process process,
			BPELWriter bpelWriter) {

		Document document = parentNode.getOwnerDocument();
		
		/*
		 * NewPick
		 */
		if (activity instanceof NewEventHandlerImpl) {

			// create a new DOM element for our Activity
			Element activityElement = document.createElementNS(elementType.getNamespaceURI(),
					BPELConstants.ND_EVENT_HANDLERS);
			activityElement.setPrefix(BPEL_UI_Utils.addNamespace(process));
			
			NewEventHandlerImpl onUserEvent = (NewEventHandlerImpl) activity;
			
			//if (onUserEvent.getID() != null) {
				//onEventElement.setAttribute("partnerLink", onEvent.getPartnerLink()
				//		.getName());
			//}

			// insert the DOM element into the DOM tree
			parentNode.appendChild(activityElement);
		}
		
		/*
		 * NewPick
		 */
		if (activity instanceof OnUserEvent) {

			// create a new DOM element for our Activity
			Element activityElement = document.createElementNS(elementType.getNamespaceURI(),
					BPEL_UI_Constants.ND_USER_INTERACTION);
			activityElement.setPrefix(BPEL_UI_Utils.addNamespace(process));
			
			OnUserEvent onUserEvent = (OnUserEvent) activity;
			
			if (onUserEvent.getID() != null) {
				//onEventElement.setAttribute("partnerLink", onEvent.getPartnerLink()
				//		.getName());
			}

			// insert the DOM element into the DOM tree
			parentNode.appendChild(activityElement);
		}
		
		if (activity instanceof NewScope) {;

			// create a new DOM element for our Activity
			Element activityElement = document.createElementNS(elementType.getNamespaceURI(),
					BPEL_UI_Constants.ND_NEW_SCOPE);
			activityElement.setPrefix(BPEL_UI_Utils.addNamespace(process));
			
			NewScope activity2 = (NewScope) activity;
			
			if (activity2.isSetIsolated())
				//activityElement.setAttribute("isolated", BPELUtils
				//		.boolean2XML(activity.getIsolated()));
			if (activity2.isSetExitOnStandardFault())
				//activityElement.setAttribute("exitOnStandardFault", BPELUtils
				//		.boolean2XML(activity.getExitOnStandardFault()));
			if (activity2.getVariables() != null
					&& !activity2.getVariables().getChildren().isEmpty())
				//activityElement.appendChild(variables2XML(activity.getVariables()));
			if (activity2.getCorrelationSets() != null
					&& !activity2.getCorrelationSets().getChildren().isEmpty())
				//activityElement.appendChild(correlationSets2XML(activity
				//		.getCorrelationSets()));
			if (activity2.getPartnerLinks() != null
					&& !activity2.getPartnerLinks().getChildren().isEmpty())
				//activityElement.appendChild(partnerLinks2XML(activity
				//		.getPartnerLinks()));
			if (activity2.getFaultHandlers() != null)
				//activityElement.appendChild(faultHandlers2XML(activity
				//		.getFaultHandlers()));
			if (activity2.getCompensationHandler() != null)
				//activityElement.appendChild(compensationHandler2XML(activity
				//		.getCompensationHandler()));
			if (activity2.getTerminationHandler() != null)
				//activityElement.appendChild(terminationHandler2XML(activity
				//		.getTerminationHandler()));
			if (activity2.getEventHandlers() != null)
				//activityElement.appendChild(eventHandler2XML(activity
				//		.getEventHandlers()));
			if (activity2.getMessageExchanges() != null
					&& !activity2.getMessageExchanges().getChildren().isEmpty())
				//activityElement.appendChild(messageExchanges2XML(activity
				//		.getMessageExchanges()));
			if (activity2.getActivity() != null)
				//activityElement.appendChild(activity2XML(activity.getActivity()));

			//addCommonActivityItems(activityElement, activity);

			// insert the DOM element into the DOM tree
			System.out.println("activity Element = "+activityElement);
			parentNode.appendChild(activityElement);
		}
	}

}
