package be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.messageproperties.MessagepropertiesFactory;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.bpel.model.messageproperties.Query;
import org.eclipse.wst.wsdl.BindingOperation;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Port;
import org.eclipse.wst.wsdl.Service;

import be.edu.fundp.precise.uibpel.model.OnUserEvent;

/**
 * The Class EventInteractionManager.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class EventInteractionManager {

	/** The my cs. */
	private CorrelationSet myCS;
	
	/** The wsdl_user_event_listinner. */
	private Definition wsdl_user_event_listinner;
	
	/** The process ws dl. */
	private Definition processWSDl;
	
	/** The list. */
	private Map<String, Variable> variableList = new HashMap<String, Variable>();
	
	/** The Constant ON_USER_EVENT_DATA. */
	public static final String ON_USER_EVENT_DATA = "onUserEventData";

	private static final String START_DATA = "startProcessData";
	
	/** The event operation. */
	private Operation eventOperation;
	
	/** The start operation. */
	private Operation startOperation;
	
	/** The event count. */
	private int eventCount;
	
	/** The start count. */
	private int startCount;
	
	CorrelationSet startCorrelationSet;

	private Property processIdProperty;
	
	/**
	 * Instantiates a new event interaction manager.
	 *
	 * @param wsdl_user_event_listinner the wsdl_user_event_listinner
	 * @param processWSDl the process ws dl
	 */
	public EventInteractionManager(Definition wsdl_user_event_listinner, Definition processWSDl, CorrelationSet processIdCorrelationSet) {
		this.processWSDl = processWSDl;
		this.wsdl_user_event_listinner= wsdl_user_event_listinner;
		eventOperation = getFireEventOperation();
		startOperation = getStartOperation();
		myCS = processIdCorrelationSet;
		processIdProperty = myCS.getProperties().listIterator().next();
		createPropertyAlias(wsdl_user_event_listinner, processIdProperty);
		createPropertyStartAlias(wsdl_user_event_listinner, processIdProperty);
		startCorrelationSet = createCorrelationSets();
		eventCount = 0;
		startCount = 0;
	}
	
	private Operation getStartOperation() {
		Service s1 = (Service) wsdl_user_event_listinner.getEServices().get(0);
		Port p1 = (Port) s1.getEPorts().get(0);
		for (Object op : p1.getBinding().getBindingOperations()) {
			BindingOperation opera = (BindingOperation) op;
			System.out.println("op="+opera.getName());
			if (opera.getName().equals("start")){
				System.out.println("heeerrreee");
				return opera.getEOperation();
			}
		}
		return null;
	}

	private Operation getFireEventOperation() {
		Service s1 = (Service) wsdl_user_event_listinner.getEServices().get(0);
		Port p1 = (Port) s1.getEPorts().get(0);
		for (Object op : p1.getBinding().getBindingOperations()) {
			BindingOperation opera = (BindingOperation) op;
			if (opera.getName().equals("fireEvent")){
				return opera.getEOperation();
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private void createPropertyAlias(Definition wsdl_user_event_listinner2,
			Property processIdProperty) {
		PropertyAlias userEventPropertyAlias = MessagepropertiesFactory.eINSTANCE.createPropertyAlias();
		userEventPropertyAlias.setMessageType(eventOperation.getInput().getMessage());

		userEventPropertyAlias.setPart("parameters");
		userEventPropertyAlias.setPropertyName(processIdProperty);
		
		String query = "";
		String prefix = processWSDl.getPrefix("test");
		if (prefix!=null)
			query = query + "/" + prefix + ":" + "processId";
		else
			query = query + "/" + "processId";
		Query q = MessagepropertiesFactory.eINSTANCE.createQuery();
		q.setValue(query);
		userEventPropertyAlias.setQuery(q);
		
		processWSDl.getEExtensibilityElements().add(userEventPropertyAlias);
	}

	@SuppressWarnings("unchecked")
	private void createPropertyStartAlias(Definition wsdl_user_event_listinner2,
			Property processIdProperty) {
		PropertyAlias userEventPropertyAlias = MessagepropertiesFactory.eINSTANCE.createPropertyAlias();
		userEventPropertyAlias.setMessageType(startOperation.getInput().getMessage());

		userEventPropertyAlias.setPart("parameters");
		userEventPropertyAlias.setPropertyName(processIdProperty);
		
		String query = "";
		String prefix = processWSDl.getPrefix("test2");
		if (prefix!=null)
			query = query + "/" + prefix + ":" + "processId";
		else
			query = query + "/" + "processId";
		Query q = MessagepropertiesFactory.eINSTANCE.createQuery();
		q.setValue(query);
		userEventPropertyAlias.setQuery(q);
		
		processWSDl.getEExtensibilityElements().add(userEventPropertyAlias);
	}

	/**
	 * Creates the event var.
	 *
	 * @param userEvent the user event
	 */
	public void createEventVar(OnUserEvent userEvent) {
		Variable inputVar = BPELFactory.eINSTANCE.createVariable();
		inputVar.setName(ON_USER_EVENT_DATA + eventCount);
		inputVar.setMessageType((Message) eventOperation.getInput()
				.getMessage());
		variableList.put(userEvent.getId(), inputVar);
		eventCount++;
	}
	
	/**
	 * Creates the event var.
	 *
	 * @param userEvent the user event
	 */
	public void createStartVar(String interactionId) {
		Variable inputVar = BPELFactory.eINSTANCE.createVariable();
		inputVar.setName(START_DATA + startCount);
		inputVar.setMessageType((Message) startOperation.getInput()
				.getMessage());
		variableList.put(interactionId, inputVar);
		eventCount++;
	}

	/**
	 * Gets the operation.
	 *
	 * @return the operation
	 */
	public Operation getOperation() {
		return eventOperation;
	}
	
	/**
	 * Gets the operation.
	 *
	 * @return the operation
	 */
	public Operation getStartingOperation() {
		return startOperation;
	}

	/**
	 * Gets the correlation set.
	 *
	 * @return the correlation set
	 */
	public CorrelationSet getCorrelationSet() {
		return myCS;
	}

	/**
	 * Gets the variables.
	 *
	 * @return the variables
	 */
	public Collection<? extends Variable> getVariables() {
		return variableList.values();
	}

	/**
	 * Gets the variable.
	 *
	 * @param id the id
	 * @return the variable
	 */
	public Variable getVariable(String id) {
		return  variableList.get(id);
	}
	
	private CorrelationSet createCorrelationSets() {
		CorrelationSet correlationSet = BPELFactory.eINSTANCE.createCorrelationSet();
		correlationSet.setName("startProcessCorrelationSet");
		correlationSet.getProperties().add(processIdProperty);
		return correlationSet;
	}

	public CorrelationSet getStartCorrelationSet() {
		return startCorrelationSet;
	}
}