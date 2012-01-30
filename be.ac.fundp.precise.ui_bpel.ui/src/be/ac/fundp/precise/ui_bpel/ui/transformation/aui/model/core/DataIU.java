package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core;

public class DataIU extends InteractionUnit{

	public static final int INPUT = 1;
	public static final int OUTPUT = 0;
	private int uiType;
	private String type;
	private String label;
	private String id;
	
	public int getUiType() {
		return uiType;
	}

	public String getType() {
		return type;
	}

	public String getLabel() {
		return label;
	}

	public void setDataUIType(int output) {
		this.uiType = output;
	}

	public void setDataType(String name) {
		this.type = name;
	}

	public void setLabel(String name) {
		this.label = name;
	}

	public String getId() {
		return id;
	}

}
