package be.ac.fundp.precise.dataManagment.hibernate.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="ROLES")
public class Role {

	@Column(name="role_name", nullable=false)
	private String roleId;

	@Id
	@GeneratedValue
	private int roleRealId;
	
//	@ManyToOne
//	@JoinColumn(name = "joinColumn", nullable = false)
//	private Process owningProcess;

	private Boolean startable;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public int getRoleRealId() {
		return roleRealId;
	}

	public void setRoleRealId(int roleRealId) {
		this.roleRealId = roleRealId;
	}

	public Boolean getStartable() {
		return startable;
	}

	public void setStartable(Boolean startable) {
		this.startable = startable;
	}
//
//	public Process getOwningProcess() {
//		return owningProcess;
//	}
//
//	public void setOwningProcess(Process owningProcess) {
//		this.owningProcess = owningProcess;
//	}
}
