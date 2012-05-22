package be.ac.fundp.precise.clientAppMediation.dispatcher;

import java.util.List;

import be.ac.fundp.precise.dataManagment.CoordinatedData;

public interface Dispatcher {

	/**
	 * Require input interaction.
	 *
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @param role the user'role.
	 * @return the data provided by the user.
	 */
	public List<CoordinatedData> requireInputInteraction(String processId,
			String userInteracId, String role);

	/**
	 * Require output interaction.
	 *
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @param data the data to be presented to the user.
	 * @param role the user'role.
	 */
	public void requireOutputInteraction(String processId,
			String userInteracId, List<CoordinatedData> data, String role);

	/**
	 * Require selection interaction.
	 *
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @param data the data to be presented to the user.
	 * @param role the user'role.
	 * @return the data provided by the user.
	 */
	public List<CoordinatedData> requireSelectionInteraction(String processId,
			String userInteracId, List<CoordinatedData> data, String role);

	/**
	 * This method releases the execution of all interactions which are pending
	 * and waiting for a user interactions.
	 *
	 * @param processId the process's id.
	 */
	public void releaseAll(String processId);
}
