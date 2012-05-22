package be.ac.fundp.precise.userActionManagment.codeManagment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.ReadableRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import be.ac.fundp.precise.WebClientConstants;

public class CodeManager {

	static final int BUFFER = 2048;
	static protected CodeManager self;
	protected Map<String, Map<String, String>> roleCodePath = new HashMap<String, Map<String, String>>();
	static int count = 1;

	protected CodeManager() {
	}

	public static CodeManager getInstance() {
		if (self == null)
			self = new CodeManager();
		return self;
	}

	public void getCode(String process, String role, String webContentPath) {
		
		JSONObject obj =  getDesc(process, role);
		Map<String, String> mapping = new HashMap<String, String>();
		try {
			@SuppressWarnings("rawtypes")
			Iterator iter = obj.keys();
		    while(iter.hasNext()){
		        String key = (String)iter.next();
		        String value = obj.getString(key);
		        mapping.put(key, value);
		    }
		
			ClientResource itemsResource = new ClientResource(
					WebClientConstants.restHost + "/" + process +
						"/" + role + "/" + "code" + "/" + "html");

			Representation fr = itemsResource.get();
			if (fr.getMediaType().equals(MediaType.APPLICATION_ZIP)) {
				ReadableRepresentation rr = (ReadableRepresentation) fr;
				InputStream inputStream = rr.getStream();
				File zipFile = File.createTempFile(process + count++,
						"zip");
				OutputStream out = new FileOutputStream(zipFile);
				byte buf[] = new byte[BUFFER];
				int len;
				while ((len = inputStream.read(buf)) > 0)
					out.write(buf, 0, len);
				out.close();
				inputStream.close();
				Map<String, String> path = unzip(process, role, "html", zipFile,
						webContentPath, mapping);
				zipFile.deleteOnExit();
				Map<String, String> mapping2 = new HashMap<String, String>();
				for (String ui : mapping.keySet()) {
					mapping2.put(ui, path.get(mapping.get(ui)));
				}
				roleCodePath.put(process+role, mapping2);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	private JSONObject getDesc(String process, String role) {
		try {
			ClientResource itemsResource = new ClientResource(
					WebClientConstants.restHost + "/" + process +
						"/" + role + "/" + "code" + "/" +
						"html" + "/" + "desc");
			Representation fr = itemsResource.get();;
			JsonRepresentation jr = new JsonRepresentation(fr);
			return jr.getJsonObject();
		} catch (Exception e) {
			e.printStackTrace();
			return new JSONObject();
		}
	}

	private Map<String, String> unzip(String process, String role, String context,
			File auiFile, String webContentPath, Map<String, String> mapping) throws IOException {
		BufferedOutputStream dest = null;
		BufferedInputStream is = null;
		ZipEntry entry;
		ZipFile zipfile = new ZipFile(auiFile.getAbsolutePath());
		Enumeration<?> e = zipfile.entries();
		Map<String, String> codeMapping = new HashMap<String, String>();
		String codePath = webContentPath + File.separator + process
				+ File.separator + role + File.separator + context;
		while (e.hasMoreElements()) {
			entry = (ZipEntry) e.nextElement();
			is = new BufferedInputStream(zipfile.getInputStream(entry));
			int count;
			byte data[] = new byte[BUFFER];
			String filePath = codePath + File.separator + entry.getName();
			File newFile = new File(filePath);
			newFile.mkdirs();
			newFile.mkdir();
			System.out.println("entry:"+entry.getName());
			//if (entry.isDirectory()) {
			//	System.out.println("folder");
			//	continue;
			//}
			if (newFile.exists())
				newFile.delete();
			FileOutputStream baos = new FileOutputStream(newFile);
			dest = new BufferedOutputStream(baos, BUFFER);
			while ((count = is.read(data, 0, BUFFER)) != -1) {
				dest.write(data, 0, count);
			}
			dest.flush();
			dest.close();
			is.close();
			System.out.println("filePath="+filePath);
			codeMapping.put(entry.getName(), filePath.substring(filePath.indexOf("/WebContent")));
		}
		auiFile.deleteOnExit();
		return codeMapping;
	}

	public String getCodeAddress(String process, String role, String cuiId) {
		return roleCodePath.get(process+role).get(cuiId);
	}
}
