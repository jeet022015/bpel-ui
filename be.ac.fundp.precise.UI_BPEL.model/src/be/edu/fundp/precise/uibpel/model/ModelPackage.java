/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model;

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
 * @see be.edu.fundp.precise.uibpel.model.ModelFactory
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
	String eNS_URI = "http://fundp.ac.be/precise/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ui_bpel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.uibpel.model.impl.UsableEntityImpl <em>Usable Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.uibpel.model.impl.UsableEntityImpl
	 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getUsableEntity()
	 * @generated
	 */
	int USABLE_ENTITY = 0;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USABLE_ENTITY__DOCUMENTATION_ELEMENT = BPELPackage.BPEL_EXTENSIBLE_ELEMENT__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USABLE_ENTITY__ELEMENT = BPELPackage.BPEL_EXTENSIBLE_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USABLE_ENTITY__EEXTENSIBILITY_ELEMENTS = BPELPackage.BPEL_EXTENSIBLE_ELEMENT__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USABLE_ENTITY__DOCUMENTATION = BPELPackage.BPEL_EXTENSIBLE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USABLE_ENTITY__ROLES = BPELPackage.BPEL_EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USABLE_ENTITY__ID = BPELPackage.BPEL_EXTENSIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Usable Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USABLE_ENTITY_FEATURE_COUNT = BPELPackage.BPEL_EXTENSIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl <em>User Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl
	 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getUserInteraction()
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
	int USER_INTERACTION__DOCUMENTATION_ELEMENT = USABLE_ENTITY__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__ELEMENT = USABLE_ENTITY__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__EEXTENSIBILITY_ELEMENTS = USABLE_ENTITY__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__DOCUMENTATION = USABLE_ENTITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__ROLES = USABLE_ENTITY__ROLES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__ID = USABLE_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__NAME = USABLE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__SUPPRESS_JOIN_FAILURE = USABLE_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__TARGETS = USABLE_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__SOURCES = USABLE_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__DATA = USABLE_ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>User Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION_FEATURE_COUNT = USABLE_ENTITY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.uibpel.model.impl.DataItemImpl <em>Data Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.uibpel.model.impl.DataItemImpl
	 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getDataItem()
	 * @generated
	 */
	int DATA_ITEM = 2;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM__DOCUMENTATION_ELEMENT = BPELPackage.BPEL_EXTENSIBLE_ELEMENT__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM__ELEMENT = BPELPackage.BPEL_EXTENSIBLE_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM__EEXTENSIBILITY_ELEMENTS = BPELPackage.BPEL_EXTENSIBLE_ELEMENT__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM__DOCUMENTATION = BPELPackage.BPEL_EXTENSIBLE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM__DESCRIPTION = BPELPackage.BPEL_EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM__TYPE = BPELPackage.BPEL_EXTENSIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_FEATURE_COUNT = BPELPackage.BPEL_EXTENSIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.uibpel.model.impl.DataInputUIImpl <em>Data Input UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.uibpel.model.impl.DataInputUIImpl
	 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getDataInputUI()
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
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__ROLES = USER_INTERACTION__ROLES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__ID = USER_INTERACTION__ID;

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
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_UI__DATA = USER_INTERACTION__DATA;

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
	 * The meta object id for the '{@link be.edu.fundp.precise.uibpel.model.impl.DataOutputUIImpl <em>Data Output UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.uibpel.model.impl.DataOutputUIImpl
	 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getDataOutputUI()
	 * @generated
	 */
	int DATA_OUTPUT_UI = 4;

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
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__ROLES = USER_INTERACTION__ROLES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__ID = USER_INTERACTION__ID;

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
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_UI__DATA = USER_INTERACTION__DATA;

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
	 * The meta object id for the '{@link be.edu.fundp.precise.uibpel.model.impl.DataSelectionUIImpl <em>Data Selection UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.uibpel.model.impl.DataSelectionUIImpl
	 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getDataSelectionUI()
	 * @generated
	 */
	int DATA_SELECTION_UI = 5;

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
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__ROLES = DATA_INPUT_UI__ROLES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__ID = DATA_INPUT_UI__ID;

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
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SELECTION_UI__DATA = DATA_INPUT_UI__DATA;

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
	 * The meta object id for the '{@link be.edu.fundp.precise.uibpel.model.impl.OnUserEventImpl <em>On User Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.uibpel.model.impl.OnUserEventImpl
	 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getOnUserEvent()
	 * @generated
	 */
	int ON_USER_EVENT = 6;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__DOCUMENTATION_ELEMENT = USABLE_ENTITY__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__ELEMENT = USABLE_ENTITY__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__EEXTENSIBILITY_ELEMENTS = USABLE_ENTITY__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__DOCUMENTATION = USABLE_ENTITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__ROLES = USABLE_ENTITY__ROLES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__ID = USABLE_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT__ACTIVITY = USABLE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>On User Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_USER_EVENT_FEATURE_COUNT = USABLE_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link be.edu.fundp.precise.uibpel.model.impl.PickUIImpl <em>Pick UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.uibpel.model.impl.PickUIImpl
	 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getPickUI()
	 * @generated
	 */
	int PICK_UI = 7;

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
	 * The meta object id for the '{@link be.edu.fundp.precise.uibpel.model.impl.ScopeUIImpl <em>Scope UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.uibpel.model.impl.ScopeUIImpl
	 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getScopeUI()
	 * @generated
	 */
	int SCOPE_UI = 8;

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
	 * The meta object id for the '{@link be.edu.fundp.precise.uibpel.model.impl.EventHandlerUIImpl <em>Event Handler UI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.uibpel.model.impl.EventHandlerUIImpl
	 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getEventHandlerUI()
	 * @generated
	 */
	int EVENT_HANDLER_UI = 9;

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
	 * The meta object id for the '{@link be.edu.fundp.precise.uibpel.model.DataType <em>Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.edu.fundp.precise.uibpel.model.DataType
	 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 10;


	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.uibpel.model.UsableEntity <em>Usable Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Usable Entity</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.UsableEntity
	 * @generated
	 */
	EClass getUsableEntity();

	/**
	 * Returns the meta object for the attribute list '{@link be.edu.fundp.precise.uibpel.model.UsableEntity#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Roles</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.UsableEntity#getRoles()
	 * @see #getUsableEntity()
	 * @generated
	 */
	EAttribute getUsableEntity_Roles();

	/**
	 * Returns the meta object for the attribute '{@link be.edu.fundp.precise.uibpel.model.UsableEntity#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.UsableEntity#getId()
	 * @see #getUsableEntity()
	 * @generated
	 */
	EAttribute getUsableEntity_Id();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.uibpel.model.UserInteraction <em>User Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Interaction</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.UserInteraction
	 * @generated
	 */
	EClass getUserInteraction();

	/**
	 * Returns the meta object for the containment reference list '{@link be.edu.fundp.precise.uibpel.model.UserInteraction#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.UserInteraction#getData()
	 * @see #getUserInteraction()
	 * @generated
	 */
	EReference getUserInteraction_Data();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.uibpel.model.DataItem <em>Data Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Item</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.DataItem
	 * @generated
	 */
	EClass getDataItem();

	/**
	 * Returns the meta object for the attribute '{@link be.edu.fundp.precise.uibpel.model.DataItem#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.DataItem#getDescription()
	 * @see #getDataItem()
	 * @generated
	 */
	EAttribute getDataItem_Description();

	/**
	 * Returns the meta object for the attribute '{@link be.edu.fundp.precise.uibpel.model.DataItem#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.DataItem#getType()
	 * @see #getDataItem()
	 * @generated
	 */
	EAttribute getDataItem_Type();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.uibpel.model.DataInputUI <em>Data Input UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Input UI</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.DataInputUI
	 * @generated
	 */
	EClass getDataInputUI();

	/**
	 * Returns the meta object for the reference '{@link be.edu.fundp.precise.uibpel.model.DataInputUI#getInputVariable <em>Input Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input Variable</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.DataInputUI#getInputVariable()
	 * @see #getDataInputUI()
	 * @generated
	 */
	EReference getDataInputUI_InputVariable();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.uibpel.model.DataOutputUI <em>Data Output UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Output UI</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.DataOutputUI
	 * @generated
	 */
	EClass getDataOutputUI();

	/**
	 * Returns the meta object for the reference '{@link be.edu.fundp.precise.uibpel.model.DataOutputUI#getOutputVariable <em>Output Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output Variable</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.DataOutputUI#getOutputVariable()
	 * @see #getDataOutputUI()
	 * @generated
	 */
	EReference getDataOutputUI_OutputVariable();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.uibpel.model.DataSelectionUI <em>Data Selection UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Selection UI</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.DataSelectionUI
	 * @generated
	 */
	EClass getDataSelectionUI();

	/**
	 * Returns the meta object for the attribute '{@link be.edu.fundp.precise.uibpel.model.DataSelectionUI#getMinCardinality <em>Min Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Cardinality</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.DataSelectionUI#getMinCardinality()
	 * @see #getDataSelectionUI()
	 * @generated
	 */
	EAttribute getDataSelectionUI_MinCardinality();

	/**
	 * Returns the meta object for the attribute '{@link be.edu.fundp.precise.uibpel.model.DataSelectionUI#getMaxCardinality <em>Max Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Cardinality</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.DataSelectionUI#getMaxCardinality()
	 * @see #getDataSelectionUI()
	 * @generated
	 */
	EAttribute getDataSelectionUI_MaxCardinality();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.uibpel.model.OnUserEvent <em>On User Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>On User Event</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.OnUserEvent
	 * @generated
	 */
	EClass getOnUserEvent();

	/**
	 * Returns the meta object for the containment reference '{@link be.edu.fundp.precise.uibpel.model.OnUserEvent#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Activity</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.OnUserEvent#getActivity()
	 * @see #getOnUserEvent()
	 * @generated
	 */
	EReference getOnUserEvent_Activity();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.uibpel.model.PickUI <em>Pick UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pick UI</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.PickUI
	 * @generated
	 */
	EClass getPickUI();

	/**
	 * Returns the meta object for the containment reference list '{@link be.edu.fundp.precise.uibpel.model.PickUI#getUserInteraction <em>User Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>User Interaction</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.PickUI#getUserInteraction()
	 * @see #getPickUI()
	 * @generated
	 */
	EReference getPickUI_UserInteraction();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.uibpel.model.ScopeUI <em>Scope UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scope UI</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.ScopeUI
	 * @generated
	 */
	EClass getScopeUI();

	/**
	 * Returns the meta object for class '{@link be.edu.fundp.precise.uibpel.model.EventHandlerUI <em>Event Handler UI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Handler UI</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.EventHandlerUI
	 * @generated
	 */
	EClass getEventHandlerUI();

	/**
	 * Returns the meta object for the containment reference list '{@link be.edu.fundp.precise.uibpel.model.EventHandlerUI#getUserInteraction <em>User Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>User Interaction</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.EventHandlerUI#getUserInteraction()
	 * @see #getEventHandlerUI()
	 * @generated
	 */
	EReference getEventHandlerUI_UserInteraction();

	/**
	 * Returns the meta object for enum '{@link be.edu.fundp.precise.uibpel.model.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Type</em>'.
	 * @see be.edu.fundp.precise.uibpel.model.DataType
	 * @generated
	 */
	EEnum getDataType();

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
		 * The meta object literal for the '{@link be.edu.fundp.precise.uibpel.model.impl.UsableEntityImpl <em>Usable Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.uibpel.model.impl.UsableEntityImpl
		 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getUsableEntity()
		 * @generated
		 */
		EClass USABLE_ENTITY = eINSTANCE.getUsableEntity();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USABLE_ENTITY__ROLES = eINSTANCE.getUsableEntity_Roles();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USABLE_ENTITY__ID = eINSTANCE.getUsableEntity_Id();

		/**
		 * The meta object literal for the '{@link be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl <em>User Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl
		 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getUserInteraction()
		 * @generated
		 */
		EClass USER_INTERACTION = eINSTANCE.getUserInteraction();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERACTION__DATA = eINSTANCE.getUserInteraction_Data();

		/**
		 * The meta object literal for the '{@link be.edu.fundp.precise.uibpel.model.impl.DataItemImpl <em>Data Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.uibpel.model.impl.DataItemImpl
		 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getDataItem()
		 * @generated
		 */
		EClass DATA_ITEM = eINSTANCE.getDataItem();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_ITEM__DESCRIPTION = eINSTANCE.getDataItem_Description();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_ITEM__TYPE = eINSTANCE.getDataItem_Type();

		/**
		 * The meta object literal for the '{@link be.edu.fundp.precise.uibpel.model.impl.DataInputUIImpl <em>Data Input UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.uibpel.model.impl.DataInputUIImpl
		 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getDataInputUI()
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
		 * The meta object literal for the '{@link be.edu.fundp.precise.uibpel.model.impl.DataOutputUIImpl <em>Data Output UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.uibpel.model.impl.DataOutputUIImpl
		 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getDataOutputUI()
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
		 * The meta object literal for the '{@link be.edu.fundp.precise.uibpel.model.impl.DataSelectionUIImpl <em>Data Selection UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.uibpel.model.impl.DataSelectionUIImpl
		 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getDataSelectionUI()
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
		 * The meta object literal for the '{@link be.edu.fundp.precise.uibpel.model.impl.OnUserEventImpl <em>On User Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.uibpel.model.impl.OnUserEventImpl
		 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getOnUserEvent()
		 * @generated
		 */
		EClass ON_USER_EVENT = eINSTANCE.getOnUserEvent();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ON_USER_EVENT__ACTIVITY = eINSTANCE.getOnUserEvent_Activity();

		/**
		 * The meta object literal for the '{@link be.edu.fundp.precise.uibpel.model.impl.PickUIImpl <em>Pick UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.uibpel.model.impl.PickUIImpl
		 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getPickUI()
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
		 * The meta object literal for the '{@link be.edu.fundp.precise.uibpel.model.impl.ScopeUIImpl <em>Scope UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.uibpel.model.impl.ScopeUIImpl
		 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getScopeUI()
		 * @generated
		 */
		EClass SCOPE_UI = eINSTANCE.getScopeUI();

		/**
		 * The meta object literal for the '{@link be.edu.fundp.precise.uibpel.model.impl.EventHandlerUIImpl <em>Event Handler UI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.uibpel.model.impl.EventHandlerUIImpl
		 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getEventHandlerUI()
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
		 * The meta object literal for the '{@link be.edu.fundp.precise.uibpel.model.DataType <em>Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.edu.fundp.precise.uibpel.model.DataType
		 * @see be.edu.fundp.precise.uibpel.model.impl.ModelPackageImpl#getDataType()
		 * @generated
		 */
		EEnum DATA_TYPE = eINSTANCE.getDataType();

	}

} //ModelPackage
