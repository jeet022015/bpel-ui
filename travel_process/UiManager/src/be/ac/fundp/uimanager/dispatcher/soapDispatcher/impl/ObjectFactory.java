
package be.ac.fundp.uimanager.dispatcher.soapDispatcher.impl;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the be.ac.fundp.uimanager.dispatcher.soapDispatcher.impl package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: be.ac.fundp.uimanager.dispatcher.soapDispatcher.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequireAssyncInteraction }
     * 
     */
    public RequireAssyncInteraction createRequireAssyncInteraction() {
        return new RequireAssyncInteraction();
    }

    /**
     * Create an instance of {@link DataItemType }
     * 
     */
    public DataItemType createDataItemType() {
        return new DataItemType();
    }

    /**
     * Create an instance of {@link RequireAssyncInteractionResponse }
     * 
     */
    public RequireAssyncInteractionResponse createRequireAssyncInteractionResponse() {
        return new RequireAssyncInteractionResponse();
    }

    /**
     * Create an instance of {@link RequireSyncInteractionResponse }
     * 
     */
    public RequireSyncInteractionResponse createRequireSyncInteractionResponse() {
        return new RequireSyncInteractionResponse();
    }

    /**
     * Create an instance of {@link RequireSyncInteraction }
     * 
     */
    public RequireSyncInteraction createRequireSyncInteraction() {
        return new RequireSyncInteraction();
    }

}
