package be.ac.fundp.uimanager.restServer;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import be.ac.fundp.uimanager.restServer.resource.LoginResource;
import be.ac.fundp.uimanager.restServer.resource.SubscriptionResource;
import be.ac.fundp.uimanager.restServer.resource.TestEventResource;
import be.ac.fundp.uimanager.restServer.resource.UserEventResource;

public class FirstStepsApplication extends Application {
	/**
	 * Creates a root Restlet that will receive all incoming calls.
	 */
	@Override
	public synchronized Restlet createInboundRoot() {
		// Create a router Restlet that routes each call to a
		// new instance of HelloWorldResource.
		Router router = new Router(getContext());
		// Defines only one route
		router.attach("/event/{role}/{processId}/{cuiId}", UserEventResource.class);
		router.attach("/subscribe/{login}/{password}/{role}/{ipAddress}", SubscriptionResource.class);
		router.attach("/login/{login}/{password}", LoginResource.class);
        router.attach("/test", TestEventResource.class);
		return router;
	}
}