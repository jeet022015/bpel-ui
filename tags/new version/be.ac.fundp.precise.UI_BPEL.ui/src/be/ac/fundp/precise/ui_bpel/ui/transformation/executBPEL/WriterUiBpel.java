package be.ac.fundp.precise.ui_bpel.ui.transformation.executBPEL;

import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.proxy.OperationProxy;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.PortType;
import org.w3c.dom.Element;

import be.ac.fundp.precise.ui_bpel.ui.transformation.executBPEL.stubs.MessageStub;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

public class WriterUiBpel extends BPELWriter {

	//private Process process;
	private PartnerLink pl;
	private Variable inputVar;
	private Operation outputOperation;
	private Operation selectionOperation;
	private Operation inputOperation;
	private PortType portType;

	public WriterUiBpel(Process process) {
		super();
		inputVar = BPELFactory.eINSTANCE.createVariable();
		inputVar.setName("inputVar");
		Message message = new MessageStub();
		inputVar.setMessageType(message);
		//this.process = process;
	}

	protected Element variables2XML(Variables variables) {
		//TODO Deal with element here
		//ElementStub message = new ElementStub();
		//inputVar.setElement((Element) message);
		variables.getChildren().add(inputVar);
		return super.variables2XML(variables);
	}

	protected Element partnerLinks2XML(PartnerLinks partnerLinks) {
		if (!partnerLinks.getChildren().isEmpty()) {
			for (PartnerLink partnerLink : partnerLinks.getChildren()) {
				PortType f = partnerLink.getPartnerRole() != null ? (PortType) partnerLink
						.getPartnerRole().getPortType() : null;
				if (f != null
						&& f.getQName()
								.getNamespaceURI()
								.equals("http://www.example.org/UI_BPEL-Mediator/")) {
					pl = partnerLink;
					portType = (PortType) pl.getPartnerRole().getPortType();
					outputOperation = new OperationProxy(URI.createURI("ns"),
							portType, "dataOutputUI");
					selectionOperation = new OperationProxy(
							URI.createURI("ns"), portType, "dataSelectionUI");
					inputOperation = new OperationProxy(URI.createURI("ns"),
							portType, "dataInputUI");
				}
			}
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

		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("MyInvoke");
		i.setPartnerLink(pl);
		i.setInputVariable(activity.getOutputVariable());
		i.setOperation(outputOperation);

		Assign a = BPELFactory.eINSTANCE.createAssign();
		a.setName("MyAssign");

		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'test'");
		f.setExpression(e);
		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage("urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0");
		toQuery.setValue("role");
		t.setQuery(toQuery);
		t.setVariable(activity.getOutputVariable());
		// Message message = activity.getOutputVariable().getMessageType();
		// Part p = new PartStub(c.eResource(),
		// message, "parameters");
		// t.setPart(p);
		c.setFrom(f);
		c.setTo(t);
		a.getCopy().add(c);

		s.getActivities().add(a);
		s.getActivities().add(i);

		return super.sequence2XML(s);
	}

	private Element dealWithDataSelectionUI(DataSelectionUI activity) {
		Sequence s = BPELFactory.eINSTANCE.createSequence();

		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("MyInvoke");
		i.setPartnerLink(pl);
		i.setInputVariable(activity.getInputVariable());
		i.setOutputVariable(activity.getOutputVariable());
		i.setOperation(selectionOperation);
		i.setPortType(portType);

		Assign a = BPELFactory.eINSTANCE.createAssign();
		a.setName("MyAssign");

		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'test'");
		f.setExpression(e);
		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage("urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0");
		toQuery.setValue("role");
		t.setQuery(toQuery);
		t.setVariable(activity.getInputVariable());
		// Message message = activity.getOutputVariable().getMessageType();
		// Part p = new PartStub(c.eResource(),
		// message, "parameters");
		// t.setPart(p);
		c.setFrom(f);
		c.setTo(t);
		a.getCopy().add(c);

		s.getActivities().add(a);
		s.getActivities().add(i);

		return super.sequence2XML(s);
	}

	private Element dealWithDataInputUI(DataInputUI activity) {
		Sequence s = BPELFactory.eINSTANCE.createSequence();

		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("MyInvoke");
		i.setPartnerLink(pl);
		i.setInputVariable(inputVar);
		i.setOutputVariable(activity.getInputVariable());
		i.setOperation(inputOperation);
		i.setPortType(portType);

		Assign a = BPELFactory.eINSTANCE.createAssign();
		a.setName("MyAssign");

		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'test'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage("urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0");
		toQuery.setValue("role");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		// Message message = activity.getInputVariable().getMessageType();
		// Part p = new PartStub(c.eResource(),
		// message, "parameters");
		// t.setPart(p);
		c.setFrom(f);
		c.setTo(t);
		a.getCopy().add(c);

		s.getActivities().add(a);
		s.getActivities().add(i);

		return super.sequence2XML(s);
	}
}
