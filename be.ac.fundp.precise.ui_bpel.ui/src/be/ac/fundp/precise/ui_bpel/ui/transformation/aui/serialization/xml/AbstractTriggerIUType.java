//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.01 at 09:52:26 AM CET 
//


package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AbstractTriggerIUType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AbstractTriggerIUType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NAVIGATION"/>
 *     &lt;enumeration value="OPERATION"/>
 *     &lt;enumeration value="OPERATION_NAVIGATION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(namespace = "http://UsiXML-XSD/AbstractUIModel",
		 name = "AbstractTriggerIUType")
@XmlEnum
public enum AbstractTriggerIUType {

    NAVIGATION,
    OPERATION,
    OPERATION_NAVIGATION;

    public String value() {
        return name();
    }

    public static AbstractTriggerIUType fromValue(String v) {
        return valueOf(v);
    }

}