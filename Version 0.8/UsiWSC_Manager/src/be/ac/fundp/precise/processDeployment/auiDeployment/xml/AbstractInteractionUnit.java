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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 				Main entity of the model, every abstract object is an AbstractInteractionUnit.
 * 			
 * 
 * <p>Java class for AbstractInteractionUnit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractInteractionUnit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listener" type="{http://UsiXML-XSD/AbstractUIModel}AbstractListener" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="name" type="{http://UsiXML-XSD/AbstractUIModel}AbstractLocalization" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="state" type="{http://UsiXML-XSD/AbstractUIModel}State" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="transition" type="{http://UsiXML-XSD/AbstractUIModel}Transition" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="role" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="importance" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="repetitionFactor" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="hierarchyNumber" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="securityType" type="{http://UsiXML-XSD/AbstractUIModel}AuthenticationType" />
 *       &lt;attribute name="securityMechanism" type="{http://UsiXML-XSD/AbstractUIModel}SecurityMechanism" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://UsiXML-XSD/AbstractUIModel",
		 name = "AbstractInteractionUnit", propOrder = {
    "listener",
    "name",
    "state",
    "transition"
})
@XmlSeeAlso({
    AbstractCompoundIU.class,
    AbstractElementaryIU.class
})
public class AbstractInteractionUnit {

	@XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel",required = true)
    protected List<AbstractListener> listener;
	
	@XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel",required = true)
    protected List<AbstractLocalization> name;
	
	@XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel",required = true)
    protected List<State> state;
	
	@XmlElement(namespace = "http://UsiXML-XSD/AbstractUIModel",required = true)
    protected List<Transition> transition;
	
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute
    protected String role;
    @XmlAttribute
    protected Integer importance;
    @XmlAttribute
    protected Integer repetitionFactor;
    @XmlAttribute
    protected Integer hierarchyNumber;
    @XmlAttribute
    protected AuthenticationType securityType;
    @XmlAttribute
    protected SecurityMechanism securityMechanism;

    /**
     * Gets the value of the listener property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listener property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListener().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractListener }
     * 
     * 
     */
    public List<AbstractListener> getListener() {
        if (listener == null) {
            listener = new ArrayList<AbstractListener>();
        }
        return this.listener;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractLocalization }
     * 
     * 
     */
    public List<AbstractLocalization> getName() {
        if (name == null) {
            name = new ArrayList<AbstractLocalization>();
        }
        return this.name;
    }

    /**
     * Gets the value of the state property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the state property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link State }
     * 
     * 
     */
    public List<State> getState() {
        if (state == null) {
            state = new ArrayList<State>();
        }
        return this.state;
    }

    /**
     * Gets the value of the transition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Transition }
     * 
     * 
     */
    public List<Transition> getTransition() {
        if (transition == null) {
            transition = new ArrayList<Transition>();
        }
        return this.transition;
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
     * Gets the value of the importance property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getImportance() {
        return importance;
    }

    /**
     * Sets the value of the importance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setImportance(Integer value) {
        this.importance = value;
    }

    /**
     * Gets the value of the repetitionFactor property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRepetitionFactor() {
        return repetitionFactor;
    }

    /**
     * Sets the value of the repetitionFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRepetitionFactor(Integer value) {
        this.repetitionFactor = value;
    }

    /**
     * Gets the value of the hierarchyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHierarchyNumber() {
        return hierarchyNumber;
    }

    /**
     * Sets the value of the hierarchyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHierarchyNumber(Integer value) {
        this.hierarchyNumber = value;
    }

    /**
     * Gets the value of the securityType property.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticationType }
     *     
     */
    public AuthenticationType getSecurityType() {
        return securityType;
    }

    /**
     * Sets the value of the securityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticationType }
     *     
     */
    public void setSecurityType(AuthenticationType value) {
        this.securityType = value;
    }

    /**
     * Gets the value of the securityMechanism property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityMechanism }
     *     
     */
    public SecurityMechanism getSecurityMechanism() {
        return securityMechanism;
    }

    /**
     * Sets the value of the securityMechanism property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityMechanism }
     *     
     */
    public void setSecurityMechanism(SecurityMechanism value) {
        this.securityMechanism = value;
    }

}
