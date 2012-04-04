package be.ac.fundp.uimanager.dispatcher.restDispatcher;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import be.ac.fundp.uimanager.dispatcher.Dispatcher;
import be.ac.fundp.uimanager.model.CoordinatedData;

/**
 * This class is responsible to require user interaction from devices which
 * allow communication via RestFull services.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class RestDispatcher implements Dispatcher {

	/** The Constant which defines the default client. */
	public static final String DEFAULT_HOST = "http://10.0.1.2:8182/uibpel/";
	
	/** The Constant which define the higher time that the dispatcher can wait. */
	public static final int MAX_WAITING_TIME = 86400 *1000;// One day
	
	/** The address of the restFull service. */
	protected String hostAddress;
	
	/** The processes which are running. This Map is used to cancel the dispatcher to wait
	 * for interactions of a process which was canceled. */
	static protected Map<String, Boolean> activeProcesses =  new HashMap<String, Boolean>();

	/** The generator of random number. */
	private Random generator;

	
	/**
	 * Instantiates a new RestDispatcher.
	 *
	 * @param host the host
	 */
	public RestDispatcher(String host){
		this.hostAddress = host;
	}
	
	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.client.Dispatcher#requireInputInteracion(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<CoordinatedData> requireInputInteraction(String processId,
			String userInteracId, String role) {
		List<CoordinatedData> resp = null;
		ClientResource cr = null;
		try {
			cr = putInteraction(role, processId, userInteracId, Collections.<CoordinatedData>emptyList());

			JSONObject crudeData = getProvidedData(cr, processId);
			resp = RestDispatcherUtil.JSON2CoordinatedData(crudeData);
		} catch (Exception e) {
			//TODO deal with Exception
			e.printStackTrace();
		}finally{
			if (cr != null)
				cr.release();  
		} 
		System.gc();
		return resp;
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.client.Dispatcher#requireSelectionInteracion(java.lang.String, java.lang.String, java.util.List, java.lang.String)
	 */
	@Override
	public List<CoordinatedData> requireSelectionInteraction(String processId,
			String userInteracId, List<CoordinatedData> data2, String role) {
		List<CoordinatedData> resp = null;
		ClientResource cr = null;
		try {
			cr = putInteraction(role, processId, userInteracId, data2);
			
			JSONObject crudeData = getProvidedData(cr, processId);
			resp = RestDispatcherUtil.JSON2CoordinatedData(crudeData);
		} catch (Exception e) {
			//TODO deal with Exception
			e.printStackTrace();
		}finally{  
			if (cr != null)
				cr.release();
		} 
		System.gc();
		return resp;
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.client.Dispatcher#requireOutputInteracion(java.lang.String, java.lang.String, java.util.List, java.lang.String)
	 */
	@Override
	public void requireOutputInteraction(String processId, String userInteracId,
			List<CoordinatedData> data2, String role) {
		ClientResource cr = null;
		try {
			cr = putInteraction(role, processId, userInteracId, data2);
			getProvidedData(cr, processId);
		} catch (Exception e) {
			//TODO deal with Exception
			e.printStackTrace();
		}finally{
            if (cr != null)
				cr.release();
		}
		System.gc();
	}

	/**
	 * This method requires a interaction to the client
	 * and it receives the data provided by the user.
	 *
	 * @param cr the ClientResource of the client host.
	 * @param processId the process's id.
	 * @return the data provided by the user.
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException The JSONObject was malformed exception.
	 * @throws InterruptedException The execution crashes when it tries to put the execution to sleep.
	 */
	private JSONObject getProvidedData(ClientResource cr, String processId) throws IOException, JSONException, InterruptedException {
		Representation r = null;
		JsonRepresentation jr = null;
		JSONObject returnJson = null;
		try {
			if (generator == null)
				generator = new Random();
			
			int waitingTime = generator.nextInt(1000)+20000;			
			do {
				System.out.println("I'm sleeping for "+waitingTime+" milisenconds");
				Thread.sleep(waitingTime);
				if (!activeProcesses.get(processId)){
					System.out.println("process="+processId);
					System.out.println("process not active");
					return null;
				} else {
					System.out.println("process active");
				}
				r = cr.get();
				jr = new JsonRepresentation(r);
				returnJson = jr.getJsonObject();
				if (returnJson.has(RestDispatcherUtil.DATA_TAG_JSON))
					return returnJson;

				waitingTime += generator.nextInt(waitingTime);
			} while (waitingTime <= MAX_WAITING_TIME);
			
		} finally {
			if (r != null) r.release();
			if (jr != null) jr.release();
		}
		return returnJson;
	}

	/**
	 * This method creates a Rest ClientResource corresponding the user and process.
	 *
	 * @param role the user'role.
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @return the Rest ClientResource corresponding the user and process.
	 */
	private ClientResource createClientResource(String role,
			String processId, String userInteracId) {
		String host = processHost(role, processId, userInteracId);
		System.out.println("host="+host);
		ClientResource cr = new ClientResource(host);
		cr.setRetryAttempts(288);
		
		generator = new Random(host.hashCode());
		try {
			int sleeptime = generator.nextInt(1000);
			System.out.println("I'm sleeping for "+sleeptime+" milisenconds");
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (!activeProcesses.keySet().contains(processId))
			activeProcesses.put(processId, true);
		return cr;
	}

	/**
	 * This method creates the host to a user corresponding
	 * to a specific process.
	 *
	 * @param role the user'role.
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @return the host to a specific process.
	 */
	private String processHost(String role, String processId,
			String userInteracId) {
		return hostAddress + role + "/" + 
				processId + "/" + userInteracId;
	}

	/**
	 * This method does the put in the Rest service to require a
	 * user interaction.
	 *
	 * @param role the user'role.
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @param availableData the data to be presented to the user.
	 * @return the Rest ClientResource corresponding the user and process.
	 * @throws JSONException The JSONObject was malformed exception.
	 * @throws InterruptedException The execution crashes when it tries to put the execution to sleep.
	 */
	private ClientResource putInteraction(String role, String processId, 
			String userInteracId, List<CoordinatedData> availableData) throws JSONException, InterruptedException {
		JSONObject obj = new JSONObject();
		JSONArray data = RestDispatcherUtil.coordinatedData2JSON(availableData);
		obj.put(RestDispatcherUtil.DATA_TAG_JSON, data);
		ClientResource cr = createClientResource(role, processId, userInteracId);
		JsonRepresentation jr = new JsonRepresentation(obj);
		try {
			System.out.println("server status ="+cr.getStatus());
			if (!cr.getStatus().equals(Status.SUCCESS_OK)){
				cr.release();
				putInteraction(role, processId, userInteracId, availableData);
			}
			cr.put(jr);
			//TODO deal with loop
		} catch (Exception e) {
			e.printStackTrace();
			cr.release();
			putInteraction(role, processId, userInteracId, availableData);
		} finally {
			jr.release();
		}
		return cr;
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.dispatcher.Dispatcher#releaseAll(java.lang.String)
	 */
	@Override
	public void releaseAll(String processId) {
		activeProcesses.put(processId, false);
		System.out.println("process released="+processId);
	}

}