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
import be.ac.fundp.precise.ui_bpel.ui.UI_BPEL_Constants;
import be.edu.fundp.precise.uibpel.model.ModelPackage;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;

/**
 * Factory that knows how to create one conceptual type of UI object (and only
 * the one type of object). The objects created must be EMF model objects (i.e.
 * instances of EObject) and the types that represent them must be EMF classes
 * (i.e. instances of EClass).
 * 
 * This corresponds to items that you can create with the palette of a
 * DetailsEditor.
 * 
 * NOTE: the object returned by getNewEObject() is NOT necessarily an instance
 * of the same EClass as getEClass returns!
 * 
 * Concrete subclasses must still specify where to get icons from, and what the
 * human-readable type label of the factory should be.
 */
public class UI_BPEL_ObjectFactory extends AbstractUIObjectFactory implements
		IExtensionUIObjectFactory {

	/** The current EMF model object */
	private EClass modelType;

	/** The counter to generate a distinct name to Scopes within OnUserEvent. */
	private static int scopeCounter = 1;

	/** The mapping array the to the EMF model objects. */
	private EClass[] classArray = { ModelPackage.eINSTANCE.getDataInputUI(),
			ModelPackage.eINSTANCE.getDataOutputUI(),
			ModelPackage.eINSTANCE.getDataSelectionUI(),
			ModelPackage.eINSTANCE.getDataItem(),
			ModelPackage.eINSTANCE.getPickUI(),
			ModelPackage.eINSTANCE.getOnUserEvent(),
			ModelPackage.eINSTANCE.getScopeUI(),
			ModelPackage.eINSTANCE.getEventHandlerUI(),
			ModelPackage.eINSTANCE.getUserRole(),
			ModelPackage.eINSTANCE.getUserInteraction() };

	/**
	 * Instantiates a new extension sample ui object factory.
	 * 
	 * @param modelType
	 *            the model type
	 */
	public UI_BPEL_ObjectFactory(EClass modelType) {
		super();
		this.modelType = modelType;
	}

	/**
	 * This method instantiates a new UI-BPEL object factory.
	 */
	public UI_BPEL_ObjectFactory() {
		super();
	}

	// TODO Create constants for these values
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getLargeImage()
	 */
	@Override
	public Image getLargeImage() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = UI_BPEL_Constants.DATA_INPUT_ICON_20;
		else if (modelType.getName().equals("DataOutputUI"))
			path = UI_BPEL_Constants.DATA_OUTPUT_ICON_20;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = UI_BPEL_Constants.DATA_SELECTION_ICON_20;
		else if (modelType.getName().equals("OnUserEvent"))
			path = UI_BPEL_Constants.ON_USER_EVENT_ICON_20;
		else if (modelType.getName().equals("ScopeUI"))
			path = UI_BPEL_Constants.SCOPE_UI_ICON_20;
		else if (modelType.getName().equals("PickUI"))
			path = UI_BPEL_Constants.PICK_UI_ICON_20;
		else
			path = UI_BPEL_Constants.DEFAULT_ICON_20;
		return Activator.getDefault().getImageRegistry().get(path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getLargeImageDescriptor
	 * ()
	 */
	@Override
	public ImageDescriptor getLargeImageDescriptor() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = UI_BPEL_Constants.DATA_INPUT_ICON_20;
		else if (modelType.getName().equals("DataOutputUI"))
			path = UI_BPEL_Constants.DATA_OUTPUT_ICON_20;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = UI_BPEL_Constants.DATA_SELECTION_ICON_20;
		else if (modelType.getName().equals("OnUserEvent"))
			path = UI_BPEL_Constants.ON_USER_EVENT_ICON_20;
		else if (modelType.getName().equals("ScopeUI"))
			path = UI_BPEL_Constants.SCOPE_UI_ICON_20;
		else if (modelType.getName().equals("PickUI"))
			path = UI_BPEL_Constants.PICK_UI_ICON_20;
		else
			path = UI_BPEL_Constants.DEFAULT_ICON_20;
		return Activator.getDefault().getImageDescriptor(path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getSmallImage()
	 */
	@Override
	public Image getSmallImage() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = UI_BPEL_Constants.DATA_INPUT_ICON_16;
		else if (modelType.getName().equals("DataOutputUI"))
			path = UI_BPEL_Constants.DATA_OUTPUT_ICON_16;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = UI_BPEL_Constants.DATA_SELECTION_ICON_16;
		else if (modelType.getName().equals("OnUserEvent"))
			path = UI_BPEL_Constants.ON_USER_EVENT_ICON_16;
		else if (modelType.getName().equals("ScopeUI"))
			path = UI_BPEL_Constants.SCOPE_UI_ICON_16;
		else if (modelType.getName().equals("PickUI"))
			path = UI_BPEL_Constants.PICK_UI_ICON_16;
		else
			path = UI_BPEL_Constants.DEFAULT_ICON_16;
		return Activator.getDefault().getImageRegistry().get(path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getSmallImageDescriptor
	 * ()
	 */
	@Override
	public ImageDescriptor getSmallImageDescriptor() {
		String path = "";
		if (modelType.getName().equals("DataInputUI"))
			path = UI_BPEL_Constants.DATA_INPUT_ICON_16;
		else if (modelType.getName().equals("DataOutputUI"))
			path = UI_BPEL_Constants.DATA_OUTPUT_ICON_16;
		else if (modelType.getName().equals("DataSelectionUI"))
			path = UI_BPEL_Constants.DATA_SELECTION_ICON_16;
		else if (modelType.getName().equals("OnUserEvent"))
			path = UI_BPEL_Constants.ON_USER_EVENT_ICON_16;
		else if (modelType.getName().equals("ScopeUI"))
			path = UI_BPEL_Constants.SCOPE_UI_ICON_16;
		else if (modelType.getName().equals("PickUI"))
			path = UI_BPEL_Constants.PICK_UI_ICON_16;
		else
			path = UI_BPEL_Constants.DEFAULT_ICON_16;
		return Activator.getDefault().getImageDescriptor(path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getModelType()
	 */
	@Override
	public EClass getModelType() {
		return this.modelType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getTypeLabel()
	 */
	@Override
	public String getTypeLabel() {
		return getModelType().getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.bpel.ui.factories.IExtensionUIObjectFactory#getClassArray()
	 */
	@Override
	public EClass[] getClassArray() {
		return this.classArray;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.bpel.ui.factories.IExtensionUIObjectFactory#setModelType(
	 * org.eclipse.emf.ecore.EClass)
	 */
	@Override
	public void setModelType(EClass modelType) {
		this.modelType = modelType;
	}

	/**
	 * Creates a new EMF model objects corresponding to the current EMF class.
	 * 
	 * @return the new EMF model object
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#createInstance()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EObject createInstance() {
		EObject result = super.createInstance();

		if (result instanceof OnUserEvent) {
			OnUserEvent onUserEvent = (OnUserEvent) result;
			Scope innerScope = BPELFactory.eINSTANCE.createScope();
			innerScope.setName("InnerScope" + scopeCounter);
			onUserEvent.setActivity(innerScope);
		}

		return result;
	}

}
