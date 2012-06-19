package be.ac.fundp.precise.ui_bpel.transformation.aui.model.core;

// TODO: Auto-generated Javadoc
/**
 * The Interface InteractionUnitIF.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public interface InteractionUnitIF {

	/**
	 * Sets the parent iu.
	 *
	 * @param comp the new parent iu
	 */
	public abstract void setParentIU(AbstractComponentIU comp);

	/**
	 * Gets the parent iu.
	 *
	 * @return the parent iu
	 */
	public abstract AbstractComponentIU getParentIU();

}