package be.ac.fundp.precise.ui_bpel.ui.transformation.deployment;

/**
 * The Class ConfigurationException is through when the process flight was
 * not well formated.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class ConfigurationException extends Exception{

	/** serial Version UID. */
	private static final long serialVersionUID = 1L;
	
	String confErrorMessage;

	public void setConfMessage(String confErrorMessage) {
		this.confErrorMessage = confErrorMessage;
	}
	
	public String getConfMessage() {
		return confErrorMessage;
	}

}
