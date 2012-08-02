package be.ac.fundp.precise.uiwsc.webClient.controller.userActions;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.precise.uiwsc.webClient.controller.ControllerConstants;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.ProcessManager;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.DataItem;
import be.ac.fundp.precise.uiwsc.webClient.model.processManagment.entities.UserInteraction;

// TODO: Auto-generated Javadoc
/**
 * The Class InteractionManager.
 */
@WebServlet("/interactionManager")
public class InteractionManager extends HttpServlet {
	

	/** The Constant SERVLET_ID. */
	private static final String SERVLET_ID = "/interactionManager";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	private final static String CANCEL_BUTTON_ID = "Cancel";
	private final static String OK_BUTTON_ID = "Ok";
	
	/** The process manager. */
	protected ProcessManager processManager = ProcessManager.getInstance();

    /**
     * Instantiates a new interaction manager.
     */
    public InteractionManager() {
        super();
    }

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> para = request.getParameterMap();
		String login = (String) request.getSession().getAttribute(ControllerConstants.CONTROLLER_LOGIN);
		String processId = para.get(ControllerConstants.CONTROLLER_PROCESS_ID)[0];
		String cuiId = para.get(ControllerConstants.CONTROLLER_CUI_ID)[0];
		System.out.println("processId:"+processId);
		System.out.println("login:"+login);
		System.out.println("cuiId:"+cuiId);
		UserInteraction cui = processManager.getUserInteraction(processId, login, cuiId);
		String forward = ActionConstants.PAGE_PROCESS_AVAILABLE;
		if (para.keySet().contains(CANCEL_BUTTON_ID)) {
			cui.canceled();
			String fullURL = request.getRequestURL().toString();
			String myURL = fullURL.replaceAll(SERVLET_ID, forward);
			response.sendRedirect(myURL);
			return;
		}
		List<DataItem> providedData = new LinkedList<DataItem>();
		for (String key : para.keySet()) {
			if (!key.equals(ControllerConstants.CONTROLLER_PROCESS_ID) && !key.equals(ControllerConstants.CONTROLLER_CUI_ID) && !key.equals(OK_BUTTON_ID)){
				DataItem aDataItem = new DataItem();
				aDataItem.setId(key);
				aDataItem.setType("string");
				aDataItem.setContent(para.get(key)[0]);
				providedData.add(aDataItem);
			}
		}
		System.out.println("cui:"+cui);
		cui.setProvidedData(providedData);
		String fullURL = request.getRequestURL().toString();
		String myURL = fullURL.replaceAll(SERVLET_ID, forward);
		response.sendRedirect(myURL);
	}

}
