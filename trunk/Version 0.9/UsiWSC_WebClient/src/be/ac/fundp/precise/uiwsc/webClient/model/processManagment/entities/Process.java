package be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities;

import java.util.LinkedList;
import java.util.List;

import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.ProcessPrefix;

/**
 * The Class Process.
 */
public class Process {

	/** The id. */
	protected String id;

	/** The role. */
	protected String userId;
	
	/** The process type. */
	protected String type;
	
	protected String roleId;
	
	/** The displayable name. */
	protected String displayableName;
	
	/** The sequence. */
	private static ProcessPrefix sequence = new ProcessPrefix();

	/** The inner interactions. */
	protected List<UserInteraction> innerInteractions = new LinkedList<UserInteraction>();
	
	/**
	 * Instantiates a new process.
	 *
	 * @param processId the process id
	 * @param processType the process type
	 * @param userId2 
	 * @param newUserId the user id
	 */
	public Process(String processId, String processType, String role, String userId) {
		id = processId;
		type = processType;
		this.userId = userId;
		roleId = role;
		displayableName = processType +"-"+ sequence.next();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	public String getRole() {
		return roleId;
	}
	
	/**
	 * Gets the displayable name.
	 *
	 * @return the displayable name
	 */
	public String getDisplayableName() {
		return displayableName;
	}

	/**
	 * Gets the user interaction.
	 *
	 * @param uiId the ui id
	 * @return the user interaction
	 */
	public UserInteraction getUserInteraction(String uiId) {
		for (UserInteraction aUserInteraction : innerInteractions) {
			if (aUserInteraction.getId().equals(uiId)){
				return aUserInteraction;
			}
		}
		return null;
	}

	/**
	 * Adds the user interaction.
	 *
	 * @param cuiId the cui id
	 * @param availableData the available data
	 */
	public void addUserInteraction(String cuiId, List<DataItem> availableData) {
		UserInteraction innerInterac = getUserInteraction(cuiId);
		System.out.println("is created?");
		if (innerInterac != null)
			return;
		System.out.println("is created=====");
		innerInterac = new UserInteraction(this, cuiId);
		innerInterac.setAvailableData(availableData);
		System.out.println("innerInterac="+innerInterac);
		innerInteractions.add(innerInterac);
	}

	/**
	 * Cancel interactions.
	 */
	public void cancelInteractions() {
		for (UserInteraction interaction : innerInteractions) {
			interaction.setCanceled(true);
		}
	}

	/**
	 * Gets the pending interacions.
	 *
	 * @return the pending interacions
	 */
	public List<UserInteraction> getPendingInteracions() {
		List<UserInteraction> pendingInteractions = new LinkedList<UserInteraction>();
		for (UserInteraction interacion : innerInteractions) {
			if (interacion.isPending())
				pendingInteractions.add(interacion);
		}
		return pendingInteractions;
	}

	/**
	 * Checks for pending interacion.
	 *
	 * @return true, if successful
	 */
	public boolean hasPendingInteracion() {
		for (UserInteraction interaction : innerInteractions) {
			if(interaction.isPending())
				return true;
		}
		return false;
	}

	/**
	 * Gets the User Id.
	 *
	 * @return the user Id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Count pending interactions.
	 *
	 * @return the int
	 */
	public int countPendingInteractions() {
		int pendingInteractions = 0;
		for (UserInteraction interaction : innerInteractions) {
			if(interaction.isPending())
				pendingInteractions++;
		}
		return pendingInteractions;
	}

	/**
	 * Gets the process type.
	 *
	 * @return the process type
	 */
	public String getType() {
		return type;
	}

}