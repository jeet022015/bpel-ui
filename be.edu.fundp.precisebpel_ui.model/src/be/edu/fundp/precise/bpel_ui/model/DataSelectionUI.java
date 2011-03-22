/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.bpel_ui.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Selection UI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.DataSelectionUI#getSelectable <em>Selectable</em>}</li>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.DataSelectionUI#getMinCardinality <em>Min Cardinality</em>}</li>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.DataSelectionUI#getMaxCardinality <em>Max Cardinality</em>}</li>
 * </ul>
 * </p>
 *
 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getDataSelectionUI()
 * @model
 * @generated
 */
public interface DataSelectionUI extends DataInputUI {
	/**
	 * Returns the value of the '<em><b>Selectable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selectable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selectable</em>' containment reference.
	 * @see #setSelectable(DataOutputUI)
	 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getDataSelectionUI_Selectable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataOutputUI getSelectable();

	/**
	 * Sets the value of the '{@link be.edu.fundp.precise.bpel_ui.model.DataSelectionUI#getSelectable <em>Selectable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selectable</em>' containment reference.
	 * @see #getSelectable()
	 * @generated
	 */
	void setSelectable(DataOutputUI value);

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
	 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getDataSelectionUI_MinCardinality()
	 * @model
	 * @generated
	 */
	int getMinCardinality();

	/**
	 * Sets the value of the '{@link be.edu.fundp.precise.bpel_ui.model.DataSelectionUI#getMinCardinality <em>Min Cardinality</em>}' attribute.
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
	 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getDataSelectionUI_MaxCardinality()
	 * @model
	 * @generated
	 */
	int getMaxCardinality();

	/**
	 * Sets the value of the '{@link be.edu.fundp.precise.bpel_ui.model.DataSelectionUI#getMaxCardinality <em>Max Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Cardinality</em>' attribute.
	 * @see #getMaxCardinality()
	 * @generated
	 */
	void setMaxCardinality(int value);

} // DataSelectionUI
