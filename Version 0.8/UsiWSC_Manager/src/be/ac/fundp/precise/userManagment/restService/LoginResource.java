package be.ac.fundp.precise.userManagment.restService;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.dataManagment.DataManager;
import be.ac.fundp.precise.dataManagment.DataManagerFactory;

/**
 * The Class LoginResource is the Rest Resource responsible to 
 * verify if this user exists.
 */
public class LoginResource extends ServerResource {

	/** The AuiDeploymentManager singleton. */
	protected DataManager manager = DataManagerFactory.hibernateDataManager();

    /**
     * Verify user.
     *
     * @return the user role
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