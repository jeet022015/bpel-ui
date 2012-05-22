package be.ac.fundp.precise.dataManagment.model;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Process.
 */
public class Process {
	
	/** The id. */
	protected String id;
	
	/** The type. */
	protected String type;
	
	/** The role. */
	protected String role;
	
	/** The inner interactions. */
	protected List<UserInteraction> innerInteractions = new LinkedList<UserInteraction>();
	
	/** The process counter. */
	static int processCounter = 1;
	
	/** The displayable id. */
	protected String displayableId;
	
	/**
	 * Instantiates a new process.
	 *
	 * @param processId the process id
	 */
	public Process (String processId, String role, String type){
		this.role = role;
		id = processId;
		this.type = type;
		displayableId = "Trip "+ processCounter++;
	}
	
	/**
	 * Gets the pending interactions.
	 *
	 * @return the pending interactions
	 */
	public List<UserInteraction> getPendingInteractions(){
		List<UserInteraction> interacDone = new LinkedList<UserInteraction>();
		for (UserInteraction aUserInteraction : innerInteractions) {
			if (!aUserInteraction.isDone()){
				interacDone.add(aUserInteraction);
			}
		}
		return interacDone;
	}

	/**
	 * Checks if is finisehd.
	 *
	 * @return true, if is finisehd
	 */
	public boolean isFinisehd() {
		return true;
	}

	/**
	 * Gets the displayable name.
	 *
	 * @return the displayable name
	 */
	public String getDisplayableName() {
		return displayableId;
	}

	/**
	 * Adds the user interaction.
	 *
	 * @param cuiId the cui id
	 * @param data the data
	 * @return the user interaction
	 * @throws JSONException the jSON exception
	 */
	public synchronized UserInteraction addUserInteraction(String cuiId, JSONArray data) throws JSONException {
		UserInteraction innerInterac = getUserInteraction(cuiId);
		if (innerInterac != null)
			return innerInterac;
		innerInterac = new UserInteraction(this, role, cuiId);
		
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
		System.out.println("for the process="+id);
		return innerInterac;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Gets the user interactions.
	 *
	 * @return the user interactions
	 */
	public List<UserInteraction> getUserInteractions(){
		return innerInteractions;
	}

	/**
	 * Gets the user interaction.
	 *
	 * @param uiId the ui id
	 * @return the user interaction
	 */
	public UserInteraction getUserInteraction(String uiId) {
		for (UserInteraction aUserInteraction : innerInteractions) {
			if (aUserInteraction.getId().equals(uiId)){
				return aUserInteraction;
			}
		}
		return null;
	}

	/**
	 * Delete pending int.
	 */
	public void deletePendingInt() {
		innerInteractions.removeAll(getPendingInteractions());
	}

	/**
	 * Adds the user interaction.
	 *
	 * @param cuiId the cui id
	 */
	public void addUserInteraction(String cuiId) {
		try {
			addUserInteraction(cuiId, null);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public String getType() {
		return type;
	}
	
	public void setType(String newType) {
		type = newType;
	}

}
