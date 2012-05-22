package be.ac.fundp.precise.interactionManagment;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.precise.dataManagment.ModelManager;
import be.ac.fundp.precise.dataManagment.model.UserInteraction;
import be.ac.fundp.precise.restInteraction.restClient.RestClientApplication;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class UiManager.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
@WebServlet("/interactionManager")
public class InteractionManager extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	ModelManager r = ModelManager.getInstance();
	
    /**
     * Instantiates a new interaction manager.
     *
     * @see HttpServlet#HttpServlet()
     */
    public InteractionManager() {
        super();
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> para = request.getParameterMap();
		String role = (String) request.getSession().getAttribute("role");
		String processId = para.get("processId")[0];
		String cuiId = para.get("cuiId")[0];
		System.out.println("process:"+processId);
		System.out.println("para:"+cuiId);
		UserInteraction cui = r.getProcess(role, processId).getUserInteraction(cuiId);
		System.out.println("cui:"+cui);
		//TODO get it from desc file
		//String forward = "/uibpel/processes.jsp";
		String forward = "/uiwsc/processAvailable.html";
		String cancelButton = "cancelbutton";
		if (para.keySet().contains(cancelButton)) {
			RestClientApplication.triggerEvent(role, processId, para.get(cancelButton)[0]);
			cui.wasDone();
			String fullURL = request.getRequestURL().toString();
			String myURL = fullURL.replaceAll("/interactionManager", forward);
			response.sendRedirect(myURL);
			return;
		}
		for (String key : para.keySet()) {
			if (!key.equals("processId") && !key.equals("cuiId") && !key.equals("sendbutton")){
				System.out.println("key="+key);
				System.out.println("content="+para.get(key)[0]);
				cui.addProvidedData(key, "String", para.get(key)[0]);
			}
		}
		cui.wasDone();

		String fullURL = request.getRequestURL().toString();
		String myURL = fullURL.replaceAll("/interactionManager", forward);
		response.sendRedirect(myURL);
	}

}
