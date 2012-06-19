package be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.messageproperties.MessagepropertiesFactory;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.bpel.model.messageproperties.Query;
import org.eclipse.bpel.ui.util.XSDUtils;
import org.eclipse.wst.wsdl.BindingOperation;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Port;
import org.eclipse.wst.wsdl.Service;

import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.data_interaction.InputOperation;
import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.data_interaction.InteractionOperation;
import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.data_interaction.OutputOperation;
import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.data_interaction.SelectionOperation;

/**
 * The Class DataInteractionManager.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class DataInteractionManager {

	protected Map<String, InteractionOperation> dataInteracionMapper = new HashMap<String, InteractionOperation>();
	
	protected Operation inputOperation;
	protected Operation outputOperation;
	protected Operation selectionOperation;
	protected Operation genIdOperationOperation;

	private Property propertyProcessId;
	private Property propertyInteractionId;
	
	private CorrelationSet processIdCorrelationSet;

	private Variable genVar;
	
	/**
	 * Instantiates a new data interaction manager.
	 *
	 * @param wsdl_ui_bpel the wsdl_ui_bpel
	 * @param processWSDl the process ws dl
	 * @param propertyName the property name
	 * @param property 
	 */
	public DataInteractionManager(Definition wsdl_ui_bpel, Definition processWSDl, CorrelationSet processIdCorrelationSet, Variable genVar){
		this.genVar = genVar;
		setOperations(wsdl_ui_bpel);

		this.processIdCorrelationSet = processIdCorrelationSet;
		
		System.out.println("processIdCorrelationSet="+processIdCorrelationSet);
		
		propertyProcessId = processIdCorrelationSet.getProperties().listIterator().next();
		propertyInteractionId = createProperty(processWSDl, "intid", "interactionId");

		createParallelCorrelSets(processWSDl);
	}


	protected void setOperations(Definition uibpelWsdl) {
		Service s1 = (Service) uibpelWsdl.getEServices().get(0);
		Port p1 = (Port) s1.getEPorts().get(0);
		for (Object op : p1.getBinding().getBindingOperations()) {
			BindingOperation opera = (BindingOperation) op;
			if (opera.getName().equals("inputOperation"))
				inputOperation = opera.getEOperation();
			else if (opera.getName().equals("outputOperation"))
				outputOperation = opera.getEOperation();
			else if (opera.getName().equals("selectionOperation"))
				selectionOperation = opera.getEOperation();
			else if (opera.getName().equals("generateProcessId"))
				genIdOperationOperation = opera.getEOperation();
		}
	}

	@SuppressWarnings("unchecked")
	private Property createProperty(Definition processWSDl, String prefix, String propertyName) {
		Property property = MessagepropertiesFactory.eINSTANCE.createProperty();
		property.setType(XSDUtils.getPrimitive("string"));
		QName qname = new QName(prefix, propertyName);
		property.setQName(qname);
		property.setName(propertyName);
		property.setEnclosingDefinition(processWSDl);
		processWSDl.getEExtensibilityElements().add(property);
		return property;
	}

	private void createParallelCorrelSets(Definition processWSDl) {
		createOperationPropertyAlias(inputOperation, processWSDl);
		createOperationPropertyAlias(outputOperation, processWSDl);
		createOperationPropertyAlias(selectionOperation, processWSDl);
	}

	private void createOperationPropertyAlias(Operation eOperation, Definition processWSDl) {
		createPropertyAlias(eOperation.getOutput().getMessage(), processWSDl, "processId", propertyProcessId);
		createPropertyAlias(eOperation.getInput().getMessage(), processWSDl, "processId", propertyProcessId);
		createPropertyAlias(eOperation.getOutput().getMessage(), processWSDl, "userInteracId", propertyInteractionId);
		createPropertyAlias(eOperation.getInput().getMessage(), processWSDl, "userInteracId", propertyInteractionId);
	}


	@SuppressWarnings("unchecked")
	private void createPropertyAlias(javax.wsdl.Message message, Definition processWSDl, String element, Property property) {
		PropertyAlias myPA = MessagepropertiesFactory.eINSTANCE.createPropertyAlias();
		myPA.setMessageType(message);
		myPA.setPart("parameters");
		myPA.setPropertyName(property);
		
		//The query
		String query = "";
		String prefix = processWSDl.getPrefix("test");
		if (prefix!=null)
			query = query + "/" + prefix + ":" + element;
		else
			query = query + "/" + element;
		Query q = MessagepropertiesFactory.eINSTANCE.createQuery();
		q.setValue(query);
		myPA.setQuery(q);
		processWSDl.getEExtensibilityElements().add(myPA);
	}
	
	/**
	 * Gets the variables.
	 *
	 * @return the variables
	 */
	public Collection<? extends Variable> getVariables() {
		Set<Variable> vars = new HashSet<Variable>();
		for (InteractionOperation aInteraction : dataInteracionMapper.values()) {
			vars.add(aInteraction.getInputVariable());
			vars.add(aInteraction.getOutputVariable());
		}
		return vars;
	}

	public Collection<CorrelationSet> getInputCorrelationSets() {
		Collection<CorrelationSet> cc = new HashSet<CorrelationSet>();
		for (InteractionOperation aInteraction : dataInteracionMapper.values()) {
			Collection<Correlation> cs = aInteraction.getCorrelationSet();
			for (Correlation correlation : cs) {
				cc.add(correlation.getSet());
			}
		}
		return cc;
	}
	
	public Collection<Correlation> getCorrelationSets(String id) {
		return dataInteracionMapper.get(id).getCorrelationSet();
	}


	public void createDataSelection(String activityId) {
		InteractionOperation op = new SelectionOperation(selectionOperation, genIdOperationOperation, genVar, 
				processIdCorrelationSet, propertyInteractionId);
		dataInteracionMapper.put(activityId, op);
	}


	public void createDataInput(String activityId) {
		InteractionOperation op = new InputOperation(inputOperation, genIdOperationOperation, genVar,
				processIdCorrelationSet, propertyInteractionId);
		dataInteracionMapper.put(activityId, op);
	}


	public void createDataOutput(String activityId) {
		InteractionOperation op = new OutputOperation(outputOperation, genIdOperationOperation, genVar,
				processIdCorrelationSet, propertyInteractionId);
		dataInteracionMapper.put(activityId, op);
	}


	public InteractionOperation getOperation(String id) {
		return dataInteracionMapper.get(id);
	}
}
