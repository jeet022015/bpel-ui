/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.UserEvent#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getUserEvent()
 * @model
 * @generated
 */
public interface UserEvent extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link model.EventType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see model.EventType
	 * @see #setType(EventType)
	 * @see model.ModelPackage#getUserEvent_Type()
	 * @model required="true"
	 * @generated
	 */
	EventType getType();

	/**
	 * Sets the value of the '{@link model.UserEvent#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see model.EventType
	 * @see #getType()
	 * @generated
	 */
	void setType(EventType value);

} // UserEvent
