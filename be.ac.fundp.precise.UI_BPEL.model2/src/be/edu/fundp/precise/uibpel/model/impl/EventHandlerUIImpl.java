/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model.impl;

import java.util.Collection;

import org.eclipse.bpel.model.impl.EventHandlerImpl;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.util.BpelUiConstants;
import be.edu.fundp.precise.uibpel.model.util.BpelUiReconciliationHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Handler UI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.EventHandlerUIImpl#getUserInteraction <em>User Interaction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventHandlerUIImpl extends EventHandlerImpl implements EventHandlerUI {
	/**
	 * The cached value of the '{@link #getUserInteraction() <em>User Interaction</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserInteraction()
	 * @generated
	 * @ordered
	 */
	protected EList<OnUserEvent> userInteraction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventHandlerUIImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.EVENT_HANDLER_UI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OnUserEvent> getUserInteraction() {
		if (userInteraction == null) {
			userInteraction = new EObjectContainmentEList<OnUserEvent>(OnUserEvent.class, this, ModelPackage.EVENT_HANDLER_UI__USER_INTERACTION);
		}
		return userInteraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.EVENT_HANDLER_UI__USER_INTERACTION:
				return ((InternalEList<?>)getUserInteraction()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.EVENT_HANDLER_UI__USER_INTERACTION:
				return getUserInteraction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.EVENT_HANDLER_UI__USER_INTERACTION:
				getUserInteraction().clear();
				getUserInteraction().addAll((Collection<? extends OnUserEvent>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.EVENT_HANDLER_UI__USER_INTERACTION:
				getUserInteraction().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.EVENT_HANDLER_UI__USER_INTERACTION:
				return userInteraction != null && !userInteraction.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	
	@Override
	protected void adoptContent(EReference reference, Object object) {
		if (object instanceof OnUserEvent) {
			BpelUiReconciliationHelper.adoptChild(this, userInteraction, (OnUserEvent) object,
					BpelUiConstants.ND_ON_USER_EVENT);
		}
		super.adoptContent(reference, object);
	}
	
	@Override
	protected void orphanContent(EReference reference, Object object) {
		if (object instanceof OnUserEvent) {
			ReconciliationHelper.orphanChild(this, (OnUserEvent) object);
		}
		super.orphanContent(reference, object);
	}

} //EventHandlerUIImpl
