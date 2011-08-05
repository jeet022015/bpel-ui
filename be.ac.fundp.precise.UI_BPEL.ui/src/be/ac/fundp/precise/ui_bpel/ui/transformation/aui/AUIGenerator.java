package be.ac.fundp.precise.ui_bpel.ui.transformation.aui;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.Else;
import org.eclipse.bpel.model.ElseIf;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.model.If;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.RepeatUntil;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.While;
import org.eclipse.emf.common.util.EList;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

import org.usixml.aui.auiPackage.AbstractCompoundIU;
import org.usixml.aui.auiPackage.AbstractDataIU;
import org.usixml.aui.auiPackage.AbstractDataIUType;
import org.usixml.aui.auiPackage.AbstractUIModel;
import org.usixml.aui.auiPackage.AuiPackageFactory;

public class AUIGenerator {

	private int idGen = 1;
	
	private AbstractUIModel model;
	private AuiPackageFactory factory = AuiPackageFactory.eINSTANCE;
	private AbstractCompoundIU comp;
	private Map<String, Set<String>> varDependenceMapping;
	private Set<String> varUI;
	private MediatorConfigurator medConf;
	
	public AUIGenerator (OutputStream out){
		medConf = new MediatorConfigurator (out);
	}
	
	public AbstractUIModel createAUI(Process process) {
		//AuiPackageFactory.eINSTANCE.eClass();
		AbstractUIModel model = factory.createAbstractUIModel();
		this.model = model;
		createAbstractComponent();
		 
		activity2AUI(process.getActivity());
		
		medConf.finalize();
		
		return model;
	}

	private void createAbstractComponent() {
		comp = factory.createAbstractCompoundIU();
		comp.setHelp("Help");
		comp.setId(idGen);
		idGen++;
		model.getCompoundIUs().add(comp);
		comp.setModel(model);
		varDependenceMapping = new HashMap<String, Set<String>>();
		varUI = new HashSet<String>();
	}
	
	private void activity2AUI(Activity activity){
		
		//Create elements
		if (activity instanceof DataSelectionUI)
			createDataUiDataSelectionUI((DataSelectionUI) activity);
		else if (activity instanceof DataInputUI)
			createDataUiDataInputUI((DataInputUI) activity);
		else if (activity instanceof DataOutputUI)
			createDataUiDataOutputUI((DataOutputUI) activity);
		
		//Create Variable Dependence
		if (activity instanceof Invoke)
			invoke2AUI((Invoke) activity);
		else if (activity instanceof Assign)
			assign2AUI((Assign) activity);
		else if (activity instanceof DataSelectionUI)
			dataSelection2AUI((DataSelectionUI) activity);
		
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

	private void createDataUiDataSelectionUI(DataSelectionUI activity) {
		hasDependenceAmongVars(activity.getOutputVariable().getName());
		
		medConf.createDataSelectionConf(comp, activity);
		varUI.add(activity.getOutputVariable().getName());
		varUI.add(activity.getInputVariable().getName());
		
		createAbstractDataUIComponent(factory.createAbstractSelectionIU(), 
				AbstractDataIUType.INPUT_OUTPUT);
	}

	private void hasDependenceAmongVars(String varName) {
		if (varUI.contains(varName)) {
			createAbstractComponent();
			return;
		}
		Set<String> myVarDep = varDependenceMapping.get(varName);
		if (myVarDep != null)
			for (String variable : myVarDep) {
				if (varUI.contains(variable)){
					createAbstractComponent();
					break;
				}
			}
	}

	private void createDataUiDataOutputUI(DataOutputUI activity) {
		hasDependenceAmongVars(activity.getOutputVariable().getName());
		
		medConf.createDataOutputConf(comp, activity);
		varUI.add(activity.getOutputVariable().getName());
		
		createAbstractDataUIComponent(factory.createAbstractDataIU(), AbstractDataIUType.OUTPUT);
	}

	private void createDataUiDataInputUI(DataInputUI activity) {
		varUI.add(activity.getInputVariable().getName());
		
		medConf.createDataInputConf(comp, activity);
		
		createAbstractDataUIComponent(factory.createAbstractDataIU(), AbstractDataIUType.INPUT);
	}

	private void createAbstractDataUIComponent(AbstractDataIU abstractDataIU,
			AbstractDataIUType input) {
		abstractDataIU.setParentIU(comp);
		abstractDataIU.setDataUIType(input);
		comp.getInteractionUnits().add(abstractDataIU);
	}

	private void repeatUntil2AUI(RepeatUntil activity) {
		createAbstractComponent();
		activity2AUI (activity.getActivity());
	}

	private void forEach2AUI(ForEach activity) {
		createAbstractComponent();
		activity2AUI (activity.getActivity());
	}

	private void while2AUI(While activity) {
		createAbstractComponent();
		activity2AUI (activity.getActivity());
	}
	
	private void pick2AUI(Pick activity) {
		EList<OnMessage> onMessages = activity.getMessages();
		for (OnMessage onMessage : onMessages) {
			createAbstractComponent();
			activity2AUI (onMessage.getActivity());
		}
		
		EList<OnAlarm> onAlarmes = activity.getAlarm();
		for (OnAlarm onAlarme : onAlarmes) {
			createAbstractComponent();
			activity2AUI (onAlarme.getActivity());
		}
		
	}
	
	private void flow2AUI(Flow activity) {
		EList<Activity> activities = activity.getActivities();
		AbstractCompoundIU intialComp = comp;
		for (Activity activity2 : activities) {
			comp = intialComp;
			activity2AUI (activity2);
		}
	}

	private void if2AUI(If activity) {
		createAbstractComponent();
		activity2AUI (activity.getActivity());
		else2AUI(activity.getElse());
		EList<ElseIf> elseIfs = activity.getElseIf();
		for (ElseIf elseIf : elseIfs) {
			elseIf2AUI(elseIf);
		}
	}

	private void elseIf2AUI(ElseIf elseIf) {
		createAbstractComponent();
		activity2AUI (elseIf.getActivity());
	}

	private void else2AUI(Else else1) {
		createAbstractComponent();
		activity2AUI (else1.getActivity());
	}
	
	private void sequence2AUI(Sequence activity) {
		EList<Activity> activities = activity.getActivities();
		for (Activity activity2 : activities) {
			activity2AUI(activity2);
		}
	}
	
	private void scope2AUI(Scope activity) {
		activity2AUI(activity.getActivity());
		
		if (activity.getEventHandlers() != null){
			EList<OnAlarm> onAlarmes = activity.getEventHandlers().getAlarm();
			for (OnAlarm onAlarm : onAlarmes) {
				createAbstractComponent();
				activity2AUI (onAlarm.getActivity());
			}
			
			EList<OnEvent> events = activity.getEventHandlers().getEvents();
			for (OnEvent onEvent : events) {
				createAbstractComponent();
				activity2AUI (onEvent.getActivity());
			}
		}
	}

	private void assign2AUI(Assign activity) {
		EList<Copy> copies = activity.getCopy();
		for (Copy copy : copies) {
			copy2AUI(copy);
		}
	}

	private void copy2AUI(Copy copy) {
		if (copy.getTo().getVariable() != null
				&& copy.getFrom().getVariable() != null){
			dealWithVars(copy.getFrom().getVariable(), copy.getTo().getVariable());
		}
	}

	private void invoke2AUI(Invoke activity) {
		dealWithVars(activity.getInputVariable(), activity.getOutputVariable());
	}
	
	private void dataSelection2AUI(DataSelectionUI activity) {
		dealWithVars(activity.getInputVariable(), activity.getOutputVariable());
	}

	private void dealWithVars(Variable inputVariable,
			Variable outputVariable) {
		String inputVarName = null;
		String outputVarName =null;
		if (inputVariable != null){
			inputVarName = inputVariable.getName();
		}
		if (outputVariable != null){
			outputVarName = outputVariable.getName();
		}
		Set<String> set;
		if(inputVarName != null && outputVarName != null){
			if (varDependenceMapping.containsKey(outputVarName)){
				set = varDependenceMapping.get(outputVarName);
				
			} else {
				set = new HashSet<String>();
			}
			set.add(inputVarName);
			varDependenceMapping.put(outputVarName, set);
		}
	}

}