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
import org.eclipse.emf.ecore.EEnum;
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
	 * The meta object id for the '{@link model.impl.UserInteractionImpl <em>User Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.UserInteractionImpl
	 * @see model.impl.ModelPackageImpl#getUserInteraction()
	 * @generated
	 */
	int USER_INTERACTION = 0;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__DOCUMENTATION_ELEMENT = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__ELEMENT = BPELPackage.EXTENSION_ACTIVITY__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__EEXTENSIBILITY_ELEMENTS = BPELPackage.EXTENSION_ACTIVITY__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__DOCUMENTATION = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__NAME = BPELPackage.EXTENSION_ACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__SUPPRESS_JOIN_FAILURE = BPELPackage.EXTENSION_ACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__TARGETS = BPELPackage.EXTENSION_ACTIVITY__TARGETS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__SOURCES = BPELPackage.EXTENSION_ACTIVITY__SOURCES;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__ROLES = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION_FEATURE_COUNT = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.impl.UserRoleImpl <em>User Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.UserRoleImpl
	 * @see model.impl.ModelPackageImpl#getUserRole()
	 * @generated
	 */
	int USER_ROLE = 1;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ROLE__DOCUMENTATION_ELEMENT = BPELPackage.EXTENSIBLE_ELEMENT__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ROLE__ELEMENT = BPELPackage.EXTENSIBLE_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ROLE__EEXTENSIBILITY_ELEMENTS = BPELPackage.EXTENSIBLE_ELEMENT__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ROLE__DOCUMENTATION = BPELPackage.EXTENSIBLE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ROLE__ID = BPELPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ROLE_FEATURE_COUNT = BPELPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.impl.DataOutputUIImpl <em>Data Output UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.DataOutputUIImpl
	 * @see model.impl.ModelPackageImpl#getDataOutputUI()
	 * @generated
	 */
	int DATA_OUTPUT_UI = 2;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__DOCUMENTATION_ELEMENT = USER_INTERACTION__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__ELEMENT = USER_INTERACTION__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__EEXTENSIBILITY_ELEMENTS = USER_INTERACTION__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__DOCUMENTATION = USER_INTERACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__NAME = USER_INTERACTION__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__SUPPRESS_JOIN_FAILURE = USER_INTERACTION__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__TARGETS = USER_INTERACTION__TARGETS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__SOURCES = USER_INTERACTION__SOURCES;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__ROLES = USER_INTERACTION__ROLES;

	/**
	 * The feature id for the '<em><b>Output Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__OUTPUT_VARIABLE = USER_INTERACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Output UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI_FEATURE_COUNT = USER_INTERACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.impl.DataInputUIImpl <em>Data Input UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.DataInputUIImpl
	 * @see model.impl.ModelPackageImpl#getDataInputUI()
	 * @generated
	 */
	int DATA_INPUT_UI = 3;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__DOCUMENTATION_ELEMENT = USER_INTERACTION__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__ELEMENT = USER_INTERACTION__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__EEXTENSIBILITY_ELEMENTS = USER_INTERACTION__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__DOCUMENTATION = USER_INTERACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__NAME = USER_INTERACTION__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__SUPPRESS_JOIN_FAILURE = USER_INTERACTION__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__TARGETS = USER_INTERACTION__TARGETS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__SOURCES = USER_INTERACTION__SOURCES;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__ROLES = USER_INTERACTION__ROLES;

	/**
	 * The feature id for the '<em><b>User Validation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__USER_VALIDATION = USER_INTERACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__INPUT_VARIABLE = USER_INTERACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Input UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI_FEATURE_COUNT = USER_INTERACTION_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link model.impl.DataSelectionUIImpl <em>Data Selection UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.DataSelectionUIImpl
	 * @see model.impl.ModelPackageImpl#getDataSelectionUI()
	 * @generated
	 */
	int DATA_SELECTION_UI = 4;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__DOCUMENTATION_ELEMENT = DATA_INPUT_UI__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__ELEMENT = DATA_INPUT_UI__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__EEXTENSIBILITY_ELEMENTS = DATA_INPUT_UI__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__DOCUMENTATION = DATA_INPUT_UI__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__NAME = DATA_INPUT_UI__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__SUPPRESS_JOIN_FAILURE = DATA_INPUT_UI__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__TARGETS = DATA_INPUT_UI__TARGETS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__SOURCES = DATA_INPUT_UI__SOURCES;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__ROLES = DATA_INPUT_UI__ROLES;

	/**
	 * The feature id for the '<em><b>User Validation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__USER_VALIDATION = DATA_INPUT_UI__USER_VALIDATION;

	/**
	 * The feature id for the '<em><b>Input Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__INPUT_VARIABLE = DATA_INPUT_UI__INPUT_VARIABLE;

	/**
	 * The feature id for the '<em><b>Min Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__MIN_CARDINALITY = DATA_INPUT_UI_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__MAX_CARDINALITY = DATA_INPUT_UI_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Selectable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__SELECTABLE = DATA_INPUT_UI_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Data Selection UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI_FEATURE_COUNT = DATA_INPUT_UI_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link model.impl.DecisionUIImpl <em>Decision UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.DecisionUIImpl
	 * @see model.impl.ModelPackageImpl#getDecisionUI()
	 * @generated
	 */
	int DECISION_UI = 5;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_UI__DOCUMENTATION_ELEMENT = USER_INTERACTION__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_UI__ELEMENT = USER_INTERACTION__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_UI__EEXTENSIBILITY_ELEMENTS = USER_INTERACTION__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_UI__DOCUMENTATION = USER_INTERACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_UI__NAME = USER_INTERACTION__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_UI__SUPPRESS_JOIN_FAILURE = USER_INTERACTION__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_UI__TARGETS = USER_INTERACTION__TARGETS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_UI__SOURCES = USER_INTERACTION__SOURCES;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_UI__ROLES = USER_INTERACTION__ROLES;

	/**
	 * The feature id for the '<em><b>Choices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_UI__CHOICES = USER_INTERACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Decision UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_UI_FEATURE_COUNT = USER_INTERACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ChoiceImpl
	 * @see model.impl.ModelPackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 6;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__DOCUMENTATION_ELEMENT = BPELPackage.EXTENSIBLE_ELEMENT__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__ELEMENT = BPELPackage.EXTENSIBLE_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__EEXTENSIBILITY_ELEMENTS = BPELPackage.EXTENSIBLE_ELEMENT__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__DOCUMENTATION = BPELPackage.EXTENSIBLE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__IS_DEFAULT = BPELPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__ARGUMENTS = BPELPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__CONTAINER = BPELPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = BPELPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link model.impl.OnUserEventImpl <em>On User Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.OnUserEventImpl
	 * @see model.impl.ModelPackageImpl#getOnUserEvent()
	 * @generated
	 */
	int ON_USER_EVENT = 7;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__DOCUMENTATION_ELEMENT = BPELPackage.EXTENSIBLE_ELEMENT__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__ELEMENT = BPELPackage.EXTENSIBLE_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__EEXTENSIBILITY_ELEMENTS = BPELPackage.EXTENSIBLE_ELEMENT__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__DOCUMENTATION = BPELPackage.EXTENSIBLE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__ACTIVITY = BPELPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__VARIABLE = BPELPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>User Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__USER_ROLE = BPELPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__TYPE = BPELPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__ID = BPELPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>On User Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT_FEATURE_COUNT = BPELPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link model.impl.NewPickImpl <em>New Pick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.NewPickImpl
	 * @see model.impl.ModelPackageImpl#getNewPick()
	 * @generated
	 */
	int NEW_PICK = 8;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PICK__DOCUMENTATION_ELEMENT = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PICK__ELEMENT = BPELPackage.EXTENSION_ACTIVITY__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PICK__EEXTENSIBILITY_ELEMENTS = BPELPackage.EXTENSION_ACTIVITY__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PICK__DOCUMENTATION = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PICK__NAME = BPELPackage.EXTENSION_ACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PICK__SUPPRESS_JOIN_FAILURE = BPELPackage.EXTENSION_ACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PICK__TARGETS = BPELPackage.EXTENSION_ACTIVITY__TARGETS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PICK__SOURCES = BPELPackage.EXTENSION_ACTIVITY__SOURCES;

	/**
	 * The feature id for the '<em><b>Create Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PICK__CREATE_INSTANCE = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PICK__MESSAGES = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Alarm</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PICK__ALARM = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>User Interacion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PICK__USER_INTERACION = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>New Pick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PICK_FEATURE_COUNT = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link model.impl.NewEventHandlerImpl <em>New Event Handler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.NewEventHandlerImpl
	 * @see model.impl.ModelPackageImpl#getNewEventHandler()
	 * @generated
	 */
	int NEW_EVENT_HANDLER = 9;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EVENT_HANDLER__DOCUMENTATION_ELEMENT = BPELPackage.EVENT_HANDLER__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EVENT_HANDLER__ELEMENT = BPELPackage.EVENT_HANDLER__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EVENT_HANDLER__EEXTENSIBILITY_ELEMENTS = BPELPackage.EVENT_HANDLER__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EVENT_HANDLER__DOCUMENTATION = BPELPackage.EVENT_HANDLER__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Alarm</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EVENT_HANDLER__ALARM = BPELPackage.EVENT_HANDLER__ALARM;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EVENT_HANDLER__EVENTS = BPELPackage.EVENT_HANDLER__EVENTS;

	/**
	 * The feature id for the '<em><b>User Interacion</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EVENT_HANDLER__USER_INTERACION = BPELPackage.EVENT_HANDLER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New Event Handler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EVENT_HANDLER_FEATURE_COUNT = BPELPackage.EVENT_HANDLER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.EventType <em>Event Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.EventType
	 * @see model.impl.ModelPackageImpl#getEventType()
	 * @generated
	 */
	int EVENT_TYPE = 10;


	/**
	 * Returns the meta object for class '{@link model.UserInteraction <em>User Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Interaction</em>'.
	 * @see model.UserInteraction
	 * @generated
	 */
	EClass getUserInteraction();

	/**
	 * Returns the meta object for the reference list '{@link model.UserInteraction#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Roles</em>'.
	 * @see model.UserInteraction#getRoles()
	 * @see #getUserInteraction()
	 * @generated
	 */
	EReference getUserInteraction_Roles();

	/**
	 * Returns the meta object for class '{@link model.UserRole <em>User Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Role</em>'.
	 * @see model.UserRole
	 * @generated
	 */
	EClass getUserRole();

	/**
	 * Returns the meta object for the attribute '{@link model.UserRole#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see model.UserRole#getID()
	 * @see #getUserRole()
	 * @generated
	 */
	EAttribute getUserRole_ID();

	/**
	 * Returns the meta object for class '{@link model.DataOutputUI <em>Data Output UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Output UI</em>'.
	 * @see model.DataOutputUI
	 * @generated
	 */
	EClass getDataOutputUI();

	/**
	 * Returns the meta object for the reference '{@link model.DataOutputUI#getOutputVariable <em>Output Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output Variable</em>'.
	 * @see model.DataOutputUI#getOutputVariable()
	 * @see #getDataOutputUI()
	 * @generated
	 */
	EReference getDataOutputUI_OutputVariable();

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
	 * Returns the meta object for class '{@link model.DataSelectionUI <em>Data Selection UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Selection UI</em>'.
	 * @see model.DataSelectionUI
	 * @generated
	 */
	EClass getDataSelectionUI();

	/**
	 * Returns the meta object for the attribute '{@link model.DataSelectionUI#getMinCardinality <em>Min Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Cardinality</em>'.
	 * @see model.DataSelectionUI#getMinCardinality()
	 * @see #getDataSelectionUI()
	 * @generated
	 */
	EAttribute getDataSelectionUI_MinCardinality();

	/**
	 * Returns the meta object for the attribute '{@link model.DataSelectionUI#getMaxCardinality <em>Max Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Cardinality</em>'.
	 * @see model.DataSelectionUI#getMaxCardinality()
	 * @see #getDataSelectionUI()
	 * @generated
	 */
	EAttribute getDataSelectionUI_MaxCardinality();

	/**
	 * Returns the meta object for the reference '{@link model.DataSelectionUI#getSelectable <em>Selectable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Selectable</em>'.
	 * @see model.DataSelectionUI#getSelectable()
	 * @see #getDataSelectionUI()
	 * @generated
	 */
	EReference getDataSelectionUI_Selectable();

	/**
	 * Returns the meta object for class '{@link model.DecisionUI <em>Decision UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decision UI</em>'.
	 * @see model.DecisionUI
	 * @generated
	 */
	EClass getDecisionUI();

	/**
	 * Returns the meta object for the reference list '{@link model.DecisionUI#getChoices <em>Choices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Choices</em>'.
	 * @see model.DecisionUI#getChoices()
	 * @see #getDecisionUI()
	 * @generated
	 */
	EReference getDecisionUI_Choices();

	/**
	 * Returns the meta object for class '{@link model.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see model.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for the attribute '{@link model.Choice#isIsDefault <em>Is Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Default</em>'.
	 * @see model.Choice#isIsDefault()
	 * @see #getChoice()
	 * @generated
	 */
	EAttribute getChoice_IsDefault();

	/**
	 * Returns the meta object for the reference list '{@link model.Choice#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see model.Choice#getArguments()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_Arguments();

	/**
	 * Returns the meta object for the reference '{@link model.Choice#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see model.Choice#getContainer()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_Container();

	/**
	 * Returns the meta object for class '{@link model.OnUserEvent <em>On User Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>On User Event</em>'.
	 * @see model.OnUserEvent
	 * @generated
	 */
	EClass getOnUserEvent();

	/**
	 * Returns the meta object for the reference '{@link model.OnUserEvent#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Activity</em>'.
	 * @see model.OnUserEvent#getActivity()
	 * @see #getOnUserEvent()
	 * @generated
	 */
	EReference getOnUserEvent_Activity();

	/**
	 * Returns the meta object for the reference '{@link model.OnUserEvent#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see model.OnUserEvent#getVariable()
	 * @see #getOnUserEvent()
	 * @generated
	 */
	EReference getOnUserEvent_Variable();

	/**
	 * Returns the meta object for the reference '{@link model.OnUserEvent#getUserRole <em>User Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User Role</em>'.
	 * @see model.OnUserEvent#getUserRole()
	 * @see #getOnUserEvent()
	 * @generated
	 */
	EReference getOnUserEvent_UserRole();

	/**
	 * Returns the meta object for the attribute '{@link model.OnUserEvent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see model.OnUserEvent#getType()
	 * @see #getOnUserEvent()
	 * @generated
	 */
	EAttribute getOnUserEvent_Type();

	/**
	 * Returns the meta object for the attribute '{@link model.OnUserEvent#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see model.OnUserEvent#getID()
	 * @see #getOnUserEvent()
	 * @generated
	 */
	EAttribute getOnUserEvent_ID();

	/**
	 * Returns the meta object for class '{@link model.NewPick <em>New Pick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Pick</em>'.
	 * @see model.NewPick
	 * @generated
	 */
	EClass getNewPick();

	/**
	 * Returns the meta object for the reference list '{@link model.NewPick#getUserInteracion <em>User Interacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>User Interacion</em>'.
	 * @see model.NewPick#getUserInteracion()
	 * @see #getNewPick()
	 * @generated
	 */
	EReference getNewPick_UserInteracion();

	/**
	 * Returns the meta object for class '{@link model.NewEventHandler <em>New Event Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Event Handler</em>'.
	 * @see model.NewEventHandler
	 * @generated
	 */
	EClass getNewEventHandler();

	/**
	 * Returns the meta object for the reference list '{@link model.NewEventHandler#getUserInteracion <em>User Interacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>User Interacion</em>'.
	 * @see model.NewEventHandler#getUserInteracion()
	 * @see #getNewEventHandler()
	 * @generated
	 */
	EReference getNewEventHandler_UserInteracion();

	/**
	 * Returns the meta object for enum '{@link model.EventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Event Type</em>'.
	 * @see model.EventType
	 * @generated
	 */
	EEnum getEventType();

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
		 * The meta object literal for the '{@link model.impl.UserInteractionImpl <em>User Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.UserInteractionImpl
		 * @see model.impl.ModelPackageImpl#getUserInteraction()
		 * @generated
		 */
		EClass USER_INTERACTION = eINSTANCE.getUserInteraction();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERACTION__ROLES = eINSTANCE.getUserInteraction_Roles();

		/**
		 * The meta object literal for the '{@link model.impl.UserRoleImpl <em>User Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.UserRoleImpl
		 * @see model.impl.ModelPackageImpl#getUserRole()
		 * @generated
		 */
		EClass USER_ROLE = eINSTANCE.getUserRole();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_ROLE__ID = eINSTANCE.getUserRole_ID();

		/**
		 * The meta object literal for the '{@link model.impl.DataOutputUIImpl <em>Data Output UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.DataOutputUIImpl
		 * @see model.impl.ModelPackageImpl#getDataOutputUI()
		 * @generated
		 */
		EClass DATA_OUTPUT_UI = eINSTANCE.getDataOutputUI();

		/**
		 * The meta object literal for the '<em><b>Output Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_OUTPUT_UI__OUTPUT_VARIABLE = eINSTANCE.getDataOutputUI_OutputVariable();

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

		/**
		 * The meta object literal for the '{@link model.impl.DataSelectionUIImpl <em>Data Selection UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.DataSelectionUIImpl
		 * @see model.impl.ModelPackageImpl#getDataSelectionUI()
		 * @generated
		 */
		EClass DATA_SELECTION_UI = eINSTANCE.getDataSelectionUI();

		/**
		 * The meta object literal for the '<em><b>Min Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SELECTION_UI__MIN_CARDINALITY = eINSTANCE.getDataSelectionUI_MinCardinality();

		/**
		 * The meta object literal for the '<em><b>Max Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SELECTION_UI__MAX_CARDINALITY = eINSTANCE.getDataSelectionUI_MaxCardinality();

		/**
		 * The meta object literal for the '<em><b>Selectable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SELECTION_UI__SELECTABLE = eINSTANCE.getDataSelectionUI_Selectable();

		/**
		 * The meta object literal for the '{@link model.impl.DecisionUIImpl <em>Decision UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.DecisionUIImpl
		 * @see model.impl.ModelPackageImpl#getDecisionUI()
		 * @generated
		 */
		EClass DECISION_UI = eINSTANCE.getDecisionUI();

		/**
		 * The meta object literal for the '<em><b>Choices</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECISION_UI__CHOICES = eINSTANCE.getDecisionUI_Choices();

		/**
		 * The meta object literal for the '{@link model.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ChoiceImpl
		 * @see model.impl.ModelPackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '<em><b>Is Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHOICE__IS_DEFAULT = eINSTANCE.getChoice_IsDefault();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE__ARGUMENTS = eINSTANCE.getChoice_Arguments();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE__CONTAINER = eINSTANCE.getChoice_Container();

		/**
		 * The meta object literal for the '{@link model.impl.OnUserEventImpl <em>On User Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.OnUserEventImpl
		 * @see model.impl.ModelPackageImpl#getOnUserEvent()
		 * @generated
		 */
		EClass ON_USER_EVENT = eINSTANCE.getOnUserEvent();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ON_USER_EVENT__ACTIVITY = eINSTANCE.getOnUserEvent_Activity();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ON_USER_EVENT__VARIABLE = eINSTANCE.getOnUserEvent_Variable();

		/**
		 * The meta object literal for the '<em><b>User Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ON_USER_EVENT__USER_ROLE = eINSTANCE.getOnUserEvent_UserRole();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ON_USER_EVENT__TYPE = eINSTANCE.getOnUserEvent_Type();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ON_USER_EVENT__ID = eINSTANCE.getOnUserEvent_ID();

		/**
		 * The meta object literal for the '{@link model.impl.NewPickImpl <em>New Pick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.NewPickImpl
		 * @see model.impl.ModelPackageImpl#getNewPick()
		 * @generated
		 */
		EClass NEW_PICK = eINSTANCE.getNewPick();

		/**
		 * The meta object literal for the '<em><b>User Interacion</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_PICK__USER_INTERACION = eINSTANCE.getNewPick_UserInteracion();

		/**
		 * The meta object literal for the '{@link model.impl.NewEventHandlerImpl <em>New Event Handler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.NewEventHandlerImpl
		 * @see model.impl.ModelPackageImpl#getNewEventHandler()
		 * @generated
		 */
		EClass NEW_EVENT_HANDLER = eINSTANCE.getNewEventHandler();

		/**
		 * The meta object literal for the '<em><b>User Interacion</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_EVENT_HANDLER__USER_INTERACION = eINSTANCE.getNewEventHandler_UserInteracion();

		/**
		 * The meta object literal for the '{@link model.EventType <em>Event Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.EventType
		 * @see model.impl.ModelPackageImpl#getEventType()
		 * @generated
		 */
		EEnum EVENT_TYPE = eINSTANCE.getEventType();

	}

} //ModelPackage
