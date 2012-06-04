/**
� * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model.impl;

import java.util.Collection;

import org.eclipse.bpel.model.impl.BPELExtensibleElementImpl;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.UserInteraction;
import be.edu.fundp.precise.uibpel.model.UserRole;
import be.edu.fundp.precise.uibpel.model.util.BpelUiConstants;
import be.edu.fundp.precise.uibpel.model.util.BpelUiReconciliationHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl#getId <em>Id</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl#getUserRoles <em>User Roles</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl#isCreateInstance <em>Create Instance</em>}</li>
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
	 * The cached value of the '{@link #getUserRoles() <em>User Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<UserRole> userRoles;

	/**
	 * The default value of the '{@link #isCreateInstance() <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCreateInstance()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CREATE_INSTANCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCreateInstance() <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCreateInstance()
	 * @generated
	 * @ordered
	 */
	protected boolean createInstance = CREATE_INSTANCE_EDEFAULT;

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
			userRoles = new EObjectContainmentEList<UserRole>(UserRole.class, this, ModelPackage.USER_INTERACTION__USER_ROLES);
		}
		return userRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCreateInstance() {
		return createInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateInstance(boolean newCreateInstance) {
		boolean oldCreateInstance = createInstance;
		createInstance = newCreateInstance;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, ModelPackage.eINSTANCE
					.getUserInteraction_CreateInstance().getName(),String.valueOf(newCreateInstance));
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.USER_INTERACTION__CREATE_INSTANCE, oldCreateInstance, createInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.USER_INTERACTION__USER_ROLES:
				return ((InternalEList<?>)getUserRoles()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.USER_INTERACTION__ID:
				return getId();
			case ModelPackage.USER_INTERACTION__USER_ROLES:
				return getUserRoles();
			case ModelPackage.USER_INTERACTION__CREATE_INSTANCE:
				return isCreateInstance();
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
			case ModelPackage.USER_INTERACTION__CREATE_INSTANCE:
				setCreateInstance((Boolean)newValue);
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
			case ModelPackage.USER_INTERACTION__CREATE_INSTANCE:
				setCreateInstance(CREATE_INSTANCE_EDEFAULT);
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
			case ModelPackage.USER_INTERACTION__CREATE_INSTANCE:
				return createInstance != CREATE_INSTANCE_EDEFAULT;
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
		result.append(", createInstance: ");
		result.append(createInstance);
		result.append(')');
		return result.toString();
	}
	
	@Override
	protected void adoptContent(EReference reference, Object object) {
		if (object instanceof UserRole) {
			BpelUiReconciliationHelper.adoptChild(this, userRoles, (UserRole) object,
					BpelUiConstants.ND_USER_ROLE);
		}
		super.adoptContent(reference, object);

	}
	
	@Override
	protected void orphanContent(EReference reference, Object obj) {
		if (obj instanceof UserRole) {
			BpelUiReconciliationHelper.orphanChild(this, (UserRole)obj);
		}
		super.orphanContent(reference, obj);
	}
} //UserInteractionImpl
