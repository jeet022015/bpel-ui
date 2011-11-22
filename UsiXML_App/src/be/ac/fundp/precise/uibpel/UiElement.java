package be.ac.fundp.precise.uibpel;

import java.util.Date;

public class UiElement {

	protected static int currentId = 0;
	
	protected String cuiId;
	protected String internalId;
	protected String userInteractionType;
	protected String processId;
	protected boolean newUserInteraction;
	protected boolean performed;
	protected Date userInteractionStart;
	
	public UiElement(String cuiId, String userInteractionType, String processId,Date userInteractionStart) {
		this.cuiId = cuiId;
		this.userInteractionType = userInteractionType;
		this.processId = processId;
		this.userInteractionStart = userInteractionStart;
	}
}
