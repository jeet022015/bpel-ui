package be.ac.fundp.precise.restInteraction.restClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.ClientResource;

import be.ac.fundp.precise.WebClientConstants;
import be.ac.fundp.precise.dataManagment.model.UserInteraction;

public class RestClientApplication {

	public static void sendData(String role, String processId, String cuiId,
			UserInteraction interaction, String process) {
		//ClientResource itemsResource = new ClientResource("http://10.0.1.3:8090/UiManager/restlet/send_data" +
		//"/process/{processId}/{role}/{cuiId}/send_data"
		ClientResource itemsResource = new ClientResource(WebClientConstants.restHost +
				"/process" +
				"/" + processId +
				"/" + role +
				"/" + cuiId
				+ "/send_data");
		JSONObject obj = new JSONObject();
		JSONArray data = new  JSONArray();
		try {
			for (String dataId : interaction.getProvidedItemIds()) {
				JSONObject aUiDataType = new JSONObject();
					aUiDataType.put("id", dataId);
				aUiDataType.put("type", interaction.getProvidedItemType(dataId));
				aUiDataType.put("content", interaction.getProvidedItemContent(dataId));
				data.put(aUiDataType);
			}
			obj.put("data", data);
		} catch (JSONException e) {
			obj = new JSONObject();
			e.printStackTrace();
		}
		JsonRepresentation jr = new JsonRepresentation(obj);
		itemsResource.put(jr);
		System.out.println("put data!");
	}

	public static void triggerEvent(String role, String processId, String eventId){
		//ClientResource itemsResource = new ClientResource("http://10.0.1.3:8090/UiManager/restlet/event" +
		ClientResource itemsResource = new ClientResource(WebClientConstants.restHost+"/event" +
				"/" + role +
				"/" + processId +
				"/" + eventId);
		itemsResource.get();
	}
}
