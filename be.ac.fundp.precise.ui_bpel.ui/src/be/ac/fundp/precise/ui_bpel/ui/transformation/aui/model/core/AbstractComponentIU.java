package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core;

import java.util.LinkedList;
import java.util.List;

public class AbstractComponentIU extends InteractionUnit{

	protected List<InteractionUnit> interactionUnits = 
			new LinkedList<InteractionUnit>();
	protected String help;
	protected String id;
	protected AbstractUIModel model;
	
	public void setHelp(String string) {
		help = string;
	}

	public void setId(String idGen) {
		id = idGen;
		
	}

	public void setModel(AbstractUIModel model) {
		this.model = model;
	}

	public String getId() {
		return id;
	}

	public List<InteractionUnit> getInnerInteractionUnits() {
		return interactionUnits;
	}
	
	public TriggerUI createInnerAbstractTriggerIU() {
		TriggerUI trigger = new TriggerUI();
		interactionUnits.add(trigger);
		return trigger;
	}
	
	public DataIU createInnerDataInputUI() {
		DataIU input = new DataIU();
		interactionUnits.add(input);
		input.setParentIU(this);
		return input;
	}

}
