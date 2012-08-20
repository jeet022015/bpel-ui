package be.ac.fundp.precise.dataManagment.hibernate.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Class Role represents a role in a hibernate DB.
 */
@Entity(name="ROLES")
public class Role {

	/** The role id. */
	@Column(name="role_name", nullable=false)
	private String roleId;

	/** The role real id. */
	@Id
	@GeneratedValue
	private int roleRealId;

	/** The startable. */
private Boolean startable;

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the role real id.
	 *
	 * @return the role real id
	 */
	public int getRoleRealId() {
		return roleRealId;
	}

	/**
	 * Sets the role real id.
	 *
	 * @param roleRealId the new role real id
	 */
	public void setRoleRealId(int roleRealId) {
		this.roleRealId = roleRealId;
	}

	/**
	 * Gets the startable.
	 *
	 * @return the startable
	 */
	public Boolean getStartable() {
		return startable;
	}

	/**
	 * Sets the startable.
	 *
	 * @param startable the new startable
	 */
	public void setStartable(Boolean startable) {
		this.startable = startable;
	}}
