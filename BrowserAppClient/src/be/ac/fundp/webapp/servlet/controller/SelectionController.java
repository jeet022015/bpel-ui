package be.ac.fundp.webapp.servlet.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ac.fundp.webapp.DataItemType;

/**
 * Servlet implementation class SelectionController
 */
public class SelectionController extends UiController {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DataItemType> dataProvided =  new LinkedList<DataItemType>();
		//FIXME remove this hack, can I generate an id for an selection?
		String select[] = request.getParameterValues("id");
		if (select != null && select.length != 0) {
			for (int i = 0; i < select.length; i++) {
				DataItemType aDataItem = new DataItemType();
				//FIXME remove this hack, can I pass more that one parameter in a input interaction?
				aDataItem.setData(select[i]);
				aDataItem.setDataItemId("id");
				aDataItem.setTypeName("String");
				dataProvided.add(aDataItem);
			}
		}
		String role = (String) request.getSession().getAttribute("role");
		resourceManager.putData(resourceManager.getCurrentCuiId(role),
								dataProvided.toArray(new DataItemType[0]));
		
		if (resourceManager.getCurrentOrder() != null)
			resourceManager.getCurrentOrder().setPerformed();
		
		super.doGet(request, response);
	}
}
