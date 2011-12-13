
package be.ac.fundp.uimanager.provider;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


// TODO: Auto-generated Javadoc
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
 * &lt;element name="userInteracId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="processid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="data" type="{http://fundp.ac.be/UiManager/}UiDataType" maxOccurs="unbounded" minOccurs="0"/>
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
    "userInteracId",
    "role",
    "processid",
    "data"
})
@XmlRootElement(name = "outputOperation")
public class OutputOperation {

    /** The user interac id. */
    protected String userInteracId;
    
    /** The role. */
    protected String role;
    
    /** The processid. */
    protected String processid;
    
    /** The data. */
    protected List<UiDataType> data;

    /**
     * Gets the value of the userInteracId property.
     *
     * @return the user interac id
     * possible object is
     * {@link String }
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

    /**
     * Gets the value of the processid property.
     *
     * @return the processid
     * possible object is
     * {@link String }
     */
    public String getProcessid() {
        return processid;
    }

    /**
     * Sets the value of the processid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessid(String value) {
        this.processid = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the data property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     *
     * @return the data
     * {@link UiDataType }
     */
    public List<UiDataType> getData() {
        if (data == null) {
            data = new ArrayList<UiDataType>();
        }
        return this.data;
    }

}
