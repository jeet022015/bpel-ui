/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see be.edu.fundp.precise.uibpel.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = be.edu.fundp.precise.uibpel.model.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Data Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Item</em>'.
	 * @generated
	 */
	DataItem createDataItem();

	/**
	 * Returns a new object of class '<em>Data Input UI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Input UI</em>'.
	 * @generated
	 */
	DataInputUI createDataInputUI();

	/**
	 * Returns a new object of class '<em>Data Output UI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Output UI</em>'.
	 * @generated
	 */
	DataOutputUI createDataOutputUI();

	/**
	 * Returns a new object of class '<em>Data Selection UI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Selection UI</em>'.
	 * @generated
	 */
	DataSelectionUI createDataSelectionUI();

	/**
	 * Returns a new object of class '<em>On User Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>On User Event</em>'.
	 * @generated
	 */
	OnUserEvent createOnUserEvent();

	/**
	 * Returns a new object of class '<em>Pick UI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pick UI</em>'.
	 * @generated
	 */
	PickUI createPickUI();

	/**
	 * Returns a new object of class '<em>Scope UI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scope UI</em>'.
	 * @generated
	 */
	ScopeUI createScopeUI();

	/**
	 * Returns a new object of class '<em>Event Handler UI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Handler UI</em>'.
	 * @generated
	 */
	EventHandlerUI createEventHandlerUI();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
