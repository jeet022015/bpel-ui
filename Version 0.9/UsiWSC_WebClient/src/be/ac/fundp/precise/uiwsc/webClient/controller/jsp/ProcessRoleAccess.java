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

public class ProcessRoleAccess {

	
	public List<String> getProcesses() throws ResourceException, IOException, JSONException{
		List<String> processes = new ArrayList<String>();
		ClientResource itemsResource = null;
		JsonRepresentation rep = null;
		try {
			itemsResource = new ClientResource(ConnectionConstants.USI_WSC_MANAGER_HOST +
					"/processes");
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
	
	public List<String> getRoles(String processId) throws ResourceException, IOException, JSONException{
		List<String> roles = new ArrayList<String>();
		ClientResource itemsResource = null;
		JsonRepresentation rep = null;
		try {
			itemsResource = new ClientResource(ConnectionConstants.USI_WSC_MANAGER_HOST +
					"/"+processId+ "/roles");
			rep = new JsonRepresentation(itemsResource.get());
			JSONObject object = rep.getJsonObject();
			JSONArray processArray = object.getJSONArray("roles"); 
			processArray.length();
			for (int i = 0; i < processArray.length(); i++) {
				roles.add(processArray.getString(i));
			}
		} finally {
			if (itemsResource != null)
				itemsResource.release();
			if (rep != null)
				rep.release();
		}
		return roles;
	}
}
