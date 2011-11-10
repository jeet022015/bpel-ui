package be.ac.fundp.precise.ui_bpel.ui.properties.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.ui.commands.RemoveFromListCommand;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;

public class RemoveVariableCommand extends RemoveFromListCommand {

	Object context;
	public RemoveVariableCommand(EObject context, Variable var) {
		super(ModelHelper.getContainingScope(context), var, 
				"Delete Variable");	
	}

	@Override
	protected List<Variable> getList() {
		// https://issues.jboss.org/browse/JBIDE-8048
		Variables variables = ModelHelper.getVariables( target );
		if (variables != null)
			return variables.getChildren();
		return new ArrayList<Variable>();
	}
}
