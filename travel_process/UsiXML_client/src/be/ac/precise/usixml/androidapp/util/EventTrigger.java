package be.ac.precise.usixml.androidapp.util;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.engine.Engine;
import org.restlet.ext.httpclient.HttpClientHelper;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import be.ac.precise.usixml.androidapp.model.UserInteraction;

public class EventTrigger {
	
	public static void fireEvent(CharSequence role, String processId, String eventId) {
		Engine.getInstance().getRegisteredClients().clear();
    	Engine.getInstance().getRegisteredConverters().add(new JacksonConverter());
    	Engine.getInstance().getRegisteredClients().add(new HttpClientHelper(null));
		ClientResource itemsResource = new ClientResource("http://10.0.1.14:8090/UiManager/restlet/event" +
				"/" + role +
				"/" + processId +
				"/" + eventId);
		itemsResource.get();
	}
	
	public static void subscribe(CharSequence login, CharSequence password, CharSequence role, String ipAddress) {
		Engine.getInstance().getRegisteredClients().clear();
    	Engine.getInstance().getRegisteredConverters().add(new JacksonConverter());
    	Engine.getInstance().getRegisteredClients().add(new HttpClientHelper(null));
		ClientResource itemsResource = new ClientResource("http://10.0.1.14:8090/UiManager/restlet/subscribe" +
				"/" + login +
				"/" + password +
				"/" + role +
				"/" + ipAddress);
		itemsResource.get();
	}

	public static String verifyUser(CharSequence login, CharSequence password) throws IOException {
		Engine.getInstance().getRegisteredClients().clear();
    	Engine.getInstance().getRegisteredConverters().add(new JacksonConverter());
    	Engine.getInstance().getRegisteredClients().add(new HttpClientHelper(null));
    	//TODO Update Ip here
		ClientResource itemsResource = new ClientResource("http://10.0.1.14:8090/UiManager/restlet/login" +
				"/" + login +
				"/" + password);
		Representation get = itemsResource.get();
		String result = get.getText();
		System.out.println("result="+result);
		return result;
	}
	
	public static void sendData(CharSequence role, CharSequence processId, CharSequence cuiId, UserInteraction interaction){
		Engine.getInstance().getRegisteredClients().clear();
    	Engine.getInstance().getRegisteredConverters().add(new JacksonConverter());
    	Engine.getInstance().getRegisteredClients().add(new HttpClientHelper(null));
    	//TODO Update Ip here
		ClientResource itemsResource = new ClientResource("http://10.0.1.14:8090/UiManager/restlet/send_data" +
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
