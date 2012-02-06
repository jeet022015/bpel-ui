/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model.impl;

import java.util.Collection;

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

import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;
import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.util.BpelUiConstants;
import be.edu.fundp.precise.uibpel.model.util.BpelUiReconciliationHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Selection UI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.DataSelectionUIImpl#getOutputItem <em>Output Item</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.DataSelectionUIImpl#getMinCardinality <em>Min Cardinality</em>}</li>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.DataSelectionUIImpl#getMaxCardinality <em>Max Cardinality</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataSelectionUIImpl extends DataInputUIImpl implements DataSelectionUI {
	/**
	 * The cached value of the '{@link #getOutputItem() <em>Output Item</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputItem()
	 * @generated
	 * @ordered
	 */
	protected EList<DataItem> outputItem;

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
	public EList<DataItem> getOutputItem() {
		if (outputItem == null) {
			outputItem = new EObjectContainmentEList<DataItem>(DataItem.class, this, ModelPackage.DATA_SELECTION_UI__OUTPUT_ITEM);
		}
		return outputItem;
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
	 * @generated NOT
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
	 * @generated NOT
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
			case ModelPackage.DATA_SELECTION_UI__OUTPUT_ITEM:
				return ((InternalEList<?>)getOutputItem()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.DATA_SELECTION_UI__OUTPUT_ITEM:
				return getOutputItem();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.DATA_SELECTION_UI__OUTPUT_ITEM:
				getOutputItem().clear();
				getOutputItem().addAll((Collection<? extends DataItem>)newValue);
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
			case ModelPackage.DATA_SELECTION_UI__OUTPUT_ITEM:
				getOutputItem().clear();
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
			case ModelPackage.DATA_SELECTION_UI__OUTPUT_ITEM:
				return outputItem != null && !outputItem.isEmpty();
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DataOutputUI.class) {
			switch (derivedFeatureID) {
				case ModelPackage.DATA_SELECTION_UI__OUTPUT_ITEM: return ModelPackage.DATA_OUTPUT_UI__OUTPUT_ITEM;
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
		if (baseClass == DataOutputUI.class) {
			switch (baseFeatureID) {
				case ModelPackage.DATA_OUTPUT_UI__OUTPUT_ITEM: return ModelPackage.DATA_SELECTION_UI__OUTPUT_ITEM;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
	
	@Override
	protected void adoptContent(EReference reference, Object object) {
		if (object instanceof DataItem) {
			if (reference.getName().equals(BpelUiConstants.ND_OUTPUT_ITEM))
				BpelUiReconciliationHelper.adoptChild(this, outputItem, (DataItem) object,
						BpelUiConstants.ND_OUTPUT_ITEM);
		}
		super.adoptContent(reference, object);
	}

	@SuppressWarnings("restriction")
	@Override
	protected void orphanContent(EReference reference, Object object) {
		if (object instanceof DataItem) {
			BpelUiReconciliationHelper.orphanChild(this, (DataItem) object);
		}
		super.orphanContent(reference, object);
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
