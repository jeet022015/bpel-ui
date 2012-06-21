package be.ac.fundp.precise.ui_bpel.transformations.bpel.parsers;

import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.CorrelationPattern;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.ui.properties.CorrelationSection;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;

import be.ac.fundp.precise.ui_bpel.transformations.bpel.bpelEntities.PartnerEntity;

public class InitialReceiverParser {

	private CommonConcepts cc = CommonConcepts.getInstance();
	private Assign assignBefore;
	private Invoke i;
	
	public InitialReceiverParser(String processName, PartnerEntity uiManagerPartner) {

		Operation genIdOperation = uiManagerPartner.getOperation("generateProcessId");
		Variable inputVar = cc.getInputGenVar(genIdOperation);
		Variable outputVar = cc.getOutputGenVar(genIdOperation);
		
		//================== Initialization =============
		assignBefore = genIdInit(processName, genIdOperation, inputVar);
		//================== INVOKE =====================
		i = genIdInvoke(genIdOperation, inputVar, outputVar, uiManagerPartner.getPartnerLink(), cc.getProcessIdCorrelationSet(uiManagerPartner
				.getProperty("processId")));
	}

	private Invoke genIdInvoke(Operation genIdOperation, Variable inputVar, Variable outputVar, PartnerLink partnerLink, CorrelationSet correlationSet) {
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeGenProcessId");
		i.setInputVariable(inputVar);
		i.setOutputVariable(outputVar);
		i.setOperation(genIdOperation);
		i.setPartnerLink(partnerLink);
		Correlations cc = BPELFactory.eINSTANCE.createCorrelations();
		Correlation processCorrelation = BPELFactory.eINSTANCE.createCorrelation();
		processCorrelation.setInitiate(CorrelationSection.YES);
				//bpel.getEventInteractionManager().getCorrelationSet();
		//processCorrelation.setSet(bpel.getUserEventCorrelationSet());
		processCorrelation.setSet(correlationSet);
		processCorrelation.setPattern(CorrelationPattern.get(CorrelationPattern.RESPONSE));
		cc.getChildren().add(processCorrelation);
		i.setCorrelations(cc);
		return i;
	}

	private Assign genIdInit(String processName, Operation genIdOperation, Variable inputVar) {
		Assign assignBefore = BPELFactory.eINSTANCE.createAssign();
		assignBefore.setName("IdGenerationConfiguration");
		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		To t = createToPart(inputVar, genIdOperation);
		f.setLiteral(ExecutableTransUtil.
				createDefaultInitializer(t.getVariable(), t.getPart(), 
				new String[0]));
		c.setFrom(f);
		c.setTo(t);
		
		Copy c1 = createCopyRole(processName, genIdOperation, inputVar);
		assignBefore.getCopy().add(c);
		assignBefore.getCopy().add(c1);
		return assignBefore;
	}
	
	protected Copy createCopyRole(String processName, Operation genIdOperation, Variable inputVar) {
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'" + processName + "'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("processName");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		t.setPart((Part) genIdOperation.getInput().getMessage().getPart("parameters"));

		c.setFrom(f);
		c.setTo(t);
		return c;
	}
	
	private To createToPart(Variable inputVar, Operation inputOperation) {
		To t = BPELFactory.eINSTANCE.createTo();
		t.setVariable(inputVar);
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		return t;
	}

	public Assign getAssign() {
		return assignBefore;
	}
	
	public Invoke getInvoke() {
		return i;
	}

}
