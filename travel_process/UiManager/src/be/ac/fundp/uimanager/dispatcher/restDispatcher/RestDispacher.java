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
import be.ac.fundp.uimanager.model.ProvidedData;

/**
 * The Class RestDispacher.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class RestDispacher implements Dispatcher {

	public static final String DEFAULT_HOST = "http://10.0.1.2:8182/uibpel/";
	
	public static final int MAX_WAITING_TIME = 86400 *1000;// One day
	
	/** The host. */
	protected String host;
	protected Map<String, Boolean> activeProcesses =  new HashMap<String, Boolean>();

	private Random generator;

	
	public RestDispacher(String host){
		this.host = host;
	}
	
	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.client.Dispatcher#requireInputInteracion(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ProvidedData> requireInputInteracion(String processId,
			String userInteracId, String role) {
		List<ProvidedData> resp = null;
		ClientResource cr = null;
		try {
			cr = putInteraction(role, processId, userInteracId, Collections.<ProvidedData>emptyList());

			JSONObject crudeData = getProvidedData(cr, processId);
			resp = RestDispatcherUtil.JSON2CoordinatedData(crudeData);
		} catch (Exception e) {
			//TODO deal with Exception
			e.printStackTrace();
		}finally{
			if (cr.getResponseEntity() != null)
            	cr.getResponseEntity().release();
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
	public List<ProvidedData> requireSelectionInteracion(String processId,
			String userInteracId, List<ProvidedData> data2, String role) {
		List<ProvidedData> resp = null;
		ClientResource cr = null;
		try {
			cr = putInteraction(role, processId, userInteracId, data2);
			
			JSONObject crudeData = getProvidedData(cr, processId);
			resp = RestDispatcherUtil.JSON2CoordinatedData(crudeData);
		} catch (Exception e) {
			//TODO deal with Exception
			e.printStackTrace();
		}finally{  
			if (cr.getResponseEntity() != null)
            	cr.getResponseEntity().release();
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
	public void requireOutputInteracion(String processid, String userInteracId,
			List<ProvidedData> data2, String role) {
		ClientResource cr = null;
		try {
			cr = putInteraction(role, processid, userInteracId, data2);
		} catch (Exception e) {
			//TODO deal with Exception
			e.printStackTrace();
		}finally{
            if (cr.getResponseEntity() != null)
            	cr.getResponseEntity().release();
            if (cr != null)
				cr.release();
		}
		System.gc();
	}

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
				if (!activeProcesses.get(processId))
					return null;
				r = cr.get();
				jr = new JsonRepresentation(r);
				returnJson = jr.getJsonObject();
				if (returnJson.has(RestDispatcherUtil.DATA_TAG_JSON))
					return returnJson;
				//Algorithm to avoid conflicts
				waitingTime += generator.nextInt(waitingTime);
			} while (waitingTime <= MAX_WAITING_TIME);
			
		} finally {
			if (r != null) r.release();
			if (jr != null) jr.release();
		}
		return returnJson;
	}

	private ClientResource createClientResource(String role,
			String processId, String userInteracId) {
		String host = createHost(role, processId, userInteracId);
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
		
		activeProcesses.put(processId, true);
		return cr;
	}

	private String createHost(String role, String processId,
			String userInteracId) {
		return host + role + "/" + 
			processId + "/" + userInteracId;
	}

	private ClientResource putInteraction(String role, String processId, 
			String userInteracId, List<ProvidedData> data2) throws JSONException, InterruptedException {
		JSONObject obj = new JSONObject();
		JSONArray data = RestDispatcherUtil.coordinatedData2JSON(data2);
		obj.put(RestDispatcherUtil.DATA_TAG_JSON, data);
		ClientResource cr = createClientResource(role, processId, userInteracId);
		JsonRepresentation jr = new JsonRepresentation(obj);
		try {
			System.out.println("server status ="+cr.getStatus());
			if (!cr.getStatus().equals(Status.SUCCESS_OK)){
				cr.release();
				putInteraction(role, processId, userInteracId, data2);
			}
			cr.put(jr);
			//TODO deal with loop
		} catch (Exception e) {
			e.printStackTrace();
			cr.release();
			putInteraction(role, processId, userInteracId, data2);
		} finally {
			jr.release();
		}
		return cr;
	}

	@Override
	public void releaseAll(String processId) {
		activeProcesses.put(processId, false);
	}

}