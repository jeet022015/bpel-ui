package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.data_interaction;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;

public class SelectionOperation extends AbstractInteractionOperation{
	
	private static final String CORRELATION_SET_SELECTION_OPERATION_INTERACTION = "SelectionOperationInteraction-";
	private static final String CORRELATION_SET_SELECTION_OPERATION_PROCESS = "SelectionOperationProcess-";
	private static final String VARIABLE_DATA_SELECTION_RESPONSE = "dataSelectionResponse";
	private static final String VARIABLE_DATA_SELECTION_REQUEST = "dataSelectionRequest";
	static protected int operationCounter = 1;

	public SelectionOperation(Operation inputOperation, Operation genOperation, Variable genVar, 
			Property propertyProcessId, Property propertyInteractionId){
		try {
			operation = inputOperation;
			this.genOperation = genOperation;
			genVariable = genVar;
			createDataOutputVar();
			createCorrelationSets(propertyProcessId, propertyInteractionId);
		} finally{
			operationCounter++;
		}
	}

	protected void createDataOutputVar() {
		inputVariable = BPELFactory.eINSTANCE.createVariable();
		inputVariable.setName(VARIABLE_DATA_SELECTION_REQUEST + operationCounter);
		inputVariable.setMessageType((Message) operation.getInput()
				.getMessage());
		outputVariable = BPELFactory.eINSTANCE.createVariable();
		outputVariable.setName(VARIABLE_DATA_SELECTION_RESPONSE + operationCounter);
		outputVariable.setMessageType((Message) operation.getOutput()
				.getMessage());
		
	}
	
	protected void createCorrelationSets(Property propertyProcessId, Property propertyInteractionId) {
		CorrelationSet processCS = BPELFactory.eINSTANCE.createCorrelationSet();
		processCS.setName(CORRELATION_SET_SELECTION_OPERATION_PROCESS+operationCounter);
		processCS.getProperties().add(propertyProcessId);
		correlationSets.add(processCS);
		
		CorrelationSet interactionCS = BPELFactory.eINSTANCE.createCorrelationSet();
		interactionCS.setName(CORRELATION_SET_SELECTION_OPERATION_INTERACTION+operationCounter);
		interactionCS.getProperties().add(propertyInteractionId);
		correlationSets.add(interactionCS);
	}
}
