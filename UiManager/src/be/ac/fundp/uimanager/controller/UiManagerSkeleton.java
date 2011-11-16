/**
 * UiManagerSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package be.ac.fundp.uimanager.controller;

import be.ac.fundp.ClientDispacherSelector;
import be.ac.fundp.UiManagerUtil;
import be.ac.fundp.uimanager.GenerateProcessIdResponse;
import be.ac.fundp.uimanager.InputOperationResponse;
import be.ac.fundp.uimanager.SelectionOperationResponse;
import be.ac.fundp.uimanager.client.Dispatcher;

/**
 * UiManagerSkeleton java skeleton for the axisService
 */
public class UiManagerSkeleton {

	protected ClientDispacherSelector clientSelector = ClientDispacherSelector.getInstance();
	/**
	 * Auto generated method signature
	 * 
	 * @param inputOperation
	 * @return inputOperationResponse
	 */

	public be.ac.fundp.uimanager.InputOperationResponse inputOperation(
			be.ac.fundp.uimanager.InputOperation inputOperation) {
		System.out.println("inputOperation - begin");
		Dispatcher clientDisp = clientSelector.getDispacher(inputOperation.getRole()); 
			
		InputOperationResponse response = clientDisp.requireInputInteracion
					(inputOperation.getProcessId(), inputOperation.getUserInteracId(), inputOperation.getRole());
		System.out.println("inputOperation - end");
		return response;
		
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param selectionOperation
	 * @return selectionOperationResponse
	 */

	public be.ac.fundp.uimanager.SelectionOperationResponse selectionOperation(
			be.ac.fundp.uimanager.SelectionOperation selectionOperation) {
		System.out.println("SelectionOperation - begin");
		Dispatcher clientDisp = clientSelector.getDispacher(selectionOperation.getRole()); 
			
		SelectionOperationResponse response = clientDisp.requireSelectionInteracion
					(selectionOperation.getProcessId(), selectionOperation.getUserInteracId(), 
					 selectionOperation.getData(), selectionOperation.getRole());
		System.out.println("SelectionOperation - end");;
		return response;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param outputOperation
	 * @return
	 */

	public void outputOperation(
			be.ac.fundp.uimanager.OutputOperation outputOperation) {
		System.out.println("outputOperation - begin");
		Dispatcher clientDisp = clientSelector.getDispacher(outputOperation.getRole()); 
		clientDisp.requireOutputInteracion (outputOperation.getProcessid(),
				outputOperation.getUserInteracId(), outputOperation.getData(),
				outputOperation.getRole());
		System.out.println("outputOperation - end");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param generateProcessId
	 * @return generateProcessIdResponse
	 */

	public be.ac.fundp.uimanager.GenerateProcessIdResponse generateProcessId(
			be.ac.fundp.uimanager.GenerateProcessId generateProcessId) {
		System.out.println("generateProcessId - begin");
		GenerateProcessIdResponse genResp = new GenerateProcessIdResponse();
		genResp.setProcessId(UiManagerUtil.generateId());
		System.out.println("generateProcessId - end");
		return genResp;
	}

}
