package be.ac.fundp.precise.uiwsc.webClient.model.processManagment.interactionListenner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import be.ac.fundp.precise.uiwsc.webClient.model.ConnectionConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.DataItem;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.UserInteraction;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.events.DataInteractionEvent;

/**
 * The Class DataInteracionListenner.
 */
public class DataInteracionListenner {

	/**
	 * This method invoke the UsiWSC service to send the data provided by the 
	 * user interaction.
	 *
	 * @param event the data interaction event
	 */
	public void interactionDone(DataInteractionEvent event) {
		UserInteraction interaction = (UserInteraction)event.getSource();
		String processId = interaction.getParent().getId();
		String userId = interaction.getParent().getUserId();
		String cuiId = interaction.getId();
		ClientResource itemsResource = new ClientResource(ConnectionConstants.USI_WSC_MANAGER_HOST +
				"/process" +
				//"/"+ processType +
				"/" + processId +
				"/" + userId +
				"/" + cuiId +
				"/send_data");
		JSONObject obj = new JSONObject();
		JSONArray data = new  JSONArray();
		try {
			for (DataItem dataItem : interaction.getProvidedData()) {
				JSONObject aUiDataType = new JSONObject();
					aUiDataType.put("id", dataItem.getId());
				aUiDataType.put("type", dataItem.getType());
				aUiDataType.put("content", dataItem.getContent());
				data.put(aUiDataType);
			}
			obj.put("data", data);
		} catch (JSONException e) {
			obj = new JSONObject();
			e.printStackTrace();
		}
		JsonRepresentation jr = new JsonRepresentation(obj);
		Representation t = itemsResource.put(jr);
		jr.release();
		t.release();
		System.out.println("Data Sent");
	}

}
