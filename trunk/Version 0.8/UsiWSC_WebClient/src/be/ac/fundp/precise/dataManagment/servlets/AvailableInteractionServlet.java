package be.ac.fundp.precise.dataManagment.servlets;

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

import be.ac.fundp.precise.dataManagment.ModelManager;
import be.ac.fundp.precise.dataManagment.model.UserInteraction;

/**
 * The Class LoginController.
 */
@WebServlet(value = "/availableInteractions", name = "AvailableInteractions")
public class AvailableInteractionServlet extends HttpServlet {

	static int cont = 0;
	
	ModelManager mm = ModelManager.getInstance();
	
	/**
	 * Instantiates a new login manager.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public AvailableInteractionServlet() {
		super();
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		List<UserInteraction> products = new LinkedList<UserInteraction>();
//		Process p1 = new Process("id1", "Role", "travel");
//		UserInteraction ui1 = new UserInteraction(p1, "Role", "test"+cont);
//		UserInteraction ui2 = new UserInteraction(p1, "Role", "test"+cont);
//		cont++;
//		products.add(ui1);
//		products.add(ui2);
		String role = (String) request.getSession().getAttribute("role");
		String processId = request.getParameter("processId");
		//System.out.println("role="+role);
		//System.out.println("processId="+processId);
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
//		JSONArray userIntearctions = new JSONArray();
//		JSONObject aProcess = new JSONObject();
//		JSONObject aProcess2 = new JSONObject();
//		try {
//			aProcess.put("id", "InteractionId1");
//			aProcess2.put("id", "InteractionId2");
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		userIntearctions.put(aProcess);
//		userIntearctions.put(aProcess2);
//		String json = userIntearctions.toString();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
