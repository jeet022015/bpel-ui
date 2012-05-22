package be.ac.fundp.precise.userManagment.restService;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.dataManagment.DataManager;
import be.ac.fundp.precise.dataManagment.DataManagerFactory;

/**
 * The Class SubscriptionResource is the Rest Resource responsible to 
 * subscribe a user.
 */
public class SubscriptionResource extends ServerResource {

	/** The AuiDeploymentManager singleton. */
	protected DataManager manager = DataManagerFactory.hibernateDataManager();

    /**
     * Subscribe a user.
     *
     * @return the description of the subscription
     */
    @Get
    public String subscribe() {
    	String login = (String) getRequestAttributes().get("login");
    	String password = (String) getRequestAttributes().get("password");
    	String role = (String) getRequestAttributes().get("role");
    	String ipAddress = (String) getRequestAttributes().get("address");
    	String newIpAddress = ipAddress.replaceAll("%3Chttp%3E", "http://").replaceAll("%3Cslash%3E", "/"); 
    	manager.subscribe(login, password, role, newIpAddress);
        return "subscribed";
    }

}