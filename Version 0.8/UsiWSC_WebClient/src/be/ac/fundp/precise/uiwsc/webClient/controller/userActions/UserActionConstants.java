package be.ac.fundp.precise.uiwsc.webClient.controller.userActions;

public class UserActionConstants {
	
	public static final String HTTP_ORIGINAL = "http://";
	
	public static final String HTTP_FLAG = "<http>";
	
	public static final String SLASH_ORIGINAL = "/";
	
	public static final String SLASH_FLAG = "<slash>";

	public static String adapt(String originalHost) {
		return originalHost.replaceAll(HTTP_ORIGINAL, HTTP_FLAG)
						   .replaceAll(SLASH_ORIGINAL, SLASH_FLAG);
	}

}
