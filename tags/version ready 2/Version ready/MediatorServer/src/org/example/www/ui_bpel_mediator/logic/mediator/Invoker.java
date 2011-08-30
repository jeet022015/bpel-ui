package org.example.www.ui_bpel_mediator.logic.mediator;

import org.example.www.ui_bpel_mediator.DataUIType;

public class Invoker {
	
	protected static Invoker self;
	
	protected Invoker(){
		
	}

	public static Invoker getInstance() {
		if(self==null)
			self = new Invoker();
		return self;
	}

	public DataFromCUI invokeAction(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public DataFromCUI invokeSelectAtc(String id, DataUIType selectable) {
		// TODO Auto-generated method stub
		return null;
	}

}
