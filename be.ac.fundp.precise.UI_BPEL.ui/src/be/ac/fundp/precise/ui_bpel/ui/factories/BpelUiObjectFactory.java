package be.ac.fundp.precise.ui_bpel.ui.factories;

import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.bpel.ui.factories.IExtensionUIObjectFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import be.ac.fundp.precise.ui_bpel.ui.Activator;
import be.ac.fundp.precise.ui_bpel.ui.util.BpelUiConstants;
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
		return Activator.getDefault().getImageRegistry().get(BpelUiConstants.DEFAULT_ICON_20);
	}

	@Override
	public ImageDescriptor getLargeImageDescriptor() {
		return Activator.getDefault().getImageDescriptor(BpelUiConstants.DEFAULT_ICON_20);
	}

	@Override
	public EClass getModelType() {
		return this.modelType;
	}

	@Override
	public Image getSmallImage() {
		return Activator.getDefault().getImageRegistry().get(BpelUiConstants.DEFAULT_ICON_16);
	}

	@Override
	public ImageDescriptor getSmallImageDescriptor() {
		return Activator.getDefault().getImageDescriptor(BpelUiConstants.DEFAULT_ICON_16);
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
