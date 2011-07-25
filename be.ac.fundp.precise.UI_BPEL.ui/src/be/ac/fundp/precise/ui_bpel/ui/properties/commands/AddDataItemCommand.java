package be.ac.fundp.precise.ui_bpel.ui.properties.commands;

import org.eclipse.bpel.ui.commands.AddToListCommand;
import org.eclipse.emf.common.util.EList;

import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.UserInteraction;

public class AddDataItemCommand extends AddToListCommand {
	public AddDataItemCommand(UserInteraction target, DataItem newCopy) {
		super(target, newCopy, "add DataItem");
	}

	@Override
	protected EList<DataItem> getList() {
		return ((UserInteraction)target).getData();
	}
}