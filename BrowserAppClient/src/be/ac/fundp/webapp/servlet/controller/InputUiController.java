package be.ac.fundp.webapp.servlet.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.webapp.DataItemType;

/**
 * Servlet implementation class InputUiController
 */
public class InputUiController extends UiController {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> para = request.getParameterMap();
		List<DataItemType> dataProvided =  new LinkedList<DataItemType>();
		for (String key : para.keySet()) {
			DataItemType aDataItem = new DataItemType();
			//FIXME remove this hack, can I pass more that one parameter in a input interaction?
			aDataItem.setData(para.get(key)[0]);
			aDataItem.setDataItemId(key);
			aDataItem.setTypeName("String");
			dataProvided.add(aDataItem);
		}
		String role = (String) request.getSession().getAttribute("role");
		resourceManager.putData(resourceManager.getCurrentCuiId(role),
								dataProvided.toArray(new DataItemType[0]));
		
		if (resourceManager.getCurrentOrder() != null)
			resourceManager.getCurrentOrder().setPerformed();
		
		super.doGet(request, response);
	}

}
