package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core;

import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.CoordinationConfig;

public class AuiFactory {

	protected CoordinationConfig coordConfig = null;

	public AuiFactory () {
		
	}
	
	public AuiFactory (CoordinationConfig c) {
		coordConfig = c;
	}

	public AbstractUIModel createAbstractUIModel() {
		return new AbstractUIModel();
	}

}
