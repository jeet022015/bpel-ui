package be.ac.fundp.precise.ui_bpel.transformations.bpel.parsers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.CorrelationPattern;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.ui.properties.CorrelationSection;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;

import be.ac.fundp.precise.ui_bpel.transformations.bpel.bpelEntities.PartnerEntity;
import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.ScopeUI;

public class ScopeUIParser {

	private static final String CORRELATION_ON_USER_EVENT_OPERATION = "correlationSet";
	private List<Variable> onUserEventVars = new LinkedList<Variable>();
	private List<OnEvent> onEventVars = new LinkedList<OnEvent>();
	private List<CorrelationSet> onEventCorrelationSets = new LinkedList<CorrelationSet>();
	private PartnerEntity partnerEntity;
	private static int operationCounter = 1;

	public ScopeUIParser(ScopeUI activity, PartnerEntity partnerEntity) {
		this.partnerEntity = partnerEntity;
		EventHandlerUI eventH = (EventHandlerUI) activity.getEventHandlers();
		Operation op = partnerEntity.getOperation("fireEvent");
		for (OnUserEvent onUiEvent : eventH.getUserInteraction()) {
			Variable v = createVariable((Message) op.getInput().getMessage());

			OnEvent userInteractionEvent = BPELFactory.eINSTANCE
					.createOnEvent();
			userInteractionEvent.setActivity(onUiEvent.getActivity());
			userInteractionEvent.setPartnerLink(partnerEntity.getPartnerLink());
			userInteractionEvent.setOperation(op);
			userInteractionEvent.setVariable(v);
			Correlations cc = BPELFactory.eINSTANCE.createCorrelations();
			Correlation processCorrelation = BPELFactory.eINSTANCE
					.createCorrelation();
			processCorrelation.setInitiate(CorrelationSection.NO);
			CorrelationSet eventCorrelationSet = createCorrelationSet();
			processCorrelation.setSet(eventCorrelationSet);
			cc.getChildren().add(processCorrelation);
			userInteractionEvent.setCorrelations(cc);

			onEventCorrelationSets.add(eventCorrelationSet);
			onUserEventVars.add(v);
			onEventVars.add(userInteractionEvent);
			operationCounter++;
		}
	}

	private CorrelationSet createCorrelationSet() {
		CorrelationSet interactionCS = BPELFactory.eINSTANCE
				.createCorrelationSet();
		interactionCS.setName(CORRELATION_ON_USER_EVENT_OPERATION
				+ operationCounter);
		interactionCS.getProperties().add(getProperty("processId"));
		Correlation cr2 = BPELFactory.eINSTANCE.createCorrelation();
		cr2.setSet(interactionCS);
		cr2.setInitiate(CorrelationSection.YES);
		cr2.setPattern(CorrelationPattern
				.get(CorrelationPattern.REQUESTRESPONSE));
		return interactionCS;
	}

	public Property getProperty(String propertyId) {
		return partnerEntity.getProperty(propertyId);
	}

	private Variable createVariable(Message message) {
		Variable newVariable = BPELFactory.eINSTANCE.createVariable();
		newVariable.setName("onEventVar" + operationCounter);
		newVariable.setMessageType(message);
		return newVariable;
	}

	public List<Variable> getOnUserEventVars() {
		return onUserEventVars;
	}

	public List<OnEvent> getOnEvents() {
		return onEventVars;
	}

	public List<CorrelationSet> getOnEventCorrelationSets() {
		return onEventCorrelationSets;
	}

}
