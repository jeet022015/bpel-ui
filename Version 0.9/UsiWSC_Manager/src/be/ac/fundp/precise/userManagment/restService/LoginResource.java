package be.ac.fundp.precise.userManagment.restService;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.dataManagment.DataManagerFactory;
import be.ac.fundp.precise.dataManagment.hibernate.NewDataManagerHibernate;

/**
 * The Class LoginResource is the Rest Resource responsible to 
 * verify if this user exists.
 */
public class LoginResource extends ServerResource {

	/** The AuiDeploymentManager singleton. */
	//protected DataManager manager = DataManagerFactory.hibernateDataManager();
	protected NewDataManagerHibernate uiManager = DataManagerFactory.hibernateDataManager();

    /**
     * Verify user.
     *
     * @return the user role
     */
    @Get
    public Representation verifyUser() {
    	String login = (String) getRequestAttributes().get("login");
    	String password = (String) getRequestAttributes().get("password");
    	String hostAdress = (String) getRequestAttributes().get("address");
    	String newIpAddress = hostAdress.replaceAll("%3Chttp%3E", "http://").replaceAll("%3Cslash%3E", "/");
    	if (uiManager.verifyUser(login, password))
    		return new StringRepresentation("ok");
    	return new StringRepresentation("fail");
    }

}