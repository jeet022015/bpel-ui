
package be.ac.fundp.uimanager.userevent.client;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the be.ac.fundp.uimanager.userevent.client package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: be.ac.fundp.uimanager.userevent.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FireEventResponse }.
     *
     * @return the fire event response
     */
    public FireEventResponse createFireEventResponse() {
        return new FireEventResponse();
    }

    /**
     * Create an instance of {@link FireEvent }.
     *
     * @return the fire event
     */
    public FireEvent createFireEvent() {
        return new FireEvent();
    }

}
