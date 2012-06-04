package be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities;

/**
 * The Class DataItem.
 */
public class DataItem {
	
	/** The data item id. */
	protected String dataItemId;
	
	/** The data item type. */
	protected String dataItemType;
	
	/** The content. */
	protected Object content;

	/**
	 * Sets the id.
	 *
	 * @param dataItemId the new id
	 */
	public void setId(String dataItemId) {
		this.dataItemId = dataItemId;
	}

	/**
	 * Sets the type.
	 *
	 * @param dataItemType the new type
	 */
	public void setType(String dataItemType) {
		this.dataItemType = dataItemType;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(Object content) {
		this.content = content;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return dataItemId;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return dataItemType;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public Object getContent() {
		return content;
	}

}
