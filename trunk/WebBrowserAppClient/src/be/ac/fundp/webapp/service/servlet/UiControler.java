package be.ac.fundp.webapp.service.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class UiControler.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
@WebServlet("/UiControler")
public class UiControler extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cui2page. */
	protected static Map<String, String> cui2page = new HashMap<String, String>();
       
    /**
     * Instantiates a new ui controler.
     *
     * @see HttpServlet#HttpServlet()
     */
    public UiControler() {
        super();
        cui2page.put("input", "/beaty2/input.jsp");
        cui2page.put("output", "/beaty2/output.jsp");
        cui2page.put("select", "/beaty2/selection.jsp");
        cui2page.put("0", "/uibpel/input_initial_info.jsp");
        cui2page.put("1", "/uibpel/customer_information.jsp");
        cui2page.put("2", "/uibpel/select_shipper.jsp");
        cui2page.put("5", "/uibpel/bill_information.jsp");
        cui2page.put("3", "/uibpel/select_payment_method.jsp");
        cui2page.put("4", "/uibpel/receipt.jsp");
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Am I here?");
		String processId = (String) request.getParameter("processId");
		System.out.println("the process Id is "+processId);
		String cuiId = (String) request.getParameter("cuiId");
		System.out.println("the cui Id is "+cuiId);
		
		String page = cui2page.get(cuiId);
		
		String forward = page+"?processId="+processId+"&cuiId="+cuiId;
		//String forward = page;
		String fullURL = request.getRequestURL().toString();
		System.out.println("fullURL URL = "+fullURL);
		String myURL = fullURL.replaceAll("/UiControler", forward); 
		System.out.println("request URL = "+request.getRequestURL());
		System.out.println("request URI = "+request.getRequestURI());
		System.out.println("I'm going to = "+myURL);
		response.sendRedirect(myURL);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Or here?");
	}

}
