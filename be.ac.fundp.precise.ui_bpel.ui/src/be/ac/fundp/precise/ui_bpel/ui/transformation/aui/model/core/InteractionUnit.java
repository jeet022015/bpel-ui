package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core;

abstract class InteractionUnit implements InteractionUnitIF{
	
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
