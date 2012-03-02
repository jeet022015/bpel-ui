package be.ac.fundp.webapp.service.representation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import be.ac.fundp.webapp.service.util.ThreadEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class UserInteraction.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class UserInteraction {

	/** The user interaction id. */
	protected String userInteractionId;
	
	/** The presented data. */
	protected List<DataItem> presentedData = new LinkedList<DataItem>();
	
	/** The provided data. */
	protected List<DataItem> providedData = new LinkedList<DataItem>();
	
	/** The provided data. */
	static protected Map<String, String> displayNames = new HashMap<String, String>();
	
	static {
		displayNames.put("27", "Employee's Travel Demand");
		displayNames.put("28", "Veredict about the Travel");
		displayNames.put("30", "Travel Information");
		displayNames.put("31", "Travel Payment");
	}
	
	protected ThreadEvent locker = new ThreadEvent();
	
	/** The performed. */
	protected boolean performed;
	
	/**
	 * Instantiates a new user interaction.
	 *
	 * @param id the id
	 */
	public UserInteraction(String id){
		userInteractionId = id;
		this.performed = false;
	}
	
	/**
	 * Adds the presented data item.
	 *
	 * @param item the item
	 */
	public void addPresentedDataItem(DataItem item){
		presentedData.add(item);
	}
	
	/**
	 * Adds the presented data item.
	 *
	 * @param id the id
	 * @param type the type
	 * @param data the data
	 */
	public void addPresentedDataItem(String id, String type, Object data){
		DataItem aDataItem = new DataItem(id, type, data);
		presentedData.add(aDataItem);
	}
	
	/**
	 * Adds the provided data item.
	 *
	 * @param item the item
	 */
	public void addProvidedDataItem(DataItem item){
		providedData.add(item);
	}
	
	/**
	 * Adds the provided data item.
	 *
	 * @param id the id
	 * @param type the type
	 * @param data the data
	 */
	public void addProvidedDataItem(String id, String type, Object data){
		DataItem aDataItem = new DataItem(id, type, data);
		providedData.add(aDataItem);
	}
	
	/**
	 * Checks if is performed.
	 *
	 * @return true, if is performed
	 */
	public boolean isPerformed(){
		return performed;
	}
	
	/**
	 * Sets the performed.
	 */
	public void setPerformed(){
		locker.signal();
		performed = true;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return userInteractionId;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getDisplayableName() {
		String displayName = displayNames.get(userInteractionId);
		if (displayName != null)
			return displayName;
		return "Interaction "+userInteractionId;
	}

	/**
	 * Gets the provided data.
	 *
	 * @return the provided data
	 * @throws InterruptedException 
	 */
	public List<DataItem> getProvidedData() throws InterruptedException {
		if (isPerformed())
			return providedData;
		locker.await();
		return providedData;
		
	}
	
	/**
	 * Gets the presented data.
	 *
	 * @return the presented data
	 */
	public List<DataItem> getPresentedData() {
		return presentedData;
	}
}
