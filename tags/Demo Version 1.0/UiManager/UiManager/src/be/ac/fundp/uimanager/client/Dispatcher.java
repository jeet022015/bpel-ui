package be.ac.fundp.uimanager.client;

import be.ac.fundp.uimanager.InputOperationResponse;
import be.ac.fundp.uimanager.SelectionOperationResponse;
import be.ac.fundp.uimanager.UiDataType;

public interface Dispatcher {

	InputOperationResponse requireInputInteracion(String processId,
			String userInteracId, String role);

	void requireOutputInteracion(String processid,
			String userInteracId, UiDataType[] data, String role);

	SelectionOperationResponse requireSelectionInteracion(String processId,
			String userInteracId, UiDataType[] data, String role);

}
