package be.ac.fundp.precise.ui_bpel.ui.properties;

import org.eclipse.bpel.ui.commands.AddVariableCommand;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;

import be.ac.fundp.precise.ui_bpel.ui.properties.commands.AddInputDataItemCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.commands.RemoveInputDataItemCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.commands.RemoveVariableCommand;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.ModelPackage;

/**
 * The Class DataInputUIPropertySection implements the properties to 
 * feed the DataProperty to DataInputUI.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class DataInputUIPropertySection extends AbstractDataPropertySection {

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.properties.AbstractDataPropertySection#getDataItem()
	 */
	@Override
	EList<DataItem> getDataItem() {
		return ((DataInputUI) getModel()).getInputItem();
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.properties.AbstractDataPropertySection#getAddDataItemCommand(be.edu.fundp.precise.uibpel.model.DataItem)
	 */
	@Override
	Command getAddDataItemCommand(DataItem id) {
		DataInputUI userActivity = (DataInputUI) getModel();
		
		CompoundCommand cmd = new CompoundCommand();
		Command command = new AddInputDataItemCommand(userActivity, id);
		Command command2 = new AddVariableCommand(userActivity, id.getVariable());
		cmd.add(command);
		cmd.add(command2);
		return cmd;
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.properties.AbstractDataPropertySection#getRemoveDataItemCommand()
	 */
	@Override
	Command getRemoveDataItemCommand() {
		CompoundCommand cmd = new CompoundCommand();
		DataInputUI userActivity = (DataInputUI) getModel();
		Command command = new RemoveInputDataItemCommand(
				userActivity, fDataSection.fCurrent);
		Command command2 = new RemoveVariableCommand(userActivity,
				fDataSection.fCurrent.getVariable());
		cmd.add(command);
		cmd.add(command2);
		return cmd;
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.properties.AbstractDataPropertySection#getCurrentDataItemContext()
	 */
	@Override
	Object getCurrentDataItemContext() {
		DataInputUI assign = getModel();
		if (assign == null) {
			return -1;
		}
		return assign.getInputItem().indexOf(fCurrentDataItem);
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.properties.AbstractDataPropertySection#getLabel()
	 */
	@Override
	String getLabel() {
		return "Data Input Item:";
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.properties.AbstractDataPropertySection#fixAdapter(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected int fixAdapter(Notification n) {
		if (n.getFeature() == ModelPackage.eINSTANCE.getDataItem()) {
			DataItem aDataInputUI = (DataItem) n.getNewValue();
			DataInputUI dataInputUi = getModel();
			if (aDataInputUI != null) {
				return dataInputUi.getInputItem().indexOf(aDataInputUI);
			}
		}
		return -1;
	}

	
}
