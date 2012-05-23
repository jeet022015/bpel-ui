package be.ac.fundp.precise.uiwsc.webClient.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import be.ac.fundp.precise.uiwsc.webClient.controller.entity.Process;

public class ModelManager {

	protected static ModelManager self;

	protected Map<String, List<Process>> myProcesses = new HashMap<String, List<Process>>();;

	protected ModelManager(){
	}

	public synchronized static ModelManager getInstance(){
		if (self == null)
			self = new ModelManager();
		return self;
	}

	public List<Process> getPendingProcesses(String role){
		List<Process> listProcess = new LinkedList<Process>();
		for (Process process : getProcessses(role)) {
			if (!process.getPendingInteractions().isEmpty())
				listProcess.add(process);
		}
		return listProcess;
	}

	private synchronized List<Process> getProcessses(String role) {
		if (myProcesses.get(role) == null)
			myProcesses.put(role, new LinkedList<Process>());
		return myProcesses.get(role);
	}

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
