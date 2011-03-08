/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.impl;

import javax.wsdl.extensions.ExtensibilityElement;

import model.DataInputUI;
import model.ModelPackage;

import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Input UI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.DataInputUIImpl#isUserValidation <em>User Validation</em>}</li>
 *   <li>{@link model.impl.DataInputUIImpl#getInputVariable <em>Input Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataInputUIImpl extends UserInteractionImpl implements DataInputUI {
	/**
	 * The default value of the '{@link #isUserValidation() <em>User Validation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUserValidation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USER_VALIDATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUserValidation() <em>User Validation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUserValidation()
	 * @generated
	 * @ordered
	 */
	protected boolean userValidation = USER_VALIDATION_EDEFAULT;

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
	public boolean isUserValidation() {
		return userValidation;
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
		Variable oldInputVariable = inputVariable;
		
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, ModelPackage.eINSTANCE
					.getDataInputUI_InputVariable().getName(),
					newInputVariable.getName());
		}
		
		inputVariable = newInputVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DATA_INPUT_UI__INPUT_VARIABLE, oldInputVariable, inputVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setUserValidation(boolean newUserValidation) {
		boolean oldUserValidation = userValidation;
		
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, ModelPackage.eINSTANCE
					.getDataInputUI_UserValidation().getName(),
					Boolean.toString(newUserValidation));
		}
		
		userValidation = newUserValidation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DATA_INPUT_UI__USER_VALIDATION, oldUserValidation, userValidation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.DATA_INPUT_UI__USER_VALIDATION:
				return isUserValidation();
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
			case ModelPackage.DATA_INPUT_UI__USER_VALIDATION:
				setUserValidation((Boolean)newValue);
				return;
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
			case ModelPackage.DATA_INPUT_UI__USER_VALIDATION:
				setUserValidation(USER_VALIDATION_EDEFAULT);
				return;
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
			case ModelPackage.DATA_INPUT_UI__USER_VALIDATION:
				return userValidation != USER_VALIDATION_EDEFAULT;
			case ModelPackage.DATA_INPUT_UI__INPUT_VARIABLE:
				return inputVariable != null;
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
		result.append(" (userValidation: ");
		result.append(userValidation);
		result.append(')');
		return result.toString();
	}
	
	@SuppressWarnings("restriction")
	@Override
	protected void adoptContent(EReference reference, Object object) {
		if (object instanceof Variable) {
			ReconciliationHelper.replaceChild(this, inputVariable, (Variable) object);
		}
		super.adoptContent(reference, object);

	}
	
	@SuppressWarnings("restriction")
	@Override
	protected void orphanContent(EReference reference, Object obj) {
		if (obj instanceof Variable) {
			ReconciliationHelper.orphanChild(this, (Variable)obj);
		}
		super.orphanContent(reference, obj);
	}

	public ExtensibilityElement removeExtensibilityElement(
			ExtensibilityElement arg0) {
		// TODO Auto-generated method stub
		return null;
	}

} //DataInputUIImpl
