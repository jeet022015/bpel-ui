package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.strategies;

import auiPackage.AbstractDataIU;
import auiPackage.AuiPackageFactory;

public class StrategyDataUI implements StrategyAUIElement {

	@Override
	public AbstractDataIU getStrategy() {
		return AuiPackageFactory.eINSTANCE.createAbstractDataIU();
	}

}
