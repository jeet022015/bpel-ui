package be.ac.fundp.usiwsc.webapp.client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.ClientResource;

import be.ac.fundp.usiwsc.webapp.model.UserInteraction;

public class RestClient {

	public static void sendData(String role, String processId, String cuiId, UserInteraction interaction){
		//Engine.getInstance().getRegisteredClients().clear();
    	//Engine.getInstance().getRegisteredConverters().add(new JacksonConverter());
    	//Engine.getInstance().getRegisteredClients().add(new HttpClientHelper(null));
    	//TODO Update Ip here
		ClientResource itemsResource = new ClientResource("http://10.0.1.3:8090/UiManager/restlet/send_data" +
				"/" + role +
				"/" + processId +
				"/" + cuiId);
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
}
