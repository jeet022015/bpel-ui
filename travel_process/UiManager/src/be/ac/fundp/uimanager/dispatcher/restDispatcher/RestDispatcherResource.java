package be.ac.fundp.uimanager.dispatcher.restDispatcher;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 * The Class RestDispatcherResource represents a Rest Resource to 
 * handle with the data sent from the user.
 */
public class RestDispatcherResource extends ServerResource {
	
	/** The data holder. */
	protected RestDispatcherDataHolder dataHolder = RestDispatcherDataHolder.getInstance(); 
	
	/**
	 * This method handles with the data sent from the user.
	 *
	 * @param entity the entity
	 * @return the string
	 */
    @Put
    public void sendData(Representation entity) {
    	String role = (String) getRequestAttributes().get("role");
    	String processId = (String) getRequestAttributes().get("processId");
    	String cuiId = (String) getRequestAttributes().get("cuiId");
    	System.out.println("role="+role);
    	System.out.println("processId="+processId);
    	System.out.println("cuiID="+cuiId);
    	
    	if (entity.getMediaType().isCompatible(MediaType.APPLICATION_JSON)) {
			try {
				JSONObject data = new JsonRepresentation(entity)
					.getJsonObject();
				dataHolder.putData(role, processId, cuiId, data);
				//Save result
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
    }

}
