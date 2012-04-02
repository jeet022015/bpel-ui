package be.ac.fundp.uimanager.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ROLES")
public class Role {
	
	@Id
	private String roleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
