/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model;

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
 *   <li>{@link be.edu.fundp.precise.uibpel.model.UserInteraction#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see be.edu.fundp.precise.uibpel.model.ModelPackage#getUserInteraction()
 * @model abstract="true"
 * @generated
 */
public interface UserInteraction extends UsableEntity, ExtensionActivity {
	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference list.
	 * The list contents are of type {@link be.edu.fundp.precise.uibpel.model.DataItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference list.
	 * @see be.edu.fundp.precise.uibpel.model.ModelPackage#getUserInteraction_Data()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataItem> getData();

} // UserInteraction
