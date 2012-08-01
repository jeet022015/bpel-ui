package be.ac.fundp.precise.ui_bpel.ui.properties.commands;

import org.eclipse.bpel.ui.commands.RemoveFromListCommand;
import org.eclipse.emf.common.util.EList;

import be.edu.fundp.precise.uibpel.model.UserInteraction;
import be.edu.fundp.precise.uibpel.model.UserRole;

/**
 * The Class RemoveUserRoleCommand.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class RemoveUserRoleCommand  extends RemoveFromListCommand {

	/**
	 * Instantiates a new command to remove a user role.
	 *
	 * @param activity the current User Interaction activity
	 * @param currentUserRole the current user role
	 */
	public RemoveUserRoleCommand(UserInteraction activity,
			UserRole currentUserRole) {
		super(activity, currentUserRole,  "Remove User Role");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.commands.RemoveFromListCommand#getList()
	 */
	@Override
	protected EList<UserRole> getList() {
		return ((UserInteraction)target).getUserRoles();
	}

}
