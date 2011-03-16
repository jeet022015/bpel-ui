package org.eclipse.bpel.extensionssample.ui.factories;

import org.eclipse.bpel.extensionssample.ui.Activator;
import org.eclipse.bpel.extensionssample.ui.ExtensionSampleUIConstants;
import org.eclipse.bpel.ui.factories.IExtensionUIObjectFactory;
import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import be.edu.fundp.bpel_ui.model.ModelPackage;

public class ExtensionSampleUIObjectFactory extends AbstractUIObjectFactory implements IExtensionUIObjectFactory {

	private EClass modelType;
	private EClass[] classArray = { ModelPackage.eINSTANCE.getNewPick(), ModelPackage.eINSTANCE.getOnUserEvent()};

	public ExtensionSampleUIObjectFactory(EClass modelType) {
		super();
		this.modelType = modelType;
	}
	
	public ExtensionSampleUIObjectFactory() {
		super();
	}
	
	@Override
	public Image getLargeImage() {
		return Activator.getDefault().getImageRegistry().get(ExtensionSampleUIConstants.DEFAULT_ICON_20);
	}

	@Override
	public ImageDescriptor getLargeImageDescriptor() {
		return Activator.getDefault().getImageDescriptor(ExtensionSampleUIConstants.DEFAULT_ICON_20);
	}

	@Override
	public EClass getModelType() {
		return this.modelType;
	}

	@Override
	public Image getSmallImage() {
		return Activator.getDefault().getImageRegistry().get(ExtensionSampleUIConstants.DEFAULT_ICON_16);
	}

	@Override
	public ImageDescriptor getSmallImageDescriptor() {
		return Activator.getDefault().getImageDescriptor(ExtensionSampleUIConstants.DEFAULT_ICON_16);
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
