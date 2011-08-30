/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.bpel_ui.model;

import org.eclipse.bpel.model.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Input UI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.DataInputUI#getInputVariable <em>Input Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getDataInputUI()
 * @model
 * @generated
 */
public interface DataInputUI extends UserInteraction {
	/**
	 * Returns the value of the '<em><b>Input Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Variable</em>' reference.
	 * @see #setInputVariable(Variable)
	 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getDataInputUI_InputVariable()
	 * @model required="true"
	 * @generated
	 */
	Variable getInputVariable();

	/**
	 * Sets the value of the '{@link be.edu.fundp.precise.bpel_ui.model.DataInputUI#getInputVariable <em>Input Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Variable</em>' reference.
	 * @see #getInputVariable()
	 * @generated
	 */
	void setInputVariable(Variable value);

} // DataInputUI
