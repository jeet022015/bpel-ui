package be.ac.fundp.precise.ui_bpel.ui.properties.commands;

import org.eclipse.bpel.ui.commands.AddToListCommand;
import org.eclipse.emf.common.util.EList;

import be.ac.fundp.precise.ui_bpel.ui.Messages;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;

public class AddInputDataItemCommand extends AddToListCommand {
	public AddInputDataItemCommand(DataInputUI target, DataItem newCopy) {
		super(target, newCopy, Messages.UIBPELEditor_Command_Add_DataItem);
	}
	
	@Override
	public void doExecute() {
		super.doExecute();
		if (newElement == null) throw new IllegalStateException();
		
	}

	@Override
	protected EList<DataItem> getList() {
		return ((DataInputUI)target).getInputItem();
	}
}