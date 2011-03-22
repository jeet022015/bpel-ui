/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.bpel_ui.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see be.edu.fundp.bpel_ui.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = be.edu.fundp.bpel_ui.model.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>User Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Role</em>'.
	 * @generated
	 */
	UserRole createUserRole();

	/**
	 * Returns a new object of class '<em>Data Output UI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Output UI</em>'.
	 * @generated
	 */
	DataOutputUI createDataOutputUI();

	/**
	 * Returns a new object of class '<em>Data Input UI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Input UI</em>'.
	 * @generated
	 */
	DataInputUI createDataInputUI();

	/**
	 * Returns a new object of class '<em>Data Selection UI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Selection UI</em>'.
	 * @generated
	 */
	DataSelectionUI createDataSelectionUI();

	/**
	 * Returns a new object of class '<em>Decision UI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Decision UI</em>'.
	 * @generated
	 */
	DecisionUI createDecisionUI();

	/**
	 * Returns a new object of class '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice</em>'.
	 * @generated
	 */
	Choice createChoice();

	/**
	 * Returns a new object of class '<em>On User Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>On User Event</em>'.
	 * @generated
	 */
	OnUserEvent createOnUserEvent();

	/**
	 * Returns a new object of class '<em>New Pick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Pick</em>'.
	 * @generated
	 */
	NewPick createNewPick();

	/**
	 * Returns a new object of class '<em>New Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Scope</em>'.
	 * @generated
	 */
	NewScope createNewScope();

	/**
	 * Returns a new object of class '<em>New Event Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Event Handler</em>'.
	 * @generated
	 */
	NewEventHandler createNewEventHandler();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
