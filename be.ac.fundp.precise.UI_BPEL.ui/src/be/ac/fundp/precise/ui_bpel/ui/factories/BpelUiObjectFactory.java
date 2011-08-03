package be.ac.fundp.precise.ui_bpel.ui.factories;

import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.bpel.ui.factories.IExtensionUIObjectFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import be.ac.fundp.precise.ui_bpel.ui.Activator;
import be.ac.fundp.precise.ui_bpel.ui.Messages;
import be.edu.fundp.precise.uibpel.model.ModelPackage;

public class BpelUiObjectFactory extends AbstractUIObjectFactory implements IExtensionUIObjectFactory {
	private EClass modelType;
	private EClass[] classArray = { ModelPackage.eINSTANCE.getDataInputUI(), 
			ModelPackage.eINSTANCE.getDataOutputUI(), ModelPackage.eINSTANCE.getDataSelectionUI(),
			ModelPackage.eINSTANCE.getDataItem()};

	public BpelUiObjectFactory(EClass modelType) {
		super();
		this.modelType = modelType;
	}
	
	public BpelUiObjectFactory() {
		super();
	}
	
	@Override
	public Image getLargeImage() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = Messages.DATA_INPUT_ICON_20;
		else if (modelType.getName().equals("DataOutputUI"))
			path = Messages.DATA_OUTPUT_ICON_20;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = Messages.DATA_SELECTION_ICON_20;
		else if (modelType.getName().equals("OnUserEvent"))
			path = Messages.ON_USER_EVENT_ICON_20;
		else if (modelType.getName().equals("ScopeUI"))
			path = Messages.SCOPE_UI_ICON_20;
		else if (modelType.getName().equals("PickUI"))
			path = Messages.PICK_UI_ICON_20;
		else 
			path = Messages.DEFAULT_ICON_20;
		return Activator.getDefault().getImageRegistry().get(path);
	}

	@Override
	public ImageDescriptor getLargeImageDescriptor() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = Messages.DATA_INPUT_ICON_20;
		else if (modelType.getName().equals("DataOutputUI"))
			path = Messages.DATA_OUTPUT_ICON_20;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = Messages.DATA_SELECTION_ICON_20;
		else if (modelType.getName().equals("OnUserEvent"))
			path = Messages.ON_USER_EVENT_ICON_20;
		else if (modelType.getName().equals("ScopeUI"))
			path = Messages.SCOPE_UI_ICON_20;
		else if (modelType.getName().equals("PickUI"))
			path = Messages.PICK_UI_ICON_20;
		else 
			path = Messages.DEFAULT_ICON_20;
		return Activator.getDefault().getImageDescriptor(path);
	}

	@Override
	public EClass getModelType() {
		return this.modelType;
	}

	@Override
	public Image getSmallImage() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = Messages.DATA_INPUT_ICON_16;
		else if (modelType.getName().equals("DataOutputUI"))
			path = Messages.DATA_OUTPUT_ICON_16;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = Messages.DATA_SELECTION_ICON_16;
		else if (modelType.getName().equals("OnUserEvent"))
			path = Messages.ON_USER_EVENT_ICON_16;
		else if (modelType.getName().equals("ScopeUI"))
			path = Messages.SCOPE_UI_ICON_16;
		else if (modelType.getName().equals("PickUI"))
			path = Messages.PICK_UI_ICON_16;
		else 
			path = Messages.DEFAULT_ICON_16;
		return Activator.getDefault().getImageRegistry().get(path);
	}

	@Override
	public ImageDescriptor getSmallImageDescriptor() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = Messages.DATA_INPUT_ICON_16;
		else if (modelType.getName().equals("DataOutputUI"))
			path = Messages.DATA_OUTPUT_ICON_16;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = Messages.DATA_SELECTION_ICON_16;
		else if (modelType.getName().equals("OnUserEvent"))
			path = Messages.ON_USER_EVENT_ICON_16;
		else if (modelType.getName().equals("ScopeUI"))
			path = Messages.SCOPE_UI_ICON_16;
		else if (modelType.getName().equals("PickUI"))
			path = Messages.PICK_UI_ICON_16;
		else 
			path = Messages.DEFAULT_ICON_16;
		return Activator.getDefault().getImageDescriptor(path);
	}

	@Override
	public String getTypeLabel() {
		return getModelType().getName();
	}

	@Override
	public EClass[] getClassArray() {
		return this.classArray;
	}

	@Override
	public void setModelType(EClass modelType) {
		this.modelType = modelType;
	}

}
