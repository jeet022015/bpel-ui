package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.data_interaction;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;

public class InputOperation extends AbstractInteractionOperation{
	
	private static final String CORRELATION_SET_INPUT_OPERATION_INTERACTION = "InputOperationInteraction-";
	private static final String CORRELATION_SET_INPUT_OPERATION_PROCESS = "InputOperationProcess-";
	private static final String VARIABLE_DATA_INPUT_RESPONSE = "dataInputResponse";
	private static final String VARIABLE_DATA_INPUT_REQUEST = "dataInputRequest";
	static protected int operationCounter = 1;

	public InputOperation(Operation inputOperation, Operation genOperation, Variable genVar,
			Property propertyProcessId, Property propertyInteractionId){
		try {
			operation = inputOperation;
			this.genOperation = genOperation;
			genVariable = genVar;
			createDataInputVar();
			createCorrelationSets(propertyProcessId, propertyInteractionId);
		} finally{
			operationCounter++;
		}
	}

	protected void createDataInputVar() {
		inputVariable = BPELFactory.eINSTANCE.createVariable();
		inputVariable.setName(VARIABLE_DATA_INPUT_REQUEST + operationCounter);
		inputVariable.setMessageType((Message) operation.getInput()
				.getMessage());
		outputVariable = BPELFactory.eINSTANCE.createVariable();
		outputVariable.setName(VARIABLE_DATA_INPUT_RESPONSE + operationCounter);
		outputVariable.setMessageType((Message) operation.getOutput()
				.getMessage());
		
	}
	
	protected void createCorrelationSets(Property propertyProcessId, 
			Property propertyInteractionId) {
		CorrelationSet processCS = BPELFactory.eINSTANCE.createCorrelationSet();
		processCS.setName(CORRELATION_SET_INPUT_OPERATION_PROCESS+operationCounter);
		processCS.getProperties().add(propertyProcessId);
		correlationSets.add(processCS);
		
		CorrelationSet interactionCS = BPELFactory.eINSTANCE.createCorrelationSet();
		interactionCS.setName(CORRELATION_SET_INPUT_OPERATION_INTERACTION+operationCounter);
		interactionCS.getProperties().add(propertyInteractionId);
		correlationSets.add(interactionCS);
	}
}
