package be.edu.fundp.precisebpel_ui.ui.factories;

import org.eclipse.bpel.ui.factories.IExtensionUIObjectFactory;
import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
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
		return Activator.getDefault().getImageRegistry().get(BPEL_UIConstants.DEFAULT_ICON_20);
	}

	@Override
	public ImageDescriptor getLargeImageDescriptor() {
		return Activator.getDefault().getImageDescriptor(BPEL_UIConstants.DEFAULT_ICON_20);
	}

	@Override
	public EClass getModelType() {
		return this.modelType;
	}

	@Override
	public Image getSmallImage() {
		return Activator.getDefault().getImageRegistry().get(BPEL_UIConstants.DEFAULT_ICON_16);
	}

	@Override
	public ImageDescriptor getSmallImageDescriptor() {
		return Activator.getDefault().getImageDescriptor(BPEL_UIConstants.DEFAULT_ICON_16);
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
