
package be.ac.fundp.webapp.service.eventclient;

import javax.xml.bind.annotation.XmlRegistry;


// TODO: Auto-generated Javadoc
/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the be.ac.fundp.webapp.service.eventclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: be.ac.fundp.webapp.service.eventclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CommunicateUserEvent }.
     *
     * @return the communicate user event
     */
    public CommunicateUserEvent createCommunicateUserEvent() {
        return new CommunicateUserEvent();
    }

    /**
     * Create an instance of {@link CommunicateUserEventResponse }.
     *
     * @return the communicate user event response
     */
    public CommunicateUserEventResponse createCommunicateUserEventResponse() {
        return new CommunicateUserEventResponse();
    }

}
