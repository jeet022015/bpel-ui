/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Input UI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.DataInputUI#getInputItem <em>Input Item</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.DataInputUI#isCreateInstance <em>Create Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see be.edu.fundp.precise.uibpel.model.ModelPackage#getDataInputUI()
 * @model
 * @generated
 */
public interface DataInputUI extends DataInteraction {
	/**
	 * Returns the value of the '<em><b>Input Item</b></em>' containment reference list.
	 * The list contents are of type {@link be.edu.fundp.precise.uibpel.model.DataItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Item</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Item</em>' containment reference list.
	 * @see be.edu.fundp.precise.uibpel.model.ModelPackage#getDataInputUI_InputItem()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataItem> getInputItem();

	/**
	 * Returns the value of the '<em><b>Create Instance</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Instance</em>' attribute.
	 * @see #setCreateInstance(boolean)
	 * @see be.edu.fundp.precise.uibpel.model.ModelPackage#getDataInputUI_CreateInstance()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isCreateInstance();

	/**
	 * Sets the value of the '{@link be.edu.fundp.precise.uibpel.model.DataInputUI#isCreateInstance <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Instance</em>' attribute.
	 * @see #isCreateInstance()
	 * @generated
	 */
	void setCreateInstance(boolean value);

} // DataInputUI
