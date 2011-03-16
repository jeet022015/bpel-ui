package org.eclipse.bpel.extensionssample.ui.adapters;

import java.util.List;

import org.eclipse.bpel.extensionssample.ui.action.editpart.CreateOnUserInteractionAction;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.ui.actions.editpart.AbstractAction;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.adapters.PickAdapter;
import org.eclipse.bpel.ui.adapters.delegates.MultiContainer;
import org.eclipse.bpel.ui.adapters.delegates.ReferenceContainer;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.bpel.ui.editparts.PickEditPart;
import org.eclipse.gef.EditPart;

import be.edu.fundp.bpel_ui.model.ModelPackage;

public class NewPickAdapter extends PickAdapter {
	
	@Override
	public IContainer createContainerDelegate() {
		MultiContainer omc = new MultiContainer();
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getPick_Messages()));
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getPick_Alarm()));
		omc.add(new ReferenceContainer(ModelPackage.eINSTANCE.getNewPick_UserInteracion()));
		//omc.add(new ReferenceContainer(ModelPackage));
		return omc;
	}
	
/* EditPartFactory */
	
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart result = new PickEditPart();
		result.setModel(model);
		return result;
	}

	/* IOutlineEditPartFactory */
	
	@Override
	public EditPart createOutlineEditPart(EditPart context, Object model) {
		EditPart result = new OutlineTreeEditPart();
		result.setModel(model);
		return result;
	}

	/* IEditPartActionContributor */
	
	@Override
	public List<AbstractAction> getEditPartActions(final EditPart editPart) {
		List<AbstractAction> actions = super.getEditPartActions(editPart);

		actions.add(new CreateOnUserInteractionAction(editPart));

		return actions;
	}

}
