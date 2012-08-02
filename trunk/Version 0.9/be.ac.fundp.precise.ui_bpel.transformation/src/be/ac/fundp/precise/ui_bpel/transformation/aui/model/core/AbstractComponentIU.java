package be.ac.fundp.precise.ui_bpel.transformation.aui.model.core;

import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a component in an Abstract User Interface.
 * A component can be considered as a Compound (UsiXML), Interactor
 * Composition (MARIA), or UI Group (UI MDE Approach).
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class AbstractComponentIU extends InteractionUnit{

	/** The inner elements of the composition. */
	protected List<InteractionUnit> interactionUnits = 
			new LinkedList<InteractionUnit>();
	
	/** The help description. */
	protected String help;
	
	/** The id of the composition. */
	protected String id;
	
	/** The label of the composition. */
	protected String label;
	
	/**
	 * This method Gets the Component's label.
	 *
	 * @return the label of the composition
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * This method sets the Component's label.
	 *
	 * @param string the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/** The parent model. */
	protected AbstractUIModel model;
	
	/**
	 * This method Sets the help.
	 *
	 * @param string the new help
	 */
	public void setHelp(String string) {
		help = string;
	}

	/**
	 * This method Sets the id.
	 *
	 * @param idGen the new id of the composition
	 */
	public void setId(String idGen) {
		id = idGen;
		
	}

	/**
	 * This method Sets the parent model.
	 *
	 * @param model the new parent model
	 */
	public void setModel(AbstractUIModel model) {
		this.model = model;
	}

	/**
	 * This method Gets the id.
	 *
	 * @return the id of the composition
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method Gets the list of the inner interaction units.
	 *
	 * @return the list of inner interaction units
	 */
	public List<InteractionUnit> getInnerInteractionUnits() {
		return interactionUnits;
	}
	
	/**
	 * This method Creates the inner trigger in the composition.
	 *
	 * @see be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.TriggerUI
	 *
	 * @return the trigger.
	 */
	public TriggerUI createInnerAbstractTriggerIU(String triggerId) {
		TriggerUI trigger = new TriggerUI();
		trigger.setId(triggerId);
		interactionUnits.add(trigger);
		return trigger;
	}
	
	/**
	 * This method creates the inner data interaction.
	 *
	 * @see be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.DataIU
	 *
	 * @return the data element.
	 */
	public DataIU createInnerDataInputUI() {
		DataIU input = new DataIU();
		interactionUnits.add(input);
		input.setParentIU(this);
		return input;
	}
}
