package be.ac.fundp.webapp.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String DEFAULT_PAGE = "/index2.jsp";
	private static Map<String, String> pages = new HashMap<String, String>();
	private static List<String> userInteraction = new LinkedList<String>();
	private static String currentId;
	
	public static void addUserInteraction(String id){
		System.out.println("putting = "+id);
		userInteraction.add(id);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        pages.put("input", "/input.jsp");
        pages.put("output", "/output.jsp");
        pages.put("select", "/selection.jsp");
        pages.put("0", "/input.jsp");
        pages.put("1", "/output.jsp");
        pages.put("2", "/selection.jsp");
        pages.put(null, DEFAULT_PAGE);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = getPage();
		System.out.println("request = "+ request);
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		System.out.println("view = "+ view);
		System.out.println("forward = "+ forward);
		view.forward(request, response);
	}

	private String getPage() {
		if (userInteraction.isEmpty()){
			currentId = "";
			return DEFAULT_PAGE;
		}
		currentId = userInteraction.remove(0);
		System.out.println("currentId = "+ currentId);
		return pages.get(currentId);
	}
	
	public static String getCurrent(){
		System.out.println("currentIdRequired = "+ currentId);
		return currentId;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("here?");
	}

}
