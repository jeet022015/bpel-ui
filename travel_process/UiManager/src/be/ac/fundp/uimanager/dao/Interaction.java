package be.ac.fundp.uimanager.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 * The Class DataItem represents the user Interaction
 * in the data base.
 */
@Entity(name="INTERACTIONS")
public class Interaction {
	
	/** The interaction real id. */
	@Id @GeneratedValue
	private int interactionRealId;
	
	/** The interaction id. */
	private String interactionId;
	
	/** The is finished. */
	private boolean isFinished;
	
	/** The available data. */
	@OneToMany
	@JoinTable(name = "availableData", joinColumns = { @JoinColumn(name = "availableData_ID") })
	private Collection<DataItem> availableData = new ArrayList<DataItem>();
	
	/** The provided data. */
	@OneToMany
	@JoinTable(name = "providedData", joinColumns = { @JoinColumn(name = "providedData_ID") })
	private Collection<DataItem> providedData = new ArrayList<DataItem>();
	
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
	 * Checks if is finished.
	 *
	 * @return true, if is finished
	 */
	public boolean isFinished() {
		return isFinished;
	}
	
	/**
	 * Sets the finished.
	 *
	 * @param isFinished the new finished
	 */
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	
	/**
	 * Gets the available data.
	 *
	 * @return the available data
	 */
	public Collection<DataItem> getAvailableData() {
		return availableData;
	}
	
	/**
	 * Sets the available data.
	 *
	 * @param availableData the new available data
	 */
	public void setAvailableData(Collection<DataItem> availableData) {
		this.availableData = availableData;
	}
	
	/**
	 * Gets the provided data.
	 *
	 * @return the provided data
	 */
	public Collection<DataItem> getProvidedData() {
		return providedData;
	}
	
	/**
	 * Sets the provided data.
	 *
	 * @param providedData the new provided data
	 */
	public void setProvidedData(Collection<DataItem> providedData) {
		this.providedData = providedData;
	}
	
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
}
