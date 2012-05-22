package be.ac.fundp.precise.userActionManagment.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.precise.userActionManagment.UserActionManager;
import be.ac.fundp.precise.userActionManagment.codeManagment.CodeManager;

/**
 * The Class LoginController.
 */
@WebServlet(value="/processAction", name="ProcessAction")
public class ProcessAction extends HttpServlet{

	protected UserActionManager userManager = UserActionManager.getInstance();
	
	protected CodeManager codeManager = CodeManager.getInstance();
	
	/** The Constant LOGIN_MANAGER_TAG. */
	private static final String LOGIN_MANAGER_TAG = "/processAction";

    /**
     * Instantiates a new login manager.
     *
     * @see HttpServlet#HttpServlet()
     */
    public ProcessAction() {
        super();
    }
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		String processId = request.getParameter("processId");
		String forward = "/uibpel/processDetails.jsp?processIf="+processId;
		String fullURL = request.getRequestURL().toString();
		String myURL = fullURL.substring(0, fullURL.indexOf(LOGIN_MANAGER_TAG))+ forward;
		response.sendRedirect(myURL);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request,response);
    }

}
