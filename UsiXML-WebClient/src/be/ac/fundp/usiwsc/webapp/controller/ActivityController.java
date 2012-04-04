package be.ac.fundp.usiwsc.webapp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/activityManager", name="ActivityServlet")
public class ActivityController  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The cui2page. */
	protected static Map<String, String> cui2page = new HashMap<String, String>();

	/**
	 * Instantiates a new ui controler.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public ActivityController() {
		super();
		cui2page.put("27", "/uibpel/travel/employee_info.jsp");
		cui2page.put("28", "/uibpel/travel/manager_veredict.jsp");
		cui2page.put("30", "/uibpel/travel/client_info.jsp");
		cui2page.put("31", "/uibpel/travel/payment_info.jsp");
	}
	
	/**
	 * Do get.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String processId = (String) request.getParameter("processId");
		String cuiId = (String) request.getParameter("cuiId");

		String page = cui2page.get(cuiId);

		String forward = page + "?processId=" + processId + "&cuiId=" + cuiId;
		// String forward = page;
		String fullURL = request.getRequestURL().toString();
		String myURL = fullURL.replaceAll("/activityManager", forward);
		System.out.println("myURL="+myURL);
		response.sendRedirect(myURL);
	}

}
