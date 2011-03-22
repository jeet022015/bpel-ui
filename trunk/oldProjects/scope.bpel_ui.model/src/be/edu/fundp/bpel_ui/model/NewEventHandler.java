/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.bpel_ui.model;

import org.eclipse.bpel.model.EventHandler;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Event Handler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link be.edu.fundp.bpel_ui.model.NewEventHandler#getUserInteracion <em>User Interacion</em>}</li>
 * </ul>
 * </p>
 *
 * @see be.edu.fundp.bpel_ui.model.ModelPackage#getNewEventHandler()
 * @model
 * @generated
 */
public interface NewEventHandler extends EventHandler {
	/**
	 * Returns the value of the '<em><b>User Interacion</b></em>' containment reference list.
	 * The list contents are of type {@link be.edu.fundp.bpel_ui.model.OnUserEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Interacion</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Interacion</em>' containment reference list.
	 * @see be.edu.fundp.bpel_ui.model.ModelPackage#getNewEventHandler_UserInteracion()
	 * @model containment="true"
	 * @generated
	 */
	EList<OnUserEvent> getUserInteracion();

} // NewEventHandler
