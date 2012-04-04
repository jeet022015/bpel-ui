package be.ac.fundp.uimanager.client.rest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import be.ac.fundp.uimanager.InputOperationResponse;
import be.ac.fundp.uimanager.SelectionOperationResponse;
import be.ac.fundp.uimanager.UiDataType;
import be.ac.fundp.uimanager.client.Dispatcher;

public class RestDispacher implements Dispatcher {

	protected String host = "http://10.0.1.20:8182/uibpel/sync/";
	
	@Override
	public InputOperationResponse requireInputInteracion(String processId,
			String userInteracId, String role) {
		JSONObject result = new JSONObject();
		InputOperationResponse resp = new InputOperationResponse();
	    
		ClientResource cr = new ClientResource(host + userInteracId);
		cr.setRetryDelay(300000);
		cr.setRetryAttempts(288);
		JsonRepresentation jr = null;
		JsonRepresentation jr2 = null;
		Representation r = null;
		try {
			System.out.println("the host is ="+host + userInteracId);
			
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

	@Override
	public void requireOutputInteracion(String processid, String userInteracId,
			UiDataType[] data2, String role) {
		ClientResource cr = new ClientResource(host + userInteracId);
		cr.setRetryDelay(300000);
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

	@Override
	public SelectionOperationResponse requireSelectionInteracion(
			String processId, String userInteracId, UiDataType[] data2,
			String role) {
		JSONObject result = new JSONObject();
		SelectionOperationResponse resp = new SelectionOperationResponse();
		ClientResource cr = new ClientResource(host + userInteracId);
		cr.setRetryDelay(300000);
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
