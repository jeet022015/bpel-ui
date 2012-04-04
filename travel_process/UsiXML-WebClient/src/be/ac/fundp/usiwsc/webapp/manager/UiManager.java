package be.ac.fundp.usiwsc.webapp.manager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import be.ac.fundp.usiwsc.webapp.model.Process;
import be.ac.fundp.usiwsc.webapp.model.UserInteraction;

// TODO: Auto-generated Javadoc
/**
 * The Class UiManager.
 */
public class UiManager {
	
	/** The self. */
	protected static UiManager self;
	
	/** The my processes. */
	protected Map<String, List<Process>> myProcesses = new HashMap<String, List<Process>>();
	
	/**
	 * Instantiates a new ui manager.
	 */
	private UiManager (){
	}
	
	/**
	 * Gets the single instance of UiManager.
	 *
	 * @return single instance of UiManager
	 */
	public static UiManager getInstance(){
		if (self == null)
			self = new UiManager();
		return self;
	}
	
	/**
	 * Gets the pending processes.
	 *
	 * @param role the role
	 * @return the pending processes
	 */
	public List<Process> getPendingProcesses(String role){
		List<Process> listProcess = new LinkedList<Process>();
		for (Process process : getProcessses(role)) {
			System.out.println("process="+process.getDisplayableName());
			System.out.println("process pending="+process.getPendingInteractions());
			if (!process.getPendingInteractions().isEmpty())
				listProcess.add(process);
		}
		return listProcess;
	}

	/**
	 * Gets the data provided by user.
	 *
	 * @param role the role
	 * @param processId the process id
	 * @param cuiId the cui id
	 * @return the data provided by user
	 */
	public UserInteraction getDataProvidedByUser(String role, String processId,
			String cuiId) {
		Process p = getProcess(role, processId);
		return p.getUserInteraction(cuiId);
	}

	/**
	 * Gets the process.
	 *
	 * @param role the role
	 * @param processId the process id
	 * @return the process
	 */
	public synchronized Process getProcess(String role, String processId) {
		for (Process existingProcess : getProcessses(role)) {
			if (existingProcess.getId().equals(processId))
				return existingProcess;
		}
		Process p = new Process(processId);
		getProcessses(role).add(p);
		return p;
	}

	/**
	 * Gets the processses.
	 *
	 * @param role the role
	 * @return the processses
	 */
	private synchronized List<Process> getProcessses(String role) {
		if (myProcesses.get(role) == null)
			myProcesses.put(role, new LinkedList<Process>());
		return myProcesses.get(role);
	}

}
