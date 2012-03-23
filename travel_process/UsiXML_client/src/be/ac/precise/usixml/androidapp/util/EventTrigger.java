package be.ac.precise.usixml.androidapp.util;

import java.io.IOException;

import org.restlet.engine.Engine;
import org.restlet.ext.httpclient.HttpClientHelper;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
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
		ClientResource itemsResource = new ClientResource("http://10.0.1.14:8090/UiManager/restlet/login" +
				"/" + login +
				"/" + password);
		Representation get = itemsResource.get();
		String result = get.getText();
		System.out.println("result="+result);
		return result;
	}

}
