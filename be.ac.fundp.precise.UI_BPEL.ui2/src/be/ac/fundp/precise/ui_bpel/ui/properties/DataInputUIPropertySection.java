package be.ac.fundp.precise.ui_bpel.ui.properties;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.ui.commands.AddVariableCommand;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.ModelHelper;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.Section;

import be.ac.fundp.precise.ui_bpel.ui.properties.commands.AddInputDataItemCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.commands.RemoveInputDataItemCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.commands.RemoveVariableCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.dialogs.DataItemDialog;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;

/*
 * Bug 120110
 * This class implements the detail property tab for the "elemental" extension activity.
 * This property detail tab allows the user to select a variable in scope for this activity.
 * 
 * Note that validation of this activity is not yet implemented.
 */
public class DataInputUIPropertySection extends BPELPropertySection {

	protected Composite parentComposite;
	protected Label variableName;
	protected Button variableBrowseButton;
	private Section mainLabel;
	private Composite sectionClient;
	private Button deleteRoleButton;
	private DataItem currentDataItem;

	private DataInputUI getActivity() {
		return (DataInputUI)getInput();
	}

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
	protected void createClient(Composite parent) {
		FlatFormData data;

		final Composite composite = parentComposite = createFlatFormComposite( 
				createFlatFormComposite(parent) );
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(composite, IDetailsAreaConstants.VSPACE);
		composite.setLayoutData(data);
		
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
				Shell shell = composite.getShell();
				// I need to create a command
				DataItemDialog dialog = new DataItemDialog(shell);
				DataItem id = dialog.open();
				
				if (id != null){
					DataInputUI userActivity = getActivity();
					
					CompoundCommand cmd = new CompoundCommand();
					Command command = new AddInputDataItemCommand(userActivity, id);
					Command command2 = new AddVariableCommand(userActivity, id.getVariable());
					cmd.add(command);
					cmd.add(command2);
					getCommandFramework().execute(wrapInShowContextCommand(cmd));
					refreshAdapters();
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
				CompoundCommand cmd = new CompoundCommand();
				Command command = new RemoveInputDataItemCommand(
						getActivity(), currentDataItem);
				Command command2 = new RemoveVariableCommand(
						getActivity(),currentDataItem.getVariable());
				cmd.add(command);
				cmd.add(command2);
				getCommandFramework().execute(wrapInShowContextCommand(cmd));
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		
	}
	
	public void updateVariableWidgets() {
		if(getActivity() != null){
			for (final DataItem dataItem : getActivity().getInputItem()) {
				String name;
				if (dataItem.getVariable() != null)
					name = dataItem.getVariable().getName();
				else
					name = "DefaultName";
				Button button4 = fWidgetFactory.createButton(sectionClient,
					name, SWT.RADIO);
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
	
	@Override
	protected void basicSetInput(EObject newInput) {
		if ( newInput instanceof DataInputUI) {
			super.basicSetInput(newInput);
			updateVariableWidgets();
		}
	}
}
