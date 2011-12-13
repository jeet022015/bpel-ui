package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.bpel.model.Activity;
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
import org.eclipse.bpel.model.resource.BPELResourceSetImpl;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Operation;

import be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.manager.DataInteractionManager;
import be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.manager.EventInteractionManager;
import be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.representation.ImportRepresentation;
import be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.representation.PartnerLinkRepresentation;
import be.ac.fundp.precise.ui_bpel.ui.util.WSDLImportHelperUI;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;
import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.PickUI;
import be.edu.fundp.precise.uibpel.model.ScopeUI;

// TODO: Auto-generated Javadoc
/**
 * The Class BpelUIUtil.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class BpelUIUtil {

	/** The Constant WSLD_NAME. */
	private static final String WSLD_NAME = "wsdl";
	
	/** The Constant SERVICE_NAME. */
	private static final String SERVICE_NAME = "UiManager";
	
	/** The Constant SERVICE_NAME_USER_EVENT. */
	private static final String SERVICE_NAME_USER_EVENT = "UserEventListener";
	
	/** The ui manager partner link. */
	protected PartnerLinkRepresentation uiManagerPartnerLink;
	
	/** The user event listener partner link. */
	protected PartnerLinkRepresentation userEventListenerPartnerLink;
	
	/** The ui manager import. */
	protected ImportRepresentation uiManagerImport;
	
	/** The user event import. */
	protected ImportRepresentation userEventImport;
	
	/** The ui manager op. */
	protected DataInteractionManager uiManagerOp;
	
	/** The event manager op. */
	protected EventInteractionManager eventManagerOp;
	
	/** The wsdl_ui_bpel. */
	private Definition wsdl_ui_bpel;
	
	/** The wsdl_user_event_listinner. */
	private Definition wsdl_user_event_listinner;
	
	/** The process ws dl. */
	private Definition processWSDl;
	
	/** The p. */
	private Process p;

	/** The instance. */
	private static BpelUIUtil instance;

	/**
	 * Gets the instace.
	 *
	 * @return the instace
	 */
	public static BpelUIUtil getInstace() {
		if (instance == null) {
			instance = new BpelUIUtil();
		}
		return instance;
	}

	/**
	 * Instantiates a new bpel ui util.
	 */
	private BpelUIUtil() {

	}

	/**
	 * Configure process.
	 *
	 * @param processWSDLPath the process wsdl path
	 * @param ui_bpelWSDLPath the ui_bpel wsdl path
	 * @param userListnnerPath the user listnner path
	 * @param process the process
	 */
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
		
		uiManagerPartnerLink = new PartnerLinkRepresentation("UiManagerPartnerLink",
				"UiManagerPartnerLinkType","UiManagerRole", wsdl_ui_bpel,SERVICE_NAME, processWSDl, false);
		userEventListenerPartnerLink = new PartnerLinkRepresentation("UserEventPartnerLink",
				"UserEventPartnerLinkType","UserEventRole", wsdl_user_event_listinner,SERVICE_NAME_USER_EVENT, processWSDl, true);
		
		uiManagerImport = new ImportRepresentation(wsdl_ui_bpel, processWSDl, p.eResource());
		userEventImport = new ImportRepresentation(wsdl_user_event_listinner,processWSDl, p.eResource());
		
		eventManagerOp = new EventInteractionManager(wsdl_user_event_listinner, processWSDl);
		uiManagerOp = new DataInteractionManager(wsdl_ui_bpel, processWSDl, eventManagerOp.getProperty());
		
		saveProcessWSDL();
		uiManagerOp.createGenIdVars();
		treatProcess(process.getActivity());
	}

	/**
	 * Save process wsdl.
	 */
	public void saveProcessWSDL() {
		
		WSDLImportHelperUI.addToolingNamespaces(processWSDl);

		try {
			processWSDl.eResource().save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the ui variables.
	 *
	 * @return the ui variables
	 */
	public Set<Variable> getUiVariables() {
		Set<Variable> var = new HashSet<Variable>();
		var.addAll(uiManagerOp.getVariables());
		var.addAll(eventManagerOp.getVariables());
		return var;
	}

	/**
	 * Gets the variable for user interaction.
	 *
	 * @param id the id
	 * @return the variable for user interaction
	 */
	public Variable[] getVariableForUserInteraction(String id) {
		if (uiManagerOp.containsUserInteraction(id))
			return uiManagerOp.getVariable(id);
		return eventManagerOp.getVariable(id);
	}

	/**
	 * Treat process.
	 *
	 * @param activity the activity
	 */
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

	/**
	 * Deal pick.
	 *
	 * @param f the f
	 */
	private void dealPick(Pick f) {
		for (OnAlarm intAct : f.getAlarm())
			treatProcess(intAct.getActivity());
		for (OnMessage intAct : f.getMessages())
			treatProcess(intAct.getActivity());
	}

	/**
	 * Extension activity2 xml.
	 *
	 * @param activity the activity
	 */
	private void extensionActivity2XML(ExtensionActivity activity) {
		if (activity instanceof DataSelectionUI) {
			uiManagerOp.createDataSelectionVar((DataSelectionUI) activity);
			return;
		} else if (activity instanceof DataInputUI) {
			uiManagerOp.createDataInputVar((DataInputUI) activity);
			return;
		} else if (activity instanceof DataOutputUI) {
			uiManagerOp.createDataOutputVar((DataOutputUI) activity);
			return;
		} else if (activity instanceof ScopeUI) {
			ScopeUI scope = (ScopeUI) activity;
			EventHandler eventHand = scope.getEventHandlers();
			if (eventHand instanceof EventHandlerUI) {
				EventHandlerUI eventHandUI = (EventHandlerUI) eventHand;
				for (OnUserEvent userEvent : eventHandUI.getUserInteraction()) {
					eventManagerOp.createEventVar(userEvent);
				}
			}
			scopeInner(scope);
			return;
		} else if (activity instanceof PickUI) {
			PickUI pick = (PickUI) activity;
			for (OnUserEvent userEvent : pick.getUserInteraction()) {
				eventManagerOp.createEventVar(userEvent);
			}
			dealPick(pick);
		}
	}

	/**
	 * Scope inner.
	 *
	 * @param activity the activity
	 */
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

	/**
	 * Gets the input operation.
	 *
	 * @return the input operation
	 */
	public Operation getInputOperation() {
		return uiManagerOp.getInputOperation();
	}

	/**
	 * Gets the output operation.
	 *
	 * @return the output operation
	 */
	public Operation getOutputOperation() {
		return uiManagerOp.getOutputOperation();
	}

	/**
	 * Gets the selection operation.
	 *
	 * @return the selection operation
	 */
	public Operation getSelectionOperation() {
		return uiManagerOp.getSelectionOperation();
	}

	/**
	 * Gets the event operation.
	 *
	 * @return the event operation
	 */
	public Operation getEventOperation() {
		return eventManagerOp.getOperation();
	}
	
	/**
	 * Gets the import bpel.
	 *
	 * @return the import bpel
	 */
	public Import getImportBPEL() {
		return uiManagerImport.getImport();
	}
	
	/**
	 * Gets the import user event.
	 *
	 * @return the import user event
	 */
	public Import getImportUserEvent() {
		return userEventImport.getImport();
	}

	/**
	 * Gets the partner link bpel.
	 *
	 * @return the partner link bpel
	 */
	public PartnerLink getPartnerLinkBPEL() {
		return uiManagerPartnerLink.getPartnerLink();
	}

	/**
	 * Attempt load wsdl.
	 *
	 * @param uri the uri
	 * @param resourceSet the resource set
	 * @return the object
	 */
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

	/**
	 * Gets the user event correlation set.
	 *
	 * @return the user event correlation set
	 */
	public CorrelationSet getUserEventCorrelationSet() {
		return eventManagerOp.getCorrelationSet();
	}

	/**
	 * Gets the partner link user event.
	 *
	 * @return the partner link user event
	 */
	public PartnerLink getPartnerLinkUserEvent() {
		return userEventListenerPartnerLink.getPartnerLink();
	}

	/**
	 * Gets the gen id operation.
	 *
	 * @return the gen id operation
	 */
	public Operation getGenIdOperation() {
		return uiManagerOp.getGenIdOperation();
	}

	/**
	 * Gets the gen id var.
	 *
	 * @return the gen id var
	 */
	public Variable[] getGenIdVar() {
		return uiManagerOp.getVariable(DataInteractionManager.GEN_ID_INDEX);
	}
}
