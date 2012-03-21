package be.ac.fundp.usiwsc.webapp.model;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Process {
	
	protected String id;
	protected List<UserInteraction> innerInteractions = new LinkedList<UserInteraction>();
	
	public Process (String processId){
		id = processId;
	}
	
	public List<UserInteraction> getPendingInteractions(){
		List<UserInteraction> interacDone = new LinkedList<UserInteraction>();
		System.out.println("heeeree");
		for (UserInteraction aUserInteraction : innerInteractions) {
			System.out.println("aUserInteraction="+aUserInteraction.getDisplayableName());
			if (!aUserInteraction.isDone()){
				System.out.println("pending="+aUserInteraction.getDisplayableName());
				interacDone.add(aUserInteraction);
			}
		}
		return interacDone;
	}

	public boolean isFinisehd() {
		return true;
	}

	public String getDisplayableName() {
		return id;
	}

	public synchronized UserInteraction addUserInteraction(String cuiId, JSONArray data) throws JSONException {
		UserInteraction innerInterac = getUserInteraction(cuiId);
		if (innerInterac != null)
			return innerInterac;
		innerInterac = new UserInteraction(cuiId);
		
		if (data != null){
			for (int i = 0; i < data.length(); i++) {
				JSONObject aData = data.getJSONObject(i);
				String id = aData.getString("id");
				String type = aData.getString("type");
				Object content = aData.get("content");
				innerInterac.addAvailableData(id, type, content);
			}
		}
		
		innerInteractions.add(innerInterac);
		System.out.println("created ui="+cuiId);
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
			if (aUserInteraction.getId().equals(uiId)){
				return aUserInteraction;
			}
		}
		return null;
	}

	public void deletePendingInt() {
		innerInteractions.removeAll(getPendingInteractions());
	}

	public void addUserInteraction(String cuiId) {
		try {
			addUserInteraction(cuiId, null);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
