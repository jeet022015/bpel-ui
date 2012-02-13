package be.ac.fundp.precise.ui_bpel.ui.properties.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.ui.commands.RemoveFromListCommand;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.WSDLElement;

// TODO: Auto-generated Javadoc
/**
 * The Class RemoveVariableCommand.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class RemoveVariableCommand extends RemoveFromListCommand {

	/** The context. */
	Object context;
	Variable varDelete;
	
	/**
	 * Instantiates a new removes the variable command.
	 *
	 * @param context the context
	 * @param var the var
	 */
	public RemoveVariableCommand(EObject context, Variable var) {
		super(ModelHelper.getContainingScope(context), var, 
				"Delete Variable");	
		varDelete = var;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.commands.RemoveFromListCommand#getList()
	 */
	@Override
	protected List<Variable> getList() {
		Variables variables = getCorrectVariables(target);
		if (variables != null )
			return variables.getChildren();
		return new ArrayList<Variable>();
	}

	private Variables getCorrectVariables(EObject context) {
		if (context instanceof Process) 
			return ((Process)context).getVariables();
		if (context instanceof Scope){
			Scope innerScope = ((Scope)context);
			Variables variables = innerScope.getVariables();
			if (variables.getChildren().contains(varDelete))
				return variables;	
		}
		if (context instanceof WSDLElement){
			return getCorrectVariables(((WSDLElement)context).getContainer());
		}
		return null;
	}
}
