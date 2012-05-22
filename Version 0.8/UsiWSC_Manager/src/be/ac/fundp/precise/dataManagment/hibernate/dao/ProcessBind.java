package be.ac.fundp.precise.dataManagment.hibernate.dao;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * The Class ProcessBind represents the ProcessBind
 * in the data base.
 */
@Entity(name = "PROCESS_BIND")
public class ProcessBind {
	
	/**
	 * The Class ProcessBindIdClass.
	 */
	@Embeddable
	public static class ProcessBindIdClass implements Serializable{

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 6737546483463172041L;
		
		/** The process. */
		@JoinColumn(name = "process_id")
		//@OneToOne(mappedBy="processId")
		@ManyToOne
		private Process process;

		/** The role. */
		@JoinColumn(name = "role_id")
		//@OneToOne(mappedBy="roleId")
		@ManyToOne
		private Role role;

		/**
		 * Gets the process.
		 *
		 * @return the process
		 */
		public Process getProcess() {
			return process;
		}

		/**
		 * Sets the process.
		 *
		 * @param process the new process
		 */
		public void setProcess(Process process) {
			this.process = process;
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

	}

	/** The id. */
	@Embedded
	private ProcessBindIdClass id = new ProcessBindIdClass();
	
	/** The process bind real id. */
	@Id
	@GeneratedValue
	private int processBindRealId;
	
	/** The user. */
	@OneToOne
	private User user;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public ProcessBindIdClass getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(ProcessBindIdClass id) {
		this.id = id;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the process bind real id.
	 *
	 * @return the process bind real id
	 */
	public int getProcessBindRealId() {
		return processBindRealId;
	}

	/**
	 * Sets the process bind real id.
	 *
	 * @param processBindRealId the new process bind real id
	 */
	public void setProcessBindRealId(int processBindRealId) {
		this.processBindRealId = processBindRealId;
	}
}
