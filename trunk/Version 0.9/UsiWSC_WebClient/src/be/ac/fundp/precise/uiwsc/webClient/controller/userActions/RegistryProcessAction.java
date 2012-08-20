package be.ac.fundp.precise.uiwsc.webClient.controller.userActions;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import be.ac.fundp.precise.uiwsc.webClient.controller.ControllerConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.codeManagment.CodeManager;
import be.ac.fundp.precise.uiwsc.webClient.model.exception.CodeRetreivingException;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.ProcessManager;
import be.ac.fundp.precise.uiwsc.webClient.model.userManagment.ProcessRegistationManager;

/**
 * The Class RegistryProcessAction.
 */
@WebServlet("/registryProcessAction")
public class RegistryProcessAction extends HttpServlet {
	

	/** The Constant SERVLET_ID. */
	private static final String SERVLET_ID = "/registryProcessAction";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The process manager. */
	protected ProcessManager processManager = ProcessManager.getInstance();
	
	/** The code manager. */
	protected CodeManager codeManager = CodeManager.getInstance();

    /**
     * Instantiates a new registry process action.
     */
    public RegistryProcessAction() {
        super();
    }

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> para = request.getParameterMap();
		String login = (String) request.getSession().getAttribute(ControllerConstants.CONTROLLER_LOGIN);
		String processId = para.get("process")[0];
		String role = para.get("role")[0];
		String webContentPath = getServletContext().getRealPath("/WebContent");
		String forward = ActionConstants.PAGE_PROCESS_AVAILABLE;
		
		ProcessRegistationManager.register(processId, role, login);
		try {
			codeManager.retrieveCode(processId, role, webContentPath);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (CodeRetreivingException e) {
			e.printStackTrace();
		}
		String fullURL = request.getRequestURL().toString();
		String myURL = fullURL.replaceAll(SERVLET_ID, forward);
		response.sendRedirect(myURL);
	}

}
