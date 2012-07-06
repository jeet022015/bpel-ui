package be.ac.fundp.precise.userManagment.restService;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.dataManagment.DataManagerFactory;
import be.ac.fundp.precise.dataManagment.hibernate.NewDataManagerHibernate;

/**
 * The Class SubscriptionResource is the Rest Resource responsible to 
 * subscribe a user.
 */
public class SubscriptionResource extends ServerResource {

	/** The AuiDeploymentManager singleton. */
	//protected DataManager manager = DataManagerFactory.hibernateDataManager();
	protected NewDataManagerHibernate uiManager = DataManagerFactory.hibernateDataManager();

    /**
     * Subscribe a user.
     *
     * @return the description of the subscription
     */
    @Get
    public Representation subscribe() {
    	String login = (String) getRequestAttributes().get("login");
    	String password = (String) getRequestAttributes().get("password");
    	String hostAdress = (String) getRequestAttributes().get("address");
    	//String role = (String) getRequestAttributes().get("role");
    	//String ipAddress = (String) getRequestAttributes().get("address");
    	String newIpAddress = hostAdress.replaceAll("%3Chttp%3E", "http://").replaceAll("%3Cslash%3E", "/");
    	//uiManager.subscribe(login, password, role, newIpAddress);
    	try {
			uiManager.subscribeUser(login, password, newIpAddress);
		} catch (Exception e) {
			e.printStackTrace();
			return new StringRepresentation("fail");
		}
        return new StringRepresentation("subscribed");
    }

}