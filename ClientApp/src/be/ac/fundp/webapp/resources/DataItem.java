package be.ac.fundp.webapp.resources;

public class DataItem {
	private String key;
	private String type;
	private Object data;
	
	public DataItem(String key, String type, Object data) {
		this.setKey(key);
		this.setType(type);
		this.setData(data);
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}
}
