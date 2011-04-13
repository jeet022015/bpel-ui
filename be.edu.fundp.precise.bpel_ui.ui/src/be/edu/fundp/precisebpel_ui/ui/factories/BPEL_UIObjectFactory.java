package be.edu.fundp.precisebpel_ui.ui.factories;

import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.bpel.ui.factories.IExtensionUIObjectFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import be.edu.fundp.precise.bpel_ui.model.ModelPackage;
import be.edu.fundp.precisebpel_ui.ui.Activator;
import be.edu.fundp.precisebpel_ui.ui.BPEL_UIConstants;

public class BPEL_UIObjectFactory extends AbstractUIObjectFactory implements IExtensionUIObjectFactory {

	private EClass modelType;
	private EClass[] classArray = { ModelPackage.eINSTANCE.getPickUI(), ModelPackage.eINSTANCE.getOnUserEvent(),
			ModelPackage.eINSTANCE.getDataInputUI(), ModelPackage.eINSTANCE.getDataOutputUI(),
			ModelPackage.eINSTANCE.getDataSelectionUI(), ModelPackage.eINSTANCE.getScopeUI(),
			ModelPackage.eINSTANCE.getEventHandlerUI(), ModelPackage.eINSTANCE.getUserRole()};

	public BPEL_UIObjectFactory(EClass modelType) {
		super();
		this.modelType = modelType;
	}
	
	public BPEL_UIObjectFactory() {
		super();
	}
	
	@Override
	public Image getLargeImage() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = BPEL_UIConstants.DATA_INPUT_ICON_20;
		else if (modelType.getName().equals("DataOutputUI"))
			path = BPEL_UIConstants.DATA_OUTPUT_ICON_20;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = BPEL_UIConstants.DATA_SELECTION_ICON_20;
		else if (modelType.getName().equals("OnUserEvent"))
			path = BPEL_UIConstants.ON_USER_EVENT_ICON_20;
		else if (modelType.getName().equals("ScopeUI"))
			path = BPEL_UIConstants.SCOPE_UI_ICON_20;
		else if (modelType.getName().equals("PickUI"))
			path = BPEL_UIConstants.PICK_UI_ICON_20;
		else 
			path = BPEL_UIConstants.DEFAULT_ICON_20;
		return Activator.getDefault().getImageRegistry().get(path);
	}

	@Override
	public ImageDescriptor getLargeImageDescriptor() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = BPEL_UIConstants.DATA_INPUT_ICON_20;
		else if (modelType.getName().equals("DataOutputUI"))
			path = BPEL_UIConstants.DATA_OUTPUT_ICON_20;
		else if (modelType.getName().equals("DataSelectiontUI"))
			path = BPEL_UIConstants.DATA_SELECTION_ICON_20;
		else if (modelType.getName().equals("OnUserEvent"))
			path = BPEL_UIConstants.ON_USER_EVENT_ICON_20;
		else if (modelType.getName().equals("ScopeUI"))
			path = BPEL_UIConstants.SCOPE_UI_ICON_20;
		else if (modelType.getName().equals("PickUI"))
			path = BPEL_UIConstants.PICK_UI_ICON_20;
		else 
			path = BPEL_UIConstants.DEFAULT_ICON_20;
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
			path = BPEL_UIConstants.DATA_INPUT_ICON_16;
		else if (modelType.getName().equals("DataOutputUI"))
			path = BPEL_UIConstants.DATA_OUTPUT_ICON_16;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = BPEL_UIConstants.DATA_SELECTION_ICON_16;
		else if (modelType.getName().equals("OnUserEvent"))
			path = BPEL_UIConstants.ON_USER_EVENT_ICON_16;
		else if (modelType.getName().equals("ScopeUI"))
			path = BPEL_UIConstants.SCOPE_UI_ICON_16;
		else if (modelType.getName().equals("PickUI"))
			path = BPEL_UIConstants.PICK_UI_ICON_16;
		else 
			path = BPEL_UIConstants.DEFAULT_ICON_16;
		return Activator.getDefault().getImageRegistry().get(path);
	}

	@Override
	public ImageDescriptor getSmallImageDescriptor() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = BPEL_UIConstants.DATA_INPUT_ICON_16;
		else if (modelType.getName().equals("DataOutputUI"))
			path = BPEL_UIConstants.DATA_OUTPUT_ICON_16;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = BPEL_UIConstants.DATA_SELECTION_ICON_16;
		else if (modelType.getName().equals("OnUserEvent"))
			path = BPEL_UIConstants.ON_USER_EVENT_ICON_16;
		else if (modelType.getName().equals("ScopeUI"))
			path = BPEL_UIConstants.SCOPE_UI_ICON_16;
		else if (modelType.getName().equals("PickUI"))
			path = BPEL_UIConstants.PICK_UI_ICON_16;
		else 
			path = BPEL_UIConstants.DEFAULT_ICON_16;
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
