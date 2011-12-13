package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.strategies;

import auiPackage.AbstractDataIU;
import auiPackage.AuiPackageFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class StrategySelectionUI.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class StrategySelectionUI implements StrategyAUIElement {

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.transformation.aui.strategies.StrategyAUIElement#getStrategy()
	 */
	@Override
	public AbstractDataIU getStrategy() {
		return AuiPackageFactory.eINSTANCE.createAbstractSelectionIU();
	}

}
