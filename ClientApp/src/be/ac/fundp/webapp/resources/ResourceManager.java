package be.ac.fundp.webapp.resources;

import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
	
	private static ResourceManager itself;
	private Map<String, UIDataCapsule> mappingIdRequiredData;
	private Map<String, UIDataCapsule> mappingIdProvidedData;
	private int timeout = 15000;
	private ThreadEvent t = ThreadEvent.getInstance();
	//TODO What for a long time
	//private Random r = new Random();
	
	private ResourceManager(){
		mappingIdRequiredData =  new HashMap<String, UIDataCapsule> ();
		mappingIdProvidedData =  new HashMap<String, UIDataCapsule> ();
	}
	
	public static ResourceManager getInstance(){
		if (itself == null)
			itself = new ResourceManager();
		return itself;
	}
	
	public UIDataCapsule getData(String id){
		UIDataCapsule map = mappingIdRequiredData.get(id);
		if (map != null)
			return map;
		return new UIDataCapsule();
	}
	
	public void putData(String id, UIDataCapsule d){
		mappingIdRequiredData.put(id, d);
	}

	public UIDataCapsule getSynchronizedUIData(String id) throws InterruptedException {
		UIDataCapsule map = mappingIdRequiredData.get(id);
		int count = 0;
		while (count < timeout && map == null){
			Thread.sleep(1000);
			//Thread.currentThread().wait();
			map = mappingIdRequiredData.get(id);
			count += 1000;
			System.out.println("loop Id = "+id);
			System.out.println("internal clock"+count);
		}
		mappingIdRequiredData.remove(id);
		if (count >= timeout){
			System.out.println("Sorry too late :(");
			return new UIDataCapsule();
		}
		return map;
	}

	public void putOutputData(String uiId, UIDataCapsule d) {
		System.out.println("data put = "+ d);
		mappingIdProvidedData.put(uiId, d);
	}
	
	public UIDataCapsule getOutputUIData(String id){
		System.out.println("whaat is the ID???? = "+id);
		UIDataCapsule map = mappingIdProvidedData.get(id);
		mappingIdProvidedData.remove(id);
		return map;
	}
	
}