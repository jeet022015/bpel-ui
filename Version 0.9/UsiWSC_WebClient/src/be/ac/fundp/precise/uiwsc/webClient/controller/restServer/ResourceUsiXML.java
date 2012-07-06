package be.ac.fundp.precise.uiwsc.webClient.controller.restServer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

import be.ac.fundp.precise.uiwsc.webClient.controller.ControllerConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.ProcessManager;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.DataItem;

/**
 * The Class ResourceUsiXML is responsible to deal with the communication among the 
 * UsiWSC client and UsiWSC manager.
 */
public class ResourceUsiXML extends ServerResource {

	/** The process manager. */
	protected ProcessManager processManager = ProcessManager.getInstance();

	/**
	 * Retrieve the data provided by the user. If the data is not available, the response will
	 * be a text with <i>"Data not available." </i>.
	 *
	 * @return the representation with the data provided
	 */
	@Get
	public Representation retrieve() {
		final String user = (String) getRequestAttributes().get(ControllerConstants.CONTROLLER_LOGIN);
		final String processId = (String) getRequestAttributes().get(ControllerConstants.CONTROLLER_PROCESS_ID);
		//final String process = (String) getRequestAttributes().get(ControllerConstants.CONTROLLER_PROCESS);
		final String cuiId = (String) getRequestAttributes().get(ControllerConstants.CONTROLLER_CUI_ID);
		List<DataItem> providedData = processManager.getProvidedData(user, processId, cuiId);
		JSONObject obj = new JSONObject();

		if (providedData == null || providedData.isEmpty()) {
			try {
				obj.put("Error","Data not available.");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else {
			try {
				obj.put(ServerConstants.JSON_DATA,parseProvidedData(providedData));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new JsonRepresentation(obj);
	}
	
	/**
	 * Add a new user interaction to a process. And it creates a process if it does
	 * not exists. 
	 *
	 * @param entity the entity with the data available to be presented to the user.
	 * @throws ResourceException the resource exception if a error during the data retrieving occurs
	 */
	@Put
	public void newUserInteraction(Representation entity) throws ResourceException {
		final String user = (String) getRequestAttributes().get(ControllerConstants.CONTROLLER_LOGIN);
		final String role = (String) getRequestAttributes().get(ControllerConstants.CONTROLLER_ROLE);
		final String processId = (String) getRequestAttributes().get(ControllerConstants.CONTROLLER_PROCESS_ID);
		final String process = (String) getRequestAttributes().get(ControllerConstants.CONTROLLER_PROCESS);
		final String cuiId = (String) getRequestAttributes().get(ControllerConstants.CONTROLLER_CUI_ID);
		List<DataItem> availableData = Collections.emptyList();

		try {
			if (entity.getMediaType().isCompatible(MediaType.APPLICATION_JSON)) {
				JSONObject dataReceived = new JsonRepresentation(entity).getJsonObject();
				availableData = parseReceivedData(dataReceived);
			}
		} catch (Exception e) {
			e.printStackTrace();
			availableData = Collections.emptyList();
		}
		processManager.newInteraction(user, processId, process, role, cuiId, availableData);
	}

	/**
	 * Parses the received data in JSON to the format used by the system. We do it in order to
	 * allow any type of data, not only JSON.
	 *
	 * @param jsonData the data provided
	 * @return the List of DataItem for each data provided in the JSON
	 * @throws JSONException the jSON exception if a error during the data retrieving occurs
	 */
	private List<DataItem> parseReceivedData(JSONObject jsonData) throws JSONException {
		List<DataItem> providedData = new LinkedList<DataItem>();
		if (jsonData.has(ServerConstants.JSON_DATA)) {
			JSONArray data = jsonData.getJSONArray(ServerConstants.JSON_DATA);
			if (data != null){
				for (int i = 0; i < data.length(); i++) {
					JSONObject aData = data.getJSONObject(i);
					DataItem aDataItem = new DataItem();
					aDataItem.setId(aData.getString(ServerConstants.JSON_ID));
					aDataItem.setType(aData.getString(ServerConstants.JSON_TYPE));
					aDataItem.setContent(aData.get(ServerConstants.JSON_CONTENT));
					providedData.add(aDataItem);
				}
			}
		}
		return providedData;
	}
	
	/**
	 * Parses the  data in the format used by the system to JSON. We do it in order to
	 * allow any type of data, not only JSON.
	 *
	 * @param data the List of DataItem
	 * @return the JSON array where each entry is a dataItem on the list 
	 * @throws JSONException the jSON exception if a error during the data retrieving occurs
	 */
	private JSONArray parseProvidedData(List<DataItem> data) throws JSONException {
		JSONArray dataJson = new JSONArray();
		for (DataItem dataItem : data) {
			try {
				JSONObject aData = new JSONObject();
				aData.put(ServerConstants.JSON_ID,dataItem.getId());
				aData.put(ServerConstants.JSON_TYPE,dataItem.getType());
				aData.put(ServerConstants.JSON_CONTENT, dataItem.getContent());
				dataJson.put(aData);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return dataJson;
	}
}