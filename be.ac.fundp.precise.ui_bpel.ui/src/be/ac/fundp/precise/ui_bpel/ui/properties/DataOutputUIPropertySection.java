package be.ac.fundp.precise.ui_bpel.ui.properties;

import org.eclipse.bpel.ui.commands.AddVariableCommand;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;

import be.ac.fundp.precise.ui_bpel.ui.properties.commands.AddOutputDataItemCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.commands.RemoveDataOutputItemCommand;
import be.ac.fundp.precise.ui_bpel.ui.properties.commands.RemoveVariableCommand;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.ModelPackage;

/**
 * The Class DataOutputUIPropertySection implements the properties to 
 * feed the DataProperty to DataOutputUI.
 * 
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class DataOutputUIPropertySection extends AbstractDataPropertySection {

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.properties.AbstractDataPropertySection#getDataItem()
	 */
	@Override
	EList<DataItem> getDataItem() {
		return ((DataOutputUI) getModel()).getOutputItem();
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.properties.AbstractDataPropertySection#getAddDataItemCommand(be.edu.fundp.precise.uibpel.model.DataItem)
	 */
	@Override
	Command getAddDataItemCommand(DataItem id) {
		DataOutputUI userActivity = (DataOutputUI)getInput();
		CompoundCommand cmd = new CompoundCommand();
		Command command = new AddOutputDataItemCommand(userActivity, id);
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
		DataOutputUI userActivity = (DataOutputUI)getInput();
		CompoundCommand cmd = new CompoundCommand();
		Command command = new RemoveDataOutputItemCommand(
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
		DataOutputUI assign = getModel();
		if (assign == null) {
			return -1;
		}
		return assign.getOutputItem().indexOf(fCurrentDataItem);
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.properties.AbstractDataPropertySection#getLabel()
	 */
	@Override
	String getLabel() {
		return "Data Output Item:";
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.ui_bpel.ui.properties.AbstractDataPropertySection#fixAdapter(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	int fixAdapter(Notification n) {
		if (n.getFeature() == ModelPackage.eINSTANCE.getDataItem()) {
			DataItem aDataOutputUI = (DataItem) n.getNewValue();
			DataOutputUI dataOutputUi = getModel();
			if (aDataOutputUI != null) {
				return dataOutputUi.getOutputItem().indexOf(aDataOutputUI);
			}
		}
		return -1;
	}


}
