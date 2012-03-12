package be.ac.fundp.uimanager.model;

public class ProvidedData {

	protected String id;
	protected String type;
	protected Object content;
	
	public String getType() {
		return type;
	}

	public Object getData() {
		return content;
	}

	public String getId() {
		return id;
	}

	public void setType(String type) {
		this.type = type;
		
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setData(Object content) {
		this.content = content;
	}

}
