package be.ac.fundp.precise.ui_bpel.ui.properties.commands;

import org.eclipse.bpel.ui.commands.AddToListCommand;
import org.eclipse.emf.common.util.EList;

import be.edu.fundp.precise.uibpel.model.UserInteraction;
import be.edu.fundp.precise.uibpel.model.UserRole;

public class AddUserRoleCommand extends AddToListCommand {
	
	public AddUserRoleCommand(UserInteraction userActivity, UserRole id) {
		super(userActivity, id, "Add User Role");
	}

	@Override
	public void doExecute() {
		super.doExecute();
		if (newElement == null) throw new IllegalStateException();
		
	}

	@Override
	protected EList<UserRole> getList() {
		return ((UserInteraction)target).getUserRoles();
	}
}
