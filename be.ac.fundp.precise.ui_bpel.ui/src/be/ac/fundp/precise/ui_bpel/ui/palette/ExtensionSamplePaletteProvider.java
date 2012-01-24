package be.ac.fundp.precise.ui_bpel.ui.palette;

import org.eclipse.bpel.common.ui.palette.IPaletteProvider;
import org.eclipse.bpel.common.ui.palette.PaletteCategory;
import org.eclipse.bpel.ui.util.BPELCreationToolEntry;
import org.eclipse.gef.palette.PaletteRoot;

import be.ac.fundp.precise.ui_bpel.ui.factories.UI_BPEL_ObjectFactory;
import be.edu.fundp.precise.uibpel.model.ModelPackage;

/**
 * This class adds the new UI-BPEL elements to the BPEL Design's palette.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class ExtensionSamplePaletteProvider implements IPaletteProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.common.ui.palette.IPaletteProvider#contributeItems(org.eclipse.gef.palette.PaletteRoot)
	 */
	@Override
	public void contributeItems(PaletteRoot paletteRoot) {

		PaletteCategory category = new PaletteCategory("User Interactions");
		category.setCategoryId("uibpel");
		category.setOrder(40);

		category.add(new BPELCreationToolEntry(
				"Data Input UI", "Data Input UI",
						new UI_BPEL_ObjectFactory(ModelPackage.eINSTANCE
								.getDataInputUI())));
		
		category.add(new BPELCreationToolEntry(
				"Data Output UI", "Data Output UI",
				new UI_BPEL_ObjectFactory(ModelPackage.eINSTANCE
						.getDataOutputUI())));
		
		category.add(new BPELCreationToolEntry(
				"Data Selection UI", "Data Selection UI",
				new UI_BPEL_ObjectFactory(ModelPackage.eINSTANCE
						.getDataSelectionUI())));
		
		category.add(new BPELCreationToolEntry("Scope UI", "Scope UI",
				new UI_BPEL_ObjectFactory(ModelPackage.eINSTANCE
						.getScopeUI())));
		
		category.add(new BPELCreationToolEntry("Pick UI", "Pick UI",
				new UI_BPEL_ObjectFactory(ModelPackage.eINSTANCE
						.getPickUI())));

		paletteRoot.add(category);
	}

}
