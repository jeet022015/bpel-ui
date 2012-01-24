package be.ac.fundp.precise.ui_bpel.ui.editpart;

import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.ui.adapters.IEventHandlerHolder;
import org.eclipse.bpel.ui.editparts.ScopeEditPart;
import org.eclipse.bpel.ui.util.BPELUtil;

/**
 * The panel in the UI ScopeUiEditPart represent the edit part in
 * eclipse UI that present the information about ScopeUI.
 * 
 * In the collapsed state, this class will render the node. In the
 * expanded state, the subclass will be expected to render the node.
 * 
 * @see be.edu.fundp.precise.uibpel.model.ScopeUI
 * 
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class ScopeUiEditPart extends ScopeEditPart {
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.editparts.ScopeEditPart#getEventHandler()
	 */
	public EventHandler getEventHandler() {
		IEventHandlerHolder holder = BPELUtil.adapt(getActivity(), IEventHandlerHolder.class);
		if (holder != null) {
			return holder.getEventHandler(getActivity());
		}
		return null;
	}

}
