package be.ac.fundp.precise.uiwsc.webClient.controller.exposedData;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import be.ac.fundp.precise.uiwsc.webClient.controller.ControllerConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.ProcessManager;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.Process;

/**
 * The Class AvailableProcessServlet exposes the available processes
 * for a specific user.
 */
@WebServlet(value = "/availableProcesses", name = "AvailableProcesses")
public class AvailableProcessServlet extends HttpServlet {

	/** The cont. */
	static int cont = 0;
	
	/** The process manager. */
	ProcessManager processManager = ProcessManager.getInstance();

	/**
	 * Instantiates a new available process servlet.
	 */
	public AvailableProcessServlet() {
		super();
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//String role = (String) request.getSession().getAttribute("role");
		String login = (String) request.getSession().getAttribute(ControllerConstants.CONTROLLER_LOGIN);
		List<Process> products = processManager.getPendingProcesses(login);
		JSONArray processes = new JSONArray();
		for (Process aProcess : products) {
			JSONObject interaction = new JSONObject();
			try {
				interaction.put(ExposedDataConstants.ID, aProcess.getId());
				interaction.put(ExposedDataConstants.NAME, aProcess.getDisplayableName());
				interaction.put(ExposedDataConstants.INTERACTIONS, aProcess.countPendingInteractions());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			processes.put(interaction);
		}
		String json = processes.toString();
		response.setContentType(ExposedDataConstants.APPLICATION_JSON);
		response.setCharacterEncoding(ExposedDataConstants.UTF_8);
		response.getWriter().write(json);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
