/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model;

import org.eclipse.bpel.model.BPELExtensibleElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.UserInteraction#getRoles <em>Roles</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.UserInteraction#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see be.edu.fundp.precise.uibpel.model.ModelPackage#getUserInteraction()
 * @model abstract="true"
 * @generated
 */
public interface UserInteraction extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' attribute list.
	 * @see be.edu.fundp.precise.uibpel.model.ModelPackage#getUserInteraction_Roles()
	 * @model
	 * @generated
	 */
	EList<String> getRoles();

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
	 * @see be.edu.fundp.precise.uibpel.model.ModelPackage#getUserInteraction_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link be.edu.fundp.precise.uibpel.model.UserInteraction#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // UserInteraction
