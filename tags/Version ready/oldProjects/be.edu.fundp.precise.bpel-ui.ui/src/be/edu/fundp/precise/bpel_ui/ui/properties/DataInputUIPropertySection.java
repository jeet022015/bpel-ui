package be.edu.fundp.precise.bpel_ui.ui.properties;

import model.DataInputUI;
import model.ModelPackage;

import org.eclipse.bpel.common.ui.details.ButtonIValue;
import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.common.ui.flatui.FlatFormLayout;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.bpel.ui.properties.EditController;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

import be.edu.fundp.precise.bpel_ui.ui.Messages;

public class DataInputUIPropertySection  extends BPELPropertySection {
	
	Button fCreateInstanceButton;	
	EditController fCreteInstanceController ;


	protected void createChangeTrackers() {	
		fCreteInstanceController = createEditController();
		fCreteInstanceController.setViewIValue(new ButtonIValue(fCreateInstanceButton));
		fCreteInstanceController.startListeningTo(fCreateInstanceButton);
	}

	@Override
	protected void basicSetInput(EObject newInput) {

		super.basicSetInput(newInput);
		
		if (newInput instanceof DataInputUI) {
			fCreteInstanceController.setFeature(ModelPackage.eINSTANCE.getDataInputUI_UserValidation());
			fCreteInstanceController.setInput(newInput);
		} else {
			fCreteInstanceController.setFeature( null );		
			fCreteInstanceController.setInput(newInput);
		}
	}

	protected void createCreateInstanceWidgets(Composite composite) {
		FlatFormData data;
		
		Composite parent = fWidgetFactory.createComposite(composite);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		
		parent.setLayoutData(data);
		parent.setLayout(new FillLayout());

		fCreateInstanceButton = fWidgetFactory.createButton(parent, Messages.Must_the_user_evaluate, SWT.CHECK); 
	}
	
	@Override
	protected void createClient(Composite parent) {
		Composite composite = createFlatFormComposite(parent);
		// HACK: the checkbox by itself looks cramped..give it a little extra space
		((FlatFormLayout)composite.getLayout()).marginHeight += 3;

		createCreateInstanceWidgets(composite);
		createChangeTrackers();

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			composite, IHelpContextIds.PROPERTY_PAGE_PICK_IMPLEMENTATION);
	}


	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@Override
	public Object getUserContext() {
		return null;
	}
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@Override
	public void restoreUserContext(Object userContext) {
		fCreateInstanceButton.setFocus();
		
	}
	
	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
	 */
	@Override
	public boolean shouldUseExtraSpace () {
		return false;
	}
	
	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#getMinimumHeight()
	 */
	@Override
	public int getMinimumHeight () {
		return 40;
	}

}
