package be.ac.precise.usixml.androidapp.service.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.engine.Engine;
import org.restlet.ext.httpclient.HttpClientHelper;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.routing.Router;

import be.ac.precise.usixml.androidapp.service.server.resource.TestServerResource;
import be.ac.precise.usixml.androidapp.service.server.resource.UsixmlServerResource;
import be.ac.precise.usixml.androidapp.util.AndroidAppConstants;

public class AndroidServerApplication extends Application {

	/**
     * Creates a root Restlet that will receive all incoming calls.
     */
	@Override
    public Restlet createInboundRoot() {
    	
		Engine.getInstance().getRegisteredClients().clear();
    	Engine.getInstance().getRegisteredConverters().add(new JacksonConverter());
    	Engine.getInstance().getRegisteredClients().add(new HttpClientHelper(null));
        // Create a router Restlet that routes each call to a new instance of HelloWorldResource.
        Router router = new Router(getContext());
        
        router.setMaxAttempts(300);
        
        router.attach("/test", TestServerResource.class);
        router.attach("/uibpel/{"+AndroidAppConstants.PARAM_ROLE+"}"+
        			  "/{"+AndroidAppConstants.PARAM_PROCESS+"}" +
        			  "/{"+ AndroidAppConstants.PARAM_INTERACTION+"}",
        		UsixmlServerResource.class);

        return router;
    }
}
//358 228