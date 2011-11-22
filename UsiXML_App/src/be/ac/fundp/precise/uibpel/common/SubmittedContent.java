package be.ac.fundp.precise.uibpel.common;

public class SubmittedContent {

	protected String id;
	protected String type;
	protected Object data;

	public void setType(String newType) {
		type = newType;
	}
	
	public void setId(String newId) {
		id = newId;
	}
	
	public void setData(Object newData) {
		data = newData;
	}
	
	
	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public Object getData() {
		return data;
	}


}
