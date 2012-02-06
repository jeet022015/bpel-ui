package be.ac.fundp.precise.ui_bpel.ui.properties.aux;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataType;

/**
 * The Class CategorySection is responsible to manager the current 
 * Data Item in a Property Section.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class DataItemCategorySection {

	/** The combo label. */
	public Label fComboLabel;
	
	/** The combo. */
	public Combo fCombo;
	
	/** The allowed types. */
	public DataType[] fAllowedType;
	
	/** The outer composite. */
	public Composite fOuterComposite;
	
	/** The current Data Item. */
	public DataItem fCurrent;
	
	/** The name field label. */
	public Label fNameFieldLabel;
	
	/** The name field. */
	public Label fNameField;
	//public Text fNameField;

	/**
	 * Hide current View of a Data Item.
	 */
	public void hideCurrent() {
		// TODO implement it.
		
	}

	/**
	 * Ensure category composite created.
	 */
	public void ensureCategoryCompositeCreated() {
		// TODO implement it.
	}

	/**
	 * Update type combo.
	 */
	public void updateCombo() {
		fNameField.setText(fCurrent.getVariable().getName());
		for(int i=0; i < fAllowedType.length; i++) {
			if (fAllowedType[i] == fCurrent.getType()) {
				fCombo.select(i);
				return ;
			}
		}
	}
}
