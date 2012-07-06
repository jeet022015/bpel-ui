package be.ac.fundp.precise.dataManagment.hibernate.daos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="BindingProcess")
public class BindingProcess {

	/** The process real id. */
	@Id
	@GeneratedValue
	private int processRealId;

	@OneToOne
	@JoinColumn(name="process_instance", nullable=false)
	private ProcessInstance processInstance;

	@OneToOne
	@JoinColumn(name="bond_role", nullable=false)
	private Role role;

	@OneToOne
	@JoinColumn(name="bond_user", nullable=false)
	private User user;
	
	@OneToOne
	@JoinColumn(name="registred_process", nullable=false)
	private RegistredProcess registredProcess;

	public ProcessInstance getProcessInstance() {
		return processInstance;
	}

	public void setProcessInstance(ProcessInstance process) {
		this.processInstance = process;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getProcessRealId() {
		return processRealId;
	}

	public void setProcessRealId(int processRealId) {
		this.processRealId = processRealId;
	}

	public RegistredProcess getRegistredProcess() {
		return registredProcess;
	}

	public void setRegistredProcess(RegistredProcess registredProcess) {
		this.registredProcess = registredProcess;
	}
}
