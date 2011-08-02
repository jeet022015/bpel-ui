package org.example.www.ui_bpel_mediator.logic;

import org.example.www.ui_bpel_mediator.DataUIType;
import org.example.www.ui_bpel_mediator.logic.mediator.DataFromCUI;


public class Logic {
	
	protected static Logic instance;
	protected AUI_Communicator mediator = AUI_Communicator.getInstance();
	
	
	protected Logic() {
	}

	public static Logic getInstance() {
		if (instance == null) {
			instance = new Logic();
		}
		return instance;
	}

	public void sendData(String id, DataUIType data) {
		mediator.sendData(id, data);
	}

	public DataUIType getSelectionData(String id, DataUIType selectable) {
		DataFromCUI receiveData = mediator.receiveSelectedData(id, selectable);
		DataUIType data = parser(receiveData);
		return data;
	}

	public DataUIType getInputData(String id) {
		DataFromCUI receiveData = mediator.receiveInputData(id);
		DataUIType data = parser(receiveData);
		return data;
	}

	private DataUIType parser(DataFromCUI receiveData) {
		// TODO Auto-generated method stub
		return null;
	}

}
