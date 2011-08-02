package org.example.www.ui_bpel_mediator.logic.mediator;

import java.util.HashSet;
import java.util.Set;

public class UIComponent {

	protected Set <String> myDataInput = new HashSet<String>();
	protected Set <String> myDataOutput = new HashSet<String>();
	protected Set <String> myDataSelection = new HashSet<String>();
	
	public void addDataInput(String string) {
		myDataInput.add(string);
	}

	public void addDataOutput(String string) {
		myDataOutput.add(string);
	}

	public void addDataSelecion(String string) {
		myDataSelection.add(string);
	}

}
