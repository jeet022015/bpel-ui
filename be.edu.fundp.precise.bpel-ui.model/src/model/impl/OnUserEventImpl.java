/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.impl;

import model.EventType;
import model.ModelPackage;
import model.OnUserEvent;
import model.UserRole;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Variable;

import org.eclipse.bpel.model.impl.ExtensibleElementImpl;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>On User Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.OnUserEventImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link model.impl.OnUserEventImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link model.impl.OnUserEventImpl#getUserRole <em>User Role</em>}</li>
 *   <li>{@link model.impl.OnUserEventImpl#getType <em>Type</em>}</li>
 *   <li>{@link model.impl.OnUserEventImpl#getID <em>ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OnUserEventImpl extends ExtensibleElementImpl implements OnUserEvent {
	/**
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected Activity activity;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable variable;

	/**
	 * The cached value of the '{@link #getUserRole() <em>User Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserRole()
	 * @generated
	 * @ordered
	 */
	protected UserRole userRole;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final EventType TYPE_EDEFAULT = EventType.ON_DATA_INPUT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EventType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OnUserEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ON_USER_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getActivity() {
		if (activity != null && activity.eIsProxy()) {
			InternalEObject oldActivity = (InternalEObject)activity;
			activity = (Activity)eResolveProxy(oldActivity);
			if (activity != oldActivity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ON_USER_EVENT__ACTIVITY, oldActivity, activity));
			}
		}
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity basicGetActivity() {
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setActivity(Activity newActivity) {
		if (newActivity != activity) {
			NotificationChain msgs = null;
			if (activity != null)
				msgs = ((InternalEObject) activity)
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
								- ModelPackage.ON_USER_EVENT__ACTIVITY, null, msgs);
			if (newActivity != null)
				msgs = ((InternalEObject) newActivity)
						.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
								- ModelPackage.ON_USER_EVENT__ACTIVITY, null, msgs);
			msgs = basicSetActivity(newActivity, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ON_USER_EVENT__ACTIVITY, newActivity, newActivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	private NotificationChain basicSetActivity(Activity newActivity,
			NotificationChain msgs) {
		Activity oldActivity = activity;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldActivity, newActivity);
		}
		activity = newActivity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, ModelPackage.ON_USER_EVENT__ACTIVITY,
					oldActivity, newActivity);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (Variable)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ON_USER_EVENT__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setVariable(Variable newVariable) {
		if (newVariable != variable) {
			NotificationChain msgs = null;
			if (variable != null)
				msgs = ((InternalEObject) variable)
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
								- ModelPackage.ON_USER_EVENT__VARIABLE, null, msgs);
			if (newVariable != null)
				msgs = ((InternalEObject) newVariable)
						.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
								- ModelPackage.ON_USER_EVENT__VARIABLE, null, msgs);
			msgs = basicSetVariable(newVariable, msgs);
			if (msgs != null)
				msgs.dispatch();
		} if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ON_USER_EVENT__VARIABLE, newVariable, newVariable));
	}

	private NotificationChain basicSetVariable(Variable newVariable,
			NotificationChain msgs) {
		Variable oldVariable = variable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					//TODO create a Constant
					"variable",
					newVariable == null ? null : newVariable.getName());
		}
		variable = newVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, ModelPackage.ON_USER_EVENT__VARIABLE,
					oldVariable, newVariable);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserRole getUserRole() {
		if (userRole != null && userRole.eIsProxy()) {
			InternalEObject oldUserRole = (InternalEObject)userRole;
			userRole = (UserRole)eResolveProxy(oldUserRole);
			if (userRole != oldUserRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ON_USER_EVENT__USER_ROLE, oldUserRole, userRole));
			}
		}
		return userRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserRole basicGetUserRole() {
		return userRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserRole(UserRole newUserRole) {
		UserRole oldUserRole = userRole;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldUserRole, newUserRole);
		}
		userRole = newUserRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ON_USER_EVENT__USER_ROLE, oldUserRole, userRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EventType newType) {
		EventType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, ModelPackage.eINSTANCE
					.getOnUserEvent_Type().getName(),
					Integer.toString(newType.getValue()));
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ON_USER_EVENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getID() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setID(String newID) {
		String oldID = id;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, ModelPackage.eINSTANCE
					.getOnUserEvent_ID().getName(),
					newID);
		}
		id = newID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ON_USER_EVENT__ID, oldID, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ON_USER_EVENT__ACTIVITY:
				if (resolve) return getActivity();
				return basicGetActivity();
			case ModelPackage.ON_USER_EVENT__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case ModelPackage.ON_USER_EVENT__USER_ROLE:
				if (resolve) return getUserRole();
				return basicGetUserRole();
			case ModelPackage.ON_USER_EVENT__TYPE:
				return getType();
			case ModelPackage.ON_USER_EVENT__ID:
				return getID();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.ON_USER_EVENT__ACTIVITY:
				setActivity((Activity)newValue);
				return;
			case ModelPackage.ON_USER_EVENT__VARIABLE:
				setVariable((Variable)newValue);
				return;
			case ModelPackage.ON_USER_EVENT__USER_ROLE:
				setUserRole((UserRole)newValue);
				return;
			case ModelPackage.ON_USER_EVENT__TYPE:
				setType((EventType)newValue);
				return;
			case ModelPackage.ON_USER_EVENT__ID:
				setID((String)newValue);
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
			case ModelPackage.ON_USER_EVENT__ACTIVITY:
				setActivity((Activity)null);
				return;
			case ModelPackage.ON_USER_EVENT__VARIABLE:
				setVariable((Variable)null);
				return;
			case ModelPackage.ON_USER_EVENT__USER_ROLE:
				setUserRole((UserRole)null);
				return;
			case ModelPackage.ON_USER_EVENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelPackage.ON_USER_EVENT__ID:
				setID(ID_EDEFAULT);
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
			case ModelPackage.ON_USER_EVENT__ACTIVITY:
				return activity != null;
			case ModelPackage.ON_USER_EVENT__VARIABLE:
				return variable != null;
			case ModelPackage.ON_USER_EVENT__USER_ROLE:
				return userRole != null;
			case ModelPackage.ON_USER_EVENT__TYPE:
				return type != TYPE_EDEFAULT;
			case ModelPackage.ON_USER_EVENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (type: ");
		result.append(type);
		result.append(", ID: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //OnUserEventImpl
