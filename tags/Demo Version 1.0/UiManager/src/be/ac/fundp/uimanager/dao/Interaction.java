package be.ac.fundp.uimanager.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name="INTERACTIONS")
public class Interaction {
	
	@Id @GeneratedValue
	private int interactionRealId;
	private String interactionId;
	private boolean isFinished;
	@OneToMany
	@JoinTable(name = "availableData", joinColumns = { @JoinColumn(name = "availableData_ID") })
	private Collection<DataItem> availableData = new ArrayList<DataItem>();
	@OneToMany
	@JoinTable(name = "providedData", joinColumns = { @JoinColumn(name = "providedData_ID") })
	private Collection<DataItem> providedData = new ArrayList<DataItem>();
	
	public String getInteractionId() {
		return interactionId;
	}
	public void setInteractionId(String interactionId) {
		this.interactionId = interactionId;
	}
	public boolean isFinished() {
		return isFinished;
	}
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	public Collection<DataItem> getAvailableData() {
		return availableData;
	}
	public void setAvailableData(Collection<DataItem> availableData) {
		this.availableData = availableData;
	}
	public Collection<DataItem> getProvidedData() {
		return providedData;
	}
	public void setProvidedData(Collection<DataItem> providedData) {
		this.providedData = providedData;
	}
	public int getInteractionRealId() {
		return interactionRealId;
	}
	public void setInteractionRealId(int interactionRealId) {
		this.interactionRealId = interactionRealId;
	}
}
