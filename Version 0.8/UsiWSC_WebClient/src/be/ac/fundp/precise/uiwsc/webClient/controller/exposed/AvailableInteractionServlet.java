package be.ac.fundp.precise.uiwsc.webClient.controller.exposed;

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

import be.ac.fundp.precise.uiwsc.webClient.controller.entity.UserInteraction;
import be.ac.fundp.precise.uiwsc.webClient.model.ModelManager;

@WebServlet(value = "/availableInteractions", name = "AvailableInteractions")
public class AvailableInteractionServlet extends HttpServlet {
	
	ModelManager mm = ModelManager.getInstance();

	public AvailableInteractionServlet() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String role = (String) request.getSession().getAttribute("role");
		String processId = request.getParameter("processId");
		JSONArray userIntearctions = new JSONArray();
		List<UserInteraction> products = mm.getProcess(role, processId).getPendingInteractions();
		for (UserInteraction userInteraction : products) {
			JSONObject interaction = new JSONObject();
			try {
				interaction.put("id", userInteraction.getId());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			userIntearctions.put(interaction);
		}
		String json = userIntearctions.toString();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
