package be.ac.fundp.precise.dataManagment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import be.ac.fundp.precise.dataManagment.model.Process;

public class ModelManager {

	protected static ModelManager self;
	
	/** The my processes. */
	protected Map<String, List<Process>> myProcesses = new HashMap<String, List<Process>>();;

	protected ModelManager(){
	}

	public synchronized static ModelManager getInstance(){
		if (self == null)
			self = new ModelManager();
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
			if (!process.getPendingInteractions().isEmpty())
				listProcess.add(process);
		}
		return listProcess;
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
		Process p = new Process(processId, role, "TravelScenario");
		getProcessses(role).add(p);
		return p;
	}
}
