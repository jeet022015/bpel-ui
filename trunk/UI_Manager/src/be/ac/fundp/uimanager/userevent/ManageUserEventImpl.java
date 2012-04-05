
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package be.ac.fundp.uimanager.userevent;

import java.util.logging.Logger;

import be.ac.fundp.uimanager.userevent.client.UserEventListner;
import be.ac.fundp.uimanager.userevent.client.UserEventListnerPortType;

/**
 * This class was generated by Apache CXF 2.5.0
 * 2011-11-20T20:30:13.029+01:00
 * Generated source version: 2.5.0
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */

@javax.jws.WebService(
                      serviceName = "ManageUserEvent",
                      portName = "ManageUserEventSOAP",
                      targetNamespace = "http://fundp.ac.be/ManageUserEvent/",
                      wsdlLocation = "http://www.example.org/?wsdl",
                      endpointInterface = "be.ac.fundp.uimanager.userevent.ManageUserEvent")
                      
public class ManageUserEventImpl implements ManageUserEvent {

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(ManageUserEventImpl.class.getName());

    /* (non-Javadoc)
     * @see be.ac.fundp.uimanager.userevent.ManageUserEvent#communicateUserEvent(java.lang.String  processId ,)java.lang.String  eventId ,)java.lang.String  role )*
     */
    public void communicateUserEvent(java.lang.String processId,java.lang.String eventId,java.lang.String role) { 
        LOG.info("Executing operation communicateUserEvent");
        System.out.println(processId);
        System.out.println(eventId);
        System.out.println(role);
        
        UserEventListner ss = new UserEventListner();
        UserEventListnerPortType port = ss.getUserEventListnerSOAP11PortHttp();  

        port.fireEvent(eventId, processId);

        System.out.println("Communication User Event");
    }

}
