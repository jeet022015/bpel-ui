/**
 * UI_BPELMediatorSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.4  Built on : Dec 19, 2010 (08:18:42 CET)
 */
package org.example.www.ui_bpel_mediator;

import org.example.www.ui_bpel_mediator.logic.Logic;

/**
 * UI_BPELMediatorSkeleton java skeleton for the axisService
 */
public class UI_BPELMediatorSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @param eventDataUI
	 */

	public void eventDataUI(
			org.example.www.ui_bpel_mediator.EventDataUI eventDataUI) {
		// TODO : fill this with the necessary business logic

	}

	/**
	 * Auto generated method signature
	 * 
	 * @param dataOutputUI
	 */

	public void dataOutputUI(
			org.example.www.ui_bpel_mediator.DataOutputUI dataOutputUI) {
		String id = dataOutputUI.getAuiID();
		Logic l = Logic.getInstance();
		l.sendData (id, dataOutputUI.getData());
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param dataSelectionUI
	 */

	public org.example.www.ui_bpel_mediator.DataSelectionUIResponse dataSelectionUI(
			org.example.www.ui_bpel_mediator.DataSelectionUI dataSelectionUI) {
		DataSelectionUIResponse d = new DataSelectionUIResponse();
		String id = dataSelectionUI.getAuiID();
		Logic l = Logic.getInstance();
		DataUIType data = l.getSelectionData (id, dataSelectionUI.getSelectable());
		data.setBooleanUIData(null);
		d.setSelected(data);
		return d;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param dataInputUI
	 */

	public org.example.www.ui_bpel_mediator.DataInputUIResponse dataInputUI(
			org.example.www.ui_bpel_mediator.DataInputUI dataInputUI) {
		DataInputUIResponse d = new DataInputUIResponse();
		String id = dataInputUI.getAuiID();
		Logic l = Logic.getInstance();
		DataUIType data = l.getInputData (id);
		data.setBooleanUIData(null);
		d.setData(data);
		return d;
	}

}
