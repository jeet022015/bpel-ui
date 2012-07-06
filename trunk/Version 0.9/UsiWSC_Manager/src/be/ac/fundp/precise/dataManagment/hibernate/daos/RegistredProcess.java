package be.ac.fundp.precise.dataManagment.hibernate.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="RegistredProcess")
public class RegistredProcess {

	@Id
	@GeneratedValue
	private int registredProcessId;

	@OneToOne
	@JoinColumn(name="inner_process", nullable=false)
	private Process boundProcess;

	@OneToOne
	@JoinColumn(name="registred_role", nullable=false)
	private Role role;
	
	@OneToOne
	@JoinColumn(name="own_user", nullable=false)
	private User ownerUser;
	
	@Column(name="available", nullable=false)
	private Boolean available;

	public Process getBoundProcesse() {
		return boundProcess;
	}

	public void setBoundProcess(Process boundProcess) {
		this.boundProcess = boundProcess;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return ownerUser;
	}

	public void setUser(User user) {
		this.ownerUser = user;
	}

	public int getRegistredProcessId() {
		return registredProcessId;
	}

	public void setRegistredProcessId(int processRealId) {
		this.registredProcessId = processRealId;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
}
