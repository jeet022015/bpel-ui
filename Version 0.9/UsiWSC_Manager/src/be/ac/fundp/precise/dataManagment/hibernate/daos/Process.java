package be.ac.fundp.precise.dataManagment.hibernate.daos;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "PROCESSES")
public class Process {

	@Id
	@GeneratedValue
	private int processRealId;

	@Column(name="process_name", nullable=false)
	private String processId;

	@OneToMany
	private Collection<Role> allowedRole = new ArrayList<Role>();
	
	@OneToMany
	private Collection<Interaction> interactions = new ArrayList<Interaction>();
	
	@OneToMany
	private Collection<ProcessInstance> instancies = new ArrayList<ProcessInstance>();

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public Collection<Role> getAllowedRole() {
		return allowedRole;
	}

	public void setAllowedRole(Collection<Role> allowedRole) {
		this.allowedRole = allowedRole;
	}

	public int getProcessRealId() {
		return processRealId;
	}

	public void setProcessRealId(int processRealId) {
		this.processRealId = processRealId;
	}

	public Collection<Interaction> getInteractions() {
		return interactions;
	}

	public void setInteractions(Collection<Interaction> interactions) {
		this.interactions = interactions;
	}

	public Collection<ProcessInstance> getInstancies() {
		return instancies;
	}

	public void setInstancies(Collection<ProcessInstance> instancies) {
		this.instancies = instancies;
	}
}
