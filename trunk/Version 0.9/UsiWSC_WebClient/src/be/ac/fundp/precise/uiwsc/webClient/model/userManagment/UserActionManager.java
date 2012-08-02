package be.ac.fundp.precise.uiwsc.webClient.model.userManagment;

import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import be.ac.fundp.precise.uiwsc.webClient.controller.restServer.ServerConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.ConnectionConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.codeManagment.CodeManager;

/**
 * The Class UserActionManager.
 */
public class UserActionManager {

	/** The Constant OPERATION_LOGIN. */
	private static final String OPERATION_LOGIN = "login";
	
	/** The Constant OPERATION_SUBSCRIBE. */
	private static final String OPERATION_SUBSCRIBE = "subscribe";
	
	/** The code manager. */
	protected CodeManager codeManager = CodeManager.getInstance();
	
	/** The login. */
	private String login;
	
	/** The password. */
	private String password;

	/** The host root. */
	private String hostRoot;
	
	///** The web content path. */
	//private String webContentPath;

	/**
	 * Instantiates a new user action manager.
	 *
	 * @param login the login
	 * @param password the password
	 * @param processId the process id
	 * @param roleId the role id
	 * @param hostRoot the host root
	 * @param webContentPath the web content path
	 */
	public UserActionManager(String login, String password,
								String hostRoot, String webContentPath){
		this.login = login;
		this.password = password;
		this.hostRoot = hostRoot;
		//this.webContentPath = webContentPath;
	}

	/**
	 * Subscribe.
	 *
	 * @return true, if successful
	 */
	public boolean subscribe() {
		String returnMsg = null;
		try {
			returnMsg = connectServer(OPERATION_SUBSCRIBE);
			
			return "subscribed".equals(returnMsg);
			//System.out.println(returnMsg);
			//codeManager.retrieveCode(processId, roleId, webContentPath);
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
	}

	/**
	 * Login.
	 *
	 * @return true, if successful
	 */
	public boolean login() {
		String returnMsg = null;
		try {
			returnMsg = connectServer(OPERATION_LOGIN);
			System.out.println(returnMsg);
			return "ok".equals(returnMsg);
			//codeManager.retrieveCode(processId, roleId, webContentPath);
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
	}

	/**
	 * Connect server.
	 *
	 * @param operation the operation
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private String connectServer(String operation) throws IOException {
		String hostAddress = UserManagmentUtil.adapt(hostRoot +
				ServerConstants.FULL_SERVICE_TERMINATION);
		ClientResource itemsResource = null;
		Representation r = null;
		try {
			itemsResource = new ClientResource(ConnectionConstants.USI_WSC_MANAGER_HOST +
					"/"+ operation +
					"/"+ login +
					"/"+ password +
					"/"+ hostAddress +
					"/"+ "rest_html");
			r = itemsResource.get();
			return r.getText();
		} finally {
			if (itemsResource != null)
				itemsResource.release();
			if (r != null)
				r.release();
		}
	}
}