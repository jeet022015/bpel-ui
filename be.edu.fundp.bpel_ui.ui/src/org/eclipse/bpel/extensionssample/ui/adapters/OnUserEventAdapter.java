/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.extensionssample.ui.adapters;

import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.ContainerAdapter;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.adapters.IExtensionFactory;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.adapters.IOutlineEditPartFactory;
import org.eclipse.bpel.ui.adapters.delegates.ActivityContainer;
import org.eclipse.bpel.ui.editparts.ElseIfEditPart;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelFactory;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wst.wsdl.Operation;

import be.edu.fundp.bpel_ui.model.ModelPackage;


public class OnUserEventAdapter extends ContainerAdapter implements ILabeledElement,
	EditPartFactory, IOutlineEditPartFactory, IMarkerHolder, IExtensionFactory
{	

	/* IContainer delegate */
	
	@Override
	public IContainer createContainerDelegate() {
		System.out.println("ai aia aia aiaia ia aia i");
		return new ActivityContainer(ModelPackage.eINSTANCE.getOnUserEvent_Activity());
	}

	/* ILabeledElement */
	
	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_ONMESSAGE_16);
	}
	
	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_ONMESSAGE_32);
	}	
	
	public String getTypeLabel(Object object) {
		return Messages.OnEventAdapter_OnEvent_1; 
	}	
	
	public String getLabel(Object object) {
		String s = ModelHelper.getDisplayName(object);
		if (s != null && !("".equals(s))) return s; //$NON-NLS-1$

		OnEvent onEvent = (OnEvent)object;
		// If it has an operation, use the operation's name as the label
		Operation operation = onEvent.getOperation();
		if (operation != null) {
			return operation.getName();
		}
		return getTypeLabel(object);
	}	

	/* EditPartFactory */
	
	public EditPart createEditPart(EditPart context, Object model) {
		System.out.println("OnUserEvent - model "+model);
		System.out.println("OnUserEvent - context "+context);
		Resource r = ((EObject)model).eResource();
		System.out.println("OnUserEvent Resource = "+r);
		EditPart result = new ElseIfEditPart();
		result.setModel(model);
		return result;
	}

	/* IOutlineEditPartFactory */
	
	public EditPart createOutlineEditPart(EditPart context, Object model) {
		EditPart result = new OutlineTreeEditPart();
		result.setModel(model);
		return result;
	}
	

	/* IExtensionFactory */
	
	public EObject createExtension(EObject object) {
		return null;
		//return UiextensionmodelFactory.eINSTANCE.createOnEventExtension();
	}

}
