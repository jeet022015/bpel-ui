package be.ac.fundp.webapp.service.representation;

import java.util.LinkedList;
import java.util.List;

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
	protected List<DataItem> providedData = new LinkedList<DataItem>();;
	
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
		performed = true;
	}
	
	/**
	 * Reset performed.
	 */
	public void resetPerformed(){
		performed = false;
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
	 * Gets the provided data.
	 *
	 * @return the provided data
	 */
	public List<DataItem> getProvidedData() {
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
