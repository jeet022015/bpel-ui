package be.ac.fundp.usiwsc.webapp.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserInteraction {

	private Map<String, UserInterDesc> availableData = new HashMap<String, UserInterDesc>();
	private Map<String, UserInterDesc> providedData = new HashMap<String, UserInterDesc>();
	static private Map<String, String> diplayNames = new HashMap<String, String>();
	static {
		diplayNames.put("28", "Veredict");
		diplayNames.put("27", "Employee Information");
		diplayNames.put("30", "Employee Information");
		diplayNames.put("31", "Payment Information");
	}
	private String id;
	private boolean isDone;
	
	public UserInteraction(String cuiId) {
		id = cuiId;
		isDone = false;
	}

	public class UserInterDesc {
		String type;
		Object content;
		
		public UserInterDesc (String type, Object content) {
			this.type = type;
			this.content = content;
		}
	}

	public String getId() {
		return id;
	}

	public boolean isDone() {
		return isDone;
	}
	
	public void wasDone() {
		isDone = true;
	}

	public String getDisplayableName() {
		if (diplayNames.keySet().contains(id))
			return diplayNames.get(id);
		return id;
	}
	
	public Set<String> getAvailableItemIds() {
		return availableData.keySet();
	}

	public Object getAvailableItemContent(String itemId) {
		return availableData.get(itemId).content;
	}
	
	public Object getProvidedItemContent(String itemId) {

		return providedData.get(itemId).content;
	}

	public void addProvidedData(String inputId, String type, Object content) {
		if (!providedData.keySet().contains(id))
			providedData.put(inputId, new UserInterDesc(type, content));
	}
	
	public void addAvailableData(String id, String type, Object content) {
		if (!getAvailableItemIds().contains(id))
			availableData.put(id, new UserInterDesc(type, content));
	}

	public Set<String> getProvidedItemIds() {
		return providedData.keySet();
	}
}