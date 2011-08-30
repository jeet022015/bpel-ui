package be.ac.fundp.precise.ui_bpel.ui.adapters;

import java.util.List;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.ui.actions.editpart.AbstractAction;
import org.eclipse.bpel.ui.adapters.EventHandlerAdapter;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.adapters.delegates.MultiContainer;
import org.eclipse.bpel.ui.adapters.delegates.ReferenceContainer;
import org.eclipse.gef.EditPart;

import be.ac.fundp.precise.ui_bpel.ui.action.editpart.CreateOnUserInteractionAction;
import be.edu.fundp.precise.uibpel.model.ModelPackage;

public class EventHandlerUIAdapter extends EventHandlerAdapter {
	

	/* IContainer delegate */

	@Override
	public IContainer createContainerDelegate() {
		MultiContainer omc = new MultiContainer();
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getEventHandler_Events()));
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getEventHandler_Alarm()));
		omc.add(new ReferenceContainer(ModelPackage.eINSTANCE.getEventHandlerUI_UserInteraction()));
		return omc;
	}

	/* IEditPartActionContributor */
	
	public List<AbstractAction> getEditPartActions(final EditPart editPart) {
		List<AbstractAction> actions = super.getEditPartActions(editPart);

		actions.add(new CreateOnUserInteractionAction(editPart));
		
		return actions;
	}
}
