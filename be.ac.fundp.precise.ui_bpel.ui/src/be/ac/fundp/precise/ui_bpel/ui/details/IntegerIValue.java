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

import org.eclipse.bpel.common.ui.details.IValue;
import org.eclipse.swt.widgets.Text;

// TODO: Auto-generated Javadoc
/**
 * The Class IntegerIValue.
 *
 * @author Waldemar Pires
 * @date Jul 27, 2007
 */

public class IntegerIValue implements IValue {
	
	/** The widget. */
	Text fWidget;
	
	/** The number. */
	Integer number;
	
	/**
	 * Instantiates a new integer i value.
	 *
	 * @param fCreateInstanceButton the f create instance button
	 */
	public IntegerIValue ( Text fCreateInstanceButton ) {
		fWidget = fCreateInstanceButton;
	}

	/**
	 * Gets the.
	 *
	 * @return the object
	 * @see org.eclipse.bpel.common.ui.details.IValue#get()
	 */
	public Object get() {
		String numberString = fWidget.getText().trim();
		this.number = new Integer(Integer.parseInt(numberString));
		return this.number;
	}

	/**
	 * Sets the.
	 *
	 * @param text the text
	 * @see org.eclipse.bpel.common.ui.details.IValue#set(java.lang.Object)
	 */
	@SuppressWarnings("nls")
	public void set( Object text ) {
		if (text == null) {
			fWidget.setText("0");
		} else {
			fWidget.setText( text.toString() );
		}
	}
	
	
}
