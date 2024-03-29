/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.Pick;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Pick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.NewPick#getUserInteracion <em>User Interacion</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getNewPick()
 * @model
 * @generated
 */
public interface NewPick extends ExtensionActivity, Pick {
	/**
	 * Returns the value of the '<em><b>User Interacion</b></em>' reference list.
	 * The list contents are of type {@link model.OnUserEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Interacion</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Interacion</em>' reference list.
	 * @see model.ModelPackage#getNewPick_UserInteracion()
	 * @model
	 * @generated
	 */
	EList<OnUserEvent> getUserInteracion();

} // NewPick
