package be.edu.fundp.precisebpel_ui.ui.action.editpart;

import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.actions.editpart.AbstractAction;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.InsertInContainerCommand;
import org.eclipse.bpel.ui.commands.SetNameAndDirectEditCommand;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import be.edu.fundp.precise.bpel_ui.model.ModelPackage;
import be.edu.fundp.precisebpel_ui.ui.factories.BPEL_UIObjectFactory;


public class CreateOnUserInteractionAction extends AbstractAction {

	public CreateOnUserInteractionAction(EditPart editPart) {
		super(editPart);
	}

	public ImageDescriptor getIcon() {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_ACTION_ONALARM);
	}

	public Image getIconImg() {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_ACTION_ONALARM);
	}

	public boolean onButtonPressed() {
		CompoundCommand command = new CompoundCommand();
		BPEL_UIObjectFactory e = new BPEL_UIObjectFactory();
		e.setModelType(ModelPackage.eINSTANCE.getOnUserEvent());
		EObject child = e.createInstance();
		command.add(new InsertInContainerCommand((EObject)modelObject, child, null));
		command.add(new SetNameAndDirectEditCommand(child, viewer));
		BPELEditor bpelEditor = ModelHelper.getBPELEditor(modelObject);
		bpelEditor.getCommandStack().execute(command);
		return true;
	}

	public String getToolTip() {
		return "Add On User Event"; 
	}
	
	@Override
	public ImageDescriptor getDisabledIcon() { return ImageDescriptor.getMissingImageDescriptor(); }
	@Override
	public boolean isEnabled() { return true; }	

}
