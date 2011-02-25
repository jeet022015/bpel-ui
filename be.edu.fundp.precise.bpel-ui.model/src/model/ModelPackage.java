/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.bpel.model.BPELPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/bpel/bpel-ui/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "bpel-ui";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link model.impl.DataInputUIImpl <em>Data Input UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.DataInputUIImpl
	 * @see model.impl.ModelPackageImpl#getDataInputUI()
	 * @generated
	 */
	int DATA_INPUT_UI = 0;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__DOCUMENTATION_ELEMENT = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__ELEMENT = BPELPackage.EXTENSION_ACTIVITY__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__EEXTENSIBILITY_ELEMENTS = BPELPackage.EXTENSION_ACTIVITY__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__DOCUMENTATION = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__NAME = BPELPackage.EXTENSION_ACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__SUPPRESS_JOIN_FAILURE = BPELPackage.EXTENSION_ACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__TARGETS = BPELPackage.EXTENSION_ACTIVITY__TARGETS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__SOURCES = BPELPackage.EXTENSION_ACTIVITY__SOURCES;

	/**
	 * The feature id for the '<em><b>User Validation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__USER_VALIDATION = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__INPUT_VARIABLE = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Input UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI_FEATURE_COUNT = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link model.DataInputUI <em>Data Input UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Input UI</em>'.
	 * @see model.DataInputUI
	 * @generated
	 */
	EClass getDataInputUI();

	/**
	 * Returns the meta object for the attribute '{@link model.DataInputUI#isUserValidation <em>User Validation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Validation</em>'.
	 * @see model.DataInputUI#isUserValidation()
	 * @see #getDataInputUI()
	 * @generated
	 */
	EAttribute getDataInputUI_UserValidation();

	/**
	 * Returns the meta object for the reference '{@link model.DataInputUI#getInputVariable <em>Input Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input Variable</em>'.
	 * @see model.DataInputUI#getInputVariable()
	 * @see #getDataInputUI()
	 * @generated
	 */
	EReference getDataInputUI_InputVariable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link model.impl.DataInputUIImpl <em>Data Input UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.DataInputUIImpl
		 * @see model.impl.ModelPackageImpl#getDataInputUI()
		 * @generated
		 */
		EClass DATA_INPUT_UI = eINSTANCE.getDataInputUI();

		/**
		 * The meta object literal for the '<em><b>User Validation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_INPUT_UI__USER_VALIDATION = eINSTANCE.getDataInputUI_UserValidation();

		/**
		 * The meta object literal for the '<em><b>Input Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_INPUT_UI__INPUT_VARIABLE = eINSTANCE.getDataInputUI_InputVariable();

	}

} //ModelPackage
