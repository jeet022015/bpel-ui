/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.bpel_ui.model;

import org.eclipse.bpel.model.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Selection UI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link be.edu.fundp.bpel_ui.model.DataSelectionUI#getMinCardinality <em>Min Cardinality</em>}</li>
 *   <li>{@link be.edu.fundp.bpel_ui.model.DataSelectionUI#getMaxCardinality <em>Max Cardinality</em>}</li>
 *   <li>{@link be.edu.fundp.bpel_ui.model.DataSelectionUI#getSelectable <em>Selectable</em>}</li>
 * </ul>
 * </p>
 *
 * @see be.edu.fundp.bpel_ui.model.ModelPackage#getDataSelectionUI()
 * @model
 * @generated
 */
public interface DataSelectionUI extends DataInputUI {
	/**
	 * Returns the value of the '<em><b>Min Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Cardinality</em>' attribute.
	 * @see #setMinCardinality(int)
	 * @see be.edu.fundp.bpel_ui.model.ModelPackage#getDataSelectionUI_MinCardinality()
	 * @model required="true"
	 * @generated
	 */
	int getMinCardinality();

	/**
	 * Sets the value of the '{@link be.edu.fundp.bpel_ui.model.DataSelectionUI#getMinCardinality <em>Min Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Cardinality</em>' attribute.
	 * @see #getMinCardinality()
	 * @generated
	 */
	void setMinCardinality(int value);

	/**
	 * Returns the value of the '<em><b>Max Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Cardinality</em>' attribute.
	 * @see #setMaxCardinality(int)
	 * @see be.edu.fundp.bpel_ui.model.ModelPackage#getDataSelectionUI_MaxCardinality()
	 * @model required="true"
	 * @generated
	 */
	int getMaxCardinality();

	/**
	 * Sets the value of the '{@link be.edu.fundp.bpel_ui.model.DataSelectionUI#getMaxCardinality <em>Max Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Cardinality</em>' attribute.
	 * @see #getMaxCardinality()
	 * @generated
	 */
	void setMaxCardinality(int value);

	/**
	 * Returns the value of the '<em><b>Selectable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selectable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selectable</em>' reference.
	 * @see #setSelectable(Variable)
	 * @see be.edu.fundp.bpel_ui.model.ModelPackage#getDataSelectionUI_Selectable()
	 * @model required="true"
	 * @generated
	 */
	Variable getSelectable();

	/**
	 * Sets the value of the '{@link be.edu.fundp.bpel_ui.model.DataSelectionUI#getSelectable <em>Selectable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selectable</em>' reference.
	 * @see #getSelectable()
	 * @generated
	 */
	void setSelectable(Variable value);

} // DataSelectionUI
