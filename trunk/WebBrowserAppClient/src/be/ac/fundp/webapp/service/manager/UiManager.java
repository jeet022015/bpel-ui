package be.ac.fundp.webapp.service.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import be.ac.fundp.webapp.service.provider.DataItemType;
import be.ac.fundp.webapp.service.representation.DataItem;
import be.ac.fundp.webapp.service.representation.Process;
import be.ac.fundp.webapp.service.representation.UserInteraction;
import be.ac.fundp.webapp.service.util.ThreadEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class UiManager.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class UiManager {
	
	/** The self. */
	protected static UiManager self;
	
	/** The processes. */
	protected Map<String, Map<String, Process>> processes = new HashMap<String, Map<String, Process>>();
	
	/** The waiters. */
	protected Map<String, ThreadEvent> waiters = new HashMap<String, ThreadEvent>();
	
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
	 * Adds the user interaction.
	 *
	 * @param cuiId the cui id
	 * @param role the role
	 * @param processId the process id
	 * @param dataToPresent the data to present
	 */
	public void addUserInteraction(String cuiId, String role, String processId, List<DataItemType> dataToPresent){
		Process myProcess = retrieveProcess(role, processId);
		if (myProcess == null) {
			Map<String, Process> myProcessMap = processes.get(role);
			myProcess = new Process(processId, role);
			myProcessMap.put(processId, myProcess);
			processes.put(role, myProcessMap);
			System.out.println("created a New process with id = "+ processId);
		}
		
		//FIXME put the responsibility to create the User Interaction for the Process.
		UserInteraction thisUserInteraction = new UserInteraction(cuiId);
		for (DataItemType dataItemType : dataToPresent) {
			thisUserInteraction.addPresentedDataItem(dataItemType.getDataItemId(),
					dataItemType.getTypeName(), dataItemType.getData());
		}
		myProcess.addUserInteraction(thisUserInteraction);
	}
	
	/**
	 * Wait data from user.
	 *
	 * @param cuiId the cui id
	 * @param role the role
	 * @param processId the process id
	 * @return the list
	 * @throws InterruptedException the interrupted exception
	 */
	public List<DataItem> waitDataFromUser(String cuiId, String role, String processId) throws InterruptedException{
		String token = role+processId+cuiId;
		ThreadEvent locker;
		synchronized (this) {
			if (waiters.containsKey(token)){
				locker = waiters.get(token);
			} else {
				locker = new ThreadEvent();
				waiters.put(token, locker);
			}
		}
		
		System.out.println("is waiting for "+token);
		locker.await();
		System.out.println("token released "+token);
		Process myProcess = retrieveProcess(role, processId);
		return myProcess.getProvidedData(cuiId);
	}
	
	/**
	 * User interacion performed.
	 *
	 * @param cuiId the cui id
	 * @param role the role
	 * @param processId the process id
	 */
	public void userInteracionPerformed(String cuiId, String role, String processId){
		String token = role+processId+cuiId;
		ThreadEvent locker = waiters.get(token);
		if (locker !=  null){
			locker.signal();
		}
	}

	/**
	 * Retrieve process.
	 *
	 * @param role the role
	 * @param processId the process id
	 * @return the process
	 */
	public Process retrieveProcess(String role, String processId) {
		Map<String, Process> myProcessMap;
		if (processes.containsKey(role)) {
			System.out.println("contains ROLE");
			myProcessMap = processes.get(role);
		} else {
			myProcessMap = new HashMap<String, Process>();
			processes.put(role, myProcessMap);
		}
		
		Process myProcess = null;
		if (myProcessMap.containsKey(processId)) {
			myProcess = myProcessMap.get(processId);
		}else {
			System.out.println("but havent the process.");
		}
		return myProcess;
	}
	
	/**
	 * Checks for pending user interacions.
	 *
	 * @param role the role
	 * @return true, if successful
	 */
	public boolean hasPendingUserInteracions(String role){
		if (!processes.containsKey(role)){;
			return false;
		}
		for (Process aProcess : processes.get(role).values()) {
			if (aProcess.hasPendingUserInteracions()) 
				return true;
		}
		return false;
	}
	
	/**
	 * Gets the pending processes.
	 *
	 * @param role the role
	 * @return the pending processes
	 */
	public List<Process> getPendingProcesses(String role){
		List<Process> pendingProcesses = new LinkedList<Process>();
		Collection<Process> myprocesses = processes.get(role).values();
		for (Process aProcess : myprocesses) {
			if (aProcess.hasPendingUserInteracions()) 
				pendingProcesses.add(aProcess);
		}
		return pendingProcesses;
	}
}