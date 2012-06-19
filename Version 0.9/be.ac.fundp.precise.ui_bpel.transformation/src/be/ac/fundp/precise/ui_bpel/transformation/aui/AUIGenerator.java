package be.ac.fundp.precise.ui_bpel.transformation.aui;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.ElseIf;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.model.If;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.RepeatUntil;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.While;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

import be.ac.fundp.precise.ui_bpel.transformation.aui.model.AuiFactoryBuilder;
import be.ac.fundp.precise.ui_bpel.transformation.aui.model.core.AbstractComponentIU;
import be.ac.fundp.precise.ui_bpel.transformation.aui.model.core.AbstractUIModel;
import be.ac.fundp.precise.ui_bpel.transformation.aui.model.core.AuiFactory;
import be.ac.fundp.precise.ui_bpel.transformation.aui.model.core.DataIU;
import be.ac.fundp.precise.ui_bpel.transformation.aui.model.core.SelectionUI;
import be.ac.fundp.precise.ui_bpel.transformation.aui.serialization.XML_Engine;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

/**
 * The Class AUIGenerator.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class AUIGenerator {
	
	/** The factory. */
	protected AuiFactory factory = AuiFactoryBuilder.newAuiFactory();
	
	/** The converter. */
	protected ExtensibleURIConverterImpl converter = new ExtensibleURIConverterImpl();
	
	/** The med conf. */
	protected MediatorConfigurator medConf;
	
	/** The role models. */
	protected Map<String, AbstractUIModel> roleModels = new HashMap<String, AbstractUIModel>();
	
	protected IFolder processFolder;
	
	protected Process process;
	
	public AUIGenerator (IFolder processFolder, Process process) throws IOException, ParserConfigurationException, TransformerException, CoreException{
		this.process = process;
		this.processFolder = processFolder;
		medConf = new MediatorConfigurator ();
		processAUI();
	}
	
	public MediatorConfigurator getConf(){
		return medConf;
	}
	
	public Map<String, File> saveModels() throws IOException, CoreException {
		Map<String, File> parsingMap = new HashMap<String, File>();
		IFolder auiFolder = processFolder.getFolder("aui-artifacts");
		NullProgressMonitor progressMonitor = new NullProgressMonitor();
		if (auiFolder.exists()){
			//coordFolder.delete(true, progressMonitor);
			for (IResource content : auiFolder.members()) { 
				content.delete(IResource.FOLDER, progressMonitor);
			}
			auiFolder.refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);
		} else {
			auiFolder.create(true, true, progressMonitor);
		}
		for (String role : roleModels.keySet()) {
			IFile roleAuiFile = auiFolder.getFile("AUI_Model-"+role+".xml");
			IPath fullAuiFilePath = roleAuiFile.getFullPath();
			URI auiFileUri = URI.createPlatformResourceURI(fullAuiFilePath.toString(), false);
			
			OutputStream out3 = new BufferedOutputStream(converter.createOutputStream(auiFileUri));
			
			AbstractUIModel roleModel = roleModels.get(role);
			XML_Engine engine = new XML_Engine();
			engine.serialize(roleModel, out3);
			parsingMap.put(role, new File (roleAuiFile.getLocation().toOSString()));
		}
		return parsingMap;
	}
	
	/**
	 * Creates the aui.
	 *
	 * @param process the process
	 * @return the map
	 * @throws TransformerException the transformer exception
	 */
	public void processAUI() throws TransformerException {
		roleModels = new HashMap<String, AbstractUIModel>();
		
		List<String> roles = RolesDetector.getRoles(process);
		for (String role : roles) {
			AbstractUIModel model = factory.createAbstractUIModel();
			roleModels.put(role, model);
		}
		//String role = "defaultRole";
		//roleModels.put(role, factory.createAbstractUIModel());
		
		activity2AUI(process.getActivity());
		
		//medConf.finalize();
	}

	/**
	 * Creates the abstract component.
	 *
	 * @param role the role
	 * @return the abstract compound iu
	 */
	private SelectionUI createSelectionUI(String role, String id, String label)  {
		
		AbstractUIModel model = roleModels.get(role);
		SelectionUI comp = model.createInnerSelectionUI();
		
		comp.setHelp("Help");
		comp.setId(id);
		comp.setLabel(label);
		return comp;
	}
	
	/**
	 * Creates the abstract component.
	 *
	 * @param role the role
	 * @param name 
	 * @return the abstract compound iu
	 */
	private AbstractComponentIU createAbstractComponent(String role, String id, String label) {
		
		AbstractUIModel model = roleModels.get(role);
		AbstractComponentIU comp = model.createInnerAbstractCompoundIU();
		comp.setHelp("Help");
		comp.setId(id);
		comp.setLabel(label);
		return comp;
	}
	
	/**
	 * Activity2 aui.
	 *
	 * @param activity the activity
	 */
	private void activity2AUI(Activity activity){
		
		//Create elements
		if (activity instanceof DataSelectionUI)
			createDataUiDataSelectionUI((DataSelectionUI) activity);
		else if (activity instanceof DataInputUI)
			createDataUiDataInputUI((DataInputUI) activity);
		else if (activity instanceof DataOutputUI)
			createDataUiDataOutputUI((DataOutputUI) activity);
		
		//Create New Component
		else if (activity instanceof Flow)
			flow2AUI((Flow) activity);
		else if (activity instanceof If)
			if2AUI((If) activity);
		else if (activity instanceof While)
			while2AUI((While) activity);
		else if (activity instanceof ForEach)
			forEach2AUI((ForEach) activity);
		else if (activity instanceof RepeatUntil)
			repeatUntil2AUI((RepeatUntil) activity);
		else if (activity instanceof Pick)
			pick2AUI((Pick) activity);
		
		//Recursive
		else if (activity instanceof Sequence)
			sequence2AUI((Sequence) activity);
		else if (activity instanceof Scope)
			scope2AUI((Scope) activity);
	}

	/**
	 * Creates the data ui data selection ui.
	 *
	 * @param activity the activity
	 */
	private void createDataUiDataSelectionUI(DataSelectionUI activity) {
		String role = "defaultRole";
		if (activity.getUserRoles() != null && activity.getUserRoles().size() > 0){
			role = activity.getUserRoles().get(0).getRoleId();
		}
		
		SelectionUI comp = createSelectionUI(role,  activity.getId(), activity.getName());
		
		for (DataItem item : activity.getInputItem()) {
			DataIU dataComp = comp.createInnerDataInputUI();
			dataComp.setDataUIType(DataIU.INPUT);
			dataComp.setDataType(item.getType().getName());
			dataComp.setLabel(item.getVariable().getName());
		}
		
		for (DataItem item : activity.getOutputItem()) {
			DataIU dataComp = comp.createInnerDataInputUI();
			dataComp.setDataUIType(DataIU.OUTPUT);
			dataComp.setDataType(item.getType().getName());
			dataComp.setLabel(item.getVariable().getName());
		}
		
		comp.createInnerAbstractTriggerIU();
		
		medConf.createDataSelectionConf(role, activity.getId(), comp.getId());
	}

	/**
	 * Creates the data ui data output ui.
	 *
	 * @param activity the activity
	 */
	private void createDataUiDataOutputUI(DataOutputUI activity) {
		String role = "defaultRole";
		if (activity.getUserRoles() != null && activity.getUserRoles().size() > 0){
			role = activity.getUserRoles().get(0).getRoleId();
		}
		
		AbstractComponentIU comp = createAbstractComponent(role, activity.getId(), activity.getName());
		
		for (DataItem item : activity.getOutputItem()) {
			DataIU dataComp = comp.createInnerDataInputUI();
			dataComp.setDataUIType(DataIU.OUTPUT);
			dataComp.setDataType(item.getType().getName());
			dataComp.setLabel(item.getVariable().getName());
		}
		
		comp.createInnerAbstractTriggerIU();
		
		medConf.createDataOutputConf(role, activity.getId(), comp.getId());
	}
	
	/**
	 * Creates the data ui data input ui.
	 *
	 * @param activity the activity
	 */
	private void createDataUiDataInputUI(DataInputUI activity) {
		String role = "defaultRole";
		if (activity.getUserRoles() != null && activity.getUserRoles().size() > 0){
			role = activity.getUserRoles().get(0).getRoleId();
		}
		AbstractComponentIU comp = createAbstractComponent(role, activity.getId(), activity.getName());
		
		for (DataItem item : activity.getInputItem()) {
			DataIU dataComp = comp.createInnerDataInputUI();
			dataComp.setDataUIType(DataIU.INPUT);
			dataComp.setDataType(item.getType().getName());
			dataComp.setLabel(item.getVariable().getName());
		}
		comp.createInnerAbstractTriggerIU();
		
		medConf.createDataInputConf(role, activity.getId(), comp.getId());
	}

	/**
	 * Repeat until2 aui.
	 *
	 * @param activity the activity
	 */
	private void repeatUntil2AUI(RepeatUntil activity) {
		activity2AUI (activity.getActivity());
	}

	/**
	 * For each2 aui.
	 *
	 * @param activity the activity
	 */
	private void forEach2AUI(ForEach activity) {
		activity2AUI (activity.getActivity());
	}

	/**
	 * While2 aui.
	 *
	 * @param activity the activity
	 */
	private void while2AUI(While activity) {
		activity2AUI (activity.getActivity());
	}
	
	/**
	 * Pick2 aui.
	 *
	 * @param activity the activity
	 */
	private void pick2AUI(Pick activity) {
		EList<OnMessage> onMessages = activity.getMessages();
		for (OnMessage onMessage : onMessages) {
			activity2AUI (onMessage.getActivity());
		}
		EList<OnAlarm> onAlarmes = activity.getAlarm();
		for (OnAlarm onAlarme : onAlarmes) {
			activity2AUI (onAlarme.getActivity());
		}
		
	}
	
	/**
	 * Flow2 aui.
	 *
	 * @param activity the activity
	 */
	private void flow2AUI(Flow activity) {
		for (Activity activity2 : activity.getActivities()) {
			activity2AUI (activity2);
		}
	}

	/**
	 * If2 aui.
	 *
	 * @param activity the activity
	 */
	private void if2AUI(If activity) {
		activity2AUI (activity.getActivity());
		if (activity.getElse() != null){
			activity2AUI(activity.getElse().getActivity());
		}
		
		EList<ElseIf> elseIfs = activity.getElseIf();
		for (ElseIf elseIf : elseIfs) {
			activity2AUI(elseIf.getActivity());
		}
	}
	
	/**
	 * Sequence2 aui.
	 *
	 * @param activity the activity
	 */
	private void sequence2AUI(Sequence activity) {
		EList<Activity> activities = activity.getActivities();
		for (Activity activity2 : activities) {
			activity2AUI(activity2);
		}
	}
	
	/**
	 * Scope2 aui.
	 *
	 * @param activity the activity
	 */
	private void scope2AUI(Scope activity) {
		activity2AUI(activity.getActivity());
		
		if (activity.getEventHandlers() != null){
			EList<OnAlarm> onAlarmes = activity.getEventHandlers().getAlarm();
			for (OnAlarm onAlarm : onAlarmes) {
				activity2AUI (onAlarm.getActivity());
			}
			
			EList<OnEvent> events = activity.getEventHandlers().getEvents();
			for (OnEvent onEvent : events) {
				activity2AUI (onEvent.getActivity());
			}
		}
	}
}