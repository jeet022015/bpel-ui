/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.impl;

import java.util.Collection;

import model.ModelPackage;
import model.NewPick;
import model.OnUserEvent;
import model.util.BPEL_UI_Constants;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.Pick;

import org.eclipse.bpel.model.impl.ExtensionActivityImpl;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Pick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.NewPickImpl#getCreateInstance <em>Create Instance</em>}</li>
 *   <li>{@link model.impl.NewPickImpl#getMessages <em>Messages</em>}</li>
 *   <li>{@link model.impl.NewPickImpl#getAlarm <em>Alarm</em>}</li>
 *   <li>{@link model.impl.NewPickImpl#getUserInteracion <em>User Interacion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewPickImpl extends ExtensionActivityImpl implements NewPick {
	/**
	 * The default value of the '{@link #getCreateInstance() <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateInstance()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean CREATE_INSTANCE_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getCreateInstance() <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateInstance()
	 * @generated
	 * @ordered
	 */
	protected Boolean createInstance = CREATE_INSTANCE_EDEFAULT;

	/**
	 * This is true if the Create Instance attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean createInstanceESet;

	/**
	 * The cached value of the '{@link #getMessages() <em>Messages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<OnMessage> messages;

	/**
	 * The cached value of the '{@link #getAlarm() <em>Alarm</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlarm()
	 * @generated
	 * @ordered
	 */
	protected EList<OnAlarm> alarm;

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
	protected NewPickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.NEW_PICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getCreateInstance() {
		return createInstance;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setCreateInstance(Boolean newCreateInstance) {
		Boolean oldCreateInstance = createInstance;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_CREATE_INSTANCE, BPELUtils
							.boolean2XML(newCreateInstance));
		}
		createInstance = newCreateInstance;
		boolean oldCreateInstanceESet = createInstanceESet;
		createInstanceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.NEW_PICK__CREATE_INSTANCE, oldCreateInstance,
					createInstance, !oldCreateInstanceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreateInstance() {
		Boolean oldCreateInstance = createInstance;
		boolean oldCreateInstanceESet = createInstanceESet;
		createInstance = CREATE_INSTANCE_EDEFAULT;
		createInstanceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.NEW_PICK__CREATE_INSTANCE, oldCreateInstance, CREATE_INSTANCE_EDEFAULT, oldCreateInstanceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreateInstance() {
		return createInstanceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OnMessage> getMessages() {
		if (messages == null) {
			messages = new EObjectContainmentEList<OnMessage>(OnMessage.class, this, ModelPackage.NEW_PICK__MESSAGES);
		}
		return messages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OnAlarm> getAlarm() {
		if (alarm == null) {
			alarm = new EObjectContainmentEList<OnAlarm>(OnAlarm.class, this, ModelPackage.NEW_PICK__ALARM);
		}
		return alarm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OnUserEvent> getUserInteracion() {
		if (userInteracion == null) {
			userInteracion = new EObjectResolvingEList<OnUserEvent>(OnUserEvent.class, this, ModelPackage.NEW_PICK__USER_INTERACION);
		}
		return userInteracion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.NEW_PICK__MESSAGES:
				return ((InternalEList<?>)getMessages()).basicRemove(otherEnd, msgs);
			case ModelPackage.NEW_PICK__ALARM:
				return ((InternalEList<?>)getAlarm()).basicRemove(otherEnd, msgs);
			case ModelPackage.NEW_PICK__USER_INTERACION:
				return ((InternalEList<?>)getUserInteracion()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.NEW_PICK__CREATE_INSTANCE:
				return getCreateInstance();
			case ModelPackage.NEW_PICK__MESSAGES:
				return getMessages();
			case ModelPackage.NEW_PICK__ALARM:
				return getAlarm();
			case ModelPackage.NEW_PICK__USER_INTERACION:
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
			case ModelPackage.NEW_PICK__CREATE_INSTANCE:
				setCreateInstance((Boolean)newValue);
				return;
			case ModelPackage.NEW_PICK__MESSAGES:
				getMessages().clear();
				getMessages().addAll((Collection<? extends OnMessage>)newValue);
				return;
			case ModelPackage.NEW_PICK__ALARM:
				getAlarm().clear();
				getAlarm().addAll((Collection<? extends OnAlarm>)newValue);
				return;
			case ModelPackage.NEW_PICK__USER_INTERACION:
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
			case ModelPackage.NEW_PICK__CREATE_INSTANCE:
				unsetCreateInstance();
				return;
			case ModelPackage.NEW_PICK__MESSAGES:
				getMessages().clear();
				return;
			case ModelPackage.NEW_PICK__ALARM:
				getAlarm().clear();
				return;
			case ModelPackage.NEW_PICK__USER_INTERACION:
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
			case ModelPackage.NEW_PICK__CREATE_INSTANCE:
				return isSetCreateInstance();
			case ModelPackage.NEW_PICK__MESSAGES:
				return messages != null && !messages.isEmpty();
			case ModelPackage.NEW_PICK__ALARM:
				return alarm != null && !alarm.isEmpty();
			case ModelPackage.NEW_PICK__USER_INTERACION:
				return userInteracion != null && !userInteracion.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Pick.class) {
			switch (derivedFeatureID) {
				case ModelPackage.NEW_PICK__CREATE_INSTANCE: return BPELPackage.PICK__CREATE_INSTANCE;
				case ModelPackage.NEW_PICK__MESSAGES: return BPELPackage.PICK__MESSAGES;
				case ModelPackage.NEW_PICK__ALARM: return BPELPackage.PICK__ALARM;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Pick.class) {
			switch (baseFeatureID) {
				case BPELPackage.PICK__CREATE_INSTANCE: return ModelPackage.NEW_PICK__CREATE_INSTANCE;
				case BPELPackage.PICK__MESSAGES: return ModelPackage.NEW_PICK__MESSAGES;
				case BPELPackage.PICK__ALARM: return ModelPackage.NEW_PICK__ALARM;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (createInstance: ");
		if (createInstanceESet) result.append(createInstance); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}
	@Override
	protected void adoptContent(EReference reference, Object object) {
		if (object instanceof OnMessage) {
			ReconciliationHelper.adoptChild(this, messages, (OnMessage) object,
					BPELConstants.ND_ON_MESSAGE);
		}
		if (object instanceof OnAlarm) {
			ReconciliationHelper.adoptChild(this, alarm, (OnAlarm) object,
					BPELConstants.ND_ON_ALARM);
		}
		if (object instanceof OnUserEvent) {
			ReconciliationHelper.adoptChild(this, userInteracion, (OnUserEvent) object,
					BPEL_UI_Constants.ND_ON_USER_EVENT);
		}
		super.adoptContent(reference, object);
	}

	@Override
	protected void orphanContent(EReference reference, Object object) {
		if (object instanceof OnMessage) {
			ReconciliationHelper.orphanChild(this, (OnMessage) object);
		}
		if (object instanceof OnAlarm) {
			ReconciliationHelper.orphanChild(this, (OnAlarm) object);
		}
		if (object instanceof OnUserEvent) {
			ReconciliationHelper.orphanChild(this, (OnUserEvent) object);
		}
		super.orphanContent(reference, object);
	}

} //NewPickImpl
