package be.ac.fundp.precise.userManagment.restService;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.dataManagment.DataManager;
import be.ac.fundp.precise.dataManagment.DataManagerFactory;

/**
 * The Class UserEventResource.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class LoginResource extends ServerResource {

	protected DataManager manager = DataManagerFactory.hibernateDataManager();
	
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
    	if (role != null)
    		return role;
    	return "fail";
    }

}