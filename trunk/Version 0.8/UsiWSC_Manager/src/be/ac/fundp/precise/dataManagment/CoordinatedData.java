package be.ac.fundp.precise.dataManagment;

/**
 * The Class CoordinatedData represents a data in the
 * application (provided or presented).
 */
public class CoordinatedData {

	/** The data's id. */
	protected String id;
	
	/** The data's type. */
	protected String type;
	
	/** The data's content. */
	protected Object content;
	
	/**
	 * Gets the data's type.
	 *
	 * @return the data's type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Gets the data's content.
	 *
	 * @return the data's content.
	 */
	public Object getContent() {
		return content;
	}

	/**
	 * Gets the data's id.
	 *
	 * @return the data's id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the data's type.
	 *
	 * @param type the new data's type
	 */
	public void setType(String type) {
		this.type = type;
		
	}

	/**
	 * Sets the data's id.
	 *
	 * @param id the new data's id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the data's data.
	 *
	 * @param content the new data's data
	 */
	public void setContent(Object content) {
		this.content = content;
	}

}
