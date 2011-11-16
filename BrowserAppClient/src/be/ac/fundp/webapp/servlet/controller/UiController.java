package be.ac.fundp.webapp.servlet.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.webapp.resources.ResourceManager;

/**
 * Servlet implementation class UiController
 */
public class UiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected static final String DEFAULT_PAGE = "/beaty2/index.jsp";
	protected static final String WELCOME_PAGE = "/beaty2/welcome.jsp";
	
	protected static Map<String, String> cui2page = new HashMap<String, String>();
	protected ResourceManager resourceManager = ResourceManager.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UiController() {
        super();
        //FIXME put it in a file
        cui2page.put("input", "/beaty2/input.jsp");
        cui2page.put("output", "/beaty2/output.jsp");
        cui2page.put("select", "/beaty2/selection.jsp");
        cui2page.put("0", "/beaty2/input.jsp");
        cui2page.put("1", "/beaty2/output.jsp");
        cui2page.put("2", "/beaty2/selection.jsp");
        cui2page.put("4", "/beaty2/input.jsp");
        cui2page.put("5", "/beaty2/selection.jsp");
        cui2page.put("7", "/beaty2/output.jsp");
        cui2page.put("6", "/beaty2/selection.jsp");
        cui2page.put("8", "/beaty2/output.jsp");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = DEFAULT_PAGE;
		String role = (String) request.getSession().getAttribute("role");
		if (role != null)
			forward = getPage(role);	
		
		String fullURL = request.getRequestURL().toString();
		String myURL = fullURL.substring(0,fullURL.lastIndexOf("/"))+forward; 
		System.out.println("UI Controller - request URL = "+request.getRequestURL());
		System.out.println("UI Controller - request URI = "+request.getRequestURI());
		System.out.println("UI Controller - I'm going to = "+myURL);
		response.sendRedirect(myURL);
		//RequestDispatcher view = request.getRequestDispatcher(forward);
		//view.forward(request, response);
	}

	protected String getPage(String role) {
		String currentId = resourceManager.getNextCui(role);
		if (currentId == null)
			return WELCOME_PAGE;
		return cui2page.get(currentId);
	}

}
