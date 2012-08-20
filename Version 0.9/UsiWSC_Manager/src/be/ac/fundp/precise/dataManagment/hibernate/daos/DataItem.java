package be.ac.fundp.precise.dataManagment.hibernate.daos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * The Class DataItem represents the user DataItem
 * in the data base.
 */
@Entity(name="DATA_ITEMS")
public class DataItem {
	
	/** The real data item id. */
	@Id @GeneratedValue
	private int realDataItemId;
	
	/** The item id. */
	private String itemId;
	
	/** The data. */
	private Serializable data;
	
	/** The type. */
	@OneToOne
	private Interaction parent;
	
	/** The item type. */
	@Enumerated(EnumType.STRING)
	private ItemType itemType;
	
	/**
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public String getItemId() {
		return itemId;
	}
	
	/**
	 * Sets the item id.
	 *
	 * @param itemId the new item id
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Serializable getData() {
		return data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(Serializable data) {
		this.data = data;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Interaction getParent() {
		return parent;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param parent the new parent
	 */
	public void setParent(Interaction parent) {
		this.parent = parent;
	}
	
	/**
	 * Gets the item type.
	 *
	 * @return the item type
	 */
	public ItemType getItemType() {
		return itemType;
	}
	
	/**
	 * Sets the item type.
	 *
	 * @param itemType the new item type
	 */
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	
	/**
	 * Gets the real data item id.
	 *
	 * @return the real data item id
	 */
	public int getRealDataItemId() {
		return realDataItemId;
	}
	
	/**
	 * Sets the real data item id.
	 *
	 * @param realDataItemId the new real data item id
	 */
	public void setRealDataItemId(int realDataItemId) {
		this.realDataItemId = realDataItemId;
	}

}
