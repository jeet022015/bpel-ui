package be.ac.fundp.uimanager.restServer.resource;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.uimanager.UiManagerLogic;
import be.ac.fundp.uimanager.userevent.client.UserEventListner;
import be.ac.fundp.uimanager.userevent.client.UserEventListnerPortType;

// TODO: Auto-generated Javadoc
/**
 * The Class UserEventResource.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class UserEventResource extends ServerResource {

	protected UiManagerLogic manager = UiManagerLogic.getInstance();
	
    /**
     * Represent.
     *
     * @return the string
     */
    @Get
    public String represent() {
    	String role = (String) getRequestAttributes().get("role");
    	String processId = (String) getRequestAttributes().get("processId");
    	String cuiID = (String) getRequestAttributes().get("cuiId");
    	System.out.println("role="+role);
    	System.out.println("processId="+processId);
    	System.out.println("cuiID="+cuiID);
    	System.out.println("work!!!!!");
    	UserEventListner ss = new UserEventListner();
        UserEventListnerPortType port = ss.getUserEventListnerSOAP11PortHttp();  
        port.fireEvent(cuiID, processId);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        manager.getDispatcher(role).releaseAll(processId);
        return "event fired";
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