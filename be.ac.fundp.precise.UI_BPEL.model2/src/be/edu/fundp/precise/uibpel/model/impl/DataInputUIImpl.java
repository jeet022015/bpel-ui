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

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.util.BpelUiConstants;
import be.edu.fundp.precise.uibpel.model.util.BpelUiReconciliationHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Input UI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.DataInputUIImpl#getInputItem <em>Input Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataInputUIImpl extends DataInteractionImpl implements DataInputUI {
	/**
	 * The cached value of the '{@link #getInputItem() <em>Input Item</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputItem()
	 * @generated
	 * @ordered
	 */
	protected EList<DataItem> inputItem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataInputUIImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.DATA_INPUT_UI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataItem> getInputItem() {
		if (inputItem == null) {
			inputItem = new EObjectContainmentEList<DataItem>(DataItem.class, this, ModelPackage.DATA_INPUT_UI__INPUT_ITEM);
		}
		return inputItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.DATA_INPUT_UI__INPUT_ITEM:
				return ((InternalEList<?>)getInputItem()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.DATA_INPUT_UI__INPUT_ITEM:
				return getInputItem();
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
			case ModelPackage.DATA_INPUT_UI__INPUT_ITEM:
				getInputItem().clear();
				getInputItem().addAll((Collection<? extends DataItem>)newValue);
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
			case ModelPackage.DATA_INPUT_UI__INPUT_ITEM:
				getInputItem().clear();
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
			case ModelPackage.DATA_INPUT_UI__INPUT_ITEM:
				return inputItem != null && !inputItem.isEmpty();
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
			BpelUiReconciliationHelper.adoptChild(this, inputItem, (DataItem) object,
					BpelUiConstants.ND_INPUT_ITEM);
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

} //DataInputUIImpl
