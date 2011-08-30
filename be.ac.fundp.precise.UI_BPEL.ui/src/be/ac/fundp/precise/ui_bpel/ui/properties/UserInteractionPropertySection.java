package be.ac.fundp.precise.ui_bpel.ui.properties;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.common.ui.flatui.FlatFormLayout;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Section;

import be.ac.fundp.precise.ui_bpel.ui.properties.commands.AddDataItemCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.commands.RemoveDataItemCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.dialogs.NumberInputDialog;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataType;
import be.edu.fundp.precise.uibpel.model.ModelFactory;
import be.edu.fundp.precise.uibpel.model.UserInteraction;

/*
 * Bug 120110
 * This class implements the detail property tab for the "elemental" extension activity.
 * This property detail tab allows the user to select a variable in scope for this activity.
 * 
 * Note that validation of this activity is not yet implemented.
 */
public class UserInteractionPropertySection  extends BPELPropertySection {
		
	private Section mainLabel;
	private Button variableBrowseButton;
	private Composite sectionClient;
	private Button deleteRoleButton;
	private DataItem currentDataItem;
	
	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
			/* model object */
			new BatchedMultiObjectAdapter() {
				
				@Override
				public void notify (Notification n) {
				}
				
				@Override
				public void finish() {
					updateVariableWidgets();
				}
			}
		};
	}

	@Override
	protected void basicSetInput(EObject newInput) {

		//super.basicSetInput(newInput);
		if (newInput instanceof UserInteraction) {
			super.basicSetInput(newInput);
			updateVariableWidgets();
		}
	}

	private void updateVariableWidgets() {
		UserInteraction userActivity = getActivity();
		if(userActivity != null){
			for (final DataItem dataItem : userActivity.getData()) {
				Button button4 = fWidgetFactory.createButton(sectionClient,
					dataItem.getDescription(), SWT.RADIO);
				button4.addSelectionListener(new SelectionListener() {
					public void widgetSelected(SelectionEvent e) {
						currentDataItem = dataItem;
					}

					public void widgetDefaultSelected(SelectionEvent e) {
						widgetSelected(e);
					}
				});
				
			}
		}
	}

	protected void createCreateInstanceWidgets(Composite composite) {
		FlatFormData data;
		
		final Composite parent = createFlatFormComposite(createFlatFormComposite(composite));
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(0, 0);
		parent.setLayoutData(data);
		
		mainLabel = fWidgetFactory.createSection(composite, SWT.NONE); //$NON-NLS-1$

		mainLabel.setText("Data:");
		//g = fWidgetFactory.createGroup(composite, "group");
		//Button button2 = fWidgetFactory.createButton(g, "", SWT.RADIO);
		sectionClient = fWidgetFactory.createComposite(mainLabel);
		sectionClient.setLayout(new GridLayout());
		mainLabel.setClient(sectionClient);
		
		variableBrowseButton = fWidgetFactory.createButton(composite,
				"Create Data", SWT.PUSH);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(10, 0);
		data.top = new FlatFormAttachment(0, 0);
		data.height = FigureUtilities.getTextExtents(
				variableBrowseButton.getText(), variableBrowseButton.getFont()).height + 4;
		mainLabel.setLayoutData(data);

		data = new FlatFormData();
		data.top = new FlatFormAttachment(mainLabel, 0, SWT.TOP);
		data.left = new FlatFormAttachment(50, -BPELUtil.calculateButtonWidth(
				variableBrowseButton, SHORT_BUTTON_WIDTH)
				- IDetailsAreaConstants.CENTER_SPACE);
		data.right = new FlatFormAttachment(50,
				-IDetailsAreaConstants.CENTER_SPACE);
		variableBrowseButton.setLayoutData(data);
		
		variableBrowseButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				Shell shell = parent.getShell();
				// I need to create a command
				NumberInputDialog dialog = new NumberInputDialog(shell);
				String[] id = dialog.open();
				
				if (id[0] != null){
					UserInteraction userActivity = getActivity();
					DataItem l = ModelFactory.eINSTANCE.createDataItem();
					l.setDescription(id[0]);
					l.setType(DataType.get(id[1]));
					Command command = new AddDataItemCommand(userActivity, l);
					getCommandFramework().execute(wrapInShowContextCommand(command));
					refreshAdapters();
					//updateVariableWidgets();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		
		deleteRoleButton = fWidgetFactory.createButton(composite,
				"Delete Data", SWT.PUSH);
		data = new FlatFormData();
		data.top = new FlatFormAttachment(mainLabel, 25, SWT.TOP);
		// data.bottom = new FlatFormAttachment(mainLabel, 2, SWT.BOTTOM);
		data.left = new FlatFormAttachment(50, -BPELUtil.calculateButtonWidth(
				deleteRoleButton, SHORT_BUTTON_WIDTH)
				- IDetailsAreaConstants.CENTER_SPACE);
		data.right = new FlatFormAttachment(50,
				-IDetailsAreaConstants.CENTER_SPACE);
		deleteRoleButton.setLayoutData(data);
		
		deleteRoleButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				getCommandFramework().execute(
						wrapInShowContextCommand(new RemoveDataItemCommand(
								getActivity(), currentDataItem)));
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
	}
	
	@Override
	protected void createClient(Composite parent) {
		Composite composite = createFlatFormComposite(parent);
		// HACK: the checkbox by itself looks cramped..give it a little extra space
		((FlatFormLayout)composite.getLayout()).marginHeight += 3;

		createCreateInstanceWidgets(composite);
		//createChangeTrackers();

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			composite, IHelpContextIds.PROPERTY_PAGE_PICK_IMPLEMENTATION);
		updateVariableWidgets();
	}

	protected UserInteraction getActivity() {
		UserInteraction activity = (UserInteraction)getInput();
		return activity;
	}

}