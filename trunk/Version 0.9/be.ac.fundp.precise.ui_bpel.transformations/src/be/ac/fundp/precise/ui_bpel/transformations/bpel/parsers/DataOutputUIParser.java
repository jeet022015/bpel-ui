package be.ac.fundp.precise.ui_bpel.transformations.bpel.parsers;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.CorrelationPattern;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.ui.properties.CorrelationSection;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;

import be.ac.fundp.precise.ui_bpel.transformations.bpel.bpelEntities.PartnerEntity;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;

public class DataOutputUIParser extends AbstractParser{

	private static final String CORRELATION_SET_OUTPUT_OPERATION_INTERACTION = "OutputOperationInteraction-";
	private PartnerEntity uiManagerPartner;
	private Operation outputOp;
	private Operation genOp;
	private Variable inputVar;
	private Variable outputVar;
	private Activity parse;
	private CorrelationSet interactionCS;
	private static int operationCounter = 1;
	private CommonConcepts cc = CommonConcepts.getInstance(); 

	public DataOutputUIParser(DataOutputUI activity,
			PartnerEntity uiManagerPartner) {
		this.uiManagerPartner = uiManagerPartner;
		outputOp = uiManagerPartner.getOperation("outputOperation");
		genOp = uiManagerPartner.getOperation("generateProcessId");
		inputVar = createVariable("operationOutputRequest"
				+ operationCounter, (Message) outputOp.getInput()
				.getMessage());
		outputVar = createVariable("operationOutputResponse"
				+ operationCounter, (Message) outputOp.getOutput()
				.getMessage());
		Collection<Correlation> correlations = createCorrelationSets();
		parse = parseActivity(activity, correlations);
		operationCounter++;
	}

	private Activity parseActivity(DataOutputUI activity,
			Collection<Correlation> correlations) {
		Sequence s = BPELFactory.eINSTANCE.createSequence();

		Assign assignBefore = BPELFactory.eINSTANCE.createAssign();
		assignBefore.setName("DataOutputConfiguration");

		DataItem[] dataItems = activity.getOutputItem()
				.toArray(new DataItem[0]);

		Operation genOp = uiManagerPartner.getOperation("generateProcessId");
		Part genOpPart = (Part) genOp.getOutput().getMessage()
				.getPart("parameters");

		// ================== Initialization =====================
		Copy initCopy = createInitCopy(dataItems);

		// ================== ROLE =====================
		Copy roleCopy = createCopyRole(activity);

		// ================== ID =====================
		Copy idCopy = createCopyId(activity);

		// ================== Process ID =====================
		Copy genCopy = createCopyProcessID(activity, genOpPart);

		// ================== COPY DATA ITEM =====================
		List<Copy> dataItemCopies = new LinkedList<Copy>();
		if (activity.getOutputItem() != null)
			for (int i = 0; i < dataItems.length; i++) {
				DataItem dataItem = dataItems[i];
				Copy dataItemContentCopy = createCopyDataItemContentBefore(
						dataItem, i + 1, "data", "data");
				Copy cid = createCopyDataItemIdBefore(dataItem, i + 1, "data",
						"id");

				dataItemCopies.add(dataItemContentCopy);
				dataItemCopies.add(cid);
			}
		// =========== Configuring the ASSIGN BEFORE  =============
		assignBefore.getCopy().add(initCopy);
		assignBefore.getCopy().add(roleCopy);
		assignBefore.getCopy().add(idCopy);
		assignBefore.getCopy().add(genCopy);
		assignBefore.getCopy().addAll(dataItemCopies);

		// ================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataOutput");
		i.setInputVariable(inputVar);
		i.setOutputVariable(outputVar);
		i.setOperation(outputOp);
		i.setPartnerLink(uiManagerPartner.getPartnerLink());
		Correlations ci = BPELFactory.eINSTANCE.createCorrelations();
		for (Correlation cs : correlations) {
			ci.getChildren().add(cs);
		}
		i.setCorrelations(ci);

		s.getActivities().add(assignBefore);
		s.getActivities().add(i);
		return s;
	}

	private Collection<Correlation> createCorrelationSets() {
		Collection<Correlation> correlations = new LinkedList<Correlation>();
		
		Correlation cr = BPELFactory.eINSTANCE.createCorrelation();
		cr.setSet(getProcessIdCorrelationSet());
		cr.setInitiate(CorrelationSection.NO);
		cr.setPattern(CorrelationPattern
				.get(CorrelationPattern.REQUESTRESPONSE));
		correlations.add(cr);

		interactionCS = BPELFactory.eINSTANCE
				.createCorrelationSet();
		interactionCS.setName(CORRELATION_SET_OUTPUT_OPERATION_INTERACTION
				+ operationCounter);
		interactionCS.getProperties().add(getProperty("interactionId"));
		Correlation cr2 = BPELFactory.eINSTANCE.createCorrelation();
		cr2.setSet(interactionCS);
		cr2.setInitiate(CorrelationSection.YES);
		cr2.setPattern(CorrelationPattern
				.get(CorrelationPattern.REQUESTRESPONSE));
		correlations.add(cr2);
		return correlations;
	}

	public Activity getActivity() {
		return parse;
	}
	
	public Property getProperty(String propertyId) {
		return uiManagerPartner.getProperty(propertyId);
	}

	@Override
	public Variable getInputVar() {
		return inputVar;
	}

	@Override
	public Variable getOutputVar() {
		return outputVar;
	}

	@Override
	Part getOperationInputPart() {
		return (Part) outputOp.getInput().getMessage().getPart("parameters");
	}

	@Override
	Part getOperationOutputPart() {
		return (Part) outputOp.getOutput().getMessage()
				.getPart("parameters");
	}

	@Override
	Operation getOperationGenId() {
		return genOp;
	}

	public CorrelationSet getCorrelationSet() {
		return interactionCS;
	}

	@Override
	Variable getOutputGenVar() {
		return cc.getOutputGenVar(genOp);
	}

	@Override
	CorrelationSet getProcessIdCorrelationSet() {
		return cc.getProcessIdCorrelationSet(uiManagerPartner.getProperty("processId"));
	}
}
