/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model;

import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.Pick;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pick UI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.PickUI#getUserInteraction <em>User Interaction</em>}</li>
 * </ul>
 * </p>
 *
 * @see be.edu.fundp.precise.uibpel.model.ModelPackage#getPickUI()
 * @model
 * @generated
 */
public interface PickUI extends Pick, ExtensionActivity {
	/**
	 * Returns the value of the '<em><b>User Interaction</b></em>' containment reference list.
	 * The list contents are of type {@link be.edu.fundp.precise.uibpel.model.OnUserEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Interaction</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Interaction</em>' containment reference list.
	 * @see be.edu.fundp.precise.uibpel.model.ModelPackage#getPickUI_UserInteraction()
	 * @model containment="true"
	 * @generated
	 */
	EList<OnUserEvent> getUserInteraction();

} // PickUI
