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
		
		category.add(new BPELCreationToolEntry("New Scope",
				"New Scope", new ExtensionSampleUIObjectFactory(
						ModelPackage.eINSTANCE.getNewScope())));

		paletteRoot.add(category);
	}

}
