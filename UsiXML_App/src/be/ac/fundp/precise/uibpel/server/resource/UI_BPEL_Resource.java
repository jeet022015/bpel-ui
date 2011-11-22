package be.ac.fundp.precise.uibpel.server.resource;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.uibpel.UiJsonUtil;
import be.ac.fundp.precise.uibpel.common.SubmittedContent;
import be.ac.fundp.precise.uibpel.manager.UIManager;

public class UI_BPEL_Resource   extends ServerResource{
	
	protected UIManager uiManagerAndroid = UIManager.getInstance();
	
	public void store(Representation entity) throws ResourceException {
		System.out.println("the ui was put");
		if (entity.getMediaType().isCompatible(MediaType.APPLICATION_JSON)) {
			try {
				JSONObject result = new JsonRepresentation(entity).getJsonObject();
				String cuiID = result.getString("cuiid");
				JSONArray data = result.getJSONArray("data");
				SubmittedContent[] content = UiJsonUtil.collectData(data);
				uiManagerAndroid.addUserInteraction(cuiID,content);
				//r.addNotification();
			} catch (IOException e) {
				//TODO treat exception
				e.printStackTrace();
			} catch (JSONException e) {
				//TODO treat exception
				e.printStackTrace();
			}
		}
//		try {
//			finalize();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
	}
	

}
