package be.ac.fundp.precise.dataManagment.hibernate.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * The Class User.
 */
@Entity(name="PROCESSES")
public class Process {
	
	/** The process identification. */
	@Id
	private String processIdentification;

	/** The allowed role. */
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> allowedRole = new ArrayList<Role>();
	 
	/**
	 * Gets the Process Identification.
	 *
	 * @return the process identification
	 */
	public String getProcessIdentification() {
		return processIdentification;
	}
	
	/**
	 * Sets the process identification.
	 *
	 * @param processIdentification the process identification
	 */
	public void setProcessIdentification(String processIdentification) {
		this.processIdentification = processIdentification;
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

}
