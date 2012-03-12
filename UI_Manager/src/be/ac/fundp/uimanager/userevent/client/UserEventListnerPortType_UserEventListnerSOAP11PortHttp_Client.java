
package be.ac.fundp.uimanager.userevent.client;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;

// TODO: Auto-generated Javadoc
/**
 * This class was generated by Apache CXF 2.5.0
 * 2011-11-20T20:38:12.304+01:00
 * Generated source version: 2.5.0
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public final class UserEventListnerPortType_UserEventListnerSOAP11PortHttp_Client {

    /** The Constant SERVICE_NAME. */
    private static final QName SERVICE_NAME = new QName("http://precise.fundp.ac.be/UserEventListener/", "UserEventListner");

    /**
     * Instantiates a new user event listner port type_ user event listner soa p11 port http_ client.
     */
    private UserEventListnerPortType_UserEventListnerSOAP11PortHttp_Client() {
    }

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = UserEventListner.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        UserEventListner ss = new UserEventListner(wsdlURL, SERVICE_NAME);
        UserEventListnerPortType port = ss.getUserEventListnerSOAP11PortHttp();  
        
        {
        System.out.println("Invoking fireEvent...");
        java.lang.String _fireEvent_eventId = "_fireEvent_eventId-1559149395";
        java.lang.String _fireEvent_processId = "_fireEvent_processId1538383672";
        port.fireEvent(_fireEvent_eventId, _fireEvent_processId);


        }

        System.exit(0);
    }

}