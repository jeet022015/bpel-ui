/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.bpel_ui.model;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>On User Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getId <em>Id</em>}</li>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getType <em>Type</em>}</li>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getVariable <em>Variable</em>}</li>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getOnUserEvent()
 * @model
 * @generated
 */
public interface OnUserEvent extends BPEL_UI_Entity {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getOnUserEvent_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link be.edu.fundp.precise.bpel_ui.model.UserEventType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see be.edu.fundp.precise.bpel_ui.model.UserEventType
	 * @see #setType(UserEventType)
	 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getOnUserEvent_Type()
	 * @model
	 * @generated
	 */
	UserEventType getType();

	/**
	 * Sets the value of the '{@link be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see be.edu.fundp.precise.bpel_ui.model.UserEventType
	 * @see #getType()
	 * @generated
	 */
	void setType(UserEventType value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(Variable)
	 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getOnUserEvent_Variable()
	 * @model
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' containment reference.
	 * @see #setContainer(Activity)
	 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getOnUserEvent_Container()
	 * @model containment="true"
	 * @generated
	 */
	Activity getContainer();

	/**
	 * Sets the value of the '{@link be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getContainer <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' containment reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Activity value);

} // OnUserEvent
