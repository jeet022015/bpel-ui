/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model.impl;

import javax.wsdl.extensions.ExtensibilityElement;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
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
 * An implementation of the model object '<em><b>Data Input UI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.DataInputUIImpl#getInputVariable <em>Input Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataInputUIImpl extends UserInteractionImpl implements DataInputUI {
	/**
	 * The cached value of the '{@link #getInputVariable() <em>Input Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable inputVariable;

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
	public Variable getInputVariable() {
		if (inputVariable != null && inputVariable.eIsProxy()) {
			InternalEObject oldInputVariable = (InternalEObject)inputVariable;
			inputVariable = (Variable)eResolveProxy(oldInputVariable);
			if (inputVariable != oldInputVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.DATA_INPUT_UI__INPUT_VARIABLE, oldInputVariable, inputVariable));
			}
		}
		return inputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetInputVariable() {
		return inputVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setInputVariable(Variable newInputVariable) {
		
		if (newInputVariable != inputVariable) {
			ENotificationImpl notification = null;
			Variable oldVariable = inputVariable;
			if (!isReconciling) {
				ReconciliationHelper.replaceAttribute(this,
						//Is it working?
						ModelPackage.eINSTANCE.getDataInputUI_InputVariable().getName(),
						newInputVariable == null ? null : newInputVariable.getName());
			}
			inputVariable = newInputVariable;
			if (eNotificationRequired()) {
				notification = new ENotificationImpl(this,
						Notification.SET,
						ModelPackage.DATA_INPUT_UI__INPUT_VARIABLE, oldVariable,
						newInputVariable);
				notification.dispatch();
			}
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 
					ModelPackage.DATA_INPUT_UI__INPUT_VARIABLE,
					newInputVariable, newInputVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.DATA_INPUT_UI__INPUT_VARIABLE:
				if (resolve) return getInputVariable();
				return basicGetInputVariable();
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
			case ModelPackage.DATA_INPUT_UI__INPUT_VARIABLE:
				setInputVariable((Variable)newValue);
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
			case ModelPackage.DATA_INPUT_UI__INPUT_VARIABLE:
				setInputVariable((Variable)null);
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
			case ModelPackage.DATA_INPUT_UI__INPUT_VARIABLE:
				return inputVariable != null;
		}
		return super.eIsSet(featureID);
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
		if (object!=null && getInputVariable() == object) {
			// has the variable name changed?
			if (BPELConstants.AT_NAME.equals(attrName)) {
				// update our "variable" attribute with the name change
				ReconciliationHelper.replaceAttribute(this, 
						//Is it working?
						ModelPackage.eINSTANCE.getDataInputUI_InputVariable().getName(),
						attrValue);
			}
		}
	}

} //DataInputUIImpl
