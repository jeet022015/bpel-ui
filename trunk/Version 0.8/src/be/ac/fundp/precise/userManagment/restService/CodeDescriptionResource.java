package be.ac.fundp.precise.userManagment.restService;

import java.util.Map;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.processDeployment.auiDeployment.AuiDeploymentManager;

/**
 * The Class UserEventResource.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class CodeDescriptionResource extends ServerResource {

	protected AuiDeploymentManager manager = AuiDeploymentManager.getInstance();
	
    /**
     * Represent.
     *
     * @return the string
     */
    @Get
    public Representation getCode() {
    	String role = (String) getRequestAttributes().get("role");
    	String process = (String) getRequestAttributes().get("process");
    	Map<String, String> pathJson = manager.getConf(process, role);
    	JSONObject o = new JSONObject(pathJson);
    	JsonRepresentation r = new JsonRepresentation(o);
    	return r;
    }
}