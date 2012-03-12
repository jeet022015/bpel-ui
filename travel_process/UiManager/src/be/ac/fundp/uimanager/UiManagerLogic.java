package be.ac.fundp.uimanager;

import java.util.HashMap;
import java.util.Map;

import be.ac.fundp.uimanager.dispatcher.Dispatcher;
import be.ac.fundp.uimanager.dispatcher.restDispatcher.RestDispacher;

public class UiManagerLogic {
	
	static UiManagerLogic self;
	
	private int counter = 1;
	
	private String HEAD_PROCESS = "Trip";
	
	/** The my dispatchers. */
	protected Map<String, Dispatcher> myDispatchers = new HashMap<String, Dispatcher>();
	
	protected UiManagerLogic(){
		myDispatchers.put("employee", new RestDispacher(RestDispacher.DEFAULT_HOST));
		myDispatchers.put("manager", new RestDispacher("http://localhost:8070/UsiXML-WebClient/restlet/uibpel/"));
		myDispatchers.put("administrator", new RestDispacher("http://localhost:8070/UsiXML-WebClient/restlet/uibpel/"));
		//myDispatchers.put("manager", new SOAPDispatcher(SOAPDispatcher.DEFAULT_HOST));
		//myDispatchers.put("administrator", new SOAPDispatcher(SOAPDispatcher.DEFAULT_HOST));
	}
	
	public static UiManagerLogic getInstance(){
		if (self == null)
			self = new UiManagerLogic();
		return self;
	}

	public Dispatcher getDispatcher(String role) {
		return myDispatchers.get(role);
	}

	public String generateId() {
		return HEAD_PROCESS+counter++;
	}

}
