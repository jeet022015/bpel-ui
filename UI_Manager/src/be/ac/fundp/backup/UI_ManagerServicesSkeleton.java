/**
 * UI_ManagerServicesSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package be.ac.fundp.backup;

import be.ac.fundp.InputOperationResponse;
import be.ac.fundp.SelectionOperationResponse;
import be.ac.fundp.communication.Dispatcher;

/**
 * UI_ManagerServicesSkeleton java skeleton for the axisService
 */
public class UI_ManagerServicesSkeleton {

	protected Dispatcher clientDispatcher = Dispatcher.getInstance();
	/**
	 * Auto generated method signature
	 * 
	 * @param outputOperation
	 * @return
	 */

	public void outputOperation(final be.ac.fundp.OutputOperation outputOperation) {
		Runnable r1 = new Runnable() {
			public void run() {
				clientDispatcher.dispatchOutputOp(outputOperation.getId(), outputOperation.getData());
			}
		};

		Thread t = new Thread(r1);
		t.start();
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param inputOperation
	 * @return inputOperationResponse
	 */

	public be.ac.fundp.InputOperationResponse inputOperation(
			be.ac.fundp.InputOperation inputOperation) {
		InputOperationResponse i = clientDispatcher.dispatchInputOp(inputOperation.getId());
		return i;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param selectionOperation
	 * @return selectionOperationResponse
	 */

	public be.ac.fundp.SelectionOperationResponse selectionOperation(
			be.ac.fundp.SelectionOperation selectionOperation) {
		SelectionOperationResponse i = clientDispatcher.dispatchSelectionOp(selectionOperation.getId(), selectionOperation.getData());
		System.out.println("and here?");
		return i;
	}

}
