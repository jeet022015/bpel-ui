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

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ExtensionSampleUIObject objects.
 */
public class ExtensionSampleUIObjectFactory extends AbstractUIObjectFactory implements IExtensionUIObjectFactory {

	/** The model type. */
	private EClass modelType;
	
	/** The scope counter. */
	private static int scopeCounter = 1;
	
	/** The class array. */
	private EClass[] classArray = { ModelPackage.eINSTANCE.getDataInputUI(), 
			ModelPackage.eINSTANCE.getDataOutputUI(), ModelPackage.eINSTANCE.getDataSelectionUI(),
			ModelPackage.eINSTANCE.getDataItem(), ModelPackage.eINSTANCE.getPickUI(),
			ModelPackage.eINSTANCE.getOnUserEvent(), ModelPackage.eINSTANCE.getScopeUI(),
			ModelPackage.eINSTANCE.getEventHandlerUI(), ModelPackage.eINSTANCE.getUserRole(), 
			ModelPackage.eINSTANCE.getUserInteraction()};

	/**
	 * Instantiates a new extension sample ui object factory.
	 *
	 * @param modelType the model type
	 */
	public ExtensionSampleUIObjectFactory(EClass modelType) {
		super();
		this.modelType = modelType;
	}
	
	/**
	 * Instantiates a new extension sample ui object factory.
	 */
	public ExtensionSampleUIObjectFactory() {
		super();
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getLargeImage()
	 */
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

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getLargeImageDescriptor()
	 */
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

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getSmallImage()
	 */
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

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getSmallImageDescriptor()
	 */
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

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getModelType()
	 */
	@Override
	public EClass getModelType() {
		return this.modelType;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getTypeLabel()
	 */
	@Override
	public String getTypeLabel() {
		return getModelType().getName();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.factories.IExtensionUIObjectFactory#getClassArray()
	 */
	@Override
	public EClass[] getClassArray() {
		return this.classArray;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.factories.IExtensionUIObjectFactory#setModelType(org.eclipse.emf.ecore.EClass)
	 */
	@Override
	public void setModelType(EClass modelType) {
		this.modelType = modelType;
	}

	/**
	 * Creates a new ExtensionSampleUIObject object.
	 *
	 * @return the e object
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
