/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.util.BpelUiConstants;
import be.edu.fundp.precise.uibpel.model.util.BpelUiReconciliationHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Output UI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.DataOutputUIImpl#getOutputItem <em>Output Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataOutputUIImpl extends DataInteractionImpl implements DataOutputUI {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataOutputUIImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.DATA_OUTPUT_UI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataItem> getOutputItem() {
		if (outputItem == null) {
			outputItem = new EObjectContainmentEList<DataItem>(DataItem.class, this, ModelPackage.DATA_OUTPUT_UI__OUTPUT_ITEM);
		}
		return outputItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.DATA_OUTPUT_UI__OUTPUT_ITEM:
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
			case ModelPackage.DATA_OUTPUT_UI__OUTPUT_ITEM:
				return getOutputItem();
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
			case ModelPackage.DATA_OUTPUT_UI__OUTPUT_ITEM:
				getOutputItem().clear();
				getOutputItem().addAll((Collection<? extends DataItem>)newValue);
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
			case ModelPackage.DATA_OUTPUT_UI__OUTPUT_ITEM:
				getOutputItem().clear();
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
			case ModelPackage.DATA_OUTPUT_UI__OUTPUT_ITEM:
				return outputItem != null && !outputItem.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void updateElementReferences(EObject object, String attrName,
			String attrValue) {
		
	}
	
	@SuppressWarnings("restriction")
	@Override
	protected void adoptContent(EReference reference, Object object) {
		if (object instanceof DataItem) {
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

} //DataOutputUIImpl
