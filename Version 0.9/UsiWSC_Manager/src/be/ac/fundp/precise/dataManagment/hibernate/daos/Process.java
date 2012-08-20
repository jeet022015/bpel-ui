package be.ac.fundp.precise.dataManagment.hibernate.daos;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Process represents a process in a hibernate DB.
 */
@Entity(name = "PROCESSES")
public class Process {

	/** The process real id. */
	@Id
	@GeneratedValue
	private int processRealId;

	/** The process id. */
	@Column(name="process_name", nullable=false)
	private String processId;

	/** The allowed role. */
	@OneToMany
	private Collection<Role> allowedRole = new ArrayList<Role>();
	
	/** The interactions. */
	@OneToMany
	private Collection<Interaction> interactions = new ArrayList<Interaction>();
	
	/** The instancies. */
	@OneToMany
	private Collection<ProcessInstance> instancies = new ArrayList<ProcessInstance>();

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
	 * Gets the allowed role.
	 *
	 * @return the allowed role
	 */
	public Collection<Role> getAllowedRole() {
		return allowedRole;
	}

	/**
	 * Sets the allowed role.
	 *
	 * @param allowedRole the new allowed role
	 */
	public void setAllowedRole(Collection<Role> allowedRole) {
		this.allowedRole = allowedRole;
	}

	/**
	 * Gets the process real id.
	 *
	 * @return the process real id
	 */
	public int getProcessRealId() {
		return processRealId;
	}

	/**
	 * Sets the process real id.
	 *
	 * @param processRealId the new process real id
	 */
	public void setProcessRealId(int processRealId) {
		this.processRealId = processRealId;
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
	 * Gets the instancies.
	 *
	 * @return the instancies
	 */
	public Collection<ProcessInstance> getInstancies() {
		return instancies;
	}

	/**
	 * Sets the instancies.
	 *
	 * @param instancies the new instancies
	 */
	public void setInstancies(Collection<ProcessInstance> instancies) {
		this.instancies = instancies;
	}
}
