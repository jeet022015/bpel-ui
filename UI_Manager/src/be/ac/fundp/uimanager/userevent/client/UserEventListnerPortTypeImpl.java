
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package be.ac.fundp.uimanager.userevent.client;

import java.util.logging.Logger;

/**
 * This class was generated by Apache CXF 2.5.0
 * 2011-11-20T20:38:12.363+01:00
 * Generated source version: 2.5.0
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */

@javax.jws.WebService(
                      serviceName = "UserEventListner",
                      portName = "UserEventListnerSOAP11port_http",
                      targetNamespace = "http://precise.fundp.ac.be/UserEventListener/",
                      wsdlLocation = "http://localhost:8080/ode/processes/UserEventListner?wsdl",
                      endpointInterface = "be.ac.fundp.uimanager.userevent.client.UserEventListnerPortType")
                      
public class UserEventListnerPortTypeImpl implements UserEventListnerPortType {

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(UserEventListnerPortTypeImpl.class.getName());

    /* (non-Javadoc)
     * @see be.ac.fundp.uimanager.userevent.client.UserEventListnerPortType#fireEvent(java.lang.String  eventId ,)java.lang.String  processId )*
     */
    public void fireEvent(java.lang.String eventId,java.lang.String processId) { 
        LOG.info("Executing operation fireEvent");
        System.out.println(eventId);
        System.out.println(processId);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
