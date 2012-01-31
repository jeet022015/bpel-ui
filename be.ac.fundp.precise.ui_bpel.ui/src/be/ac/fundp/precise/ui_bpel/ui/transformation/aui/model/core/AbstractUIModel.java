package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core;

import java.util.LinkedList;
import java.util.List;

/**
 * This class represents the complete Abstract User Interface.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class AbstractUIModel {

	/** The compound u is. */
	protected List<AbstractComponentIU> compoundUIs = new LinkedList<AbstractComponentIU>();
	
	/**
	 * Creates the inner abstract compound iu.
	 *
	 * @return the abstract component iu
	 */
	public AbstractComponentIU createInnerAbstractCompoundIU(){
		AbstractComponentIU compound = new AbstractComponentIU();
		compoundUIs.add(compound);
		
		compound.setModel(this);
		
		return compound;
	}

	/**
	 * Creates the inner selection ui.
	 *
	 * @return the selection ui
	 */
	public SelectionUI createInnerSelectionUI() {
		SelectionUI compound = new SelectionUI();
		compoundUIs.add(compound);
		
		compound.setModel(this);
		
		return compound;
	}

	/**
	 * Gets the inner abstract compound iu.
	 *
	 * @return the inner abstract compound iu
	 */
	public List<AbstractComponentIU> getInnerAbstractCompoundIU() {
		return compoundUIs;
	}

}
