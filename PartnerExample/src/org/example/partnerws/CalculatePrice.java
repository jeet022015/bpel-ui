
package org.example.partnerws;

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
 *         &lt;element name="initialPrice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="shipPrice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="product" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "initialPrice",
    "shipPrice",
    "product"
})
@XmlRootElement(name = "calculatePrice")
public class CalculatePrice {

    protected int initialPrice;
    protected int shipPrice;
    @XmlElement(required = true)
    protected String product;

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

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduct(String value) {
        this.product = value;
    }

}
