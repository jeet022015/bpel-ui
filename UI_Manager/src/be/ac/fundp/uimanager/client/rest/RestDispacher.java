package be.ac.fundp.uimanager.client.rest;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import be.ac.fundp.uimanager.client.Dispatcher;
import be.ac.fundp.uimanager.provider.UiDataType;

// TODO: Auto-generated Javadoc
/**
 * The Class RestDispacher.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class RestDispacher implements Dispatcher {

	/** The host. */
	protected String host = "http://10.0.1.20:8182/uibpel/sync/";

	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.client.Dispatcher#requireInputInteracion(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<UiDataType> requireInputInteracion(String processId,
			String userInteracId, String role) {
		JSONObject result = new JSONObject();
		List<UiDataType> resp = new LinkedList<UiDataType>();
	    
		ClientResource cr = new ClientResource(host+ processId+ "/" + userInteracId);
		//cr.setRetryDelay(300000);
		cr.setRetryAttempts(288);
		JsonRepresentation jr = null;
		JsonRepresentation jr2 = null;
		Representation r = null;
		try {
			System.out.println("the host is ="+host+processId+"/"+userInteracId);
			
			JSONObject obj = new JSONObject();
			obj.put("cuiid", userInteracId);
			JSONArray data = new JSONArray();
			obj.put("data", data);
			jr = new JsonRepresentation(obj);
			cr.put(jr);
			System.out.println("put done!");
			
			r = cr.get();
			jr2 = new JsonRepresentation(r);
			result = jr2.getJsonObject();
			resp = UiManagerRestUtil.parseJSON(result);
			//r.exhaust();
			//jr2.exhaust();
			//jr.exhaust();
			System.out.println("Test Finished is =" + result);
			
		} catch (Exception e) {
			e.printStackTrace();
			result = new JSONObject();
			//return requireInputInteracion( processId,userInteracId, role);
		}finally{    
            cr.release();  
            cr.getResponseEntity().release();
            if (jr != null){
            	jr.release();
            }
            if (r != null){
            	r.release();
            }
            if (jr2 != null){
            	jr2.release();
            }
		} 
		System.gc();
		return resp;
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.client.Dispatcher#requireOutputInteracion(java.lang.String, java.lang.String, java.util.List, java.lang.String)
	 */
	@Override
	public void requireOutputInteracion(String processid, String userInteracId,
			List<UiDataType> data2, String role) {
		ClientResource cr = new ClientResource(host+ processid+ "/" + userInteracId);
		//cr.setRetryDelay(300000);
		cr.setRetryAttempts(288);
		JsonRepresentation jr = null;
		try {
			
			//ClientResource cr = new ClientResource(host + userInteracId);
			JSONObject obj = new JSONObject();
			obj.put("cuiid", userInteracId);
			JSONArray data = UiManagerRestUtil.parseUiDataType(data2);
			obj.put("data", data);
			jr = new JsonRepresentation(obj);
			cr.put(jr);
			System.out.println("put done!");
			//jr.exhaust();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{  
            cr.release();  
            cr.getResponseEntity().release();
            if (jr != null)
            	jr.release();
		}
		System.gc();
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.client.Dispatcher#requireSelectionInteracion(java.lang.String, java.lang.String, java.util.List, java.lang.String)
	 */
	@Override
	public List<UiDataType> requireSelectionInteracion(String processId,
			String userInteracId, List<UiDataType> data2, String role) {
		JSONObject result = new JSONObject();
		List<UiDataType> resp = new LinkedList<UiDataType>();
		ClientResource cr = new ClientResource(host+ processId+ "/" + userInteracId);
		//cr.setRetryDelay(300000);
		cr.setRetryAttempts(288);
		JsonRepresentation jr2 = null;
		Representation r = null;
		JsonRepresentation jr = null;
		try {
			
			//ClientResource cr = new ClientResource(host + userInteracId);
			JSONObject obj = new JSONObject();
			obj.put("cuiid", userInteracId);
			JSONArray data = UiManagerRestUtil.parseUiDataType(data2);
			obj.put("data", data);
			jr = new JsonRepresentation(obj);
			cr.put(jr);
			System.out.println("put done!");
			
			r = cr.get();
			jr2 = new JsonRepresentation(r);
			result = jr2.getJsonObject();
			resp = UiManagerRestUtil.parseJSON_Selection(result);
			System.out.println("Test Finished is =" + result);
			//r.exhaust();
			//jr2.exhaust();
			//jr.exhaust();
		} catch (Exception e) {
			e.printStackTrace();
			result = new JSONObject();
		}finally{  
            cr.release();  
            cr.getResponseEntity().release();  
            if (jr != null)
            	jr.release();
            if (r != null)
            	r.release();
            if (jr2 != null)
            	jr2.release();
		} 
		System.gc();
		return resp;
	}

}
