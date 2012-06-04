package be.ac.fundp.precise.uiwsc.webClient.controller.restServer;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * The Class TestResource a resource to test if the service is on.
 */
public class TestResource extends ServerResource {

    /**
     * A method to test if the server is on.
     *
     * @return the string
     */
    @Get
    public String represent() {
        return "works";
    }

}