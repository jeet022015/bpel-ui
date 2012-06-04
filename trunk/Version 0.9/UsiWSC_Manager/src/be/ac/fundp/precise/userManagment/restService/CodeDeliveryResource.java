package be.ac.fundp.precise.userManagment.restService;

import java.io.IOException;

import org.restlet.data.MediaType;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.processDeployment.auiDeployment.AuiManager;

/**
 * The Class CodeDeliveryResource is the Rest Resource responsible to 
 * delivery the code corresponding to the specific process, for the specific
 * role in the process.
 */
public class CodeDeliveryResource extends ServerResource {

	/** The AuiDeploymentManager singleton. */
	protected AuiManager uiManager = AuiManager.getInstance();
	
    /**
     * Gets the code.
     *
     * @return the Rest Representation that contains the specific code.
     */
    @Get
    public Representation getCode() {
    	String role = (String) getRequestAttributes().get("role");
    	String process = (String) getRequestAttributes().get("process");
    	String context = (String) getRequestAttributes().get("context");
    	//String filePath = manager.getCode(process, role);
    	String filePath;
		try {
			filePath = uiManager.adaptAui(process, role, context);
		} catch (IOException e) {
			e.printStackTrace();
			StringRepresentation r = new StringRepresentation("UI not available.");
    		return r;
		}
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

}