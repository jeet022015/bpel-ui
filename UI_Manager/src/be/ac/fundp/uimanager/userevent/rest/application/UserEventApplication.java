package be.ac.fundp.uimanager.userevent.rest.application;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import be.ac.fundp.uimanager.userevent.rest.resource.TestEventResource;
import be.ac.fundp.uimanager.userevent.rest.resource.UserEventResource;

// TODO: Auto-generated Javadoc
/**
 * The Class UserEventApplication.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class UserEventApplication extends Application {

    /**
     * Creates a root Restlet that will receive all incoming calls.
     *
     * @return the restlet
     */
    @Override
    public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a new instance of HelloWorldResource.
        Router router = new Router(getContext());

        // Defines only one route
        router.attach("/event/{processId}/{cuiId}", UserEventResource.class);
        router.attach("/test", TestEventResource.class);

        return router;
    }

}