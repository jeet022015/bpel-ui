package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.manager;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.messageproperties.MessagepropertiesFactory;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.bpel.model.messageproperties.Query;
import org.eclipse.bpel.ui.util.XSDUtils;
import org.eclipse.wst.wsdl.BindingOperation;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Port;
import org.eclipse.wst.wsdl.Service;

public class GeneratorOperationManager {

	private Operation genIdOperation;
	private Property propertyProcessId;
	private Variable inputVar;
	private Variable outputVar;
	private CorrelationSet correlationSet;

	public GeneratorOperationManager(Definition uibpelWsdl,
			Definition processWSDl) {
		genIdOperation = getGenIdOperation(uibpelWsdl);
		propertyProcessId = createProperty(processWSDl, "psid", "processId");
		createPropertyAlias(genIdOperation.getOutput().getMessage(), processWSDl, "processId", propertyProcessId);
		createGenIdVars();
		correlationSet = createCorrelationSets();
	}

	@SuppressWarnings("unchecked")
	private Property createProperty(Definition processWSDl, String prefix, String propertyName) {
		Property property = MessagepropertiesFactory.eINSTANCE.createProperty();
		property.setType(XSDUtils.getPrimitive("string"));
		QName qname = new QName(prefix, propertyName);
		property.setQName(qname);
		property.setName(propertyName);
		property.setEnclosingDefinition(processWSDl);
		processWSDl.getEExtensibilityElements().add(property);
		return property;
	}
	
	@SuppressWarnings("unchecked")
	private void createPropertyAlias(javax.wsdl.Message message, Definition processWSDl, String element, Property property) {
		PropertyAlias myPA = MessagepropertiesFactory.eINSTANCE.createPropertyAlias();
		myPA.setMessageType(message);
		myPA.setPart("parameters");
		myPA.setPropertyName(property);
		
		//The query
		String query = "";
		String prefix = processWSDl.getPrefix("test");
		if (prefix!=null)
			query = query + "/" + prefix + ":" + element;
		else
			query = query + "/" + element;
		Query q = MessagepropertiesFactory.eINSTANCE.createQuery();
		q.setValue(query);
		myPA.setQuery(q);
		processWSDl.getEExtensibilityElements().add(myPA);
	}

	protected Operation getGenIdOperation(Definition uibpelWsdl) {
		Service s1 = (Service) uibpelWsdl.getEServices().get(0);
		Port p1 = (Port) s1.getEPorts().get(0);
		for (Object op : p1.getBinding().getBindingOperations()) {
			BindingOperation opera = (BindingOperation) op;
			if (opera.getName().equals("generateProcessId"))
				return opera.getEOperation();
		}
		return null;
	}
	
	protected void createGenIdVars() {
		inputVar = BPELFactory.eINSTANCE.createVariable();
		inputVar.setName("operationProcessIdRequest");
		inputVar.setMessageType((Message) genIdOperation.getInput()
				.getMessage());
		outputVar = BPELFactory.eINSTANCE.createVariable();
		outputVar.setName("operationProcessIdResponse");
		outputVar.setMessageType((Message) genIdOperation.getOutput()
				.getMessage());
	}
	
	private CorrelationSet createCorrelationSets() {
		CorrelationSet correlationSet = BPELFactory.eINSTANCE.createCorrelationSet();
		correlationSet.setName("genIdCorrelationSet");
		correlationSet.getProperties().add(propertyProcessId);
		return correlationSet;
	}

	public Property getProperty() {
		return propertyProcessId;
	}
	
	public CorrelationSet getCorrelationSet() {
		return correlationSet;
	}

	public Operation getOperation() {
		return genIdOperation;
	}

	public Variable getInputVar() {
		return inputVar;
	}
	
	public Variable getOutputVar() {
		return outputVar;
	}
}
