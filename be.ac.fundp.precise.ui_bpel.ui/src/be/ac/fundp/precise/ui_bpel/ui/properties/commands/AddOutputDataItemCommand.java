package be.ac.fundp.precise.ui_bpel.ui.properties.commands;

import org.eclipse.bpel.ui.commands.AddToListCommand;
import org.eclipse.emf.common.util.EList;

import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;

public class AddOutputDataItemCommand extends AddToListCommand {
	public AddOutputDataItemCommand(DataOutputUI target, DataItem newCopy) {
		super(target, newCopy, "Add DataItem");
	}

	@Override
	protected EList<DataItem> getList() {
		return ((DataOutputUI)target).getOutputItem();
	}
}