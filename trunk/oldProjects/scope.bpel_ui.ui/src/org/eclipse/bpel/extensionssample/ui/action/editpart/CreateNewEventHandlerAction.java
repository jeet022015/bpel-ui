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
package org.eclipse.bpel.extensionssample.ui.action.editpart;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.actions.editpart.AbstractAction;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.InsertInContainerCommand;
import org.eclipse.bpel.ui.commands.SetNameAndDirectEditCommand;
import org.eclipse.bpel.ui.factories.UIObjectFactoryProvider;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import be.edu.fundp.bpel_ui.model.ModelFactory;
import be.edu.fundp.bpel_ui.model.NewEventHandler;


public final class CreateNewEventHandlerAction extends AbstractAction {

	public CreateNewEventHandlerAction(EditPart editPart) {
		super(editPart);
	}

	public ImageDescriptor getIcon() {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_ACTION_EVENTHANDLER);
	}

	public Image getIconImg() {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_ACTION_EVENTHANDLER);
	}

	public boolean onButtonPressed() {
		CompoundCommand command = new CompoundCommand(IBPELUIConstants.CMD_ADD_EVENTHANDLER);
		final NewEventHandler eventHandler =  ModelFactory.eINSTANCE.createNewEventHandler();
			//BPELFactory.eINSTANCE.createEventHandler();
		// Create an empty OnEvent inside it.
		//ExtensionSampleUIObjectFactory e = new ExtensionSampleUIObjectFactory();
		//e.setModelType(ModelPackage.eINSTANCE.getOnUserEvent());
		//OnUserEvent child = e.createInstance();
		//eventHandler.
		final OnEvent onEvent = (OnEvent)UIObjectFactoryProvider.getInstance().getFactoryFor(
				BPELPackage.eINSTANCE.getOnEvent()).createInstance();
		eventHandler.getEvents().add(onEvent);
		command.add(new InsertInContainerCommand((EObject)modelObject, eventHandler, null)); 
		command.add(new SetNameAndDirectEditCommand(onEvent, viewer));
		ModelHelper.getBPELEditor(modelObject).getCommandStack().execute(command);
		BPELUtil.setShowEventHandler(editPart, true);
		return true;
	}

	public String getToolTip() {
		return "My New Event"; 
	}
	
	@Override
	public ImageDescriptor getDisabledIcon() { return ImageDescriptor.getMissingImageDescriptor(); }
	@Override
	public boolean isEnabled() { return true; }	
}