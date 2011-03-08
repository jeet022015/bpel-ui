/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.bpel.model.Activity;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>On User Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.OnUserEvent#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getOnUserEvent()
 * @model
 * @generated
 */
public interface OnUserEvent extends EObject {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(Activity)
	 * @see model.ModelPackage#getOnUserEvent_Container()
	 * @model required="true"
	 * @generated
	 */
	Activity getContainer();

	/**
	 * Sets the value of the '{@link model.OnUserEvent#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Activity value);

} // OnUserEvent
