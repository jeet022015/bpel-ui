
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package be.ac.fundp.webapp.service.eventclient;

import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;

// TODO: Auto-generated Javadoc
/**
 * This class was generated by Apache CXF 2.5.0
 * 2011-11-20T21:07:43.440+01:00
 * Generated source version: 2.5.0
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */

@javax.jws.WebService(
                      serviceName = "ManageUserEvent",
                      portName = "ManageUserEventSOAP",
                      targetNamespace = "http://fundp.ac.be/ManageUserEvent/",
                      wsdlLocation = "http://localhost:8050/UI_Manager/services/ManageUserEventSOAP?wsdl",
                      endpointInterface = "be.ac.fundp.webapp.service.eventclient.ManageUserEvent")
                      
public class ManageUserEventImpl implements ManageUserEvent {

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(ManageUserEventImpl.class.getName());

    /* (non-Javadoc)
     * @see be.ac.fundp.webapp.service.eventclient.ManageUserEvent#communicateUserEvent(java.lang.String  processId ,)java.lang.String  eventId ,)java.lang.String  role )*
     */
    public void communicateUserEvent(java.lang.String processId,java.lang.String eventId,java.lang.String role) { 
        LOG.info("Executing operation communicateUserEvent");
        System.out.println(processId);
        System.out.println(eventId);
        System.out.println(role);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
