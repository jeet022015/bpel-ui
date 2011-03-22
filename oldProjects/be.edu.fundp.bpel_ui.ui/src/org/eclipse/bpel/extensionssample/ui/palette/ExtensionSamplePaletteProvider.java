package org.eclipse.bpel.extensionssample.ui.palette;

import org.eclipse.bpel.common.ui.palette.IPaletteProvider;
import org.eclipse.bpel.common.ui.palette.PaletteCategory;
import org.eclipse.bpel.extensionssample.ui.factories.ExtensionSampleUIObjectFactory;
import org.eclipse.bpel.ui.util.BPELCreationToolEntry;
import org.eclipse.gef.palette.PaletteRoot;

import be.edu.fundp.bpel_ui.model.ModelPackage;

public class ExtensionSamplePaletteProvider implements IPaletteProvider {

	@Override
	public void contributeItems(PaletteRoot paletteRoot) {

		PaletteCategory category = new PaletteCategory("ExtensionSample");
		category.setCategoryId("extensionsample");
		category.setOrder(40);

		
		category.add(new BPELCreationToolEntry("New Pick",
				"New Pick", new ExtensionSampleUIObjectFactory(
						ModelPackage.eINSTANCE.getNewPick())));

		paletteRoot.add(category);
	}

}
