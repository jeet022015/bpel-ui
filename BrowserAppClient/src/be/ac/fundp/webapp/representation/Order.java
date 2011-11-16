package be.ac.fundp.webapp.representation;

import java.util.LinkedList;
import java.util.List;

public class Order {

	protected static int counter = 0;
	protected String name;
	protected boolean performed;
	protected List<String> userInteractions = new LinkedList<String>();
	
	public Order(){
		name = "Order "+counter++;
		performed = false;
	}
	
	public String getName(){
		return name;
	}
	
	public String getUiColor(){
		if (performed)
			return "#00FF00";
		return "#FFF380";
	}
	
	public boolean isPerformed(){
		return performed;
	}
	
	public void setPerformed(){
		performed = true;
	}

	public void addUserInteraction(String cuiId) {
		userInteractions.add(cuiId);
	}
}
