/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.bpel_ui.model;

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
 * @see be.edu.fundp.precise.bpel_ui.model.ModelFactory
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
	String eNS_URI = "http://precise.fundp.edu.be/bpel-ui/";

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
	ModelPackage eINSTANCE = be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.BPEL_UI_EntityImpl <em>BPEL UI Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.BPEL_UI_EntityImpl
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getBPEL_UI_Entity()
	 * @generated
	 */
	int BPEL_UI_ENTITY = 0;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPEL_UI_ENTITY__DOCUMENTATION_ELEMENT = BPELPackage.EXTENSIBLE_ELEMENT__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPEL_UI_ENTITY__ELEMENT = BPELPackage.EXTENSIBLE_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPEL_UI_ENTITY__EEXTENSIBILITY_ELEMENTS = BPELPackage.EXTENSIBLE_ELEMENT__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPEL_UI_ENTITY__DOCUMENTATION = BPELPackage.EXTENSIBLE_ELEMENT__DOCUMENTATION;

	/**
	 * The number of structural features of the '<em>BPEL UI Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPEL_UI_ENTITY_FEATURE_COUNT = BPELPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.UserInteractionImpl <em>User Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.UserInteractionImpl
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getUserInteraction()
	 * @generated
	 */
	int USER_INTERACTION = 1;

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
	 * The feature id for the '<em><b>Role</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__ROLE = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION_FEATURE_COUNT = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.DataInputUIImpl <em>Data Input UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.DataInputUIImpl
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getDataInputUI()
	 * @generated
	 */
	int DATA_INPUT_UI = 2;

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
	 * The feature id for the '<em><b>Role</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__ROLE = USER_INTERACTION__ROLE;

	/**
	 * The feature id for the '<em><b>Input Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__INPUT_VARIABLE = USER_INTERACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Input UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI_FEATURE_COUNT = USER_INTERACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.DataOutputUIImpl <em>Data Output UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.DataOutputUIImpl
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getDataOutputUI()
	 * @generated
	 */
	int DATA_OUTPUT_UI = 3;

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
	 * The feature id for the '<em><b>Role</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__ROLE = USER_INTERACTION__ROLE;

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
	 * The meta object id for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.DataSelectionUIImpl <em>Data Selection UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.DataSelectionUIImpl
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getDataSelectionUI()
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
	 * The feature id for the '<em><b>Role</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__ROLE = DATA_INPUT_UI__ROLE;

	/**
	 * The feature id for the '<em><b>Input Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__INPUT_VARIABLE = DATA_INPUT_UI__INPUT_VARIABLE;

	/**
	 * The feature id for the '<em><b>Output Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__OUTPUT_VARIABLE = DATA_INPUT_UI_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__MIN_CARDINALITY = DATA_INPUT_UI_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__MAX_CARDINALITY = DATA_INPUT_UI_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Data Selection UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI_FEATURE_COUNT = DATA_INPUT_UI_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.PickUIImpl <em>Pick UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.PickUIImpl
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getPickUI()
	 * @generated
	 */
	int PICK_UI = 5;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICK_UI__DOCUMENTATION_ELEMENT = BPELPackage.PICK__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICK_UI__ELEMENT = BPELPackage.PICK__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICK_UI__EEXTENSIBILITY_ELEMENTS = BPELPackage.PICK__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICK_UI__DOCUMENTATION = BPELPackage.PICK__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICK_UI__NAME = BPELPackage.PICK__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICK_UI__SUPPRESS_JOIN_FAILURE = BPELPackage.PICK__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICK_UI__TARGETS = BPELPackage.PICK__TARGETS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICK_UI__SOURCES = BPELPackage.PICK__SOURCES;

	/**
	 * The feature id for the '<em><b>Create Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICK_UI__CREATE_INSTANCE = BPELPackage.PICK__CREATE_INSTANCE;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICK_UI__MESSAGES = BPELPackage.PICK__MESSAGES;

	/**
	 * The feature id for the '<em><b>Alarm</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICK_UI__ALARM = BPELPackage.PICK__ALARM;

	/**
	 * The feature id for the '<em><b>User Interaction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICK_UI__USER_INTERACTION = BPELPackage.PICK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pick UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICK_UI_FEATURE_COUNT = BPELPackage.PICK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.EventHandlerUIImpl <em>Event Handler UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.EventHandlerUIImpl
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getEventHandlerUI()
	 * @generated
	 */
	int EVENT_HANDLER_UI = 6;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_HANDLER_UI__DOCUMENTATION_ELEMENT = BPELPackage.EVENT_HANDLER__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_HANDLER_UI__ELEMENT = BPELPackage.EVENT_HANDLER__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_HANDLER_UI__EEXTENSIBILITY_ELEMENTS = BPELPackage.EVENT_HANDLER__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_HANDLER_UI__DOCUMENTATION = BPELPackage.EVENT_HANDLER__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Alarm</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_HANDLER_UI__ALARM = BPELPackage.EVENT_HANDLER__ALARM;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_HANDLER_UI__EVENTS = BPELPackage.EVENT_HANDLER__EVENTS;

	/**
	 * The feature id for the '<em><b>User Interaction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_HANDLER_UI__USER_INTERACTION = BPELPackage.EVENT_HANDLER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event Handler UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_HANDLER_UI_FEATURE_COUNT = BPELPackage.EVENT_HANDLER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.ScopeUIImpl <em>Scope UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.ScopeUIImpl
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getScopeUI()
	 * @generated
	 */
	int SCOPE_UI = 7;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__DOCUMENTATION_ELEMENT = BPELPackage.SCOPE__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__ELEMENT = BPELPackage.SCOPE__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__EEXTENSIBILITY_ELEMENTS = BPELPackage.SCOPE__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__DOCUMENTATION = BPELPackage.SCOPE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__NAME = BPELPackage.SCOPE__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__SUPPRESS_JOIN_FAILURE = BPELPackage.SCOPE__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__TARGETS = BPELPackage.SCOPE__TARGETS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__SOURCES = BPELPackage.SCOPE__SOURCES;

	/**
	 * The feature id for the '<em><b>Isolated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__ISOLATED = BPELPackage.SCOPE__ISOLATED;

	/**
	 * The feature id for the '<em><b>Fault Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__FAULT_HANDLERS = BPELPackage.SCOPE__FAULT_HANDLERS;

	/**
	 * The feature id for the '<em><b>Compensation Handler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__COMPENSATION_HANDLER = BPELPackage.SCOPE__COMPENSATION_HANDLER;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__ACTIVITY = BPELPackage.SCOPE__ACTIVITY;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__VARIABLES = BPELPackage.SCOPE__VARIABLES;

	/**
	 * The feature id for the '<em><b>Correlation Sets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__CORRELATION_SETS = BPELPackage.SCOPE__CORRELATION_SETS;

	/**
	 * The feature id for the '<em><b>Event Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__EVENT_HANDLERS = BPELPackage.SCOPE__EVENT_HANDLERS;

	/**
	 * The feature id for the '<em><b>Partner Links</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__PARTNER_LINKS = BPELPackage.SCOPE__PARTNER_LINKS;

	/**
	 * The feature id for the '<em><b>Termination Handler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__TERMINATION_HANDLER = BPELPackage.SCOPE__TERMINATION_HANDLER;

	/**
	 * The feature id for the '<em><b>Message Exchanges</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__MESSAGE_EXCHANGES = BPELPackage.SCOPE__MESSAGE_EXCHANGES;

	/**
	 * The feature id for the '<em><b>Exit On Standard Fault</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI__EXIT_ON_STANDARD_FAULT = BPELPackage.SCOPE__EXIT_ON_STANDARD_FAULT;

	/**
	 * The number of structural features of the '<em>Scope UI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_UI_FEATURE_COUNT = BPELPackage.SCOPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.UserRoleImpl <em>User Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.UserRoleImpl
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getUserRole()
	 * @generated
	 */
	int USER_ROLE = 8;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ROLE__DOCUMENTATION_ELEMENT = BPEL_UI_ENTITY__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ROLE__ELEMENT = BPEL_UI_ENTITY__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ROLE__EEXTENSIBILITY_ELEMENTS = BPEL_UI_ENTITY__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ROLE__DOCUMENTATION = BPEL_UI_ENTITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ROLE__ID = BPEL_UI_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ROLE_FEATURE_COUNT = BPEL_UI_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.OnUserEventImpl <em>On User Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.OnUserEventImpl
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getOnUserEvent()
	 * @generated
	 */
	int ON_USER_EVENT = 9;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__DOCUMENTATION_ELEMENT = BPEL_UI_ENTITY__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__ELEMENT = BPEL_UI_ENTITY__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__EEXTENSIBILITY_ELEMENTS = BPEL_UI_ENTITY__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__DOCUMENTATION = BPEL_UI_ENTITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__ID = BPEL_UI_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__TYPE = BPEL_UI_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__VARIABLE = BPEL_UI_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__CONTAINER = BPEL_UI_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>On User Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT_FEATURE_COUNT = BPEL_UI_ENTITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.bpel_ui.model.UserEventType <em>User Event Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.bpel_ui.model.UserEventType
	 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getUserEventType()
	 * @generated
	 */
	int USER_EVENT_TYPE = 10;


	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.bpel_ui.model.BPEL_UI_Entity <em>BPEL UI Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPEL UI Entity</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.BPEL_UI_Entity
	 * @generated
	 */
	EClass getBPEL_UI_Entity();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.bpel_ui.model.UserInteraction <em>User Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Interaction</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.UserInteraction
	 * @generated
	 */
	EClass getUserInteraction();

	/**
	 * Returns the meta object for the containment reference list '{@link be.edu.fundp.precise.bpel_ui.model.UserInteraction#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Role</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.UserInteraction#getRole()
	 * @see #getUserInteraction()
	 * @generated
	 */
	EReference getUserInteraction_Role();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.bpel_ui.model.DataInputUI <em>Data Input UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Input UI</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.DataInputUI
	 * @generated
	 */
	EClass getDataInputUI();

	/**
	 * Returns the meta object for the reference '{@link be.edu.fundp.precise.bpel_ui.model.DataInputUI#getInputVariable <em>Input Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input Variable</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.DataInputUI#getInputVariable()
	 * @see #getDataInputUI()
	 * @generated
	 */
	EReference getDataInputUI_InputVariable();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.bpel_ui.model.DataOutputUI <em>Data Output UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Output UI</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.DataOutputUI
	 * @generated
	 */
	EClass getDataOutputUI();

	/**
	 * Returns the meta object for the reference '{@link be.edu.fundp.precise.bpel_ui.model.DataOutputUI#getOutputVariable <em>Output Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output Variable</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.DataOutputUI#getOutputVariable()
	 * @see #getDataOutputUI()
	 * @generated
	 */
	EReference getDataOutputUI_OutputVariable();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.bpel_ui.model.DataSelectionUI <em>Data Selection UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Selection UI</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.DataSelectionUI
	 * @generated
	 */
	EClass getDataSelectionUI();

	/**
	 * Returns the meta object for the attribute '{@link be.edu.fundp.precise.bpel_ui.model.DataSelectionUI#getMinCardinality <em>Min Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Cardinality</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.DataSelectionUI#getMinCardinality()
	 * @see #getDataSelectionUI()
	 * @generated
	 */
	EAttribute getDataSelectionUI_MinCardinality();

	/**
	 * Returns the meta object for the attribute '{@link be.edu.fundp.precise.bpel_ui.model.DataSelectionUI#getMaxCardinality <em>Max Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Cardinality</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.DataSelectionUI#getMaxCardinality()
	 * @see #getDataSelectionUI()
	 * @generated
	 */
	EAttribute getDataSelectionUI_MaxCardinality();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.bpel_ui.model.PickUI <em>Pick UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pick UI</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.PickUI
	 * @generated
	 */
	EClass getPickUI();

	/**
	 * Returns the meta object for the containment reference list '{@link be.edu.fundp.precise.bpel_ui.model.PickUI#getUserInteraction <em>User Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>User Interaction</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.PickUI#getUserInteraction()
	 * @see #getPickUI()
	 * @generated
	 */
	EReference getPickUI_UserInteraction();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.bpel_ui.model.EventHandlerUI <em>Event Handler UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Handler UI</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.EventHandlerUI
	 * @generated
	 */
	EClass getEventHandlerUI();

	/**
	 * Returns the meta object for the containment reference list '{@link be.edu.fundp.precise.bpel_ui.model.EventHandlerUI#getUserInteraction <em>User Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>User Interaction</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.EventHandlerUI#getUserInteraction()
	 * @see #getEventHandlerUI()
	 * @generated
	 */
	EReference getEventHandlerUI_UserInteraction();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.bpel_ui.model.ScopeUI <em>Scope UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scope UI</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.ScopeUI
	 * @generated
	 */
	EClass getScopeUI();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.bpel_ui.model.UserRole <em>User Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Role</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.UserRole
	 * @generated
	 */
	EClass getUserRole();

	/**
	 * Returns the meta object for the attribute '{@link be.edu.fundp.precise.bpel_ui.model.UserRole#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.UserRole#getId()
	 * @see #getUserRole()
	 * @generated
	 */
	EAttribute getUserRole_Id();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.bpel_ui.model.OnUserEvent <em>On User Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>On User Event</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.OnUserEvent
	 * @generated
	 */
	EClass getOnUserEvent();

	/**
	 * Returns the meta object for the attribute '{@link be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getId()
	 * @see #getOnUserEvent()
	 * @generated
	 */
	EAttribute getOnUserEvent_Id();

	/**
	 * Returns the meta object for the attribute '{@link be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getType()
	 * @see #getOnUserEvent()
	 * @generated
	 */
	EAttribute getOnUserEvent_Type();

	/**
	 * Returns the meta object for the reference '{@link be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getVariable()
	 * @see #getOnUserEvent()
	 * @generated
	 */
	EReference getOnUserEvent_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Container</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.OnUserEvent#getContainer()
	 * @see #getOnUserEvent()
	 * @generated
	 */
	EReference getOnUserEvent_Container();

	/**
	 * Returns the meta object for enum '{@link be.edu.fundp.precise.bpel_ui.model.UserEventType <em>User Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>User Event Type</em>'.
	 * @see be.edu.fundp.precise.bpel_ui.model.UserEventType
	 * @generated
	 */
	EEnum getUserEventType();

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
		 * The meta object literal for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.BPEL_UI_EntityImpl <em>BPEL UI Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.BPEL_UI_EntityImpl
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getBPEL_UI_Entity()
		 * @generated
		 */
		EClass BPEL_UI_ENTITY = eINSTANCE.getBPEL_UI_Entity();

		/**
		 * The meta object literal for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.UserInteractionImpl <em>User Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.UserInteractionImpl
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getUserInteraction()
		 * @generated
		 */
		EClass USER_INTERACTION = eINSTANCE.getUserInteraction();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERACTION__ROLE = eINSTANCE.getUserInteraction_Role();

		/**
		 * The meta object literal for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.DataInputUIImpl <em>Data Input UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.DataInputUIImpl
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getDataInputUI()
		 * @generated
		 */
		EClass DATA_INPUT_UI = eINSTANCE.getDataInputUI();

		/**
		 * The meta object literal for the '<em><b>Input Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_INPUT_UI__INPUT_VARIABLE = eINSTANCE.getDataInputUI_InputVariable();

		/**
		 * The meta object literal for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.DataOutputUIImpl <em>Data Output UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.DataOutputUIImpl
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getDataOutputUI()
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
		 * The meta object literal for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.DataSelectionUIImpl <em>Data Selection UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.DataSelectionUIImpl
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getDataSelectionUI()
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
		 * The meta object literal for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.PickUIImpl <em>Pick UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.PickUIImpl
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getPickUI()
		 * @generated
		 */
		EClass PICK_UI = eINSTANCE.getPickUI();

		/**
		 * The meta object literal for the '<em><b>User Interaction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PICK_UI__USER_INTERACTION = eINSTANCE.getPickUI_UserInteraction();

		/**
		 * The meta object literal for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.EventHandlerUIImpl <em>Event Handler UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.EventHandlerUIImpl
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getEventHandlerUI()
		 * @generated
		 */
		EClass EVENT_HANDLER_UI = eINSTANCE.getEventHandlerUI();

		/**
		 * The meta object literal for the '<em><b>User Interaction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_HANDLER_UI__USER_INTERACTION = eINSTANCE.getEventHandlerUI_UserInteraction();

		/**
		 * The meta object literal for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.ScopeUIImpl <em>Scope UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.ScopeUIImpl
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getScopeUI()
		 * @generated
		 */
		EClass SCOPE_UI = eINSTANCE.getScopeUI();

		/**
		 * The meta object literal for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.UserRoleImpl <em>User Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.UserRoleImpl
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getUserRole()
		 * @generated
		 */
		EClass USER_ROLE = eINSTANCE.getUserRole();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_ROLE__ID = eINSTANCE.getUserRole_Id();

		/**
		 * The meta object literal for the '{@link be.edu.fundp.precise.bpel_ui.model.impl.OnUserEventImpl <em>On User Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.OnUserEventImpl
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getOnUserEvent()
		 * @generated
		 */
		EClass ON_USER_EVENT = eINSTANCE.getOnUserEvent();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ON_USER_EVENT__ID = eINSTANCE.getOnUserEvent_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ON_USER_EVENT__TYPE = eINSTANCE.getOnUserEvent_Type();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ON_USER_EVENT__VARIABLE = eINSTANCE.getOnUserEvent_Variable();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ON_USER_EVENT__CONTAINER = eINSTANCE.getOnUserEvent_Container();

		/**
		 * The meta object literal for the '{@link be.edu.fundp.precise.bpel_ui.model.UserEventType <em>User Event Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.bpel_ui.model.UserEventType
		 * @see be.edu.fundp.precise.bpel_ui.model.impl.ModelPackageImpl#getUserEventType()
		 * @generated
		 */
		EEnum USER_EVENT_TYPE = eINSTANCE.getUserEventType();

	}

} //ModelPackage
