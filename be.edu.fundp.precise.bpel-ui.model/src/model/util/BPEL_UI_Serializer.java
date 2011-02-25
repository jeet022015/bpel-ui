package model.util;

import javax.xml.namespace.QName;

import model.DataInputUI;
import model.ModelPackage;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.extensions.BPELActivitySerializer;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class BPEL_UI_Serializer implements BPELActivitySerializer{

	public void marshall(QName elementType, Activity activity, Node parentNode,
			Process process, BPELWriter bpelWriter) {
		Document document = parentNode.getOwnerDocument();

		/*
		 * SampleSimpleActivity
		 */
		if (activity instanceof DataInputUI) {

			// create a new DOM element for our Activity
			Element activityElement = document.createElementNS(elementType.getNamespaceURI(),
					ExtensionsampleConstants.ND_DATA_INPUT_UI);
			activityElement.setPrefix(ExtensionSampleUtils.addNamespace(process));

			// handle the SampleExtensionAttribute
			String attName = ModelPackage.eINSTANCE
					.getDataInputUI_UserValidation().getName();
			activityElement.setAttribute(attName, Boolean.toString(((DataInputUI) activity)
					.isUserValidation()));

			// insert the DOM element into the DOM tree
			parentNode.appendChild(activityElement);
		}
	}

}
