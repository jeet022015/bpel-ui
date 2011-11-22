package be.ac.fundp.precise.uibpel.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.engine.Engine;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.routing.Router;

import be.ac.fundp.precise.uibpel.server.resource.UIAssyncServerResource;
import be.ac.fundp.precise.uibpel.server.resource.UISyncServerResource;

public class AndroidServerApplication extends Application {

	/**
     * Creates a root Restlet that will receive all incoming calls.
     */
	@Override
    public Restlet createInboundRoot() {
    	
    	Engine.getInstance().getRegisteredConverters().add(new JacksonConverter());
        // Create a router Restlet that routes each call to a new instance of HelloWorldResource.
        Router router = new Router(getContext());
        
        //router.setRetryDelay(21600000);
        router.setMaxAttempts(300);
        
        router.attach("/assync", UIAssyncServerResource.class);
        router.attach("/sync/{cuiId}", UISyncServerResource.class);

        return router;
    }
}
//358 228