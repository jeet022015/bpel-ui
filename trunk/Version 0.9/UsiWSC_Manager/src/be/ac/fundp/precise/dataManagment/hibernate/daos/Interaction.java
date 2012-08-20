package be.ac.fundp.precise.dataManagment.hibernate.daos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Class Interaction represents an interaction in a hibernate DB.
 */
@Entity
public class Interaction {

	/** The interaction real id. */
	@Id @GeneratedValue
	private int interactionRealId;
	
	/** The interaction id. */
	private String interactionId;

	/** The aui id. */
	private String[] auiId = new String[0];

	/**
	 * Gets the interaction real id.
	 *
	 * @return the interaction real id
	 */
	public int getInteractionRealId() {
		return interactionRealId;
	}

	/**
	 * Sets the interaction real id.
	 *
	 * @param interactionRealId the new interaction real id
	 */
	public void setInteractionRealId(int interactionRealId) {
		this.interactionRealId = interactionRealId;
	}

	/**
	 * Gets the interaction id.
	 *
	 * @return the interaction id
	 */
	public String getInteractionId() {
		return interactionId;
	}

	/**
	 * Sets the interaction id.
	 *
	 * @param interactionId the new interaction id
	 */
	public void setInteractionId(String interactionId) {
		this.interactionId = interactionId;
	}

	/**
	 * Gets the aui id.
	 *
	 * @return the aui id
	 */
	public String[] getAuiId() {
		return auiId;
	}

	/**
	 * Sets the aui id.
	 *
	 * @param auiId the new aui id
	 */
	public void setAuiId(String[] auiId) {
		this.auiId = auiId;
	}
}
