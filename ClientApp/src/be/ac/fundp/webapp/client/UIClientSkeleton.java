/**
 * UIClientSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package be.ac.fundp.webapp.client;

import be.ac.fundp.webapp.RequireSyncInteractionResponse;
import be.ac.fundp.webapp.UIDataType;
import be.ac.fundp.webapp.controllers.Controller;
import be.ac.fundp.webapp.resources.DataItem;
import be.ac.fundp.webapp.resources.ResourceManager;
import be.ac.fundp.webapp.resources.UIDataCapsule;

/**
 * UIClientSkeleton java skeleton for the axisService
 */
public class UIClientSkeleton {

	public ResourceManager otherResource = ResourceManager.getInstance();
	/**
	 * Auto generated method signature
	 * 
	 * @param requireAssyncInteraction
	 * @return
	 */

	public void requireAssyncInteraction(
			be.ac.fundp.webapp.RequireAssyncInteraction requireAssyncInteraction) {
		String uiId = requireAssyncInteraction.getId();
		UIDataCapsule d = new UIDataCapsule();
		if (requireAssyncInteraction.getInputData() != null)
			for (UIDataType dc : requireAssyncInteraction.getInputData()) 
				d.addData(dc.getId(), dc.getType(), dc.getData());
		otherResource.putOutputData(uiId, d);
    	Controller.addUserInteraction(uiId);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param requireSyncInteraction
	 * @return requireSyncInteractionResponse
	 */

	public be.ac.fundp.webapp.RequireSyncInteractionResponse requireSyncInteraction(
			be.ac.fundp.webapp.RequireSyncInteraction requireSyncInteraction) {
		RequireSyncInteractionResponse response = new RequireSyncInteractionResponse();
		String uiId = requireSyncInteraction.getId();
		UIDataCapsule d = new UIDataCapsule();
		if (requireSyncInteraction.getInputData() != null)
			for (UIDataType dc : requireSyncInteraction.getInputData()) 
				d.addData(dc.getId(), dc.getType(), dc.getData());
		otherResource.putOutputData(uiId, d);
    	Controller.addUserInteraction(uiId);
    	System.out.println("the UIid = "+uiId);
    	
    	UIDataCapsule dresp = new UIDataCapsule();
		try {
			dresp = otherResource.getSynchronizedUIData(uiId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DataItem[] dcIn = dresp.getItens();
		if(dcIn != null){
			UIDataType[] dcOut = new UIDataType[dresp.getItens().length];
			for (int i = 0; i < dcIn.length; i++) {
				DataItem dataItem = dcIn[i];
				dcOut[i] = new UIDataType();
				dcOut[i].setId(dataItem.getKey());
				dcOut[i].setData(dataItem.getData());
				dcOut[i].setType(dataItem.getType());
			}
			response.setOutData(dcOut);
		}
		return response;
	}

}
