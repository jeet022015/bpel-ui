/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.bpel_ui.model.impl;

import be.edu.fundp.bpel_ui.model.ModelPackage;
import be.edu.fundp.bpel_ui.model.NewEventHandler;
import be.edu.fundp.bpel_ui.model.OnUserEvent;

import java.util.Collection;

import org.eclipse.bpel.model.impl.EventHandlerImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Event Handler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.bpel_ui.model.impl.NewEventHandlerImpl#getUserInteracion <em>User Interacion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewEventHandlerImpl extends EventHandlerImpl implements NewEventHandler {
	/**
	 * The cached value of the '{@link #getUserInteracion() <em>User Interacion</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserInteracion()
	 * @generated
	 * @ordered
	 */
	protected EList<OnUserEvent> userInteracion;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewEventHandlerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.NEW_EVENT_HANDLER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OnUserEvent> getUserInteracion() {
		if (userInteracion == null) {
			userInteracion = new EObjectResolvingEList<OnUserEvent>(OnUserEvent.class, this, ModelPackage.NEW_EVENT_HANDLER__USER_INTERACION);
		}
		return userInteracion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.NEW_EVENT_HANDLER__USER_INTERACION:
				return getUserInteracion();
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
			case ModelPackage.NEW_EVENT_HANDLER__USER_INTERACION:
				getUserInteracion().clear();
				getUserInteracion().addAll((Collection<? extends OnUserEvent>)newValue);
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
			case ModelPackage.NEW_EVENT_HANDLER__USER_INTERACION:
				getUserInteracion().clear();
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
			case ModelPackage.NEW_EVENT_HANDLER__USER_INTERACION:
				return userInteracion != null && !userInteracion.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NewEventHandlerImpl
