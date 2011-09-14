package be.ac.fundp.precise.ui_bpel.ui.transformation.executBPEL;

import javax.wsdl.PortType;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypeFactory;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.resource.BPELResourceSetImpl;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.util.WSDLConstants;
import org.w3c.dom.Element;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

public class WriterUiBpel extends BPELWriter {

	private static final String SERVICE_NAME = "CurrencyConvertorSoap";
	private PartnerLink pl;
	private Variable inputVar;
	private Operation outputOperation;
	private Operation selectionOperation;
	private Operation inputOperation;
	private Process process;
	private Definition wsdlDefinition;
	private String path = "file:/Users/Neto/Documents/workspaceBPEL/AnotherService/CurrencyConvertor.wsdl";


	public WriterUiBpel(Process process) {
		super();
		this.process = process;
	}
	
	private Import attemptLoad ( ) {
		
		Import  fImport = null;
		// empty paths are ignored
		if (path.length() == 0) {
			return null;
		}
		

		URI uri = URI.createURI(path);
		//URI uri = URI.createFileURI( path );
		if (uri == null) {
			return null;
		}
		
		fImport = createImport( attemptLoad(uri, "wsdl") );
		
		return fImport;
		
	}
	
	private Import createImport(Object obj) {
		Import imp = null;
		if (obj instanceof Definition) {
			wsdlDefinition = (Definition)obj;
			imp = createImportFrom(wsdlDefinition);
		}
		return imp;
	}
	
	private Import createImportFrom (Definition defn) {
		
		Import imp = BPELFactory.eINSTANCE.createImport();
	
		// namespace
		String t = defn.getTargetNamespace();
		if (t != null) {
			imp.setNamespace( t );
		}
		// location
		Resource resource = process.eResource();
		URI schemaURI = URI.createURI( defn.getLocation() );
		imp.setLocation( schemaURI.deresolve(resource.getURI(),true,true,true).toString() );
		
		// importType (the WSDL kind)
		imp.setImportType(  WSDLConstants.WSDL_NAMESPACE_URI );
	
		return imp;		
	}

	private Object attemptLoad(URI uri, String kind) {

		Resource resource = null;
		try {
			BPELResourceSetImpl fHackedResourceSet = BPELUtils.slightlyHackedResourceSet(process);
			resource = fHackedResourceSet.getResource(uri, true, kind);
		} catch (Throwable t) {
			// BPELUIPlugin.log(t);
			return t;
		}

		// Bugzilla 324164
		if (resource!=null && resource.getErrors().isEmpty() && resource.isLoaded()) {
			return resource.getContents().get(0);
		}
		return null;
	}
	
	protected Element process2XML(Process process) {
		process.getImports().add(attemptLoad());
		return super.process2XML(process);
	}

	protected Element variables2XML(Variables variables) {
		variables.getChildren().add(inputVar);
		return super.variables2XML(variables);
	}

	protected Element partnerLinks2XML(PartnerLinks partnerLinks) {
		PartnerLink pl = createUIBPELPartnerLink();
		System.out.println(pl);
		return super.partnerLinks2XML(partnerLinks);
	}

	private PartnerLink createUIBPELPartnerLink() {
		
		PortType pt = null;
		for (Object portType : wsdlDefinition.getPortTypes().keySet()) {
			QName t = (QName)portType;
			if(t.getLocalPart().equals(SERVICE_NAME))
				pt = wsdlDefinition.getPortType(t);
		}
		//FIXME PUT CORRECT NAMES
		
		PartnerLink partner = BPELFactory.eINSTANCE.createPartnerLink();
		
		String newPartnerName = "name";
		newPartnerName = BPELUtil.generateUniqueModelName(process, newPartnerName, partner);
		PartnerLinkType plt = PartnerlinktypeFactory.eINSTANCE.createPartnerLinkType();
		plt.setName( "PartnerLInkTypeName");
		
		Role role1 =  PartnerlinktypeFactory.eINSTANCE.createRole();
		role1.setName ( "RoleName" );
		role1.setPortType(pt);
		plt.getRole().add(role1);
		return partner;
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
		//i.setInputVariable(activity.getOutputVariable());
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
		//t.setVariable(activity.getOutputVariable());
		
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
		//i.setInputVariable(activity.getInputVariable());
		//i.setOutputVariable(activity.getOutputVariable());
		i.setOperation(selectionOperation);
		//i.setPortType(portType);

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
		//t.setVariable(activity.getInputVariable());
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
		//i.setOutputVariable(activity.getInputVariable());
		i.setOperation(inputOperation);
		//i.setPortType(portType);

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
		c.setFrom(f);
		c.setTo(t);
		a.getCopy().add(c);

		s.getActivities().add(a);
		s.getActivities().add(i);

		return super.sequence2XML(s);
	}
}
