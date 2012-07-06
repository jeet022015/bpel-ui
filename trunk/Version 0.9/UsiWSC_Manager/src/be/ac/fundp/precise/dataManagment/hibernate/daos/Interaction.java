package be.ac.fundp.precise.dataManagment.hibernate.daos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Interaction {

	@Id @GeneratedValue
	private int interactionRealId;
	
	private String interactionId;

	private String[] auiId = new String[0];

	public int getInteractionRealId() {
		return interactionRealId;
	}

	public void setInteractionRealId(int interactionRealId) {
		this.interactionRealId = interactionRealId;
	}

	public String getInteractionId() {
		return interactionId;
	}

	public void setInteractionId(String interactionId) {
		this.interactionId = interactionId;
	}

	public String[] getAuiId() {
		return auiId;
	}

	public void setAuiId(String[] auiId) {
		this.auiId = auiId;
	}
}
