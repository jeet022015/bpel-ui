package be.ac.fundp.precise.ui_bpel.transformations.bpel.parsers;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.Receive;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.ui.properties.CorrelationSection;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;

import be.ac.fundp.precise.ui_bpel.transformations.bpel.bpelEntities.PartnerEntity;
import be.edu.fundp.precise.uibpel.model.DataInputUI;

public class StarterDataInputUIParser {

	private DataInputUIParser parser;
	private String receiveName;
	private Variable inputVar;
	private Sequence act;
	private CommonConcepts cc = CommonConcepts.getInstance();
	private static int operationCounter = 1;

	public StarterDataInputUIParser(DataInputUI activity,
			PartnerEntity uiManagerPartner, PartnerEntity processOpPartner) {
		parser = new DataInputUIParser(activity, uiManagerPartner);
		Operation startOp = processOpPartner.getOperation("start");
		inputVar = createVariable("operationStartInputRequest" + operationCounter,
				(Message) startOp.getInput().getMessage());
		Part startOpPart = (Part) startOp.getInput().getMessage()
				.getPart("parameters");
		
		Operation genIdOperation = uiManagerPartner.getOperation("generateProcessId");
		Variable outputGenVar = cc.getOutputGenVar(genIdOperation);
		Part genOpPart = (Part) genIdOperation.getOutput().getMessage()
				.getPart("parameters");

		act = BPELFactory.eINSTANCE.createSequence();
		act.setName("StarterDataInputUISequence-" + operationCounter);
		Receive r = BPELFactory.eINSTANCE.createReceive();
		r.setPartnerLink(processOpPartner.getPartnerLink());
		r.setOperation(startOp);
		r.setCreateInstance(true);
		r.setVariable(inputVar);
		receiveName = "UserStartingReceiver"+operationCounter;
		r.setName(receiveName);
		Correlations cc = BPELFactory.eINSTANCE.createCorrelations();
		Correlation processCorrelation = BPELFactory.eINSTANCE.createCorrelation();
		processCorrelation.setInitiate(CorrelationSection.YES);
				//bpel.getEventInteractionManager().getCorrelationSet();
		//processCorrelation.setSet(bpel.getUserEventCorrelationSet());
		CorrelationSet correlationSet = this.cc.getProcessIdCorrelationSet(uiManagerPartner
				.getProperty("processId"));
		processCorrelation.setSet(correlationSet);
		//processCorrelation.setPattern(CorrelationPattern.get(CorrelationPattern.REQUEST));
		cc.getChildren().add(processCorrelation);
		r.setCorrelations(cc);
		act.getActivities().add(r);
		Assign assignBefore = BPELFactory.eINSTANCE.createAssign();
		assignBefore.setName("IdGenerationConfiguration");
		Copy c1 = BPELFactory.eINSTANCE.createCopy();
		From f1 = BPELFactory.eINSTANCE.createFrom();
		To t1 = createToPart(outputGenVar, genIdOperation);
		f1.setLiteral(ExecutableTransUtil.
				createDefaultInitializer(t1.getVariable(), t1.getPart(), 
				new String[0]));
		c1.setFrom(f1);
		c1.setTo(t1);

		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("processId");
		f.setQuery(toQuery);
		f.setVariable(inputVar);
		f.setPart(startOpPart);

		To t = BPELFactory.eINSTANCE.createTo();
		toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("processId");
		t.setQuery(toQuery);
		t.setVariable(outputGenVar);
		t.setPart(genOpPart);
		c.setFrom(f);
		c.setTo(t);
		
		assignBefore.getCopy().add(c1);
		assignBefore.getCopy().add(c);
		act.getActivities().add(assignBefore);
		operationCounter++;
	}

	private To createToPart(Variable inputVar, Operation inputOperation) {
		To t = BPELFactory.eINSTANCE.createTo();
		t.setVariable(inputVar);
		t.setPart((Part) inputOperation.getOutput().getMessage().getPart("parameters"));
		return t;
	}

	protected Variable createVariable(String variableName, Message message) {
		Variable newVariable = BPELFactory.eINSTANCE.createVariable();
		newVariable.setName(variableName);
		newVariable.setMessageType(message);
		return newVariable;
	}

	public Variable getInputVar() {
		return parser.getInputVar();
	}

	public Variable getOutputVar() {
		return parser.getOutputVar();
	}

	public Variable getReceiveVar() {
		return inputVar;
	}

	public CorrelationSet getCorrelationSet() {
		return parser.getCorrelationSet();
	}

	public Activity getActivity() {
		act.getActivities().add(parser.getActivity());
		return act;
	}

	public String getReceiveName() {
		return receiveName;
	}

}
