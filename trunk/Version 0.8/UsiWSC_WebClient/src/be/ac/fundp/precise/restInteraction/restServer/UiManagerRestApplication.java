package be.ac.fundp.precise.restInteraction.restServer;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import be.ac.fundp.precise.restInteraction.restResource.ResourceUsiXML;
import be.ac.fundp.precise.restInteraction.restResource.TestEventResource;

public class UiManagerRestApplication extends Application {

	/**
	 * Creates a root Restlet that will receive all incoming calls.
	 *
	 * @return the restlet
	 */
	@Override
	public synchronized Restlet createInboundRoot() {
		// Create a router Restlet that routes each call 
		Router router = new Router(getContext());
		// Defines only one route
		router.attach("/uibpel/{role}/{processId}/{cuiId}", ResourceUsiXML.class);
        router.attach("/test", TestEventResource.class);
		return router;
	}
}
