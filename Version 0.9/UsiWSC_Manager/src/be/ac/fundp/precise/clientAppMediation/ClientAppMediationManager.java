package be.ac.fundp.precise.clientAppMediation;

import java.util.List;

import be.ac.fundp.precise.clientAppMediation.dispatcher.Dispatcher;
import be.ac.fundp.precise.clientAppMediation.dispatcher.restDispatcher.RestDispatcher;
import be.ac.fundp.precise.dataManagment.CoordinatedData;
import be.ac.fundp.precise.dataManagment.DataManager;
import be.ac.fundp.precise.dataManagment.DataManagerFactory;
import be.ac.fundp.precise.dataManagment.hibernate.dao.InteractionType;
import be.ac.fundp.precise.dataManagment.hibernate.dao.ProtocolType;

/**
 * The Class ClientAppMediationManager manages the interactions with
 * the client applications.
 * 
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date May 22, 2012
 */
public class ClientAppMediationManager {

	private static final String PROCESS_MAIN = "TravelScenario";

	/** The self. */
	protected static ClientAppMediationManager self;

	/** The data manager. */
	private DataManager dataManager;

	/**
	 * Instantiates a new client app mediation manager.
	 */
	protected ClientAppMediationManager() {
		dataManager = DataManagerFactory.hibernateDataManager();
	}

	/**
	 * Gets the single instance of ClientAppMediationManager.
	 * 
	 * @return single instance of ClientAppMediationManager
	 */
	public static ClientAppMediationManager getInstance() {
		if (self == null)
			self = new ClientAppMediationManager();
		return self;
	}

	/**
	 * This method requires an input interaction.
	 * 
	 * @param role
	 *            the user'role.
	 * @param processId
	 *            the process's id.
	 * @param userInteracId
	 *            the user interaction's id.
	 * @return the data provided by the user.
	 */
	public List<CoordinatedData> requireInputInteraction(String roleId,
			String processId, String userInteracId) {

		String userId = dataManager.getBoundUser(roleId, processId);
		int interactionRealId = dataManager.createInteraction(processId,
				userId, userInteracId);
		List<CoordinatedData> response = getDispatcher(userId)
				.requireInputInteraction(PROCESS_MAIN, processId, userInteracId, userId);
		try {
			dataManager.providedInteractionData(interactionRealId, response,
					InteractionType.Input);
			return response;
		} finally {
			if (userInteracId.equals("28") || userInteracId.equals("31")) {
				dataManager.releaseRole(roleId, processId);
			}
		}
	}

	/**
	 * Gets the dispatcher.
	 * 
	 * @param userId
	 *            the user id
	 * @return the dispatcher
	 */
	private Dispatcher getDispatcher(String userId) {
		ProtocolType protocol = dataManager.getUserProtocolType(userId);
		if (protocol.equals(ProtocolType.Rest))
			return new RestDispatcher(dataManager.getIpAddress(userId));
		return null;
	}

	/**
	 * This method requires a select interaction.
	 * 
	 * @param processId
	 *            the process's id.
	 * @param userInteracId
	 *            the user interaction's id.
	 * @param selectableData
	 *            the data which the user can select.
	 * @param role
	 *            the user's role.
	 * @return the data selected by the user.
	 */
	public List<CoordinatedData> requireSelectionInteracion(String processId,
			String userInteracId, List<CoordinatedData> selectableData,
			String roleId) {

		String userId = dataManager.getBoundUser(roleId, processId);
		int interactionRealId = dataManager.createInteraction(processId,
				userId, userInteracId);
		dataManager.providedInteractionData(interactionRealId, selectableData,
				InteractionType.Output);
		List<CoordinatedData> response = getDispatcher(userId)
				.requireSelectionInteraction(PROCESS_MAIN, processId, userInteracId,
						selectableData, userId);
		try {
			dataManager.providedInteractionData(interactionRealId, response,
					InteractionType.Input);
			return response;
		} finally {
			if (userInteracId.equals("28") || userInteracId.equals("31")) {
				dataManager.releaseRole(roleId, processId);
			}
		}

	}

	/**
	 * This method requires an output interaction.
	 * 
	 * @param processId
	 *            the process's id.
	 * @param userInteracId
	 *            the user interaction's id.
	 * @param outputData
	 *            the data to be presented to the user.
	 * @param role
	 *            the user's role.
	 */
	public void requireOutputInteracion(String processId, String userInteracId,
			List<CoordinatedData> outputData, String roleId) {

		String userId = dataManager.getBoundUser(roleId, processId);
		int interactionRealId = dataManager.createInteraction(processId,
				userId, userInteracId);
		dataManager.providedInteractionData(interactionRealId, outputData,
				InteractionType.Output);
		getDispatcher(userId).requireOutputInteraction(PROCESS_MAIN, processId,
				userInteracId, outputData, userId);

		if (userInteracId.equals("29") || userInteracId.equals("32")) {
			getDispatcherByRole(roleId, processId).releaseAll(processId);
			dataManager.finishProcess(processId);
			dataManager.releaseRole(roleId, processId);
		}
	}

	/**
	 * Gets the dispatcher by role.
	 * 
	 * @param role
	 *            the role
	 * @param processId
	 *            the process id
	 * @return the dispatcher by role
	 */
	private Dispatcher getDispatcherByRole(String role, String processId) {
		String userId = dataManager.getBoundUser(role, processId);
		return getDispatcher(userId);
	}

}
