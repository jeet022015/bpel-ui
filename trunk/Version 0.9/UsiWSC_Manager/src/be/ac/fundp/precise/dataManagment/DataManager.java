package be.ac.fundp.precise.dataManagment;

import java.util.List;
import java.util.Map;

/**
 * The Interface DataManager represents an abstraction to the data management
 * for the UsiWSC Manager. The current version is configured to do the
 * management based on hibernate technologies.
 * 
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date May 22, 2012
 */
public interface DataManager {

	/** The id gen. */
	static IdProcessGenerator idGen = new IdProcessGenerator();

	/**
	 * Gets the bound user.
	 *
	 * @param roleId the role id
	 * @param processId the process id
	 * @return the bound user
	 * @throws Exception 
	 */
	String getBoundUser(String roleId, String processId) throws Exception;

	/**
	 * Creates the interaction.
	 * 
	 * @param processId
	 *            the process id
	 * @param userId
	 *            the user id
	 * @param userInteracId
	 *            the user interac id
	 * @return the int
	 */
	int createInteraction(String processId, String userId, String userInteracId);


	/**
	 * Release role.
	 * 
	 * @param role
	 *            the role
	 * @param processId
	 *            the process id
	 */
	void releaseRole(String role, String processId);


	/**
	 * Gets the ip address.
	 * 
	 * @param userId
	 *            the user id
	 * @return the ip address
	 */
	String getIpAddress(String userId);

	/**
	 * Finish process.
	 * 
	 * @param processId
	 *            the process id
	 */
	void finishProcess(String processId);

	/**
	 * Verify user.
	 * 
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 * @return the string
	 */
	boolean verifyUser(String login, String password);

	/**
	 * Subscribe.
	 * 
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 * @param role
	 *            the role
	 * @param host
	 *            the new host address
	 */
	void subscribe(String login, String password, String role,
			String host);

	/**
	 * Adds the role.
	 * 
	 * @param processName
	 *            the process name
	 * @param roleName
	 *            the role name
	 */
	void addRole(String processName, String roleName);

	List<String> getAvailableProcesses();

	List<String> getStartingRoles(String process);

	String bindUserToProcess(String userId, String process, String processId)
			throws InterruptedException;

	void createProcess(String processId, List<String> roles,
			List<String> startingRoles,
			Map<String, List<String>> interactionMapping) throws Exception;

	void createProcessType(String processType);

}
