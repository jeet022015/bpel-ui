package be.ac.fundp.precise.ui_bpel.ui.properties.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.ui.commands.RemoveFromListCommand;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;

// TODO: Auto-generated Javadoc
/**
 * The Class RemoveVariableCommand.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class RemoveVariableCommand extends RemoveFromListCommand {

	/** The context. */
	Object context;
	
	/**
	 * Instantiates a new removes the variable command.
	 *
	 * @param context the context
	 * @param var the var
	 */
	public RemoveVariableCommand(EObject context, Variable var) {
		super(ModelHelper.getContainingScope(context), var, 
				"Delete Variable");	
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.commands.RemoveFromListCommand#getList()
	 */
	@Override
	protected List<Variable> getList() {
		// https://issues.jboss.org/browse/JBIDE-8048
		Variables variables = ModelHelper.getVariables( target );
		if (variables != null)
			return variables.getChildren();
		return new ArrayList<Variable>();
	}
}
