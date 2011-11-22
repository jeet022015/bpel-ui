package be.ac.fundp.precise.ui_bpel.ui.properties;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.ui.commands.CompoundCommand;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.Section;

import be.ac.fundp.precise.ui_bpel.ui.properties.commands.AddUserRoleCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.commands.RemoveUserRoleCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.dialogs.UserRoleDialog;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.UserInteraction;
import be.edu.fundp.precise.uibpel.model.UserRole;

/*
 * Bug 120110
 * This class implements the detail property tab for the "elemental" extension activity.
 * This property detail tab allows the user to select a variable in scope for this activity.
 * 
 * Note that validation of this activity is not yet implemented.
 */
public class UserRolePropertySection extends BPELPropertySection {

	protected Composite parentComposite;
	protected Label variableName;
	protected Button variableBrowseButton;
	private Section mainLabel;
	private Composite sectionClient;
	private Button deleteRoleButton;
	private List<Button> availableDataItemButtons = new LinkedList<Button>();
	private List<String> dataItemsInButton = new LinkedList<String>();
	private Button currentDataItemButton;
	private UserRole currentDataItem;

	private UserInteraction getActivity() {
		return (UserInteraction)getInput();
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

		mainLabel.setText("Roles:");
		//g = fWidgetFactory.createGroup(composite, "group");
		//Button button2 = fWidgetFactory.createButton(g, "", SWT.RADIO);
		sectionClient = fWidgetFactory.createComposite(mainLabel);
		sectionClient.setLayout(new GridLayout());
		mainLabel.setClient(sectionClient);
		
		variableBrowseButton = fWidgetFactory.createButton(composite,
				"Create Role", SWT.PUSH);
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
				UserRoleDialog dialog = new UserRoleDialog(shell);
				UserRole id = dialog.open();
				
				if (id != null){
					UserInteraction userActivity = getActivity();
					
					Command command = new AddUserRoleCommand(userActivity, id);
					getCommandFramework().execute(command);
					updateVariableWidgets();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		
		deleteRoleButton = fWidgetFactory.createButton(composite,
				"Delete Role", SWT.PUSH);
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
				Command command = new RemoveUserRoleCommand(
						getActivity(), currentDataItem);
				cmd.add(command);
				getCommandFramework().execute(wrapInShowContextCommand(cmd));
				
				dataItemsInButton.remove(currentDataItem.getRoleId());
				currentDataItemButton.setVisible(false);
				availableDataItemButtons.add(currentDataItemButton);
				currentDataItemButton = null;
				updateVariableWidgets();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		
		for (int i = 0; i < 10; i++) {
			Button button4 = fWidgetFactory.createButton(sectionClient,
						"buttonName", SWT.RADIO);
			button4.setVisible(false);
			availableDataItemButtons.add(button4);
		}
	}
	
	public void updateVariableWidgets() {
		if(getActivity() != null){
			for (final UserRole dataItem : getActivity().getUserRoles()) {
				if (dataItem.getRoleId() != null && !dataItemsInButton.contains(dataItem.getRoleId())){
					String name = dataItem.getRoleId();
					dataItemsInButton.add(name);
					final Button button4 = availableDataItemButtons.remove(0);
					button4.setText(name);
					button4.addSelectionListener(new SelectionListener() {
						public void widgetSelected(SelectionEvent e) {
							currentDataItem = dataItem;
							currentDataItemButton = button4;
						}
	
						public void widgetDefaultSelected(SelectionEvent e) {
							widgetSelected(e);
						}
					});
					button4.setVisible(true);
				}
			}
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
