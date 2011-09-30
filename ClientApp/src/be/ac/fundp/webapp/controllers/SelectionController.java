package be.ac.fundp.webapp.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.webapp.resources.ResourceManager;
import be.ac.fundp.webapp.resources.UIDataCapsule;

/**
 * Servlet implementation class SelectionController
 */
@WebServlet("/SelectionController")
public class SelectionController extends Controller {
	private static final long serialVersionUID = 1L;
    
	private ResourceManager manager = ResourceManager.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UIDataCapsule d = new UIDataCapsule();
		String select[] = request.getParameterValues("id");
		System.out.println("here......2");
		if (select != null && select.length != 0) {
			for (int i = 0; i < select.length; i++) {
				d.addData("id", "String", select[i]);
				System.out.println("here......");
			}
		}
		manager.putData(getCurrent(), d);
		super.doGet(request, response);
	}
}
