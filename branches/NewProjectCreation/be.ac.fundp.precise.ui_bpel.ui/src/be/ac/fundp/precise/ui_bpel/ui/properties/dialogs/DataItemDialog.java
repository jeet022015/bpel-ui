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

// TODO: Auto-generated Javadoc
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
	
	/** The b1. */
	private Button b1;
	
	/** The b2. */
	private Button b2;
	
	/** The b3. */
	private Button b3;
	
	/** The b4. */
	private Button b4;

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
		
		DataItem newDataItem = ModelFactory.eINSTANCE.createDataItem();
		
		Shell parent = getParent();
		final Shell shell = new Shell(parent, SWT.TITLE | SWT.BORDER
				| SWT.APPLICATION_MODAL);
		shell.setText("Input Data");

		shell.setLayout(new GridLayout(3, true));

		Label label = new Label(shell, SWT.NULL);
		label.setText("Data Input");

		final Text text = new Text(shell, SWT.SINGLE | SWT.BORDER);
		text.setText("");
		
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
		
		//g.setSize(110, 110);
		g.setText("Types:");
		b1 = new Button(g, SWT.RADIO);
		b1.setBounds(10, 5, 75, 15);
		//HAck
		b1.setText("DateType");
		
		b2 = new Button(g, SWT.RADIO);
		b2.setBounds(10, 20, 75, 15);
		b2.setText(DataType.INT_TYPE.getName());
		
		b3 = new Button(g, SWT.RADIO);
		b3.setBounds(10, 35, 80, 15);
		b3.setText(DataType.STRING_TYPE.getName());
		b3.setSelection(true);
		
		b4 = new Button(g, SWT.RADIO);
		b4.setBounds(10, 50, 80, 15);
		b4.setText(DataType.BOOLEAN_TYPE.getName());

		Listener myList = new Listener() {
			public void handleEvent(Event event) {
				try {
					if (b2.getSelection())
						type = b2.getText();
					else if (b3.getSelection())
						type = b3.getText();
					else if (b4.getSelection())
						type = b4.getText();
					else type = b1.getText();
				} catch (Exception e) {
					buttonOK.setEnabled(false);
				}
			}
		};
		
		b1.addListener(SWT.Selection,myList);
		b2.addListener(SWT.Selection,myList);
		b3.addListener(SWT.Selection,myList);
		b4.addListener(SWT.Selection,myList);
		
//		VariableTypeSelector variableTypeSelector = new VariableTypeSelector(shell, 
//				SWT.NONE, getBPELEditor(),
//				t, new VariableTypeCallback());
		

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

		newDataItem.setType(DataType.get(type));
		Variable v = BPELFactory.eINSTANCE.createVariable();
		v.setName(value);
		v.setType(XSDUtils.getPrimitive("string"));
//		if (xsdType2 != null){
//			v.setType(xsdType2);
//		}else if (xsdElement2 != null){
//			v.setXSDElement(xsdElement2);
//		} else if(message2 != null){
//			v.setMessageType(message2);
//		}
		newDataItem.setVariable(v);
		return newDataItem;
	}
}