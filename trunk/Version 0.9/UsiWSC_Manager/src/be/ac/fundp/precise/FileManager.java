package be.ac.fundp.precise;

import java.net.URL;

/**
 * The Class FileManager is responsible to identify the file path
 * of the project.
 */
public class FileManager {
	
	/** The url. */
	private static URL url = FileManager.class
			.getResource("FileManager.class");
	
	/** The class name. */
	private static String className = url.getFile();
	
	/** The Constant WEBINF. */
	private static final String WEBINF = "WEB-INF";
	
	/**
	 * Gets the root path.
	 *
	 * @return the root path
	 */
	public static String getRootPath(){
		String filePath = className.substring(0,
				className.indexOf(WEBINF));
		return filePath;
	}
}
