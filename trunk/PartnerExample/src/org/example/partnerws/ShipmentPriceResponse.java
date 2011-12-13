
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
 *         &lt;element name="shipPrice" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "shipPrice"
})
@XmlRootElement(name = "shipmentPriceResponse")
public class ShipmentPriceResponse {

    protected int shipPrice;

    /**
     * Gets the value of the shipPrice property.
     * 
     */
    public int getShipPrice() {
        return shipPrice;
    }

    /**
     * Sets the value of the shipPrice property.
     * 
     */
    public void setShipPrice(int value) {
        this.shipPrice = value;
    }

}
