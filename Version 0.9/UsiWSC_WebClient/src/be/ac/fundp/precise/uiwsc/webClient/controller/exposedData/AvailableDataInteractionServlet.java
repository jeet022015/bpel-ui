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
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.UserInteraction;

/**
 * The Class AvailableDataInteractionServlet exposes the available interactions
 * for a specific process.
 */
@WebServlet(value = "/availableInteractions", name = "AvailableInteractions")
public class AvailableDataInteractionServlet extends HttpServlet {
	
	/** The process manager. */
	ProcessManager processManager = ProcessManager.getInstance();

	/**
	 * Instantiates a new available data interaction servlet.
	 */
	public AvailableDataInteractionServlet() {
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

		String login = (String) request.getSession().getAttribute(ControllerConstants.CONTROLLER_LOGIN);
		String processId = request.getParameter(ControllerConstants.CONTROLLER_PROCESS_ID);
		JSONArray userIntearctions = new JSONArray();
		List<UserInteraction> products = processManager.getPendingInteractions(login, processId);
		for (UserInteraction userInteraction : products) {
			JSONObject interaction = new JSONObject();
			try {
				interaction.put("id", userInteraction.getId());
				interaction.put("process", userInteraction.getParent().getType());
				interaction.put("role", userInteraction.getParent().getRole());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			userIntearctions.put(interaction);
		}
		String json = userIntearctions.toString();
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
