//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.27 at 03:49:22 PM CET 
//


package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthenticationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuthenticationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="USER_PASSWORD"/>
 *     &lt;enumeration value="INTEGRATED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuthenticationType")
@XmlEnum
public enum AuthenticationType {

    NONE,
    USER_PASSWORD,
    INTEGRATED;

    public String value() {
        return name();
    }

    public static AuthenticationType fromValue(String v) {
        return valueOf(v);
    }

}
