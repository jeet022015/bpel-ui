package be.ac.fundp.uimanager;

import java.util.UUID;
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
	
	protected Map<String, String> users = new HashMap<String, String>();
	
	protected Map<String, String> roleMaaping = new HashMap<String, String>();
	
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
		String uuid = UUID.randomUUID().toString();
		uuid = HEAD_PROCESS+counter+uuid;
		counter++;
		return uuid;
	}

	public void subscribe(String login, String password, String role, String ipAddress) {
		Dispatcher d = new RestDispacher("http://"+ipAddress+":8182/uibpel/");
		myDispatchers.put(role, d);
		users.put(login, password);
		roleMaaping.put(login, role);
	}

	public String verifyUser(String login, String password) {
		if (users.keySet().contains(login) && users.get(login).equals(password))
			return roleMaaping.get(login);
		return null;
	}
}
