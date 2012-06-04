package be.ac.fundp.precise.uiwsc.webClient.model.processManagment.events;

import java.util.EventObject;

/**
 * The Class DataInteractionEvent.
 */
public class DataInteractionEvent extends EventObject{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new data interaction event.
	 *
	 * @param anInteraction the data interaction provided
	 */
	public DataInteractionEvent(Object anInteraction) {
		super(anInteraction);
	}

}
