package org.example.partnerws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.5.0
 * 2011-11-20T18:22:36.017+01:00
 * Generated source version: 2.5.0
 * 
 */
@WebService(targetNamespace = "http://www.example.org/partnerWS/", name = "partnerWS")
@XmlSeeAlso({ObjectFactory.class})
public interface PartnerWS {

    @WebResult(name = "discount", targetNamespace = "")
    @RequestWrapper(localName = "calculateDiscount", targetNamespace = "http://www.example.org/partnerWS/", className = "org.example.partnerws.CalculateDiscount")
    @WebMethod(action = "http://www.example.org/partnerWS/calculateDiscount")
    @ResponseWrapper(localName = "calculateDiscountResponse", targetNamespace = "http://www.example.org/partnerWS/", className = "org.example.partnerws.CalculateDiscountResponse")
    public int calculateDiscount(
        @WebParam(name = "price", targetNamespace = "")
        int price,
        @WebParam(name = "product", targetNamespace = "")
        java.lang.String product
    );

    @WebResult(name = "shipPrice", targetNamespace = "")
    @RequestWrapper(localName = "shipmentPrice", targetNamespace = "http://www.example.org/partnerWS/", className = "org.example.partnerws.ShipmentPrice")
    @WebMethod(action = "http://www.example.org/partnerWS/shipmentPrice")
    @ResponseWrapper(localName = "shipmentPriceResponse", targetNamespace = "http://www.example.org/partnerWS/", className = "org.example.partnerws.ShipmentPriceResponse")
    public int shipmentPrice(
        @WebParam(name = "shipper", targetNamespace = "")
        java.lang.String shipper,
        @WebParam(name = "product", targetNamespace = "")
        java.lang.String product
    );

    @WebResult(name = "initialPrice", targetNamespace = "")
    @RequestWrapper(localName = "calculateInitialPrice", targetNamespace = "http://www.example.org/partnerWS/", className = "org.example.partnerws.CalculateInitialPrice")
    @WebMethod(action = "http://www.example.org/partnerWS/calculateInitialPrice")
    @ResponseWrapper(localName = "calculateInitialPriceResponse", targetNamespace = "http://www.example.org/partnerWS/", className = "org.example.partnerws.CalculateInitialPriceResponse")
    public int calculateInitialPrice(
        @WebParam(name = "product", targetNamespace = "")
        java.lang.String product
    );

    @WebResult(name = "price", targetNamespace = "")
    @RequestWrapper(localName = "calculatePrice", targetNamespace = "http://www.example.org/partnerWS/", className = "org.example.partnerws.CalculatePrice")
    @WebMethod(action = "http://www.example.org/partnerWS/calculatePrice")
    @ResponseWrapper(localName = "calculatePriceResponse", targetNamespace = "http://www.example.org/partnerWS/", className = "org.example.partnerws.CalculatePriceResponse")
    public int calculatePrice(
        @WebParam(name = "initialPrice", targetNamespace = "")
        int initialPrice,
        @WebParam(name = "shipPrice", targetNamespace = "")
        int shipPrice,
        @WebParam(name = "product", targetNamespace = "")
        java.lang.String product
    );
}
