package be.ac.fundp.precise.uiwsc.webClient.model.processManagment.interactionListenner;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import be.ac.fundp.precise.uiwsc.webClient.model.ConnectionConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.Process;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.UserInteraction;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.events.CancelInteractionEvent;

/**
 * The Class CancelInteractionListenner is the default cancel interaction Listener.
 */
public class CancelInteractionListenner {

	/**
	 * Invoke the UsiManager method to fire a cancel event.
	 *
	 * @param event the cancel event
	 */
	public void cancelInteraction(CancelInteractionEvent event) {
		UserInteraction interaction = (UserInteraction)event.getSource();
		Process p = interaction.getParent();
		p.cancelInteractions();
		String processId = p.getId();
		String userId = interaction.getParent().getUserId();
		String cuiId = interaction.getId();
		//TODO create an Id for event
		String eventId = "event_id";
		ClientResource itemsResource = new ClientResource(ConnectionConstants.USI_WSC_MANAGER_HOST +
				"/process" +
				"/" + processId +
				"/" + userId +
				"/" + cuiId +
				"/event" +
				"/" + eventId );
		Representation r =  null;
		try {
			r = itemsResource.get();
		} finally {
			if (r != null)
				r.release();
			if (itemsResource != null)
				itemsResource.release();
		}
	}

}
