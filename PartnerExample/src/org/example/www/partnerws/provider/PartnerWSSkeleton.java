/**
 * PartnerWSSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package org.example.www.partnerws.provider;

import org.example.www.partnerws.CalculateDiscount;
import org.example.www.partnerws.CalculateDiscountResponse;
import org.example.www.partnerws.CalculateInitialPrice;
import org.example.www.partnerws.CalculateInitialPriceResponse;
import org.example.www.partnerws.CalculatePriceE;
import org.example.www.partnerws.CalculatePriceResponse;
import org.example.www.partnerws.ShipmentPrice;
import org.example.www.partnerws.ShipmentPriceResponse;

/**
 * PartnerWSSkeleton java skeleton for the axisService
 */
public class PartnerWSSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @param calculateDiscount
	 * @return calculateDiscountResponse
	 */

	public CalculateDiscountResponse calculateDiscount(
			CalculateDiscount calculateDiscount) {
		CalculateDiscountResponse r = new CalculateDiscountResponse();
		r.setDiscount(10);
		return r;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param shipmentPrice
	 * @return shipmentPriceResponse
	 */

	public ShipmentPriceResponse shipmentPrice(
			ShipmentPrice shipmentPrice) {
		ShipmentPriceResponse r = new ShipmentPriceResponse();
		r.setShipPrice(100);
		return r;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param calculateInitialPrice
	 * @return calculateInitialPriceResponse
	 */

	public CalculateInitialPriceResponse calculateInitialPrice(
			CalculateInitialPrice calculateInitialPrice) {
		System.out.println("here////");
		CalculateInitialPriceResponse u = new CalculateInitialPriceResponse();
		u.setInitialPrice(110);
		return u;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param calculatePrice
	 * @return calculatePriceResponse
	 */

	public CalculatePriceResponse calculatePrice(
			CalculatePriceE calculatePrice) {
		CalculatePriceResponse u = new CalculatePriceResponse();
		u.setPrice(210);
		return u;
	}

}
    