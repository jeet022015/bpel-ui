package be.ac.fundp.precise.ui_bpel.ui.action.editpart;

import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.actions.editpart.AbstractAction;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetNameAndDirectEditCommand;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import be.ac.fundp.precise.ui_bpel.ui.commands.InsertUiElementInContainerCommand;
import be.ac.fundp.precise.ui_bpel.ui.factories.UI_BPEL_ObjectFactory;
import be.edu.fundp.precise.uibpel.model.ModelPackage;


// TODO: Auto-generated Javadoc
/**
 * The Class CreateOnUserInteractionAction.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class CreateOnUserInteractionAction extends AbstractAction {

	/**
	 * Instantiates a new creates the on user interaction action.
	 *
	 * @param editPart the edit part
	 */
	public CreateOnUserInteractionAction(EditPart editPart) {
		super(editPart);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#getIcon()
	 */
	public ImageDescriptor getIcon() {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_ACTION_ONALARM);
	}

	/**
	 * Gets the icon img.
	 *
	 * @return the icon img
	 */
	public Image getIconImg() {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_ACTION_ONALARM);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#onButtonPressed()
	 */
	public boolean onButtonPressed() {
		CompoundCommand command = new CompoundCommand();
		UI_BPEL_ObjectFactory e = new UI_BPEL_ObjectFactory();
		e.setModelType(ModelPackage.eINSTANCE.getOnUserEvent());
		EObject child = e.createInstance();
		command.add(new InsertUiElementInContainerCommand((EObject)modelObject, child, null));
		command.add(new SetNameAndDirectEditCommand(child, viewer));
		BPELEditor bpelEditor = ModelHelper.getBPELEditor(modelObject);
		bpelEditor.getCommandStack().execute(command);
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#getToolTip()
	 */
	public String getToolTip() {
		//TODO Create a constant
		return "Add On User Event"; 
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.actions.editpart.AbstractAction#getDisabledIcon()
	 */
	@Override
	public ImageDescriptor getDisabledIcon() { return ImageDescriptor.getMissingImageDescriptor(); }
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.actions.editpart.AbstractAction#isEnabled()
	 */
	@Override
	public boolean isEnabled() { return true; }	

}
