/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.impl;

import model.Choice;
import javax.xml.namespace.QName;

import model.DataInputUI;
import model.DataOutputUI;
import model.DataSelectionUI;
import model.DecisionUI;
import model.EventType;
import model.ModelFactory;
import model.ModelPackage;
import model.NewEventHandler;
import model.NewPick;
import model.OnUserEvent;
import model.UserInteraction;
import model.UserRole;
import model.util.BPEL_UIDeserializer;
import model.util.BPEL_UI_Serializer;
import model.util.ExtensionsampleConstants;

import org.eclipse.bpel.model.BPELPackage;

import org.eclipse.bpel.model.extensions.BPELExtensionRegistry;
import org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage;

import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userInteractionEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userRoleEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataOutputUIEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataInputUIEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSelectionUIEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decisionUIEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass onUserEventEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newPickEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newEventHandlerEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eventTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @customized
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BPELPackage.eINSTANCE.eClass();
		PartnerlinktypePackage.eINSTANCE.eClass();
		MessagepropertiesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();
		
		registerSerializerAndDeserializer();
  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserInteraction() {
		return userInteractionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserInteraction_Roles() {
		return (EReference)userInteractionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserRole() {
		return userRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserRole_ID() {
		return (EAttribute)userRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataOutputUI() {
		return dataOutputUIEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataOutputUI_OutputVariable() {
		return (EReference)dataOutputUIEClass.getEStructuralFeatures().get(0);
	}

	private static void registerSerializerAndDeserializer() {
		// Initialize BPEL extension registry
		BPELExtensionRegistry extensionRegistry = BPELExtensionRegistry.getInstance();

		// Initialize our own serializers and deserializers
		BPEL_UIDeserializer deserializer = new BPEL_UIDeserializer();
		BPEL_UI_Serializer serializer = new BPEL_UI_Serializer();

		// DataInputUI
		String name = DataInputUI.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				ExtensionsampleConstants.ND_DATA_INPUT_UI), deserializer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				serializer);
		
		// DataOutputUI
		name = DataOutputUI.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				ExtensionsampleConstants.ND_DATA_OUTPUT_UI), deserializer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				serializer);
		
		// DataSelectionUI
		name = DataSelectionUI.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				ExtensionsampleConstants.ND_DATA_SELECTION_UI), deserializer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				serializer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataInputUI() {
		return dataInputUIEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataInputUI_UserValidation() {
		return (EAttribute)dataInputUIEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataInputUI_InputVariable() {
		return (EReference)dataInputUIEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataSelectionUI() {
		return dataSelectionUIEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataSelectionUI_MinCardinality() {
		return (EAttribute)dataSelectionUIEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataSelectionUI_MaxCardinality() {
		return (EAttribute)dataSelectionUIEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSelectionUI_Selectable() {
		return (EReference)dataSelectionUIEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecisionUI() {
		return decisionUIEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecisionUI_Choices() {
		return (EReference)decisionUIEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoice() {
		return choiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChoice_IsDefault() {
		return (EAttribute)choiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoice_Arguments() {
		return (EReference)choiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoice_Container() {
		return (EReference)choiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOnUserEvent() {
		return onUserEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnUserEvent_Activity() {
		return (EReference)onUserEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnUserEvent_Variable() {
		return (EReference)onUserEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnUserEvent_UserRole() {
		return (EReference)onUserEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOnUserEvent_Type() {
		return (EAttribute)onUserEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOnUserEvent_ID() {
		return (EAttribute)onUserEventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewPick() {
		return newPickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewPick_UserInteracion() {
		return (EReference)newPickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewEventHandler() {
		return newEventHandlerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewEventHandler_UserInteracion() {
		return (EReference)newEventHandlerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEventType() {
		return eventTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		userInteractionEClass = createEClass(USER_INTERACTION);
		createEReference(userInteractionEClass, USER_INTERACTION__ROLES);

		userRoleEClass = createEClass(USER_ROLE);
		createEAttribute(userRoleEClass, USER_ROLE__ID);

		dataOutputUIEClass = createEClass(DATA_OUTPUT_UI);
		createEReference(dataOutputUIEClass, DATA_OUTPUT_UI__OUTPUT_VARIABLE);

		dataInputUIEClass = createEClass(DATA_INPUT_UI);
		createEAttribute(dataInputUIEClass, DATA_INPUT_UI__USER_VALIDATION);
		createEReference(dataInputUIEClass, DATA_INPUT_UI__INPUT_VARIABLE);

		dataSelectionUIEClass = createEClass(DATA_SELECTION_UI);
		createEAttribute(dataSelectionUIEClass, DATA_SELECTION_UI__MIN_CARDINALITY);
		createEAttribute(dataSelectionUIEClass, DATA_SELECTION_UI__MAX_CARDINALITY);
		createEReference(dataSelectionUIEClass, DATA_SELECTION_UI__SELECTABLE);

		decisionUIEClass = createEClass(DECISION_UI);
		createEReference(decisionUIEClass, DECISION_UI__CHOICES);

		choiceEClass = createEClass(CHOICE);
		createEAttribute(choiceEClass, CHOICE__IS_DEFAULT);
		createEReference(choiceEClass, CHOICE__ARGUMENTS);
		createEReference(choiceEClass, CHOICE__CONTAINER);

		onUserEventEClass = createEClass(ON_USER_EVENT);
		createEReference(onUserEventEClass, ON_USER_EVENT__ACTIVITY);
		createEReference(onUserEventEClass, ON_USER_EVENT__VARIABLE);
		createEReference(onUserEventEClass, ON_USER_EVENT__USER_ROLE);
		createEAttribute(onUserEventEClass, ON_USER_EVENT__TYPE);
		createEAttribute(onUserEventEClass, ON_USER_EVENT__ID);

		newPickEClass = createEClass(NEW_PICK);
		createEReference(newPickEClass, NEW_PICK__USER_INTERACION);

		newEventHandlerEClass = createEClass(NEW_EVENT_HANDLER);
		createEReference(newEventHandlerEClass, NEW_EVENT_HANDLER__USER_INTERACION);

		// Create enums
		eventTypeEEnum = createEEnum(EVENT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BPELPackage theBPELPackage = (BPELPackage)EPackage.Registry.INSTANCE.getEPackage(BPELPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		userInteractionEClass.getESuperTypes().add(theBPELPackage.getExtensionActivity());
		userRoleEClass.getESuperTypes().add(theBPELPackage.getExtensibleElement());
		dataOutputUIEClass.getESuperTypes().add(this.getUserInteraction());
		dataInputUIEClass.getESuperTypes().add(this.getUserInteraction());
		dataSelectionUIEClass.getESuperTypes().add(this.getDataInputUI());
		decisionUIEClass.getESuperTypes().add(this.getUserInteraction());
		choiceEClass.getESuperTypes().add(theBPELPackage.getExtensibleElement());
		onUserEventEClass.getESuperTypes().add(theBPELPackage.getExtensibleElement());
		newPickEClass.getESuperTypes().add(theBPELPackage.getExtensionActivity());
		newPickEClass.getESuperTypes().add(theBPELPackage.getPick());
		newEventHandlerEClass.getESuperTypes().add(theBPELPackage.getEventHandler());

		// Initialize classes and features; add operations and parameters
		initEClass(userInteractionEClass, UserInteraction.class, "UserInteraction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserInteraction_Roles(), this.getUserRole(), null, "roles", null, 1, -1, UserInteraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userRoleEClass, UserRole.class, "UserRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUserRole_ID(), ecorePackage.getEString(), "ID", null, 1, 1, UserRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataOutputUIEClass, DataOutputUI.class, "DataOutputUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataOutputUI_OutputVariable(), theBPELPackage.getVariable(), null, "outputVariable", null, 1, 1, DataOutputUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataInputUIEClass, DataInputUI.class, "DataInputUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataInputUI_UserValidation(), ecorePackage.getEBoolean(), "userValidation", "false", 0, 1, DataInputUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataInputUI_InputVariable(), theBPELPackage.getVariable(), null, "inputVariable", null, 1, 1, DataInputUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataSelectionUIEClass, DataSelectionUI.class, "DataSelectionUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataSelectionUI_MinCardinality(), ecorePackage.getEInt(), "minCardinality", null, 1, 1, DataSelectionUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataSelectionUI_MaxCardinality(), ecorePackage.getEInt(), "maxCardinality", null, 1, 1, DataSelectionUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataSelectionUI_Selectable(), theBPELPackage.getVariable(), null, "selectable", null, 1, 1, DataSelectionUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(decisionUIEClass, DecisionUI.class, "DecisionUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDecisionUI_Choices(), this.getChoice(), null, "choices", null, 2, -1, DecisionUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(choiceEClass, Choice.class, "Choice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChoice_IsDefault(), ecorePackage.getEBoolean(), "isDefault", "false", 0, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChoice_Arguments(), theBPELPackage.getVariable(), null, "arguments", null, 0, -1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChoice_Container(), theBPELPackage.getActivity(), null, "container", null, 1, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(onUserEventEClass, OnUserEvent.class, "OnUserEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOnUserEvent_Activity(), theBPELPackage.getActivity(), null, "activity", null, 1, 1, OnUserEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOnUserEvent_Variable(), theBPELPackage.getVariable(), null, "variable", null, 0, 1, OnUserEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOnUserEvent_UserRole(), this.getUserRole(), null, "userRole", null, 0, 1, OnUserEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOnUserEvent_Type(), this.getEventType(), "type", null, 0, 1, OnUserEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOnUserEvent_ID(), ecorePackage.getEString(), "ID", null, 0, 1, OnUserEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newPickEClass, NewPick.class, "NewPick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewPick_UserInteracion(), this.getOnUserEvent(), null, "userInteracion", null, 0, -1, NewPick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newEventHandlerEClass, NewEventHandler.class, "NewEventHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewEventHandler_UserInteracion(), this.getOnUserEvent(), null, "userInteracion", null, 0, -1, NewEventHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eventTypeEEnum, EventType.class, "EventType");
		addEEnumLiteral(eventTypeEEnum, EventType.ON_DATA_INPUT);
		addEEnumLiteral(eventTypeEEnum, EventType.ON_DATA_OUTPUT);
		addEEnumLiteral(eventTypeEEnum, EventType.ON_DATA_SELECTION);
		addEEnumLiteral(eventTypeEEnum, EventType.ON_DECISION_INTERACTION);
		addEEnumLiteral(eventTypeEEnum, EventType.ON_IMPLICIT_INTERACION);

		// Create resource
		createResource(eNS_URI);
	}

} //ModelPackageImpl
