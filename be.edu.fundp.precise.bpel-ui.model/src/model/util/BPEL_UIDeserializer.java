package model.util;

import java.util.Map;

import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;


import model.DataInputUI;
import model.ModelFactory;
import model.ModelPackage;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.extensions.BPELActivityDeserializer;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.emf.common.util.URI;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BPEL_UIDeserializer implements BPELActivityDeserializer{

	public Activity unmarshall(QName elementType, Node node, Activity activity,
			Process process, Map nsMap, ExtensionRegistry extReg, URI uri,
			BPELReader bpelReader) {
		if (ExtensionsampleConstants.ND_DATA_INPUT_UI.equals(elementType.getLocalPart())) {

			// create a new aDataInputUI model object if not already created
			DataInputUI aDataInputUI;
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
			if (activity instanceof DataInputUI) {
				aDataInputUI = (DataInputUI)activity;
			}
			else {
				aDataInputUI = ModelFactory.eINSTANCE
					.createDataInputUI();

				// attach the DOM node to our new activity
				aDataInputUI.setElement((Element) node);
			}

			// handle the userValidation
			String attName = ModelPackage.eINSTANCE
				.getDataInputUI_UserValidation().getName();
			if (((Element) node).getAttribute(attName) != null) {
				aDataInputUI.setUserValidation(Boolean.parseBoolean(((Element) node)
						.getAttribute(attName)));
			}
			
			// handle the child activity
//			NodeList childElements = sampleStructuredActivityElement.getChildNodes();
//			Element activityElement = null;
//			if (childElements != null && childElements.getLength() > 0) {
//				for (int i = 0; i < childElements.getLength(); i++) {
//
//					// the only element node is the child activity
//					if ((childElements.item(i).getNodeType() == Node.ELEMENT_NODE)) {
//						activityElement = (Element) childElements.item(i);
//						Activity childActivity = bpelReader.xml2Activity(activityElement);
//						if (childActivity != null) {
//							sampleStructuredActivity.setActivity(childActivity);
//						}
//					}
//				}
//			}
			

			return aDataInputUI;
		}
		
		System.err.println("Cannot handle this kind of element");
		return null;
	}

}
