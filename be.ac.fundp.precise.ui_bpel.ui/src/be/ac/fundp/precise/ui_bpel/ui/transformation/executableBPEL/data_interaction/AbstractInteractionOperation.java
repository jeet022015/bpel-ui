package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.data_interaction;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Variable;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;


public abstract class AbstractInteractionOperation implements InteractionOperation{

	Operation operation;
	Operation genOperation;
	PartnerLink partnerLink;
	Variable inputVariable;
	Variable outputVariable;
	Variable genVariable;
	Collection<CorrelationSet> correlationSets = new LinkedList<CorrelationSet>();
	
	@Override
	public Operation getOperation() {
		return operation;
	}

	@Override
	public Variable getInputVariable() {
		return inputVariable;
	}

	@Override
	public Variable getOutputVariable() {
		return outputVariable;
	}
	
	@Override
	public Variable getGenVariable() {
		return genVariable;
	}

	@Override
	public Operation getGenOperation() {
		return genOperation;
	}

	@Override
	public PartnerLink getPartnerLink() {
		return partnerLink;
	}

	@Override
	public Collection<CorrelationSet> getCorrelationSet() {
		return correlationSets;
	}

	@Override
	public Part getInputOperationPart() {
		return (Part) operation.getInput().getMessage().getPart("parameters");
	}

	@Override
	public Part getOutputOperationPart() {
		return (Part) operation.getOutput().getMessage().getPart("parameters");
	}

	@Override
	public Part getGenOperationPart() {
		return (Part) genOperation.getInput().getMessage().getPart("parameters");
	}
}
