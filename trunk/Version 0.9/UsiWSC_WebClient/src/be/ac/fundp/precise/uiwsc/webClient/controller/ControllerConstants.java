package be.ac.fundp.precise.uiwsc.webClient.controller;

/**
 * The Class ControllerConstants is responsible to 
 * specify all the constant value shared by all the Controller
 * entities.
 */
public class ControllerConstants {

	/** The Constant to specify the user login. */
	public static final String CONTROLLER_LOGIN = "login";

	/** The Constant to specify the user role. */
	public static final String CONTROLLER_ROLE = "role";

	/** The Constant to specify the process id. */
	public static final String CONTROLLER_PROCESS_ID = "processId";

	/** The Constant to specify the concrete UI id. */
	public static final String CONTROLLER_CUI_ID = "cuiId";

	/** The Constant to specify the process type. */
	public static final String CONTROLLER_PROCESS = "process";

	/** The Constant to specify the user password. */
	public static final String CONTROLLER_PASSWORD = "password";

	/** The Constant to specify the web content path. */
	public static final String WEB_CONTENT = "/WebContent";

	/**
	 * This method set the root path.
	 * 
	 * @param originalPath
	 *            the original path from any class
	 * @return the root path of the process
	 */
	public static String contentSubPath(String originalPath) {
		return originalPath.substring(originalPath.indexOf("/WebContent"));
	}
}
