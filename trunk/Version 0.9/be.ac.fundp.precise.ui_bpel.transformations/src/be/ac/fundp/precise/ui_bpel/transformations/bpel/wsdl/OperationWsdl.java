package be.ac.fundp.precise.ui_bpel.transformations.bpel.wsdl;

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.messageproperties.MessagepropertiesFactory;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.bpel.model.messageproperties.Query;
import org.eclipse.bpel.ui.util.XSDUtils;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.ExtensibilityElement;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDTypeDefinition;

abstract class OperationWsdl {

	@SuppressWarnings("unchecked")
	protected void createPropertyAlias(javax.wsdl.Message message,
			Definition processWSDl, String element, Property property) {
		boolean hasProperty = verifyProperty(message, element);
		if (!hasProperty)
			return;
		PropertyAlias myPA = MessagepropertiesFactory.eINSTANCE
				.createPropertyAlias();
		myPA.setMessageType(message);
		myPA.setPart("parameters");
		myPA.setPropertyName(property);

		// The query
		String query = "";
		String prefix = processWSDl.getPrefix("test");
		if (prefix != null)
			query = query + "/" + prefix + ":" + element;
		else
			query = query + "/" + element;
		Query q = MessagepropertiesFactory.eINSTANCE.createQuery();
		q.setValue(query);
		myPA.setQuery(q);
		processWSDl.getEExtensibilityElements().add(myPA);
	}

	private boolean verifyProperty(javax.wsdl.Message message, String elementName) {
		try {
			for (Object element1 : message.getParts().values()) {
				Part p = (Part)element1;
				XSDElementDeclaration elementDec = p.getElementDeclaration();
				//Anonymous type
				XSDTypeDefinition elementType = elementDec.getType();
				XSDParticle complexTyep = elementType.getComplexType();
				XSDModelGroup sequence = (XSDModelGroup)complexTyep.getContent();;
				for (XSDParticle innerElement : sequence.getParticles()) {
					XSDElementDeclaration innerElement1 = (XSDElementDeclaration) innerElement.getContent();
					if (innerElement1.getAliasName().equals(elementName)) {
						return true;
					}
				}
	
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	protected Property createStringProperty(Definition processWSDl,
			String prefix, String propertyName) {
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
	protected Property getProperty(Definition processWSDl, String propertyName) {
		for (Iterator<ExtensibilityElement> iterator = processWSDl
				.getEExtensibilityElements().iterator(); iterator.hasNext();) {
			ExtensibilityElement element = iterator.next();
			if (element instanceof Property) {
				Property p = (Property) element;
				if (p.getName().equalsIgnoreCase(propertyName))
					return p;
			}

		}
		return null;
	}
}
