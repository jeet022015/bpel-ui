package be.ac.precise.usixml.androidapp.service.server.resource;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import be.ac.precise.usixml.androidapp.ActivityManager;
import be.ac.precise.usixml.androidapp.model.UserInteraction;
import be.ac.precise.usixml.androidapp.util.AndroidAppConstants;


public class UsixmlServerResource extends ServerResource {

	protected ActivityManager actManager = ActivityManager.getInstance();
	
	@Get
	public Representation retrieve() {
		final String role = (String) getRequestAttributes().get(AndroidAppConstants.PARAM_ROLE);
		final String processId = (String) getRequestAttributes().get(AndroidAppConstants.PARAM_PROCESS);
		final String cuiId = (String) getRequestAttributes().get(AndroidAppConstants.PARAM_INTERACTION);
		
		JSONObject obj = new JSONObject();
		System.out.println("role ="+role);
		System.out.println("processId ="+processId);
		System.out.println("cuiId ="+cuiId);
		UserInteraction performedInteraction = actManager.getDataProvidedByUser(role, processId, cuiId);
		
		if (performedInteraction == null || !performedInteraction.isDone()){
			try {
				obj.put("Error","Data not available.");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return new JsonRepresentation(obj);
		}
		
		JSONArray dataJson = new JSONArray();
		
		if (performedInteraction.getProvidedItemIds() != null &&
				!performedInteraction.getProvidedItemIds().isEmpty())
			for (String itemId : performedInteraction.getProvidedItemIds()) {
				try {
					JSONObject aData = new JSONObject();
					aData.put(AndroidAppConstants.JSON_ID,itemId);
					//TODO Other Types
					aData.put(AndroidAppConstants.JSON_TYPE,"string");
					aData.put(AndroidAppConstants.JSON_CONTENT, performedInteraction.getProvidedItemContent(itemId).toString());
					dataJson.put(aData);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		
		try {
			obj.put(AndroidAppConstants.JSON_DATA, dataJson);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new JsonRepresentation(obj);
	}
	
	@Put
	public void newUserInteraction(Representation entity) throws ResourceException {
		final String role = (String) getRequestAttributes().get(AndroidAppConstants.PARAM_ROLE);
		final String processId = (String) getRequestAttributes().get(AndroidAppConstants.PARAM_PROCESS);
		final String cuiId = (String) getRequestAttributes().get(AndroidAppConstants.PARAM_INTERACTION);
		
		UserInteraction newInteraction = actManager.addUserInteraction(role, processId, cuiId);
		
		if (entity.getMediaType().isCompatible(MediaType.APPLICATION_JSON)) {
			try {
				JSONObject result = new JsonRepresentation(entity).getJsonObject();
				if (result.has(AndroidAppConstants.JSON_DATA)) {
					JSONArray data = result.getJSONArray(AndroidAppConstants.JSON_DATA);
					for (int i = 0; i < data.length(); i++) {
						JSONObject aData = data.getJSONObject(i);
						String id = aData.getString(AndroidAppConstants.JSON_ID);
						String type = aData.getString(AndroidAppConstants.JSON_TYPE);
						Object content = aData.get(AndroidAppConstants.JSON_CONTENT);
						newInteraction.addAvailableData(id, type, content);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
}
