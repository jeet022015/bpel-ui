package be.ac.fundp.precise.uibpel.representation;

import java.util.HashMap;
import java.util.Map;

public class UserInteraction {
	
	private String uiId;
	private int uniaueId;
	private boolean done;
	private int idGen = 0;
	protected Map<String, String> displayName = new HashMap<String, String>(); 

	public UserInteraction(String id){
		this.uiId = id;
		uniaueId = newUniqueId();
		done = false;
		displayName.put("4", "Provide Order Data");
		displayName.put("7", "Initial Price");
		displayName.put("6", "Select Payment Method");
		displayName.put("8", "Receipt");
	}
	
	public String getId(){
		return uiId;
	}
	
	private int newUniqueId() {
		return idGen++;
	}

	public void setDone(){
		done = true;
	}
	
	public boolean isDone(){
		return done;
	}

	public CharSequence getDisplayName() {
		if (displayName.containsKey(uiId))
			return displayName.get(uiId);
		return "User Interaction";
	}

}
