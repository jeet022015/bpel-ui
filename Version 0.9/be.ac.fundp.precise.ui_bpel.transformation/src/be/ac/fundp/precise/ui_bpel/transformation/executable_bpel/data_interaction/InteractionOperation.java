package be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.data_interaction;

import java.util.Collection;

import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Variable;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;

public interface InteractionOperation {
	
	public Operation getOperation();
	
	public Variable getInputVariable();
	
	public Variable getOutputVariable();
	
	public Variable getGenVariable();
	
	public Operation getGenOperation();
	
	public PartnerLink getPartnerLink();
	
	public Collection<Correlation> getCorrelationSet();
	
	public Part getInputOperationPart();
	
	public Part getOutputOperationPart();
	
	public Part getGenOperationPart();

}
