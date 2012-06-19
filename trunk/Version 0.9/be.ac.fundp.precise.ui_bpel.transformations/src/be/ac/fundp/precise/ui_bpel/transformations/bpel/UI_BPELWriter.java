package be.ac.fundp.precise.ui_bpel.transformations.bpel;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.wst.wsdl.Definition;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import be.ac.fundp.precise.ui_bpel.transformations.bpel.bpelEntities.PartnerEntity;
import be.ac.fundp.precise.ui_bpel.transformations.bpel.bpelEntities.PartnerManager;
import be.ac.fundp.precise.ui_bpel.transformations.bpel.parsers.CommonConcepts;
import be.ac.fundp.precise.ui_bpel.transformations.bpel.parsers.DataInputUIParser;
import be.ac.fundp.precise.ui_bpel.transformations.bpel.parsers.DataOutputUIParser;
import be.ac.fundp.precise.ui_bpel.transformations.bpel.parsers.DataSelectionUIParser;
import be.ac.fundp.precise.ui_bpel.transformations.bpel.parsers.ScopeUIParser;
import be.ac.fundp.precise.ui_bpel.transformations.bpel.parsers.StarterDataInputUIParser;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;
import be.edu.fundp.precise.uibpel.model.ScopeUI;

public class UI_BPELWriter extends BPELWriter {

	private PartnerManager partnerManager;
	private BPELResource resource;
	protected List<Element> elementVariables = new LinkedList<Element>();
	protected List<CorrelationSet> correlationSetsElements = new LinkedList<CorrelationSet>();
	protected CommonConcepts concepts = CommonConcepts.getInstance();

	public UI_BPELWriter(File newProcessWsdl, BPELResource resource)
			throws IOException {
		super();
		URI uri = URI.createFileURI(newProcessWsdl.getCanonicalPath());
		Definition processWSDl = UI_BPELUtil.attemptLoadWSDL(uri,
				resource.getResourceSet());
		this.resource = resource;
		partnerManager = new PartnerManager(processWSDl);

	}

	public void write(OutputStream out, Map<?, ?> args) throws IOException {
		super.write(resource, out, args);
	}

	@Override
	protected Element process2XML(Process process) {
		Element processElement = super.process2XML(process);
		addImports(processElement);
		addUiBpelPartnerLinks(processElement);
		addNewVariables(processElement);
		addNewCorrelations(processElement);
		return processElement;
	}

	private void addNewCorrelations(Element processElement) {
		Element correlationSetsElem = getElement(processElement,
				"correlationSets");
		if (correlationSetsElem == null) {
			System.out.println("is null");
			CorrelationSets cs = BPELFactory.eINSTANCE.createCorrelationSets();
			cs.getChildren().addAll(correlationSetsElements);
			cs.getChildren().add(concepts.getProcessIdCorrelationSet(null));
			processElement.appendChild(correlationSets2XML(cs));
		} else {
			for (CorrelationSet aCorrelSetElement : correlationSetsElements) {
				correlationSetsElem
						.appendChild(correlationSet2XML(aCorrelSetElement));
			}
			correlationSetsElem.appendChild(correlationSet2XML(concepts
					.getProcessIdCorrelationSet(null)));
		}
	}

	@Override
	protected Element extensionActivity2XML(ExtensionActivity activity) {
		if (activity instanceof DataSelectionUI) {
			return dataSelectionUI2XML((DataSelectionUI) activity);
		} else if (activity instanceof DataOutputUI) {
			return dataOutputUI2XML((DataOutputUI) activity);
		} else if (activity instanceof DataInputUI) {
			DataInputUI dataInput = (DataInputUI) activity;
			if (dataInput.isCreateInstance())
				return starterDataInputUI2XML((DataInputUI) activity);
			else
				return dataInputUI2XML((DataInputUI) activity);
		} else if (activity instanceof ScopeUI) {
			return scopeUI2XML((ScopeUI) activity);
		}
		return super.extensionActivity2XML(activity);
	}

	private Element scopeUI2XML(ScopeUI activity) {
		Element scopeElement = scope2XML(activity);
		PartnerEntity processOperationPartner = partnerManager
				.getPartner("ProcessOperation");
		ScopeUIParser parser = new ScopeUIParser(activity,
				processOperationPartner);
		for (OnEvent anOnEvent : parser.getOnEvents()) {
			Element processElement = getElement(scopeElement, "eventHandlers");
			processElement.appendChild(onEvent2XML(anOnEvent));
		}
		for (Variable anOnEventVar : parser.getOnUserEventVars()) {
			elementVariables.add(variable2XML(anOnEventVar));
		}
		for (CorrelationSet anOnEventCorrelationSet : parser
				.getOnEventCorrelationSets()) {
			correlationSetsElements.add(anOnEventCorrelationSet);
		}
		return scopeElement;
	}

	private Element dataInputUI2XML(DataInputUI activity) {
		PartnerEntity uiManagerPartner = partnerManager.getPartner("UiManager");
		DataInputUIParser parser = new DataInputUIParser(activity,
				uiManagerPartner);
		Variable inputVariable = parser.getInputVar();
		Variable outputVariable = parser.getOutputVar();
		elementVariables.add(variable2XML(inputVariable));
		elementVariables.add(variable2XML(outputVariable));

		CorrelationSet correlations = parser.getCorrelationSet();
		correlationSetsElements.add(correlations);
		Activity newAct = parser.getActivity();
		return activity2XML(newAct);
	}

	private Element starterDataInputUI2XML(DataInputUI activity) {
		PartnerEntity uiManagerPartner = partnerManager.getPartner("UiManager");
		PartnerEntity processOpPartner = partnerManager
				.getPartner("ProcessOperation");
		StarterDataInputUIParser parser = new StarterDataInputUIParser(
				activity, uiManagerPartner, processOpPartner);
		Variable inputVariable = parser.getInputVar();
		Variable outputVariable = parser.getOutputVar();
		Variable startVariable = parser.getReceiveVar();
		elementVariables.add(variable2XML(inputVariable));
		elementVariables.add(variable2XML(outputVariable));
		elementVariables.add(variable2XML(startVariable));

		CorrelationSet correlations = parser.getCorrelationSet();
		correlationSetsElements.add(correlations);
		Activity newAct = parser.getActivity();
		return activity2XML(newAct);
	}

	private Element dataOutputUI2XML(DataOutputUI activity) {
		PartnerEntity uiManagerPartner = partnerManager.getPartner("UiManager");
		DataOutputUIParser parser = new DataOutputUIParser(activity,
				uiManagerPartner);
		Variable inputVariable = parser.getInputVar();
		Variable outputVariable = parser.getOutputVar();
		elementVariables.add(variable2XML(inputVariable));
		elementVariables.add(variable2XML(outputVariable));

		CorrelationSet correlations = parser.getCorrelationSet();
		correlationSetsElements.add(correlations);
		Activity newAct = parser.getActivity();
		return activity2XML(newAct);
	}

	private Element dataSelectionUI2XML(DataSelectionUI activity) {
		PartnerEntity uiManagerPartner = partnerManager.getPartner("UiManager");
		DataSelectionUIParser parser = new DataSelectionUIParser(activity,
				uiManagerPartner);
		Variable inputVariable = parser.getInputVar();
		Variable outputVariable = parser.getOutputVar();
		elementVariables.add(variable2XML(inputVariable));
		elementVariables.add(variable2XML(outputVariable));

		CorrelationSet correlations = parser.getCorrelationSet();
		correlationSetsElements.add(correlations);
		Activity newAct = parser.getActivity();
		return activity2XML(newAct);
	}

	private void addNewVariables(Element processElement) {
		Element processVariables = getElement(processElement, "variables");
		if (processVariables == null) {
			processVariables = createBPELElement("variables");
			processElement.appendChild(processVariables);
		}
		for (Element aElementVar : elementVariables) {
			processVariables.appendChild(aElementVar);
		}
		Variable varIn = concepts.getInputGenVar(null);
		Variable varOut = concepts.getOutputGenVar(null);
		processVariables.appendChild(variable2XML(varIn));
		processVariables.appendChild(variable2XML(varOut));
	}

	private void addUiBpelPartnerLinks(Element processElement) {
		Element partnerLinksElement = getElement(processElement, "partnerLinks");
		if (partnerLinksElement == null) {
			partnerLinksElement = createBPELElement("partnerLinks");
			processElement.appendChild(partnerLinksElement);
		}
		for (PartnerEntity aPartner : partnerManager.getPartners()) {
			partnerLinksElement.appendChild(partnerLink2XML(aPartner
					.getPartnerLink()));
		}
	}

	private Element getElement(Element processElement, String elementName) {
		NodeList childs2 = processElement.getChildNodes();
		for (int i = 0; i < childs2.getLength(); i++) {
			Node aNode = childs2.item(i);
			if (aNode.getLocalName().equals(elementName))
				return (Element) aNode;
		}
		return null;
	}

	private void addImports(Element processElement) {
		for (PartnerEntity aPartner : partnerManager.getPartners()) {
			processElement.appendChild(import2XML(aPartner.getImport()));
		}
	}

	public void addPartner(String partnerName, File newUiManagerWsdl,
			boolean isMyRole) throws IOException {
		URI uri = URI.createFileURI(newUiManagerWsdl.getCanonicalPath());
		Definition partnerDefinition = UI_BPELUtil.attemptLoadWSDL(uri,
				resource.getResourceSet());
		partnerManager.addPartner(partnerName, isMyRole, partnerDefinition);
	}
}
