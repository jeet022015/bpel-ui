package be.ac.fundp.precise.uiwsc.webClient.controller.userActions;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.precise.uiwsc.webClient.controller.entity.UserInteraction;
import be.ac.fundp.precise.uiwsc.webClient.model.ModelManager;
import be.ac.fundp.precise.uiwsc.webClient.model.interactionListenner.RestClientApplication;

@WebServlet("/interactionManager")
public class InteractionManager extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	protected ModelManager r = ModelManager.getInstance();

    public InteractionManager() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> para = request.getParameterMap();
		String role = (String) request.getSession().getAttribute("role");
		String processId = para.get("processId")[0];
		String cuiId = para.get("cuiId")[0];
		UserInteraction cui = r.getProcess(role, processId).getUserInteraction(cuiId);
		String forward = "/uiwsc/processAvailable.html";
		String cancelButton = "cancelbutton";
		if (para.keySet().contains(cancelButton)) {
			RestClientApplication.triggerEvent(role, processId, para.get(cancelButton)[0]);
			cui.wasDone();
			String fullURL = request.getRequestURL().toString();
			String myURL = fullURL.replaceAll("/interactionManager", forward);
			response.sendRedirect(myURL);
			return;
		}
		for (String key : para.keySet()) {
			if (!key.equals("processId") && !key.equals("cuiId") && !key.equals("sendbutton")){
				cui.addProvidedData(key, "String", para.get(key)[0]);
			}
		}
		cui.wasDone();
		String fullURL = request.getRequestURL().toString();
		String myURL = fullURL.replaceAll("/interactionManager", forward);
		response.sendRedirect(myURL);
	}

}
