/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.bpel_ui.model.util;

import be.edu.fundp.bpel_ui.model.*;

import javax.wsdl.extensions.AttributeExtensible;
import javax.wsdl.extensions.ElementExtensible;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Scope;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.wst.wsdl.ExtensibleElement;
import org.eclipse.wst.wsdl.WSDLElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see be.edu.fundp.bpel_ui.model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSwitch<Adapter> modelSwitch =
		new ModelSwitch<Adapter>() {
			@Override
			public Adapter caseUserInteraction(UserInteraction object) {
				return createUserInteractionAdapter();
			}
			@Override
			public Adapter caseUserRole(UserRole object) {
				return createUserRoleAdapter();
			}
			@Override
			public Adapter caseDataOutputUI(DataOutputUI object) {
				return createDataOutputUIAdapter();
			}
			@Override
			public Adapter caseDataInputUI(DataInputUI object) {
				return createDataInputUIAdapter();
			}
			@Override
			public Adapter caseDataSelectionUI(DataSelectionUI object) {
				return createDataSelectionUIAdapter();
			}
			@Override
			public Adapter caseDecisionUI(DecisionUI object) {
				return createDecisionUIAdapter();
			}
			@Override
			public Adapter caseChoice(Choice object) {
				return createChoiceAdapter();
			}
			@Override
			public Adapter caseOnUserEvent(OnUserEvent object) {
				return createOnUserEventAdapter();
			}
			@Override
			public Adapter caseNewPick(NewPick object) {
				return createNewPickAdapter();
			}
			@Override
			public Adapter caseNewScope(NewScope object) {
				return createNewScopeAdapter();
			}
			@Override
			public Adapter caseNewEventHandler(NewEventHandler object) {
				return createNewEventHandlerAdapter();
			}
			@Override
			public Adapter caseWSDLElement(WSDLElement object) {
				return createWSDLElementAdapter();
			}
			@Override
			public Adapter caseIElementExtensible(ElementExtensible object) {
				return createIElementExtensibleAdapter();
			}
			@Override
			public Adapter caseIAttributeExtensible(AttributeExtensible object) {
				return createIAttributeExtensibleAdapter();
			}
			@Override
			public Adapter caseExtensibleElement(ExtensibleElement object) {
				return createExtensibleElementAdapter();
			}
			@Override
			public Adapter caseBPEL_ExtensibleElement(org.eclipse.bpel.model.ExtensibleElement object) {
				return createBPEL_ExtensibleElementAdapter();
			}
			@Override
			public Adapter caseActivity(Activity object) {
				return createActivityAdapter();
			}
			@Override
			public Adapter caseExtensionActivity(ExtensionActivity object) {
				return createExtensionActivityAdapter();
			}
			@Override
			public Adapter casePick(Pick object) {
				return createPickAdapter();
			}
			@Override
			public Adapter caseScope(Scope object) {
				return createScopeAdapter();
			}
			@Override
			public Adapter caseEventHandler(EventHandler object) {
				return createEventHandlerAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link be.edu.fundp.bpel_ui.model.UserInteraction <em>User Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.edu.fundp.bpel_ui.model.UserInteraction
	 * @generated
	 */
	public Adapter createUserInteractionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.edu.fundp.bpel_ui.model.UserRole <em>User Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.edu.fundp.bpel_ui.model.UserRole
	 * @generated
	 */
	public Adapter createUserRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.edu.fundp.bpel_ui.model.DataOutputUI <em>Data Output UI</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.edu.fundp.bpel_ui.model.DataOutputUI
	 * @generated
	 */
	public Adapter createDataOutputUIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.edu.fundp.bpel_ui.model.DataInputUI <em>Data Input UI</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.edu.fundp.bpel_ui.model.DataInputUI
	 * @generated
	 */
	public Adapter createDataInputUIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.edu.fundp.bpel_ui.model.DataSelectionUI <em>Data Selection UI</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.edu.fundp.bpel_ui.model.DataSelectionUI
	 * @generated
	 */
	public Adapter createDataSelectionUIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.edu.fundp.bpel_ui.model.DecisionUI <em>Decision UI</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.edu.fundp.bpel_ui.model.DecisionUI
	 * @generated
	 */
	public Adapter createDecisionUIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.edu.fundp.bpel_ui.model.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.edu.fundp.bpel_ui.model.Choice
	 * @generated
	 */
	public Adapter createChoiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.edu.fundp.bpel_ui.model.OnUserEvent <em>On User Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.edu.fundp.bpel_ui.model.OnUserEvent
	 * @generated
	 */
	public Adapter createOnUserEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.edu.fundp.bpel_ui.model.NewPick <em>New Pick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.edu.fundp.bpel_ui.model.NewPick
	 * @generated
	 */
	public Adapter createNewPickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.edu.fundp.bpel_ui.model.NewScope <em>New Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.edu.fundp.bpel_ui.model.NewScope
	 * @generated
	 */
	public Adapter createNewScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.edu.fundp.bpel_ui.model.NewEventHandler <em>New Event Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.edu.fundp.bpel_ui.model.NewEventHandler
	 * @generated
	 */
	public Adapter createNewEventHandlerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.wst.wsdl.WSDLElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.wst.wsdl.WSDLElement
	 * @generated
	 */
	public Adapter createWSDLElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.wsdl.extensions.ElementExtensible <em>IElement Extensible</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.wsdl.extensions.ElementExtensible
	 * @generated
	 */
	public Adapter createIElementExtensibleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.wsdl.extensions.AttributeExtensible <em>IAttribute Extensible</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.wsdl.extensions.AttributeExtensible
	 * @generated
	 */
	public Adapter createIAttributeExtensibleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.wst.wsdl.ExtensibleElement <em>Extensible Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.wst.wsdl.ExtensibleElement
	 * @generated
	 */
	public Adapter createExtensibleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.ExtensibleElement <em>Extensible Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.ExtensibleElement
	 * @generated
	 */
	public Adapter createBPEL_ExtensibleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Activity
	 * @generated
	 */
	public Adapter createActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.ExtensionActivity <em>Extension Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.ExtensionActivity
	 * @generated
	 */
	public Adapter createExtensionActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Pick <em>Pick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Pick
	 * @generated
	 */
	public Adapter createPickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Scope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Scope
	 * @generated
	 */
	public Adapter createScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.EventHandler <em>Event Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.EventHandler
	 * @generated
	 */
	public Adapter createEventHandlerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ModelAdapterFactory
