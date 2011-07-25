package be.edu.fundp.precisebpel_ui.ui.editpart;

import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.ui.adapters.IEventHandlerHolder;
import org.eclipse.bpel.ui.editparts.ScopeEditPart;
import org.eclipse.bpel.ui.util.BPELUtil;

public class ScopeUiEditPart extends ScopeEditPart {
	
	public EventHandler getEventHandler() {
		IEventHandlerHolder holder = BPELUtil.adapt(getActivity(), IEventHandlerHolder.class);
		if (holder != null) {
			return holder.getEventHandler(getActivity());
		}
		return null;
	}

}
