
package be.ac.fundp.uimanager.dispatcher.soapDispatcher.impl;

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
 *         &lt;element name="cuiId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="inputData" type="{http://webApp.fundp.ac.be}DataItemType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processId" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "cuiId",
    "inputData",
    "role",
    "processId"
})
@XmlRootElement(name = "requireSyncInteraction")
public class RequireSyncInteraction {

    @XmlElement(required = true)
    protected String cuiId;
    protected List<DataItemType> inputData;
    protected String role;
    @XmlElement(required = true)
    protected String processId;

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

    /**
     * Gets the value of the inputData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataItemType }
     * 
     * 
     */
    public List<DataItemType> getInputData() {
        if (inputData == null) {
            inputData = new ArrayList<DataItemType>();
        }
        return this.inputData;
    }

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

}
