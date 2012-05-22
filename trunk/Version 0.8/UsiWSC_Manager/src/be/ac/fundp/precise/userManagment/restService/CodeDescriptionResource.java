package be.ac.fundp.precise.userManagment.restService;

import java.util.Map;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.processDeployment.auiDeployment.AuiDeploymentManager;

/**
 * The Class CodeDescriptionResource is the Rest Resource responsible to 
 * delivery the description of the code corresponding to the specific process, for the specific
 * role in the process.
 */
public class CodeDescriptionResource extends ServerResource {

	/** The AuiDeploymentManager singleton. */
	protected AuiDeploymentManager manager = AuiDeploymentManager.getInstance();

    /**
     * Gets the code description.
     *
     * @return  the Rest Representation that contains code description
     */
    @Get
    public Representation getCodeDescription() {
    	String role = (String) getRequestAttributes().get("role");
    	String process = (String) getRequestAttributes().get("process");
    	Map<String, String> pathJson = manager.getConf(process, role);
    	JSONObject o = new JSONObject(pathJson);
    	JsonRepresentation r = new JsonRepresentation(o);
    	return r;
    }
}