package be.ac.fundp.precise.ui_bpel.ui.properties;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.common.ui.flatui.FlatFormLayout;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.bpel.ui.properties.EditController;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import be.ac.fundp.precise.ui_bpel.ui.details.IntegerIValue;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;
import be.edu.fundp.precise.uibpel.model.ModelPackage;

// TODO: Auto-generated Javadoc
/*
 * Bug 120110
 * This class implements the detail property tab for the "elemental" extension activity.
 * This property detail tab allows the user to select a variable in scope for this activity.
 * 
 * Note that validation of this activity is not yet implemented.
 */
/**
 * The Class DataSelectionMinCardinalityPropertySection.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class DataSelectionMinCardinalityPropertySection  extends BPELPropertySection {
	
	/** The create instance button. */
	Text fCreateInstanceButton;	
	
	/** The crete instance controller. */
	EditController fCreteInstanceController ;


	/**
	 * Creates the change trackers.
	 */
	protected void createChangeTrackers() {	
		fCreteInstanceController = createEditController();
		fCreteInstanceController.setViewIValue(new IntegerIValue(fCreateInstanceButton));
		fCreteInstanceController.startListeningTo(fCreateInstanceButton);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#basicSetInput(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected void basicSetInput(EObject newInput) {

		super.basicSetInput(newInput);
		if (newInput instanceof DataSelectionUI) {
			fCreteInstanceController.setFeature(
					ModelPackage.eINSTANCE.getDataSelectionUI_MinCardinality());
			fCreteInstanceController.setInput(newInput);
		} else {
			fCreteInstanceController.setFeature( null );		
			fCreteInstanceController.setInput(newInput);
		}
	}

	/**
	 * Creates the create instance widgets.
	 *
	 * @param composite the composite
	 */
	protected void createCreateInstanceWidgets(Composite composite) {
		FlatFormData data;
		
		final Composite parent  = createFlatFormComposite( createFlatFormComposite(composite) );
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		data.right = new FlatFormAttachment(0, 500);
		data.height = 500;
		parent.setLayoutData(data);
		
		fCreateInstanceButton = fWidgetFactory.createText(parent, "");
		Label variableLabel = fWidgetFactory.createLabel(parent,
				//Messages.UIBPELEditor_Property_Min_Cardinality);
				"MinCardinality:");
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 100);
		data.top = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(0, 150);
		fCreateInstanceButton.setLayoutData(data);
		//fCreateInstanceButton.setText(Integer.toString(model.getMaxCardinality()));
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(0, 500);
		variableLabel.setLayoutData(data);
		
		
		//fCreateInstanceButton.setLayoutData(data);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#createClient(org.eclipse.swt.widgets.Composite)
	 */
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
	 * Gets the user context.
	 *
	 * @return the user context
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@Override
	public Object getUserContext() {
		return null;
	}
	
	/**
	 * Restore user context.
	 *
	 * @param userContext the user context
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@Override
	public void restoreUserContext(Object userContext) {
		fCreateInstanceButton.setFocus();
	}
	
	/**
	 * Should use extra space.
	 *
	 * @return true, if successful
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
	 */
	@Override
	public boolean shouldUseExtraSpace () {
		return false;
	}
	
	/**
	 * Gets the minimum height.
	 *
	 * @return the minimum height
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#getMinimumHeight()
	 */
	@Override
	public int getMinimumHeight () {
		return 40;
	}

}