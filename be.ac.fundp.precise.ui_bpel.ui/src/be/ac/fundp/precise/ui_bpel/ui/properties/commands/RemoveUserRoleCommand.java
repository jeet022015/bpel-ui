package be.ac.fundp.precise.ui_bpel.ui.properties.commands;

import org.eclipse.bpel.ui.commands.RemoveFromListCommand;
import org.eclipse.emf.common.util.EList;

import be.edu.fundp.precise.uibpel.model.UserInteraction;
import be.edu.fundp.precise.uibpel.model.UserRole;

public class RemoveUserRoleCommand  extends RemoveFromListCommand {

	public RemoveUserRoleCommand(UserInteraction activity,
			UserRole currentDataItem) {
		super(activity, currentDataItem,  "Remove User Role");
	}

	@Override
	protected EList<UserRole> getList() {
		return ((UserInteraction)target).getUserRoles();
	}

}
