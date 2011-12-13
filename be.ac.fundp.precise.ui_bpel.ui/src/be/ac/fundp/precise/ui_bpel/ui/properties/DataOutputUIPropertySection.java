package be.ac.fundp.precise.ui_bpel.ui.properties;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.ui.commands.AddVariableCommand;
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

import be.ac.fundp.precise.ui_bpel.ui.properties.commands.AddOutputDataItemCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.commands.RemoveDataOutputItemCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.commands.RemoveVariableCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.dialogs.DataItemDialog;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;

// TODO: Auto-generated Javadoc
/*
 * Bug 120110
 * This class implements the detail property tab for the "elemental" extension activity.
 * This property detail tab allows the user to select a variable in scope for this activity.
 * 
 * Note that validation of this activity is not yet implemented.
 */
/**
 * The Class DataOutputUIPropertySection.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class DataOutputUIPropertySection extends BPELPropertySection {

	/** The parent composite. */
	protected Composite parentComposite;
	
	/** The variable name. */
	protected Label variableName;
	
	/** The variable browse button. */
	protected Button variableBrowseButton;
	
	/** The main label. */
	private Section mainLabel;
	
	/** The section client. */
	private Composite sectionClient;
	
	/** The delete role button. */
	private Button deleteRoleButton;
	
	/** The available data item buttons. */
	private List<Button> availableDataItemButtons = new LinkedList<Button>();
	
	/** The data items in button. */
	private List<String> dataItemsInButton = new LinkedList<String>();
	
	/** The current data item. */
	private DataItem currentDataItem;
	
	/** The current data item button. */
	private Button currentDataItemButton;

	/**
	 * Gets the activity.
	 *
	 * @return the activity
	 */
	private DataOutputUI getActivity() {
		return (DataOutputUI)getInput();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#createAdapters()
	 */
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
		//data.top = new FlatFormAttachment(composite, IDetailsAreaConstants.VSPACE);
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		composite.setLayoutData(data);
		
		mainLabel = fWidgetFactory.createSection(composite, SWT.NONE); //$NON-NLS-1$

		mainLabel.setText("Data Output Item:");
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
					DataOutputUI userActivity = getActivity();
					
					CompoundCommand cmd = new CompoundCommand();
					Command command = new AddOutputDataItemCommand(userActivity, id);
					Command command2 = new AddVariableCommand(userActivity, id.getVariable());
					cmd.add(command);
					cmd.add(command2);
					getCommandFramework().execute(wrapInShowContextCommand(cmd));
					updateVariableWidgets();
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
				Command command = new RemoveDataOutputItemCommand(
						getActivity(), currentDataItem);
				Command command2 = new RemoveVariableCommand(getActivity(),
						currentDataItem.getVariable());
				cmd.add(command);
				cmd.add(command2);
				getCommandFramework().execute(wrapInShowContextCommand(cmd));
				
				dataItemsInButton.remove(currentDataItem.getVariable().getName());
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
	
	/**
	 * Update variable widgets.
	 */
	public void updateVariableWidgets() {
		if(getActivity() != null){
			for (final DataItem dataItem : getActivity().getOutputItem()) {
				if (dataItem.getVariable() != null && !dataItemsInButton.contains(dataItem.getVariable().getName())){
					String name = dataItem.getVariable().getName();
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#basicSetInput(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected void basicSetInput(EObject newInput) {
		if ( newInput instanceof DataOutputUI) {
			super.basicSetInput(newInput);
			updateVariableWidgets();
		}
	}
}
