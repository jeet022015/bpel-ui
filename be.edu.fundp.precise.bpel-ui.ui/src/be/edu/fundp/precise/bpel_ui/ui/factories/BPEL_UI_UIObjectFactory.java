package be.edu.fundp.precise.bpel_ui.ui.factories;
import model.ModelPackage;

import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.bpel.ui.factories.IExtensionUIObjectFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import be.edu.fundp.precise.bpel_ui.ui.Activator;
import be.edu.fundp.precise.bpel_ui.ui.ExtensionSampleUIConstants;

public class BPEL_UI_UIObjectFactory extends AbstractUIObjectFactory implements IExtensionUIObjectFactory{

	private EClass modelType;
	private EClass[] classArray = { ModelPackage.eINSTANCE.getDataInputUI(), ModelPackage.eINSTANCE.getDataOutputUI(),
			ModelPackage.eINSTANCE.getDataSelectionUI()};

	public BPEL_UI_UIObjectFactory(EClass modelType) {
		super();
		this.modelType = modelType;
	}
	
	public BPEL_UI_UIObjectFactory() {
		super();
	}
	
	public EClass[] getClassArray() {
		return classArray;
	}

	public void setModelType(EClass modelType) {
		this.modelType = modelType;
	}

	@Override
	public EClass getModelType() {
		return this.modelType;
	}

	@Override
	public ImageDescriptor getSmallImageDescriptor() {
		String iconReference = ExtensionSampleUIConstants.DEFAULT_ICON_16;
		if (modelType.getName().equals("DataInputUI"))
			iconReference = ExtensionSampleUIConstants.DATAINPUT_ICON_16;
		
		if (modelType.getName().equals("DataOutputUI"))
			iconReference = ExtensionSampleUIConstants.DATAOUTPUT_ICON_16;
		
		return Activator.getDefault().getImageDescriptor(iconReference);
	}

	@Override
	public ImageDescriptor getLargeImageDescriptor() {
		String iconReference = ExtensionSampleUIConstants.DEFAULT_ICON_20;
		if (modelType.getName().equals("DataInputUI"))
			iconReference = ExtensionSampleUIConstants.DATAINPUT_ICON_20;
		
		if (modelType.getName().equals("DataOutputUI"))
			iconReference = ExtensionSampleUIConstants.DATAOUTPUT_ICON_20;
		return Activator.getDefault().getImageDescriptor(iconReference);
	}

	@Override
	public Image getSmallImage() {
		String iconReference = ExtensionSampleUIConstants.DEFAULT_ICON_16;
		if (modelType.getName().equals("DataInputUI"))
			iconReference = ExtensionSampleUIConstants.DATAINPUT_ICON_16;
		
		if (modelType.getName().equals("DataOutputUI"))
			iconReference = ExtensionSampleUIConstants.DATAOUTPUT_ICON_16;
		return Activator.getDefault().getImageRegistry().get(iconReference);
	}

	@Override
	public Image getLargeImage() {
		String iconReference = ExtensionSampleUIConstants.DEFAULT_ICON_20;
		if (modelType.getName().equals("DataInputUI"))
			iconReference = ExtensionSampleUIConstants.DATAINPUT_ICON_20;
		
		if (modelType.getName().equals("DataOutputUI"))
			iconReference = ExtensionSampleUIConstants.DATAOUTPUT_ICON_20;
		return Activator.getDefault().getImageRegistry().get(iconReference);
	}

	@Override
	public String getTypeLabel() {
		return getModelType().getName();
	}

}
