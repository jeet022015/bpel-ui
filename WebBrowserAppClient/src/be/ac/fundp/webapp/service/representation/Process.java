package be.ac.fundp.webapp.service.representation;

import java.util.LinkedList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Process.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class Process {

	/** The process id. */
	protected String processId;
	
	/** The process interactions. */
	protected List<UserInteraction> processInteractions = new LinkedList<UserInteraction>();
	
	/**
	 * Instantiates a new process.
	 *
	 * @param id the id
	 * @param role the role
	 */
	public Process (String id){
		processId = id;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId(){
		return processId;
	}

	/**
	 * Contain user inter.
	 *
	 * @param cuiId the cui id
	 * @return true, if successful
	 */
//	public boolean containUserInter(String cuiId) {
//		for (UserInteraction aUserInteraction : processInteractions) {
//			if (aUserInteraction.getId().equals(cuiId)){
//				return true;
//			}
//		}
//		return false;
//	}

	/**
	 * Retrieve user inter.
	 *
	 * @param cuiId the cui id
	 * @return the user interaction
	 */
	public UserInteraction retrieveUserInter(String cuiId) {
		for (UserInteraction aUserInteraction : processInteractions) {
			if (aUserInteraction.getId().equals(cuiId)){
				return aUserInteraction;
			}
		}
		return null;
	}

	/**
	 * Gets the provided data.
	 *
	 * @param cuiId the cui id
	 * @return the provided data
	 */
//	public List<DataItem> getProvidedData(String cuiId) {
//		UserInteraction thisUserInt = retrieveUserInter(cuiId);
//		return thisUserInt.getProvidedData();
//	}

	/**
	 * Checks for pending user interacions.
	 *
	 * @return true, if successful
	 */
	public boolean hasPendingUserInteracions() {
		if (processInteractions.size() == 0)
			return false;
		for (UserInteraction ui : processInteractions) {
			if (!ui.performed)
				return true;
		}
		return false;
	}
	
	/**
	 * Gets the user inter.
	 *
	 * @param pending the pending
	 * @return the user inter
	 */
	public List<UserInteraction> getUserInter(boolean pending){
		List<UserInteraction> returnList = new LinkedList<UserInteraction>();
		for (UserInteraction myUserInter : processInteractions) {
			if (!myUserInter.isPerformed() == pending)
				returnList.add(myUserInter);
		}
		return returnList;
	}

	/**
	 * Gets the user interacion.
	 *
	 * @param cuiId the cui id
	 * @return the user interacion
	 */
	public UserInteraction getUserInteracion(String cuiId) {
		for (UserInteraction aCui : processInteractions) {
			if (aCui.getId().equals(cuiId))
				return aCui;
		}
		return createUserInteraction(cuiId);
	}

	public UserInteraction createUserInteraction(String cuiId) {
		UserInteraction thisUserInteraction = new UserInteraction(cuiId);
		processInteractions.add(thisUserInteraction);
		return thisUserInteraction;
	}
}