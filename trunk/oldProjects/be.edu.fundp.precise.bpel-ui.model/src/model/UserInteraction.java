/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.bpel.model.ExtensionActivity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.UserInteraction#getRoles <em>Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getUserInteraction()
 * @model abstract="true"
 * @generated
 */
public interface UserInteraction extends ExtensionActivity {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' reference list.
	 * The list contents are of type {@link model.UserRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' reference list.
	 * @see model.ModelPackage#getUserInteraction_Roles()
	 * @model required="true"
	 * @generated
	 */
	EList<UserRole> getRoles();

} // UserInteraction
