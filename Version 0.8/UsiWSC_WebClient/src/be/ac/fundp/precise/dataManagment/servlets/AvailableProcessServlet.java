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
import be.ac.fundp.precise.dataManagment.model.Process;

/**
 * The Class LoginController.
 */
@WebServlet(value = "/availableProcesses", name = "AvailableProcesses")
public class AvailableProcessServlet extends HttpServlet {

	static int cont = 0;
	ModelManager mm = ModelManager.getInstance();
	
	/**
	 * Instantiates a new login manager.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public AvailableProcessServlet() {
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
//		List<Process> products = new LinkedList<Process>();
//		Process p1 = new Process("id1", "Role", "travel"+cont);
//		Process p2 = new Process("id2", "Role2", "travel"+cont);
//		cont++;
//		products.add(p2);
//		products.add(p1);
		String role = (String) request.getSession().getAttribute("role");
		List<Process> products = mm.getPendingProcesses(role);
		JSONArray userIntearctions = new JSONArray();
		for (Process userInteraction : products) {
			JSONObject interaction = new JSONObject();
			try {
				interaction.put("id", userInteraction.getId());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			userIntearctions.put(interaction);
		}
		String json = userIntearctions.toString();
		//String json = new Gson().toJson(products);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		//System.out.println("here");
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
