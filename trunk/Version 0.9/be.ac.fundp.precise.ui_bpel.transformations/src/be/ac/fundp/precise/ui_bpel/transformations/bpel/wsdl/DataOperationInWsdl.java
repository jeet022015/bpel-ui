package be.ac.fundp.precise.ui_bpel.transformations.bpel.wsdl;

import java.io.IOException;

import javax.wsdl.PortType;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypeFactory;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Operation;

public class DataOperationInWsdl extends OperationWsdl {

	private Definition processWSDl;
	private Property propertyProcessId;
	private Property propertyInteractionId;

	public DataOperationInWsdl(Definition processWSDl) {
		this.processWSDl = processWSDl;
		propertyProcessId = getProperty(processWSDl, "processId");
		propertyInteractionId = getProperty(processWSDl, "interactionId");
		if (propertyProcessId == null)
			propertyProcessId = createStringProperty(processWSDl, "pid",
					"processId");
		if (propertyInteractionId == null)
			propertyInteractionId = createStringProperty(processWSDl, "intid",
					"interactionId");

	}

	@SuppressWarnings("unchecked")
	public void addPartnerLinkType(String partnerName,
			Definition patternDefinition) throws IOException {
		Role role = createRole(partnerName + "RoleName");

		PartnerLinkType plt = PartnerlinktypeFactory.eINSTANCE
				.createPartnerLinkType();
		plt.setName(partnerName + "PartternLink");
		plt.setEnclosingDefinition(processWSDl);

		PortType pt = getPortType(patternDefinition);
		role.setPortType(pt);
		plt.getRole().add(role);

		processWSDl.getEExtensibilityElements().add(plt);
	}

	private Role createRole(String roleName) {
		Role role1 = PartnerlinktypeFactory.eINSTANCE.createRole();
		role1.setName(roleName);
		return role1;
	}

	private PortType getPortType(Definition patternDefinition) {
		// FIXME always with only one Name?
		for (Object portType : patternDefinition.getPortTypes().keySet()) {
			QName t = (QName) portType;
			return patternDefinition.getPortType(t);
		}
		return null;
	}

	public void addDataOperation(Operation newDataOperation) {
		if (newDataOperation.getOutput() != null
				&& newDataOperation.getOutput().getMessage() != null) {
			createPropertyAlias(newDataOperation.getOutput().getMessage(),
					processWSDl, "processId", propertyProcessId);
			createPropertyAlias(newDataOperation.getOutput().getMessage(),
					processWSDl, "userInteracId", propertyInteractionId);
		}
		if (newDataOperation.getInput() != null
				&& newDataOperation.getInput().getMessage() != null) {
			createPropertyAlias(newDataOperation.getInput().getMessage(),
					processWSDl, "processId", propertyProcessId);
			createPropertyAlias(newDataOperation.getInput().getMessage(),
					processWSDl, "userInteracId", propertyInteractionId);
		}
	}
}
