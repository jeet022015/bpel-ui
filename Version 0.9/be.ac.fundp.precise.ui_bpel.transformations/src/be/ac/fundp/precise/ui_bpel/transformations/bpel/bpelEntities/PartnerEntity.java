package be.ac.fundp.precise.ui_bpel.transformations.bpel.bpelEntities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.emf.common.util.URI;
import org.eclipse.wst.wsdl.BindingOperation;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.ExtensibilityElement;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Port;
import org.eclipse.wst.wsdl.Service;
import org.eclipse.wst.wsdl.util.WSDLConstants;

public class PartnerEntity {

	private PartnerLink partnerLink;

	private Import partnerImport;

	private Definition processDefinition;

	private Map<String, Operation> operationMap;

	public PartnerEntity(String partnerName, boolean isMyRole,
			Definition partnerDefinition, Definition baseDefinition)
			throws IOException {
		processDefinition = baseDefinition;

		partnerLink = createPartnerLink(partnerName);
		partnerImport = createImport(partnerDefinition);

		PartnerLinkType partnerLinkType = getPartnerLinkType(partnerName
				+ "PartternLink", baseDefinition);
		Role role = partnerLinkType.getRole().get(0);

		partnerLink.setPartnerLinkType(partnerLinkType);

		if (isMyRole) {
			partnerLink.setMyRole(role);
		} else {
			partnerLink.setPartnerRole(role);
		}

		operationMap = getWsdlOperations(partnerDefinition);
	}

	@SuppressWarnings("unchecked")
	private PartnerLinkType getPartnerLinkType(String partnerLinkType,
			Definition processDefinition) {
		for (Iterator<ExtensibilityElement> iterator = processDefinition
				.getEExtensibilityElements().iterator(); iterator.hasNext();) {
			ExtensibilityElement element = iterator.next();
			if (element instanceof PartnerLinkType) {
				PartnerLinkType p = (PartnerLinkType) element;
				if (p.getName().equalsIgnoreCase(partnerLinkType))
					return p;
			}

		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private Property readProperty(Definition partnerDefinition, String property) {
		for (Iterator<ExtensibilityElement> iterator = partnerDefinition
				.getEExtensibilityElements().iterator(); iterator.hasNext();) {
			ExtensibilityElement element = iterator.next();
			if (element instanceof Property) {
				Property p = (Property) element;
				// if (p.getName().equalsIgnoreCase("propertyId"))
				if (p.getName().equalsIgnoreCase(property))
					return p;
			}

		}
		return null;
	}

	private Map<String, Operation> getWsdlOperations(
			Definition partnerDefinition) {
		Map<String, Operation> operations = new HashMap<String, Operation>();
		Service s1 = (Service) partnerDefinition.getEServices().get(0);
		Port p1 = (Port) s1.getEPorts().get(0);
		for (Object op : p1.getBinding().getBindingOperations()) {
			BindingOperation opera = (BindingOperation) op;
			operations.put(opera.getName(), opera.getEOperation());
		}
		return operations;
	}

	private Import createImport(Definition partnerDefinition) {
		Import imp = BPELFactory.eINSTANCE.createImport();

		String t = partnerDefinition.getTargetNamespace();
		if (t != null)
			imp.setNamespace(t);
		URI schemaURI = URI.createPlatformPluginURI(
				partnerDefinition.getLocation(), true);
		imp.setLocation(schemaURI.lastSegment());
		imp.setImportType(WSDLConstants.WSDL_NAMESPACE_URI);
		return imp;
	}

	private PartnerLink createPartnerLink(String partnerLinkName) {
		String newPartnerName = partnerLinkName;
		PartnerLink partner = BPELFactory.eINSTANCE.createPartnerLink();
		partner.setName(newPartnerName);
		return partner;
	}

	public PartnerLink getPartnerLink() {
		return partnerLink;
	}

	public Import getImport() {
		return partnerImport;
	}

	public Operation getOperation(String operationName) {
		return operationMap.get(operationName);
	}

	public Property getProperty(String propertyId) {
		return readProperty(processDefinition, propertyId);
	}
}
