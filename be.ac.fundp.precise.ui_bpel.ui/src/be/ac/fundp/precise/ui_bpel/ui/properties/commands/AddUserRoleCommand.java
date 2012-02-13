package be.ac.fundp.precise.ui_bpel.ui.properties.commands;

import org.eclipse.bpel.ui.commands.AddToListCommand;
import org.eclipse.emf.common.util.EList;

import be.edu.fundp.precise.uibpel.model.UserInteraction;
import be.edu.fundp.precise.uibpel.model.UserRole;

// TODO: Auto-generated Javadoc
/**
 * The Class AddUserRoleCommand.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class AddUserRoleCommand extends AddToListCommand {
	
	/**
	 * Instantiates a new adds the user role command.
	 *
	 * @param userActivity the user activity
	 * @param id the id
	 */
	public AddUserRoleCommand(UserInteraction userActivity, UserRole id) {
		super(userActivity, id, "Add User Role");
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
	protected EList<UserRole> getList() {
		return ((UserInteraction)target).getUserRoles();
	}
}
