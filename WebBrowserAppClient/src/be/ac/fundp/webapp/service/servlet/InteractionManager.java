package be.ac.fundp.webapp.service.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.webapp.service.manager.UiManager;
import be.ac.fundp.webapp.service.representation.UserInteraction;

/**
 * Servlet implementation class UiManager.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
@WebServlet("/InteractionManager")
public class InteractionManager extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The ui manager. */
	UiManager uiManager = UiManager.getInstance();
       
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
		String process = para.get("processId")[0];
		String cuiId = para.get("cuiId")[0];
		UserInteraction cui = uiManager.retrieveProcess(role, process).getUserInteracion(cuiId);
		for (String key : para.keySet()) {
			if (!key.equals("processId") && !key.equals("cuiId") && !key.equals("sendbutton")){
				System.out.println("the key = "+key);
				cui.addProvidedDataItem(key, "String", para.get(key)[0]);
			}
		}
		cui.setPerformed();
		
		//uiManager.userInteracionPerformed(cuiId, role, process);
		String forward = "/uibpel/welcome.jsp";
		String fullURL = request.getRequestURL().toString();
		String myURL = fullURL.replaceAll("/InteractionManager", forward);
		System.out.println("request URI = "+request.getRequestURI());
		System.out.println("I'm going to = "+myURL);
		response.sendRedirect(myURL);
	}

}
