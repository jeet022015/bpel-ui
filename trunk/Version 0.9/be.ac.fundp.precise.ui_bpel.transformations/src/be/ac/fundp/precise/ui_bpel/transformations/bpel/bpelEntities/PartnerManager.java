package be.ac.fundp.precise.ui_bpel.transformations.bpel.bpelEntities;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.wst.wsdl.Definition;

import be.ac.fundp.precise.ui_bpel.transformations.bpel.WSDLImportHelperUI;

public class PartnerManager {

	private Definition baseWsdl;

	Map<String, PartnerEntity> partnerMap = new HashMap<String, PartnerEntity>();
	
	public PartnerManager(Definition baseWsdl) {
		this.baseWsdl = baseWsdl;
	}

	public void addPartner(String partnerName,
			boolean isMyRole, Definition partnerDefinition) throws IOException {
		if (!baseWsdl.getImports().keySet()
				.contains(partnerDefinition.getTargetNamespace())) {
			WSDLImportHelperUI.addImportAndNamespace(baseWsdl,
					partnerDefinition);
			baseWsdl.eResource().save(Collections.emptyMap());
			System.out.println("added");
		}
		PartnerEntity entity = new PartnerEntity(partnerName,
				isMyRole, partnerDefinition, baseWsdl);
		partnerMap.put(partnerName, entity);
	}

	public Collection<PartnerEntity> getPartners() {
		return partnerMap.values();
	}

	public PartnerEntity getPartner(String partnerId) {
		return partnerMap.get(partnerId);
	}

}
