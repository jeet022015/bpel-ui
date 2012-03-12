
package be.ac.fundp.uimanager.soapServer;

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
 *         &lt;element name="return" type="{http://fundp.ac.be/UiManager/}UiDataType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="processId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userInteracId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "_return",
    "processId",
    "userInteracId",
    "role"
})
@XmlRootElement(name = "selectionOperationResponse")
public class SelectionOperationResponse {

    @XmlElement(name = "return")
    protected List<UiDataType> _return;
    @XmlElement(required = true)
    protected String processId;
    @XmlElement(required = true)
    protected String userInteracId;
    @XmlElement(required = true)
    protected String role;

    /**
     * Gets the value of the return property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the return property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UiDataType }
     * 
     * 
     */
    public List<UiDataType> getReturn() {
        if (_return == null) {
            _return = new ArrayList<UiDataType>();
        }
        return this._return;
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
     * Gets the value of the userInteracId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserInteracId() {
        return userInteracId;
    }

    /**
     * Sets the value of the userInteracId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserInteracId(String value) {
        this.userInteracId = value;
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

}
