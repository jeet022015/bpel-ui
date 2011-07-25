/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model.impl;

import javax.wsdl.extensions.ExtensibilityElement;

import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.ModelPackage;

import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Output UI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.DataOutputUIImpl#getOutputVariable <em>Output Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataOutputUIImpl extends UserInteractionImpl implements DataOutputUI {
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
	public Variable getOutputVariable() {
		if (outputVariable != null && outputVariable.eIsProxy()) {
			InternalEObject oldOutputVariable = (InternalEObject)outputVariable;
			outputVariable = (Variable)eResolveProxy(oldOutputVariable);
			if (outputVariable != oldOutputVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.DATA_OUTPUT_UI__OUTPUT_VARIABLE, oldOutputVariable, outputVariable));
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
	 * @generated
	 */
	public void setOutputVariable(Variable newOutputVariable) {
		Variable oldOutputVariable = outputVariable;
		outputVariable = newOutputVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DATA_OUTPUT_UI__OUTPUT_VARIABLE, oldOutputVariable, outputVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.DATA_OUTPUT_UI__OUTPUT_VARIABLE:
				if (resolve) return getOutputVariable();
				return basicGetOutputVariable();
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
			case ModelPackage.DATA_OUTPUT_UI__OUTPUT_VARIABLE:
				setOutputVariable((Variable)newValue);
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
			case ModelPackage.DATA_OUTPUT_UI__OUTPUT_VARIABLE:
				setOutputVariable((Variable)null);
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
			case ModelPackage.DATA_OUTPUT_UI__OUTPUT_VARIABLE:
				return outputVariable != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public ExtensibilityElement removeExtensibilityElement(
			ExtensibilityElement arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	@Override
	public void updateElementReferences(EObject object, String attrName,
			String attrValue) {
		//TODO is it working?
		// Some attribute of the given EObject has changed.
		// If we keep a reference to it, we need to update
		// our XML fragment to reflect the change.
		if (object!=null && getOutputVariable() == object) {
			// has the variable name changed?
			if (BPELConstants.AT_NAME.equals(attrName)) {
				// update our "variable" attribute with the name change
				ReconciliationHelper.replaceAttribute(this, 
						//Is it working?
						ModelPackage.eINSTANCE.getDataOutputUI_OutputVariable().getName(),
						attrValue);
			}
		}
	}

} //DataOutputUIImpl
