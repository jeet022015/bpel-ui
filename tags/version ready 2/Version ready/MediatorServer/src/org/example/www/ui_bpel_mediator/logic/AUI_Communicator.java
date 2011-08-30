package org.example.www.ui_bpel_mediator.logic;

import java.util.HashSet;
import java.util.Set;

import org.example.www.ui_bpel_mediator.DataUIType;
import org.example.www.ui_bpel_mediator.logic.mediator.DataFromCUI;
import org.example.www.ui_bpel_mediator.logic.model.UI_Model;
import org.example.www.ui_bpel_mediator.logic.model.elements.UI_Component;

public class AUI_Communicator {
	
	protected static AUI_Communicator self;
	
	protected Set<UI_Component> activeComps = new HashSet<UI_Component>();
	protected UI_Model ui = UI_Model.getInstance();
	
	protected AUI_Communicator(){
		
	}
	
	public static AUI_Communicator getInstance(){
		if (self == null)
			self = new AUI_Communicator();
		return self;
	}

	public DataFromCUI receiveInputData(String id) {
		UI_Component myComponent = null;
		for (UI_Component activeComp : activeComps) {
			if(activeComp.isInnerElement(id)){
				
			}
		}
		if (myComponent == null){
			myComponent = ui.getComponent(id);
			if (!activeComps.contains(myComponent)){
				myComponent.active();
				activeComps.add(myComponent);
			}
		}
		DataFromCUI retur = myComponent.invokeInputData(id);
		if (myComponent.hasInnerElements()){
			activeComps.remove(myComponent);
		}
		return retur;
	}

	public DataFromCUI receiveSelectedData(String id, DataUIType selectable) {
		UI_Component myComponent = null;
		for (UI_Component activeComp : activeComps) {
			if(activeComp.isInnerElement(id)){
				
			}
		}
		if (myComponent == null){
			myComponent = ui.getComponent(id);
			if (!activeComps.contains(myComponent)){
				myComponent.active();
				activeComps.add(myComponent);
			}
		}
		DataFromCUI retur = myComponent.invokeSelectAtc(id, selectable);
		if (myComponent.hasInnerElements()){
			activeComps.remove(myComponent);
		}
		return retur;
	}

	public DataFromCUI sendData(String id, DataUIType data) {
		UI_Component myComponent = null;
		for (UI_Component activeComp : activeComps) {
			if(activeComp.isInnerElement(id)){
				
			}
		}
		if (myComponent == null){
			myComponent = ui.getComponent(id);
			if (!activeComps.contains(myComponent)){
				myComponent.active();
				activeComps.add(myComponent);
			}
		}
		DataFromCUI retur = myComponent.sendData(id, data);
		if (myComponent.hasInnerElements()){
			activeComps.remove(myComponent);
		}
		return retur;
	}
}
