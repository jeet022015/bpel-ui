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
package be.ac.fundp.precise.ui_bpel.ui.properties;

import org.eclipse.bpel.common.ui.details.ButtonIValue;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.common.ui.flatui.FlatFormLayout;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.bpel.ui.properties.EditController;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.UserInteraction;

/**
 * Details section for the "createInstance" property of Receive and Pick activities.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class CreateInstanceSection extends BPELPropertySection  {

	/** The create instance button. */
	Button fCreateInstanceButton;	
	
	/** The crete instance controller. */
	EditController fCreteInstanceController ;


	/**
	 * Creates the change trackers.
	 */
	protected void createChangeTrackers() {	
		fCreteInstanceController = createEditController();
		ButtonIValue bv = new ButtonIValue(fCreateInstanceButton);
		System.out.println("bv="+bv.get());
		fCreteInstanceController.setViewIValue(new ButtonIValue(fCreateInstanceButton));
		fCreteInstanceController.startListeningTo(fCreateInstanceButton);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#basicSetInput(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected void basicSetInput(EObject newInput) {

		super.basicSetInput(newInput);
		
		if (newInput instanceof UserInteraction) {
			UserInteraction ui = (UserInteraction)newInput;
			System.out.println("User Interacion="+ui.isCreateInstance());
			fCreteInstanceController.setFeature(ModelPackage.eINSTANCE.getUserInteraction_CreateInstance());
			fCreteInstanceController.setInput(newInput);
		} else {
			fCreteInstanceController.setFeature( null );		
			fCreteInstanceController.setInput(newInput);
		}
	}

	/**
	 * Creates the create instance widgets.
	 *
	 * @param composite the composite
	 */
	protected void createCreateInstanceWidgets(Composite composite) {
		FlatFormData data;
		
		Composite parent = fWidgetFactory.createComposite(composite);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		
		parent.setLayoutData(data);
		parent.setLayout(new FillLayout());

		fCreateInstanceButton = fWidgetFactory.createButton(parent, "Create Instance", SWT.CHECK);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#createClient(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createClient(Composite parent) {
		Composite composite = createFlatFormComposite(parent);
		// HACK: the checkbox by itself looks cramped..give it a little extra space
		((FlatFormLayout)composite.getLayout()).marginHeight += 3;

		createCreateInstanceWidgets(composite);
		createChangeTrackers();

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			composite, IHelpContextIds.PROPERTY_PAGE_PICK_IMPLEMENTATION);
	}


	/**
	 * Gets the user context.
	 *
	 * @return the user context
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@Override
	public Object getUserContext() {
		return null;
	}
	
	/**
	 * Restore user context.
	 *
	 * @param userContext the user context
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@Override
	public void restoreUserContext(Object userContext) {
		fCreateInstanceButton.setFocus();
		
	}
	
	/**
	 * Should use extra space.
	 *
	 * @return true, if successful
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
	 */
	@Override
	public boolean shouldUseExtraSpace () {
		return false;
	}
	
	/**
	 * Gets the minimum height.
	 *
	 * @return the minimum height
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#getMinimumHeight()
	 */
	@Override
	public int getMinimumHeight () {
		return 40;
	}
}
