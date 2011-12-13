package be.ac.fundp.webapp.service.representation;

// TODO: Auto-generated Javadoc
/**
 * The Class DataItem.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class DataItem {
	
	/** The data item id. */
	protected String dataItemId;
	
	/** The type. */
	protected String type;
	
	/** The data. */
	protected Object data;
	

	/**
	 * Instantiates a new data item.
	 *
	 * @param id the id
	 * @param type the type
	 * @param data the data
	 */
	public DataItem(String id, String type, Object data){
		dataItemId = id;
		this.type = type;
		this.data = data;
	}
	
	/**
	 * Gets the data item id.
	 *
	 * @return the data item id
	 */
	public String getDataItemId() {
		return dataItemId;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

}
