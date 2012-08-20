package be.ac.fundp.precise.userManagment.restService;

import java.util.Collections;
import java.util.List;

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
 * The Class AvailableProcessResource represents a Rest Resource for identifing
 * the available processes.
 */
public class AvailableProcessResource extends ServerResource {

	/** The ui manager. */
	protected NewDataManagerHibernate uiManager = DataManagerFactory.hibernateDataManager();

    /**
     * Gets the code.
     *
     * @return the code
     */
    @Get
    public Representation getCode() {
    	List<String> availableProcessList;
		try {
			availableProcessList = uiManager.getAvailableProcesses();
		} catch (Exception e1) {
			e1.printStackTrace();
			availableProcessList = Collections.emptyList();
		}
    	JSONArray array = new JSONArray(availableProcessList);
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