/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.bpel_ui.model.impl;

import javax.wsdl.extensions.ExtensibilityElement;

import be.edu.fundp.precise.bpel_ui.model.ModelPackage;
import be.edu.fundp.precise.bpel_ui.model.OnUserEvent;
import be.edu.fundp.precise.bpel_ui.model.UserEventType;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>On User Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.impl.OnUserEventImpl#getId <em>Id</em>}</li>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.impl.OnUserEventImpl#getType <em>Type</em>}</li>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.impl.OnUserEventImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.impl.OnUserEventImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OnUserEventImpl extends BPEL_UI_EntityImpl implements OnUserEvent {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final UserEventType TYPE_EDEFAULT = UserEventType.ON_DATA_INPUT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected UserEventType type = TYPE_EDEFAULT;

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
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected Activity container;

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
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setId(String newId) {
		String oldId = id;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, ModelPackage.eINSTANCE
					.getOnUserEvent_Id().getName(),
					newId);
		}
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ON_USER_EVENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserEventType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setType(UserEventType newType) {
		UserEventType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, ModelPackage.eINSTANCE
					.getOnUserEvent_Type().getName(),
					type.getLiteral());
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ON_USER_EVENT__TYPE, oldType, type));
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
			ENotificationImpl notification = null;
			Variable oldVariable = variable;
			if (!isReconciling) {
				ReconciliationHelper.replaceAttribute(this,
						ModelPackage.eINSTANCE.getOnUserEvent_Variable().getName(),
						newVariable == null ? null : newVariable.getName());
			}
			variable = newVariable;
			if (eNotificationRequired()) {
				notification = new ENotificationImpl(this,
						Notification.SET,
						ModelPackage.ON_USER_EVENT__VARIABLE, oldVariable,
						newVariable);
				notification.dispatch();
			}
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ON_USER_EVENT__VARIABLE, newVariable, newVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public NotificationChain basicSetContainer(Activity newContainer, NotificationChain msgs) {
		Activity oldContainer = container;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldContainer, newContainer);
		}
		container = newContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ON_USER_EVENT__CONTAINER, oldContainer, newContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(Activity newContainer) {
		if (newContainer != container) {
			NotificationChain msgs = null;
			if (container != null)
				msgs = ((InternalEObject)container).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ON_USER_EVENT__CONTAINER, null, msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ON_USER_EVENT__CONTAINER, null, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ON_USER_EVENT__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ON_USER_EVENT__CONTAINER:
				return basicSetContainer(null, msgs);
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
			case ModelPackage.ON_USER_EVENT__ID:
				return getId();
			case ModelPackage.ON_USER_EVENT__TYPE:
				return getType();
			case ModelPackage.ON_USER_EVENT__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case ModelPackage.ON_USER_EVENT__CONTAINER:
				return getContainer();
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
			case ModelPackage.ON_USER_EVENT__ID:
				setId((String)newValue);
				return;
			case ModelPackage.ON_USER_EVENT__TYPE:
				setType((UserEventType)newValue);
				return;
			case ModelPackage.ON_USER_EVENT__VARIABLE:
				setVariable((Variable)newValue);
				return;
			case ModelPackage.ON_USER_EVENT__CONTAINER:
				setContainer((Activity)newValue);
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
			case ModelPackage.ON_USER_EVENT__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.ON_USER_EVENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelPackage.ON_USER_EVENT__VARIABLE:
				setVariable((Variable)null);
				return;
			case ModelPackage.ON_USER_EVENT__CONTAINER:
				setContainer((Activity)null);
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
			case ModelPackage.ON_USER_EVENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ModelPackage.ON_USER_EVENT__TYPE:
				return type != TYPE_EDEFAULT;
			case ModelPackage.ON_USER_EVENT__VARIABLE:
				return variable != null;
			case ModelPackage.ON_USER_EVENT__CONTAINER:
				return container != null;
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
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

	@Override
	public ExtensibilityElement removeExtensibilityElement(
			ExtensibilityElement arg0) {
		return null;
	}
	
	@Override
	protected void adoptContent(EReference reference, Object object) {
		if (object instanceof Activity) {
			ReconciliationHelper.replaceChild(this, container, (Activity) object);
		}
		super.adoptContent(reference, object);

	}
	
	@Override
	protected void orphanContent(EReference reference, Object obj) {
		if (obj instanceof Activity) {
			ReconciliationHelper.orphanChild(this, (Activity)obj);
		}
		super.orphanContent(reference, obj);
	}

} //OnUserEventImpl
