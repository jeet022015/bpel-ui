package be.ac.fundp.precise.clientAppMediation.dispatcher;

import java.util.List;

import be.ac.fundp.precise.dataManagment.CoordinatedData;

/**
 * The Dispatcher to communicate with the client.
 * 
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date May 22, 2012
 */
public interface Dispatcher {

	/**
	 * Require input interaction.
	 *
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @param userLogin the user's id.
	 * @return the data provided by the user.
	 */
	public List<CoordinatedData> requireInputInteraction(String process, String processId,
			String userInteracId, String userLogin);

	/**
	 * Require output interaction.
	 *
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @param data the data to be presented to the user.
	 * @param userLogin the user's id.
	 */
	public void requireOutputInteraction(String process, String processId,
			String userInteracId, List<CoordinatedData> data, String userLogin);

	/**
	 * Require selection interaction.
	 *
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @param data the data to be presented to the user.
	 * @param userId the user's id.
	 * @return the data provided by the user.
	 */
	public List<CoordinatedData> requireSelectionInteraction(String process, String processId,
			String userInteracId, List<CoordinatedData> data, String userId);

	/**
	 * This method releases the execution of all interactions which are pending
	 * and waiting for a user interactions.
	 *
	 * @param processId the process's id.
	 */
	public void releaseAll(String processId);
}
