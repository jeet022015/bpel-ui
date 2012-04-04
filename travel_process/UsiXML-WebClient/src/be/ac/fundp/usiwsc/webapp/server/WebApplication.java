package be.ac.fundp.usiwsc.webapp.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import be.ac.fundp.usiwsc.webapp.server.resource.ResourceUsiXML;
import be.ac.fundp.usiwsc.webapp.server.resource.TestEventResource;

// TODO: Auto-generated Javadoc
/**
 * The Class WebApplication.
 */
public class WebApplication extends Application {
	
	/**
	 * Creates a root Restlet that will receive all incoming calls.
	 *
	 * @return the restlet
	 */
	@Override
	public synchronized Restlet createInboundRoot() {
		// Create a router Restlet that routes each call to a
		// new instance of HelloWorldResource.
		Router router = new Router(getContext());
		// Defines only one route
		//http://localhost:8070/UsiXML-WebClient/restlet/uibpel
		router.attach("/uibpel/{role}/{processId}/{cuiId}", ResourceUsiXML.class);
		router.attach("/test", TestEventResource.class);
		return router;
	}

}
