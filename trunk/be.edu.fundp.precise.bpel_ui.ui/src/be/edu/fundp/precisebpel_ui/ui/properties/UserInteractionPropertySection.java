package be.edu.fundp.precisebpel_ui.ui.properties;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import be.edu.fundp.precise.bpel_ui.model.DataInputUI;
import be.edu.fundp.precise.bpel_ui.model.ModelFactory;
import be.edu.fundp.precise.bpel_ui.model.UserInteraction;
import be.edu.fundp.precise.bpel_ui.model.UserRole;
import be.edu.fundp.precisebpel_ui.ui.dialogs.NumberInputDialog;

/*
 * Bug 120110
 * This class implements the detail property tab for the "elemental" extension activity.
 * This property detail tab allows the user to select a variable in scope for this activity.
 * 
 * Note that validation of this activity is not yet implemented.
 */
public class UserInteractionPropertySection extends BPELPropertySection {

	protected Composite parentComposite;
	//protected Label mainLabel
	protected Section mainLabel;
	protected Button variableBrowseButton;


	@Override
	protected MultiObjectAdapter[] createAdapters() {
		MultiObjectAdapter[] l = super.createAdapters();
		MultiObjectAdapter[] l2 = new MultiObjectAdapter[l.length+1];
		for (int i = 0; i < l.length; i++) {
			l2[i] = l[i]; 
		}
		l2[l.length] = new BatchedMultiObjectAdapter() {
				
				@Override
				public void notify (Notification n) {
				}
				
				@Override
				public void finish() {
					updateVariableWidgets();
				}
		};
		return l2;
	}

	@Override
	protected void createClient(Composite parent) {
		FlatFormData data;

		final Composite composite = parentComposite = createFlatFormComposite( createFlatFormComposite(parent) );
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(composite, IDetailsAreaConstants.VSPACE);
		composite.setLayoutData(data);

		Label variableLabel = fWidgetFactory.createLabel(composite, "Roles:"); 
		//mainLabel = fWidgetFactory.createScrolledForm(parent)Label(composite, "", SWT.NONE); //$NON-NLS-1$
		
		mainLabel = fWidgetFactory.createSection(composite, SWT.NONE); //$NON-NLS-1$
		
		mainLabel.setText("Section title");
		mainLabel.setDescription("This is the description that goes "+
				      "below the title");
				 Composite sectionClient = fWidgetFactory.createComposite(mainLabel);
				 sectionClient.setLayout(new GridLayout());
				 Button button1 = fWidgetFactory.createButton(sectionClient, "Radio 1", SWT.RADIO);
				 Button button2 = fWidgetFactory.createButton(sectionClient, "Radio 2", SWT.RADIO);
				 mainLabel.setClient(sectionClient);
		
		variableBrowseButton = fWidgetFactory.createButton(composite, "Create Role", SWT.PUSH); 

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(variableLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(variableBrowseButton, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 0);
		data.height = FigureUtilities.getTextExtents(variableBrowseButton.getText(), variableBrowseButton.getFont()).height + 4;
		mainLabel.setLayoutData(data);

		data = new FlatFormData();
		data.top = new FlatFormAttachment(mainLabel, 0, SWT.TOP);
		data.bottom = new FlatFormAttachment(mainLabel, 2, SWT.BOTTOM);
		data.left = new FlatFormAttachment(50, -BPELUtil.calculateButtonWidth(variableBrowseButton,
				SHORT_BUTTON_WIDTH)-IDetailsAreaConstants.CENTER_SPACE);
		data.right = new FlatFormAttachment(50, -IDetailsAreaConstants.CENTER_SPACE);
		variableBrowseButton.setLayoutData(data);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(mainLabel, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(mainLabel, 0, SWT.CENTER);
		variableLabel.setLayoutData(data);
		
		variableBrowseButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				Shell shell = composite.getShell();
				//I need to create a command
				//NumberInputDialog dialog = new NumberInputDialog(shell);
			   
				EObject model = getUserInteraction();
				NumberInputDialog dialog = new NumberInputDialog(shell, model, 
						ModelHelper.getVariableType(model, ModelHelper.OUTGOING));
				 String id = dialog.open();
				 UserRole l = ModelFactory.eINSTANCE.createUserRole();
				 l.setId(id);
				 if (model instanceof UserInteraction){
					 UserInteraction inter = (UserInteraction)model;
					 inter.getRole().add(l);
				 }
//				dialog.setTitle(Messages.FaultThrowNameSection_Select_Fault_Variable_2); 
//				if (dialog.open() == Window.OK) {
//					Variable variable = dialog.getVariable();
//					Command command = new SetVariableCommand(model, variable);
//					getCommandFramework().execute(wrapInShowContextCommand(command));
//				}
			}
			public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
		});
	}
	
	public void updateVariableWidgets() {
		String label = "";
		EObject model = getUserInteraction();
		if (model instanceof UserInteraction){
			 UserInteraction inter = (UserInteraction)model;
			 EList<UserRole> l = inter.getRole();
			 for (UserRole userRole : l) {
				label += " - "+userRole.getId();
			 }
			 mainLabel.setText(label);
		 } else {
			 mainLabel.setText("teste");
		 }
	}
	
	@Override
	protected void basicSetInput(EObject newInput) {
		if ( newInput instanceof UserInteraction) {
			super.basicSetInput(newInput);
			updateVariableWidgets();
		}
	}
}
