
package be.ac.fundp.webapp.service.provider;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


// TODO: Auto-generated Javadoc
/**
 * <p>Java class for DataItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataItemType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;element name="dataItemId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 * &lt;element name="typeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 * &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
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
@XmlType(name = "DataItemType", propOrder = {
    "dataItemId",
    "typeName",
    "data"
})
public class DataItemType {

    /** The data item id. */
    @XmlElement(required = true)
    protected String dataItemId;
    
    /** The type name. */
    @XmlElement(required = true)
    protected String typeName;
    
    /** The data. */
    @XmlElement(required = true)
    protected Object data;

    /**
     * Gets the value of the dataItemId property.
     *
     * @return the data item id
     * possible object is
     * {@link String }
     */
    public String getDataItemId() {
        return dataItemId;
    }

    /**
     * Sets the value of the dataItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataItemId(String value) {
        this.dataItemId = value;
    }

    /**
     * Gets the value of the typeName property.
     *
     * @return the type name
     * possible object is
     * {@link String }
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets the value of the typeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeName(String value) {
        this.typeName = value;
    }

    /**
     * Gets the value of the data property.
     *
     * @return the data
     * possible object is
     * {@link Object }
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setData(Object value) {
        this.data = value;
    }

}
