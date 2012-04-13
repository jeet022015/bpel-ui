package be.edu.fundp.precise.uibpel.model.util;

import java.util.Map;

import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.extensions.BPELActivityDeserializer;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.emf.common.util.URI;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.UserInteraction;

/*
 * Bug 120110 - this class has been updated to include a Variable
 * reference for the SampleSimpleActivity and a Variable definition
 * for the SampleStructuredActivity.
 */
public class BpelUiDeserializer implements BPELActivityDeserializer {
		
//	Set <Integer> codes = new HashSet<Integer>();
	BpelUIReader inBpelUIReader = new BpelUIReader();
	
	@Override
	public Activity unmarshall(QName elementType, Node node, Activity activity, Process process,
			Map nsMap, ExtensionRegistry extReg, URI uri, BPELReader bpelReader) {
		
		Process realProcess = null;
		
		if (bpelReader instanceof BpelUIReader) {
			BpelUIReader uiBpelReader = (BpelUIReader) bpelReader;
			inBpelUIReader.setInnerReader(uiBpelReader.getInnerReader());
			realProcess = inBpelUIReader.getInnerProcess();
		} else {
			inBpelUIReader.setInnerReader(bpelReader);
			inBpelUIReader.setInnerProcess(process);
			realProcess = process;
		}
		
		if (activity instanceof UserInteraction) {
			//Pass2
			Element saElement = (Element)node;
			resolveDataItems((UserInteraction)activity, saElement, process);
			return activity;
		}
		/*
		 * DataInputUI
		 */
		if (BpelUiConstants.ND_DATA_INPUT_UI.equals(elementType.getLocalPart())) {

			// create a new DataInputUI model object if not already created
			Element saElement = (Element)node;
			return inBpelUIReader.xml2DataInputUI(activity,saElement, realProcess);
			//return sa;
		}
		
		/*
		 * DataOutputUI
		 */
		if (BpelUiConstants.ND_DATA_OUTPUT_UI.equals(elementType.getLocalPart())) {
			// create a new DataInputUI model object if not already created
			Element saElement = (Element)node;
			return inBpelUIReader.xml2DataOutputUI(activity,saElement, realProcess);
		}
		
		/*
		 * DataSelectionUI
		 */
		if (BpelUiConstants.ND_DATA_SELECTION_UI.equals(elementType.getLocalPart())) {

			// create a new SampleSimpleActivity model object if not already created
			Element saElement = (Element)node;
			return inBpelUIReader.xml2DataSelectionUI(activity,saElement, realProcess);
		}
		
		/*
		 * PickUI
		 */
		if (BpelUiConstants.ND_PICK_UI.equals(elementType.getLocalPart())) {
			Element saElement = (Element)node;
			return inBpelUIReader.xml2PickUI(activity,saElement, realProcess);
		}
		
		/*
		 * ScopeUI
		 */
		if (BpelUiConstants.ND_SCOPE_UI.equals(elementType.getLocalPart())) {
			Element saElement = (Element)node;
			Activity scope = inBpelUIReader.xml2ScopeUI(saElement);
			inBpelUIReader.myPass2();
			return scope;
		}

		System.err.println("Cannot handle this kind of element");
		return null;
	}

	private void resolveDataItems(UserInteraction activity, Element saElement, Process process) {
		if (activity instanceof DataOutputUI){
			inBpelUIReader.readOutputDataItems((DataOutputUI)activity, saElement);
		}
		if (activity instanceof DataInputUI){
			inBpelUIReader.readInputDataItems((DataInputUI)activity, saElement);
		}
	}
}
