package be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.events.CancelInteractionEvent;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.events.DataInteractionEvent;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.interactionListenner.CancelInteractionListenner;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.interactionListenner.DataInteracionListenner;

/**
 * The Class UserInteraction.
 */
public class UserInteraction {
	
	/** The parent process. */
	private Process parentProcess;
	
	/** The id. */
	private String id;
	
	/** The interaction done. */
	private boolean interactionDone;
	
	/** The interaction canceled. */
	private boolean interactionCanceled;

	/** The available data. */
	private List<DataItem> availableData = Collections.emptyList();
	
	/** The provided data. */
	private List<DataItem> providedData = Collections.emptyList();
	
	/** The interaction listeners. */
	private Collection <DataInteracionListenner> interactionListeners = new ArrayList<DataInteracionListenner>();
	
	/** The cancel listeners. */
	private Collection <CancelInteractionListenner> cancelListeners = new ArrayList<CancelInteractionListenner>();
	
	/** The parent. */
	protected Process parent;

	/**
	 * Instantiates a new user interaction.
	 *
	 * @param process the process
	 * @param cuiId the cui id
	 */
	public UserInteraction(Process process, String cuiId) {
		parentProcess = process;
		id = cuiId;
		interactionDone = false;
		interactionCanceled = false;
		//default listeners
		interactionListeners.add(new DataInteracionListenner());
		cancelListeners.add(new CancelInteractionListenner());
	}

	/**
	 * Sets the available data.
	 *
	 * @param availableData the new available data
	 */
	public void setAvailableData(List<DataItem> availableData) {
		this.availableData = availableData;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the provided data.
	 *
	 * @return the provided data
	 */
	public List<DataItem> getProvidedData() {
		return providedData;
	}

	/**
	 * Canceled.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void canceled() {
		interactionCanceled = true;
		Collection <CancelInteractionListenner> tl;
        synchronized (this) {
            tl = (Collection)(((ArrayList)cancelListeners).clone());
        }
        CancelInteractionEvent event = new CancelInteractionEvent(this);                
        for (CancelInteractionListenner t : tl) {
        	t.cancelInteraction(event);
        }
	}

	/**
	 * Done.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void done() {
		interactionDone = true;
		Collection <DataInteracionListenner> tl;
        synchronized (this) {
            tl = (Collection)(((ArrayList)interactionListeners).clone());
        }
        DataInteractionEvent event = new DataInteractionEvent(this);                
        for (DataInteracionListenner t : tl) {
        	t.interactionDone(event);
        }
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public Process getParent() {
		return parentProcess;
	}

	/**
	 * Sets the canceled.
	 *
	 * @param b the new canceled
	 */
	public void setCanceled(boolean b) {
		interactionCanceled = b;
	}

	/**
	 * Sets the provided data.
	 *
	 * @param providedData2 the new provided data
	 */
	public void setProvidedData(List<DataItem> providedData2) {
		providedData = providedData2;
		done();
	}

	/**
	 * Checks if is done.
	 *
	 * @return true, if is done
	 */
	public boolean isDone() {
		return interactionDone;
	}

	/**
	 * Checks if is canceled.
	 *
	 * @return true, if is canceled
	 */
	public boolean isCanceled() {
		return interactionCanceled;
	}

	/**
	 * Checks if is pending.
	 *
	 * @return true, if is pending
	 */
	public boolean isPending() {
		return !isDone() && !isCanceled();
	}

	/**
	 * Gets the available data.
	 *
	 * @return the available data
	 */
	public List<DataItem> getAvailableData() {
		return availableData;
	}

	/**
	 * Gets the displayable name.
	 *
	 * @return the displayable name
	 */
	public String getDisplayableName() {
		return null;
	}
}