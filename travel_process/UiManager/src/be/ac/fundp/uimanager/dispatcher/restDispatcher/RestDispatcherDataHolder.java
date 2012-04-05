package be.ac.fundp.uimanager.dispatcher.restDispatcher;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

/**
 * This class manage the data exchanging between the UiManager
 * and the client application.
 */
public class RestDispatcherDataHolder {

	/**
	 * The Class DataListener represents the data exchanged.
	 */
	class DataListener {
		
		/** The this attribute lock the Thread until the data is been
		 * available. */
		Object token;
		
		/** The data exchanged. */
		JSONObject data;
		
		/**
		 * Instantiates a new DataListener.
		 */
		public DataListener() {
			token = new Object();
		}

		/**
		 * This method put data provided and notify all threads
		 * that are available.
		 *
		 * @param newData the new data provided.
		 */
		public void putData(JSONObject newData) {
			data = newData;
			synchronized (token) {
				token.notifyAll();
			}
		}

		/**
		 * This method get data provided. If the data is not provided, it
		 * locks the the data is available.
		 *
		 * @return the data provided.
		 * @throws InterruptedException the interrupted exception
		 */
		public JSONObject getData() throws InterruptedException {
			if (data == null) {
				synchronized (token) {
					token.wait();
				}
				System.out.println("released token!!!");
				return getData();
			} else {
				return data;
			}
		}
	}
	
	/** The self. */
	protected static RestDispatcherDataHolder self;
	
	/** The data holded. */
	Map<String, DataListener> dataHolded = new HashMap<String, DataListener>();
	
	/**
	 * Instantiates a new rest dispatcher data holder.
	 */
	protected RestDispatcherDataHolder(){
		
	}
	
	/**
	 * Gets the single instance of RestDispatcherDataHolder.
	 *
	 * @return single instance of RestDispatcherDataHolder
	 */
	public static RestDispatcherDataHolder getInstance(){
		if (self == null){
			self = new RestDispatcherDataHolder();
		}
		return self;
	}

	/**
	 * This method get data provided. If the data is not provided, it
	 * locks the the data is available.
	 *
	 * @param role the user'role.
	 * @param processId the process's id.
	 * @param cuiId the user interaction's id.
	 * @param the data provided by the user.
	 */
	public void putData(String role, String processId, String cuiId,
			JSONObject data) {
		String key = role+ processId+ cuiId;
		System.out.println("key="+key);
		if (dataHolded.keySet().contains(key)){
			DataListener dataListenner = dataHolded.get(key);
			dataListenner.putData(data);
		} else {
			DataListener dataListenner = new DataListener();
			dataListenner.putData(data);
			dataHolded.put(key, dataListenner);
		}
	}
	
	/**
	 * Gets the data.
	 *
	 * @param role the user'role.
	 * @param processId the process's id.
	 * @param cuiId the user interaction's id.
	 * @return the data provided by the user.
	 * @throws InterruptedException the interrupted exception
	 */
	public JSONObject getData(String role, String processId,
			String cuiId) throws InterruptedException {
		String key = role+processId+cuiId;
		System.out.println("key="+key);
		if (dataHolded.keySet().contains(key)){
			DataListener dataListenner = dataHolded.get(key);
			return dataListenner.getData();
		} else {
			DataListener dataListenner = new DataListener();
			dataHolded.put(key, dataListenner);
			return dataListenner.getData();
		}
		
	}
	
	
}
