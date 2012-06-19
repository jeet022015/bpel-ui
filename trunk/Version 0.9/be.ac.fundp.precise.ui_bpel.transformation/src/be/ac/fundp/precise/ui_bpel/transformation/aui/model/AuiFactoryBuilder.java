package be.ac.fundp.precise.ui_bpel.transformation.aui.model;

import be.ac.fundp.precise.ui_bpel.transformation.aui.model.core.AuiFactory;


// TODO: Auto-generated Javadoc
/**
 * The Class AuiFactoryBuilder.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class AuiFactoryBuilder {

	/**
	 * New aui factory.
	 *
	 * @return the aui factory
	 */
	static public AuiFactory newAuiFactory(){
		return new AuiFactory();
	}
	
	/**
	 * New aui factory.
	 *
	 * @param c the c
	 * @return the aui factory
	 */
	static public AuiFactory newAuiFactory(CoordinationConfig c){
		return new AuiFactory(c);
	}
}
