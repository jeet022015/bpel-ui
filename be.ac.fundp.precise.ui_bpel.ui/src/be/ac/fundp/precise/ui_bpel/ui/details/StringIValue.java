/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package be.ac.fundp.precise.ui_bpel.ui.details;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.bpel.common.ui.details.IValue;
import org.eclipse.swt.widgets.Text;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 27, 2007
 *
 */

public class StringIValue implements IValue {
	
	Text fWidget;
	String role;
	
	/**
	 * @param fCreateInstanceButton
	 */
	public StringIValue ( Text fCreateInstanceButton ) {
		fWidget = fCreateInstanceButton;
	}

	/**
	 * @see org.eclipse.bpel.common.ui.details.IValue#get()
	 */
	public Object get() {
		Collection<String> myArray = new ArrayList<String>();
		myArray.add(fWidget.getText().trim());
		return myArray;
	}

	/** 
	 * @see org.eclipse.bpel.common.ui.details.IValue#set(java.lang.Object)
	 */
	@SuppressWarnings("nls")
	public void set( Object text ) {
		if (text != null && text instanceof Collection){
			Collection myArray = (Collection) text;
			//FIXME It works?
			if (myArray.size() > 0){
				fWidget.setText( myArray.iterator().next().toString());
				return;
			}
		}
		fWidget.setText("defaultRole");
	}
}
