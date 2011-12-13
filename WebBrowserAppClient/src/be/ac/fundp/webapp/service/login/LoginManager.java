package be.ac.fundp.webapp.service.login;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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
	protected List<String> users= new LinkedList<String>();
       
    /**
     * Instantiates a new login manager.
     *
     * @see HttpServlet#HttpServlet()
     */
    public LoginManager() {
        super();
        users.add("neto");
        users.add("philippe");
        users.add("manager1");
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
		if(login != null && users.contains(login)){
			session.setAttribute("role", login);
			forward = "/uibpel/welcome.jsp";
		}
		String fullURL = request.getRequestURL().toString();
		String myURL = fullURL.replaceAll("/LoginManager", forward); 
		System.out.println("request URL = "+request.getRequestURL());
		System.out.println("request URI = "+request.getRequestURI());
		System.out.println("I'm going to = "+myURL);
		response.sendRedirect(myURL);
	}

}
