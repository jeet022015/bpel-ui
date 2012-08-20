package be.ac.fundp.precise.uiwsc.webClient.controller.jsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import be.ac.fundp.precise.uiwsc.webClient.model.ConnectionConstants;

/**
 * The Class StartableProcessAccess.
 */
public class StartableProcessAccess {

	
	/**
	 * Gets the startable processes.
	 *
	 * @param login the login
	 * @return the startable processes
	 * @throws ResourceException the resource exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException the jSON exception
	 */
	public static List<String> getStartableProcesses(String login) throws ResourceException, IOException, JSONException{
		List<String> processes = new ArrayList<String>();
		ClientResource itemsResource = null;
		JsonRepresentation rep = null;
		try {
			itemsResource = new ClientResource(ConnectionConstants.USI_WSC_MANAGER_HOST +
					"/"+login+
					"/startable");
			rep = new JsonRepresentation(itemsResource.get());
			JSONObject object = rep.getJsonObject();
			JSONArray processArray = object.getJSONArray("processes"); 
			processArray.length();
			for (int i = 0; i < processArray.length(); i++) {
				processes.add(processArray.getString(i));
			}
		} finally {
			if (itemsResource != null)
				itemsResource.release();
			if (rep != null)
				rep.release();
		}
		return processes;
	}
}
