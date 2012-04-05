
package be.ac.fundp.uimanager.userevent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;element name="processId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 * &lt;element name="eventId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 * &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string"/>
 * &lt;/sequence>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "processId",
    "eventId",
    "role"
})
@XmlRootElement(name = "communicateUserEvent")
public class CommunicateUserEvent {

    /** The process id. */
    @XmlElement(required = true)
    protected String processId;
    
    /** The event id. */
    @XmlElement(required = true)
    protected String eventId;
    
    /** The role. */
    @XmlElement(required = true)
    protected String role;

    /**
     * Gets the value of the processId property.
     *
     * @return the process id
     * possible object is
     * {@link String }
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * Sets the value of the processId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessId(String value) {
        this.processId = value;
    }

    /**
     * Gets the value of the eventId property.
     *
     * @return the event id
     * possible object is
     * {@link String }
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * Sets the value of the eventId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventId(String value) {
        this.eventId = value;
    }

    /**
     * Gets the value of the role property.
     *
     * @return the role
     * possible object is
     * {@link String }
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

}
