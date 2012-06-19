package be.ac.fundp.precise.ui_bpel.transformations.bpel.parsers;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Receive;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.Variable;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;

import be.ac.fundp.precise.ui_bpel.transformations.bpel.bpelEntities.PartnerEntity;
import be.edu.fundp.precise.uibpel.model.DataInputUI;

public class StarterDataInputUIParser {

	private DataInputUIParser parser;
	private Variable inputVar;
	private Sequence act;
	private static int operationCounter = 1;

	public StarterDataInputUIParser(DataInputUI activity,
			PartnerEntity uiManagerPartner, PartnerEntity processOpPartner) {
		parser = new DataInputUIParser(activity, uiManagerPartner);
		Operation startOp = processOpPartner.getOperation("start");
		inputVar = createVariable("operationStartInputRequest" + operationCounter,
				(Message) startOp.getInput().getMessage());

		act = BPELFactory.eINSTANCE.createSequence();
		act.setName("StarterDataInputUISequence-" + operationCounter);
		Receive r = BPELFactory.eINSTANCE.createReceive();
		r.setPartnerLink(processOpPartner.getPartnerLink());
		r.setOperation(startOp);
		r.setCreateInstance(true);
		r.setVariable(inputVar);
		r.setName("UserStartingReceiver"+operationCounter);
		act.getActivities().add(r);
		operationCounter++;
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

}
