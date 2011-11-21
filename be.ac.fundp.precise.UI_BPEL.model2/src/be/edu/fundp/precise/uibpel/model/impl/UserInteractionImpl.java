/**
Î * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model.impl;

import java.util.Collection;

import org.eclipse.bpel.model.impl.BPELExtensibleElementImpl;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.UserInteraction;
import be.edu.fundp.precise.uibpel.model.UserRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl#getId <em>Id</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl#getUserRoles <em>User Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UserInteractionImpl extends BPELExtensibleElementImpl implements UserInteraction {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUserRoles() <em>User Roles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<UserRole> userRoles;

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
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, ModelPackage.eINSTANCE
					.getUserInteraction_Id().getName(),newId);
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.USER_INTERACTION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UserRole> getUserRoles() {
		if (userRoles == null) {
			userRoles = new EObjectResolvingEList<UserRole>(UserRole.class, this, ModelPackage.USER_INTERACTION__USER_ROLES);
		}
		return userRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.USER_INTERACTION__ID:
				return getId();
			case ModelPackage.USER_INTERACTION__USER_ROLES:
				return getUserRoles();
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
			case ModelPackage.USER_INTERACTION__ID:
				setId((String)newValue);
				return;
			case ModelPackage.USER_INTERACTION__USER_ROLES:
				getUserRoles().clear();
				getUserRoles().addAll((Collection<? extends UserRole>)newValue);
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
			case ModelPackage.USER_INTERACTION__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.USER_INTERACTION__USER_ROLES:
				getUserRoles().clear();
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
			case ModelPackage.USER_INTERACTION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ModelPackage.USER_INTERACTION__USER_ROLES:
				return userRoles != null && !userRoles.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}
	
	//FIXME ADD ROLES
} //UserInteractionImpl
