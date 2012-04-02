package be.ac.fundp.uimanager.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="PROCESSES")
public class Process {
	
	@Id
	private String processId;
	private boolean isFinished;
	@OneToMany(mappedBy="interactionRealId")
	private Collection<Interaction> interactions = new ArrayList<Interaction>();
	@OneToMany(mappedBy="processBindRealId", fetch = FetchType.EAGER)
	private Collection<ProcessBind> processBind =  new ArrayList<ProcessBind>();
	
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public boolean isFinished() {
		return isFinished;
	}
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	public Collection<Interaction> getInteractions() {
		return interactions;
	}
	public void setInteractions(Collection<Interaction> interactions) {
		this.interactions = interactions;
	}
	public Collection<ProcessBind> getProcessBind() {
		return processBind;
	}
	public void setProcessBind(Collection<ProcessBind> processBind) {
		this.processBind = processBind;
	}


}
