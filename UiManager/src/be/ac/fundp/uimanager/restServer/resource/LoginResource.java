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
public class LoginResource extends ServerResource {

	protected UiManagerLogic manager = UiManagerLogic.getInstance();
	
    /**
     * Represent.
     *
     * @return the string
     */
    @Get
    public String verifyUser() {
    	String login = (String) getRequestAttributes().get("login");
    	String password = (String) getRequestAttributes().get("password");
    	String role = manager.verifyUser(login, password);
    	System.out.println("role = "+role);
    	if (role != null)
    		return role;
    	return "fail";
    }

}