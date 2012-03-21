package be.ac.fundp.usiwsc.webapp.server.resource;

import java.io.IOException;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import be.ac.fundp.usiwsc.webapp.manager.UiManager;
import be.ac.fundp.usiwsc.webapp.model.UserInteraction;

public class ResourceUsiXML extends ServerResource {
	
	protected UiManager actManager = UiManager.getInstance();
	
	private static final Logger LOG = Logger.getLogger(ResourceUsiXML.class.getName());
	
	private static boolean lock = false;
	
	private static String lockTest = "";
	
	@Override
    public Status getStatus() {
		if (lock)
			return Status.INFO_PROCESSING;
        return getResponse() == null ? null : getResponse().getStatus();
    }
	
	@Get
	public Representation retrieve() {
		final String role = (String) getRequestAttributes().get("role");
		final String processId = (String) getRequestAttributes().get("processId");
		final String cuiId = (String) getRequestAttributes().get("cuiId");
		
		LOG.info("Starting Get - REST Service");
		LOG.info("getting Rest Service - role: "+ role);
		LOG.info("getting Rest Service - process id: "+ processId);
		LOG.info("getting Rest Service - cuiId: "+ cuiId);
		
		
		JSONObject obj = new JSONObject();
		UserInteraction performedInteraction = actManager.getDataProvidedByUser(role, processId, cuiId);
		
		if (performedInteraction == null || !performedInteraction.isDone()){
			try {
				obj.put("Error","Data not available.");
				LOG.info("Data not available");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return new JsonRepresentation(obj);
		}
		
		JSONArray dataJson = new JSONArray();
		
		if (performedInteraction != null && performedInteraction.getProvidedItemIds() != null){
			LOG.info("There is available data.");
			for (String itemId : performedInteraction.getProvidedItemIds()) {
				LOG.info("An available data.");
				try {
					JSONObject aData = new JSONObject();
					aData.put("id",itemId);
					LOG.info("data id="+itemId);
					//TODO Other Types
					aData.put("type","string");
					LOG.info("data type=string");
					aData.put("content", performedInteraction.getProvidedItemContent(itemId).toString());
					LOG.info("data type="+"X");
					dataJson.put(aData);
				} catch (JSONException e) {
					e.printStackTrace();
					obj = new JSONObject();
				}
			}
		}
		
		try {
			obj.put("data", dataJson);
		} catch (JSONException e) {
			obj = new JSONObject();
			e.printStackTrace();
		}
		
		LOG.info("Finishing Get - REST Service");
		
		return new JsonRepresentation(obj);
	}
	
	@Put
	public synchronized void newUserInteraction(Representation entity) throws ResourceException {
		
		lock = true;
		
		LOG.info("Starting Put - REST Service");
		
		final String role = (String) getRequestAttributes().get("role");
		final String processId = (String) getRequestAttributes().get("processId");
		final String cuiId = (String) getRequestAttributes().get("cuiId");
		
		LOG.info("putting Rest Service - role: "+ role);
		LOG.info("putting Rest Service - process id: "+ processId);
		LOG.info("putting Rest Service - cuiId: "+ cuiId);
		
		synchronized (lockTest) {
			if (entity.getMediaType().isCompatible(MediaType.APPLICATION_JSON)) {
				try {
					JSONObject result = new JsonRepresentation(entity).getJsonObject();
					if (result.has("data")) {
						LOG.info("There is available data.");
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
		
		LOG.info("Finishing Put - REST Service");
		lock = false;
	}
}