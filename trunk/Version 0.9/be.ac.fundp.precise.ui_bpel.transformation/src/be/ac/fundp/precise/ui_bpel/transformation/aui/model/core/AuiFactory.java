package be.ac.fundp.precise.ui_bpel.transformation.aui.model.core;

import be.ac.fundp.precise.ui_bpel.transformation.aui.model.CoordinationConfig;

/**
 * A factory for creating Aui objects.
 */
public class AuiFactory {

	/** The information to configure the coordination of
	 * the UI navigation and the WSC. */
	protected CoordinationConfig coordConfig = null;

	/**
	 * Instantiates a new aui factory.
	 */
	public AuiFactory () {
		
	}
	
	/**
	 * Instantiates a new aui factory.
	 *
	 * @param the coordination configurator
	 */
	public AuiFactory (CoordinationConfig c) {
		coordConfig = c;
	}

	/**
	 * Creates a new Aui object.
	 *
	 * @return the abstract ui model
	 */
	public AbstractUIModel createAbstractUIModel() {
		return new AbstractUIModel();
	}

}
