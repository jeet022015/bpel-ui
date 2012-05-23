package be.ac.fundp.precise.uiwsc.webClient.controller.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import be.ac.fundp.precise.uiwsc.webClient.model.interactionListenner.RestClientApplication;

/**
 * The Class UserInteraction.
 */
public class UserInteraction {

	/** The available data. */
	private Map<String, UserInterDesc> availableData = new HashMap<String, UserInterDesc>();
	
	/** The provided data. */
	private Map<String, UserInterDesc> providedData = new HashMap<String, UserInterDesc>();
	
	protected String role;
	
	protected Process parent;
	
	/** The diplay names. */
	static private Map<String, String> diplayNames = new HashMap<String, String>();
	static {
		diplayNames.put("28", "Decision");
		diplayNames.put("27", "Employee Information");
		diplayNames.put("30", "Employee Information");
		diplayNames.put("31", "Payment Information");
	}
	
	/** The id. */
	private String id;
	
	/** The is done. */
	private boolean isDone;
	
	/**
	 * Instantiates a new user interaction.
	 *
	 * @param cuiId the cui id
	 */
	public UserInteraction(Process parent, String role, String cuiId) {
		id = cuiId;
		this.parent = parent;
		this.role = role;
		isDone = false;
	}

	/**
	 * The Class UserInterDesc.
	 */
	public class UserInterDesc {
		
		/** The type. */
		String type;
		
		/** The content. */
		Object content;
		
		/**
		 * Instantiates a new user inter desc.
		 *
		 * @param type the type
		 * @param content the content
		 */
		public UserInterDesc (String type, Object content) {
			this.type = type;
			this.content = content;
		}
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
	 * Checks if is done.
	 *
	 * @return true, if is done
	 */
	public boolean isDone() {
		return isDone;
	}
	
	/**
	 * Was done.
	 */
	public void wasDone() {
		//TODO Put here the design pattern Observer;
		RestClientApplication.sendData(role, parent.getId(), id, this, parent.getType());
		isDone = true;
	}

	/**
	 * Gets the displayable name.
	 *
	 * @return the displayable name
	 */
	public String getDisplayableName() {
		if (diplayNames.keySet().contains(id))
			return diplayNames.get(id);
		return id;
	}
	
	/**
	 * Gets the available item ids.
	 *
	 * @return the available item ids
	 */
	public Set<String> getAvailableItemIds() {
		return availableData.keySet();
	}

	/**
	 * Gets the available item content.
	 *
	 * @param itemId the item id
	 * @return the available item content
	 */
	public Object getAvailableItemContent(String itemId) {
		return availableData.get(itemId).content;
	}
	
	/**
	 * Gets the provided item content.
	 *
	 * @param itemId the item id
	 * @return the provided item content
	 */
	public Object getProvidedItemContent(String itemId) {

		return providedData.get(itemId).content;
	}

	/**
	 * Adds the provided data.
	 *
	 * @param inputId the input id
	 * @param type the type
	 * @param content the content
	 */
	public void addProvidedData(String inputId, String type, Object content) {
		if (!providedData.keySet().contains(id))
			providedData.put(inputId, new UserInterDesc(type, content));
	}
	
	/**
	 * Adds the available data.
	 *
	 * @param id the id
	 * @param type the type
	 * @param content the content
	 */
	public void addAvailableData(String id, String type, Object content) {
		if (!getAvailableItemIds().contains(id))
			availableData.put(id, new UserInterDesc(type, content));
	}

	/**
	 * Gets the provided item ids.
	 *
	 * @return the provided item ids
	 */
	public Set<String> getProvidedItemIds() {
		return providedData.keySet();
	}

	public String getProvidedItemType(String dataId) {
		return providedData.get(dataId).type;
	}
}