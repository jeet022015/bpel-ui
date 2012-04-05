package be.ac.fundp.uimanager.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Role represents the user Role
 * in the data base.
 */
@Entity(name="ROLES")
public class Role {
	
	/** The role id. */
	@Id
	private String roleId;

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

}
