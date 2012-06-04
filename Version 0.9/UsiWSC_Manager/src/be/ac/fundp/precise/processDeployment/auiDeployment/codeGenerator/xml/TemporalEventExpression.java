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
 * <p>Java class for TemporalEventExpression complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TemporalEventExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{http://UsiXML-XSD/AbstractUIModel}EventExpression">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://UsiXML-XSD/AbstractUIModel}TemporalOperator" minOccurs="0"/>
 *         &lt;element name="previous" type="{http://UsiXML-XSD/AbstractUIModel}EventExpression"/>
 *         &lt;element name="next" type="{http://UsiXML-XSD/AbstractUIModel}EventExpression"/>
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
		 name = "TemporalEventExpression", propOrder = {
    "type",
    "previous",
    "next"
})
public class TemporalEventExpression
    extends EventExpression
{

	/** The type. */
	@XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel",required = true)
    protected TemporalOperator type;
    
    /** The previous. */
    @XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel",required = true)
    protected EventExpression previous;
    
    /** The next. */
    @XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel",required = true)
    protected EventExpression next;

    /**
     * Gets the value of the type property.
     *
     * @return the type
     * possible object is
     * {@link TemporalOperator }
     */
    public TemporalOperator getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemporalOperator }
     *     
     */
    public void setType(TemporalOperator value) {
        this.type = value;
    }

    /**
     * Gets the value of the previous property.
     *
     * @return the previous
     * possible object is
     * {@link EventExpression }
     */
    public EventExpression getPrevious() {
        return previous;
    }

    /**
     * Sets the value of the previous property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventExpression }
     *     
     */
    public void setPrevious(EventExpression value) {
        this.previous = value;
    }

    /**
     * Gets the value of the next property.
     *
     * @return the next
     * possible object is
     * {@link EventExpression }
     */
    public EventExpression getNext() {
        return next;
    }

    /**
     * Sets the value of the next property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventExpression }
     *     
     */
    public void setNext(EventExpression value) {
        this.next = value;
    }

}
