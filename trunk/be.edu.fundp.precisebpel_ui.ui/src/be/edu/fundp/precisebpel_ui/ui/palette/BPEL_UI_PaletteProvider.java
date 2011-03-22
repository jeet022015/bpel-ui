package be.edu.fundp.precisebpel_ui.ui.palette;

import org.eclipse.bpel.common.ui.palette.IPaletteProvider;
import org.eclipse.bpel.common.ui.palette.PaletteCategory;
import org.eclipse.bpel.ui.util.BPELCreationToolEntry;
import org.eclipse.gef.palette.PaletteRoot;

import be.edu.fundp.precise.bpel_ui.model.ModelPackage;
import be.edu.fundp.precisebpel_ui.ui.factories.BPEL_UIObjectFactory;

public class BPEL_UI_PaletteProvider implements IPaletteProvider {

	@Override
	public void contributeItems(PaletteRoot paletteRoot) {

		PaletteCategory category = new PaletteCategory("BPEL-UI");
		category.setCategoryId("BPEL-UI");
		category.setOrder(40);

		category.add(new BPELCreationToolEntry("Data Input UI", "Data Input UI",
						new BPEL_UIObjectFactory(ModelPackage.eINSTANCE
								.getDataInputUI())));
		
		category.add(new BPELCreationToolEntry("Data Output UI", "Data Output UI",
				new BPEL_UIObjectFactory(ModelPackage.eINSTANCE
						.getDataOutputUI())));
		
		paletteRoot.add(category);
	}
}
