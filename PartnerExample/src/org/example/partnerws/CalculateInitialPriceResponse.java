
package org.example.partnerws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="initialPrice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "initialPrice"
})
@XmlRootElement(name = "calculateInitialPriceResponse")
public class CalculateInitialPriceResponse {

    protected int initialPrice;

    /**
     * Gets the value of the initialPrice property.
     * 
     */
    public int getInitialPrice() {
        return initialPrice;
    }

    /**
     * Sets the value of the initialPrice property.
     * 
     */
    public void setInitialPrice(int value) {
        this.initialPrice = value;
    }

}
