package be.ac.fundp.precise.uiwsc.webClient.controller.restServer;

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

import be.ac.fundp.precise.uiwsc.webClient.controller.entity.UserInteraction;
import be.ac.fundp.precise.uiwsc.webClient.model.ModelManager;


public class ResourceUsiXML extends ServerResource {
	
	protected ModelManager actManager = ModelManager.getInstance();

	@Get
	public Representation retrieve() {
		final String role = (String) getRequestAttributes().get("role");
		final String processId = (String) getRequestAttributes().get("processId");
		final String cuiId = (String) getRequestAttributes().get("cuiId");

		JSONObject obj = new JSONObject();
		UserInteraction userInteraction = actManager.getProcess(role, processId).getUserInteraction(cuiId);
		
		if (userInteraction == null || !userInteraction.isDone()){
			try {
				obj.put("Error","Data not available.");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return new JsonRepresentation(obj);
		}
		
		JSONArray dataJson = new JSONArray();
		
		if (userInteraction.getProvidedItemIds() != null && 
				!userInteraction.getProvidedItemIds().isEmpty()){
			for (String itemId : userInteraction.getProvidedItemIds()) {
				try {
					JSONObject aData = new JSONObject();
					aData.put("id",itemId);
					aData.put("type","string");
					aData.put("content", userInteraction.getProvidedItemContent(itemId).toString());
					dataJson.put(aData);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			obj.put("data", dataJson);
		} catch (JSONException e) {
			obj = new JSONObject();
			e.printStackTrace();
		}
		return new JsonRepresentation(obj);
	}
	
	@Put
	public synchronized void newUserInteraction(Representation entity) throws ResourceException {
		final String role = (String) getRequestAttributes().get("role");
		final String processId = (String) getRequestAttributes().get("processId");
		final String cuiId = (String) getRequestAttributes().get("cuiId");
		if (entity.getMediaType().isCompatible(MediaType.APPLICATION_JSON)) {
			try {
				JSONObject result = new JsonRepresentation(entity).getJsonObject();
				if (result.has("data")) {
					JSONArray data = result.getJSONArray("data");
					actManager.getProcess(role, processId).addUserInteraction(cuiId, data);
				} else {
					actManager.getProcess(role, processId).addUserInteraction(cuiId);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else {
			actManager.getProcess(role, processId).addUserInteraction(cuiId);
		}
	}
}