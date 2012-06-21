package be.ac.fundp.precise.uiwsc.webClient.model.processManagment;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import be.ac.fundp.precise.uiwsc.webClient.model.ConnectionConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.DataItem;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.Process;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.UserInteraction;

/**
 * The Class ProcessManager manages the available processes.
 */
public class ProcessManager {

	/** The singleton instance. */
	protected static ProcessManager self;

	/** The process binder. */
	protected Map<String, Map<String, Process>> processBinder = new HashMap<String, Map<String, Process>>();

	/**
	 * Instantiates a new process manager.
	 */
	protected ProcessManager() {
	}

	/**
	 * Gets the single instance of ProcessManager.
	 *
	 * @return single instance of ProcessManager
	 */
	public synchronized static ProcessManager getInstance() {
		if (self == null)
			self = new ProcessManager();
		return self;
	}

	/**
	 * New interaction.
	 *
	 * @param userId the user id
	 * @param processId the process id
	 * @param processType the process type
	 * @param cuiId the cui id
	 * @param availableData the available data
	 */
	public void newInteraction(String userId, String processId,
			String processType, String cuiId, List<DataItem> availableData) {
		createProcessMap(userId);
		createProcess(userId, processId, processType);
		Map<String, Process> userProcess = processBinder.get(userId);
		Process p = userProcess.get(processId);
		p.addUserInteraction(cuiId, availableData);
	}

	/**
	 * Creates the process map.
	 *
	 * @param userId the user id
	 */
	private synchronized void createProcessMap(String userId) {
		if (!processBinder.containsKey(userId)) {
			processBinder.put(userId, new HashMap<String, Process>());
		}
	}

	/**
	 * Creates the process.
	 *
	 * @param userId the user id
	 * @param processId the process id
	 * @param processType the process type
	 */
	private synchronized void createProcess(String userId, String processId,
			String processType) {
		Map<String, Process> userProcess = processBinder.get(userId);
		if (!userProcess.containsKey(processId)) {
			userProcess.put(processId, new Process(processId, processType,
					userId));
		}
	}

	/**
	 * Gets the provided data.
	 *
	 * @param user the user
	 * @param processId the process id
	 * @param cuiId the cui id
	 * @return the provided data
	 */
	public List<DataItem> getProvidedData(String user, String processId,
			String cuiId) {
		Process p = getProcess(user, processId);
		if (p == null)
			return null;
		return p.getUserInteraction(cuiId).getProvidedData();
	}

	/**
	 * Gets the process.
	 *
	 * @param user the user
	 * @param processId the process id
	 * @return the process
	 */
	private Process getProcess(String user, String processId) {
		if (!processBinder.containsKey(user))
			return null;
		Map<String, Process> userProcess = processBinder.get(user);
		if (!userProcess.containsKey(processId))
			return null;
		return userProcess.get(processId);
	}

	/**
	 * Gets the user interaction.
	 *
	 * @param processId the process id
	 * @param user the user
	 * @param cuiId the cui id
	 * @return the user interaction
	 */
	public UserInteraction getUserInteraction(String processId, String user,
			String cuiId) {
		Process p = getProcess(user, processId);
		if (p == null)
			return null;
		return p.getUserInteraction(cuiId);
	}

	/**
	 * Gets the pending interactions.
	 *
	 * @param user the user
	 * @param processId the process id
	 * @return the pending interactions
	 */
	public List<UserInteraction> getPendingInteractions(String user,
			String processId) {
		Process p = getProcess(user, processId);
		if (p == null)
			return Collections.emptyList();
		return p.getPendingInteracions();
	}

	/**
	 * Gets the pending processes.
	 *
	 * @param user the user
	 * @return the pending processes
	 */
	public List<Process> getPendingProcesses(String user) {
		List<Process> pendingProcess = new LinkedList<Process>();
		if (!processBinder.containsKey(user))
			return Collections.emptyList();
		for (Process process : processBinder.get(user).values()) {
			if (process.hasPendingInteracion())
				pendingProcess.add(process);
		}
		return pendingProcess;
	}

	public void startProcess(String login, String process) {
		Representation r = null;
		try {
			ClientResource itemsResource = new ClientResource(ConnectionConstants.USI_WSC_MANAGER_HOST +
					"/"+ process +
					"/"+ login +
					"/start");
			r = itemsResource.get();
			System.out.println("r="+r);
		} finally {
			if (r != null)
				r.release();
		}
	}
}
