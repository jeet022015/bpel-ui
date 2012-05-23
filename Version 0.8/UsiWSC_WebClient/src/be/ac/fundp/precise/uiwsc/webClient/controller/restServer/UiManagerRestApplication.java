package be.ac.fundp.precise.uiwsc.webClient.controller.restServer;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;


public class UiManagerRestApplication extends Application {

	@Override
	public synchronized Restlet createInboundRoot() {
		// Create a router Restlet that routes each call 
		Router router = new Router(getContext());
		// Defines only one route
		router.attach("/"+RestServerConstants.REST_SERVICE+"/{role}/{processId}/{cuiId}", ResourceUsiXML.class);
        router.attach("/test", TestEventResource.class);
		return router;
	}
}
