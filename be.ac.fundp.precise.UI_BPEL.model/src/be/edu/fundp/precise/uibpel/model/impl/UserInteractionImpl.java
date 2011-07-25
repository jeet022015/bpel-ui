/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model.impl;

import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.UserInteraction;
import be.edu.fundp.precise.uibpel.model.util.BpelUiConstants;
import be.edu.fundp.precise.uibpel.model.util.BpelUiReconciliationHelper;

import java.util.Collection;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl#getName <em>Name</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl#getSuppressJoinFailure <em>Suppress Join Failure</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.UserInteractionImpl#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UserInteractionImpl extends UsableEntityImpl implements UserInteraction {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuppressJoinFailure() <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppressJoinFailure()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SUPPRESS_JOIN_FAILURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuppressJoinFailure() <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppressJoinFailure()
	 * @generated
	 * @ordered
	 */
	protected Boolean suppressJoinFailure = SUPPRESS_JOIN_FAILURE_EDEFAULT;

	/**
	 * This is true if the Suppress Join Failure attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean suppressJoinFailureESet;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected Targets targets;

	/**
	 * The cached value of the '{@link #getSources() <em>Sources</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSources()
	 * @generated
	 * @ordered
	 */
	protected Sources sources;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected EList<DataItem> data;

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
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.USER_INTERACTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getSuppressJoinFailure() {
		return suppressJoinFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppressJoinFailure(Boolean newSuppressJoinFailure) {
		Boolean oldSuppressJoinFailure = suppressJoinFailure;
		suppressJoinFailure = newSuppressJoinFailure;
		boolean oldSuppressJoinFailureESet = suppressJoinFailureESet;
		suppressJoinFailureESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.USER_INTERACTION__SUPPRESS_JOIN_FAILURE, oldSuppressJoinFailure, suppressJoinFailure, !oldSuppressJoinFailureESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSuppressJoinFailure() {
		Boolean oldSuppressJoinFailure = suppressJoinFailure;
		boolean oldSuppressJoinFailureESet = suppressJoinFailureESet;
		suppressJoinFailure = SUPPRESS_JOIN_FAILURE_EDEFAULT;
		suppressJoinFailureESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.USER_INTERACTION__SUPPRESS_JOIN_FAILURE, oldSuppressJoinFailure, SUPPRESS_JOIN_FAILURE_EDEFAULT, oldSuppressJoinFailureESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuppressJoinFailure() {
		return suppressJoinFailureESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Targets getTargets() {
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargets(Targets newTargets, NotificationChain msgs) {
		Targets oldTargets = targets;
		targets = newTargets;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.USER_INTERACTION__TARGETS, oldTargets, newTargets);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargets(Targets newTargets) {
		if (newTargets != targets) {
			NotificationChain msgs = null;
			if (targets != null)
				msgs = ((InternalEObject)targets).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.USER_INTERACTION__TARGETS, null, msgs);
			if (newTargets != null)
				msgs = ((InternalEObject)newTargets).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.USER_INTERACTION__TARGETS, null, msgs);
			msgs = basicSetTargets(newTargets, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.USER_INTERACTION__TARGETS, newTargets, newTargets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sources getSources() {
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSources(Sources newSources, NotificationChain msgs) {
		Sources oldSources = sources;
		sources = newSources;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.USER_INTERACTION__SOURCES, oldSources, newSources);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSources(Sources newSources) {
		if (newSources != sources) {
			NotificationChain msgs = null;
			if (sources != null)
				msgs = ((InternalEObject)sources).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.USER_INTERACTION__SOURCES, null, msgs);
			if (newSources != null)
				msgs = ((InternalEObject)newSources).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.USER_INTERACTION__SOURCES, null, msgs);
			msgs = basicSetSources(newSources, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.USER_INTERACTION__SOURCES, newSources, newSources));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataItem> getData() {
		if (data == null) {
			data = new EObjectContainmentEList<DataItem>(DataItem.class, this, ModelPackage.USER_INTERACTION__DATA);
		}
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.USER_INTERACTION__TARGETS:
				return basicSetTargets(null, msgs);
			case ModelPackage.USER_INTERACTION__SOURCES:
				return basicSetSources(null, msgs);
			case ModelPackage.USER_INTERACTION__DATA:
				return ((InternalEList<?>)getData()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.USER_INTERACTION__NAME:
				return getName();
			case ModelPackage.USER_INTERACTION__SUPPRESS_JOIN_FAILURE:
				return getSuppressJoinFailure();
			case ModelPackage.USER_INTERACTION__TARGETS:
				return getTargets();
			case ModelPackage.USER_INTERACTION__SOURCES:
				return getSources();
			case ModelPackage.USER_INTERACTION__DATA:
				return getData();
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
			case ModelPackage.USER_INTERACTION__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.USER_INTERACTION__SUPPRESS_JOIN_FAILURE:
				setSuppressJoinFailure((Boolean)newValue);
				return;
			case ModelPackage.USER_INTERACTION__TARGETS:
				setTargets((Targets)newValue);
				return;
			case ModelPackage.USER_INTERACTION__SOURCES:
				setSources((Sources)newValue);
				return;
			case ModelPackage.USER_INTERACTION__DATA:
				getData().clear();
				getData().addAll((Collection<? extends DataItem>)newValue);
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
			case ModelPackage.USER_INTERACTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.USER_INTERACTION__SUPPRESS_JOIN_FAILURE:
				unsetSuppressJoinFailure();
				return;
			case ModelPackage.USER_INTERACTION__TARGETS:
				setTargets((Targets)null);
				return;
			case ModelPackage.USER_INTERACTION__SOURCES:
				setSources((Sources)null);
				return;
			case ModelPackage.USER_INTERACTION__DATA:
				getData().clear();
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
			case ModelPackage.USER_INTERACTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.USER_INTERACTION__SUPPRESS_JOIN_FAILURE:
				return isSetSuppressJoinFailure();
			case ModelPackage.USER_INTERACTION__TARGETS:
				return targets != null;
			case ModelPackage.USER_INTERACTION__SOURCES:
				return sources != null;
			case ModelPackage.USER_INTERACTION__DATA:
				return data != null && !data.isEmpty();
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
		if (baseClass == Activity.class) {
			switch (derivedFeatureID) {
				case ModelPackage.USER_INTERACTION__NAME: return BPELPackage.ACTIVITY__NAME;
				case ModelPackage.USER_INTERACTION__SUPPRESS_JOIN_FAILURE: return BPELPackage.ACTIVITY__SUPPRESS_JOIN_FAILURE;
				case ModelPackage.USER_INTERACTION__TARGETS: return BPELPackage.ACTIVITY__TARGETS;
				case ModelPackage.USER_INTERACTION__SOURCES: return BPELPackage.ACTIVITY__SOURCES;
				default: return -1;
			}
		}
		if (baseClass == ExtensionActivity.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == Activity.class) {
			switch (baseFeatureID) {
				case BPELPackage.ACTIVITY__NAME: return ModelPackage.USER_INTERACTION__NAME;
				case BPELPackage.ACTIVITY__SUPPRESS_JOIN_FAILURE: return ModelPackage.USER_INTERACTION__SUPPRESS_JOIN_FAILURE;
				case BPELPackage.ACTIVITY__TARGETS: return ModelPackage.USER_INTERACTION__TARGETS;
				case BPELPackage.ACTIVITY__SOURCES: return ModelPackage.USER_INTERACTION__SOURCES;
				default: return -1;
			}
		}
		if (baseClass == ExtensionActivity.class) {
			switch (baseFeatureID) {
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
		result.append(" (name: ");
		result.append(name);
		result.append(", suppressJoinFailure: ");
		if (suppressJoinFailureESet) result.append(suppressJoinFailure); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}
	
	@Override
	protected void adoptContent(EReference reference, Object object) {
		if (object instanceof DataItem) {
			BpelUiReconciliationHelper.adoptChild(this, data, (DataItem) object,
				//TODO It can't work.	
				BpelUiConstants.ND_DATA_ITEM);
		}
		super.adoptContent(reference, object);
	}

	@Override
	protected void orphanContent(EReference reference, Object obj) {
		if (obj instanceof DataItem) {
			BpelUiReconciliationHelper.orphanChild(this, (DataItem) obj);
		}
		super.orphanContent(reference, obj);
	}

} //UserInteractionImpl
