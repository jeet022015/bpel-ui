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
package be.ac.fundp.precise.ui_bpel.ui.properties.commands;


import org.eclipse.bpel.ui.commands.RemoveFromListCommand;
import org.eclipse.emf.common.util.EList;

import be.ac.fundp.precise.ui_bpel.ui.Messages;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.UserInteraction;


/**
 * Removes a Copy from an Assign activity.
 */
public class RemoveDataItemCommand extends RemoveFromListCommand {

	public RemoveDataItemCommand(UserInteraction target, DataItem oldCopy) {
		super(target, oldCopy,  Messages.UIBPELEditor_Command_Delete_Data);
	}

	@Override
	protected EList<DataItem> getList() {
		return ((UserInteraction)target).getData();
	}
}
