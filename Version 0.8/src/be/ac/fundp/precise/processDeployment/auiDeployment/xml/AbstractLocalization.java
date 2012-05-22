//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.01 at 09:52:26 AM CET 
//


package be.ac.fundp.precise.processDeployment.auiDeployment.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 				Describes text attributes for AbstractInteractionUnits. It is useful for internationalization.
 * 			
 * 
 * <p>Java class for AbstractLocalization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractLocalization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="longLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shortLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="help" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="lang" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://UsiXML-XSD/AbstractUIModel",
		 name = "AbstractLocalization", propOrder = {

})
public class AbstractLocalization {

	@XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel", required = true)
    protected String label;
	
	@XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel", required = true)
    protected String longLabel;
	
	@XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel", required = true)
    protected String shortLabel;
	
	@XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel", required = true)
    protected String descLabel;
	
	@XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel", required = true)
    protected String help;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(required = true)
    protected String lang;

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the longLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongLabel() {
        return longLabel;
    }

    /**
     * Sets the value of the longLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongLabel(String value) {
        this.longLabel = value;
    }

    /**
     * Gets the value of the shortLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortLabel() {
        return shortLabel;
    }

    /**
     * Sets the value of the shortLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortLabel(String value) {
        this.shortLabel = value;
    }

    /**
     * Gets the value of the descLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescLabel() {
        return descLabel;
    }

    /**
     * Sets the value of the descLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescLabel(String value) {
        this.descLabel = value;
    }

    /**
     * Gets the value of the help property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHelp() {
        return help;
    }

    /**
     * Sets the value of the help property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHelp(String value) {
        this.help = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

}
