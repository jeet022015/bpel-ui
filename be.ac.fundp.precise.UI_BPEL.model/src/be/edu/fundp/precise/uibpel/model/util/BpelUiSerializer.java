package be.edu.fundp.precise.uibpel.model.util;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.extensions.BPELActivitySerializer;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.emf.common.util.EList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;
import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.UsableEntity;
import be.edu.fundp.precise.uibpel.model.UserInteraction;

/*
 * Bug 120110 - this class has been updated to include a Variable
 * reference for the SampleSimpleActivity and a Variable definition
 * for the SampleStructuredActivity.
 */
public class BpelUiSerializer implements BPELActivitySerializer {

	@Override
	public void marshall(QName elementType, Activity activity,
			Node parentNode, Process process,
			BPELWriter bpelWriter) {

		Document document = parentNode.getOwnerDocument();
		Element saElement = null;

		/*
		 * DataSelectionUI
		 */
		if (activity instanceof DataSelectionUI) {
			DataSelectionUI sa = (DataSelectionUI)activity;

			if(saElement == null){
				// create a new DOM element for our Activity
				saElement = document.createElementNS(elementType.getNamespaceURI(),
						BpelUiConstants.ND_DATA_SELECTION_UI);
				saElement.setPrefix(BpelUiUtils.addNamespace(process));
			}

			String attMaxCardi = ModelPackage.eINSTANCE
				.getDataSelectionUI_MaxCardinality().getName();
			saElement.setAttribute(attMaxCardi, Integer.toString(sa.getMaxCardinality()));
			
			String attMinCardi = ModelPackage.eINSTANCE
				.getDataSelectionUI_MinCardinality().getName();
			saElement.setAttribute(attMinCardi, Integer.toString(sa.getMinCardinality()));
		}
		
		/*
		 * DataInputUI
		 */
		if (activity instanceof DataInputUI) {
			DataInputUI sa = (DataInputUI)activity;

			if(saElement == null){
				// create a new DOM element for our Activity
				saElement = document.createElementNS(elementType.getNamespaceURI(),
						BpelUiConstants.ND_DATA_INPUT_UI);
				saElement.setPrefix(BpelUiUtils.addNamespace(process));
			}

			// handle the InputVariable
			if (sa.getInputVariable() != null) {
				String name = sa.getInputVariable().getName();
				if (name != null && !"".equals(name.trim()))
					saElement.setAttribute(ModelPackage.eINSTANCE.
							getDataInputUI_InputVariable().getName(), name);
			}
			
		}
		
		/*
		 * DataOutputUI
		 */
		if (activity instanceof DataOutputUI) {
			DataOutputUI sa = (DataOutputUI)activity;

			if(saElement == null){
				// create a new DOM element for our Activity
				saElement = document.createElementNS(elementType.getNamespaceURI(),
						BpelUiConstants.ND_DATA_OUTPUT_UI);
				saElement.setPrefix(BpelUiUtils.addNamespace(process));
			}

			// handle the InputVariable
			if (sa.getOutputVariable() != null) {
				String name = sa.getOutputVariable().getName();
				if (name != null && !"".equals(name.trim()))
					saElement.setAttribute(ModelPackage.eINSTANCE.
							getDataOutputUI_OutputVariable().getName(), name);
			}
		}
		
		/*
		 * UserInteraction
		 */
		if (activity instanceof UserInteraction) {
			UserInteraction sa = (UserInteraction)activity;
			if(saElement != null){
				EList<DataItem> datas = sa.getData();
				for (DataItem dataItem : datas) {
					saElement.appendChild(dataItem2XML(dataItem,
							document,elementType.getNamespaceURI(),process,bpelWriter));
				}
			}
		}
		
		/*
		 * UsableEntity
		 */
		if (activity instanceof UsableEntity) {
			UsableEntity sa = (UsableEntity)activity;
			
			if(saElement != null){
				String attMaxCardi = ModelPackage.eINSTANCE
						.getUsableEntity_Id().getName();
				saElement.setAttribute(attMaxCardi, sa.getId());
				
				EList<String> roles = sa.getRoles();
				for (String role : roles) {
					Element saElement2 = document.createElementNS(elementType.getNamespaceURI(),
							BpelUiConstants.ND_USER_ROLE);
					saElement2.setPrefix(BpelUiUtils.addNamespace(process));
					saElement2.setAttribute(ModelPackage.eINSTANCE.
							getUsableEntity_Roles().getName(), role);
					saElement.appendChild(saElement2);
				}
			}
		}
		
		//NEVER DELETE IT NETO!!!!
		// insert the DOM element into the DOM tree
		parentNode.appendChild(saElement);
	}

	public Node dataItem2XML(DataItem dataItem, Document document,
			String namespaceURI, Process process, BPELWriter bpelWriter) {
		Element saElement = document.createElementNS(namespaceURI,
				BpelUiConstants.ND_DATA_ITEM);
		saElement.setPrefix(BpelUiUtils.addNamespace(process));
		
		if (dataItem.getDescription() != null) {
			saElement.setAttribute(ModelPackage.eINSTANCE.
					getDataItem_Description().getName(), dataItem.getDescription());
		}
		if (dataItem.getType() != null) {
			saElement.setAttribute(ModelPackage.eINSTANCE.
					getDataItem_Type().getName(), dataItem.getType().getLiteral());
		}
		return saElement;
	}
}
