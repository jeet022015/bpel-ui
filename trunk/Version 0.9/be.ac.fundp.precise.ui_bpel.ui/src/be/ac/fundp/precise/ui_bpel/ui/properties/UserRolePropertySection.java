package be.ac.fundp.precise.ui_bpel.ui.properties;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.Section;

import be.ac.fundp.precise.ui_bpel.ui.properties.commands.AddUserRoleCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.commands.RemoveUserRoleCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.dialogs.UserRoleDialog;
import be.edu.fundp.precise.uibpel.model.UserInteraction;
import be.edu.fundp.precise.uibpel.model.UserRole;

// TODO: Auto-generated Javadoc
/*
 * This class implements the detail property tab for the "elemental" extension activity.
 * This property detail tab allows the user to select a variable in scope for this activity.
 * 
 * Note that validation of this activity is not yet implemented.
 */
/**
 * The Class UserRolePropertySection.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class UserRolePropertySection extends BPELPropertySection {

	/** The parent composite. */
	protected Composite parentComposite;
	
	/** The variable browse button. */
	protected Button createRoleButton;
	
	/** The main label. */
	private Section mainLabel;
	
	/** The section client. */
	private Composite sectionClient;
	
	/** The delete role button. */
	private Button deleteRoleButton;
	
	/** The available data item buttons. */
	private List<Button> availableUserRoleButtons = new LinkedList<Button>();
	
	/** The data items in button. */
	private List<String> userRolesInButton = new LinkedList<String>();
	
	/** The current data item button. */
	private Button currentUserRoleButton;
	
	/** The current User Role. */
	private UserRole currentUserRole;

	/**
	 * Gets the activity.
	 *
	 * @return the activity
	 */
	private UserInteraction getActivity() {
		return (UserInteraction)getInput();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#createClient(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createClient(Composite parent) {
		FlatFormData data;

		final Composite composite = parentComposite = createFlatFormComposite( 
				createFlatFormComposite(parent) );
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		composite.setLayoutData(data);
		
		mainLabel = fWidgetFactory.createSection(composite, SWT.NONE); //$NON-NLS-1$

		mainLabel.setText("Roles:");
		sectionClient = fWidgetFactory.createComposite(mainLabel);
		sectionClient.setLayout(new GridLayout());
		mainLabel.setClient(sectionClient);
		
		createRoleButton = fWidgetFactory.createButton(composite,
				"Create Role", SWT.PUSH);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(10, 0);
		data.top = new FlatFormAttachment(0, 0);
		data.height = FigureUtilities.getTextExtents(
				createRoleButton.getText(), createRoleButton.getFont()).height + 4;
		mainLabel.setLayoutData(data);

		data = new FlatFormData();
		data.top = new FlatFormAttachment(mainLabel, 0, SWT.TOP);
		data.left = new FlatFormAttachment(50, -BPELUtil.calculateButtonWidth(
				createRoleButton, SHORT_BUTTON_WIDTH)
				- IDetailsAreaConstants.CENTER_SPACE);
		data.right = new FlatFormAttachment(50,
				-IDetailsAreaConstants.CENTER_SPACE);
		createRoleButton.setLayoutData(data);
		
		createRoleButton.addSelectionListener(new SelectionListener() {
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
				
				//CompoundCommand cmd = new CompoundCommand();
				Command command = new RemoveUserRoleCommand(
						getActivity(), currentUserRole);
				//cmd.add(command);
				//getCommandFramework().execute(wrapInShowContextCommand(cmd));
				getCommandFramework().execute(wrapInShowContextCommand(command));
				
				userRolesInButton.remove(currentUserRole.getRoleId());
				currentUserRoleButton.setVisible(false);
				availableUserRoleButtons.add(currentUserRoleButton);
				currentUserRoleButton = null;
				updateVariableWidgets();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		
		for (int i = 0; i < 3; i++) {
			Button button4 = fWidgetFactory.createButton(sectionClient,
						"buttonName", SWT.RADIO);
			button4.setVisible(false);
			availableUserRoleButtons.add(button4);
		}
	}
	
	/**
	 * Update variable widgets.
	 */
	public void updateVariableWidgets() {
		if(getActivity() != null){
			for (final UserRole dataItem : getActivity().getUserRoles()) {
				if (dataItem.getRoleId() != null && !userRolesInButton.contains(dataItem.getRoleId())){
					String name = dataItem.getRoleId();
					userRolesInButton.add(name);
					final Button button4 = availableUserRoleButtons.remove(0);
					button4.setText(name);
					button4.addSelectionListener(new SelectionListener() {
						public void widgetSelected(SelectionEvent e) {
							currentUserRole = dataItem;
							currentUserRoleButton = button4;
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#basicSetInput(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected void basicSetInput(EObject newInput) {
		if ( newInput instanceof UserInteraction) {
			super.basicSetInput(newInput);
			updateVariableWidgets();
		}
	}
}
