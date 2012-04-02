package be.ac.fundp.uimanager.dao;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "PROCESS_BIND")
public class ProcessBind {

	@Embeddable
	public static class ProcessBindIdClass implements Serializable{

		private static final long serialVersionUID = 6737546483463172041L;
		
		@JoinColumn(name = "process_id")
		//@OneToOne(mappedBy="processId")
		@ManyToOne
		private Process process;

		@JoinColumn(name = "role_id")
		//@OneToOne(mappedBy="roleId")
		@ManyToOne
		private Role role;

		public Process getProcess() {
			return process;
		}

		public void setProcess(Process process) {
			this.process = process;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

	}

	@EmbeddedId
	private ProcessBindIdClass id = new ProcessBindIdClass();
	@GeneratedValue
	private int realId;
	@OneToOne
	private User user;

	public ProcessBindIdClass getId() {
		return id;
	}

	public void setId(ProcessBindIdClass id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRealId() {
		return realId;
	}

	public void setRealId(int realId) {
		this.realId = realId;
	}

}
