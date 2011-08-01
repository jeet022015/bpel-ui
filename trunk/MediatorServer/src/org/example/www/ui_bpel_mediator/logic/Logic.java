package org.example.www.ui_bpel_mediator.logic;

import org.example.www.ui_bpel_mediator.DataUIType;


public class Logic {
	
	protected static Logic instance;
	protected MediatorDataInputInteraction medInput;
	protected MediatorDataOutputInteraction medOutput;
	protected MediatorDataSelectionInteraction medSelection;
	
	
	protected Logic() {
		medInput = new MediatorDataInputInteraction ();
		medOutput = new MediatorDataOutputInteraction ();
		medSelection = new MediatorDataSelectionInteraction ();
	}

	public static Logic getInstance() {
		if (instance == null) {
			instance = new Logic();
		}
		return instance;
	}

	public void sendData(String id, DataUIType data) {
		medOutput.sendData(id, data);
	}

	public DataUIType getSelectionData(String id, DataUIType selectable) {
		return medSelection.getSelectionData(id, selectable);
	}

	public DataUIType getInputData(String id) {
		return medInput.getInputData(id);
	}

}
