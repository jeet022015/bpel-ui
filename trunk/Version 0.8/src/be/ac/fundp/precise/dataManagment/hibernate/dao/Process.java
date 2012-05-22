package be.ac.fundp.precise.dataManagment.hibernate.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Process represents the user Process
 * in the data base.
 */
@Entity(name="PROCESSES")
public class Process {
	
	/** The process id. */
	@Id
	private String processId;
	
	/** The is finished. */
	private boolean isFinished;
	
	/** The interactions. */
	@OneToMany(mappedBy="interactionRealId")
	private Collection<Interaction> interactions = new ArrayList<Interaction>();
	
	/** The process bind. */
	@OneToMany(mappedBy="processBindRealId", fetch = FetchType.EAGER)
	private Collection<ProcessBind> processBind =  new ArrayList<ProcessBind>();
	
	/**
	 * Gets the process id.
	 *
	 * @return the process id
	 */
	public String getProcessId() {
		return processId;
	}
	
	/**
	 * Sets the process id.
	 *
	 * @param processId the new process id
	 */
	public void setProcessId(String processId) {
		this.processId = processId;
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
	 * Gets the interactions.
	 *
	 * @return the interactions
	 */
	public Collection<Interaction> getInteractions() {
		return interactions;
	}
	
	/**
	 * Sets the interactions.
	 *
	 * @param interactions the new interactions
	 */
	public void setInteractions(Collection<Interaction> interactions) {
		this.interactions = interactions;
	}
	
	/**
	 * Gets the process bind.
	 *
	 * @return the process bind
	 */
	public Collection<ProcessBind> getProcessBind() {
		return processBind;
	}
	
	/**
	 * Sets the process bind.
	 *
	 * @param processBind the new process bind
	 */
	public void setProcessBind(Collection<ProcessBind> processBind) {
		this.processBind = processBind;
	}


}
