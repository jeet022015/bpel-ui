package be.ac.fundp.uimanager;

import java.util.HashMap;
import java.util.Map;

import be.ac.fundp.uimanager.client.Dispatcher;
import be.ac.fundp.uimanager.client.rest.RestDispacher;
import be.ac.fundp.uimanager.client.soap.SOAPDispatcher;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientDispacherSelector.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class ClientDispacherSelector {

	/** The self. */
	protected static ClientDispacherSelector self;
	
	/** The my dispatchers. */
	protected Map<String, Dispatcher> myDispatchers;
	
	/**
	 * Instantiates a new client dispacher selector.
	 */
	private ClientDispacherSelector(){
		myDispatchers = new HashMap <String, Dispatcher>();
		myDispatchers.put("neto", new RestDispacher());
	}
	
	/**
	 * Gets the single instance of ClientDispacherSelector.
	 *
	 * @return single instance of ClientDispacherSelector
	 */
	public static ClientDispacherSelector getInstance(){
		if (self == null)
			self = new ClientDispacherSelector();
		return self;
	}
	
	/**
	 * Gets the dispacher.
	 *
	 * @param role the role
	 * @return the dispacher
	 */
	public Dispatcher getDispacher(String role){
		if (myDispatchers.containsKey(role))
			return myDispatchers.get(role);
		return new SOAPDispatcher();
	}
	
	/**
	 * Public dispacher.
	 *
	 * @param role the role
	 * @param newDispatcher the new dispatcher
	 */
	public void publicDispacher(String role, Dispatcher newDispatcher){
		myDispatchers.put(role, newDispatcher);
	}
}