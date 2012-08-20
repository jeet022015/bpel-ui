package be.ac.fundp.precise.uiwsc.webClient.controller.userActions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.ac.fundp.precise.uiwsc.webClient.controller.ControllerConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.userManagment.UserActionManager;


/**
 * The Class LoginAction.
 */
@WebServlet(value = "/loginAction", name = "LoginServlet")
public class LoginAction extends HttpServlet {

	/** The Constant LOGIN_MANAGER_TAG. */
	private static final String LOGIN_MANAGER_TAG = "/loginAction";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login = request
				.getParameter(ControllerConstants.CONTROLLER_LOGIN);
		String password = request
				.getParameter(ControllerConstants.CONTROLLER_PASSWORD);
		//String process = request
		//		.getParameter(ControllerConstants.CONTROLLER_PROCESS);
		String action = request.getParameter("action");
		//String role = request.getParameter(ControllerConstants.CONTROLLER_ROLE);

		String forward = ActionConstants.PAGE_DEFAULT;

		String webContentPath = getServletContext().getRealPath("/WebContent");
		String requestURL = request.getRequestURL().toString();
		String servletHost = requestURL.substring(0,
				requestURL.indexOf(LOGIN_MANAGER_TAG));

		UserActionManager userManager = new UserActionManager(login, password,
				servletHost, webContentPath);
		boolean processOk = false;

		if (action.equalsIgnoreCase(ActionConstants.ACTION_SUBSCRIBE))
			processOk = userManager.subscribe();
		else if (action.equalsIgnoreCase(ActionConstants.ACTION_LOGIN))
			processOk = userManager.login();
		if (processOk) {
			session.setAttribute(ControllerConstants.CONTROLLER_LOGIN, login);
			forward = ActionConstants.PAGE_PROCESS_AVAILABLE;
		} else {
			forward = ActionConstants.PAGE_ERROR;
		}
		String forwardURL = servletHost + forward;
		response.sendRedirect(forwardURL);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
