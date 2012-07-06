package be.ac.fundp.precise.clientAppMediation;

import java.util.Collections;
import java.util.List;

import be.ac.fundp.precise.clientAppMediation.dispatcher.Dispatcher;
import be.ac.fundp.precise.clientAppMediation.dispatcher.restDispatcher.RestDispatcher;
import be.ac.fundp.precise.dataManagment.CoordinatedData;
import be.ac.fundp.precise.dataManagment.DataManagerFactory;
import be.ac.fundp.precise.dataManagment.hibernate.NewDataManagerHibernate;
import be.ac.fundp.precise.dataManagment.hibernate.daos.ProtocolType;

/**
 * The Class ClientAppMediationManager manages the interactions with
 * the client applications.
 * 
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date May 22, 2012
 */
public class ClientAppMediationManager {

	//private static final String PROCESS_MAIN = "TravelScenario";

	/** The self. */
	protected static ClientAppMediationManager self;

	/** The data manager. */
	//private DataManager dataManager;
	private NewDataManagerHibernate dataManager;

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
	 * @param processInstanceId
	 *            the process's id.
	 * @param userInteracId
	 *            the user interaction's id.
	 * @return the data provided by the user.
	 */
	public List<CoordinatedData> requireInputInteraction(String roleId,
			String processInstanceId, String userInteracId) {
		try {
			String userId = getUser(roleId, processInstanceId);
			String processId = dataManager.getProcessId(processInstanceId);
//			int interactionRealId = dataManager.createInteraction(processInstanceId,
//				userId, userInteracId);
			List<CoordinatedData> response = getDispatcher(userId)
				.requireInputInteraction(processId, roleId, processInstanceId, userInteracId, userId);
//				.requireInputInteraction(PROCESS_MAIN, roleId, processInstanceId, userInteracId, userId);
//			dataManager.providedInteractionData(interactionRealId, response,
//					InteractionType.Input);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		} finally {
			if (userInteracId.equals("28") || userInteracId.equals("31")) {
				dataManager.releaseRole(roleId, processInstanceId);
			}
		}
	}

	private String getUser(String roleId, String processInstanceId) throws Exception{
		try {
			return dataManager.getBindUser(roleId, processInstanceId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	/**
	 * Gets the dispatcher.
	 * 
	 * @param userId
	 *            the user id
	 * @return the dispatcher
	 * @throws Exception 
	 */
	private Dispatcher getDispatcher(String userId) throws Exception {
		ProtocolType protocol = dataManager.getUserProtocolType(userId);
		if (protocol.equals(ProtocolType.Rest))
			return new RestDispatcher(dataManager.getIpAddress(userId));
		return null;
	}

	/**
	 * This method requires a select interaction.
	 * 
	 * @param processInstanceId
	 *            the process's id.
	 * @param userInteracId
	 *            the user interaction's id.
	 * @param selectableData
	 *            the data which the user can select.
	 * @param role
	 *            the user's role.
	 * @return the data selected by the user.
	 */
	public List<CoordinatedData> requireSelectionInteracion(String processInstanceId,
			String userInteracId, List<CoordinatedData> selectableData,
			String roleId) {
		try {
			String userId =  getUser(roleId, processInstanceId);
			String processId = dataManager.getProcessId(processInstanceId);
//			String userId = dataManager.getBoundUser(roleId, processId);
//			int interactionRealId = dataManager.createInteraction(processInstanceId,
//				userId, userInteracId);
//			dataManager.providedInteractionData(interactionRealId, selectableData,
//				InteractionType.Output);
			List<CoordinatedData> response = getDispatcher(userId)
//				.requireSelectionInteraction(PROCESS_MAIN, roleId, processInstanceId, userInteracId,
				.requireSelectionInteraction(processId, roleId, processInstanceId, userInteracId,
						selectableData, userId);
//			dataManager.providedInteractionData(interactionRealId, response,
//					InteractionType.Input);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		} finally {
			if (userInteracId.equals("28") || userInteracId.equals("31")) {
				dataManager.releaseRole(roleId, processInstanceId);
			}
		}

	}

	/**
	 * This method requires an output interaction.
	 * 
	 * @param processInstanceId
	 *            the process's id.
	 * @param userInteracId
	 *            the user interaction's id.
	 * @param outputData
	 *            the data to be presented to the user.
	 * @param role
	 *            the user's role.
	 */
	public void requireOutputInteracion(String processInstanceId, String userInteracId,
			List<CoordinatedData> outputData, String roleId) {

		try {
			String userId =  getUser(roleId, processInstanceId);
			String processId = dataManager.getProcessId(processInstanceId);
//			String userId = dataManager.getBoundUser(roleId, processInstanceId);
//			int interactionRealId = dataManager.createInteraction(processInstanceId,
//				userId, userInteracId);
//			dataManager.providedInteractionData(interactionRealId, outputData,
//				InteractionType.Output);
//			getDispatcher(userId).requireOutputInteraction(PROCESS_MAIN, roleId, processInstanceId,
			getDispatcher(userId).requireOutputInteraction(processId, roleId, processInstanceId,
					userInteracId, outputData, userId);
		if (userInteracId.equals("29") || userInteracId.equals("32")) {
			getDispatcherByRole(roleId, processInstanceId).releaseAll(processInstanceId);
			dataManager.finishProcess(processInstanceId);
			dataManager.releaseRole(roleId, processInstanceId);
		}
		}catch (Exception e) {
			e.printStackTrace();
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
	 * @throws Exception 
	 */
	private Dispatcher getDispatcherByRole(String roleId, String processInstanceId) throws Exception {
		//String userId = dataManager.getBoundUser(role, processId);
		String userId =  getUser(roleId, processInstanceId);
		return getDispatcher(userId);
	}

}
