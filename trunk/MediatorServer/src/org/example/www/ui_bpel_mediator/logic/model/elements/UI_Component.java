package org.example.www.ui_bpel_mediator.logic.model.elements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.example.www.ui_bpel_mediator.DataUIType;
import org.example.www.ui_bpel_mediator.logic.mediator.DataFromCUI;
import org.example.www.ui_bpel_mediator.logic.mediator.Invoker;

public class UI_Component {
	
	protected Set<String> userRoles = new HashSet<String>();
	protected Map<String,Set<DataItem>> dataInputInterac = new HashMap<String,Set<DataItem>>(); 
	protected Set<String> activeItems = new HashSet<String>();
	protected Invoker inv = Invoker.getInstance();

	public void addRole(String newRole) {
		userRoles.add(newRole);
	}

	public void addDataInput(String uiID, Set<DataItem> inputData) {
		dataInputInterac.put(uiID, inputData);
	}

	public boolean isInnerElement(String id) {
		//TODO putOutput and Selection
		return dataInputInterac.containsKey(id);
	}

	public void active() {
		activeItems.addAll(dataInputInterac.keySet());
	}

	public DataFromCUI invokeInputData(String id) {
		DataFromCUI awnser = inv.invokeAction(id);
		activeItems.remove(id);
		return awnser;
	}

	public boolean hasInnerElements() {
		return activeItems.isEmpty();
	}

	public DataFromCUI invokeSelectAtc(String id, DataUIType selectable) {
		DataFromCUI awnser = inv.invokeSelectAtc(id, selectable);
		activeItems.remove(id);
		return awnser;
	}

	public DataFromCUI sendData(String id, DataUIType data) {
		DataFromCUI awnser = inv.invokeSelectAtc(id, data);
		activeItems.remove(id);
		return awnser;
	}

}
