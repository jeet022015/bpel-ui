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


/**
 * <p>Java class for ActionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="modelSearch"/>
 *     &lt;enumeration value="modelCreate"/>
 *     &lt;enumeration value="modelRead"/>
 *     &lt;enumeration value="modelUpdate"/>
 *     &lt;enumeration value="modelDelete"/>
 *     &lt;enumeration value="modelInvoke"/>
 *     &lt;enumeration value="modelReset"/>
 *     &lt;enumeration value="modelCopy"/>
 *     &lt;enumeration value="listenerCreate"/>
 *     &lt;enumeration value="listenerDelete"/>
 *     &lt;enumeration value="eventDispatch"/>
 *     &lt;enumeration value="IUOpen"/>
 *     &lt;enumeration value="IUClose"/>
 *     &lt;enumeration value="IUActivate"/>
 *     &lt;enumeration value="IUDesactivate"/>
 *     &lt;enumeration value="IUEmphasize"/>
 *     &lt;enumeration value="IUDesemphasize"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(namespace = "http://UsiXML-XSD/AbstractUIModel",
		 name = "ActionType")
@XmlEnum
public enum ActionType {


    /** Search for model elements based on logical formula. */
    @XmlEnumValue("modelSearch")
    MODEL_SEARCH("modelSearch"),

    /** Create a new model in the Domain Model. */
    @XmlEnumValue("modelCreate")
    MODEL_CREATE("modelCreate"),

    /** Read a specified field in the Domain Model. */
    @XmlEnumValue("modelRead")
    MODEL_READ("modelRead"),

    /** Update a field in the Domain Model. */
    @XmlEnumValue("modelUpdate")
    MODEL_UPDATE("modelUpdate"),

    /** Delete a field in the Domain Model. */
    @XmlEnumValue("modelDelete")
    MODEL_DELETE("modelDelete"),

    /** Perform a query external to the current Domain Model. */
    @XmlEnumValue("modelInvoke")
    MODEL_INVOKE("modelInvoke"),

    /** Reset the Domain Model with the initial parameters. */
    @XmlEnumValue("modelReset")
    MODEL_RESET("modelReset"),

    /** Copy the Domain Model. */
    @XmlEnumValue("modelCopy")
    MODEL_COPY("modelCopy"),

    /** Create a new listener on a specified AbstractInteractionUnit. */
    @XmlEnumValue("listenerCreate")
    LISTENER_CREATE("listenerCreate"),

    /** Delete a listener of a specified AbstractInteractionUnit. */
    @XmlEnumValue("listenerDelete")
    LISTENER_DELETE("listenerDelete"),

    /** Dispatch the event to another AbstractInteractionUnit. */
    @XmlEnumValue("eventDispatch")
    EVENT_DISPATCH("eventDispatch"),

    /** Open a specified AbstractInteractionUnit. */
    @XmlEnumValue("IUOpen")
    IU_OPEN("IUOpen"),

    /** Close a specified AbstractInteractionUnit. */
    @XmlEnumValue("IUClose")
    IU_CLOSE("IUClose"),

    /** Activate a specified AbstractInteractionUnit. */
    @XmlEnumValue("IUActivate")
    IU_ACTIVATE("IUActivate"),

    /** Desactivate a specified AbstractInteractionUnit. */
    @XmlEnumValue("IUDesactivate")
    IU_DESACTIVATE("IUDesactivate"),

    /** Focus in a specified AbstractInteractionUnit. */
    @XmlEnumValue("IUEmphasize")
    IU_EMPHASIZE("IUEmphasize"),

    /** Focus out a specified AbstractInteractionUnit. */
    @XmlEnumValue("IUDesemphasize")
    IU_DESEMPHASIZE("IUDesemphasize");
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new action type.
     *
     * @param v the v
     */
    ActionType(String v) {
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
     * @return the action type
     */
    public static ActionType fromValue(String v) {
        for (ActionType c: ActionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
