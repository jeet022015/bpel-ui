package be.ac.fundp.precise.uibpel.server.resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;

import be.ac.fundp.precise.uibpel.common.SubmittedContent;


public class UISyncServerResource   extends UI_BPEL_Resource {

	@Get
	public Representation retrieve() {
		final String cuiId = (String) getRequestAttributes().get("cuiId");
		System.out.println("get cuiId = "+ cuiId);
		SubmittedContent[] data = null;
		try {
			data = uiManagerAndroid.getDataProvidedByUser(cuiId);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject();
		try {
			JSONArray list2 = new JSONArray();
			for (SubmittedContent aContent : data) {
				JSONObject aData = new JSONObject();
				aData.put("id",aContent.getId());
				aData.put("type",aContent.getType());
				//TODO extend it any data
				aData.put("content",aContent.getData().toString());
				list2.put(aData);
			}
			obj.put("providedData", list2);
		} catch (JSONException e) {
			e.printStackTrace();
			obj = new JSONObject();
		}
		return new JsonRepresentation(obj);
	}
	
	@Put
	public void syncPut(Representation entity) throws ResourceException {
		store(entity);
	}
}
