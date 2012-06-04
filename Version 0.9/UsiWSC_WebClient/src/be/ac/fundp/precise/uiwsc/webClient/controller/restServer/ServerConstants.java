package be.ac.fundp.precise.uiwsc.webClient.controller.restServer;

/**
 * The Class ServerConstants is responsible to 
 * specify all the constant value shared by all the Rest
 * entities.
 */
public class ServerConstants {
	
	/** The Constant REST_SERVER_ROOT. */
	public static final String REST_SERVER_ROOT = "restlet";
	
	/** The Constant REST_SERVICE. */
	public static final String REST_SERVICE = "uiwsc";
	
	/** The Constant FULL_SERVICE_TERMINATION. */
	public static final String FULL_SERVICE_TERMINATION = "/" + REST_SERVER_ROOT +
														  "/" + REST_SERVICE;
	
	/** The Constant JSON_DATA. */
	public static final String JSON_DATA = "data";

	/** The Constant JSON_ID. */
	public static final String JSON_ID = "id";

	/** The Constant JSON_TYPE. */
	public static final String JSON_TYPE = "type";

	/** The Constant JSON_CONTENT. */
	public static final String JSON_CONTENT = "content";

}
