package be.ac.fundp.webapp.controllers;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.webapp.resources.ResourceManager;
import be.ac.fundp.webapp.resources.UIDataCapsule;

@WebServlet("/InputController")
public class InputController extends Controller {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResourceManager manager = ResourceManager.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UIDataCapsule d = new UIDataCapsule();
		Map<String, String[]> para = request.getParameterMap();
		for (String key : para.keySet()) {
			//FIXME get the elements of the button
			if (!key.equals("SendInput")){
				String[] input = para.get(key);
				d.addData(key, "String", input[0]);
			}
		}
		manager.putData(getCurrent(), d);
		super.doGet(request, response);
	}

}