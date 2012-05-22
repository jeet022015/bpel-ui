package be.ac.fundp.precise.userManagment.restService;

import org.restlet.data.MediaType;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.processDeployment.auiDeployment.AuiDeploymentManager;

/**
 * The Class CodeDeliveryResource is the Rest Resource responsible to 
 * delivery the code corresponding to the specific process, for the specific
 * role in the process.
 */
public class CodeDeliveryResource extends ServerResource {

	/** The AuiDeploymentManager singleton. */
	protected AuiDeploymentManager manager = AuiDeploymentManager.getInstance();
	
    /**
     * Gets the code.
     *
     * @return the Rest Representation that contains the specific code.
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

	/**
	 * Gets the path to the zip file that contains the code to delivery.
	 *
	 * @param process the process id
	 * @param role the role id
	 * @return the path to the zip file
	 */
	private String getPath(String process, String role) {
		return manager.getCode(process, role);
	}

}