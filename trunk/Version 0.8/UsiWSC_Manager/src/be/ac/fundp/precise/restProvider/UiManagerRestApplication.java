package be.ac.fundp.precise.restProvider;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import be.ac.fundp.precise.clientAppMediation.dispatcher.restDispatcher.RestDispatcherResource;
import be.ac.fundp.precise.clientAppMediation.userEvent.rest.UserEventListenerResource;
import be.ac.fundp.precise.userManagment.restService.CodeDeliveryResource;
import be.ac.fundp.precise.userManagment.restService.CodeDescriptionResource;
import be.ac.fundp.precise.userManagment.restService.LoginResource;
import be.ac.fundp.precise.userManagment.restService.SubscriptionResource;

/**
 * The Class UiManagerRestApplication.
 */
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
		router.attach("/{process}/{role}/subscribe/{login}/{password}/{address}", SubscriptionResource.class);
		router.attach("/{process}/{role}/login/{login}/{password}/{address}", LoginResource.class);

		router.attach("/{process}/{role}/code/{context}/desc", CodeDescriptionResource.class);
		router.attach("/{process}/{role}/code/{context}", CodeDeliveryResource.class);
		
		router.attach("/process/{processId}/{role}/{cuiId}/send_data", RestDispatcherResource.class);
		router.attach("/process/{processId}/{role}/{cuiId}/event/{eventId}", UserEventListenerResource.class);
		
        router.attach("/test", TestEventResource.class);
		return router;
	}
}