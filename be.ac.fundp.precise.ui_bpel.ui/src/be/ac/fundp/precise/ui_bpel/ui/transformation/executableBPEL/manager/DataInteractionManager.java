package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.messageproperties.MessagepropertiesFactory;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.bpel.model.messageproperties.Query;
import org.eclipse.bpel.ui.util.XSDUtils;
import org.eclipse.wst.wsdl.BindingOperation;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Port;
import org.eclipse.wst.wsdl.Service;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

// TODO: Auto-generated Javadoc
/**
 * The Class DataInteractionManager.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class DataInteractionManager {
	
	/** The ui manager operations. */
	private Operation[] uiManagerOperations = new Operation[4];
	
	/** The operation counter. */
	private int[] operationCounter = {1,1,1,1};

	/** The Constant GEN_ID_INDEX. */
	public static final String GEN_ID_INDEX = "GEN_ID_INDEX";
	
	/** The Constant INPUT_OPERATION. */
	public static final int OPERATION_INPUT = 0;
	
	/** The Constant OUTPUT_OPERATION. */
	public static final int OPERATION_OUTPUT = 1;
	
	/** The Constant SELECTION_OPERATION. */
	public static final int OPERATION_SELECTION = 2;
	
	/** The Constant GEN_ID_OPERATION. */
	public static final int OPERATION_GEN_ID = 3;
	
	/** The Constant responseNames. */
	protected static final String[] responseNames = {"dataInputResponse", 
			"dataOutputResponse", "dataSelectionResponse", "genIdResponse"};
	
	/** The Constant requestNames. */
	protected static final  String[] requestNames = {"dataInputRequest", 
			"dataOutputRequest", "dataSelectionRequest", "genIdResquest"};
	
	/** The wsdl_ui_bpel. */
	private Definition wsdl_ui_bpel;
	
	/** The list. */
	private Map<String, Set<Variable>> list = new HashMap<String, Set<Variable>>();
	
	protected List<CorrelationSet> innerCSs = new LinkedList<CorrelationSet>();

	private Property propertyName;
	
	/** The my pa. */
	//private PropertyAlias myPA;
	
	/**
	 * Instantiates a new data interaction manager.
	 *
	 * @param wsdl_ui_bpel the wsdl_ui_bpel
	 * @param processWSDl the process ws dl
	 * @param propertyName the property name
	 */
	public DataInteractionManager(Definition wsdl_ui_bpel, Definition processWSDl, Property propertyName){
		this.wsdl_ui_bpel= wsdl_ui_bpel;
		operationConfiguration();
		createCorrelationSet(processWSDl, propertyName);
		createPropertyName(processWSDl);
		createParallelCorrelSets(processWSDl);
	}
	
	private void createPropertyName(Definition processWSDl) {
		propertyName = MessagepropertiesFactory.eINSTANCE.createProperty();
		propertyName.setType(XSDUtils.getPrimitive("string"));
		QName qname = new QName("test", "propertyTest2");
		propertyName.setQName(qname);
		propertyName.setName("propertyTest2");
		propertyName.setEnclosingDefinition(processWSDl);
		processWSDl.getEExtensibilityElements().add(propertyName);
	}

	private void createParallelCorrelSets(Definition processWSDl) {
		Service s1 = (Service) wsdl_ui_bpel.getEServices().get(0);
		Port p1 = (Port) s1.getEPorts().get(0);
		for (Object op : p1.getBinding().getBindingOperations()) {
			BindingOperation opera = (BindingOperation) op;
			if (opera.getName().equals("inputOperation"))
				createInputProperty(opera.getEOperation(), processWSDl, 3);
			else if (opera.getName().equals("selectionOperation"))
				createSelectProperty(opera.getEOperation(), 3);
		}
	}

	private void createSelectProperty(Operation eOperation, int i) {
		// TODO Auto-generated method stub
		
	}

	private void createInputProperty(Operation eOperation, Definition processWSDl, int i) {
		PropertyAlias myPA = MessagepropertiesFactory.eINSTANCE.createPropertyAlias();
		myPA.setMessageType(uiManagerOperations[OPERATION_INPUT].getOutput().getMessage());

		myPA.setPart("parameters");
		myPA.setPropertyName(propertyName);
		
		//The query
		String query = "";
		String prefix = processWSDl.getPrefix("test");
		if (prefix!=null)
			query = query + "/" + prefix + ":" + "processId";
		else
			query = query + "/" + "processId";
		Query q = MessagepropertiesFactory.eINSTANCE.createQuery();
		q.setValue(query);
		myPA.setQuery(q);
		
		processWSDl.getEExtensibilityElements().add(myPA);
		
		myPA = MessagepropertiesFactory.eINSTANCE.createPropertyAlias();
		myPA.setMessageType(uiManagerOperations[OPERATION_INPUT].getInput().getMessage());

		myPA.setPart("parameters");
		myPA.setPropertyName(propertyName);
		
		//The query
		query = "";
		prefix = processWSDl.getPrefix("test");
		if (prefix!=null)
			query = query + "/" + prefix + ":" + "processId";
		else
			query = query + "/" + "processId";
		q = MessagepropertiesFactory.eINSTANCE.createQuery();
		q.setValue(query);
		myPA.setQuery(q);
		
		processWSDl.getEExtensibilityElements().add(myPA);
		
		for (int j = 0; j < i; j++) {
			CorrelationSet myCS = BPELFactory.eINSTANCE.createCorrelationSet();
			myCS.setName("Test"+j);
			myCS.getProperties().add(propertyName);
			innerCSs.add(myCS);
		}
		
	}

	/**
	 * Creates the correlation set.
	 *
	 * @param processWSDl the process ws dl
	 * @param propertyName the property name
	 */
	private void createCorrelationSet(Definition processWSDl, Property propertyName) {

		PropertyAlias myPA = MessagepropertiesFactory.eINSTANCE.createPropertyAlias();
		myPA.setMessageType(uiManagerOperations[OPERATION_GEN_ID].getOutput().getMessage());

		myPA.setPart("parameters");
		myPA.setPropertyName(propertyName);
		
		//The query
		String query = "";
		String prefix = processWSDl.getPrefix("test");
		if (prefix!=null)
			query = query + "/" + prefix + ":" + "processId";
		else
			query = query + "/" + "processId";
		Query q = MessagepropertiesFactory.eINSTANCE.createQuery();
		q.setValue(query);
		myPA.setQuery(q);
		
		processWSDl.getEExtensibilityElements().add(myPA);
	}
	
	/**
	 * Operation configuration.
	 */
	private void operationConfiguration() {
		Service s1 = (Service) wsdl_ui_bpel.getEServices().get(0);
		Port p1 = (Port) s1.getEPorts().get(0);
		for (Object op : p1.getBinding().getBindingOperations()) {
			BindingOperation opera = (BindingOperation) op;
			if (opera.getName().equals("inputOperation"))
				uiManagerOperations[OPERATION_INPUT] = opera.getEOperation();
			else if (opera.getName().equals("outputOperation"))
				uiManagerOperations[OPERATION_OUTPUT] = opera.getEOperation();
			else if (opera.getName().equals("selectionOperation"))
				uiManagerOperations[OPERATION_SELECTION] = opera.getEOperation();
			else if (opera.getName().equals("generateProcessId"))
				uiManagerOperations[OPERATION_GEN_ID] = opera.getEOperation();
		}
	}

	/**
	 * Creates the gen id vars.
	 */
	public void createGenIdVars() {
		Variable inputVar = BPELFactory.eINSTANCE.createVariable();
		inputVar.setName(requestNames[OPERATION_GEN_ID]);
		inputVar.setMessageType((Message) uiManagerOperations[OPERATION_GEN_ID].getInput()
				.getMessage());
		Variable outputVar = BPELFactory.eINSTANCE.createVariable();
		outputVar.setName(responseNames[OPERATION_GEN_ID]);
		outputVar.setMessageType((Message) uiManagerOperations[OPERATION_GEN_ID].getOutput()
				.getMessage());
		Set<Variable> var = new HashSet<Variable>();
		var.add(outputVar);
		var.add(inputVar);
		list.put(GEN_ID_INDEX, var);
		//operationCounter[SELECTION_OPERATION]++;
	}
	
	/**
	 * Creates the data selection var.
	 *
	 * @param s the s
	 */
	public void createDataSelectionVar(DataSelectionUI s) {
		Variable inputVar = BPELFactory.eINSTANCE.createVariable();
		inputVar.setName(requestNames[OPERATION_SELECTION] + operationCounter[OPERATION_SELECTION]);
		inputVar.setMessageType((Message) uiManagerOperations[OPERATION_SELECTION].getInput()
				.getMessage());
		Variable outputVar = BPELFactory.eINSTANCE.createVariable();
		outputVar.setName(responseNames[OPERATION_SELECTION] + operationCounter[OPERATION_SELECTION]);
		outputVar.setMessageType((Message) uiManagerOperations[OPERATION_SELECTION].getOutput()
				.getMessage());
		Set<Variable> var = new HashSet<Variable>();
		var.add(outputVar);
		var.add(inputVar);
		list.put(s.getId(), var);
		operationCounter[OPERATION_SELECTION]++;
	}

	/**
	 * Creates the data input var.
	 *
	 * @param s the s
	 */
	public void createDataInputVar(DataInputUI s) {
		Variable inputVar = BPELFactory.eINSTANCE.createVariable();
		inputVar.setName(requestNames[OPERATION_INPUT] + operationCounter[OPERATION_INPUT]);
		inputVar.setMessageType((Message) uiManagerOperations[OPERATION_INPUT].getInput()
				.getMessage());
		Variable outputVar = BPELFactory.eINSTANCE.createVariable();
		outputVar.setName(responseNames[OPERATION_INPUT] + operationCounter[OPERATION_INPUT]);
		outputVar.setMessageType((Message) uiManagerOperations[OPERATION_INPUT].getOutput()
				.getMessage());
		Set<Variable> var = new HashSet<Variable>();
		var.add(outputVar);
		var.add(inputVar);
		list.put(s.getId(), var);
		operationCounter[OPERATION_INPUT]++;
	}

	/**
	 * Creates the data output var.
	 *
	 * @param s the s
	 */
	public void createDataOutputVar(DataOutputUI s) {
		Variable inputVar = BPELFactory.eINSTANCE.createVariable();
		inputVar.setName(requestNames[OPERATION_OUTPUT] + operationCounter[OPERATION_OUTPUT]);
		inputVar.setMessageType((Message) uiManagerOperations[OPERATION_OUTPUT].getInput()
				.getMessage());
		Set<Variable> var = new HashSet<Variable>();
		var.add(inputVar);
		list.put(s.getId(), var);
		operationCounter[OPERATION_OUTPUT]++;
	}

	/**
	 * Gets the input operation.
	 *
	 * @return the input operation
	 */
	public Operation getInputOperation() {
		return uiManagerOperations[OPERATION_INPUT];
	}
	
	/**
	 * Gets the output operation.
	 *
	 * @return the output operation
	 */
	public Operation getOutputOperation() {
		return uiManagerOperations[OPERATION_OUTPUT];
	}
	
	/**
	 * Gets the selection operation.
	 *
	 * @return the selection operation
	 */
	public Operation getSelectionOperation() {
		return uiManagerOperations[OPERATION_SELECTION];
	}

	/**
	 * Gets the variables.
	 *
	 * @return the variables
	 */
	public Collection<? extends Variable> getVariables() {
		Set<Variable> vars = new HashSet<Variable>();
		for (Set<Variable> variable : list.values()) {
			vars.addAll(variable);
		}
		return vars;
	}

	/**
	 * Contains user interaction.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean containsUserInteraction(String id) {
		return list.keySet().contains(id);
	}

	/**
	 * Gets the variable.
	 *
	 * @param id the id
	 * @return the variable
	 */
	public Variable[] getVariable(String id) {
		return  list.get(id).toArray(new Variable[0]);
	}
	
	/**
	 * Gets the default response names.
	 *
	 * @param id the id
	 * @return the default response names
	 */
	public static String getDefaultResponseNames(int id) {
		return  responseNames[id];
	}
	
	/**
	 * Gets the default request names.
	 *
	 * @param id the id
	 * @return the default request names
	 */
	public static String getDefaultRequestNames(int id) {
		return  requestNames[id];
	}

	/**
	 * Gets the gen id operation.
	 *
	 * @return the gen id operation
	 */
	public Operation getGenIdOperation() {
		return uiManagerOperations[OPERATION_GEN_ID];
	}

	public List<CorrelationSet> getInputCorrelationSets() {
		return innerCSs;
	}
}
