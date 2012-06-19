package be.ac.fundp.precise.ui_bpel.transformations.bpel.parsers;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;

public class CommonConcepts {

	private static CommonConcepts self;
	private Variable inputVar;
	private Variable outputVar;
	private CorrelationSet correlationSet;

	protected CommonConcepts() {

	}

	public static CommonConcepts getInstance() {
		if (self == null)
			self = new CommonConcepts();
		return self;
	}

	public Variable getInputGenVar(Operation genIdOperation) {
		if (inputVar != null)
			return inputVar;
		createVariables(genIdOperation);
		return inputVar;
	}

	public Variable getOutputGenVar(Operation genIdOperation) {
		if (outputVar != null)
			return outputVar;
		createVariables(genIdOperation);
		return outputVar;
	}

	private void createVariables(Operation genIdOperation) {
		inputVar = BPELFactory.eINSTANCE.createVariable();
		inputVar.setName("processIdRequest");
		inputVar.setMessageType((Message) genIdOperation.getInput()
				.getMessage());
		outputVar = BPELFactory.eINSTANCE.createVariable();
		outputVar.setName("processIdResponse");
		outputVar.setMessageType((Message) genIdOperation.getOutput()
				.getMessage());
	}

	public CorrelationSet getProcessIdCorrelationSet(Property propertyProcessId) {
		if (correlationSet != null)
			return correlationSet;
		System.out.println("propertyProcessId=" + propertyProcessId);
		correlationSet = BPELFactory.eINSTANCE.createCorrelationSet();
		correlationSet.setName("genIdCorrelationSet");
		correlationSet.getProperties().add(propertyProcessId);
		return correlationSet;
	}
}
