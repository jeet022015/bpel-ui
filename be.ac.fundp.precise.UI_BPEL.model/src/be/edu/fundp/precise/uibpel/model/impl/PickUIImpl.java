/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model.impl;

import java.util.Collection;

import javax.wsdl.extensions.ExtensibilityElement;

import org.eclipse.bpel.model.impl.PickImpl;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.PickUI;
import be.edu.fundp.precise.uibpel.model.util.BpelUiConstants;
import be.edu.fundp.precise.uibpel.model.util.BpelUiReconciliationHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pick UI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link be.edu.fundp.precise.uibpel.model.impl.PickUIImpl#getUserInteraction <em>User Interaction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PickUIImpl extends PickImpl implements PickUI {
	/**
	 * The cached value of the '{@link #getUserInteraction() <em>User Interaction</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserInteraction()
	 * @generated
	 * @ordered
	 */
	protected EList<OnUserEvent> userInteraction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PickUIImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PICK_UI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OnUserEvent> getUserInteraction() {
		if (userInteraction == null) {
			userInteraction = new EObjectContainmentEList<OnUserEvent>(OnUserEvent.class, this, ModelPackage.PICK_UI__USER_INTERACTION);
		}
		return userInteraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PICK_UI__USER_INTERACTION:
				return ((InternalEList<?>)getUserInteraction()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.PICK_UI__USER_INTERACTION:
				return getUserInteraction();
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
			case ModelPackage.PICK_UI__USER_INTERACTION:
				getUserInteraction().clear();
				getUserInteraction().addAll((Collection<? extends OnUserEvent>)newValue);
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
			case ModelPackage.PICK_UI__USER_INTERACTION:
				getUserInteraction().clear();
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
			case ModelPackage.PICK_UI__USER_INTERACTION:
				return userInteraction != null && !userInteraction.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public ExtensibilityElement removeExtensibilityElement(
			ExtensibilityElement arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateElementReferences(EObject object, String attrName,
			String attrValue) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void adoptContent(EReference reference, Object object) {
		if (object instanceof OnUserEvent) {
			BpelUiReconciliationHelper.adoptChild(this, userInteraction, (OnUserEvent) object,
					BpelUiConstants.ND_USER_INTERACTION);
		}
		super.adoptContent(reference, object);
	}

	@Override
	protected void orphanContent(EReference reference, Object object) {
		if (object instanceof OnUserEvent) {
			BpelUiReconciliationHelper.orphanChild(this, (OnUserEvent) object);
		}
		super.orphanContent(reference, object);
	}

} //PickUIImpl
