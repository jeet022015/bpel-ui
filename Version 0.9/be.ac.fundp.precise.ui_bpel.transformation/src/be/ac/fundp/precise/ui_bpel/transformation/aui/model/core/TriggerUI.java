package be.ac.fundp.precise.ui_bpel.transformation.aui.model.core;

/**
 * This class represents any element in the AUI that can change the state of the UI.
 * In this class has the same meaning of AbstractTriggerIU (in UsiXML), Control Interactor
 * (in MARIA). This element is implicit in AUI MDE approach.   
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class TriggerUI extends InteractionUnit{

	/** The id of the trigger. */
	protected String id = "";
	
	/**
	 * This method gets the id of the trigger.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

}
