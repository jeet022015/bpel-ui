package be.ac.fundp.precise.uiwsc.webClient.controller.userActions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.ac.fundp.precise.uiwsc.webClient.model.codeManager.CodeManager;


@WebServlet(value = "/loginAction", name = "LoginServlet")
public class LoginAction extends HttpServlet {

	private static final String PAGE_PROCESS_AVAILABLE = "/uiwsc/processAvailable.html";

	private static final String PAGE_DEFAULT = "/uiwsc";

	protected UserActionManager userManager = UserActionManager.getInstance();

	protected CodeManager codeManager = CodeManager.getInstance();

	private static final String LOGIN_MANAGER_TAG = "/loginAction";

	public LoginAction() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String process = request.getParameter("process");
		String action = request.getParameter("action");
		String role = request.getParameter("role");
		
		String forward = PAGE_DEFAULT;
		
		String webContentPath = getServletContext().getRealPath("/WebContent");
		String fullURL = request.getRequestURL().toString();
		String servletPath = fullURL.substring(0, fullURL.indexOf(LOGIN_MANAGER_TAG));
		boolean processOk = false;
		
		if (action.equalsIgnoreCase("subscribe")) {
			processOk = userManager.subscribe(login, password, process, role, servletPath);
		} else {
			processOk = userManager.login(login, password, process, role, servletPath);
		}
		if (processOk) {
			session.setAttribute("role", role);
			session.setAttribute("process", process);
			codeManager.getCode(process, role, webContentPath);
			forward = PAGE_PROCESS_AVAILABLE;
		}
		String myURL = fullURL.substring(0, fullURL.indexOf(LOGIN_MANAGER_TAG))
				+ forward;
		response.sendRedirect(myURL);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
