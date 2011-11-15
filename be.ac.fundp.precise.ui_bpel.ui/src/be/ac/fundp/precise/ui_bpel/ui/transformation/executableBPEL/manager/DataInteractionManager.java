package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Variable;
import org.eclipse.wst.wsdl.BindingOperation;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Port;
import org.eclipse.wst.wsdl.Service;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

public class DataInteractionManager {
	
	private Operation[] uiManagerOperations = new Operation[3];
	private int[] operationCounter = {1,1,1};
	
	public static final int INPUT_OPERATION = 0;
	public static final int OUTPUT_OPERATION = 1;
	public static final int SELECTION_OPERATION = 2;
	
	protected static final String[] responseNames = {"dataInputResponse", 
			"dataOutputResponse", "dataSelectionResponse"};
	
	protected static final  String[] requestNames = {"dataInputRequest", 
			"dataOutputRequest", "dataSelectionRequest"};
	
	private Definition wsdl_ui_bpel;
	
	private Map<String, Set<Variable>> list = new HashMap<String, Set<Variable>>();;
	
	public DataInteractionManager(Definition wsdl_ui_bpel){
		this.wsdl_ui_bpel= wsdl_ui_bpel;
		operationConfiguration();
	}
	
	private void operationConfiguration() {
		Service s1 = (Service) wsdl_ui_bpel.getEServices().get(0);
		Port p1 = (Port) s1.getEPorts().get(0);
		for (Object op : p1.getBinding().getBindingOperations()) {
			BindingOperation opera = (BindingOperation) op;
			if (opera.getName().equals("inputOperation"))
				uiManagerOperations[INPUT_OPERATION] = opera.getEOperation();
			else if (opera.getName().equals("outputOperation"))
				uiManagerOperations[OUTPUT_OPERATION] = opera.getEOperation();
			else if (opera.getName().equals("selectionOperation"))
				uiManagerOperations[SELECTION_OPERATION] = opera.getEOperation();
		}
	}

	public void createDataSelectionVar(DataSelectionUI s) {
		Variable inputVar = BPELFactory.eINSTANCE.createVariable();
		inputVar.setName(requestNames[SELECTION_OPERATION] + operationCounter[SELECTION_OPERATION]);
		inputVar.setMessageType((Message) uiManagerOperations[SELECTION_OPERATION].getInput()
				.getMessage());
		Variable outputVar = BPELFactory.eINSTANCE.createVariable();
		outputVar.setName(responseNames[SELECTION_OPERATION] + operationCounter[SELECTION_OPERATION]);
		outputVar.setMessageType((Message) uiManagerOperations[SELECTION_OPERATION].getOutput()
				.getMessage());
		Set<Variable> var = new HashSet<Variable>();
		var.add(outputVar);
		var.add(inputVar);
		list.put(s.getId(), var);
		operationCounter[SELECTION_OPERATION]++;
	}

	public void createDataInputVar(DataInputUI s) {
		Variable inputVar = BPELFactory.eINSTANCE.createVariable();
		inputVar.setName(requestNames[INPUT_OPERATION] + operationCounter[INPUT_OPERATION]);
		inputVar.setMessageType((Message) uiManagerOperations[INPUT_OPERATION].getInput()
				.getMessage());
		Variable outputVar = BPELFactory.eINSTANCE.createVariable();
		outputVar.setName(responseNames[INPUT_OPERATION] + operationCounter[INPUT_OPERATION]);
		outputVar.setMessageType((Message) uiManagerOperations[INPUT_OPERATION].getOutput()
				.getMessage());
		Set<Variable> var = new HashSet<Variable>();
		var.add(outputVar);
		var.add(inputVar);
		list.put(s.getId(), var);
		operationCounter[INPUT_OPERATION]++;
	}

	public void createDataOutputVar(DataOutputUI s) {
		Variable inputVar = BPELFactory.eINSTANCE.createVariable();
		inputVar.setName(requestNames[OUTPUT_OPERATION] + operationCounter[OUTPUT_OPERATION]);
		inputVar.setMessageType((Message) uiManagerOperations[OUTPUT_OPERATION].getInput()
				.getMessage());
		Set<Variable> var = new HashSet<Variable>();
		var.add(inputVar);
		list.put(s.getId(), var);
		operationCounter[OUTPUT_OPERATION]++;
	}

	public Operation getInputOperation() {
		return uiManagerOperations[INPUT_OPERATION];
	}
	
	public Operation getOutputOperation() {
		return uiManagerOperations[OUTPUT_OPERATION];
	}
	
	public Operation getSelectionOperation() {
		return uiManagerOperations[SELECTION_OPERATION];
	}

	public Collection<? extends Variable> getVariables() {
		Set<Variable> vars = new HashSet<Variable>();
		for (Set<Variable> variable : list.values()) {
			vars.addAll(variable);
		}
		return vars;
	}

	public boolean containsUserInteraction(String id) {
		return list.keySet().contains(id);
	}

	public Variable[] getVariable(String id) {
		return  list.get(id).toArray(new Variable[0]);
	}
	
	public static String getDefaultResponseNames(int id) {
		return  responseNames[id];
	}
	
	public static String getDefaultRequestNames(int id) {
		return  requestNames[id];
	}
}
