
package be.ac.fundp.precise.processMediation.userEvent.webService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PendingInteraction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PendingInteraction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="processId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cuiId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PendingInteraction", propOrder = {
    "processId",
    "cuiId"
})
public class PendingInteraction {

    @XmlElement(required = true)
    protected String processId;
    @XmlElement(required = true)
    protected String cuiId;

    /**
     * Gets the value of the processId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
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
     * Gets the value of the cuiId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuiId() {
        return cuiId;
    }

    /**
     * Sets the value of the cuiId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuiId(String value) {
        this.cuiId = value;
    }

}
