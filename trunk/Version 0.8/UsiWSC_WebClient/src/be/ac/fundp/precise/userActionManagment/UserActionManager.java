package be.ac.fundp.precise.userActionManagment;

import org.restlet.resource.ClientResource;

import be.ac.fundp.precise.WebClientConstants;

public class UserActionManager {

	static UserActionManager self;

	protected UserActionManager(){
	}

	public static UserActionManager getInstance() {
		if (self == null)
			self = new UserActionManager();
		return self;
	}

	public boolean subscribe(String login, String password, String process,
			String role, String scheme, String serverName, int portNumber, String servletPath) {
		try {
			//restlet/
			System.out.println("servletPath="+servletPath);
			servletPath = servletPath.replaceAll("http://", "<http>");
			servletPath = servletPath.replaceAll("/", "<slash>");
			//String address = "<"+scheme+">"+serverName+":"+portNumber+servletPath+"<slash>restlet<slash>uibpel";
			String address = servletPath+"<slash>restlet<slash>uibpel";
			//ClientResource itemsResource = new ClientResource("http://10.0.1.3:8050/UsiWSC_Manager/restlet" +
			ClientResource itemsResource = new ClientResource(WebClientConstants.restHost +
					"/"+ process +
					"/"+ role +
					"/"+ "subscribe" +
					"/"+ login +
					"/"+ password +
					"/"+ address);
			itemsResource.get();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean login(String login, String password, String process,
			String role) {
		try {
			String address = "<http>10.0.1.0:8080<slash>test";
			ClientResource itemsResource = new ClientResource(WebClientConstants.restHost +
					"/"+ process +
					"/"+ role +
					"/"+ "login" +
					"/"+ login +
					"/"+ password +
					"/"+ address);
			itemsResource.get();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
