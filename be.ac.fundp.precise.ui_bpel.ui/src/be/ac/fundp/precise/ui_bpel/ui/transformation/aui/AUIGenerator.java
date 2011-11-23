package be.ac.fundp.precise.ui_bpel.ui.transformation.aui;

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
import org.eclipse.emf.common.util.EList;

import auiPackage.AbstractCompoundIU;
import auiPackage.AbstractDataIU;
import auiPackage.AbstractDataIUType;
import auiPackage.AbstractOrdering;
import auiPackage.AbstractTriggerIU;
import auiPackage.AbstractUIModel;
import auiPackage.AuiPackageFactory;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.strategies.StrategyAUIElement;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.strategies.StrategyDataUI;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.strategies.StrategySelectionUI;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

public class AUIGenerator {

	private int idGen = 1;
	
	private AuiPackageFactory factory = AuiPackageFactory.eINSTANCE;
	private MediatorConfigurator medConf;
	private Map<String, AbstractUIModel> roleModels = new HashMap<String, AbstractUIModel>();
	
	private int orderingCounter;
	
	public AUIGenerator (OutputStream out) throws ParserConfigurationException{
		medConf = new MediatorConfigurator (out);
	}
	
	public Map<String, AbstractUIModel> createAUI(Process process) throws TransformerException {
		roleModels = new HashMap<String, AbstractUIModel>();
		
		List<String> roles = RolesDetector.getRoles(process);
		for (String role : roles) {
			AbstractUIModel model = factory.createAbstractUIModel();
			roleModels.put(role, model);
		}
		String role = "defaultRole";
		roleModels.put(role, factory.createAbstractUIModel());
		
		orderingCounter= 1;
		
		activity2AUI(process.getActivity());
		
		medConf.finalize();
		
		return roleModels;
	}

	private AbstractCompoundIU createAbstractComponent(String role) {
		AbstractCompoundIU comp = factory.createAbstractCompoundIU();
		comp.setHelp("Help");
		comp.setId(idGen);
		idGen++;
		
		AbstractUIModel model = roleModels.get(role);
		model.getCompoundIUs().add(comp);
		comp.setModel(model);
		
		AbstractOrdering order = factory.createAbstractOrdering();
		order.setOrderingLevel(orderingCounter);
		comp.getRelationships().add(order);
		return comp;
	}
	
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

	private void createDataUiDataSelectionUI(DataSelectionUI activity) {
		String role = "defaultRole";
		if (activity.getUserRoles() != null && activity.getUserRoles().size() > 0){
			role = activity.getUserRoles().get(0).getRoleId();
		}
		AbstractCompoundIU comp = dataInteraction(role, activity.getInputItem(), 
				AbstractDataIUType.OUTPUT, new StrategySelectionUI());
		selectionUI(comp,AbstractDataIUType.INPUT, activity.getOutputItem(), new StrategySelectionUI());
		medConf.createDataSelectionConf(comp, activity);
	}

	private void selectionUI(AbstractCompoundIU comp,
			AbstractDataIUType output, EList<DataItem> outputItem, StrategySelectionUI strategy) {
		for (DataItem item : outputItem) {
			//AbstractDataIU dataComp = factory.createAbstractDataIU();
			AbstractDataIU dataComp = strategy.getStrategy();
			dataComp.setParentIU(comp);
			dataComp.setDataUIType(output);
			dataComp.setDataType(item.getType().getName());
			dataComp.setLabel(item.getVariable().getName());
			comp.getInteractionUnits().add(dataComp);
		}
	}

	private void createDataUiDataOutputUI(DataOutputUI activity) {
		String role = "defaultRole";
		if (activity.getUserRoles() != null && activity.getUserRoles().size() > 0){
			role = activity.getUserRoles().get(0).getRoleId();
		}
		AbstractCompoundIU comp = dataInteraction(role, activity.getOutputItem(),
				AbstractDataIUType.OUTPUT, new StrategyDataUI());
		medConf.createDataOutputConf(comp, activity);
	}
	
	private void createDataUiDataInputUI(DataInputUI activity) {
		String role = "defaultRole";
		if (activity.getUserRoles() != null && activity.getUserRoles().size() > 0){
			role = activity.getUserRoles().get(0).getRoleId();
		}
		AbstractCompoundIU comp = dataInteraction(role, activity.getInputItem(),
				AbstractDataIUType.INPUT, new StrategyDataUI());
		medConf.createDataInputConf(comp, activity);
	}

	private AbstractCompoundIU dataInteraction(String role, EList<DataItem> dataItems, 
			AbstractDataIUType output, StrategyAUIElement strategy) {
		AbstractCompoundIU comp = createAbstractComponent(role);
		orderingCounter++;
		
		for (DataItem item : dataItems) {
			//AbstractDataIU dataComp = factory.createAbstractDataIU();
			AbstractDataIU dataComp = strategy.getStrategy();
			dataComp.setParentIU(comp);
			dataComp.setDataUIType(output);
			dataComp.setDataType(item.getType().getName());
			dataComp.setLabel(item.getVariable().getName());
			comp.getInteractionUnits().add(dataComp);
		}
		
		AbstractTriggerIU validator = factory.createAbstractTriggerIU();
		comp.getInteractionUnits().add(validator);
		return comp;
	}

	private void repeatUntil2AUI(RepeatUntil activity) {
		//FIXME put repetition
		
		activity2AUI (activity.getActivity());
	}

	private void forEach2AUI(ForEach activity) {
		//FIXME put repetition
		
		activity2AUI (activity.getActivity());
	}

	private void while2AUI(While activity) {
		//FIXME put repetition
		
		activity2AUI (activity.getActivity());
	}
	
	private void pick2AUI(Pick activity) {
		int pickInitOrdering = orderingCounter;
		int maxOrdering = orderingCounter;
		EList<OnMessage> onMessages = activity.getMessages();
		for (OnMessage onMessage : onMessages) {
			orderingCounter = pickInitOrdering;
			activity2AUI (onMessage.getActivity());
			if(orderingCounter > maxOrdering)
				maxOrdering = orderingCounter;
		}
		EList<OnAlarm> onAlarmes = activity.getAlarm();
		for (OnAlarm onAlarme : onAlarmes) {
			orderingCounter = pickInitOrdering;
			activity2AUI (onAlarme.getActivity());
			if(orderingCounter > maxOrdering)
				maxOrdering = orderingCounter;
		}
		orderingCounter = maxOrdering;
		
	}
	
	private void flow2AUI(Flow activity) {
		int pickInitOrdering = orderingCounter;
		int maxOrdering = orderingCounter;
		for (Activity activity2 : activity.getActivities()) {
			orderingCounter = pickInitOrdering;
			activity2AUI (activity2);
			if(orderingCounter > maxOrdering)
				maxOrdering = orderingCounter;
		}
		orderingCounter = maxOrdering;
	}

	private void if2AUI(If activity) {
		int pickInitOrdering = orderingCounter;
		
		activity2AUI (activity.getActivity());
		int maxOrdering = orderingCounter;
		
		if (activity.getElse() != null){
			orderingCounter = pickInitOrdering;
			activity2AUI(activity.getElse().getActivity());
			if(orderingCounter > maxOrdering)
				maxOrdering = orderingCounter;
		}
		
		EList<ElseIf> elseIfs = activity.getElseIf();
		for (ElseIf elseIf : elseIfs) {
			orderingCounter = pickInitOrdering;
			activity2AUI(elseIf.getActivity());
			if(orderingCounter > maxOrdering)
				maxOrdering = orderingCounter;
		}
		
		orderingCounter = maxOrdering;
	}
	
	private void sequence2AUI(Sequence activity) {
		EList<Activity> activities = activity.getActivities();
		for (Activity activity2 : activities) {
			activity2AUI(activity2);
		}
	}
	
	private void scope2AUI(Scope activity) {
		int pickInitOrdering = orderingCounter;
		activity2AUI(activity.getActivity());
		int maxOrdering = orderingCounter;
		
		if (activity.getEventHandlers() != null){
			EList<OnAlarm> onAlarmes = activity.getEventHandlers().getAlarm();
			for (OnAlarm onAlarm : onAlarmes) {
				orderingCounter = pickInitOrdering;
				activity2AUI (onAlarm.getActivity());
				if(orderingCounter > maxOrdering)
					maxOrdering = orderingCounter;
			}
			
			EList<OnEvent> events = activity.getEventHandlers().getEvents();
			for (OnEvent onEvent : events) {
				orderingCounter = pickInitOrdering;
				activity2AUI (onEvent.getActivity());
				if(orderingCounter > maxOrdering)
					maxOrdering = orderingCounter;
			}
		}
		orderingCounter = maxOrdering;
	}
}