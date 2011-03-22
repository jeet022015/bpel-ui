/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.bpel_ui.model;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>On User Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link be.edu.fundp.bpel_ui.model.OnUserEvent#getActivity <em>Activity</em>}</li>
 *   <li>{@link be.edu.fundp.bpel_ui.model.OnUserEvent#getVariable <em>Variable</em>}</li>
 *   <li>{@link be.edu.fundp.bpel_ui.model.OnUserEvent#getUserRole <em>User Role</em>}</li>
 *   <li>{@link be.edu.fundp.bpel_ui.model.OnUserEvent#getType <em>Type</em>}</li>
 *   <li>{@link be.edu.fundp.bpel_ui.model.OnUserEvent#getID <em>ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see be.edu.fundp.bpel_ui.model.ModelPackage#getOnUserEvent()
 * @model
 * @generated
 */
public interface OnUserEvent extends ExtensionActivity {
	/**
	 * Returns the value of the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' reference.
	 * @see #setActivity(Activity)
	 * @see be.edu.fundp.bpel_ui.model.ModelPackage#getOnUserEvent_Activity()
	 * @model required="true"
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link be.edu.fundp.bpel_ui.model.OnUserEvent#getActivity <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

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
	 * @see be.edu.fundp.bpel_ui.model.ModelPackage#getOnUserEvent_Variable()
	 * @model
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link be.edu.fundp.bpel_ui.model.OnUserEvent#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>User Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Role</em>' reference.
	 * @see #setUserRole(UserRole)
	 * @see be.edu.fundp.bpel_ui.model.ModelPackage#getOnUserEvent_UserRole()
	 * @model
	 * @generated
	 */
	UserRole getUserRole();

	/**
	 * Sets the value of the '{@link be.edu.fundp.bpel_ui.model.OnUserEvent#getUserRole <em>User Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Role</em>' reference.
	 * @see #getUserRole()
	 * @generated
	 */
	void setUserRole(UserRole value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link be.edu.fundp.bpel_ui.model.EventType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see be.edu.fundp.bpel_ui.model.EventType
	 * @see #setType(EventType)
	 * @see be.edu.fundp.bpel_ui.model.ModelPackage#getOnUserEvent_Type()
	 * @model
	 * @generated
	 */
	EventType getType();

	/**
	 * Sets the value of the '{@link be.edu.fundp.bpel_ui.model.OnUserEvent#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see be.edu.fundp.bpel_ui.model.EventType
	 * @see #getType()
	 * @generated
	 */
	void setType(EventType value);

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see be.edu.fundp.bpel_ui.model.ModelPackage#getOnUserEvent_ID()
	 * @model
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link be.edu.fundp.bpel_ui.model.OnUserEvent#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

} // OnUserEvent
