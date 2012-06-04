//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.01 at 09:52:26 AM CET 
//


package be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


// TODO: Auto-generated Javadoc
/**
 * <p>Java class for EventType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EventType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="onDataInput"/>
 *     &lt;enumeration value="onErroneousDataInput"/>
 *     &lt;enumeration value="onDataOutput"/>
 *     &lt;enumeration value="onDataSelection"/>
 *     &lt;enumeration value="onOperationTrigger"/>
 *     &lt;enumeration value="onNavigationTrigger"/>
 *     &lt;enumeration value="onFocusIn"/>
 *     &lt;enumeration value="onFocusOut"/>
 *     &lt;enumeration value="onModelUpdate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(namespace = "http://UsiXML-XSD/AbstractUIModel",
name = "EventType")
@XmlEnum
public enum EventType {


    /** New data has been entered by the user. */
    @XmlEnumValue("onDataInput")
    ON_DATA_INPUT("onDataInput"),

    /** New erroneous data has been entered by the user. */
    @XmlEnumValue("onErroneousDataInput")
    ON_ERRONEOUS_DATA_INPUT("onErroneousDataInput"),

    /** New data has been output through the interface. */
    @XmlEnumValue("onDataOutput")
    ON_DATA_OUTPUT("onDataOutput"),

    /** Some data has been selected by the user. */
    @XmlEnumValue("onDataSelection")
    ON_DATA_SELECTION("onDataSelection"),

    /** An AbstractOperationIU has been activated. */
    @XmlEnumValue("onOperationTrigger")
    ON_OPERATION_TRIGGER("onOperationTrigger"),

    /** An AbstractNavigationIU has been activated. */
    @XmlEnumValue("onNavigationTrigger")
    ON_NAVIGATION_TRIGGER("onNavigationTrigger"),

    /** An AbstractInteractionUnit has been focused in. */
    @XmlEnumValue("onFocusIn")
    ON_FOCUS_IN("onFocusIn"),

    /** An AbstractInteractionUnit has been focused out. */
    @XmlEnumValue("onFocusOut")
    ON_FOCUS_OUT("onFocusOut"),

    /** The Domain Model has been updated. */
    @XmlEnumValue("onModelUpdate")
    ON_MODEL_UPDATE("onModelUpdate");
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new event type.
     *
     * @param v the v
     */
    EventType(String v) {
        value = v;
    }

    /**
     * Value.
     *
     * @return the string
     */
    public String value() {
        return value;
    }

    /**
     * From value.
     *
     * @param v the v
     * @return the event type
     */
    public static EventType fromValue(String v) {
        for (EventType c: EventType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
