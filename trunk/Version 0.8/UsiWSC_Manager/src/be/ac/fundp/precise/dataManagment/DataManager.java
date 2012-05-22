package be.ac.fundp.precise.dataManagment;

import java.util.List;

import be.ac.fundp.precise.dataManagment.hibernate.dao.InteractionType;
import be.ac.fundp.precise.dataManagment.hibernate.dao.ProtocolType;

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
	 * @param role
	 *            the user role id
	 * @param processId
	 *            the process id
	 * @return the bound user
	 */
	String getBoundUser(String roleId, String processId);

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
	 * Provided interaction data.
	 * 
	 * @param interactionRealId
	 *            the interaction real id
	 * @param response
	 *            the response
	 * @param type
	 *            the type
	 */
	void providedInteractionData(int interactionRealId,
			List<CoordinatedData> response, InteractionType type);

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
	 * Gets the user protocol type.
	 * 
	 * @param userId
	 *            the user id
	 * @return the user protocol type
	 */
	ProtocolType getUserProtocolType(String userId);

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
	String verifyUser(String login, String password);

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

}
