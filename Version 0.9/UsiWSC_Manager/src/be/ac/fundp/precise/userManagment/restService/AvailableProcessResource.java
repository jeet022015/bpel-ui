package be.ac.fundp.precise.userManagment.restService;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.dataManagment.DataManager;
import be.ac.fundp.precise.dataManagment.DataManagerFactory;

public class AvailableProcessResource extends ServerResource {

	protected DataManager uiManager = DataManagerFactory.hibernateDataManager();

    @Get
    public Representation getCode() {
    	List<String> testList = uiManager.getAvailableProcesses();
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