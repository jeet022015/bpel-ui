//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.01 at 09:52:26 AM CET 
//


package be.ac.fundp.precise.processDeployment.auiDeployment.xml;

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
 *         &lt;element name="abstractCompoundIUs" type="{http://UsiXML-XSD/AbstractUIModel}AbstractCompoundIU" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://UsiXML-XSD/AbstractUIModel",
		 name = "abstractUIModel", propOrder = {
    "abstractCompoundIUs"
})
@XmlRootElement(name = "abstractUIModel")
public class AbstractUIModel {

	@XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel",required = true)
    protected List<AbstractCompoundIU> abstractCompoundIUs;

    /**
     * Gets the value of the abstractCompoundIUs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractCompoundIUs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractCompoundIUs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractCompoundIU }
     * 
     * 
     */
    public List<AbstractCompoundIU> getAbstractCompoundIUs() {
        if (abstractCompoundIUs == null) {
            abstractCompoundIUs = new ArrayList<AbstractCompoundIU>();
        }
        return this.abstractCompoundIUs;
    }

}
