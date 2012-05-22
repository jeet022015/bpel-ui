package be.ac.fundp.precise.userManagment.restService;

import org.restlet.data.MediaType;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.processDeployment.auiDeployment.AuiDeploymentManager;

/**
 * The Class UserEventResource.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class CodeDeliveryResource extends ServerResource {

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
    	String filePath = getPath(process, role);
    	System.out.println("filePath="+ filePath);
    	System.out.println("role="+ role);
    	if (filePath == null){
    		StringRepresentation r = new StringRepresentation("UI not available.");
    		return r;
    	}
    	FileRepresentation fr = new FileRepresentation(
    			filePath, MediaType.APPLICATION_ZIP);
        return fr;
    }

	private String getPath(String process, String role) {
		return manager.getCode(process, role);
	}

}