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
package be.ac.fundp.precise.ui_bpel.ui.action.editpart;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.actions.editpart.AbstractAction;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetNameAndDirectEditCommand;
import org.eclipse.bpel.ui.factories.UIObjectFactoryProvider;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import be.ac.fundp.precise.ui_bpel.ui.commands.InsertUiElementInContainerCommand;
import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.ModelFactory;


// TODO: Auto-generated Javadoc
/**
 * The Class CreateEventHandlerUIAction.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public final class CreateEventHandlerUIAction extends AbstractAction {

	/**
	 * Instantiates a new creates the event handler ui action.
	 *
	 * @param editPart the edit part
	 */
	public CreateEventHandlerUIAction(EditPart editPart) {
		super(editPart);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#getIcon()
	 */
	public ImageDescriptor getIcon() {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_ACTION_EVENTHANDLER);
	}

	/**
	 * Gets the icon img.
	 *
	 * @return the icon img
	 */
	public Image getIconImg() {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_ACTION_EVENTHANDLER);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#onButtonPressed()
	 */
	public boolean onButtonPressed() {
		CompoundCommand command = new CompoundCommand(IBPELUIConstants.CMD_ADD_EVENTHANDLER);
		
		final EventHandlerUI eventHandler =  ModelFactory.eINSTANCE.createEventHandlerUI();
		final OnEvent onEvent = (OnEvent)UIObjectFactoryProvider.getInstance().getFactoryFor(
				BPELPackage.eINSTANCE.getOnEvent()).createInstance();
		
		eventHandler.getEvents().add(onEvent);
		
		command.add(new InsertUiElementInContainerCommand((EObject)modelObject, eventHandler, null)); 
		command.add(new SetNameAndDirectEditCommand(onEvent, viewer));
		ModelHelper.getBPELEditor(modelObject).getCommandStack().execute(command);
		BPELUtil.setShowEventHandler(editPart, true);
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#getToolTip()
	 */
	public String getToolTip() {
		return "My New Event2"; 
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.actions.editpart.AbstractAction#getDisabledIcon()
	 */
	@Override
	public ImageDescriptor getDisabledIcon() { return ImageDescriptor.getMissingImageDescriptor(); }
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.actions.editpart.AbstractAction#isEnabled()
	 */
	@Override
	public boolean isEnabled() { return true; }	
}