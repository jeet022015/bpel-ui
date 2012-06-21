package be.ac.fundp.precise.uiwsc.webClient.controller.userActions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.precise.uiwsc.webClient.controller.ControllerConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.ProcessManager;

/**
 * The Class AvailableDataInteractionServlet exposes the available interactions
 * for a specific process.
 */
@WebServlet(value = "/startingProcessActivity", name = "StartingProcessActivity")
public class StartingProcessServlet extends HttpServlet {
	
	/** The process manager. */
	ProcessManager processManager = ProcessManager.getInstance();

	/**
	 * Instantiates a new available data interaction servlet.
	 */
	public StartingProcessServlet() {
		super();
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String login = (String) request.getSession().getAttribute(ControllerConstants.CONTROLLER_LOGIN);
		String process = request.getParameter("process");
		processManager.startProcess(login, process);
		String requestURL = request.getRequestURL().toString();
		String servletHost = requestURL.substring(0,
				requestURL.indexOf("/startingProcessActivity"));
		String forwardURL = servletHost + ActionConstants.PAGE_PROCESS_AVAILABLE;
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
