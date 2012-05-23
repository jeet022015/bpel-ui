package be.ac.fundp.precise.uiwsc.webClient.controller.userActions;

import org.restlet.resource.ClientResource;

import be.ac.fundp.precise.uiwsc.webClient.WebClientConstants;
import be.ac.fundp.precise.uiwsc.webClient.controller.restServer.RestServerConstants;

public class UserActionManager {

	private static final String LOGIN_CONS = "login";
	private static final String SUBSCRIBE_CONS = "subscribe";
	protected static UserActionManager self;

	protected UserActionManager(){
	}

	public static UserActionManager getInstance() {
		if (self == null)
			self = new UserActionManager();
		return self;
	}

	public boolean subscribe(String login, String password, String process,
			String role, String hostRoot) {
		try {
			String hostAddress = UserActionConstants.adapt(hostRoot + RestServerConstants.FULL_SERVICE_TERMINATION);
			ClientResource itemsResource = new ClientResource(WebClientConstants.restHost +
					"/"+ process +
					"/"+ role +
					"/"+ SUBSCRIBE_CONS +
					"/"+ login +
					"/"+ password +
					"/"+ hostAddress);
			itemsResource.get();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean login(String login, String password, String process,
			String role, String hostRoot) {
		try {
			String hostAddress = UserActionConstants.adapt(hostRoot + RestServerConstants.FULL_SERVICE_TERMINATION);
			ClientResource itemsResource = new ClientResource(WebClientConstants.restHost +
					"/"+ process +
					"/"+ role +
					"/"+ LOGIN_CONS +
					"/"+ login +
					"/"+ password +
					"/"+ hostAddress);
			itemsResource.get();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
