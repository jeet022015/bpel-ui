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
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;

public class DataInputUIParser extends AbstractParser {

	private static final String CORRELATION_SET_SELECTION_OPERATION_INTERACTION = "InputOperationInteraction-";

	private Activity parse;
	private PartnerEntity uiManagerPartner;

	private static int operationCounter = 1;

	private Variable inputVar;

	private Variable outputVar;

	private Operation inputOp;

	private Operation genOp;

	private CorrelationSet interactionCS;

	private CommonConcepts cc = CommonConcepts.getInstance();

	public DataInputUIParser(DataInputUI activity,
			PartnerEntity uiManagerPartner) {
		this.uiManagerPartner = uiManagerPartner;
		inputOp = uiManagerPartner.getOperation("inputOperation");
		genOp = uiManagerPartner.getOperation("generateProcessId");
		inputVar = createVariable("operationInputRequest" + operationCounter,
				(Message) inputOp.getInput().getMessage());
		outputVar = createVariable("operationInputResponse" + operationCounter,
				(Message) inputOp.getOutput().getMessage());
		Collection<Correlation> correlations = createCorrelationSets();
		parse = parseActivity(activity, correlations);
		operationCounter++;
	}

	private Activity parseActivity(DataInputUI activity,
			Collection<Correlation> correlations) {
		Sequence s = BPELFactory.eINSTANCE.createSequence();

		Assign assignBefore = BPELFactory.eINSTANCE.createAssign();
		assignBefore.setName("DataInputConfiguration");

		Operation genOp = uiManagerPartner.getOperation("generateProcessId");
		Part genOpPart = (Part) genOp.getOutput().getMessage()
				.getPart("parameters");

		// ================== Initialization =====================
		Copy initCopy = createInitCopy(null);

		// ================== ROLE =====================
		Copy roleCopy = createCopyRole(activity);

		// ================== ID =====================
		Copy idCopy = createCopyId(activity);

		// ================== Process ID =====================
		Copy genCopy = createCopyProcessID(activity, genOpPart);

		// =========== Configuring the ASSIGN BEFORE =============
		assignBefore.getCopy().add(initCopy);
		assignBefore.getCopy().add(roleCopy);
		assignBefore.getCopy().add(idCopy);
		assignBefore.getCopy().add(genCopy);

		// ================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataSelection");
		i.setInputVariable(inputVar);
		i.setOutputVariable(outputVar);
		i.setOperation(inputOp);
		i.setPartnerLink(uiManagerPartner.getPartnerLink());
		Correlations ci = BPELFactory.eINSTANCE.createCorrelations();
		for (Correlation cs : correlations) {
			ci.getChildren().add(cs);
		}
		i.setCorrelations(ci);

		// ================== COPY DATA ITEM =====================
		List<Copy> dataItemCopiesAfter = new LinkedList<Copy>();
		if (activity.getInputItem() != null)
			for (DataItem di : activity.getInputItem()) {
				Copy dataItemContentCopy = createDataItemContentAfterCopy(di,
						"data", "data");
				dataItemCopiesAfter.add(dataItemContentCopy);
			}

		s.getActivities().add(assignBefore);
		s.getActivities().add(i);

		if (dataItemCopiesAfter.size() > 0) {
			Assign after = BPELFactory.eINSTANCE.createAssign();
			after.setName("ResponseToDataItems");
			after.getCopy().addAll(dataItemCopiesAfter);
			s.getActivities().add(after);
		}
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

		interactionCS = BPELFactory.eINSTANCE.createCorrelationSet();
		interactionCS.setName(CORRELATION_SET_SELECTION_OPERATION_INTERACTION
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
		return (Part) inputOp.getInput().getMessage().getPart("parameters");
	}

	@Override
	Part getOperationOutputPart() {
		return (Part) inputOp.getOutput().getMessage().getPart("parameters");
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
		return cc.getProcessIdCorrelationSet(uiManagerPartner
				.getProperty("processId"));
	}
}
