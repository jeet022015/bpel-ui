package be.ac.fundp.precise.ui_bpel.ui.properties.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import be.edu.fundp.precise.uibpel.model.ModelFactory;
import be.edu.fundp.precise.uibpel.model.UserRole;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRoleDialog.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class UserRoleDialog  extends Dialog {

	/** The value. */
	private String value = "NameDefault";
	
	/**
	 * Instantiates a new user role dialog.
	 *
	 * @param parent the parent
	 */
	public UserRoleDialog(Shell parent) {
		super(parent);
	}
	
	/**
	 * Instantiates a new user role dialog.
	 *
	 * @param parent the parent
	 * @param style the style
	 */
	public UserRoleDialog(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * Makes the dialog visible.
	 *
	 * @return the user role
	 */
	public UserRole open() {
		
		UserRole newDataItem = ModelFactory.eINSTANCE.createUserRole();
		
		Shell parent = getParent();
		final Shell shell = new Shell(parent, SWT.TITLE | SWT.BORDER
				| SWT.APPLICATION_MODAL);
		shell.setText("Input Data");

		shell.setLayout(new GridLayout(2, true));

		Label label = new Label(shell, SWT.NULL);
		label.setText("Data Input");

		final Text text = new Text(shell, SWT.SINGLE | SWT.BORDER);
		text.setText("");

		final Button buttonOK = new Button(shell, SWT.PUSH);
		buttonOK.setText("OK");
		buttonOK.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		Button buttonCancel = new Button(shell, SWT.PUSH);
		buttonCancel.setText("Cancel");

		text.addListener(SWT.Modify, new Listener() {

			public void handleEvent(Event event) {
				try {
					value = text.getText();
					buttonOK.setEnabled(true);
				} catch (Exception e) {
					buttonOK.setEnabled(false);
				}
			}
		});
		

		buttonOK.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				shell.dispose();
			}
		});

		buttonCancel.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				shell.dispose();
			}
		});

		shell.addListener(SWT.Traverse, new Listener() {
			public void handleEvent(Event event) {
				if (event.detail == SWT.TRAVERSE_ESCAPE)
					event.doit = false;
			}
		});

		shell.pack();
		shell.open();

		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		newDataItem.setRoleId(value);
		return newDataItem;
	}

}
