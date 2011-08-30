package be.ac.fundp.precise.ui_bpel.ui.palette;

import org.eclipse.bpel.common.ui.palette.IPaletteProvider;
import org.eclipse.bpel.common.ui.palette.PaletteCategory;
import org.eclipse.bpel.ui.util.BPELCreationToolEntry;
import org.eclipse.gef.palette.PaletteRoot;

import be.ac.fundp.precise.ui_bpel.ui.Messages;
import be.ac.fundp.precise.ui_bpel.ui.factories.BpelUiObjectFactory;
import be.edu.fundp.precise.uibpel.model.ModelPackage;

public class BpelUiPaletteProvider implements IPaletteProvider {

	@Override
	public void contributeItems(PaletteRoot paletteRoot) {

		PaletteCategory category = new PaletteCategory(Messages.UIBPELEditor_Palette);
		category.setCategoryId("uibpel");
		category.setOrder(30);

		category.add(new BPELCreationToolEntry(
				Messages.UIBPELEditor_Data_Input_UI_1, Messages.UIBPELEditor_Data_Input_UI_2,
						new BpelUiObjectFactory(ModelPackage.eINSTANCE
								.getDataInputUI())));
		
		category.add(new BPELCreationToolEntry(
				Messages.UIBPELEditor_Data_Output_UI_1, Messages.UIBPELEditor_Data_Output_UI_2,
				new BpelUiObjectFactory(ModelPackage.eINSTANCE
						.getDataOutputUI())));
		
		category.add(new BPELCreationToolEntry(
				Messages.UIBPELEditor_Data_Selection_UI_1, Messages.UIBPELEditor_Data_Selection_UI_2,
				new BpelUiObjectFactory(ModelPackage.eINSTANCE
						.getDataSelectionUI())));
		
		category.add(new BPELCreationToolEntry("Scope UI", "Scope UI",
				new BpelUiObjectFactory(ModelPackage.eINSTANCE
						.getScopeUI())));
		
		category.add(new BPELCreationToolEntry("Pick UI", "Pick UI",
				new BpelUiObjectFactory(ModelPackage.eINSTANCE
						.getPickUI())));

		paletteRoot.add(category);
	}
}
