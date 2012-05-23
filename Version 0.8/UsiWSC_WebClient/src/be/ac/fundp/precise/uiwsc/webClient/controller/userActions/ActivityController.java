package be.ac.fundp.precise.uiwsc.webClient.controller.userActions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.precise.uiwsc.webClient.model.codeManager.CodeManager;

@WebServlet(value="/activityManager", name="ActivityServlet")
public class ActivityController  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected CodeManager codeManager = CodeManager.getInstance();

	public ActivityController() {
		super();
	}

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
		response.sendRedirect(myURL);
	}

}
