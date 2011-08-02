package org.example.www.ui_bpel_mediator.logic.model.elements;

import java.util.HashMap;
import java.util.Map;

import org.example.www.ui_bpel_mediator.logic.mediator.UIComponent;

public class UI_Representation {
	
	protected Map<Integer, UI_Component> myComps = new HashMap<Integer, UI_Component>();

	public UI_Component getComponent(int compID) {
		UI_Component newComp;
		if(!myComps.containsKey(compID)){
			newComp = new UI_Component();
			myComps.put(compID, newComp);
		} else {
			newComp = myComps.get(compID);
		}
		return newComp;
	}

	public UI_Component getMyComponent(String id) {
		for (UI_Component component : myComps.values()) {
			if (component.isInnerElement(id)){
				return component;
			}
		}
		return null;
	}

}
