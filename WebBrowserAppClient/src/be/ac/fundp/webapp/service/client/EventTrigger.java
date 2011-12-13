package be.ac.fundp.webapp.service.client;

import be.ac.fundp.webapp.service.eventclient.ManageUserEvent;
import be.ac.fundp.webapp.service.eventclient.ManageUserEvent_Service;

// TODO: Auto-generated Javadoc
/**
 * The Class EventTrigger.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class EventTrigger {

	/**
	 * Fire event.
	 *
	 * @param role the role
	 * @param process the process
	 * @param cuiId the cui id
	 */
	public static void fireEvent(String role, String process, String cuiId) {
		ManageUserEvent_Service ss = new ManageUserEvent_Service();
        ManageUserEvent port = ss.getManageUserEventSOAP();  
        System.out.println("Invoking communicateUserEvent...");
        port.communicateUserEvent(process, cuiId, role);
	}

}
