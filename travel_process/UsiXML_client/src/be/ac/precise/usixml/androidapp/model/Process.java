package be.ac.precise.usixml.androidapp.model;

import java.util.LinkedList;
import java.util.List;

public class Process {

	protected String id;
	protected List<UserInteraction> innerInteractions = new LinkedList<UserInteraction>();
	
	public Process (String processId){
		id = processId;
	}
	
	public boolean hasPendingAct() {
		for (UserInteraction innerInter : innerInteractions) {
			if (!innerInter.isDone()) {
				return true;
			}
		}
		return false;
	}

	public boolean isFinisehd() {
		return true;
	}

	public String getDisplayableName() {
		return id;
	}

	public UserInteraction addUserInteraction(String cuiId) {
		UserInteraction innerInterac = getUserInteraction(cuiId);
		if (innerInterac != null)
			return innerInterac;
		innerInterac = new UserInteraction(cuiId);
		innerInteractions.add(innerInterac);
		return innerInterac;
	}

	public String getId() {
		return id;
	}
	
	public List<UserInteraction> getUserInteractions(){
		return innerInteractions;
	}

	public UserInteraction getUserInteraction(String uiId) {
		for (UserInteraction aUserInteraction : innerInteractions) {
			if (aUserInteraction.getId().equals(uiId))
				return aUserInteraction;
		}
		return null;
	}

	public void deletePendingInt() {
		List<UserInteraction> interacDone = new LinkedList<UserInteraction>();
		for (UserInteraction aUserInteraction : innerInteractions) {
			if (!aUserInteraction.isDone())
				interacDone.add(aUserInteraction);
		}
		innerInteractions.removeAll(interacDone);
	}

}
