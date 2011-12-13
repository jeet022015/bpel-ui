package be.ac.fundp.precise.ui_bpel.ui.adapters;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.adapters.ContainerAdapter;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.adapters.IExtensionFactory;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.adapters.IOutlineEditPartFactory;
import org.eclipse.bpel.ui.adapters.delegates.ActivityContainer;
import org.eclipse.bpel.ui.editparts.ElseIfEditPart;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.swt.graphics.Image;

import be.ac.fundp.precise.ui_bpel.ui.ExtensionSampleUIConstants;
import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class OnUserEventAdapter.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class OnUserEventAdapter extends ContainerAdapter implements ILabeledElement,
	EditPartFactory, IOutlineEditPartFactory, IMarkerHolder, IExtensionFactory
{	

	/* IContainer delegate */
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.adapters.ContainerAdapter#createContainerDelegate()
	 */
	@Override
	public IContainer createContainerDelegate() {
		return new ActivityContainer(ModelPackage.eINSTANCE.getOnUserEvent_Activity());
	}

	/* ILabeledElement */
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getSmallImage(java.lang.Object)
	 */
	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(ExtensionSampleUIConstants.ON_USER_EVENT_ICON_16);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getLargeImage(java.lang.Object)
	 */
	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(ExtensionSampleUIConstants.ON_USER_EVENT_ICON_20);
	}	
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getTypeLabel(java.lang.Object)
	 */
	public String getTypeLabel(Object object) {
		return "OnUserEvent"; 
	}	
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getLabel(java.lang.Object)
	 */
	public String getLabel(Object object) {
		String s = ModelHelper.getDisplayName(object);
		if (s != null && !("".equals(s))) return s; //$NON-NLS-1$

		OnUserEvent onEvent = (OnUserEvent)object;
		// If it has an operation, use the operation's name as the label
		String operation = onEvent.getId();
		if (operation != null && !operation.equals("")) {
			return operation;
		}
		return getTypeLabel(object);
	}	

	/* EditPartFactory */
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		//Resource r = ((EObject)model).eResource();
		EditPart result = new ElseIfEditPart();
		result.setModel(model);
		return result;
	}

	/* IOutlineEditPartFactory */
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.adapters.IOutlineEditPartFactory#createOutlineEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	public EditPart createOutlineEditPart(EditPart context, Object model) {
		EditPart result = new OutlineTreeEditPart();
		result.setModel(model);
		return result;
	}
	

	/* IExtensionFactory */
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.adapters.IExtensionFactory#createExtension(org.eclipse.emf.ecore.EObject)
	 */
	public EObject createExtension(EObject object) {
		return null;
		//return UiextensionmodelFactory.eINSTANCE.createOnEventExtension();
	}

}