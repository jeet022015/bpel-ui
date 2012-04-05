package be.ac.fundp.uimanager.restServer.resource;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.uimanager.UiManagerLogic;
import be.ac.fundp.uimanager.userevent.client.UserEventListner;
import be.ac.fundp.uimanager.userevent.client.UserEventListnerPortType;

/**
 * The Class UserEventResource represents a Rest Resource to receive user
 * events and retransmit it to the process execution. 
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class UserEventResource extends ServerResource {

	protected UiManagerLogic manager = UiManagerLogic.getInstance();
	
    /**
     * This method retransmit a user event to the process execution.
     *
     * @return the summary of the event fired.
     */
    @Get
    public String fireEvent() {
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
        return "event fired";
    }


}