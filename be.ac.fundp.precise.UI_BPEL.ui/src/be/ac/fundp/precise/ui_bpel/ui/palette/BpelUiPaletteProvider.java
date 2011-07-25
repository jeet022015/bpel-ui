package be.ac.fundp.precise.ui_bpel.ui.palette;

import org.eclipse.bpel.common.ui.palette.IPaletteProvider;
import org.eclipse.bpel.common.ui.palette.PaletteCategory;
import org.eclipse.bpel.ui.util.BPELCreationToolEntry;
import org.eclipse.gef.palette.PaletteRoot;

import be.ac.fundp.precise.ui_bpel.ui.factories.BpelUiObjectFactory;
import be.edu.fundp.precise.uibpel.model.ModelPackage;

public class BpelUiPaletteProvider implements IPaletteProvider {

	@Override
	public void contributeItems(PaletteRoot paletteRoot) {

		PaletteCategory category = new PaletteCategory("UI BPEL");
		category.setCategoryId("uibpel");
		category.setOrder(40);

		category.add(new BPELCreationToolEntry("Data Input UI", "Data Input UI",
						new BpelUiObjectFactory(ModelPackage.eINSTANCE
								.getDataInputUI())));
		
		category.add(new BPELCreationToolEntry("Data Output UI", "Data Output UI",
				new BpelUiObjectFactory(ModelPackage.eINSTANCE
						.getDataOutputUI())));
		
		category.add(new BPELCreationToolEntry("Data Selection UI", "Data Selection UI",
				new BpelUiObjectFactory(ModelPackage.eINSTANCE
						.getDataSelectionUI())));

		paletteRoot.add(category);
	}
}
