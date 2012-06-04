package be.ac.fundp.precise;

import java.net.URL;

public class FileManager {
	private static URL url = FileManager.class
			.getResource("FileManager.class");
	private static String className = url.getFile();
	private static final String WEBINF = "WEB-INF";
	
	public static String getRootPath(){
		String filePath = className.substring(0,
				className.indexOf(WEBINF));
		return filePath;
	}
}
