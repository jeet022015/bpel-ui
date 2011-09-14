package be.ac.fundp.precise.ui_bpel.ui.transformation.aui;

import java.io.OutputStream;

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
import auiPackage.AbstractSelectionIU;
import auiPackage.AbstractTriggerIU;
import auiPackage.AbstractUIModel;
import auiPackage.AuiPackageFactory;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

public class AUIGenerator {

	private int idGen = 1;
	
	private AbstractUIModel model;
	private AuiPackageFactory factory = AuiPackageFactory.eINSTANCE;
	private MediatorConfigurator medConf;
	private int orderingCounter;
	
	public AUIGenerator (OutputStream out) throws ParserConfigurationException{
		medConf = new MediatorConfigurator (out);
	}
	
	public AbstractUIModel createAUI(Process process) throws TransformerException {
		//AuiPackageFactory.eINSTANCE.eClass();
		AbstractUIModel model = factory.createAbstractUIModel();
		this.model = model;
		orderingCounter= 1;
		
		activity2AUI(process.getActivity());
		
		medConf.finalize();
		
		return model;
	}

	private AbstractCompoundIU createAbstractComponent() {
		AbstractCompoundIU comp = factory.createAbstractCompoundIU();
		comp.setHelp("Help");
		comp.setId(idGen);
		idGen++;
		
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
		AbstractCompoundIU comp = createAbstractComponent();
		orderingCounter++;
		
		medConf.createDataSelectionConf(comp, activity);

		AbstractSelectionIU a = factory.createAbstractSelectionIU();
		a.setMaxCardinality(activity.getMaxCardinality());
		a.setMinCardinality(activity.getMinCardinality());
		
		AbstractDataIU dataComp = createAbstractDataUIComponent(comp,
				factory.createAbstractDataIU(), 
				AbstractDataIUType.INPUT_OUTPUT, "STRING");
		comp.getInteractionUnits().add(dataComp);
		
		//FIXME put the type from the data Item
		
		AbstractTriggerIU validator = factory.createAbstractTriggerIU();
		comp.getInteractionUnits().add(validator);
	}

	private void createDataUiDataOutputUI(DataOutputUI activity) {
		AbstractCompoundIU comp = createAbstractComponent();
		orderingCounter++;
		
		medConf.createDataOutputConf(comp, activity);
		
		for (DataItem item : activity.getOutputItem()) {
			AbstractDataIU dataComp = createAbstractDataUIComponent(comp,
					factory.createAbstractDataIU(), 
					AbstractDataIUType.OUTPUT, item.getType().getName());
			comp.getInteractionUnits().add(dataComp);
		}
		
		AbstractTriggerIU validator = factory.createAbstractTriggerIU();
		comp.getInteractionUnits().add(validator);
	}

	private void createDataUiDataInputUI(DataInputUI activity) {
		AbstractCompoundIU comp = createAbstractComponent();
		orderingCounter++;
		
		medConf.createDataInputConf(comp, activity);
		for (DataItem item : activity.getInputItem()) {
			AbstractDataIU dataComp = createAbstractDataUIComponent(comp,
					factory.createAbstractDataIU(), 
					AbstractDataIUType.INPUT, item.getType().getName());
			comp.getInteractionUnits().add(dataComp);
		}
		
		AbstractTriggerIU validator = factory.createAbstractTriggerIU();
		comp.getInteractionUnits().add(validator);
	}

	private AbstractDataIU createAbstractDataUIComponent(AbstractCompoundIU comp, 
			AbstractDataIU abstractDataIU,
			AbstractDataIUType input, String dataType) {
		abstractDataIU.setParentIU(comp);
		abstractDataIU.setDataUIType(input);
		abstractDataIU.setDataType(dataType);
		return abstractDataIU;
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