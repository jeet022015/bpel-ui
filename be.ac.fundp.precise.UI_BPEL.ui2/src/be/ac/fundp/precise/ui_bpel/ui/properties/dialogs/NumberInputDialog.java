package be.ac.fundp.precise.ui_bpel.ui.properties.dialogs;

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

import be.ac.fundp.precise.ui_bpel.ui.Messages;

public class NumberInputDialog extends Dialog {
	private String value = "Default";
	private String type = Messages.Data_Type_String;
	//private EObject modelObject;
	//private EObject variableType;
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;

	/**
	 * @param parent
	 * @param eObject 
	 * @param model 
	 */
	public NumberInputDialog(Shell parent) {
		super(parent);
		//this.modelObject = modelObject;
		//this.variableType = variableType;
	}

	/**
	 * @param parent
	 * @param style
	 */
	public NumberInputDialog(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * Makes the dialog visible.
	 * 
	 * @return
	 */
	public String[] open() {
		Shell parent = getParent();
		final Shell shell = new Shell(parent, SWT.TITLE | SWT.BORDER
				| SWT.APPLICATION_MODAL);
		shell.setText(Messages.UIBPELEditor_Dialog_Number_Input_Title);

		shell.setLayout(new GridLayout(3, true));

		Label label = new Label(shell, SWT.NULL);
		label.setText(Messages.UIBPELEditor_Dialog_Number_Input_Label1);

		final Text text = new Text(shell, SWT.SINGLE | SWT.BORDER);
		
		final Group g = new Group(shell, SWT.SINGLE | SWT.BORDER);

		final Button buttonOK = new Button(shell, SWT.PUSH);
		buttonOK.setText(Messages.UIBPELEditor_Dialog_Number_Input_Button1);
		buttonOK.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		Button buttonCancel = new Button(shell, SWT.PUSH);
		buttonCancel.setText(Messages.UIBPELEditor_Dialog_Number_Input_Button2);

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
		
		//g.setSize(110, 110);
		g.setText(Messages.UIBPELEditor_Dialog_Number_Input_Label2);
		b1 = new Button(g, SWT.RADIO);
		b1.setBounds(10, 5, 75, 15);
		b1.setText(Messages.UIBPELEditor_Dialog_Number_Input_Label_type1);
		b1.setEnabled(true);
		b2 = new Button(g, SWT.RADIO);
		b2.setBounds(10, 20, 75, 15);
		b2.setText(Messages.UIBPELEditor_Dialog_Number_Input_Label_type2);
		b3 = new Button(g, SWT.RADIO);
		b3.setBounds(10, 35, 80, 15);
		b3.setText(Messages.UIBPELEditor_Dialog_Number_Input_Label_type3);
		b4 = new Button(g, SWT.RADIO);
		b4.setBounds(10, 50, 80, 15);
		b4.setText(Messages.UIBPELEditor_Dialog_Number_Input_Label_type4);

		Listener myList = new Listener() {
			public void handleEvent(Event event) {
				try {
					if (b1.getSelection())
						type = Messages.Data_Type_String;
						//"StringType";
					else if (b2.getSelection())
						type = Messages.Data_Type_Int; 
						//"IntType";
					else if (b3.getSelection())
						type = Messages.Data_Type_Date; 
						//"DataType";
					else type = Messages.Data_Type_Boolean; 
							//"BooleanType";
				} catch (Exception e) {
					buttonOK.setEnabled(false);
				}
			}
		};
		
		b1.addListener(SWT.Selection,myList);
		b2.addListener(SWT.Selection,myList);
		b3.addListener(SWT.Selection,myList);
		b4.addListener(SWT.Selection,myList);

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

		text.setText("");
		shell.pack();
		shell.open();

		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		return new String [] {value, type};
	}
}
