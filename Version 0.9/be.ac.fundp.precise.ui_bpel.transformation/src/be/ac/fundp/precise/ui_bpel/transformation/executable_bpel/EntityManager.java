package be.ac.fundp.precise.ui_bpel.transformation.executable_bpel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
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
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Operation;

import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.manager.DataInteractionManager;
import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.manager.EventInteractionManager;
import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.manager.GeneratorOperationManager;
import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.representation.ImportRepresentation;
import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.representation.PartnerLinkRepresentation;
import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.util.ExecutableBpelFileManager;
import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.util.WSDLImportHelperUI;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;
import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.PickUI;
import be.edu.fundp.precise.uibpel.model.ScopeUI;

/**
 * The BpelUIUtil can be utilized to identify the requirements for parsing a 
 * UI-BPEL model to its executable version.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class EntityManager {

	/** The Constant WSLD_NAME. */
	private static final String WSLD_NAME = "wsdl";
	
	/** The Constant SERVICE_NAME. */
	private static final String SERVICE_NAME = "UiManager";
	
	/** The Constant SERVICE_NAME_USER_EVENT. */
	private static final String SERVICE_NAME_USER_EVENT = "ProcessOperations";
	
	/** The UI manager partner link. */
	protected PartnerLinkRepresentation uiManagerPartnerLink;
	
	/** The user event listener partner link. */
	protected PartnerLinkRepresentation userEventListenerPartnerLink;
	
	/** The UI manager import. */
	protected ImportRepresentation uiManagerImport;
	
	/** The user event import. */
	protected ImportRepresentation userEventImport;
	
	/** The UI manager operation. */
	protected DataInteractionManager uiManagerOp;
	
	/** The event manager operation. */
	protected EventInteractionManager eventManagerOp;
	
	/** The event manager operation. */
	private GeneratorOperationManager genetatorManagerOp;
	
	/** The WSDL Definition of the coordinator WS. */
	private Definition wsdl_ui_bpel;
	
	/** The WSDL Definition to allow the process listen User events. */
	private Definition wsdl_user_event_listinner;
	
	/** The WSDL Definition of the process. */
	private Definition processWSDl;
	
	/** The process. */
	private Process p;

	/** The OutputStream to save the executable process. */
	private OutputStream out;


	/**
	 * Instantiates a new BpelUIUtil.
	 */
	public EntityManager() {

	}

	/**
	 * This method configure the environment to derive the executable process.
	 * 1. Identify the WSDLs
	 * 2. Add the import to the new WSDLs into the process WSDL
	 * 3. Add the CorrelationSet that allow listen User Event into the process WSDL
	 * 4. Create the variable to the new Invokes.
	 *
	 * @param iFile the process file (bpel file)
	 * @param process the process representation (EMF representation)
	 * @param container 
	 * @throws CoreException this exception can be throued if the new WSDLs cannot be copied from
	 * the core of plug-in.
	 * @throws IOException Signals that an I/O exception has occurred during the serialization of
	 * the new process.
	 */
	public void configureProcess(IFile iFile,  Process process, IContainer container) throws CoreException, IOException {

		if (p != null && p.equals(process))
			return;
		else
			p = process;

		managerFiles(iFile, process, container);
		
		addToolingNamespaces();
		
		uiManagerImport = new ImportRepresentation(wsdl_ui_bpel, processWSDl, p.eResource());
		userEventImport = new ImportRepresentation(wsdl_user_event_listinner,processWSDl, p.eResource());

		genetatorManagerOp = new GeneratorOperationManager(wsdl_ui_bpel, processWSDl);
		eventManagerOp = new EventInteractionManager(wsdl_user_event_listinner, processWSDl, 
				genetatorManagerOp.getCorrelationSet());
		uiManagerOp = new DataInteractionManager(wsdl_ui_bpel, processWSDl,
				genetatorManagerOp.getCorrelationSet(), genetatorManagerOp.getOutputVar());
		
		//save the first time to add the namespaces of the new definitions
		saveProcessWSDL();
		
		uiManagerPartnerLink = new PartnerLinkRepresentation("UiManagerPartnerLink",
				"UiManagerPartnerLinkType","UiManagerRole", wsdl_ui_bpel,SERVICE_NAME, processWSDl, false);
		userEventListenerPartnerLink = new PartnerLinkRepresentation("UserEventPartnerLink",
				"UserEventPartnerLinkType","UserEventRole", wsdl_user_event_listinner,SERVICE_NAME_USER_EVENT, processWSDl, true);
		
		//save the first time to add the new partner links
		saveProcessWSDL();
		
		treatProcess(process.getActivity());
	}

	/**
	 * This method load the new WSDLs and it creates the output Stream to save the executable
	 * BPEL Process.
	 *
	 * @param iFile the process file (bpel file)
	 * @param process the process representation (EMF representation)
	 * @param container 
	 * @param folder 
	 * @throws CoreException this exception can be throued if the new WSDLs cannot be copied from
	 * the core of plug-in.
	 * @throws IOException Signals that an I/O exception has occurred during the serialization of
	 * the new process.
	 */
	private void managerFiles(IFile iFile, Process process, IContainer container) throws CoreException, IOException {
		
		ExecutableBpelFileManager wsdlManager = new ExecutableBpelFileManager(iFile, container);
		
		String processWsldPath = "";
		for (Import processImp : process.getImports()) {
			wsdlManager.getCopyProcessWSDLs(processImp.getLocation());
			if (process.getTargetNamespace().equals(processImp.getNamespace())){
				processWsldPath = wsdlManager.getWsdlPath(processImp.getLocation());
			}
		}
		
		URI uri = URI.createPlatformResourceURI(processWsldPath, false);
		processWSDl = (Definition) attemptLoadWSDL(uri, process.eResource()
				.getResourceSet());

		uri = URI.createPlatformResourceURI(wsdlManager.getUiManagerPath(), false);
		wsdl_ui_bpel = (Definition) attemptLoadWSDL(uri, process.eResource()
				.getResourceSet());
		
		uri = URI.createPlatformResourceURI(wsdlManager.getUserEventListenerPath(), false);
		wsdl_user_event_listinner = (Definition) attemptLoadWSDL(uri, process.eResource()
				.getResourceSet());
		
		out = wsdlManager.getOutputStream();
	}

	/**
	 * This method adds necessary namespaces to the process wsdl.
	 */
	private void addToolingNamespaces() {
		
		WSDLImportHelperUI.addToolingNamespaces(processWSDl);

		saveProcessWSDL();
	}

	/**
	 * This method saves the wsdl of the executable BPEL process.
	 */
	private void saveProcessWSDL() {
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
		var.add(genetatorManagerOp.getInputVar());
		var.add(genetatorManagerOp.getOutputVar());
		return var;
	}

	/**
	 * This method identify the correct treatment for an activity.
	 *
	 * @param activity the activity
	 */
	private void treatProcess(Activity activity) {
		if (activity instanceof ExtensionActivity)
			dealExtensionActivity((ExtensionActivity) activity);
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
			dealScope((Scope) activity);
		else if (activity instanceof ForEach)
			treatProcess(((ForEach) activity).getActivity());
		else if (activity instanceof RepeatUntil)
			treatProcess(((RepeatUntil) activity).getActivity());
	}

	/**
	 * Deal with a pick activity.
	 *
	 * @param f the Pick activity
	 */
	private void dealPick(Pick f) {
		for (OnAlarm intAct : f.getAlarm())
			treatProcess(intAct.getActivity());
		for (OnMessage intAct : f.getMessages())
			treatProcess(intAct.getActivity());
	}

	/**
	 * Deal with an extension activity.
	 *
	 * @param activity the extension activity
	 */
	private void dealExtensionActivity(ExtensionActivity activity) {
		if (activity instanceof DataSelectionUI) {
			uiManagerOp.createDataSelection(((DataSelectionUI) activity).getId());
			return;
		} else if (activity instanceof DataInputUI) {
			DataInputUI input = (DataInputUI)activity;
			if (input.isCreateInstance())
				eventManagerOp.createStartVar(input.getId());
			else 
				uiManagerOp.createDataInput(input.getId());
			return;
		} else if (activity instanceof DataOutputUI) {
			uiManagerOp.createDataOutput(((DataOutputUI) activity).getId());
			return;
		} else if (activity instanceof ScopeUI) {
			ScopeUI scope = (ScopeUI) activity;
			EventHandler eventHand = scope.getEventHandlers();
			if (eventHand instanceof EventHandlerUI) {
				EventHandlerUI eventHandUI = (EventHandlerUI) eventHand;
				for (OnUserEvent userEvent : eventHandUI.getUserInteraction()) {
					eventManagerOp.createEventVar(userEvent);
					treatProcess(userEvent.getActivity());
				}
			}
			dealScope(scope);
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
	 * Deal with a scope activity.
	 *
	 * @param activity the scope activity
	 */
	private void dealScope(Scope activity) {
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
	 * Attempt load a wsdl.
	 *
	 * @param uri the uri
	 * @param resourceSet the resource set of the process
	 * @return the Definition of the WSDL
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
	public Collection<CorrelationSet> getCorrelationSets() {
		Collection<CorrelationSet> returnSet = new HashSet<CorrelationSet>();
		returnSet.addAll(uiManagerOp.getInputCorrelationSets());
		returnSet.add(eventManagerOp.getCorrelationSet());
		returnSet.add(eventManagerOp.getStartCorrelationSet());
		returnSet.add(genetatorManagerOp.getCorrelationSet());
		return returnSet;
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
	 * Gets the output stream.
	 *
	 * @return the output stream
	 */
	public OutputStream getOutputStream() {
		return out;
	}

	public GeneratorOperationManager getGeneratorOperationManager() {
		return genetatorManagerOp;
	}

	public EventInteractionManager getEventInteractionManager() {
		return eventManagerOp;
	}
	
	public DataInteractionManager getDataInteractionManager() {
		return uiManagerOp;
	}
}
