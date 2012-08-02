package be.ac.fundp.precise.clientAppMediation.userEvent.rest;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.clientAppMediation.dispatcher.restDispatcher.RestDispatcherDataHolder;
import be.ac.fundp.precise.processMediation.startProcess.webService.ProcessOperations;
import be.ac.fundp.precise.processMediation.startProcess.webService.ProcessOperationsPortType;


/**
 * The Class UserEventResource represents a Rest Resource to receive user
 * events and retransmit it to the process execution. 
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class UserEventListenerResource  extends ServerResource {

	
	protected RestDispatcherDataHolder dataHolder = RestDispatcherDataHolder.getInstance(); 
	
    /**
     * This method retransmit a user event to the process execution.
     *
     * @return the summary of the event fired.
     */
    @Get
    public String fireEvent() {
    	String login = (String) getRequestAttributes().get("login");
    	String processId = (String) getRequestAttributes().get("processId");
    	String cuiID = (String) getRequestAttributes().get("cuiId");
    	System.out.println("login="+login);
    	System.out.println("processId="+processId);
    	System.out.println("cuiID="+cuiID);
    	ProcessOperations ss = new ProcessOperations();
    	ProcessOperationsPortType port = ss.getProcessOperationsSOAP11PortHttp();
        port.fireEvent("cancel", processId);
    	//UserEventListener_Service ss = new UserEventListener_Service();
    	//UserEventListener port = ss.getUserEventListenerSOAP();  
        //port.fireEvent(cuiID, processId);
        return "event fired";
    }


}