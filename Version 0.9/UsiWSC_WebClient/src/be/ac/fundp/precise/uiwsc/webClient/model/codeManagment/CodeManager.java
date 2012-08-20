package be.ac.fundp.precise.uiwsc.webClient.model.codeManagment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import be.ac.fundp.precise.uiwsc.webClient.model.exception.CodeRetreivingException;

/**
 * The Class CodeManager this class is responsible to:
 * <li>
 * <ul> get the correct code regarding the context id <ul>
 * <ul> save the code in the correct folder<ul>
 * <ul> allow the access to the code<ul>
 * </li>.
 */
public class CodeManager {

	/** The singleton instance. */
	static protected CodeManager self;
	
	/** The default context id. */
	static protected String CONTEXT_HTML_DEFAULT = "html";
	
	/** The code mapping. */
	protected Map<CodeIndex, CodeMapper> codeMapping = new HashMap<CodeIndex, CodeMapper>();

	/**
	 * Instantiates a new code manager.
	 */
	protected CodeManager() {
	}

	/**
	 * Gets the single instance of CodeManager.
	 *
	 * @return single instance of CodeManager
	 */
	public synchronized static CodeManager getInstance() {
		if (self == null)
			self = new CodeManager();
		return self;
	}

	/**
	 * Retrieve code from the UsiWSC manager.
	 *
	 * @param processId the process id
	 * @param roleId the role id
	 * @param webContentPath the web content path
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException the jSON exception
	 * @throws InterruptedException the interrupted exception
	 * @throws CodeRetreivingException the code retreiving exception
	 */
	public void retrieveCode(String processId, String roleId,
			String webContentPath) throws IOException, JSONException,
			InterruptedException, CodeRetreivingException {
		System.out.println("processId="+processId);
		System.out.println("roleId="+roleId);
		System.out.println("context="+CONTEXT_HTML_DEFAULT);
		CodeIndex index = new CodeIndex(processId, roleId, CONTEXT_HTML_DEFAULT);
		CodeMapper codeMapper = new CodeMapper(processId, roleId,
				CONTEXT_HTML_DEFAULT, webContentPath);
		codeMapping.put(index, codeMapper);
	}

	/**
	 * Gets the code path for a specific user interactions.
	 *
	 * @param processId the process id
	 * @param roleId the role id
	 * @param cuiId the cui id
	 * @return the code address
	 */
	public String getCodeAddress(String processId, String roleId, String cuiId) {
		CodeIndex index = new CodeIndex(processId, roleId, CONTEXT_HTML_DEFAULT);
		return codeMapping.get(index).getCode(cuiId);
	}
}
