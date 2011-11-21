package be.ac.fundp.precise.ui_bpel.ui.factories;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.bpel.ui.factories.IExtensionUIObjectFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import be.ac.fundp.precise.ui_bpel.ui.Activator;
import be.ac.fundp.precise.ui_bpel.ui.ExtensionSampleUIConstants;
import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;

public class ExtensionSampleUIObjectFactory extends AbstractUIObjectFactory implements IExtensionUIObjectFactory {

	private EClass modelType;
	private static int scopeCounter = 1;
	
	private EClass[] classArray = { ModelPackage.eINSTANCE.getDataInputUI(), 
			ModelPackage.eINSTANCE.getDataOutputUI(), ModelPackage.eINSTANCE.getDataSelectionUI(),
			ModelPackage.eINSTANCE.getDataItem(), ModelPackage.eINSTANCE.getPickUI(),
			ModelPackage.eINSTANCE.getOnUserEvent(), ModelPackage.eINSTANCE.getScopeUI(),
			ModelPackage.eINSTANCE.getEventHandlerUI(), ModelPackage.eINSTANCE.getUserRole(), 
			ModelPackage.eINSTANCE.getUserInteraction()};

	public ExtensionSampleUIObjectFactory(EClass modelType) {
		super();
		this.modelType = modelType;
	}
	
	public ExtensionSampleUIObjectFactory() {
		super();
	}
	

	@Override
	public Image getLargeImage() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = ExtensionSampleUIConstants.DATA_INPUT_ICON_20;
		else if (modelType.getName().equals("DataOutputUI"))
			path = ExtensionSampleUIConstants.DATA_OUTPUT_ICON_20;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = ExtensionSampleUIConstants.DATA_SELECTION_ICON_20;
		else if (modelType.getName().equals("OnUserEvent"))
			path = ExtensionSampleUIConstants.ON_USER_EVENT_ICON_20;
		else if (modelType.getName().equals("ScopeUI"))
			path = ExtensionSampleUIConstants.SCOPE_UI_ICON_20;
		else if (modelType.getName().equals("PickUI"))
			path = ExtensionSampleUIConstants.PICK_UI_ICON_20;
		else 
			path = ExtensionSampleUIConstants.DEFAULT_ICON_20;
		return Activator.getDefault().getImageRegistry().get(path);
	}

	@Override
	public ImageDescriptor getLargeImageDescriptor() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = ExtensionSampleUIConstants.DATA_INPUT_ICON_20;
		else if (modelType.getName().equals("DataOutputUI"))
			path = ExtensionSampleUIConstants.DATA_OUTPUT_ICON_20;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = ExtensionSampleUIConstants.DATA_SELECTION_ICON_20;
		else if (modelType.getName().equals("OnUserEvent"))
			path = ExtensionSampleUIConstants.ON_USER_EVENT_ICON_20;
		else if (modelType.getName().equals("ScopeUI"))
			path = ExtensionSampleUIConstants.SCOPE_UI_ICON_20;
		else if (modelType.getName().equals("PickUI"))
			path = ExtensionSampleUIConstants.PICK_UI_ICON_20;
		else 
			path = ExtensionSampleUIConstants.DEFAULT_ICON_20;
		return Activator.getDefault().getImageDescriptor(path);
	}

	@Override
	public Image getSmallImage() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = ExtensionSampleUIConstants.DATA_INPUT_ICON_16;
		else if (modelType.getName().equals("DataOutputUI"))
			path = ExtensionSampleUIConstants.DATA_OUTPUT_ICON_16;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = ExtensionSampleUIConstants.DATA_SELECTION_ICON_16;
		else if (modelType.getName().equals("OnUserEvent"))
			path = ExtensionSampleUIConstants.ON_USER_EVENT_ICON_16;
		else if (modelType.getName().equals("ScopeUI"))
			path = ExtensionSampleUIConstants.SCOPE_UI_ICON_16;
		else if (modelType.getName().equals("PickUI"))
			path = ExtensionSampleUIConstants.PICK_UI_ICON_16;
		else 
			path = ExtensionSampleUIConstants.DEFAULT_ICON_16;
		return Activator.getDefault().getImageRegistry().get(path);
	}

	@Override
	public ImageDescriptor getSmallImageDescriptor() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = ExtensionSampleUIConstants.DATA_INPUT_ICON_16;
		else if (modelType.getName().equals("DataOutputUI"))
			path = ExtensionSampleUIConstants.DATA_OUTPUT_ICON_16;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = ExtensionSampleUIConstants.DATA_SELECTION_ICON_16;
		else if (modelType.getName().equals("OnUserEvent"))
			path = ExtensionSampleUIConstants.ON_USER_EVENT_ICON_16;
		else if (modelType.getName().equals("ScopeUI"))
			path = ExtensionSampleUIConstants.SCOPE_UI_ICON_16;
		else if (modelType.getName().equals("PickUI"))
			path = ExtensionSampleUIConstants.PICK_UI_ICON_16;
		else 
			path = ExtensionSampleUIConstants.DEFAULT_ICON_16;
		return Activator.getDefault().getImageDescriptor(path);
	}

	@Override
	public EClass getModelType() {
		return this.modelType;
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

	/**
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#createInstance()
	 */
	@Override
	public EObject createInstance() {
		EObject result = super.createInstance();
		
	 if (result instanceof OnUserEvent) {
			/** Per bug# 133170 */
		 	OnUserEvent onAlarm = (OnUserEvent) result;
		 	Scope innerScope = BPELFactory.eINSTANCE.createScope();
		 	innerScope.setName("InnerScope"+scopeCounter);
			onAlarm.setActivity(innerScope);
		}

		return result;
	}
	
}
