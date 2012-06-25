package be.ac.fundp.precise.ui_bpel.ui.adapters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.ui.actions.editpart.AbstractAction;
import org.eclipse.bpel.ui.actions.editpart.CreateCompensationHandlerAction;
import org.eclipse.bpel.ui.actions.editpart.CreateFaultHandlerAction;
import org.eclipse.bpel.ui.actions.editpart.CreateTerminationHandlerAction;
import org.eclipse.bpel.ui.adapters.ICompensationHandlerHolder;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.adapters.IEventHandlerHolder;
import org.eclipse.bpel.ui.adapters.IFaultHandlerHolder;
import org.eclipse.bpel.ui.adapters.ITerminationHandlerHolder;
import org.eclipse.bpel.ui.adapters.ScopeAdapter;
import org.eclipse.bpel.ui.adapters.delegates.ActivityContainer;
import org.eclipse.bpel.ui.adapters.delegates.MultiContainer;
import org.eclipse.bpel.ui.adapters.delegates.OptionalIndirectContainer;
import org.eclipse.bpel.ui.adapters.delegates.ReferenceContainer;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.gef.EditPart;

import be.ac.fundp.precise.ui_bpel.ui.action.editpart.CreateEventHandlerUIAction;
import be.ac.fundp.precise.ui_bpel.ui.editpart.ScopeUiEditPart;

// TODO: Auto-generated Javadoc
/**
 * The Class ScopeUIAdapter.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class ScopeUIAdapter extends ScopeAdapter {
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.adapters.ScopeAdapter#createContainerDelegate()
	 */
	@Override
	public IContainer createContainerDelegate() {
		MultiContainer omc = new MultiContainer();
		omc.add(new ActivityContainer(BPELPackage.eINSTANCE.getScope_Activity()));
		// TODO: Support scoped partner links, correlation sets, variables and message exchanges
		omc.add(new OptionalIndirectContainer(BPELPackage.eINSTANCE.getScope_PartnerLinks(),			
			new ReferenceContainer(BPELPackage.eINSTANCE.getPartnerLinks_Children())));
		omc.add(new OptionalIndirectContainer(BPELPackage.eINSTANCE.getScope_CorrelationSets(),			
			new ReferenceContainer(BPELPackage.eINSTANCE.getCorrelationSets_Children())));
		omc.add(new OptionalIndirectContainer(BPELPackage.eINSTANCE.getScope_Variables(),			
			new ReferenceContainer(BPELPackage.eINSTANCE.getVariables_Children())));
		omc.add(new OptionalIndirectContainer(BPELPackage.eINSTANCE.getScope_MessageExchanges(),			
				new ReferenceContainer(BPELPackage.eINSTANCE.getMessageExchanges_Children())));
		
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getScope_FaultHandlers()));
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getScope_CompensationHandler()));
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getScope_TerminationHandler()));
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getScope_EventHandlers()));
		return omc;
	}
	
	/* EditPartFactory */
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.adapters.ScopeAdapter#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart result = new ScopeUiEditPart();
		result.setModel(model);
		return result;
	}
	
	/* IEditPartActionContributor */
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.adapters.ScopeAdapter#getEditPartActions(org.eclipse.gef.EditPart)
	 */
	public List<AbstractAction> getEditPartActions(final EditPart editPart) {
		List<AbstractAction> actions = new ArrayList<AbstractAction>();
		Object modelObject = editPart.getModel();
		
		IFaultHandlerHolder ifh =  BPELUtil.adapt(modelObject, IFaultHandlerHolder.class);
		if (ifh != null && ifh.getFaultHandler(modelObject) == null) {
			actions.add(new CreateFaultHandlerAction(editPart));
		}			
		ICompensationHandlerHolder ich = BPELUtil.adapt(modelObject, ICompensationHandlerHolder.class);
		if (ich != null && ich.getCompensationHandler(modelObject) == null) {
    		actions.add(new CreateCompensationHandlerAction(editPart));
		}
		ITerminationHandlerHolder ith = BPELUtil.adapt(modelObject, ITerminationHandlerHolder.class);
		if (ith != null && ith.getTerminationHandler(modelObject) == null) {
    		actions.add(new CreateTerminationHandlerAction(editPart));
		}
		IEventHandlerHolder ieh = BPELUtil.adapt(modelObject, IEventHandlerHolder.class);
		if (ieh != null && ieh.getEventHandler(modelObject) == null) {
	    	actions.add(new CreateEventHandlerUIAction(editPart));
		}
		
		return actions;
	}
	

}
