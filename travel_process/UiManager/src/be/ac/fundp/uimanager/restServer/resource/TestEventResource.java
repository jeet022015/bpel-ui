package be.ac.fundp.uimanager.restServer.resource;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

// TODO: Auto-generated Javadoc
/**
 * The Class TestEventResource.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class TestEventResource extends ServerResource {

    /**
     * Represent.
     *
     * @return the string
     */
    @Get
    public String represent() {
        return "works";
    }
    
//    @Put
//	public void syncPut(Representation entity) throws ResourceException {
//		//String cuiID = (String) getRequestAttributes().get("cuiId");
//		//String processId = (String) getRequestAttributes().get("processId");
//		if (entity.getMediaType().isCompatible(MediaType.APPLICATION_JSON)) {
//			try {
//				JSONObject result = new JsonRepresentation(entity).getJsonObject();
//				String cuiID = result.getString("cuiId");
//				String processId = result.getString("processId");
//				//String role = result.getString("role");
//				
//				UserEventListner ss = new UserEventListner();
//		        UserEventListnerPortType port = ss.getUserEventListnerSOAP11PortHttp();  
//
//		        port.fireEvent(cuiID, processId);
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (JSONException e) {
//				e.printStackTrace();
//			}
//		}
//	}

}