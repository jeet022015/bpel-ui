
package be.ac.fundp.precise.processDeployment.webService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for uiMappingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="uiMappingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activityId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iuId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uiMappingType", propOrder = {
    "activityId",
    "iuId"
})
public class UiMappingType {

    @XmlElement(required = true)
    protected String activityId;
    @XmlElement(required = true)
    protected String iuId;

    /**
     * Gets the value of the activityId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityId() {
        return activityId;
    }

    /**
     * Sets the value of the activityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityId(String value) {
        this.activityId = value;
    }

    /**
     * Gets the value of the iuId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIuId() {
        return iuId;
    }

    /**
     * Sets the value of the iuId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIuId(String value) {
        this.iuId = value;
    }

}
