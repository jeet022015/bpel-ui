//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.27 at 03:49:22 PM CET 
//


package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Interaction unit allowing triggering an event.
 * 			
 * 
 * <p>Java class for AbstractTriggerIU complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractTriggerIU">
 *   &lt;complexContent>
 *     &lt;extension base="{http://UsiXML-XSD/AbstractUIModel}AbstractElementaryIU">
 *       &lt;sequence>
 *         &lt;element name="triggerIUType" type="{http://UsiXML-XSD/AbstractUIModel}AbstractTriggerIUType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractTriggerIU", propOrder = {
    "triggerIUType"
})
public class AbstractTriggerIU
    extends AbstractElementaryIU
{

    protected AbstractTriggerIUType triggerIUType;

    /**
     * Gets the value of the triggerIUType property.
     * 
     * @return
     *     possible object is
     *     {@link AbstractTriggerIUType }
     *     
     */
    public AbstractTriggerIUType getTriggerIUType() {
        return triggerIUType;
    }

    /**
     * Sets the value of the triggerIUType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AbstractTriggerIUType }
     *     
     */
    public void setTriggerIUType(AbstractTriggerIUType value) {
        this.triggerIUType = value;
    }

}
