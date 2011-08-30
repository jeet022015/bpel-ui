package be.edu.fundp.bpel_ui.model.util;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.extensions.BPELActivitySerializer;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.bpel.model.util.BPELUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import be.edu.fundp.bpel_ui.model.NewPick;
import be.edu.fundp.bpel_ui.model.OnUserEvent;

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
		if (activity instanceof NewPick) {

			// create a new DOM element for our Activity
			Element activityElement = document.createElementNS(elementType.getNamespaceURI(),
					BPEL_UI_Constants.ND_NEW_PICK);
			activityElement.setPrefix(BPEL_UI_Utils.addNamespace(process));
			
			NewPick activityPick = (NewPick) activity;

			if (activityPick.isSetCreateInstance()) {
				activityElement.setAttribute("createInstance", BPELUtils
						.boolean2XML(activityPick.getCreateInstance()));
			}
			for (Object next : activityPick.getMessages()) {
				//activityElement.appendChild(onMessage2XML((OnMessage) next));
			}
			for (Object next : activityPick.getAlarm()) {
				//activityElement.appendChild(onAlarm2XML((OnAlarm) next));
			}
			for (OnUserEvent iterable_element : activityPick.getUserInteracion()) {
				//activityElement.appendChild(onUserInteracion2XML(next));
			}
			//addCommonActivityItems(activityElement, activityPick);

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
	}

}
