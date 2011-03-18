package org.eclipse.bpel.extensionssample.ui.adapters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.extensionssample.ui.action.editpart.CreateOnUserInteractionAction;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.ui.actions.editpart.AbstractAction;
import org.eclipse.bpel.ui.adapters.EventHandlerAdapter;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.adapters.delegates.MultiContainer;
import org.eclipse.bpel.ui.adapters.delegates.ReferenceContainer;
import org.eclipse.gef.EditPart;

import be.edu.fundp.bpel_ui.model.ModelPackage;


public class NewEventHandlerAdapter extends EventHandlerAdapter {
	

	/* IContainer delegate */

	@Override
	public IContainer createContainerDelegate() {
		MultiContainer omc = new MultiContainer();
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getEventHandler_Events()));
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getEventHandler_Alarm()));
		//omc.add(new ReferenceContainer(ModelPackage.eINSTANCE.getNewEventHandler_UserInteracion()));
		System.out.println("aqui tah blz2?");
		return omc;
	}

	/* IEditPartActionContributor */
	
	public List<AbstractAction> getEditPartActions(final EditPart editPart) {
		List<AbstractAction> actions = super.getEditPartActions(editPart);

		actions.add(new CreateOnUserInteractionAction(editPart));
		
		return actions;
	}
}
