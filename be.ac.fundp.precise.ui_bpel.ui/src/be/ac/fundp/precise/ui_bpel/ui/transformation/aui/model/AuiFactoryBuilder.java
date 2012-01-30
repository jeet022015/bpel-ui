package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model;

import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.AuiFactory;


public class AuiFactoryBuilder {

	static public AuiFactory newAuiFactory(){
		return new AuiFactory();
	}
	
	static public AuiFactory newAuiFactory(CoordinationConfig c){
		return new AuiFactory(c);
	}
}
