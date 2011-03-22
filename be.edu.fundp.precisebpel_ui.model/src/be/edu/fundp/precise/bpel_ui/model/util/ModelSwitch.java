/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.bpel_ui.model.util;

import be.edu.fundp.precise.bpel_ui.model.*;

import java.util.List;

import javax.wsdl.extensions.AttributeExtensible;
import javax.wsdl.extensions.ElementExtensible;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Scope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.wst.wsdl.ExtensibleElement;
import org.eclipse.wst.wsdl.WSDLElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModelPackage.BPEL_UI_ENTITY: {
				BPEL_UI_Entity bpeL_UI_Entity = (BPEL_UI_Entity)theEObject;
				T result = caseBPEL_UI_Entity(bpeL_UI_Entity);
				if (result == null) result = caseBPEL_ExtensibleElement(bpeL_UI_Entity);
				if (result == null) result = caseExtensibleElement(bpeL_UI_Entity);
				if (result == null) result = caseWSDLElement(bpeL_UI_Entity);
				if (result == null) result = caseIElementExtensible(bpeL_UI_Entity);
				if (result == null) result = caseIAttributeExtensible(bpeL_UI_Entity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.USER_INTERACTION: {
				UserInteraction userInteraction = (UserInteraction)theEObject;
				T result = caseUserInteraction(userInteraction);
				if (result == null) result = caseExtensionActivity(userInteraction);
				if (result == null) result = caseBPEL_UI_Entity(userInteraction);
				if (result == null) result = caseActivity(userInteraction);
				if (result == null) result = caseBPEL_ExtensibleElement(userInteraction);
				if (result == null) result = caseExtensibleElement(userInteraction);
				if (result == null) result = caseWSDLElement(userInteraction);
				if (result == null) result = caseIElementExtensible(userInteraction);
				if (result == null) result = caseIAttributeExtensible(userInteraction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DATA_INPUT_UI: {
				DataInputUI dataInputUI = (DataInputUI)theEObject;
				T result = caseDataInputUI(dataInputUI);
				if (result == null) result = caseUserInteraction(dataInputUI);
				if (result == null) result = caseExtensionActivity(dataInputUI);
				if (result == null) result = caseBPEL_UI_Entity(dataInputUI);
				if (result == null) result = caseActivity(dataInputUI);
				if (result == null) result = caseBPEL_ExtensibleElement(dataInputUI);
				if (result == null) result = caseExtensibleElement(dataInputUI);
				if (result == null) result = caseWSDLElement(dataInputUI);
				if (result == null) result = caseIElementExtensible(dataInputUI);
				if (result == null) result = caseIAttributeExtensible(dataInputUI);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DATA_OUTPUT_UI: {
				DataOutputUI dataOutputUI = (DataOutputUI)theEObject;
				T result = caseDataOutputUI(dataOutputUI);
				if (result == null) result = caseUserInteraction(dataOutputUI);
				if (result == null) result = caseExtensionActivity(dataOutputUI);
				if (result == null) result = caseBPEL_UI_Entity(dataOutputUI);
				if (result == null) result = caseActivity(dataOutputUI);
				if (result == null) result = caseBPEL_ExtensibleElement(dataOutputUI);
				if (result == null) result = caseExtensibleElement(dataOutputUI);
				if (result == null) result = caseWSDLElement(dataOutputUI);
				if (result == null) result = caseIElementExtensible(dataOutputUI);
				if (result == null) result = caseIAttributeExtensible(dataOutputUI);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DATA_SELECTION_UI: {
				DataSelectionUI dataSelectionUI = (DataSelectionUI)theEObject;
				T result = caseDataSelectionUI(dataSelectionUI);
				if (result == null) result = caseDataInputUI(dataSelectionUI);
				if (result == null) result = caseDataOutputUI(dataSelectionUI);
				if (result == null) result = caseUserInteraction(dataSelectionUI);
				if (result == null) result = caseExtensionActivity(dataSelectionUI);
				if (result == null) result = caseBPEL_UI_Entity(dataSelectionUI);
				if (result == null) result = caseActivity(dataSelectionUI);
				if (result == null) result = caseBPEL_ExtensibleElement(dataSelectionUI);
				if (result == null) result = caseExtensibleElement(dataSelectionUI);
				if (result == null) result = caseWSDLElement(dataSelectionUI);
				if (result == null) result = caseIElementExtensible(dataSelectionUI);
				if (result == null) result = caseIAttributeExtensible(dataSelectionUI);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PICK_UI: {
				PickUI pickUI = (PickUI)theEObject;
				T result = casePickUI(pickUI);
				if (result == null) result = casePick(pickUI);
				if (result == null) result = caseBPEL_UI_Entity(pickUI);
				if (result == null) result = caseActivity(pickUI);
				if (result == null) result = caseBPEL_ExtensibleElement(pickUI);
				if (result == null) result = caseExtensibleElement(pickUI);
				if (result == null) result = caseWSDLElement(pickUI);
				if (result == null) result = caseIElementExtensible(pickUI);
				if (result == null) result = caseIAttributeExtensible(pickUI);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.EVENT_HANDLER_UI: {
				EventHandlerUI eventHandlerUI = (EventHandlerUI)theEObject;
				T result = caseEventHandlerUI(eventHandlerUI);
				if (result == null) result = caseEventHandler(eventHandlerUI);
				if (result == null) result = caseBPEL_UI_Entity(eventHandlerUI);
				if (result == null) result = caseBPEL_ExtensibleElement(eventHandlerUI);
				if (result == null) result = caseExtensibleElement(eventHandlerUI);
				if (result == null) result = caseWSDLElement(eventHandlerUI);
				if (result == null) result = caseIElementExtensible(eventHandlerUI);
				if (result == null) result = caseIAttributeExtensible(eventHandlerUI);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SCOPE_UI: {
				ScopeUI scopeUI = (ScopeUI)theEObject;
				T result = caseScopeUI(scopeUI);
				if (result == null) result = caseScope(scopeUI);
				if (result == null) result = caseBPEL_UI_Entity(scopeUI);
				if (result == null) result = caseActivity(scopeUI);
				if (result == null) result = caseBPEL_ExtensibleElement(scopeUI);
				if (result == null) result = caseExtensibleElement(scopeUI);
				if (result == null) result = caseWSDLElement(scopeUI);
				if (result == null) result = caseIElementExtensible(scopeUI);
				if (result == null) result = caseIAttributeExtensible(scopeUI);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.USER_ROLE: {
				UserRole userRole = (UserRole)theEObject;
				T result = caseUserRole(userRole);
				if (result == null) result = caseBPEL_UI_Entity(userRole);
				if (result == null) result = caseBPEL_ExtensibleElement(userRole);
				if (result == null) result = caseExtensibleElement(userRole);
				if (result == null) result = caseWSDLElement(userRole);
				if (result == null) result = caseIElementExtensible(userRole);
				if (result == null) result = caseIAttributeExtensible(userRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ON_USER_EVENT: {
				OnUserEvent onUserEvent = (OnUserEvent)theEObject;
				T result = caseOnUserEvent(onUserEvent);
				if (result == null) result = caseBPEL_UI_Entity(onUserEvent);
				if (result == null) result = caseBPEL_ExtensibleElement(onUserEvent);
				if (result == null) result = caseExtensibleElement(onUserEvent);
				if (result == null) result = caseWSDLElement(onUserEvent);
				if (result == null) result = caseIElementExtensible(onUserEvent);
				if (result == null) result = caseIAttributeExtensible(onUserEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPEL UI Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPEL UI Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPEL_UI_Entity(BPEL_UI_Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Interaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Interaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserInteraction(UserInteraction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Input UI</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Input UI</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataInputUI(DataInputUI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Output UI</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Output UI</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataOutputUI(DataOutputUI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Selection UI</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Selection UI</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSelectionUI(DataSelectionUI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pick UI</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pick UI</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePickUI(PickUI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Handler UI</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Handler UI</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventHandlerUI(EventHandlerUI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scope UI</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scope UI</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopeUI(ScopeUI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserRole(UserRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>On User Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>On User Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOnUserEvent(OnUserEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSDLElement(WSDLElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IElement Extensible</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IElement Extensible</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIElementExtensible(ElementExtensible object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAttribute Extensible</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAttribute Extensible</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAttributeExtensible(AttributeExtensible object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensibleElement(ExtensibleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPEL_ExtensibleElement(org.eclipse.bpel.model.ExtensibleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivity(Activity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionActivity(ExtensionActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pick</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pick</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePick(Pick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Handler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Handler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventHandler(EventHandler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScope(Scope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ModelSwitch
