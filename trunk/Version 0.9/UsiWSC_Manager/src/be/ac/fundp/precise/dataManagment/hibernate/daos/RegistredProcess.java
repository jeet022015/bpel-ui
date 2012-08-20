package be.ac.fundp.precise.dataManagment.hibernate.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * The Class RegistredProcess represents a Registred Process in a hibernate DB.
 */
@Entity(name="RegistredProcess")
public class RegistredProcess {

	/** The registred process id. */
	@Id
	@GeneratedValue
	private int registredProcessId;

	/** The bound process. */
	@OneToOne
	@JoinColumn(name="inner_process", nullable=false)
	private Process boundProcess;

	/** The role. */
	@OneToOne
	@JoinColumn(name="registred_role", nullable=false)
	private Role role;
	
	/** The owner user. */
	@OneToOne
	@JoinColumn(name="own_user", nullable=false)
	private User ownerUser;
	
	/** The available. */
	@Column(name="available", nullable=false)
	private Boolean available;

	/**
	 * Gets the bound processe.
	 *
	 * @return the bound processe
	 */
	public Process getBoundProcesse() {
		return boundProcess;
	}

	/**
	 * Sets the bound process.
	 *
	 * @param boundProcess the new bound process
	 */
	public void setBoundProcess(Process boundProcess) {
		this.boundProcess = boundProcess;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return ownerUser;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.ownerUser = user;
	}

	/**
	 * Gets the registred process id.
	 *
	 * @return the registred process id
	 */
	public int getRegistredProcessId() {
		return registredProcessId;
	}

	/**
	 * Sets the registred process id.
	 *
	 * @param processRealId the new registred process id
	 */
	public void setRegistredProcessId(int processRealId) {
		this.registredProcessId = processRealId;
	}

	/**
	 * Gets the available.
	 *
	 * @return the available
	 */
	public Boolean getAvailable() {
		return available;
	}

	/**
	 * Sets the available.
	 *
	 * @param available the new available
	 */
	public void setAvailable(Boolean available) {
		this.available = available;
	}
}
