package be.ac.fundp.precise.uiwsc.webClient.model.userManagment;

import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import be.ac.fundp.precise.uiwsc.webClient.model.ConnectionConstants;

public class ProcessRegistationManager {

	
	
	//router.attach("/{process}/{role}/registry/{login}", RegistryProcessResource.class);
	/**
	 * Connect server.
	 *
	 * @param operation the operation
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String register(String process, String role, String login) throws IOException {

		Representation r = null;
		ClientResource itemsResource = null;
		try {
			itemsResource = new ClientResource(ConnectionConstants.USI_WSC_MANAGER_HOST +
					"/"+ process +
					"/"+ role +
					"/registry" +
					"/"+ login);
			r = itemsResource.get();
			return r.getText();
		} finally {
			if (r != null)
				r.release();
			if (itemsResource != null)
				itemsResource.release();
		}
	}
}