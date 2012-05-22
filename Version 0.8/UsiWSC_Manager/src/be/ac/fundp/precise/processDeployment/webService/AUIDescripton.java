
package be.ac.fundp.precise.processDeployment.webService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AUI_Descripton complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AUI_Descripton">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="aui_entry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uiMapping" type="{http://precise.funpd.ac.be/AuiDeployer}uiMappingType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AUI_Descripton", propOrder = {
    "role",
    "auiEntry",
    "uiMapping"
})
public class AUIDescripton {

    @XmlElement(required = true)
    protected String role;
    @XmlElement(name = "aui_entry", required = true)
    protected String auiEntry;
    @XmlElement(required = true)
    protected List<UiMappingType> uiMapping;

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
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

    /**
     * Gets the value of the auiEntry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuiEntry() {
        return auiEntry;
    }

    /**
     * Sets the value of the auiEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuiEntry(String value) {
        this.auiEntry = value;
    }

    /**
     * Gets the value of the uiMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uiMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUiMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UiMappingType }
     * 
     * 
     */
    public List<UiMappingType> getUiMapping() {
        if (uiMapping == null) {
            uiMapping = new ArrayList<UiMappingType>();
        }
        return this.uiMapping;
    }

}
