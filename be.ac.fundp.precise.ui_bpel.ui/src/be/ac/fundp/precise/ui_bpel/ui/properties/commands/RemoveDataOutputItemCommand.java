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

import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;


// TODO: Auto-generated Javadoc
/**
 * Removes a Copy from an Assign activity.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class RemoveDataOutputItemCommand extends RemoveFromListCommand {

	/**
	 * Instantiates a new removes the data output item command.
	 *
	 * @param target the target
	 * @param oldCopy the old copy
	 */
	public RemoveDataOutputItemCommand(DataOutputUI target, DataItem oldCopy) {
		super(target, oldCopy,  "Remove DataItem");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.commands.RemoveFromListCommand#getList()
	 */
	@Override
	protected EList<DataItem> getList() {
		return ((DataOutputUI)target).getOutputItem();
	}
}
