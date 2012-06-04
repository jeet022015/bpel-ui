
package be.ac.fundp.precise.processDeployment.webService;

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
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deploymentVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "deploymentVersion"
})
@XmlRootElement(name = "deployAuiResponse")
public class DeployAuiResponse {

    @XmlElement(required = true)
    protected String deploymentVersion;

    /**
     * Gets the value of the deploymentVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeploymentVersion() {
        return deploymentVersion;
    }

    /**
     * Sets the value of the deploymentVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeploymentVersion(String value) {
        this.deploymentVersion = value;
    }

}
