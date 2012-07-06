package be.ac.fundp.precise.dataManagment.hibernate.daos;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ProcessInstance {

	@Id
	private String processInstanceId;

	@OneToOne
	@JoinColumn(name="own_process", nullable=false)
	private Process ownProcess;
	
	/** The is finished. */
	@Column(name="finished", nullable=false)
	private Boolean isFinished;
	
	@OneToMany
	private Collection<BindingProcess> processBinding = new ArrayList<BindingProcess>();
	
	@OneToMany
	private Collection<DataItem> dataProvided = new ArrayList<DataItem>();

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public Boolean isFinished() {
		return isFinished;
	}

	public void setFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}

	public Collection<BindingProcess> getProcessBinding() {
		return processBinding;
	}

	public void setProcessBinding(Collection<BindingProcess> processBinding) {
		this.processBinding = processBinding;
	}

	public Collection<DataItem> getDataProvided() {
		return dataProvided;
	}

	public void setDataProvided(Collection<DataItem> dataProvided) {
		this.dataProvided = dataProvided;
	}

	public Process getOwnProcess() {
		return ownProcess;
	}

	public void setOwnProcess(Process ownProcess) {
		this.ownProcess = ownProcess;
	}
	
	
}
