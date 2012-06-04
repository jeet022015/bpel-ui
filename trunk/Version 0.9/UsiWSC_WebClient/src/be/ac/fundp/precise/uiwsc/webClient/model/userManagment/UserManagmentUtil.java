package be.ac.fundp.precise.uiwsc.webClient.model.userManagment;

/**
 * The Class UserManagmentUtil.
 */
public class UserManagmentUtil {
	
	/** The Constant HTTP_ORIGINAL. */
	public static final String HTTP_ORIGINAL = "http://";
	
	/** The Constant HTTP_FLAG. */
	public static final String HTTP_FLAG = "<http>";
	
	/** The Constant SLASH_ORIGINAL. */
	public static final String SLASH_ORIGINAL = "/";
	
	/** The Constant SLASH_FLAG. */
	public static final String SLASH_FLAG = "<slash>";

	/**
	 * Adapt.
	 *
	 * @param originalHost the original host
	 * @return the string
	 */
	public static String adapt(String originalHost) {
		return originalHost.replaceAll(HTTP_ORIGINAL, HTTP_FLAG)
						   .replaceAll(SLASH_ORIGINAL, SLASH_FLAG);
	}

}
