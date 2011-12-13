package be.ac.fundp.webapp.service.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.webapp.service.client.EventTrigger;
import be.ac.fundp.webapp.service.manager.UiManager;
import be.ac.fundp.webapp.service.representation.UserInteraction;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class EventManager.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
@WebServlet("/EventManager")
public class EventManager extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
	/** The ui manager. */
	UiManager uiManager = UiManager.getInstance();
	
    /**
     * Instantiates a new event manager.
     *
     * @see HttpServlet#HttpServlet()
     */
    public EventManager() {
        super();
        // TODO Auto-generated constructor stub
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
		System.out.println("para = "+para);
		System.out.println("para value = "+para.values());
		System.out.println("para keys = "+para.keySet());
		String process = para.get("processId")[0];
		String cuiId = para.get("cuiId")[0];
		UserInteraction cui = uiManager.retrieveProcess(role, process).getUserInteracion(cuiId);
		cui.setPerformed();
		
		EventTrigger.fireEvent(role, process, cuiId);
		
		String forward = "/uibpel/welcome.jsp";
		String fullURL = request.getRequestURL().toString();
		String myURL = fullURL.replaceAll("/EventManager", forward); 
		System.out.println("request URL = "+request.getRequestURL());
		System.out.println("request URI = "+request.getRequestURI());
		System.out.println("I'm going to = "+myURL);
		response.sendRedirect(myURL);
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
