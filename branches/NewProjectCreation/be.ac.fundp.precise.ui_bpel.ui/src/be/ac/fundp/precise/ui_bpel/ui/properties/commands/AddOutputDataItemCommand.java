package be.ac.fundp.precise.ui_bpel.ui.properties.commands;

import org.eclipse.bpel.ui.commands.AddToListCommand;
import org.eclipse.emf.common.util.EList;

import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;

// TODO: Auto-generated Javadoc
/**
 * The Class AddOutputDataItemCommand.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class AddOutputDataItemCommand extends AddToListCommand {
	
	/**
	 * Instantiates a new adds the output data item command.
	 *
	 * @param target the target
	 * @param newCopy the new copy
	 */
	public AddOutputDataItemCommand(DataOutputUI target, DataItem newCopy) {
		super(target, newCopy, "Add DataItem");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.commands.AddToListCommand#getList()
	 */
	@Override
	protected EList<DataItem> getList() {
		return ((DataOutputUI)target).getOutputItem();
	}
}