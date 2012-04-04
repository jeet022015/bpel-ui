package be.ac.fundp.usiwsc.webapp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@WebServlet(value="/loginManager", name="LoginServlet")
public class LoginController extends HttpServlet{

	/** The Constant LOGIN_MANAGER_TAG. */
	private static final String LOGIN_MANAGER_TAG = "/loginManager";

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger("be.ac.fundp");
	
	/** The users. */
	protected Map<String, String> allowedUsers = new HashMap<String, String>();
       
    /**
     * Instantiates a new login manager.
     *
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        allowedUsers.put("neto", "employee");
        allowedUsers.put("philippe", "manager");
        allowedUsers.put("mohamed", "administrator");
    }
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	logger.info("Initing LoginController");
    	HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String forward = "/uibpel/index.html";
		if(login != null && allowedUsers.keySet().contains(login)){
			session.setAttribute("role", allowedUsers.get(login));
			forward = "/uibpel/welcome.jsp";
		}
		String fullURL = request.getRequestURL().toString();
		logger.info("previous URL: "+fullURL);
		String myURL = fullURL.substring(0, fullURL.indexOf(LOGIN_MANAGER_TAG))+ forward;
		logger.info("redirecting URLL: "+myURL);
		response.sendRedirect(myURL);
		logger.info("Finalizing LoginController");
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request,response);
    }

}
