/**
 * UIClientSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package be.ac.fundp.webapp.provider;

import be.ac.fundp.webapp.DataItemType;
import be.ac.fundp.webapp.RequireAssyncInteraction;
import be.ac.fundp.webapp.RequireSyncInteraction;
import be.ac.fundp.webapp.RequireSyncInteractionResponse;
import be.ac.fundp.webapp.resources.ResourceManager;

/**
 * UIClientSkeleton java skeleton for the axisService
 */
public class UIClientSkeleton {

	protected ResourceManager resourceManager = ResourceManager.getInstance();
	/**
	 * Auto generated method signature
	 * 
	 * @param requireAssyncInteraction
	 * @return
	 */

	public void requireAssyncInteraction(
			RequireAssyncInteraction requireAssyncInteraction) {
		String cuiId = requireAssyncInteraction.getCuiId();		
		resourceManager.configureDataRequiredByUi(cuiId, requireAssyncInteraction.getInputData());
		resourceManager.addCuiId(cuiId, requireAssyncInteraction.getRole());
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param requireSyncInteraction
	 * @return requireSyncInteractionResponse
	 */

	public RequireSyncInteractionResponse requireSyncInteraction(
			RequireSyncInteraction requireSyncInteraction) {
		RequireSyncInteractionResponse response = new RequireSyncInteractionResponse();
		
		String cuiId = requireSyncInteraction.getCuiId();
		
		resourceManager.configureDataRequiredByUi(cuiId, requireSyncInteraction.getInputData());
		resourceManager.addCuiId(cuiId, requireSyncInteraction.getRole());
		
		DataItemType[] uiItems;
		try {
			uiItems = resourceManager.waitDataUI(cuiId);
		} catch (InterruptedException e) {
			uiItems = new DataItemType[0];
		}
		response.setOutData(uiItems);
		return response;
	}

}
    