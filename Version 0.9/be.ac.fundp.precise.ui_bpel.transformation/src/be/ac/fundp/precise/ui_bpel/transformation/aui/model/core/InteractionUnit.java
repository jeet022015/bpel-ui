package be.ac.fundp.precise.ui_bpel.transformation.aui.model.core;

/**
 * A abstract class that represents any element in a AUI.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
abstract class InteractionUnit implements InteractionUnitIF{
	
	/** The comp. */
	private AbstractComponentIU comp;
	
	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.InteractionUnitIF#setParentIU(be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.AbstractComponentIU)
	 */
	@Override
	public void setParentIU(AbstractComponentIU comp){
		this.comp = comp;
	}
	
	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.InteractionUnitIF#getParentIU()
	 */
	@Override
	public AbstractComponentIU getParentIU(){
		return comp;
	}

}
