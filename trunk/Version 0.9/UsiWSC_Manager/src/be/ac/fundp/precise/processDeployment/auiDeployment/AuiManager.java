package be.ac.fundp.precise.processDeployment.auiDeployment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.google.common.io.Files;

/**
 * The Class AuiManager is responsible to manage the AUI.
 */
public class AuiManager {

	/** The Constant BUFFER. */
	private static final int BUFFER = 2048;

	/** The self. */
	protected static AuiManager self;
	
	/** The file diff. */
	protected static int fileDiff = 1;
	
	/** The adapter mapping. */
	private Map<String, AuiAdapter> adapterMapping = new HashMap<String, AuiAdapter>();
	
	/**
	 * Instantiates a new aui manager.
	 */
	protected AuiManager() {

	}

	/**
	 * Gets the single instance of AuiManager.
	 *
	 * @return single instance of AuiManager
	 */
	public static AuiManager getInstance() {
		if (self == null)
			self = new AuiManager();
		return self;
	}

	/**
	 * New aui.
	 *
	 * @param processType the process type
	 * @param file the file
	 * @param userRoles the user roles
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void newAui(String processType, byte[] file, List<UserRole> userRoles) throws IOException {
		Map<String, String> entryZipFileMapping = unzip(file);
		AuiAdapter adapter = new AuiAdapter();
		for (UserRole userRole : userRoles) {
			String roleAuiFile = entryZipFileMapping.get(userRole.getAuiEntry());
			AuiRoleMapper role = new AuiRoleMapper(userRole.getRole(), roleAuiFile, userRole.getUiMapping());
			adapter.addRole(role);
		}
		adapterMapping.put(processType, adapter);
	}
	
	/**
	 * Unzip.
	 *
	 * @param zipData the zip data
	 * @return the map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private Map<String, String> unzip(byte[] zipData) throws IOException {
		Map<String, String> unzipMapping = new HashMap<String, String>();
		File tempAuiFile = File.createTempFile("auiFile"+fileDiff++, ".zip");
		tempAuiFile.deleteOnExit();

		File tempEntryFolder = Files.createTempDir();
		BufferedOutputStream contentStream = new BufferedOutputStream(new FileOutputStream(tempAuiFile));  
		contentStream.write(zipData);
		contentStream.close();

		ZipFile auiZipFile = new ZipFile(tempAuiFile.getCanonicalPath());
		Enumeration<?> e = auiZipFile.entries();
		while (e.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) e.nextElement();
			BufferedInputStream entryStream = new BufferedInputStream(auiZipFile.getInputStream(entry));
			
			int count;
			byte dataBuffer[] = new byte[BUFFER];
			File tempAuiEntryFile = new File( tempEntryFolder.getCanonicalPath()+File.separator+entry.getName());
			BufferedOutputStream dest = new BufferedOutputStream(new FileOutputStream(tempAuiEntryFile), BUFFER);

			while ((count = entryStream.read(dataBuffer, 0, BUFFER)) != -1) {
				dest.write(dataBuffer, 0, count);
			}
			dest.flush();
			dest.close();
			entryStream.close();
			unzipMapping.put(entry.getName(), tempAuiEntryFile.getCanonicalPath());
		}
		auiZipFile.close();
		return unzipMapping;
	}

	/**
	 * Adapt aui.
	 *
	 * @param processType the process type
	 * @param role the role
	 * @param contextId the context id
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String adaptAui(String processType, String role, String contextId) throws IOException {
		AuiAdapter auiAdapter = adapterMapping.get(processType);
		if (auiAdapter == null)
			return null;
		return auiAdapter.adapt(role, contextId);
	}
	
	/**
	 * Adaptation description.
	 *
	 * @param processType the process type
	 * @param role the role
	 * @param contextId the context id
	 * @return the map
	 */
	public Map<String, String> adaptationDescription(String processType, String role, String contextId) {
		AuiAdapter auiAdapter = adapterMapping.get(processType);
		if (auiAdapter == null)
			return null;
		return auiAdapter.adaptationDesc(role, contextId);
	}
}
