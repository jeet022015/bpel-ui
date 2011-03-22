package be.edu.fundp.precise.bpel_ui.model.util;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.extensions.BPELActivitySerializer;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import be.edu.fundp.precise.bpel_ui.model.DataInputUI;
import be.edu.fundp.precise.bpel_ui.model.DataOutputUI;
import be.edu.fundp.precise.bpel_ui.model.ModelPackage;

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
		 * DataInputUI
		 */
		if (activity instanceof DataInputUI) {
			DataInputUI sa = (DataInputUI)activity;

			// create a new DOM element for our Activity
			Element saElement = document.createElementNS(elementType.getNamespaceURI(),
					BPEL_UI_Constants.ND_DATA_INPUT_UI);
			saElement.setPrefix(BPEL_UI_Utils.addNamespace(process));

			// handle the InputVariable
			if (sa.getInputVariable() != null) {
				String name = sa.getInputVariable().getName();
				if (name != null && !"".equals(name.trim()))
					saElement.setAttribute(ModelPackage.eINSTANCE.
							getDataInputUI_InputVariable().getName(), name);
			}
			
			//TODO and the User Role

			// insert the DOM element into the DOM tree
			parentNode.appendChild(saElement);
		}
		
		/*
		 * DataOutputUI
		 */
		if (activity instanceof DataOutputUI) {
			DataOutputUI sa = (DataOutputUI)activity;

			// create a new DOM element for our Activity
			Element saElement = document.createElementNS(elementType.getNamespaceURI(),
					BPEL_UI_Constants.ND_DATA_OUTPUT_UI);
			saElement.setPrefix(BPEL_UI_Utils.addNamespace(process));

			// handle the InputVariable
			if (sa.getOutputVariable() != null) {
				String name = sa.getOutputVariable().getName();
				if (name != null && !"".equals(name.trim()))
					saElement.setAttribute(ModelPackage.eINSTANCE.
							getDataOutputUI_OutputVariable().getName(), name);
			}
			
			//TODO and the User Role

			// insert the DOM element into the DOM tree
			parentNode.appendChild(saElement);
		}
	}

}
