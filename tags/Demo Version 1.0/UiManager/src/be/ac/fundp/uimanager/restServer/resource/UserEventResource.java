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
        //manager.releaseInteracitons(role, processId);
        return "event fired";
    }


}