package be.ac.fundp.precise.userManagment.restService;

import java.util.Collection;
import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.dataManagment.DataManagerFactory;
import be.ac.fundp.precise.dataManagment.hibernate.NewDataManagerHibernate;

/**
 * The Class UserStartableProcessResource.
 */
public class UserStartableProcessResource extends ServerResource {

	/** The ui manager. */
	protected NewDataManagerHibernate uiManager = DataManagerFactory.hibernateDataManager();

    /**
     * Gets the code.
     *
     * @return the code
     */
    @Get
    public Representation getCode() {
    	Collection<String> testList;
    	String user = (String) getRequestAttributes().get("login");
		try {
			testList = uiManager.getStartableProcess(user);
		} catch (Exception e1) {
			e1.printStackTrace();
			testList = Collections.emptyList();
		}
    	JSONArray array = new JSONArray(testList);
    	JSONObject o = new JSONObject();
    	try {
			o.put("processes", array);
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	JsonRepresentation r = new JsonRepresentation(o);
    	return r;
    }
}