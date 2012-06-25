package be.ac.fundp.precise.ui_bpel.ui.properties.commands;

import org.eclipse.bpel.ui.commands.RemoveFromListCommand;
import org.eclipse.emf.common.util.EList;

import be.edu.fundp.precise.uibpel.model.UserInteraction;
import be.edu.fundp.precise.uibpel.model.UserRole;

// TODO: Auto-generated Javadoc
/**
 * The Class RemoveUserRoleCommand.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class RemoveUserRoleCommand  extends RemoveFromListCommand {

	/**
	 * Instantiates a new removes the user role command.
	 *
	 * @param activity the activity
	 * @param currentDataItem the current data item
	 */
	public RemoveUserRoleCommand(UserInteraction activity,
			UserRole currentDataItem) {
		super(activity, currentDataItem,  "Remove User Role");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.commands.RemoveFromListCommand#getList()
	 */
	@Override
	protected EList<UserRole> getList() {
		return ((UserInteraction)target).getUserRoles();
	}

}
