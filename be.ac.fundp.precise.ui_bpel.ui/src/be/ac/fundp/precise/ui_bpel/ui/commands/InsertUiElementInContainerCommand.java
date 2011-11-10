package be.ac.fundp.precise.ui_bpel.ui.commands;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.OpaqueActivity;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.commands.InsertInContainerCommand;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.w3c.dom.Node;

import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.util.BpelUiReconciliationHelper;

public class InsertUiElementInContainerCommand extends InsertInContainerCommand{

	public InsertUiElementInContainerCommand(EObject aParent, EObject aChild,
			EObject aBeforeMarker) {
		super(aParent, aChild, aBeforeMarker);
	}
	
	/**
	 * @see org.eclipse.bpel.ui.commands.util.AutoUndoCommand#canDoExecute()
	 */
	@Override
	public boolean canDoExecute() {
		IContainer container = BPELUtil.adapt(parent, IContainer.class);
		
		// https://issues.jboss.org/browse/JBIDE-8068
		// Adding an opaque activity will make the process abstract!
		// Make sure this is what the user had intended.
		if (child instanceof OpaqueActivity) {
			Process process = BPELUtils.getProcess(parent);
			if ( !BPELUtils.isAbstractProcess(process) ) {
				if (!MessageDialog.openQuestion(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(),
						Messages.Make_Process_Abstract_Title,
						Messages.Make_Process_Abstract_Message)) {
					return false;
				}
			}
		}
		boolean returnBool =  container.canAddObject(parent, child, before);
		return returnBool;
	}

	/**
	 * @see org.eclipse.bpel.ui.commands.util.AutoUndoCommand#doExecute()
	 */
	@Override
	public void doExecute() {
		IContainer container = BPELUtil.adapt(parent, IContainer.class);
		container.addChild(parent, child, before);

		Node parentElement = getRealParentElement(child, parent);
	    Node beforeElement = getRealBeforeElement(child, parent, before);
	    BpelUiReconciliationHelper.getInstance().patchDomUI(child, parent, parentElement, before, beforeElement);
	}
	
	/**
	 * In case we created implicit sequence to hold two children and we want to insert 
	 * before that sequence that means we want to insert at the beginning of that sequence 
	 * @param child
	 * @param parent
	 * @param before
	 * @return
	 */
	private static Node getRealBeforeElement(EObject child, EObject parent, EObject before) {
		if (before != null && !(before instanceof org.eclipse.bpel.ui.uiextensionmodel.impl.EndNodeImpl)) {
	    	if (ReconciliationHelper.isSingleActivityContainer(parent) && child instanceof Activity) {
	    		return ReconciliationHelper.getActivity(parent).getElement().getFirstChild();
	    	} 
	    	return org.eclipse.bpel.ui.util.BPELEditorUtil.getInstance().getElementForObject(before);	    	
	    }
		return null;
	}
	
	/**
	 * In case we created implicit sequence to hold two children we need to patch
	 * parent element to be that sequence 
	 * @param child
	 * @param parent
	 * @return
	 */
	private static Node getRealParentElement(EObject child, EObject parent) {
		if (ReconciliationHelper.isSingleActivityContainer(parent) && child instanceof Activity && child != ReconciliationHelper.getActivity(parent)) {
	    	return org.eclipse.bpel.ui.util.BPELEditorUtil.getInstance().getElementForObject(ReconciliationHelper.getActivity(parent));
	    } else if (BPELUtils.isTransparent(parent.eContainer(), parent)) {
	    	EObject container = parent.eContainer();
			return org.eclipse.bpel.ui.util.BPELEditorUtil.getInstance().getElementForObject(container);
	    }
	    return org.eclipse.bpel.ui.util.BPELEditorUtil.getInstance().getElementForObject(parent);		
	}
	
}
