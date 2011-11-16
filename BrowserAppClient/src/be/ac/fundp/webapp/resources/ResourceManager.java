package be.ac.fundp.webapp.resources;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import be.ac.fundp.webapp.DataItemType;
import be.ac.fundp.webapp.representation.Order;

public class ResourceManager {

	protected static ResourceManager self;
	protected HashMap<String, List<String>> mapCuiStack = new HashMap<String, List<String>>();
	protected Map<String, ThreadEvent> breakers = new HashMap<String, ThreadEvent>();
	protected Map<String, DataItemType[]> uiProvidedInformation = new HashMap<String, DataItemType[]>();
	protected Map<String, DataItemType[]> uiRequiredInformation = new HashMap<String, DataItemType[]>();
	protected Map<String, String> currentCuiId = new HashMap<String, String>();
	
	protected List<Order> orders = new LinkedList<Order>();
	protected Order currentOrder;
	
	private ResourceManager (){
		
	}
	
	public static ResourceManager getInstance() {
		if (self == null)
			self = new ResourceManager();
		return self;
	}

	public DataItemType[] waitDataUI(String cuiId) throws InterruptedException {
		ThreadEvent te = new ThreadEvent();
		breakers.put(cuiId, te);
		te.await();
		return uiProvidedInformation.get(cuiId);
	}

	public void configureDataRequiredByUi(String cuiId, DataItemType[] inputData) {
		if(inputData == null || inputData.length == 0)
			return;
		uiRequiredInformation.put(cuiId, inputData);
	}
	
	public DataItemType[] getRequiredDataByUi(String cuiId){
		DataItemType[] dataRequired = uiRequiredInformation.remove(cuiId);
		return dataRequired;
	}

	public void addCuiId(String cuiId, String role) {
		List<String> roleCuiId;
		if (mapCuiStack.containsKey(role))
			roleCuiId = mapCuiStack.get(role);
		else{
			roleCuiId = new LinkedList<String>();
			mapCuiStack.put(role, roleCuiId);
		}
			
		roleCuiId.add(cuiId);
		
		currentOrder = new Order();
		orders.add(currentOrder);
		currentOrder.addUserInteraction(cuiId);
	}
	
	public String getCurrentCuiId(String role) {
		return currentCuiId.get(role);
	}

	public void putData(String cuiId, DataItemType[] dataProvided) {
		uiProvidedInformation.put(cuiId, dataProvided);
		ThreadEvent te = breakers.get(cuiId);
		if (te != null){
			te.signal();
			breakers.remove(cuiId);
		}
	}

	public String getNextCui(String role) {
		List<String> cuiStack2 = mapCuiStack.get(role);
		if (cuiStack2 == null) {
			mapCuiStack.put(role, new LinkedList<String>());
			return null;
		}
		if (cuiStack2.isEmpty())
			return null;
		String currentCuiId = cuiStack2.remove(0);
		this.currentCuiId.put(role, currentCuiId);
		return currentCuiId;
	}
	
	public Order getCurrentOrder(){
		return currentOrder;
	}
	
	public List<Order> getOrders(){
		return orders;
	}
}
