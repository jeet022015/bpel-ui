package be.ac.fundp.precise.ui_bpel.ui.properties.dialogs;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.ui.util.XSDUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataType;
import be.edu.fundp.precise.uibpel.model.ModelFactory;

/**
 * The Class DataItemDialog.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class DataItemDialog extends Dialog {
	
	/** The type. */
	private String type = DataType.STRING_TYPE.getName();
	
	/** The value. */
	private String value = "NameDefault";

	/**
	 * Instantiates a new data item dialog.
	 *
	 * @param parent the parent
	 */
	public DataItemDialog(Shell parent) {
		super(parent);
	}

	/**
	 * Instantiates a new data item dialog.
	 *
	 * @param parent the parent
	 * @param style the style
	 */
	public DataItemDialog(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * Makes the dialog visible.
	 *
	 * @return the data item
	 */
	public DataItem open() {
		
		Shell parent = getParent();
		final Shell shell = new Shell(parent, SWT.TITLE | SWT.BORDER
				| SWT.APPLICATION_MODAL);
		shell.setText("New Data Item");

		GridLayout gl = new GridLayout(2, true);
		gl.makeColumnsEqualWidth = false;
		shell.setLayout(gl);
		String[] availableTypes = {"DateType", DataType.INT_TYPE.getName(), 
				DataType.STRING_TYPE.getName(), DataType.BOOLEAN_TYPE.getName()};

		Label nameFieldLabel = new Label(shell, SWT.NULL);
		nameFieldLabel.setText("Name:");
		nameFieldLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		final Text text = new Text(shell, SWT.SINGLE | SWT.BORDER);
		text.setText(value);

		Label typeLabel = new Label(shell, SWT.NULL);
		typeLabel.setText("Type:");
		typeLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		final Group g = new Group(shell, SWT.SINGLE | SWT.BORDER);

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
		
		//g.setText("Available Types");
		final Button[] ButtonTypes = {new Button(g, SWT.RADIO), new Button(g, SWT.RADIO),
				new Button(g, SWT.RADIO), new Button(g, SWT.RADIO)};

		Listener myList = new Listener() {
			public void handleEvent(Event event) {
				try {
					for (Button button : ButtonTypes) {
						if (button.getSelection())
							type = button.getText();
					}
				} catch (Exception e) {
					buttonOK.setEnabled(false);
				}
			}
		};
		
		for (int i = 0; i < ButtonTypes.length; i++) {
			Button button = ButtonTypes[i];
			button.setText(availableTypes[i]);
			button.setBounds(10, 5+i*15, 120, 15);
			button.addListener(SWT.Selection,myList);
		}

		buttonOK.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				shell.dispose();
			}
		});

		buttonCancel.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				value = null;
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

		if (value == null){
			return null;
		}
		DataItem newDataItem = ModelFactory.eINSTANCE.createDataItem();
		newDataItem.setType(DataType.get(type));
		Variable v = BPELFactory.eINSTANCE.createVariable();
		v.setName(value);
		v.setType(XSDUtils.getPrimitive("string"));
		newDataItem.setVariable(v);
		return newDataItem;
	}
}
