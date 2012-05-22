
package be.ac.fundp.precise.processDeployment.webService;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="auiZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="processZip" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="processId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uiDescription" type="{http://precise.funpd.ac.be/AuiDeployer}AUI_Descripton" maxOccurs="unbounded"/>
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
    "auiZip",
    "processZip",
    "processId",
    "uiDescription"
})
@XmlRootElement(name = "deployProcess")
public class DeployProcess {

    @XmlElement(required = true)
    protected byte[] auiZip;
    @XmlElement(required = true)
    protected byte[] processZip;
    @XmlElement(required = true)
    protected String processId;
    @XmlElement(required = true)
    protected List<AUIDescripton> uiDescription;

    /**
     * Gets the value of the auiZip property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAuiZip() {
        return auiZip;
    }

    /**
     * Sets the value of the auiZip property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAuiZip(byte[] value) {
        this.auiZip = value;
    }

    /**
     * Gets the value of the processZip property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getProcessZip() {
        return processZip;
    }

    /**
     * Sets the value of the processZip property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setProcessZip(byte[] value) {
        this.processZip = value;
    }

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
     * Gets the value of the uiDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uiDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUiDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AUIDescripton }
     * 
     * 
     */
    public List<AUIDescripton> getUiDescription() {
        if (uiDescription == null) {
            uiDescription = new ArrayList<AUIDescripton>();
        }
        return this.uiDescription;
    }

}
