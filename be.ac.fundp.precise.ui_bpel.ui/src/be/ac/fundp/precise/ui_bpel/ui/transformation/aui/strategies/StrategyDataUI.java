package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.strategies;

import auiPackage.AbstractDataIU;
import auiPackage.AuiPackageFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class StrategyDataUI.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class StrategyDataUI implements StrategyAUIElement {

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.transformation.aui.strategies.StrategyAUIElement#getStrategy()
	 */
	@Override
	public AbstractDataIU getStrategy() {
		return AuiPackageFactory.eINSTANCE.createAbstractDataIU();
	}

}
