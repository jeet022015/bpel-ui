package be.ac.fundp.webapp.resources;

import java.util.LinkedList;
import java.util.List;

public class UIDataCapsule {

	private List<DataItem> itens; 

	public UIDataCapsule(){
		itens = new LinkedList<DataItem>(); 
	}
	
	public void addData(String key, String type, Object data) {
		DataItem d = new DataItem(key, type, data);
		itens.add(d);
	}

	public void setItens(List<DataItem> itens) {
		this.itens = itens;
	}

	public DataItem[] getItens() {
		return itens.toArray(new DataItem[0]);
	}
}
