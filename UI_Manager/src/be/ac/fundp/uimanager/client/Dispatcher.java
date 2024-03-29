package be.ac.fundp.uimanager.client;

import java.util.List;

import be.ac.fundp.uimanager.provider.UiDataType;

// TODO: Auto-generated Javadoc
/**
 * The Interface Dispatcher.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public interface Dispatcher {

	/**
	 * Require input interacion.
	 *
	 * @param processId the process id
	 * @param userInteracId the user interac id
	 * @param role the role
	 * @return the list
	 */
	public List<UiDataType> requireInputInteracion(String processId,
			String userInteracId, String role);

	/**
	 * Require output interacion.
	 *
	 * @param processid the processid
	 * @param userInteracId the user interac id
	 * @param data the data
	 * @param role the role
	 */
	public void requireOutputInteracion(String processid,
			String userInteracId, List<UiDataType> data, String role);

	/**
	 * Require selection interacion.
	 *
	 * @param processId the process id
	 * @param userInteracId the user interac id
	 * @param data the data
	 * @param role the role
	 * @return the list
	 */
	public List<UiDataType> requireSelectionInteracion(String processId,
			String userInteracId, List<UiDataType> data, String role);
}
