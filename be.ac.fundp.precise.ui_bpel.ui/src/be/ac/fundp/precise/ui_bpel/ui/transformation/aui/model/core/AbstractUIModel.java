package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core;

import java.util.LinkedList;
import java.util.List;

public class AbstractUIModel {

	protected List<AbstractComponentIU> compoundUIs = new LinkedList<AbstractComponentIU>();
	
	public AbstractComponentIU createInnerAbstractCompoundIU(){
		AbstractComponentIU compound = new AbstractComponentIU();
		compoundUIs.add(compound);
		
		compound.setModel(this);
		
		return compound;
	}

	public SelectionUI createInnerSelectionUI() {
		SelectionUI compound = new SelectionUI();
		compoundUIs.add(compound);
		
		compound.setModel(this);
		
		return compound;
	}

	public List<AbstractComponentIU> getInnerAbstractCompoundIU() {
		return compoundUIs;
	}

}
