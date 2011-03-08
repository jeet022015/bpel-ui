package be.edu.fundp.precise.bpel_ui.ui.pallete;

import model.ModelPackage;

import org.eclipse.bpel.common.ui.palette.IPaletteProvider;
import org.eclipse.bpel.common.ui.palette.PaletteCategory;
import org.eclipse.bpel.ui.util.BPELCreationToolEntry;
import org.eclipse.gef.palette.PaletteRoot;

import be.edu.fundp.precise.bpel_ui.ui.factories.BPEL_UI_UIObjectFactory;

public class BPEL_UI_PaletteProvider implements IPaletteProvider{

	public void contributeItems(PaletteRoot paletteRoot) {
		PaletteCategory category = new PaletteCategory("BPEL-UI");
		category.setCategoryId("bpel-ui");
		category.setOrder(40);

		category.add(new BPELCreationToolEntry("DataInputUI", "DataInputUI",
				new BPEL_UI_UIObjectFactory(ModelPackage.eINSTANCE.getDataInputUI())));
		
		category.add(new BPELCreationToolEntry("DataOutputUI", "DataOutputUI",
				new BPEL_UI_UIObjectFactory(ModelPackage.eINSTANCE.getDataOutputUI())));

		paletteRoot.add(category);
	}

}
