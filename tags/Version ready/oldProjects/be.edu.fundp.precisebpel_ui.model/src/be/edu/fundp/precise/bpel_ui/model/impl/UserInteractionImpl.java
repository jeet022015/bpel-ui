/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.bpel_ui.model.impl;

import be.edu.fundp.precise.bpel_ui.model.ModelPackage;
import be.edu.fundp.precise.bpel_ui.model.OnUserEvent;
import be.edu.fundp.precise.bpel_ui.model.UserInteraction;
import be.edu.fundp.precise.bpel_ui.model.UserRole;
import be.edu.fundp.precise.bpel_ui.model.util.BPEL_UI_Constants;

import java.util.Collection;

import org.eclipse.bpel.model.impl.ExtensionActivityImpl;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.impl.UserInteractionImpl#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UserInteractionImpl extends ExtensionActivityImpl implements UserInteraction {
	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected EList<UserRole> role;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserInteractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.USER_INTERACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UserRole> getRole() {
		if (role == null) {
			role = new EObjectContainmentEList<UserRole>(UserRole.class, this, ModelPackage.USER_INTERACTION__ROLE);
		}
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.USER_INTERACTION__ROLE:
				return ((InternalEList<?>)getRole()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.USER_INTERACTION__ROLE:
				return getRole();
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
			case ModelPackage.USER_INTERACTION__ROLE:
				getRole().clear();
				getRole().addAll((Collection<? extends UserRole>)newValue);
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
			case ModelPackage.USER_INTERACTION__ROLE:
				getRole().clear();
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
			case ModelPackage.USER_INTERACTION__ROLE:
				return role != null && !role.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	protected void adoptContent(EReference reference, Object object) {
		if (object instanceof UserRole) {
			ReconciliationHelper.adoptChild(this, role, (UserRole) object,
					BPEL_UI_Constants.ND_ROLE);
		}
		super.adoptContent(reference, object);
	}

	@Override
	protected void orphanContent(EReference reference, Object object) {
		if (object instanceof UserRole) {
			ReconciliationHelper.orphanChild(this, (UserRole) object);
		}
		super.orphanContent(reference, object);
	}

} //UserInteractionImpl
