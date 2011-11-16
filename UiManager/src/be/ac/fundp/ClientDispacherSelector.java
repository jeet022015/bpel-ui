package be.ac.fundp;

import java.util.HashMap;
import java.util.Map;

import be.ac.fundp.uimanager.client.Dispatcher;
import be.ac.fundp.uimanager.client.rest.RestDispacher;
import be.ac.fundp.uimanager.client.soap.SOAPDispatcher;

public class ClientDispacherSelector {

	protected static ClientDispacherSelector self;
	protected Map<String, Dispatcher> myDispatchers;
	
	private ClientDispacherSelector(){
		myDispatchers = new HashMap <String, Dispatcher>();
		myDispatchers.put("neto", new RestDispacher());
	}
	
	public static ClientDispacherSelector getInstance(){
		if (self == null)
			self = new ClientDispacherSelector();
		return self;
	}
	
	public Dispatcher getDispacher(String role){
		if (myDispatchers.containsKey(role))
			return myDispatchers.get(role);
		return new SOAPDispatcher();
	}
	
	public void publicDispacher(String role, Dispatcher newDispatcher){
		myDispatchers.put(role, newDispatcher);
	}
}