package be.ac.fundp.uimanager.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="DATA_ITEMS")
public class DataItem {
	
	@Id @GeneratedValue
	private int realDataItemId;
	
	private String itemId;
	private Serializable data;
	@Enumerated(EnumType.STRING)
	private InteractionType type;
	@Enumerated(EnumType.STRING)
	private ItemType itemType;
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Serializable getData() {
		return data;
	}
	public void setData(Serializable data) {
		this.data = data;
	}
	public InteractionType getType() {
		return type;
	}
	public void setType(InteractionType type) {
		this.type = type;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	public int getRealDataItemId() {
		return realDataItemId;
	}
	public void setRealDataItemId(int realDataItemId) {
		this.realDataItemId = realDataItemId;
	}

}
