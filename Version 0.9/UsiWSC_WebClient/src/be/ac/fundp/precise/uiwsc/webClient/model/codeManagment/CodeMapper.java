package be.ac.fundp.precise.uiwsc.webClient.model.codeManagment;

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

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.ReadableRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import be.ac.fundp.precise.uiwsc.webClient.controller.ControllerConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.ConnectionConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.exception.CodeRetreivingException;

/**
 * The Class CodeMapper, from code and Concrete UI id.
 */
public class CodeMapper {

	/** The code path mapping. */
	Map<String, String> codePathMapping = new HashMap<String, String>();
	
	/** The code counter. It is used to create unique temporary files. */
	static private int codeCounter = 1;
	
	/** The Constant BUFFER. */
	static final int BUFFER = 2048;

	/**
	 * Instantiates a new code mapper.
	 *
	 * @param processType the process type
	 * @param roleId the role id
	 * @param context the context
	 * @param webContentPath the web content path
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException the jSON exception
	 * @throws InterruptedException the interrupted exception
	 * @throws CodeRetreivingException the code retreiving exception
	 */
	public CodeMapper(String processType, String roleId, String context,
			String webContentPath) throws IOException, JSONException,
			InterruptedException, CodeRetreivingException {

		Map<String, String> cui2codeId = getCodeDescription(processType, roleId,
				context);
		String codeZipPath = getCode(processType, roleId, context);
		Map<String, String> codeId2codePath = getMappingCodeId2CodePath(
				processType, roleId, context, codeZipPath, webContentPath);
		for (String cuiId : cui2codeId.keySet()) {
			codePathMapping.put(cuiId,
					codeId2codePath.get(cui2codeId.get(cuiId)));
		}
	}

	/**
	 * Gets the code.
	 *
	 * @param processType the process type
	 * @param roleId the role id
	 * @param context the context
	 * @return the string with the code.
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 * @throws CodeRetreivingException the code retreiving exception
	 */
	private String getCode(String processType, String roleId, String context)
			throws IOException, InterruptedException, CodeRetreivingException {
		Representation fr = null;
		InputStream inputStream = null;
		OutputStream out = null;
		try {
			ClientResource itemsResource = new ClientResource(
					ConnectionConstants.USI_WSC_MANAGER_HOST + "/" + processType
							+ "/" + roleId + "/" + "code" + "/" + context);
			fr = itemsResource.get();
			if (!fr.getMediaType().equals(MediaType.APPLICATION_ZIP)) {
				// Code not available
				throw new CodeRetreivingException();
			}

			ReadableRepresentation rr = (ReadableRepresentation) fr;
			inputStream = rr.getStream();
			File zipFile = File
					.createTempFile(processType + codeCounter++, "zip");
			out = new FileOutputStream(zipFile);
			byte buf[] = new byte[BUFFER];
			int len;
			while ((len = inputStream.read(buf)) > 0)
				out.write(buf, 0, len);
			return zipFile.getCanonicalPath();
		} finally {
			if (inputStream != null)
				inputStream.close();
			if (out != null)
				out.close();
			if (fr != null)
				fr.release();
		}
	}

	/**
	 * Gets the mapping code id to code path.
	 *
	 * @param process the process
	 * @param role the role
	 * @param context the context
	 * @param auiFile the aui file
	 * @param webContentPath the web content path
	 * @return the mapping code id2 code path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private Map<String, String> getMappingCodeId2CodePath(String process,
			String role, String context, String auiFile, String webContentPath)
			throws IOException {
		ZipFile zipfile = new ZipFile(auiFile);
		Enumeration<?> e = zipfile.entries();
		Map<String, String> codeMapping = new HashMap<String, String>();
		String codePath = webContentPath + File.separator + process
				+ File.separator + role + File.separator + context;
		while (e.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) e.nextElement();
			BufferedInputStream is = new BufferedInputStream(
					zipfile.getInputStream(entry));
			int count;
			byte data[] = new byte[BUFFER];
			String filePath = codePath + File.separator + entry.getName();
			File newFile = new File(filePath);
			newFile.mkdirs();
			newFile.mkdir();
			if (newFile.exists())
				newFile.delete();
			FileOutputStream baos = new FileOutputStream(newFile);
			BufferedOutputStream dest = new BufferedOutputStream(baos, BUFFER);
			while ((count = is.read(data, 0, BUFFER)) != -1) {
				dest.write(data, 0, count);
			}
			dest.flush();
			dest.close();
			is.close();
			codeMapping.put(entry.getName(),
					ControllerConstants.contentSubPath(filePath));
		}
		return codeMapping;
	}

	/**
	 * Gets the code description.
	 *
	 * @param process the process
	 * @param role the role
	 * @param contextId the context id
	 * @return the code description
	 * @throws JSONException the jSON exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 * @throws CodeRetreivingException the code retreiving exception
	 */
	private Map<String, String> getCodeDescription(String process, String role,
			String contextId) throws JSONException, IOException,
			InterruptedException, CodeRetreivingException {
		Map<String, String> cui2codeId = new HashMap<String, String>();
		Representation fr = null;
		try {
			ClientResource itemsResource = new ClientResource(
					ConnectionConstants.USI_WSC_MANAGER_HOST + "/" + process
							+ "/" + role + "/" + "code" + "/" + contextId + "/"
							+ "desc");
			fr = itemsResource.get();
			//if (fr.getMediaType().equals(MediaType.TEXT_PLAIN)) {
			if (!fr.getMediaType().isCompatible(MediaType.APPLICATION_JSON)) {
				throw new CodeRetreivingException();
			}

			JsonRepresentation jr = new JsonRepresentation(fr);
			JSONObject obj = jr.getJsonObject();
			@SuppressWarnings("rawtypes")
			Iterator iter = obj.keys();
			while (iter.hasNext()) {
				String key = (String) iter.next();
				String value = obj.getString(key);
				cui2codeId.put(key, value);
			}
		} finally {
			if (fr != null)
				fr.release();
		}
		return cui2codeId;
	}

	/**
	 * Gets the code path to a specific Concrete User Interaction.
	 *
	 * @param cuiId the cui id
	 * @return the code path
	 */
	public String getCode(String cuiId) {
		return codePathMapping.get(cuiId);
	}

}