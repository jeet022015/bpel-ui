package be.ac.fundp.precise.ui_bpel.ui.properties.commands;

import org.eclipse.bpel.ui.commands.AddToListCommand;
import org.eclipse.emf.common.util.EList;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;

// TODO: Auto-generated Javadoc
/**
 * The Class AddInputDataItemCommand.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class AddInputDataItemCommand extends AddToListCommand {
	
	/**
	 * Instantiates a new adds the input data item command.
	 *
	 * @param target the target
	 * @param newCopy the new copy
	 */
	public AddInputDataItemCommand(DataInputUI target, DataItem newCopy) {
		super(target, newCopy, "Add DataItem");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.commands.AddToListCommand#doExecute()
	 */
	@Override
	public void doExecute() {
		super.doExecute();
		if (newElement == null) throw new IllegalStateException();
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.commands.AddToListCommand#getList()
	 */
	@Override
	protected EList<DataItem> getList() {
		return ((DataInputUI)target).getInputItem();
	}
}