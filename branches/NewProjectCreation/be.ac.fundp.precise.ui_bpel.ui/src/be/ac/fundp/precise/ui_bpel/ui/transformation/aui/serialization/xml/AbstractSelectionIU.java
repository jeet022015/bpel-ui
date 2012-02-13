//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.27 at 03:49:22 PM CET 
//


package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Special type of AbstractCompoundIU representing a way to interact with the interface
 * 				by selecting an item in a list.
 * 			
 * 
 * <p>Java class for AbstractSelectionIU complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractSelectionIU">
 *   &lt;complexContent>
 *     &lt;extension base="{http://UsiXML-XSD/AbstractUIModel}AbstractCompoundIU">
 *       &lt;sequence>
 *         &lt;element name="orderCriteria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="isContinuous" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="start" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="end" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="step" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="isExpendable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="selectionType" type="{http://UsiXML-XSD/AbstractUIModel}SelectionType" />
 *       &lt;attribute name="rating" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractSelectionIU", propOrder = {
    "orderCriteria"
})
public class AbstractSelectionIU
    extends AbstractCompoundIU
{

    protected String orderCriteria;
    @XmlAttribute
    protected Boolean isContinuous;
    @XmlAttribute
    protected Float start;
    @XmlAttribute
    protected Float end;
    @XmlAttribute
    protected Float step;
    @XmlAttribute
    protected Boolean isExpendable;
    @XmlAttribute
    protected SelectionType selectionType;
    @XmlAttribute
    protected Boolean rating;

    /**
     * Gets the value of the orderCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderCriteria() {
        return orderCriteria;
    }

    /**
     * Sets the value of the orderCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderCriteria(String value) {
        this.orderCriteria = value;
    }

    /**
     * Gets the value of the isContinuous property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsContinuous() {
        return isContinuous;
    }

    /**
     * Sets the value of the isContinuous property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsContinuous(Boolean value) {
        this.isContinuous = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setStart(Float value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setEnd(Float value) {
        this.end = value;
    }

    /**
     * Gets the value of the step property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getStep() {
        return step;
    }

    /**
     * Sets the value of the step property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setStep(Float value) {
        this.step = value;
    }

    /**
     * Gets the value of the isExpendable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsExpendable() {
        return isExpendable;
    }

    /**
     * Sets the value of the isExpendable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsExpendable(Boolean value) {
        this.isExpendable = value;
    }

    /**
     * Gets the value of the selectionType property.
     * 
     * @return
     *     possible object is
     *     {@link SelectionType }
     *     
     */
    public SelectionType getSelectionType() {
        return selectionType;
    }

    /**
     * Sets the value of the selectionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectionType }
     *     
     */
    public void setSelectionType(SelectionType value) {
        this.selectionType = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRating(Boolean value) {
        this.rating = value;
    }

}
