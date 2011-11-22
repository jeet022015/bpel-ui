package be.ac.fundp.precise.uibpel.representation;

import java.util.LinkedList;
import java.util.List;

public class Process {
	protected String name;
	protected List<UserInteraction> userInteractions = new LinkedList<UserInteraction>();
	protected boolean isFinshed;
	
	public Process(String name){
		System.out.println("process name = "+ name);
		this.name = name;
		isFinshed = false;
	}
	
	public String getName(){
		return name;
	}
	
	public List<UserInteraction> getUserInteractions(){
		return userInteractions;
	}
	
	public void addUserInteraction(String cui){
		UserInteraction ui = new UserInteraction(cui);
		userInteractions.add(ui);
		if (cui.startsWith("8"))
			isFinshed = true;
	}
	
	public void performUI(String cui){
		for (UserInteraction innerUI : userInteractions) {
			if (innerUI.getId().startsWith(cui)){
				innerUI.setDone();
				return;
			}
		}
	}
	
	public boolean isFinisehd(){
		return isFinshed;
	}

	public boolean hasUndoneAct() {
		for (UserInteraction ui : userInteractions) {
			if (!ui.isDone())
				return true;
		}
		return false;
	}

}
