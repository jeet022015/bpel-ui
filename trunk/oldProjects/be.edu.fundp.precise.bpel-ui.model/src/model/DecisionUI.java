/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decision UI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.DecisionUI#getChoices <em>Choices</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getDecisionUI()
 * @model
 * @generated
 */
public interface DecisionUI extends UserInteraction {
	/**
	 * Returns the value of the '<em><b>Choices</b></em>' reference list.
	 * The list contents are of type {@link model.Choice}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Choices</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choices</em>' reference list.
	 * @see model.ModelPackage#getDecisionUI_Choices()
	 * @model lower="2"
	 * @generated
	 */
	EList<Choice> getChoices();

} // DecisionUI
