package be.ac.fundp.precise.processDeployment.auiDeployment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.google.common.io.Files;

public class AuiExtractor {
	
	File zipFile;
	static final int BUFFER = 2048;
	static int fileCounter = 1;
	List<AuiRole> roles;

	public AuiExtractor(byte[] zipData, Map<String, String> description) throws IOException {
		File auiFile = File.createTempFile("auiFile"+fileCounter++, ".zip");
		File tempfolder = Files.createTempDir();
		auiFile.deleteOnExit();
		roles = new LinkedList<AuiRole>();
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(auiFile));  
		bos.write(zipData); 
		bos.close();
		BufferedOutputStream dest = null;
		BufferedInputStream is = null;
		ZipEntry entry;
		ZipFile zipfile = new ZipFile(auiFile.getAbsolutePath());
		Enumeration<?> e = zipfile.entries();
		while (e.hasMoreElements()) {
			entry = (ZipEntry) e.nextElement();
			System.out.println("entry:"+entry);
			is = new BufferedInputStream(zipfile.getInputStream(entry));
			int count;
			byte data[] = new byte[BUFFER];
			File path = new File( tempfolder.getCanonicalPath()+File.separator+entry.getName());
			//HERE CREATE A TEMP FILE
			FileOutputStream baos = new FileOutputStream(path);
			//ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
			dest = new BufferedOutputStream(baos, BUFFER);
			while ((count = is.read(data, 0, BUFFER)) != -1) {
				dest.write(data, 0, count);
			}
			dest.flush();
			dest.close();
			is.close();
			AuiRole role = new AuiRole();
			role.setRoleName(description.get(entry.getName()));
			role.setFileName(path);
			roles.add(role);
		}
	}

	public List<AuiRole> getAllRoles() {
		return roles;
	}

}
