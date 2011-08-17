/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.uibpel.model.impl;

import javax.wsdl.extensions.ExtensibilityElement;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.impl.ScopeImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.ScopeUI;
import be.edu.fundp.precise.uibpel.model.util.BpelUiReconciliationHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scope UI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ScopeUIImpl extends ScopeImpl implements ScopeUI {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopeUIImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SCOPE_UI;
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
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetEventHandlers(
			EventHandler newEventHandlers, NotificationChain msgs) {
		EventHandler oldEventHandlers = eventHandlers;
		if (!isReconciling) {
			System.out.println("class type: "+newEventHandlers.getClass());
			BpelUiReconciliationHelper.replaceChild(this, oldEventHandlers,
					newEventHandlers);
		}
		eventHandlers = newEventHandlers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.SCOPE__EVENT_HANDLERS,
					oldEventHandlers, newEventHandlers);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

} //ScopeUIImpl
