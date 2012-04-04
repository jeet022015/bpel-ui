package be.ac.precise.usixml.androidapp.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserInteraction {

	private Map<String, UserInterDesc> availableData = new HashMap<String, UserInterDesc>();
	private Map<String, UserInterDesc> providedData = new HashMap<String, UserInterDesc>();
	static private Map<String, CharSequence> diplayNames = new HashMap<String, CharSequence>();
	static {
		diplayNames.put("0", "Personal Information");
		diplayNames.put("1", "Travel Information");
		diplayNames.put("2", "Mean of Transportation");
		diplayNames.put("19", "Select Flight Journey");
		diplayNames.put("20", "Select Train Journey");
		diplayNames.put("21", "Car Option");
		diplayNames.put("22", "Car Description");
		diplayNames.put("23", "Car Options");
		diplayNames.put("26", "Hotel Option");
		diplayNames.put("24", "Hotel Description");
		diplayNames.put("25", "Hotel Options");
		diplayNames.put("29", "Travel Veredict");
		diplayNames.put("31", "Canceled Trip");
		diplayNames.put("32", "Canceled Trip");
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

	public CharSequence getDisplayableName() {
		if (diplayNames.keySet().contains(id))
			return diplayNames.get(id);
		else return id;
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
