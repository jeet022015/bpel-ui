package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.wsdl.PortType;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.ElseIf;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.model.If;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.RepeatUntil;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.While;
import org.eclipse.bpel.model.messageproperties.MessagepropertiesFactory;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.bpel.model.messageproperties.Query;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypeFactory;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.resource.BPELResourceSetImpl;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.util.XSDUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.wst.wsdl.BindingOperation;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.wst.wsdl.Port;
import org.eclipse.wst.wsdl.Service;
import org.eclipse.wst.wsdl.util.WSDLConstants;

import be.ac.fundp.precise.ui_bpel.ui.util.WSDLImportHelperUI;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataInteraction;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;
import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.PickUI;
import be.edu.fundp.precise.uibpel.model.ScopeUI;

public class BpelUIUtil {

	public static final String DATA_SELECTION_REPONSE = "dataSelectionResponse";
	public static final String DATA_SELECTION_REQUEST = "dataSelectionRequest";
	public static final String ON_USER_EVENT_DATA = "onUserEventData";
	public static final String DATA_OUTPUT_REQUEST = "dataOutputRequest";
	public static final String DATA_INPUT_REPONSE = "dataInputResponse";
	public static final String DATA_INPUT_REQUEST = "dataInputRequest";
	private static final String WSLD_NAME = "wsdl";
	private static final String SERVICE_NAME = "UiManager";
	private static final Object SERVICE_NAME_USER_EVENT = "UserEventListener";
	private Definition wsdl_ui_bpel;
	private Definition wsdl_user_event_listinner;
	private Definition processWSDl;
	private Import importBPEL;
	private Map<String, Set<Variable>> list;
	private Operation inputOperation;
	private Operation outputOperation;
	private Operation selectionOperation;
	private Operation eventOperation;
	private int selectionCount;
	private int inputCount;
	private int outputCount;
	private int eventCount;
	private Process p;
	private PartnerLink partnerLinkBPEL;
	private PartnerLink partnerLinkUserEvent;
	private PartnerLinkType partnerLinkTypeBPEL;
	private Role role;
	private PropertyAlias myPA;
	private Property propertyName;
	private Role roleEventListenner;
	private PartnerLinkType partnerLinkTypeUserEvent;

	private static BpelUIUtil instance;

	public static BpelUIUtil getInstace() {
		if (instance == null) {
			instance = new BpelUIUtil();
		}
		return instance;
	}

	private BpelUIUtil() {

	}

	public void configureProcess(String processWSDLPath,
			String ui_bpelWSDLPath, String userListnnerPath,  Process process) {

		if (p != null && p.equals(process))
			return;
		else
			p = process;

		URI uri = URI.createPlatformResourceURI(processWSDLPath, false);
		processWSDl = (Definition) attemptLoadWSDL(uri, process.eResource()
				.getResourceSet());

		//uri = URI.createURI(ui_bpelWSDLPath, false);
		uri = URI.createPlatformResourceURI(ui_bpelWSDLPath, false);
		wsdl_ui_bpel = (Definition) attemptLoadWSDL(uri, process.eResource()
				.getResourceSet());
		
		uri = URI.createPlatformResourceURI(userListnnerPath, false);
		wsdl_user_event_listinner = (Definition) attemptLoadWSDL(uri, process.eResource()
				.getResourceSet());
		
		list = new HashMap<String, Set<Variable>>();

		importBPEL = createImportInProcess();
		partnerLinkBPEL = createPartnerLinkInProcess2();
		partnerLinkUserEvent = createPartnerLinkUserEvent();
		partnerLinkTypeBPEL = createPartnerLinkTypeInProcess();
		partnerLinkTypeUserEvent = createPartnerLinkTypeUserEvent();
		role = createRoleInProcess();
		roleEventListenner = createUserEventRole();
		
		organizeBpelElement();
		organizeBpelElementUserEvent();
		createCorrelationSet();
		importNewWSDL();
		operationConfiguration();
		treatProcess(process.getActivity());
	}

	private PartnerLinkType createPartnerLinkTypeUserEvent() {
		PartnerLinkType plt = PartnerlinktypeFactory.eINSTANCE.createPartnerLinkType();
		plt.setName("ParnetLinkTypeUserEvent");
		return plt;
	}

	private Role createUserEventRole() {
		Role role1 =  PartnerlinktypeFactory.eINSTANCE.createRole();
		role1.setName ( "RoleUserEvent" );
		return role1;
	}

	private void organizeBpelElementUserEvent() {
		//FIXME create correct names
		PortType pt = null;
		for (Object portType : wsdl_user_event_listinner.getPortTypes().keySet()) {
			QName t = (QName)portType;
			//FIXME DEDUCT IT SERVICE_NAME
			if(t.getLocalPart().equals(SERVICE_NAME_USER_EVENT)){
				pt = wsdl_user_event_listinner.getPortType(t);
				//http://www.example.org/UI_BPEL-Mediator/
			}
		}
		
		//Role and PartnerLinkType
		roleEventListenner.setPortType(pt);
		partnerLinkTypeUserEvent.getRole().add(roleEventListenner);
		partnerLinkTypeUserEvent.setEnclosingDefinition(processWSDl);
		
		partnerLinkUserEvent.setPartnerLinkType(partnerLinkTypeUserEvent);
		partnerLinkUserEvent.setPartnerRole(roleEventListenner);
	}

	private PartnerLink createPartnerLinkUserEvent() {
		String newPartnerName = "PartnerLinkUserEvent";
		PartnerLink partner = BPELFactory.eINSTANCE.createPartnerLink();
		partner.setName(newPartnerName);
		return partner;
	}

	private void createCorrelationSet() {
		CorrelationSet myCS = BPELFactory.eINSTANCE.createCorrelationSet();
		
		Service s1 = (Service) wsdl_user_event_listinner.getEServices().get(0);
		Port p1 = (Port) s1.getEPorts().get(0);
		for (Object op : p1.getBinding().getBindingOperations()) {
			BindingOperation opera = (BindingOperation) op;
			if (opera.getName().equals("fireEvent")){
				eventOperation = opera.getEOperation();
			}
		}
		
		myPA = MessagepropertiesFactory.eINSTANCE.createPropertyAlias();
		myPA.setMessageType(eventOperation.getInput().getMessage());
		Part part = (Part) eventOperation.getInput().getMessage().getPart("parameters");

		myPA.setPart("parameters");
		propertyName = MessagepropertiesFactory.eINSTANCE.createProperty();
		propertyName.setType(XSDUtils.getPrimitive("string"));
		QName qname = new QName("test", "propertyName");
		propertyName.setQName(qname);
		propertyName.setName("propertyName");
		myPA.setPropertyName(propertyName);
		propertyName.setEnclosingDefinition(processWSDl);
		
		//The query
		String query = "";
		String prefix = processWSDl.getPrefix("test");
		if (prefix!=null)
			query = query + "/" + prefix + ":" + "processId";
		else
			query = query + "/" + "processId";
		Query q = MessagepropertiesFactory.eINSTANCE.createQuery();
		q.setValue(query);
		myPA.setQuery(q);
	}

	private void organizeBpelElement() {
		//FIXME create correct names
		PortType pt = null;
		for (Object portType : wsdl_ui_bpel.getPortTypes().keySet()) {
			QName t = (QName)portType;
			//FIXME DEDUCT IT SERVICE_NAME
			if(t.getLocalPart().equals(SERVICE_NAME)){
				pt = wsdl_ui_bpel.getPortType(t);
				//http://www.example.org/UI_BPEL-Mediator/
			}
		}
		
		//Role and PartnerLinkType
		role.setPortType(pt);
		partnerLinkTypeBPEL.getRole().add(role);
		partnerLinkTypeBPEL.setEnclosingDefinition(processWSDl);
		
		partnerLinkBPEL.setPartnerLinkType(partnerLinkTypeBPEL);
		partnerLinkBPEL.setPartnerRole(role);
	}

	public void importNewWSDL() {
		
		WSDLImportHelperUI.addToolingNamespaces(processWSDl);
		
		WSDLImportHelperUI.addImportAndNamespace(processWSDl, wsdl_ui_bpel);
		WSDLImportHelperUI.addImportAndNamespace(processWSDl, wsdl_user_event_listinner);
		boolean newPL = true;

		processWSDl.getEExtensibilityElements().add(partnerLinkTypeBPEL);

		processWSDl.getEExtensibilityElements().add(partnerLinkTypeUserEvent);

		processWSDl.getEExtensibilityElements().add(propertyName);

		processWSDl.getEExtensibilityElements().add(myPA);

		try {
			processWSDl.eResource().save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Role createRoleInProcess() {
		Role role1 =  PartnerlinktypeFactory.eINSTANCE.createRole();
		role1.setName ( "RoleName" );
		return role1;
	}

	private PartnerLinkType createPartnerLinkTypeInProcess() {
		PartnerLinkType plt = PartnerlinktypeFactory.eINSTANCE.createPartnerLinkType();
		plt.setName("ParnetLinkT");
		//plt.setEnclosingDefinition(processWSDl);
		return plt;
	}

	private PartnerLink createPartnerLinkInProcess2() {
		String newPartnerName = "partnerLinkUserInteraction";
		PartnerLink partner = BPELFactory.eINSTANCE.createPartnerLink();
		partner.setName(newPartnerName);
		return partner;
	}

	private Import createImportInProcess() {

		Import imp = BPELFactory.eINSTANCE.createImport();

		// namespace
		String t = wsdl_ui_bpel.getTargetNamespace();
		if (t != null) {
			imp.setNamespace(t);
		}
		// location
		Resource resource = p.eResource();
		URI schemaURI = URI.createURI(wsdl_ui_bpel.getLocation());
		imp.setLocation(schemaURI
				.deresolve(resource.getURI(), true, true, true).toString());

		// importType (the WSDL kind)
		imp.setImportType(WSDLConstants.WSDL_NAMESPACE_URI);

		return imp;
	}

	private void operationConfiguration() {
		selectionCount = inputCount = outputCount = eventCount = 1;
		Service s1 = (Service) wsdl_ui_bpel.getEServices().get(0);
		Port p1 = (Port) s1.getEPorts().get(0);
		for (Object op : p1.getBinding().getBindingOperations()) {
			BindingOperation opera = (BindingOperation) op;
			if (opera.getName().equals("inputOperation"))
				inputOperation = opera.getEOperation();
			else if (opera.getName().equals("outputOperation"))
				outputOperation = opera.getEOperation();
			else if (opera.getName().equals("selectionOperation"))
				selectionOperation = opera.getEOperation();
			else if (opera.getName().equals("eventDataUI"))
				eventOperation = opera.getEOperation();
		}
	}

	public Set<Variable> getUiVariables() {
		Set<Variable> var = new HashSet<Variable>();
		for (Set<Variable> simpleSet : list.values()) {
			var.addAll(simpleSet);
		}
		return var;
	}

	public Variable[] getVariableForDataInt(DataInteraction activity) {
		return list.get(activity.getId()).toArray(new Variable[0]);
	}

	private void treatProcess(Activity activity) {
		if (activity instanceof ExtensionActivity)
			extensionActivity2XML((ExtensionActivity) activity);
		else if (activity instanceof Flow)
			for (Activity inAct : ((Flow) activity).getActivities())
				treatProcess(inAct);
		else if (activity instanceof If) {
			If f = (If) activity;
			treatProcess(f.getActivity());
			if (f.getElse() != null)
				treatProcess(f.getElse().getActivity());
			for (ElseIf anElseIf : f.getElseIf())
				treatProcess(anElseIf.getActivity());
		} else if (activity instanceof While)
			treatProcess(((While) activity).getActivity());
		else if (activity instanceof Sequence)
			for (Activity intAct : ((Sequence) activity).getActivities())
				treatProcess(intAct);
		else if (activity instanceof Pick) {
			dealPick((Pick) activity);
		} else if (activity instanceof Scope)
			scopeInner((Scope) activity);
		else if (activity instanceof ForEach)
			treatProcess(((ForEach) activity).getActivity());
		else if (activity instanceof RepeatUntil)
			treatProcess(((RepeatUntil) activity).getActivity());
	}

	private void dealPick(Pick f) {
		for (OnAlarm intAct : f.getAlarm())
			treatProcess(intAct.getActivity());
		for (OnMessage intAct : f.getMessages())
			treatProcess(intAct.getActivity());
	}

	private void extensionActivity2XML(ExtensionActivity activity) {
		if (activity instanceof DataSelectionUI) {
			DataSelectionUI s = (DataSelectionUI) activity;
			Variable inputVar = BPELFactory.eINSTANCE.createVariable();
			inputVar.setName(DATA_SELECTION_REQUEST + selectionCount);
			inputVar.setMessageType((Message) selectionOperation.getInput()
					.getMessage());
			Variable outputVar = BPELFactory.eINSTANCE.createVariable();
			outputVar.setName(DATA_SELECTION_REPONSE + selectionCount);
			outputVar.setMessageType((Message) selectionOperation.getOutput()
					.getMessage());
			Set<Variable> var = new HashSet<Variable>();
			var.add(outputVar);
			var.add(inputVar);
			list.put(s.getId(), var);
			selectionCount++;
			return;
		} else if (activity instanceof DataInputUI) {
			DataInputUI s = (DataInputUI) activity;
			Variable inputVar = BPELFactory.eINSTANCE.createVariable();
			inputVar.setName(DATA_INPUT_REQUEST + inputCount);
			inputVar.setMessageType((Message) inputOperation.getInput()
					.getMessage());
			Variable outputVar = BPELFactory.eINSTANCE.createVariable();
			outputVar.setName(DATA_INPUT_REPONSE + inputCount);
			outputVar.setMessageType((Message) inputOperation.getOutput()
					.getMessage());
			Set<Variable> var = new HashSet<Variable>();
			var.add(outputVar);
			var.add(inputVar);
			list.put(s.getId(), var);
			inputCount++;
			return;
		} else if (activity instanceof DataOutputUI) {
			DataOutputUI s = (DataOutputUI) activity;
			Variable inputVar = BPELFactory.eINSTANCE.createVariable();
			inputVar.setName(DATA_OUTPUT_REQUEST + outputCount);
			inputVar.setMessageType((Message) outputOperation.getInput()
					.getMessage());
			Set<Variable> var = new HashSet<Variable>();
			var.add(inputVar);
			list.put(s.getId(), var);
			outputCount++;
			return;
		} else if (activity instanceof ScopeUI) {
			ScopeUI scope = (ScopeUI) activity;
			EventHandler eventHand = scope.getEventHandlers();
			if (eventHand instanceof EventHandlerUI) {
				EventHandlerUI eventHandUI = (EventHandlerUI) eventHand;
				for (OnUserEvent userEvent : eventHandUI.getUserInteraction()) {
					Variable inputVar = BPELFactory.eINSTANCE.createVariable();
					inputVar.setName(ON_USER_EVENT_DATA + eventCount);
					inputVar.setMessageType((Message) eventOperation.getInput()
							.getMessage());
					Set<Variable> var = new HashSet<Variable>();
					var.add(inputVar);
					list.put(userEvent.getId(), var);
					eventCount++;
				}
			}
			scopeInner(scope);
			return;
		} else if (activity instanceof PickUI) {
			PickUI pick = (PickUI) activity;
			for (OnUserEvent userEvent : pick.getUserInteraction()) {
				Variable inputVar = BPELFactory.eINSTANCE.createVariable();
				inputVar.setName(ON_USER_EVENT_DATA + eventCount);
				inputVar.setMessageType((Message) eventOperation.getInput()
						.getMessage());
				Set<Variable> var = new HashSet<Variable>();
				var.add(inputVar);
				list.put(userEvent.getId(), var);
				eventCount++;
			}
			dealPick(pick);
		}
	}

	private void scopeInner(Scope activity) {
		if (activity.getFaultHandlers() != null) {
			for (Catch c : activity.getFaultHandlers().getCatch())
				treatProcess(c.getActivity());
			if (activity.getFaultHandlers().getCatchAll() != null)
				treatProcess(activity.getFaultHandlers().getCatchAll()
						.getActivity());
		}
		if (activity.getTerminationHandler() != null)
			treatProcess(activity.getTerminationHandler().getActivity());
		if (activity.getEventHandlers() != null) {
			for (OnAlarm alarm : activity.getEventHandlers().getAlarm())
				treatProcess(alarm.getActivity());
			for (OnEvent alarm : activity.getEventHandlers().getEvents())
				treatProcess(alarm.getActivity());
		}
		if (activity.getActivity() != null)
			treatProcess(activity.getActivity());
	}

	public Operation getInputOperation() {
		return inputOperation;
	}

	public Operation getOutputOperation() {
		return outputOperation;
	}

	public Operation getSelectionOperation() {
		return selectionOperation;
	}

	public Operation getEventOperation() {
		return eventOperation;
	}
	
	public Import getImportBPEL() {
		return importBPEL;
	}

	public PartnerLink getPartnerLinkBPEL() {
		return partnerLinkBPEL;
	}

	public static Object attemptLoadWSDL(URI uri, ResourceSet resourceSet) {
		Resource resource = null;
		BPELResourceSetImpl fHackedResourceSet = BPELUtils
				.slightlyHackedResourceSet(resourceSet);
		resource = fHackedResourceSet.getResource(uri, true, WSLD_NAME);

		// Bugzilla 324164
		if (resource != null && resource.getErrors().isEmpty()
				&& resource.isLoaded()) {
			return resource.getContents().get(0);
		}
		return null;
	}
}
