package be.ac.fundp.precise.userActionManagment.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.precise.userActionManagment.codeManagment.CodeManager;

// TODO: Auto-generated Javadoc
/**
 * The Class ActivityController.
 */
@WebServlet(value="/activityManager", name="ActivityServlet")
public class ActivityController  extends HttpServlet{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	protected CodeManager codeManager = CodeManager.getInstance();

	/**
	 * Instantiates a new ui controler.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public ActivityController() {
		super();
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
		String process = (String) request.getSession().getAttribute("process");
		String role = (String) request.getSession().getAttribute("role");
		String processInstanceId = (String) request.getParameter("processId");
		String cuiId = (String) request.getParameter("cuiId");

		String page = codeManager.getCodeAddress(process, role, cuiId);

		String forward = page + "?processId=" + processInstanceId + "&cuiId=" + cuiId + "&process=" + process;
		String fullURL = request.getRequestURL().toString();
		String myURL = fullURL.replaceAll("/activityManager", forward);
		System.out.println("myURL="+myURL);
		response.sendRedirect(myURL);
	}

}
