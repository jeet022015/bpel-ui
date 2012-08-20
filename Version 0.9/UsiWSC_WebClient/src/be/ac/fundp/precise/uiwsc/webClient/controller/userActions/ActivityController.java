package be.ac.fundp.precise.uiwsc.webClient.controller.userActions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.precise.uiwsc.webClient.controller.ControllerConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.codeManagment.CodeManager;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.ProcessManager;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.DataItem;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.UserInteraction;

/**
 * The Class ActivityController.
 */
@WebServlet(value = "/activityManager", name = "ActivityServlet")
public class ActivityController extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The code manager. */
	protected CodeManager codeManager = CodeManager.getInstance();

	/** The process manager. */
	protected ProcessManager processManager = ProcessManager.getInstance();

	/**
	 * Instantiates a new activity controller.
	 */
	public ActivityController() {
		super();
	}

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
		String process = (String) request
				.getParameter(ControllerConstants.CONTROLLER_PROCESS);
		String role = (String) request
				.getParameter(ControllerConstants.CONTROLLER_ROLE);
		String user = (String) request.getSession().getAttribute(
				ControllerConstants.CONTROLLER_LOGIN);
		String processInstanceId = (String) request
				.getParameter(ControllerConstants.CONTROLLER_PROCESS_ID);
		String cuiId = (String) request
				.getParameter(ControllerConstants.CONTROLLER_CUI_ID);

		String page = codeManager.getCodeAddress(process, role, cuiId);

		String forward = page + "?" + ControllerConstants.CONTROLLER_PROCESS_ID
				+ "=" + processInstanceId + "&"
				+ ControllerConstants.CONTROLLER_CUI_ID + "=" + cuiId + "&"
				+ ControllerConstants.CONTROLLER_PROCESS + "=" + process;

		UserInteraction ui = processManager.getUserInteraction(
				processInstanceId, user, cuiId);

		System.out.println("ui=" + ui);
		for (DataItem anItem : ui.getAvailableData()) {
			forward += "&" + anItem.getId() + "=" + anItem.getContent();
		}

		String fullURL = request.getRequestURL().toString();
		String myURL = fullURL.replaceAll("/activityManager", forward);
		response.sendRedirect(myURL);
	}

}
