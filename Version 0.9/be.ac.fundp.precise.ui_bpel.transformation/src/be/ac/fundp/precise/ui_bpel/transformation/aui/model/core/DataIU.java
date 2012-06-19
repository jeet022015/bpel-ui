package be.ac.fundp.precise.ui_bpel.transformation.aui.model.core;

/**
 * This class represents a data element in an Abstract User Interface.
 * A component can be considered as an Abstract Data IU (UsiXML), Edit
 * and Output_Only interactor (MARIA), or UI Group (UI MDE Approach), or
 * UI Unit (UI MDE Approach).
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class DataIU extends InteractionUnit{

	/** The Constant INPUT. */
	public static final int INPUT = 1;
	
	/** The Constant OUTPUT. */
	public static final int OUTPUT = 0;
	
	/** The ui type (input or output). */
	private int uiType;
	
	/** The Data type of the UI element. */
	private String type;
	
	/** The label. */
	private String label;
	
	/** The id. */
	private String id;
	
	/**
	 * Gets the ui type.
	 *
	 * @return the ui type
	 */
	public int getUiType() {
		return uiType;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the data ui type.
	 *
	 * @param output the new data ui type
	 */
	public void setDataUIType(int output) {
		this.uiType = output;
	}

	/**
	 * Sets the data type.
	 *
	 * @param name the new data type
	 */
	public void setDataType(String name) {
		this.type = name;
	}

	/**
	 * Sets the label.
	 *
	 * @param name the new label
	 */
	public void setLabel(String name) {
		this.label = name;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

}
