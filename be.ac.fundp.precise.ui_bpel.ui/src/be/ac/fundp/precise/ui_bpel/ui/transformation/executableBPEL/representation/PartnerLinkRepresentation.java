package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.representation;

import javax.wsdl.PortType;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypeFactory;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.wst.wsdl.Definition;

public class PartnerLinkRepresentation {
	private PartnerLink partnerLink;
	private PartnerLinkType partnerLinkType;
	private Role role;
	private Definition myWsdlDefinition;
	private Definition processWsdlDefinition;
	private String serviceName;
	
	public PartnerLinkRepresentation(String partnerLinkName, String partnerLinkTypeName, String roleName, 
			Definition myWsdlDefinition, String serviceName2, Definition processWsdlDefinition, boolean isMyRole){
		partnerLink = createPartnerLinkInProcess2(partnerLinkName);
		partnerLinkType = createPartnerLinkTypeInProcess(partnerLinkTypeName);
		role = createRoleInProcess(roleName);
		serviceName = serviceName2;
		
		this.myWsdlDefinition = myWsdlDefinition;
		this.processWsdlDefinition = processWsdlDefinition;
		
		organizeBpelElementUserEvent(isMyRole);
		
		processWsdlDefinition.getEExtensibilityElements().add(partnerLinkType);
	}
	
	private PartnerLink createPartnerLinkInProcess2(String partnerLinkName) {
		String newPartnerName = partnerLinkName;
		PartnerLink partner = BPELFactory.eINSTANCE.createPartnerLink();
		partner.setName(newPartnerName);
		return partner;
	}
	
	private PartnerLinkType createPartnerLinkTypeInProcess(String partnerLinkTypeName) {
		PartnerLinkType plt = PartnerlinktypeFactory.eINSTANCE.createPartnerLinkType();
		plt.setName(partnerLinkTypeName);
		return plt;
	}
	
	private Role createRoleInProcess(String roleName) {
		Role role1 =  PartnerlinktypeFactory.eINSTANCE.createRole();
		role1.setName ( roleName );
		return role1;
	}
	
	private void organizeBpelElementUserEvent(boolean isMyRole) {
		//FIXME create correct names
		PortType pt = null;
		for (Object portType : myWsdlDefinition.getPortTypes().keySet()) {
			QName t = (QName)portType;
			//FIXME DEDUCT IT SERVICE_NAME
			if(t.getLocalPart().equals(serviceName)){
				pt = myWsdlDefinition.getPortType(t);
				//http://www.example.org/UI_BPEL-Mediator/
			}
		}
		
		//Role and PartnerLinkType
		role.setPortType(pt);
		partnerLinkType.getRole().add(role);
		partnerLinkType.setEnclosingDefinition(processWsdlDefinition);
		
		partnerLink.setPartnerLinkType(partnerLinkType);
		if(isMyRole){
			partnerLink.setMyRole(role);
		}else{
			partnerLink.setPartnerRole(role);
		}
	}

	public PartnerLink getPartnerLink() {
		return partnerLink;
	}

}
