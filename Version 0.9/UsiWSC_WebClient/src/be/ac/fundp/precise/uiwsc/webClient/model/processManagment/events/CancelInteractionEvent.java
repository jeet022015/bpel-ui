package be.ac.fundp.precise.uiwsc.webClient.model.processManagment.events;

import java.util.EventObject;

/**
 * The Class CancelInteractionEvent.
 */
public class CancelInteractionEvent extends EventObject{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new cancel interaction event.
	 *
	 * @param anInteraction the the cancelled interaction
	 */
	public CancelInteractionEvent(Object anInteraction) {
		super(anInteraction);
	}

}
