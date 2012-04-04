package be.ac.fundp.uimanager.restServer.resource;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.uimanager.UiManagerLogic;

/**
 * The Class UserEventResource.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class SubscriptionResource extends ServerResource {

	protected UiManagerLogic manager = UiManagerLogic.getInstance();
	
    /**
     * Represent.
     *
     * @return the string
     */
    @Get
    public String subscribe() {
    	String login = (String) getRequestAttributes().get("login");
    	String password = (String) getRequestAttributes().get("password");
    	String role = (String) getRequestAttributes().get("role");
    	String ipAddress = (String) getRequestAttributes().get("ipAddress");
    	String newIpAddress = ipAddress.replaceAll("%3Chttp%3E", "http://").replaceAll("%3Cslash%3E", "/"); 
    	manager.subscribe(login, password, role, newIpAddress);
    	System.out.println("login subscribed="+login);
    	System.out.println("ip="+newIpAddress);
        return "subscribed";
    }

}