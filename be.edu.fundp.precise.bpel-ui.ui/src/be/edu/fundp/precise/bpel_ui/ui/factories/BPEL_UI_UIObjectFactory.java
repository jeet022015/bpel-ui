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
	private EClass[] classArray = { ModelPackage.eINSTANCE.getDataInputUI()};

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
		return Activator.getDefault().getImageDescriptor(ExtensionSampleUIConstants.DEFAULT_ICON_16);
	}

	@Override
	public ImageDescriptor getLargeImageDescriptor() {
		return Activator.getDefault().getImageDescriptor(ExtensionSampleUIConstants.DEFAULT_ICON_20);
	}

	@Override
	public Image getSmallImage() {
		return Activator.getDefault().getImageRegistry().get(ExtensionSampleUIConstants.DEFAULT_ICON_16);
	}

	@Override
	public Image getLargeImage() {
		return Activator.getDefault().getImageRegistry().get(ExtensionSampleUIConstants.DEFAULT_ICON_20);
	}

	@Override
	public String getTypeLabel() {
		return getModelType().getName();
	}

}
