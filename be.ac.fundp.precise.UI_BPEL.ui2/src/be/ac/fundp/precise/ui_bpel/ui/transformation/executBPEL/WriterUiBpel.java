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

	//private String path = "file:/Users/Neto/Documents/workspaceWebservice5/IManager/WebContent/WEB-INF/services/UI_ManagerWS/META-INF/UI_ManagerWS.wsdl";
	private BpelUIUtil bpel;
	//private Process p;
	
	public WriterUiBpel(Process process, IResource iFile) {
		super();
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
		//arg2 = path;
		bpel.configureProcess(arg1, arg2, process);
		//p = process;
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

	private Element dealWithDataOutputUI(DataOutputUI activity) {

		Sequence s = BPELFactory.eINSTANCE.createSequence();
		
		Variable[] vars = bpel.getVariableForDataInt(activity);
		
		Variable inputVar = vars[0];
		
		String prefix = BPELUtils.getNamespacePrefix(inputVar, inputVar.getMessageType().getQName().getNamespaceURI());

		Assign before = BPELFactory.eINSTANCE.createAssign();
		before.setName("DataOutputConfiguration");
		
		Operation inputOperation = bpel.getOutputOperation();
		
		//================== Initialization =====================

		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		final String NL = System.getProperty("line.separator");
		f.setLiteral("<ns:outputOperation xmlns:ns=\"http://fundp.ac.be\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +NL+
					 "   <ns:id>ns:id</ns:id>" + NL +
					 "   <ns:role>ns:role</ns:role>" + NL +
					 "   <ns:data>" + NL +
					 "        <ns:data xmlns:s1=\"http://www.w3.org/2001/XMLSchema-instance\" " + NL +
					 "            xmlns:s2=\"http://www.w3.org/2001/XMLSchema\" " + NL +
					 "            s1:type=\"s2:string\">data</ns:data>" + NL +
					 "        <ns:type>ns:type</ns:type>" + NL +
					 "        <ns:id>ns:id</ns:id>" + NL +
					 "   </ns:data>" + NL +
					 "</ns:outputOperation>");

		To t = BPELFactory.eINSTANCE.createTo();
		t.setVariable(inputVar);
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		c.setFrom(f);
		c.setTo(t);
		before.getCopy().add(c);
		
		//================== ROLE =====================
		String role = activity.getRoles().size() > 1 ? activity.getRoles().get(0) : "roleDefault";

		c = BPELFactory.eINSTANCE.createCopy();

		f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+role+"'");
		f.setExpression(e);

		t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+":role");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		c.setFrom(f);
		c.setTo(t);
		before.getCopy().add(c);
		
		//================== ID =====================
		c = BPELFactory.eINSTANCE.createCopy();

		f = BPELFactory.eINSTANCE.createFrom();
		e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+activity.getId()+"'");
		f.setExpression(e);

		t = BPELFactory.eINSTANCE.createTo();
		toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+":id");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		c.setFrom(f);
		c.setTo(t);
		before.getCopy().add(c);
		
		//================== COPY DATA ITEM =====================
		int cont = 1;
		for (DataItem di : activity.getOutputItem()) {
			c = BPELFactory.eINSTANCE.createCopy();

			f = BPELFactory.eINSTANCE.createFrom();
			f.setVariable(di.getVariable());
			
			t = BPELFactory.eINSTANCE.createTo();
			toQuery = BPELFactory.eINSTANCE.createQuery();
			toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
			toQuery.setValue(prefix+":data["+cont+"]/"+prefix+":data");
			t.setQuery(toQuery);
			t.setVariable(inputVar);
			t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));

			
			c.setFrom(f);
			c.setTo(t);
			before.getCopy().add(c);
			cont++;
		}

		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataOutput");
		i.setInputVariable(inputVar);
		i.setOperation(inputOperation);
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		
		s.getActivities().add(before);
		s.getActivities().add(i);

		return super.sequence2XML(s);
	}

	private Element dealWithDataSelectionUI(DataSelectionUI activity) {
		Sequence s = BPELFactory.eINSTANCE.createSequence();
		
		Variable[] vars = bpel.getVariableForDataInt(activity);
		
		Variable inputVar = vars[0].getName().startsWith(BpelUIUtil.DATA_SELECTION_REQUEST) ? vars[0] : vars[1];
		Variable outputVar = vars[0].getName().startsWith(BpelUIUtil.DATA_SELECTION_REPONSE) ? vars[0] : vars[1];

		Assign before = BPELFactory.eINSTANCE.createAssign();
		before.setName("DataInputConfiguration");
		
		Operation inputOperation = bpel.getSelectionOperation();
		
		//================== ROLE =====================
		String role = activity.getRoles().size() > 1 ? activity.getRoles().get(0) : "roleDefault";

		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+role+"'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("role");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		c.setFrom(f);
		c.setTo(t);
		before.getCopy().add(c);
		
		//================== ID =====================
		c = BPELFactory.eINSTANCE.createCopy();

		f = BPELFactory.eINSTANCE.createFrom();
		e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+activity.getId()+"'");
		f.setExpression(e);

		t = BPELFactory.eINSTANCE.createTo();
		toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("auiID");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		c.setFrom(f);
		c.setTo(t);
		before.getCopy().add(c);
		
		//================== COPY DATA ITEM =====================
		int cont = 1;
		for (DataItem di : activity.getInputItem()) {
			c = BPELFactory.eINSTANCE.createCopy();

			f = BPELFactory.eINSTANCE.createFrom();
			toQuery = BPELFactory.eINSTANCE.createQuery();
			toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
			toQuery.setValue("selectable["+cont+"]/data");
			f.setQuery(toQuery);
			f.setVariable(inputVar);
			f.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));

			t = BPELFactory.eINSTANCE.createTo();
			t.setVariable(di.getVariable());
			
			c.setFrom(f);
			c.setTo(t);
			cont++;
			before.getCopy().add(c);
		}

		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataSelection");
		i.setInputVariable(inputVar);
		i.setOutputVariable(outputVar);
		i.setOperation(inputOperation);
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		
		//================== COPY DATA ITEM =====================
		List<Copy> copies = new LinkedList<Copy>();
		cont = 1;
		for (DataItem di : activity.getOutputItem()) {
			c = BPELFactory.eINSTANCE.createCopy();

			f = BPELFactory.eINSTANCE.createFrom();
			toQuery = BPELFactory.eINSTANCE.createQuery();
			toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
			toQuery.setValue("selected["+cont+"]/:data");
			f.setQuery(toQuery);
			f.setVariable(outputVar);
			f.setPart((Part) inputOperation.getOutput().getMessage().getPart("parameters"));

			t = BPELFactory.eINSTANCE.createTo();
			t.setVariable(di.getVariable());
			
			c.setFrom(f);
			c.setTo(t);
			cont++;
			copies.add(c);
		}
		
		s.getActivities().add(before);
		s.getActivities().add(i);
		
		if (copies.size() > 0) {
			Assign after = BPELFactory.eINSTANCE.createAssign();
			after.setName("ResponseToDataItems");
			after.getCopy().addAll(copies);
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

		Assign before = BPELFactory.eINSTANCE.createAssign();
		before.setName("DataInputConfiguration");
		
		Operation inputOperation = bpel.getInputOperation();
		
		//================== Initialization =====================

		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		final String NL = System.getProperty("line.separator");
		f.setLiteral("<ns:inputOperation xmlns:ns=\"http://fundp.ac.be\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +NL+
					 "   <ns:id>ns:id</ns:id>" +NL+
					 "   <ns:role>ns:role</ns:role>" +NL+
					 "</ns:inputOperation>");

		To t = BPELFactory.eINSTANCE.createTo();
		t.setVariable(inputVar);
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		c.setFrom(f);
		c.setTo(t);
		before.getCopy().add(c);
		
		
		
		//================== ROLE =====================
		String role = activity.getRoles().size() > 1 ? activity.getRoles().get(0) : "roleDefault";

		c = BPELFactory.eINSTANCE.createCopy();

		f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+role+"'");
		f.setExpression(e);

		t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+":role");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		c.setFrom(f);
		c.setTo(t);
		before.getCopy().add(c);
		
		//================== ID =====================
		c = BPELFactory.eINSTANCE.createCopy();

		f = BPELFactory.eINSTANCE.createFrom();
		e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+activity.getId()+"'");
		f.setExpression(e);

		t = BPELFactory.eINSTANCE.createTo();
		toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+":id");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		c.setFrom(f);
		c.setTo(t);
		before.getCopy().add(c);

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
			c = BPELFactory.eINSTANCE.createCopy();

			f = BPELFactory.eINSTANCE.createFrom();
			toQuery = BPELFactory.eINSTANCE.createQuery();
			toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
			toQuery.setValue(prefix+":return["+cont+"]/"+prefix+":data");
			f.setQuery(toQuery);
			f.setVariable(outputVar);
			f.setPart((Part) inputOperation.getOutput().getMessage().getPart("parameters"));

			t = BPELFactory.eINSTANCE.createTo();
			t.setVariable(di.getVariable());
			
			c.setFrom(f);
			c.setTo(t);
			cont++;
			copies.add(c);
		}
		
		s.getActivities().add(before);
		s.getActivities().add(i);
		
		if (copies.size() > 0) {
			Assign after = BPELFactory.eINSTANCE.createAssign();
			after.setName("ResponseToDataItems");
			after.getCopy().addAll(copies);
			s.getActivities().add(after);
		}

		return super.sequence2XML(s);
	}
}
