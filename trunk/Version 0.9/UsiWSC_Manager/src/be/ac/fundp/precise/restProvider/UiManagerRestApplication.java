package be.ac.fundp.precise.restProvider;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import be.ac.fundp.precise.clientAppMediation.dispatcher.restDispatcher.RestDispatcherResource;
import be.ac.fundp.precise.clientAppMediation.userEvent.rest.UserEventListenerResource;
import be.ac.fundp.precise.processMediation.startProcess.StartProcessResource;
import be.ac.fundp.precise.userManagment.restService.AvailableProcessResource;
import be.ac.fundp.precise.userManagment.restService.AvailableRoleResource;
import be.ac.fundp.precise.userManagment.restService.AvailableStartingRoleResource;
import be.ac.fundp.precise.userManagment.restService.CodeDeliveryResource;
import be.ac.fundp.precise.userManagment.restService.CodeDescriptionResource;
import be.ac.fundp.precise.userManagment.restService.LoginResource;
import be.ac.fundp.precise.userManagment.restService.RegistryProcessResource;
import be.ac.fundp.precise.userManagment.restService.SubscriptionResource;
import be.ac.fundp.precise.userManagment.restService.UserStartableProcessResource;

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
		
		router.attach("/subscribe/{login}/{password}/{address}/{context}", SubscriptionResource.class);
		router.attach("/login/{login}/{password}/{address}/{context}", LoginResource.class);
		router.attach("/{login}/startable", UserStartableProcessResource.class);
		
		
		router.attach("/processes", AvailableProcessResource.class);
		router.attach("/{process}/roles", AvailableRoleResource.class);
		router.attach("/{process}/roles/startable", AvailableStartingRoleResource.class);
		router.attach("/{process}/{role}/registry/{login}", RegistryProcessResource.class);
		router.attach("/{process}/{login}/start", StartProcessResource.class);

		router.attach("/{process}/{role}/code/{context}/desc", CodeDescriptionResource.class);
		router.attach("/{process}/{role}/code/{context}", CodeDeliveryResource.class);
		
		router.attach("/process/{processId}/{login}/{cuiId}/send_data", RestDispatcherResource.class);
		router.attach("/process/{processId}/{login}/{cuiId}/event/{eventId}", UserEventListenerResource.class);
		
        router.attach("/test", TestEventResource.class);
		return router;
	}
}