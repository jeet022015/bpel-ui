package be.ac.fundp.precise.userManagment.restService;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.dataManagment.DataManagerFactory;
import be.ac.fundp.precise.dataManagment.hibernate.NewDataManagerHibernate;

/**
 * The Class AvailableStartingRoleResource represents a Rest Resource that identifies
 * all the roles that can start a process.
 */
public class AvailableStartingRoleResource extends ServerResource {

	/** The ui manager. */
	protected NewDataManagerHibernate uiManager = DataManagerFactory.hibernateDataManager();

    /**
     * Gets the Available Starting Roles.
     *
     * @return the Available Starting Roles
     */
    @Get
    public Representation getCode() {
    	String process = (String) getRequestAttributes().get("process");
    	JSONObject o = new JSONObject();
    	try {
	    	List<String> testList = uiManager.getStartingRoles(process);
	    	JSONArray array = new JSONArray(testList);
			o.put("roles", array);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	JsonRepresentation r = new JsonRepresentation(o);
    	return r;
    }

}