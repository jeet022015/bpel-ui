package be.ac.fundp.precise.uiwsc.webClient.controller.restServer;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import be.ac.fundp.precise.uiwsc.webClient.controller.ControllerConstants;

/**
 * The Class UiManagerRestApplication will receive all incoming calls for the
 * rest services.
 */
public class UiManagerRestApplication extends Application {

	/* (non-Javadoc)
	 * @see org.restlet.Application#createInboundRoot()
	 */
	@Override
	public synchronized Restlet createInboundRoot() { 
		Router router = new Router(getContext());
		router.attach("/"+ServerConstants.REST_SERVICE+
					  "/{"+ControllerConstants.CONTROLLER_PROCESS+"}" +
					  "/{"+ControllerConstants.CONTROLLER_ROLE+"}" +
					  "/{"+ControllerConstants.CONTROLLER_PROCESS_ID+"}" +
					  "/{"+ControllerConstants.CONTROLLER_LOGIN+"}" +
					  "/{"+ControllerConstants.CONTROLLER_CUI_ID+"}", ResourceUsiXML.class);
        router.attach("/test", TestResource.class);
		return router;
	}
}
