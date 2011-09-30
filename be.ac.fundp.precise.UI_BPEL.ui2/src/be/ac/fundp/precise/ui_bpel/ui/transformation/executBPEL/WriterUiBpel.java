package be.ac.fundp.precise.ui_bpel.ui.transformation.executBPEL;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;
import org.w3c.dom.Element;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

public class WriterUiBpel extends BPELWriter {

	private BpelUIUtil bpel;
	
	public WriterUiBpel(Process process, IResource iFile) {
		super();
		//FIXME choose better names
		String arg1 = "";
		String arg2 = "";
		bpel = BpelUIUtil.getInstace();
		for (Import processImp : process.getImports()) {
			if (process.getTargetNamespace().equals(processImp.getNamespace())){
				IFolder folder = (IFolder) iFile.getParent();
				IFile file = folder.getFile(processImp.getLocation());
				arg1 = file.getFullPath().toString();
				file = folder.getFile("UI_ManagerServices.wsdl");
				arg2 = file.getFullPath().toString();
			}
		}
		bpel.configureProcess(arg1, arg2, process);
	}
	
	public void write(BPELResource resource, OutputStream out, Map<?, ?> args)
			throws IOException {
		super.write(resource, out, args);
		bpel.importNewWSDL();
	}
	
	protected Element process2XML(Process process) {
		if (!process.getImports().contains(bpel.getImportBPEL())) {
			process.getImports().add(bpel.getImportBPEL());
		}
		return super.process2XML(process);
	}

	protected Element variables2XML(Variables variables) {
		variables.getChildren().addAll(bpel.getUiVariables());
		return super.variables2XML(variables);
	}

	protected Element partnerLinks2XML(PartnerLinks partnerLinks) {
		if (!partnerLinks.getChildren().contains(bpel.getPartnerLinkBPEL())) {
			partnerLinks.getChildren().add(bpel.getPartnerLinkBPEL());
		}
		return super.partnerLinks2XML(partnerLinks);
	}

	protected Element extensionActivity2XML(ExtensionActivity activity) {

		if (activity instanceof DataSelectionUI) {
			return dealWithDataSelectionUI((DataSelectionUI) activity);
		} else if (activity instanceof DataOutputUI) {
			return dealWithDataOutputUI((DataOutputUI) activity);
		} else if (activity instanceof DataInputUI) {
			return dealWithDataInputUI((DataInputUI) activity);
		}

		return super.extensionActivity2XML(activity);
	}
	
//	protected Element assign2XML(Assign activity) {
//		System.out.println("Assign Activity = " + activity);
//		return super.assign2XML(activity);
//	}

	private Element dealWithDataOutputUI(DataOutputUI activity) {

		Sequence s = BPELFactory.eINSTANCE.createSequence();
		
		Variable[] vars = bpel.getVariableForDataInt(activity);
		
		Variable inputVar = vars[0];
		
		String prefix = BPELUtils.getNamespacePrefix(inputVar, inputVar.getMessageType().getQName().getNamespaceURI());

		Assign assignbBefore = BPELFactory.eINSTANCE.createAssign();
		assignbBefore.setName("DataOutputConfiguration");
		
		Operation inputOperation = bpel.getOutputOperation();
		
		//================== Initialization =====================

		Copy initCopy = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		String dataItensLiteral= "";
		for (int i = 0; i < activity.getOutputItem().size(); i++) {
			dataItensLiteral += InitializationContants.DATA_ITEM;
		}
		
		final String literalExpr = InitializationContants.OUTPUT_HEAD + 
				InitializationContants.COMMON_BODY+
				InitializationContants.DATA_HEAD +
					dataItensLiteral +
				InitializationContants.DATA_TAIL +
				InitializationContants.OUTPUT_TAIL;
		
		f.setLiteral(literalExpr);

		To t = createToPart(inputVar, inputOperation);
		initCopy.setFrom(f);
		initCopy.setTo(t);
		
		//================== ROLE =====================
		String role = activity.getRoles().size() > 1 ? activity.getRoles().get(0) : "roleDefault";

		Copy roleCopy = createCopyRole(inputVar, prefix, inputOperation, role);
		
		//================== ID =====================
		
		Copy idCoppy = createCopyId(activity.getId(), inputVar, prefix, inputOperation);
		
		//================== COPY DATA ITEM =====================
		int cont = 1;
		List<Copy> dataItemCopies = new LinkedList<Copy>();
		for (DataItem di : activity.getOutputItem()) {
			Part p = (Part) inputOperation.getInput().getMessage().getPart("parameters");
			Copy c = createDataItemBeforeCopy(inputVar, prefix, p, cont, di, "data", "data");
			dataItemCopies.add(c);
			cont++;
		}

		//================== Configuring the ASSIGN BEFORE =====================
		
		assignbBefore.getCopy().add(initCopy);
		assignbBefore.getCopy().add(roleCopy);
		assignbBefore.getCopy().add(idCoppy);
		assignbBefore.getCopy().addAll(dataItemCopies);
		
		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataOutput");
		i.setInputVariable(inputVar);
		i.setOperation(inputOperation);
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		
		//================== Configuring the SEQUENCE =====================
		s.getActivities().add(assignbBefore);
		s.getActivities().add(i);

		return super.sequence2XML(s);
	}

	private Copy createDataItemBeforeCopy(Variable inputVar, String prefix,
			Part p, int cont, DataItem di, String primaryNode, String secondaryNode) {
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		String expression = "$"+di.getVariable().getName();
		Expression fromExpr = BPELFactory.eINSTANCE.createExpression();
		f.setExpression(fromExpr);
		fromExpr.setBody(expression);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+":"+primaryNode+"["+cont+"]/"+prefix+":"+secondaryNode);
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		t.setPart(p);
		
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

	private Copy createCopyId(String id, Variable inputVar,
			String prefix, Operation inputOperation) {		
		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+id+"'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+":id");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		//FIXME Get the name from some other way or create a constant
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	private Copy createCopyRole(Variable inputVar, String prefix,
			Operation inputOperation, String role) {
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+role+"'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+":role");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		//FIXME Get the name from some other way or create a constant
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	private Element dealWithDataSelectionUI(DataSelectionUI activity) {
		Sequence s = BPELFactory.eINSTANCE.createSequence();
		
		Variable[] vars = bpel.getVariableForDataInt(activity);
		
		Variable inputVar = vars[0].getName().startsWith(BpelUIUtil.DATA_SELECTION_REQUEST) ? vars[0] : vars[1];
		Variable outputVar = vars[0].getName().startsWith(BpelUIUtil.DATA_SELECTION_REPONSE) ? vars[0] : vars[1];

		Assign assignBefore = BPELFactory.eINSTANCE.createAssign();
		assignBefore.setName("DataSelectionConfiguration");
		
		String prefix = BPELUtils.getNamespacePrefix(inputVar, inputVar.getMessageType().getQName().getNamespaceURI());
		
		Operation inputOperation = bpel.getSelectionOperation();
		
		//================== Initialization =====================

		Copy initCopy = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		String dataItensLiteral= "";
		for (int i = 0; i < activity.getInputItem().size(); i++)
			dataItensLiteral += InitializationContants.DATA_ITEM;
		
		final String literalExpr = InitializationContants.SELECTION_HEAD + 
				InitializationContants.COMMON_BODY+
				InitializationContants.DATA_HEAD +
					dataItensLiteral +
				InitializationContants.DATA_TAIL +
				InitializationContants.SELECTION_TAIL;
		
		f.setLiteral(literalExpr);

		To t = createToPart(inputVar, inputOperation);
		initCopy.setFrom(f);
		initCopy.setTo(t);
		assignBefore.getCopy().add(initCopy);
		
		//================== ROLE =====================
		String role = activity.getRoles().size() > 1 ? activity.getRoles().get(0) : "roleDefault";

		Copy roleCopy = createCopyRole(inputVar, prefix, inputOperation, role);
		assignBefore.getCopy().add(roleCopy);
		
		//================== ID =====================
		Copy idCoppy = createCopyId(activity.getId(), inputVar, prefix, inputOperation);
		assignBefore.getCopy().add(idCoppy);
		
		//================== COPY DATA ITEM =====================
		int cont = 1;
		List<Copy> dataItemCopiesBefore = new LinkedList<Copy>();
		for (DataItem di : activity.getInputItem()) {
			Part p = (Part) inputOperation.getInput().getMessage().getPart("parameters");
			Copy c = createDataItemBeforeCopy(inputVar, prefix, p, cont, di, "data", "data");
			dataItemCopiesBefore.add(c);
			cont++;
		}
		
		if (dataItemCopiesBefore.size() > 0)
			assignBefore.getCopy().addAll(dataItemCopiesBefore);

		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataSelection");
		i.setInputVariable(inputVar);
		i.setOutputVariable(outputVar);
		i.setOperation(inputOperation);
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		
		//================== COPY DATA ITEM =====================
		List<Copy> dataItemCopiesAfter = new LinkedList<Copy>();
		cont = 1;
		for (DataItem di : activity.getOutputItem()) {
			Part p = (Part) inputOperation.getOutput().getMessage().getPart("parameters");
			Copy c = createDataItemCopy(outputVar, prefix, p, cont, di, "return", "data");
			cont++;
			dataItemCopiesAfter.add(c);
		}
		
		s.getActivities().add(assignBefore);
		s.getActivities().add(i);
		
		if (dataItemCopiesAfter.size() > 0) {
			Assign after = BPELFactory.eINSTANCE.createAssign();
			after.setName("ResponseToDataItems");
			after.getCopy().addAll(dataItemCopiesAfter);
			s.getActivities().add(after);
		}

		return super.sequence2XML(s);
	}

	private Element dealWithDataInputUI(DataInputUI activity) {
		
		Sequence s = BPELFactory.eINSTANCE.createSequence();
		
		Variable[] vars = bpel.getVariableForDataInt(activity);
		
		Variable inputVar = vars[0].getName().startsWith(BpelUIUtil.DATA_INPUT_REQUEST) ? vars[0] : vars[1];
		Variable outputVar = vars[0].getName().startsWith(BpelUIUtil.DATA_INPUT_REPONSE) ? vars[0] : vars[1];
		
		String prefix = BPELUtils.getNamespacePrefix(inputVar, inputVar.getMessageType().getQName().getNamespaceURI());

		Assign assignBefore = BPELFactory.eINSTANCE.createAssign();
		assignBefore.setName("DataInputConfiguration");
		
		Operation inputOperation = bpel.getInputOperation();
		
		//================== Initialization =====================

		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		String literalExpr = InitializationContants.INPUT_HEAD + 
				InitializationContants.COMMON_BODY+
				InitializationContants.INPUT_TAIL;
		f.setLiteral(literalExpr);

		To t = createToPart(inputVar, inputOperation);
		c.setFrom(f);
		c.setTo(t);
		assignBefore.getCopy().add(c);
				
		//================== ROLE =====================
		String role = activity.getRoles().size() > 1 ? activity.getRoles().get(0) : "roleDefault";

		c = createCopyRole(inputVar, prefix, inputOperation, role);
		assignBefore.getCopy().add(c);
		
		//================== ID =====================
		
		Copy idCoppy = createCopyId(activity.getId(), inputVar, prefix, inputOperation);
		assignBefore.getCopy().add(idCoppy);

		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataInput");
		i.setInputVariable(inputVar);
		i.setOutputVariable(outputVar);
		i.setOperation(inputOperation);
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		
		//================== COPY DATA ITEM =====================
		List<Copy> copies = new LinkedList<Copy>();
		int cont = 1;
		for (DataItem di : activity.getInputItem()) {
			Part p = (Part) inputOperation.getOutput().getMessage().getPart("parameters");
			c = createDataItemCopy(outputVar, prefix, p, cont, di, "return", "data");
			cont++;
			copies.add(c);
		}
		
		//================== Configuring the SEQUENCE =====================
		s.getActivities().add(assignBefore);
		s.getActivities().add(i);
		
		if (copies.size() > 0) {
			Assign assignaAfter = BPELFactory.eINSTANCE.createAssign();
			assignaAfter.setName("ResponseToDataItems");
			assignaAfter.getCopy().addAll(copies);
			s.getActivities().add(assignaAfter);
		}

		return super.sequence2XML(s);
	}

	private Copy createDataItemCopy(Variable outputVar, String prefix,
			Part part, int cont, DataItem di, String primaryNode, String secondaryNode) {
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+":"+primaryNode+"["+cont+"]/"+prefix+":"+secondaryNode);
		f.setQuery(toQuery);
		f.setVariable(outputVar);
		f.setPart(part);

		To t = BPELFactory.eINSTANCE.createTo();
		t.setVariable(di.getVariable());
		
		c.setFrom(f);
		c.setTo(t);
		return c;
	}
}
