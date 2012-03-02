package be.ac.fundp.webapp.service.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class LoginManager.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
@WebServlet("/LoginManager")
public class LoginManager extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The users. */
	protected Map<String, String> users= new HashMap<String, String>();
       
    /**
     * Instantiates a new login manager.
     *
     * @see HttpServlet#HttpServlet()
     */
    public LoginManager() {
        super();
        users.put("neto", "employee");
        users.put("philippe", "manager");
        users.put("mohamed", "administrator");
    }

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String forward = "/uibpel/index.html";
		if(login != null && users.keySet().contains(login)){
			session.setAttribute("role", users.get(login));
			forward = "/uibpel/welcome.jsp";
		}
		String fullURL = request.getRequestURL().toString();
		System.out.println("fullURL = "+fullURL);
		String myURL = fullURL.replaceAll("/LoginManager", forward);
		System.out.println("request URI = "+request.getRequestURI());
		System.out.println("I'm going to = "+myURL);
		response.sendRedirect(myURL);
	}

}
