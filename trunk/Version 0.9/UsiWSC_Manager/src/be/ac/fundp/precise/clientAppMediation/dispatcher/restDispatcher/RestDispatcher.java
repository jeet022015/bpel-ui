package be.ac.fundp.precise.clientAppMediation.dispatcher.restDispatcher;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.ClientResource;

import be.ac.fundp.precise.clientAppMediation.dispatcher.Dispatcher;
import be.ac.fundp.precise.dataManagment.CoordinatedData;

/**
 * This class is responsible to require user interaction from devices which
 * allow communication via RestFull services.
 * 
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class RestDispatcher implements Dispatcher {

	/** The Constant which define the higher time that the dispatcher can wait. */
	public static final int MAX_WAITING_TIME = 86400 * 1000;// One day

	/** The address of the restFull service. */
	protected String hostAddress;

	/**
	 * The processes which are running. This Map is used to cancel the
	 * dispatcher to wait for interactions of a process which was canceled.
	 */
	static protected Map<String, Boolean> activeProcesses = new HashMap<String, Boolean>();

	RestDispatcherDataHolder dataholder = RestDispatcherDataHolder
			.getInstance();

	/** The generator of random number. */
	private Random generator;

	/**
	 * Instantiates a new RestDispatcher.
	 * 
	 * @param host
	 *            the host
	 */
	public RestDispatcher(String host) {
		this.hostAddress = host;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.ac.fundp.uimanager.client.Dispatcher#requireInputInteracion(java.lang
	 * .String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<CoordinatedData> requireInputInteraction(String process, String role,
			String processId, String userInteracId, String userLogin) {
		List<CoordinatedData> resp = null;
		ClientResource cr = null;
		try {
			cr = putInteraction(userLogin, process, role, processId, userInteracId,
					Collections.<CoordinatedData> emptyList());
			JSONObject crudeData = dataholder.getData(userLogin, processId,
					userInteracId);
			resp = RestDispatcherUtil.JSON2CoordinatedData(crudeData);
		} catch (Exception e) {
			// TODO deal with Exception
			resp = Collections.<CoordinatedData> emptyList();
			e.printStackTrace();
		} finally {
			if (cr != null)
				cr.release();
		}
		System.gc();
		return resp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.ac.fundp.uimanager.client.Dispatcher#requireSelectionInteracion(java
	 * .lang.String, java.lang.String, java.util.List, java.lang.String)
	 */
	@Override
	public List<CoordinatedData> requireSelectionInteraction(String process, String role,
			String processId, String userInteracId,
			List<CoordinatedData> selectableData, String userLogin) {
		List<CoordinatedData> resp = null;
		ClientResource cr = null;
		try {
			cr = putInteraction(userLogin, process, role, processId, userInteracId,
					selectableData);
			JSONObject crudeData = dataholder.getData(userLogin, processId,
					userInteracId);
			resp = RestDispatcherUtil.JSON2CoordinatedData(crudeData);
		} catch (Exception e) {
			// TODO deal with Exception
			resp = Collections.<CoordinatedData> emptyList();
			e.printStackTrace();
		} finally {
			if (cr != null)
				cr.release();
		}
		System.gc();
		return resp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.ac.fundp.uimanager.client.Dispatcher#requireOutputInteracion(java.
	 * lang.String, java.lang.String, java.util.List, java.lang.String)
	 */
	@Override
	public void requireOutputInteraction(String process, String role, String processId,
			String userInteracId, List<CoordinatedData> outputData,
			String userLogin) {
		ClientResource cr = null;
		try {
			cr = putInteraction(userLogin, process, role, processId, userInteracId,
					outputData);
			dataholder.getData(userLogin, processId, userInteracId);
		} catch (Exception e) {
			// TODO deal with Exception
			e.printStackTrace();
		} finally {
			if (cr != null)
				cr.release();
		}
		System.gc();
	}

	/**
	 * This method creates a Rest ClientResource corresponding the user and
	 * process.
	 * 
	 * @param process
	 *            the process type.
	 * @param processId
	 *            the process's id.
	 * @param userLogin
	 *            the user's login.
	 * @param userInteracId
	 *            the user interaction's id.
	 * @return the Rest ClientResource corresponding the user and process.
	 */
	private ClientResource createClientResource(String process, String role,
			String processId, String userLogin, String userInteracId) {
		String host = processHost(process, role, processId, userLogin, userInteracId);
		ClientResource cr = new ClientResource(host);
		cr.setRetryAttempts(288);

		generator = new Random(host.hashCode());
		try {
			int sleeptime = generator.nextInt(1000);
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (!activeProcesses.keySet().contains(processId))
			activeProcesses.put(processId, true);
		return cr;
	}

	/**
	 * This method creates the host to a user corresponding to a specific
	 * process.
	 * 
	 * @param process
	 *            the process type.
	 * @param processId
	 *            the process's id.
	 * @param userLogin
	 *            the user's login.
	 * @param userInteracId
	 *            the user interaction's id.
	 * @return the host to a specific process.
	 */
	private String processHost(String process, String role, String processId,
			String userLogin, String userInteracId) {
		return hostAddress + "/" + process + "/" + role + "/" + processId + "/" + userLogin
				+ "/" + userInteracId;
	}

	/**
	 * This method does the put in the Rest service to require a user
	 * interaction.
	 * 
	 * @param userLogin
	 *            the user's login.
	 * @param process
	 *            the process type.
	 * @param processId
	 *            the process's id.
	 * @param userInteracId
	 *            the user interaction's id.
	 * @param availableData
	 *            the data to be presented to the user.
	 * @return the Rest ClientResource corresponding the user and process.
	 * @throws JSONException
	 *             The JSONObject was malformed exception.
	 * @throws InterruptedException
	 *             The execution crashes when it tries to put the execution to
	 *             sleep.
	 */
	private ClientResource putInteraction(String userLogin, String process, String role,
			String processId, String userInteracId,
			List<CoordinatedData> availableData) throws JSONException,
			InterruptedException {
		JSONObject obj = new JSONObject();
		JSONArray data = RestDispatcherUtil.coordinatedData2JSON(availableData);
		obj.put(RestDispatcherUtil.DATA_TAG_JSON, data);
		ClientResource cr = createClientResource(process, role, processId, userLogin,
				userInteracId);
		JsonRepresentation jr = new JsonRepresentation(obj);
		try {
			if (!cr.getStatus().equals(Status.SUCCESS_OK)) {
				cr.release();
				putInteraction(userLogin, process, role, processId, userInteracId,
						availableData);
			}
			cr.put(jr);
		} catch (Exception e) {
			e.printStackTrace();
			cr.release();
			Thread.sleep(10000);
			putInteraction(userLogin, process, role, processId, userInteracId,
					availableData);
		} finally {
			jr.release();
		}
		return cr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.ac.fundp.uimanager.dispatcher.Dispatcher#releaseAll(java.lang.String)
	 */
	@Override
	public void releaseAll(String processId) {
		activeProcesses.put(processId, false);
	}

}