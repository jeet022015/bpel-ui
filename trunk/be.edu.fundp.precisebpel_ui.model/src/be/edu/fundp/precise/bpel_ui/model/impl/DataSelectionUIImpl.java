/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.bpel_ui.model.impl;

import be.edu.fundp.precise.bpel_ui.model.DataOutputUI;
import be.edu.fundp.precise.bpel_ui.model.DataSelectionUI;
import be.edu.fundp.precise.bpel_ui.model.ModelPackage;

import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Selection UI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.impl.DataSelectionUIImpl#getSelectable <em>Selectable</em>}</li>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.impl.DataSelectionUIImpl#getMinCardinality <em>Min Cardinality</em>}</li>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.impl.DataSelectionUIImpl#getMaxCardinality <em>Max Cardinality</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataSelectionUIImpl extends DataInputUIImpl implements DataSelectionUI {
	/**
	 * The cached value of the '{@link #getSelectable() <em>Selectable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectable()
	 * @generated
	 * @ordered
	 */
	protected DataOutputUI selectable;

	/**
	 * The default value of the '{@link #getMinCardinality() <em>Min Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_CARDINALITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinCardinality() <em>Min Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinCardinality()
	 * @generated
	 * @ordered
	 */
	protected int minCardinality = MIN_CARDINALITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxCardinality() <em>Max Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_CARDINALITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxCardinality() <em>Max Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCardinality()
	 * @generated
	 * @ordered
	 */
	protected int maxCardinality = MAX_CARDINALITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataSelectionUIImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.DATA_SELECTION_UI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataOutputUI getSelectable() {
		return selectable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public NotificationChain basicSetSelectable(DataOutputUI newSelectable, NotificationChain msgs) {
		DataOutputUI oldSelectable = selectable;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldSelectable, newSelectable);
		}
		selectable = newSelectable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 
					ModelPackage.DATA_SELECTION_UI__SELECTABLE, oldSelectable, newSelectable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectable(DataOutputUI newSelectable) {
		if (newSelectable != selectable) {
			NotificationChain msgs = null;
			if (selectable != null)
				msgs = ((InternalEObject)selectable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.DATA_SELECTION_UI__SELECTABLE, null, msgs);
			if (newSelectable != null)
				msgs = ((InternalEObject)newSelectable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.DATA_SELECTION_UI__SELECTABLE, null, msgs);
			msgs = basicSetSelectable(newSelectable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DATA_SELECTION_UI__SELECTABLE, newSelectable, newSelectable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinCardinality() {
		return minCardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setMinCardinality(int newMinCardinality) {
		int oldMinCardinality = minCardinality;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, ModelPackage.eINSTANCE
					.getDataSelectionUI_MinCardinality().getName(),
					Integer.toString(newMinCardinality));
		}
		minCardinality = newMinCardinality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DATA_SELECTION_UI__MIN_CARDINALITY, oldMinCardinality, minCardinality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxCardinality() {
		return maxCardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setMaxCardinality(int newMaxCardinality) {
		int oldMaxCardinality = maxCardinality;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, ModelPackage.eINSTANCE
					.getDataSelectionUI_MaxCardinality().getName(),
					Integer.toString(newMaxCardinality));
		}
		maxCardinality = newMaxCardinality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DATA_SELECTION_UI__MAX_CARDINALITY, oldMaxCardinality, maxCardinality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.DATA_SELECTION_UI__SELECTABLE:
				return basicSetSelectable(null, msgs);
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
			case ModelPackage.DATA_SELECTION_UI__SELECTABLE:
				return getSelectable();
			case ModelPackage.DATA_SELECTION_UI__MIN_CARDINALITY:
				return getMinCardinality();
			case ModelPackage.DATA_SELECTION_UI__MAX_CARDINALITY:
				return getMaxCardinality();
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
			case ModelPackage.DATA_SELECTION_UI__SELECTABLE:
				setSelectable((DataOutputUI)newValue);
				return;
			case ModelPackage.DATA_SELECTION_UI__MIN_CARDINALITY:
				setMinCardinality((Integer)newValue);
				return;
			case ModelPackage.DATA_SELECTION_UI__MAX_CARDINALITY:
				setMaxCardinality((Integer)newValue);
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
			case ModelPackage.DATA_SELECTION_UI__SELECTABLE:
				setSelectable((DataOutputUI)null);
				return;
			case ModelPackage.DATA_SELECTION_UI__MIN_CARDINALITY:
				setMinCardinality(MIN_CARDINALITY_EDEFAULT);
				return;
			case ModelPackage.DATA_SELECTION_UI__MAX_CARDINALITY:
				setMaxCardinality(MAX_CARDINALITY_EDEFAULT);
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
			case ModelPackage.DATA_SELECTION_UI__SELECTABLE:
				return selectable != null;
			case ModelPackage.DATA_SELECTION_UI__MIN_CARDINALITY:
				return minCardinality != MIN_CARDINALITY_EDEFAULT;
			case ModelPackage.DATA_SELECTION_UI__MAX_CARDINALITY:
				return maxCardinality != MAX_CARDINALITY_EDEFAULT;
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
		result.append(" (minCardinality: ");
		result.append(minCardinality);
		result.append(", maxCardinality: ");
		result.append(maxCardinality);
		result.append(')');
		return result.toString();
	}

} //DataSelectionUIImpl
