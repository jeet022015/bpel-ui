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
import be.edu.fundp.precise.uibpel.model.PickUI;
import be.edu.fundp.precise.uibpel.model.ScopeUI;
import be.edu.fundp.precise.uibpel.model.UserInteraction;

/*
 * Bug 120110 - this class has been updated to include a Variable
 * reference for the SampleSimpleActivity and a Variable definition
 * for the SampleStructuredActivity.
 */
/**
 * The Class BpelUiDeserializer.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class BpelUiDeserializer implements BPELActivityDeserializer {
		
//	Set <Integer> codes = new HashSet<Integer>();
	/** The in bpel ui reader. */
BpelUIReader inBpelUIReader = new BpelUIReader();
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.extensions.BPELActivityDeserializer#unmarshall(javax.xml.namespace.QName, org.w3c.dom.Node, org.eclipse.bpel.model.Activity, org.eclipse.bpel.model.Process, java.util.Map, javax.wsdl.extensions.ExtensionRegistry, org.eclipse.emf.common.util.URI, org.eclipse.bpel.model.resource.BPELReader)
	 */
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
		
		if (activity instanceof PickUI || activity instanceof ScopeUI) {
			//Pass2
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
			inBpelUIReader.myPass2();
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

	/**
	 * Resolve data items.
	 *
	 * @param activity the activity
	 * @param saElement the sa element
	 * @param process the process
	 */
	private void resolveDataItems(UserInteraction activity, Element saElement, Process process) {
		if (activity instanceof DataOutputUI){
			inBpelUIReader.readOutputDataItems((DataOutputUI)activity, saElement);
		}
		if (activity instanceof DataInputUI){
			inBpelUIReader.readInputDataItems((DataInputUI)activity, saElement);
		}
	}
}
