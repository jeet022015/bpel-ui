package be.ac.fundp.precise.uiwsc.webClient.controller.restServer;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class TestEventResource extends ServerResource {

    @Get
    public String represent() {
        return "works";
    }

}