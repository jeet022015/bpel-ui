package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

import be.edu.fundp.precise.uibpel.model.OnUserEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class EventInteractionManager.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class EventInteractionManager {

	/** The my pa. */
	private PropertyAlias myPA;
	
	/** The property name. */
	private Property propertyName;
	
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
	
	/** The event operation. */
	private Operation eventOperation;
	
	/** The event count. */
	private int eventCount;
	
	/**
	 * Instantiates a new event interaction manager.
	 *
	 * @param wsdl_user_event_listinner the wsdl_user_event_listinner
	 * @param processWSDl the process ws dl
	 */
	public EventInteractionManager(Definition wsdl_user_event_listinner, Definition processWSDl) {
		this.processWSDl = processWSDl;
		this.wsdl_user_event_listinner= wsdl_user_event_listinner;
		createCorrelationSet();
	}
	
	/**
	 * Creates the correlation set.
	 */
	@SuppressWarnings("unchecked")
	private void createCorrelationSet() {
		myCS = BPELFactory.eINSTANCE.createCorrelationSet();
		myCS.setName("UserEvent");
		
		Service s1 = (Service) wsdl_user_event_listinner.getEServices().get(0);
		Port p1 = (Port) s1.getEPorts().get(0);
		for (Object op : p1.getBinding().getBindingOperations()) {
			BindingOperation opera = (BindingOperation) op;
			if (opera.getName().equals("fireEvent")){
				eventOperation = opera.getEOperation();
			}
		}
		
		myPA = MessagepropertiesFactory.eINSTANCE.createPropertyAlias();
		myPA.setMessageType(eventOperation.getInput().getMessage());

		myPA.setPart("parameters");
		propertyName = MessagepropertiesFactory.eINSTANCE.createProperty();
		propertyName.setType(XSDUtils.getPrimitive("string"));
		QName qname = new QName("test", "propertyName");
		propertyName.setQName(qname);
		propertyName.setName("propertyName");
		myPA.setPropertyName(propertyName);
		propertyName.setEnclosingDefinition(processWSDl);
		
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
		
		myCS.getProperties().add(propertyName);
		
		processWSDl.getEExtensibilityElements().add(propertyName);
		processWSDl.getEExtensibilityElements().add(myPA);
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
	 * Gets the operation.
	 *
	 * @return the operation
	 */
	public Operation getOperation() {
		return eventOperation;
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

	/**
	 * Gets the property.
	 *
	 * @return the property
	 */
	public Property getProperty() {
		return propertyName;
	}

}