/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model.impl;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import be.edu.fundp.precise.uibpel.model.DataInteraction;
import be.edu.fundp.precise.uibpel.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.DataInteractionImpl#getName <em>Name</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.DataInteractionImpl#getSuppressJoinFailure <em>Suppress Join Failure</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.DataInteractionImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.DataInteractionImpl#getSources <em>Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DataInteractionImpl extends UserInteractionImpl implements DataInteraction {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataInteractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.DATA_INTERACTION;
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
	 * @generated NOT
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, BPELConstants.AT_NAME,
					newName);
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DATA_INTERACTION__NAME, oldName, name));
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
	 * @generated NOT
	 */
	public void setSuppressJoinFailure(Boolean newSuppressJoinFailure) {
		Boolean oldSuppressJoinFailure = suppressJoinFailure;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_SUPPRESS_JOIN_FAILURE,
					BPELUtils.boolean2XML(newSuppressJoinFailure));
		}
		suppressJoinFailure = newSuppressJoinFailure;
		boolean oldSuppressJoinFailureESet = suppressJoinFailureESet;
		suppressJoinFailureESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DATA_INTERACTION__SUPPRESS_JOIN_FAILURE, oldSuppressJoinFailure, suppressJoinFailure, !oldSuppressJoinFailureESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void unsetSuppressJoinFailure() {
		Boolean oldSuppressJoinFailure = suppressJoinFailure;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_SUPPRESS_JOIN_FAILURE, (String) null);
		}
		boolean oldSuppressJoinFailureESet = suppressJoinFailureESet;
		suppressJoinFailure = SUPPRESS_JOIN_FAILURE_EDEFAULT;
		suppressJoinFailureESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.DATA_INTERACTION__SUPPRESS_JOIN_FAILURE, oldSuppressJoinFailure, SUPPRESS_JOIN_FAILURE_EDEFAULT, oldSuppressJoinFailureESet));
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
	 * @generated NOT
	 */
	public NotificationChain basicSetTargets(Targets newTargets, NotificationChain msgs) {
		Targets oldTargets = targets;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldTargets, newTargets);
		}
		targets = newTargets;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.DATA_INTERACTION__TARGETS, oldTargets, newTargets);
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
				msgs = ((InternalEObject)targets).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.DATA_INTERACTION__TARGETS, null, msgs);
			if (newTargets != null)
				msgs = ((InternalEObject)newTargets).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.DATA_INTERACTION__TARGETS, null, msgs);
			msgs = basicSetTargets(newTargets, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DATA_INTERACTION__TARGETS, newTargets, newTargets));
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
	 * @generated NOT
	 */
	public NotificationChain basicSetSources(Sources newSources, NotificationChain msgs) {
		Sources oldSources = sources;
		sources = newSources;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldSources, newSources);
		}
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.DATA_INTERACTION__SOURCES, oldSources, newSources);
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
				msgs = ((InternalEObject)sources).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.DATA_INTERACTION__SOURCES, null, msgs);
			if (newSources != null)
				msgs = ((InternalEObject)newSources).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.DATA_INTERACTION__SOURCES, null, msgs);
			msgs = basicSetSources(newSources, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DATA_INTERACTION__SOURCES, newSources, newSources));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.DATA_INTERACTION__TARGETS:
				return basicSetTargets(null, msgs);
			case ModelPackage.DATA_INTERACTION__SOURCES:
				return basicSetSources(null, msgs);
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
			case ModelPackage.DATA_INTERACTION__NAME:
				return getName();
			case ModelPackage.DATA_INTERACTION__SUPPRESS_JOIN_FAILURE:
				return getSuppressJoinFailure();
			case ModelPackage.DATA_INTERACTION__TARGETS:
				return getTargets();
			case ModelPackage.DATA_INTERACTION__SOURCES:
				return getSources();
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
			case ModelPackage.DATA_INTERACTION__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.DATA_INTERACTION__SUPPRESS_JOIN_FAILURE:
				setSuppressJoinFailure((Boolean)newValue);
				return;
			case ModelPackage.DATA_INTERACTION__TARGETS:
				setTargets((Targets)newValue);
				return;
			case ModelPackage.DATA_INTERACTION__SOURCES:
				setSources((Sources)newValue);
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
			case ModelPackage.DATA_INTERACTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.DATA_INTERACTION__SUPPRESS_JOIN_FAILURE:
				unsetSuppressJoinFailure();
				return;
			case ModelPackage.DATA_INTERACTION__TARGETS:
				setTargets((Targets)null);
				return;
			case ModelPackage.DATA_INTERACTION__SOURCES:
				setSources((Sources)null);
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
			case ModelPackage.DATA_INTERACTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.DATA_INTERACTION__SUPPRESS_JOIN_FAILURE:
				return isSetSuppressJoinFailure();
			case ModelPackage.DATA_INTERACTION__TARGETS:
				return targets != null;
			case ModelPackage.DATA_INTERACTION__SOURCES:
				return sources != null;
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
				case ModelPackage.DATA_INTERACTION__NAME: return BPELPackage.ACTIVITY__NAME;
				case ModelPackage.DATA_INTERACTION__SUPPRESS_JOIN_FAILURE: return BPELPackage.ACTIVITY__SUPPRESS_JOIN_FAILURE;
				case ModelPackage.DATA_INTERACTION__TARGETS: return BPELPackage.ACTIVITY__TARGETS;
				case ModelPackage.DATA_INTERACTION__SOURCES: return BPELPackage.ACTIVITY__SOURCES;
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
				case BPELPackage.ACTIVITY__NAME: return ModelPackage.DATA_INTERACTION__NAME;
				case BPELPackage.ACTIVITY__SUPPRESS_JOIN_FAILURE: return ModelPackage.DATA_INTERACTION__SUPPRESS_JOIN_FAILURE;
				case BPELPackage.ACTIVITY__TARGETS: return ModelPackage.DATA_INTERACTION__TARGETS;
				case BPELPackage.ACTIVITY__SOURCES: return ModelPackage.DATA_INTERACTION__SOURCES;
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

} //DataInteractionImpl
