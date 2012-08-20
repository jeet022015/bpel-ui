//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.01 at 09:52:26 AM CET 
//


package be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JustificationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JustificationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CLAIM"/>
 *     &lt;enumeration value="GROUND"/>
 *     &lt;enumeration value="WARRANT"/>
 *     &lt;enumeration value="BACKING"/>
 *     &lt;enumeration value="REBUTTAL"/>
 *     &lt;enumeration value="QUALIFIER"/>
 *     &lt;enumeration value="UNDEFINED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(namespace = "http://UsiXML-XSD/AbstractUIModel",
name = "JustificationType")
@XmlEnum
public enum JustificationType {


    /**
     * 
     * 						Assertion put forward publicly for general acceptance with the implication that there
     * 						are underlying 'reasons' that could show it to be 'well founded'
     * 						and therefore entitled to be generally accepted.
     * 					
     * 
     */
    CLAIM,

    /**
     * 
     * 						The term 'ground' refers to the specific facts relied on to support a given claim.
     * 					
     * 
     */
    GROUND,

    /**
     * 
     * 						Assertion that entitles you to interpret or link the grounds (facts) as support of the
     * 						claim.
     * 					
     * 
     */
    WARRANT,

    /**
     * 
     * 						The �backing� consists of a very general set of background assumptions which, in effect,
     * 						legitimize the basis for believing in the warrant. That is, if the
     * 						warrant is not accepted on its surface, then the backing is called
     * 						into play to add deeper support to the argument.
     * 					
     * 
     */
    BACKING,

    /**
     * 
     * 						The �rebuttal� presents the possible exceptions or objections as to why the claim, the
     * 						grounds, the warrants, or the backing may not hold for the situation under discussion.
     * 					
     * 
     */
    REBUTTAL,

    /**
     * 
     * 						Word that indicates how strongly the claim is being asserted, or how likely that something
     * 						might occur.
     * 					
     * 
     */
    QUALIFIER,
    
    /** The UNDEFINED. */
    UNDEFINED;

    /**
     * Value.
     *
     * @return the string
     */
    public String value() {
        return name();
    }

    /**
     * From value.
     *
     * @param v the v
     * @return the justification type
     */
    public static JustificationType fromValue(String v) {
        return valueOf(v);
    }

}
