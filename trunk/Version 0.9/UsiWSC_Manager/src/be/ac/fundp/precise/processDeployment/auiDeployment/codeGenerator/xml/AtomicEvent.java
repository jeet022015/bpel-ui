//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.01 at 09:52:26 AM CET 
//


package be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


// TODO: Auto-generated Javadoc
/**
 * <p>Java class for AtomicEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AtomicEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{http://UsiXML-XSD/AbstractUIModel}EventExpression">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://UsiXML-XSD/AbstractUIModel}EventType" minOccurs="0"/>
 *         &lt;element name="specification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://UsiXML-XSD/AbstractUIModel",
		 name = "AtomicEvent", propOrder = {
    "type",
    "specification"
})
public class AtomicEvent
    extends EventExpression
{

	/** The type. */
	@XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel",required = true)
    protected EventType type;
	
	/** The specification. */
	@XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel",required = true)
    protected String specification;

    /**
     * Gets the value of the type property.
     *
     * @return the type
     * possible object is
     * {@link EventType }
     */
    public EventType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventType }
     *     
     */
    public void setType(EventType value) {
        this.type = value;
    }

    /**
     * Gets the value of the specification property.
     *
     * @return the specification
     * possible object is
     * {@link String }
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * Sets the value of the specification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecification(String value) {
        this.specification = value;
    }

}