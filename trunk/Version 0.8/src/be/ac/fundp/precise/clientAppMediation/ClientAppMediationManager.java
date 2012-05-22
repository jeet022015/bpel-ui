package be.ac.fundp.precise.clientAppMediation;

import java.util.List;

import be.ac.fundp.precise.clientAppMediation.dispatcher.Dispatcher;
import be.ac.fundp.precise.clientAppMediation.dispatcher.restDispatcher.RestDispatcher;
import be.ac.fundp.precise.dataManagment.CoordinatedData;
import be.ac.fundp.precise.dataManagment.DataManager;
import be.ac.fundp.precise.dataManagment.DataManagerFactory;
import be.ac.fundp.precise.dataManagment.hibernate.dao.InteractionType;
import be.ac.fundp.precise.dataManagment.hibernate.dao.ProtocolType;

public class ClientAppMediationManager {
	
	protected static ClientAppMediationManager self;
	
	private DataManager dataManager;
	
	protected ClientAppMediationManager(){
		dataManager = DataManagerFactory.hibernateDataManager();
	}
	
	public static ClientAppMediationManager getInstance(){
		if (self == null)
			self = new ClientAppMediationManager();
		return self;
	}
	
	/**
	 * This method requires an input interaction.
	 *
	 * @param role the user'role.
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @return the data provided by the user.
	 */
	public List<CoordinatedData> requireInputInteraction(String role,
			String processId, String userInteracId) {

		dataManager.createRoleIfNecessary(role);
		dataManager.createProcessIfNecessary(processId);

		String userId = dataManager.getUser(role, processId);
		int interactionRealId = dataManager.createInteraction(processId, userId, userInteracId);
		List<CoordinatedData> response = getDispatcher(userId)
				.requireInputInteraction(processId, userInteracId, role);
		try {
			dataManager.providedInteractionData(interactionRealId, response, InteractionType.Input);
			return response;
		} finally {
			if (userInteracId.equals("28") || userInteracId.equals("31")){
				dataManager.releaseRole(role, processId);
			}
		}
	}

	private Dispatcher getDispatcher(String userId) {
		ProtocolType protocol = dataManager.getUserProtocolType(userId);
		if (protocol.equals(ProtocolType.Rest))
			return new RestDispatcher(dataManager.getIpAddress(userId));
		return null;
	}

	/**
	 * This method requires a select interaction.
	 *
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @param selectableData the data which the user can select.
	 * @param role the user's role.
	 * @return the data selected by the user.
	 */
	public List<CoordinatedData> requireSelectionInteracion(String processId,
			String userInteracId, List<CoordinatedData> selectableData,
			String role) {
		dataManager.createRoleIfNecessary(role);
		dataManager.createProcessIfNecessary(processId);

		String userId = dataManager.getUser(role, processId);
		int interactionRealId = dataManager.createInteraction(processId, userId, userInteracId);
		dataManager.providedInteractionData(interactionRealId, selectableData, InteractionType.Output);
		List<CoordinatedData> response = getDispatcher(userId)
				.requireSelectionInteraction(processId, userInteracId,
				selectableData, role);
		try {
			dataManager.providedInteractionData(interactionRealId, response, InteractionType.Input);
			return response;
		} finally {
			if (userInteracId.equals("28") || userInteracId.equals("31")){
				dataManager.releaseRole(role, processId);
			}
		}
		
	}

	/**
	 * This method requires an output interaction.
	 *
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @param outputData the data to be presented to the user.
	 * @param role the user's role.
	 */
	public void requireOutputInteracion(String processId, String userInteracId,
			List<CoordinatedData> outputData, String role) {

		dataManager.createRoleIfNecessary(role);
		dataManager.createProcessIfNecessary(processId);

		String userId = dataManager.getUser(role, processId);
		int interactionRealId = dataManager.createInteraction(processId, userId, userInteracId);
		dataManager.providedInteractionData(interactionRealId, outputData, InteractionType.Output);
		getDispatcher(userId).requireOutputInteraction(processId,
				userInteracId, outputData, role);
		
		if (userInteracId.equals("29") || userInteracId.equals("32")) {
			getDispatcherByRole(role, processId).releaseAll(processId);
			dataManager.finishProcess(processId);
			dataManager.releaseRole(role, processId);
		}
	}

	private Dispatcher getDispatcherByRole(String role, String processId) {
		dataManager.createRoleIfNecessary(role);
		dataManager.createProcessIfNecessary(processId);

		String userId = dataManager.getUser(role, processId);
		return getDispatcher(userId);
	}

}
