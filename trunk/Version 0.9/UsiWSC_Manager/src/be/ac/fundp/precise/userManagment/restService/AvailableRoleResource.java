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

public class AvailableRoleResource extends ServerResource {

	protected NewDataManagerHibernate uiManager = DataManagerFactory.hibernateDataManager();

    @Get
    public Representation getRole() {
    	String processId = (String) getRequestAttributes().get("process");
    	List<String> testList;
		try {
			testList = uiManager.getAvailableRole(processId);
		} catch (Exception e1) {
			e1.printStackTrace();
			testList = Collections.emptyList();
		}
    	JSONArray array = new JSONArray(testList);
    	JSONObject o = new JSONObject();
    	try {
			o.put("roles", array);
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	JsonRepresentation r = new JsonRepresentation(o);
    	return r;
    }
}