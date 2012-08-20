package be.ac.fundp.precise.dataManagment.hibernate.daos;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * The Class ProcessInstance represents a process instance in the hibernate DB.
 */
@Entity
public class ProcessInstance {

	/** The process instance id. */
	@Id
	private String processInstanceId;

	/** The own process. */
	@OneToOne
	@JoinColumn(name="own_process", nullable=false)
	private Process ownProcess;
	
	/** The is finished. */
	@Column(name="finished", nullable=false)
	private Boolean isFinished;
	
	/** The process binding. */
	@OneToMany
	private Collection<BindingProcess> processBinding = new ArrayList<BindingProcess>();
	
	/** The data provided. */
	@OneToMany
	private Collection<DataItem> dataProvided = new ArrayList<DataItem>();

	/**
	 * Gets the process instance id.
	 *
	 * @return the process instance id
	 */
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	/**
	 * Sets the process instance id.
	 *
	 * @param processInstanceId the new process instance id
	 */
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	/**
	 * Checks if is finished.
	 *
	 * @return the boolean
	 */
	public Boolean isFinished() {
		return isFinished;
	}

	/**
	 * Sets the finished.
	 *
	 * @param isFinished the new finished
	 */
	public void setFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}

	/**
	 * Gets the process binding.
	 *
	 * @return the process binding
	 */
	public Collection<BindingProcess> getProcessBinding() {
		return processBinding;
	}

	/**
	 * Sets the process binding.
	 *
	 * @param processBinding the new process binding
	 */
	public void setProcessBinding(Collection<BindingProcess> processBinding) {
		this.processBinding = processBinding;
	}

	/**
	 * Gets the data provided.
	 *
	 * @return the data provided
	 */
	public Collection<DataItem> getDataProvided() {
		return dataProvided;
	}

	/**
	 * Sets the data provided.
	 *
	 * @param dataProvided the new data provided
	 */
	public void setDataProvided(Collection<DataItem> dataProvided) {
		this.dataProvided = dataProvided;
	}

	/**
	 * Gets the own process.
	 *
	 * @return the own process
	 */
	public Process getOwnProcess() {
		return ownProcess;
	}

	/**
	 * Sets the own process.
	 *
	 * @param ownProcess the new own process
	 */
	public void setOwnProcess(Process ownProcess) {
		this.ownProcess = ownProcess;
	}
	
	
}
