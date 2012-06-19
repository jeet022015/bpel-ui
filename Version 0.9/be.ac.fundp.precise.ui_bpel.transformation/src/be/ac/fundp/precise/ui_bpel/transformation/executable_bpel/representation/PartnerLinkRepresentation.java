package be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.representation;

import javax.wsdl.PortType;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypeFactory;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.wst.wsdl.Definition;

/**
 * The Class PartnerLinkRepresentation.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class PartnerLinkRepresentation {
	
	/** The partner link. */
	private PartnerLink partnerLink;
	
	/** The partner link type. */
	private PartnerLinkType partnerLinkType;
	
	/** The role. */
	private Role role;
	
	/** The my wsdl definition. */
	private Definition myWsdlDefinition;
	
	/** The process wsdl definition. */
	private Definition processWsdlDefinition;
	
	/** The service name. */
	private String serviceName;
	
	/**
	 * Instantiates a new partner link representation.
	 *
	 * @param partnerLinkName the partner link name
	 * @param partnerLinkTypeName the partner link type name
	 * @param roleName the role name
	 * @param myWsdlDefinition the my wsdl definition
	 * @param serviceName2 the service name2
	 * @param processWsdlDefinition the process wsdl definition
	 * @param isMyRole the is my role
	 */
	@SuppressWarnings("unchecked")
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
	
	/**
	 * Creates the partner link in process2.
	 *
	 * @param partnerLinkName the partner link name
	 * @return the partner link
	 */
	private PartnerLink createPartnerLinkInProcess2(String partnerLinkName) {
		String newPartnerName = partnerLinkName;
		PartnerLink partner = BPELFactory.eINSTANCE.createPartnerLink();
		partner.setName(newPartnerName);
		return partner;
	}
	
	/**
	 * Creates the partner link type in process.
	 *
	 * @param partnerLinkTypeName the partner link type name
	 * @return the partner link type
	 */
	private PartnerLinkType createPartnerLinkTypeInProcess(String partnerLinkTypeName) {
		PartnerLinkType plt = PartnerlinktypeFactory.eINSTANCE.createPartnerLinkType();
		plt.setName(partnerLinkTypeName);
		return plt;
	}
	
	/**
	 * Creates the role in process.
	 *
	 * @param roleName the role name
	 * @return the role
	 */
	private Role createRoleInProcess(String roleName) {
		Role role1 =  PartnerlinktypeFactory.eINSTANCE.createRole();
		role1.setName ( roleName );
		return role1;
	}
	
	/**
	 * Organize bpel element user event.
	 *
	 * @param isMyRole the is my role
	 */
	private void organizeBpelElementUserEvent(boolean isMyRole) {
		//FIXME create correct names
		PortType pt = null;
		for (Object portType : myWsdlDefinition.getPortTypes().keySet()) {
			QName t = (QName)portType;
			System.out.println("serviceName:"+serviceName);
			System.out.println("t:"+t.getLocalPart());
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

	/**
	 * Gets the partner link.
	 *
	 * @return the partner link
	 */
	public PartnerLink getPartnerLink() {
		return partnerLink;
	}

}
