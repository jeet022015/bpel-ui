/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model;

import org.eclipse.bpel.model.BPELExtensibleElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.UserRole#getRoleId <em>Role Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see be.edu.fundp.precise.uibpel.model.ModelPackage#getUserRole()
 * @model
 * @generated
 */
public interface UserRole extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Role Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Id</em>' attribute.
	 * @see #setRoleId(String)
	 * @see be.edu.fundp.precise.uibpel.model.ModelPackage#getUserRole_RoleId()
	 * @model
	 * @generated
	 */
	String getRoleId();

	/**
	 * Sets the value of the '{@link be.edu.fundp.precise.uibpel.model.UserRole#getRoleId <em>Role Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Id</em>' attribute.
	 * @see #getRoleId()
	 * @generated
	 */
	void setRoleId(String value);

} // UserRole
