
package be.ac.fundp.uimanager.client.soap.implementation;

import javax.xml.bind.annotation.XmlRegistry;


// TODO: Auto-generated Javadoc
/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the be.ac.fundp.uimanager.client.soap.implementation package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: be.ac.fundp.uimanager.client.soap.implementation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequireAssyncInteraction }.
     *
     * @return the require assync interaction
     */
    public RequireAssyncInteraction createRequireAssyncInteraction() {
        return new RequireAssyncInteraction();
    }

    /**
     * Create an instance of {@link DataItemType }.
     *
     * @return the data item type
     */
    public DataItemType createDataItemType() {
        return new DataItemType();
    }

    /**
     * Create an instance of {@link RequireAssyncInteractionResponse }.
     *
     * @return the require assync interaction response
     */
    public RequireAssyncInteractionResponse createRequireAssyncInteractionResponse() {
        return new RequireAssyncInteractionResponse();
    }

    /**
     * Create an instance of {@link RequireSyncInteractionResponse }.
     *
     * @return the require sync interaction response
     */
    public RequireSyncInteractionResponse createRequireSyncInteractionResponse() {
        return new RequireSyncInteractionResponse();
    }

    /**
     * Create an instance of {@link RequireSyncInteraction }.
     *
     * @return the require sync interaction
     */
    public RequireSyncInteraction createRequireSyncInteraction() {
        return new RequireSyncInteraction();
    }

}
