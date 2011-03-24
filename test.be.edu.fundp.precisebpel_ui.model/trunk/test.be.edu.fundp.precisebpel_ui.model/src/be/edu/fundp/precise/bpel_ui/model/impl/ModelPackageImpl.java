/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.bpel_ui.model.impl;

import javax.xml.namespace.QName;

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

import be.edu.fundp.precise.bpel_ui.model.BPEL_UI_Entity;
import be.edu.fundp.precise.bpel_ui.model.DataInputUI;
import be.edu.fundp.precise.bpel_ui.model.DataOutputUI;
import be.edu.fundp.precise.bpel_ui.model.DataSelectionUI;
import be.edu.fundp.precise.bpel_ui.model.EventHandlerUI;
import be.edu.fundp.precise.bpel_ui.model.ModelFactory;
import be.edu.fundp.precise.bpel_ui.model.ModelPackage;
import be.edu.fundp.precise.bpel_ui.model.OnUserEvent;
import be.edu.fundp.precise.bpel_ui.model.PickUI;
import be.edu.fundp.precise.bpel_ui.model.ScopeUI;
import be.edu.fundp.precise.bpel_ui.model.UserEventType;
import be.edu.fundp.precise.bpel_ui.model.UserInteraction;
import be.edu.fundp.precise.bpel_ui.model.UserRole;
import be.edu.fundp.precise.bpel_ui.model.util.BPEL_UI_Constants;
import be.edu.fundp.precise.bpel_ui.model.util.BPEL_UI_Deserializer;
import be.edu.fundp.precise.bpel_ui.model.util.BPEL_UI_Serializer;

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
	private EClass bpeL_UI_EntityEClass = null;

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
	private EClass dataInputUIEClass = null;

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
	private EClass dataSelectionUIEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pickUIEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventHandlerUIEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopeUIEClass = null;

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
	private EClass onUserEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum userEventTypeEEnum = null;

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
	 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#eNS_URI
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
	 * @generated
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

		registerSerializeAndDeserialize();
  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}

	private static void registerSerializeAndDeserialize() {
		// Initialize BPEL extension registry
		BPELExtensionRegistry extensionRegistry = BPELExtensionRegistry.getInstance();

		// Initialize our own serializers and deserializers
		BPEL_UI_Deserializer deserializer = new BPEL_UI_Deserializer();
		BPEL_UI_Serializer serializer = new BPEL_UI_Serializer();

		// PickUI
		String name = PickUI.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				BPEL_UI_Constants.ND_PICK_UI), deserializer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				serializer);
		
		// ScopeUI
		name = ScopeUI.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				BPEL_UI_Constants.ND_SCOPE_UI), deserializer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				serializer);
		
		// EventHandlerUI
		name = EventHandlerUI.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				BPEL_UI_Constants.ND_EVENT_UI_HANDLER), deserializer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				serializer);
		
		// OnUserEvent
		name = OnUserEvent.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				BPEL_UI_Constants.ND_ON_USER_EVENT), deserializer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				serializer);
		
		// DataInputUI
		name = DataInputUI.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				BPEL_UI_Constants.ND_DATA_INPUT_UI), deserializer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				serializer);
		
		// DataOutputUI
		name = DataOutputUI.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				BPEL_UI_Constants.ND_DATA_OUTPUT_UI), deserializer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				serializer);
		
		// DataSelectionUI
		name = DataSelectionUI.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				BPEL_UI_Constants.ND_DATA_SELECTION_UI), deserializer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				serializer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBPEL_UI_Entity() {
		return bpeL_UI_EntityEClass;
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
	public EReference getUserInteraction_Role() {
		return (EReference)userInteractionEClass.getEStructuralFeatures().get(0);
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
	public EReference getDataInputUI_InputVariable() {
		return (EReference)dataInputUIEClass.getEStructuralFeatures().get(0);
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
	public EClass getPickUI() {
		return pickUIEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPickUI_UserInteraction() {
		return (EReference)pickUIEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventHandlerUI() {
		return eventHandlerUIEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventHandlerUI_UserInteraction() {
		return (EReference)eventHandlerUIEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopeUI() {
		return scopeUIEClass;
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
	public EAttribute getUserRole_Id() {
		return (EAttribute)userRoleEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getOnUserEvent_Id() {
		return (EAttribute)onUserEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOnUserEvent_Type() {
		return (EAttribute)onUserEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnUserEvent_Variable() {
		return (EReference)onUserEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnUserEvent_Activity() {
		return (EReference)onUserEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUserEventType() {
		return userEventTypeEEnum;
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
		bpeL_UI_EntityEClass = createEClass(BPEL_UI_ENTITY);

		userInteractionEClass = createEClass(USER_INTERACTION);
		createEReference(userInteractionEClass, USER_INTERACTION__ROLE);

		dataInputUIEClass = createEClass(DATA_INPUT_UI);
		createEReference(dataInputUIEClass, DATA_INPUT_UI__INPUT_VARIABLE);

		dataOutputUIEClass = createEClass(DATA_OUTPUT_UI);
		createEReference(dataOutputUIEClass, DATA_OUTPUT_UI__OUTPUT_VARIABLE);

		dataSelectionUIEClass = createEClass(DATA_SELECTION_UI);
		createEAttribute(dataSelectionUIEClass, DATA_SELECTION_UI__MIN_CARDINALITY);
		createEAttribute(dataSelectionUIEClass, DATA_SELECTION_UI__MAX_CARDINALITY);

		pickUIEClass = createEClass(PICK_UI);
		createEReference(pickUIEClass, PICK_UI__USER_INTERACTION);

		eventHandlerUIEClass = createEClass(EVENT_HANDLER_UI);
		createEReference(eventHandlerUIEClass, EVENT_HANDLER_UI__USER_INTERACTION);

		scopeUIEClass = createEClass(SCOPE_UI);

		userRoleEClass = createEClass(USER_ROLE);
		createEAttribute(userRoleEClass, USER_ROLE__ID);

		onUserEventEClass = createEClass(ON_USER_EVENT);
		createEAttribute(onUserEventEClass, ON_USER_EVENT__ID);
		createEAttribute(onUserEventEClass, ON_USER_EVENT__TYPE);
		createEReference(onUserEventEClass, ON_USER_EVENT__VARIABLE);
		createEReference(onUserEventEClass, ON_USER_EVENT__ACTIVITY);

		// Create enums
		userEventTypeEEnum = createEEnum(USER_EVENT_TYPE);
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
		bpeL_UI_EntityEClass.getESuperTypes().add(theBPELPackage.getExtensibleElement());
		userInteractionEClass.getESuperTypes().add(theBPELPackage.getActivity());
		userInteractionEClass.getESuperTypes().add(this.getBPEL_UI_Entity());
		dataInputUIEClass.getESuperTypes().add(this.getUserInteraction());
		dataOutputUIEClass.getESuperTypes().add(this.getUserInteraction());
		dataSelectionUIEClass.getESuperTypes().add(this.getDataInputUI());
		dataSelectionUIEClass.getESuperTypes().add(this.getDataOutputUI());
		pickUIEClass.getESuperTypes().add(theBPELPackage.getPick());
		pickUIEClass.getESuperTypes().add(this.getBPEL_UI_Entity());
		eventHandlerUIEClass.getESuperTypes().add(theBPELPackage.getEventHandler());
		eventHandlerUIEClass.getESuperTypes().add(this.getBPEL_UI_Entity());
		scopeUIEClass.getESuperTypes().add(theBPELPackage.getScope());
		scopeUIEClass.getESuperTypes().add(this.getBPEL_UI_Entity());
		userRoleEClass.getESuperTypes().add(this.getBPEL_UI_Entity());
		onUserEventEClass.getESuperTypes().add(this.getBPEL_UI_Entity());

		// Initialize classes and features; add operations and parameters
		initEClass(bpeL_UI_EntityEClass, BPEL_UI_Entity.class, "BPEL_UI_Entity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(userInteractionEClass, UserInteraction.class, "UserInteraction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserInteraction_Role(), this.getUserRole(), null, "role", null, 1, -1, UserInteraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataInputUIEClass, DataInputUI.class, "DataInputUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataInputUI_InputVariable(), theBPELPackage.getVariable(), null, "inputVariable", null, 1, 1, DataInputUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataOutputUIEClass, DataOutputUI.class, "DataOutputUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataOutputUI_OutputVariable(), theBPELPackage.getVariable(), null, "outputVariable", null, 1, 1, DataOutputUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataSelectionUIEClass, DataSelectionUI.class, "DataSelectionUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataSelectionUI_MinCardinality(), ecorePackage.getEInt(), "minCardinality", null, 0, 1, DataSelectionUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataSelectionUI_MaxCardinality(), ecorePackage.getEInt(), "maxCardinality", null, 0, 1, DataSelectionUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pickUIEClass, PickUI.class, "PickUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPickUI_UserInteraction(), this.getOnUserEvent(), null, "userInteraction", null, 0, -1, PickUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventHandlerUIEClass, EventHandlerUI.class, "EventHandlerUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventHandlerUI_UserInteraction(), this.getOnUserEvent(), null, "userInteraction", null, 0, -1, EventHandlerUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scopeUIEClass, ScopeUI.class, "ScopeUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(userRoleEClass, UserRole.class, "UserRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUserRole_Id(), ecorePackage.getEString(), "id", null, 1, 1, UserRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(onUserEventEClass, OnUserEvent.class, "OnUserEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOnUserEvent_Id(), ecorePackage.getEString(), "id", null, 1, 1, OnUserEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOnUserEvent_Type(), this.getUserEventType(), "type", null, 0, 1, OnUserEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOnUserEvent_Variable(), theBPELPackage.getVariable(), null, "variable", null, 0, 1, OnUserEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOnUserEvent_Activity(), theBPELPackage.getActivity(), null, "activity", null, 0, 1, OnUserEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(userEventTypeEEnum, UserEventType.class, "UserEventType");
		addEEnumLiteral(userEventTypeEEnum, UserEventType.ON_DATA_INPUT);
		addEEnumLiteral(userEventTypeEEnum, UserEventType.ON_DATA_SELECTION);
		addEEnumLiteral(userEventTypeEEnum, UserEventType.ON_DATA_OUTPUT);
		addEEnumLiteral(userEventTypeEEnum, UserEventType.ON_ERRONEOUS_INTERACTION);
		addEEnumLiteral(userEventTypeEEnum, UserEventType.ON_IMPLICITE_INTERACTION);

		// Create resource
		createResource(eNS_URI);
	}

} //ModelPackageImpl
