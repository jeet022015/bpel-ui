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

import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;

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
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.impl.DataSelectionUIImpl#getOutputVariable <em>Output Variable</em>}</li>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.impl.DataSelectionUIImpl#getMinCardinality <em>Min Cardinality</em>}</li>
 *   <li>{@link be.edu.fundp.precise.bpel_ui.model.impl.DataSelectionUIImpl#getMaxCardinality <em>Max Cardinality</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataSelectionUIImpl extends DataInputUIImpl implements DataSelectionUI {
	/**
	 * The cached value of the '{@link #getOutputVariable() <em>Output Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable outputVariable;

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
	public Variable getOutputVariable() {
		if (outputVariable != null && outputVariable.eIsProxy()) {
			InternalEObject oldOutputVariable = (InternalEObject)outputVariable;
			outputVariable = (Variable)eResolveProxy(oldOutputVariable);
			if (outputVariable != oldOutputVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.DATA_SELECTION_UI__OUTPUT_VARIABLE, oldOutputVariable, outputVariable));
			}
		}
		return outputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetOutputVariable() {
		return outputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setOutputVariable(Variable newOutputVariable) {
		if (newOutputVariable != outputVariable) {
			ENotificationImpl notification = null;
			Variable oldVariable = outputVariable;
			if (!isReconciling) {
				ReconciliationHelper.replaceAttribute(this,
						//Is it working?
						ModelPackage.eINSTANCE.getDataOutputUI_OutputVariable().getName(),
						newOutputVariable == null ? null : newOutputVariable.getName());
			}
			outputVariable = newOutputVariable;
			if (eNotificationRequired()) {
				notification = new ENotificationImpl(this,
						Notification.SET,
						ModelPackage.DATA_SELECTION_UI__OUTPUT_VARIABLE, oldVariable,
						newOutputVariable);
				notification.dispatch();
			}
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 
					ModelPackage.DATA_SELECTION_UI__OUTPUT_VARIABLE, newOutputVariable, newOutputVariable));
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
		System.out.println("aquuuiiiiii "+newMaxCardinality);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.DATA_SELECTION_UI__OUTPUT_VARIABLE:
				if (resolve) return getOutputVariable();
				return basicGetOutputVariable();
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
			case ModelPackage.DATA_SELECTION_UI__OUTPUT_VARIABLE:
				setOutputVariable((Variable)newValue);
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
			case ModelPackage.DATA_SELECTION_UI__OUTPUT_VARIABLE:
				setOutputVariable((Variable)null);
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
			case ModelPackage.DATA_SELECTION_UI__OUTPUT_VARIABLE:
				return outputVariable != null;
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
				case ModelPackage.DATA_SELECTION_UI__OUTPUT_VARIABLE: return ModelPackage.DATA_OUTPUT_UI__OUTPUT_VARIABLE;
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
				case ModelPackage.DATA_OUTPUT_UI__OUTPUT_VARIABLE: return ModelPackage.DATA_SELECTION_UI__OUTPUT_VARIABLE;
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
		result.append(" (minCardinality: ");
		result.append(minCardinality);
		result.append(", maxCardinality: ");
		result.append(maxCardinality);
		result.append(')');
		return result.toString();
	}

} //DataSelectionUIImpl
