package be.ac.precise.usixml.androidapp.util;

import org.restlet.engine.Engine;
import org.restlet.ext.httpclient.HttpClientHelper;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.resource.ClientResource;

public class EventTrigger {
	
	public static void fireEvent(String role, String processId, String eventId) {
		Engine.getInstance().getRegisteredClients().clear();
    	Engine.getInstance().getRegisteredConverters().add(new JacksonConverter());
    	Engine.getInstance().getRegisteredClients().add(new HttpClientHelper(null));
		ClientResource itemsResource = new ClientResource("http://10.0.1.14:8090/UiManager/restlet/event" +
				"/" + role +
				"/" + processId +
				"/" + eventId);
		itemsResource.get();
		System.out.println("I did it.");
	}

}
