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
 * A representation of the model object '<em><b>Data Output UI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.DataOutputUI#getOutputVariable <em>Output Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getDataOutputUI()
 * @model
 * @generated
 */
public interface DataOutputUI extends UserInteraction {
	/**
	 * Returns the value of the '<em><b>Output Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Variable</em>' reference.
	 * @see #setOutputVariable(Variable)
	 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getDataOutputUI_OutputVariable()
	 * @model required="true"
	 * @generated
	 */
	Variable getOutputVariable();

	/**
	 * Sets the value of the '{@link be.edu.fundp.precise.bpel_ui.model.DataOutputUI#getOutputVariable <em>Output Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Variable</em>' reference.
	 * @see #getOutputVariable()
	 * @generated
	 */
	void setOutputVariable(Variable value);

} // DataOutputUI
