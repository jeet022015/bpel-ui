package be.ac.fundp.precise.userActionManagment.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.ac.fundp.precise.userActionManagment.UserActionManager;
import be.ac.fundp.precise.userActionManagment.codeManagment.CodeManager;

/**
 * The Class LoginController.
 */
@WebServlet(value = "/loginAction", name = "LoginServlet")
public class LoginAction extends HttpServlet {

	protected UserActionManager userManager = UserActionManager.getInstance();

	protected CodeManager codeManager = CodeManager.getInstance();

	/** The Constant LOGIN_MANAGER_TAG. */
	private static final String LOGIN_MANAGER_TAG = "/loginAction";

	/**
	 * Instantiates a new login manager.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAction() {
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
		HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String process = request.getParameter("process");
		String action = request.getParameter("action");
		String role = request.getParameter("role");
		String forward = "/uiwsc";
		//String forward = "/uibpel/index.jsp";
		String webContentPath = getServletContext().getRealPath("/WebContent");
		
		
		String fullURL = request.getRequestURL().toString();
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int portNumber = request.getServerPort();
		//String servletPath = request.getServletPath();
		//System.out.println("servletPath="+servletPath);
		//servletPath = servletPath.substring(0, servletPath.indexOf(LOGIN_MANAGER_TAG));
		String servletPath = fullURL.substring(0, fullURL.indexOf(LOGIN_MANAGER_TAG));
		
		
		boolean processOk = false;
		if (action.equalsIgnoreCase("subscribe")) {
			processOk = userManager.subscribe(login, password, process, role, scheme, serverName, portNumber, servletPath);
		} else {
			processOk = userManager.login(login, password, process, role);
		}
		if (processOk) {
			session.setAttribute("role", role);
			session.setAttribute("process", process);
			codeManager.getCode(process, role, webContentPath);
			//forward = "/uibpel/processes.jsp";
			forward = "/uiwsc/processAvailable.html";
		}
		System.out.println("fullURL="+fullURL);
		String myURL = fullURL.substring(0, fullURL.indexOf(LOGIN_MANAGER_TAG))
				+ forward;
		response.sendRedirect(myURL);
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
