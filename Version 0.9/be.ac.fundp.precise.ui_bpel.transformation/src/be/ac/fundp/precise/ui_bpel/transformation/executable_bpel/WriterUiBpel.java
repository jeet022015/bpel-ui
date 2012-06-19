package be.ac.fundp.precise.ui_bpel.transformation.executable_bpel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.CorrelationPattern;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.Receive;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.adapters.INamespaceMap;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.properties.CorrelationSection;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.xsd.util.XSDConstants;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.data_interaction.InteractionOperation;
import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.manager.EventInteractionManager;
import be.ac.fundp.precise.ui_bpel.transformation.executable_bpel.manager.GeneratorOperationManager;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataInteraction;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;
import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.ScopeUI;
import be.edu.fundp.precise.uibpel.model.UserRole;

/**
 * The Class WriterUiBpel.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class WriterUiBpel extends BPELWriter {
	
	/** The bpel. */
	protected EntityManager bpel;
	
	/** The process. */
	protected Process process;
	
	/** The output var gen. */
	protected Variable outputVarGen;

	protected IFolder processFolder;
	
	/**
	 * Instantiates a new writer ui bpel.
	 *
	 * @param process the process
	 * @param iFile the i file
	 * @param folder 
	 * @throws CoreException 
	 * @throws IOException 
	 */
	public WriterUiBpel(Process process, IFile iFile, IContainer container) throws CoreException, IOException {
		super();
		this.process = process;
		bpel = new EntityManager();
		bpel.configureProcess(iFile, process, container);
	}
	
	public OutputStream getOutput(){
		return bpel.getOutputStream();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#write(org.eclipse.bpel.model.resource.BPELResource, java.io.OutputStream, java.util.Map)
	 */
	public void write(BPELResource resource, Map<?, ?> args)
			throws IOException {
		OutputStream out = bpel.getOutputStream();
		super.write(resource, out, args);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#onEvent2XML(org.eclipse.bpel.model.OnEvent)
	 */
	@Override
	protected Element onEvent2XML(OnEvent onEvent) {
		Element onEventElement = createBPELElement("onEvent");
		if (onEvent.getPartnerLink() != null
				&& onEvent.getPartnerLink().getName() != null) {
			onEventElement.setAttribute("partnerLink", onEvent.getPartnerLink()
					.getName());
		}
		if (onEvent.getPortType() != null
				&& onEvent.getPortType().getQName() != null) {
			onEventElement.setAttribute("portType", ExecutableTransUtil.qNameToString(onEvent,
					onEvent.getPortType().getQName(), process));
		}
		
		if (onEvent.getOperation() != null) {
			onEventElement.setAttribute("operation",
					getOperationSignature(onEvent.getOperation()));
		}
		if (onEvent.getVariable() != null
				&& onEvent.getVariable().getName() != null) {
			onEventElement.setAttribute("variable", onEvent.getVariable()
					.getName());
		}
		if (onEvent.getMessageExchange() != null)
			onEventElement.setAttribute("messageExchange", onEvent
					.getMessageExchange().getName());
		if (onEvent.getMessageType() != null) {
			onEventElement.setAttribute("messageType", ExecutableTransUtil.qNameToString(onEvent,
					onEvent.getMessageType().getQName(), process));
		}
		if (onEvent.getXSDElement() != null) {
			onEventElement.setAttribute("element",
					onEvent.getXSDElement().getQName());
		}
		if (onEvent.getCorrelationSets() != null) {
			onEventElement.appendChild(correlationSets2XML(onEvent
					.getCorrelationSets()));
		}
		if (onEvent.getCorrelations() != null) {
			onEventElement.appendChild(correlations2XML(onEvent
					.getCorrelations()));
		}

		if (onEvent.getActivity() != null) {
			onEventElement.appendChild(activity2XML(onEvent.getActivity()));
		}

		if (onEvent.getFromParts() != null) {
			onEventElement.appendChild(fromParts2XML(onEvent.getFromParts()));
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(onEvent, onEventElement);

		extensibleElement2XML(onEvent, onEventElement);
		return onEventElement;
	}
	
	protected Element receive2XML(Receive activity) {
		Element activityElement = super.receive2XML(activity);
		if (!activity.isSetCreateInstance()){
			return activityElement;
		}

		Sequence s = BPELFactory.eINSTANCE.createSequence();
		s.setName("initializationSequence");
		Element seqElement = createBPELElement("sequence");

		GeneratorOperationManager genOpManager = bpel.getGeneratorOperationManager();
		Operation genIdOperation = genOpManager.getOperation();
		Variable inputVar = genOpManager.getInputVar();
		outputVarGen = genOpManager.getOutputVar();
		
		//================== Initialization =============
		Assign assignBefore = genIdInit(genIdOperation, inputVar);
		//================== INVOKE =====================
		Invoke i = genIdInvoke(genIdOperation, inputVar);
		
		seqElement.appendChild(activityElement);
		seqElement.appendChild(assign2XML(assignBefore));
		seqElement.appendChild(invoke2XML(i));
		
		s.getActivities().add(assignBefore);
		s.getActivities().add(i);
		
		addCommonActivityItems(seqElement, s);
		return seqElement;
	}
	
	protected Element correlationSets2XML(CorrelationSets correlationSets) {

		Element correlationSetsElement = super.correlationSets2XML(correlationSets);
		if (correlationSetsElement == null) {
			correlationSetsElement = createBPELElement("correlationSets");

			// serialize local namespace prefixes to XML
			serializePrefixes(correlationSets, correlationSetsElement);
			extensibleElement2XML(correlationSets, correlationSetsElement);
		}
		for (CorrelationSet innerCS : bpel.getCorrelationSets()) {
			correlationSetsElement.appendChild(correlationSet2XML(innerCS));
		}
		return correlationSetsElement;
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#process2XML(org.eclipse.bpel.model.Process)
	 */
	protected Element process2XML(Process process) {
		Element processElement = createBPELElement("process");
		if (process.getName() != null)
			processElement.setAttribute("name", process.getName());
		if (process.getTargetNamespace() != null)
			processElement.setAttribute("targetNamespace", process
					.getTargetNamespace());
		if (process.isSetSuppressJoinFailure())
			processElement.setAttribute("suppressJoinFailure", BPELUtils
					.boolean2XML(process.getSuppressJoinFailure()));
		if (process.getExitOnStandardFault() != null)
			processElement.setAttribute("exitOnStandardFault", BPELUtils
					.boolean2XML(process.getExitOnStandardFault()));
		if (process.isSetVariableAccessSerializable())
			processElement.setAttribute("variableAccessSerializable", BPELUtils
					.boolean2XML(process.getVariableAccessSerializable()));
		if (process.isSetQueryLanguage())
			processElement.setAttribute("queryLanguage", process
					.getQueryLanguage());
		if (process.isSetExpressionLanguage())
			processElement.setAttribute("expressionLanguage", process
					.getExpressionLanguage());
		if (process.isSetAbstractProcessProfile())
			processElement.setAttribute("abstractProcessProfile", process
					.getAbstractProcessProfile());

		Import uiManager = bpel.getImportBPEL();
		Import userEvent = bpel.getImportUserEvent();
		
		List<String> importNamespaces = new LinkedList<String>();
		for (Import next : process.getImports()) {
			importNamespaces.add(next.getNamespace());
			if (next.getNamespace().equals(uiManager.getNamespace()))
				processElement.appendChild(import2XML(uiManager));
			if (next.getNamespace().equals(userEvent.getNamespace()))
				processElement.appendChild(import2XML(userEvent));
			processElement.appendChild(import2XML(next));
		}
		
		if(!importNamespaces.contains(uiManager.getNamespace())){
			processElement.appendChild(import2XML(uiManager));
		}

		if(!importNamespaces.contains(userEvent.getNamespace())){
			processElement.appendChild(import2XML(userEvent));
		}

		if (process.getPartnerLinks() != null
				&& !process.getPartnerLinks().getChildren().isEmpty())
			processElement.appendChild(partnerLinks2XML(process
					.getPartnerLinks()));

		//TODO Fix empty variables
		if (process.getVariables() != null
				&& !process.getVariables().getChildren().isEmpty()){
			Element original = super.variables2XML(process.getVariables());
			for (Variable next : bpel.getUiVariables()) {
				original.appendChild(variable2XML(next));
			}
			processElement.appendChild(original);
		}

		if (process.getCorrelationSets() == null){
			process.setCorrelationSets(BPELFactory.eINSTANCE.createCorrelationSets());
		}
		processElement.appendChild(correlationSets2XML(process
					.getCorrelationSets()));

		if (process.getExtensions() != null)
			processElement.appendChild(extensions2XML(process.getExtensions()));

		if (process.getFaultHandlers() != null)
			processElement.appendChild(faultHandlers2XML(process
					.getFaultHandlers()));

		if (process.getEventHandlers() != null)
			processElement.appendChild(eventHandler2XML(process
					.getEventHandlers()));

		if (process.getMessageExchanges() != null
				&& !process.getMessageExchanges().getChildren().isEmpty())
			processElement.appendChild(messageExchanges2XML(process
					.getMessageExchanges()));

		if (process.getActivity() != null)
			processElement.appendChild(activity2XML(process.getActivity()));

		extensibleElement2XML(process, processElement);

		return processElement;
	}

	private Assign genIdInit(Operation genIdOperation, Variable inputVar) {
		Assign assignBefore = BPELFactory.eINSTANCE.createAssign();
		assignBefore.setName("IdGenerationConfiguration");
		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		To t = createToPart(inputVar, genIdOperation);
		f.setLiteral(ExecutableTransUtil.
				createDefaultInitializer(t.getVariable(), t.getPart(), 
				new String[0]));
		c.setFrom(f);
		c.setTo(t);
		assignBefore.getCopy().add(c);
		return assignBefore;
	}

	private Invoke genIdInvoke(Operation genIdOperation, Variable inputVar) {
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeGenProcessId");
		i.setInputVariable(inputVar);
		i.setOutputVariable(outputVarGen);
		i.setOperation(genIdOperation);
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		Correlations cc = BPELFactory.eINSTANCE.createCorrelations();
		Correlation processCorrelation = BPELFactory.eINSTANCE.createCorrelation();
		processCorrelation.setInitiate(CorrelationSection.YES);
		CorrelationSet eventCorrelationSet = bpel.getEventInteractionManager().getCorrelationSet();
		//processCorrelation.setSet(bpel.getUserEventCorrelationSet());
		processCorrelation.setSet(eventCorrelationSet);
		processCorrelation.setPattern(CorrelationPattern.get(CorrelationPattern.RESPONSE));
		cc.getChildren().add(processCorrelation);
		i.setCorrelations(cc);
		return i;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#partnerLinks2XML(org.eclipse.bpel.model.PartnerLinks)
	 */
	protected Element partnerLinks2XML(PartnerLinks partnerLinks) {
		
		Element original = super.partnerLinks2XML(partnerLinks);
		
		original.appendChild(partnerLink2XML(bpel.getPartnerLinkBPEL()));
		original.appendChild(partnerLink2XML(bpel.getPartnerLinkUserEvent()));
		
		return original;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#extensionActivity2XML(org.eclipse.bpel.model.ExtensionActivity)
	 */
	protected Element extensionActivity2XML(ExtensionActivity activity) {

		if (activity instanceof DataSelectionUI) {
			return dealWithDataSelectionUI((DataSelectionUI) activity);
		} else if (activity instanceof DataOutputUI) {
			return dealWithDataOutputUI((DataOutputUI) activity);
		} else if (activity instanceof DataInputUI) {
			DataInputUI dataInput = (DataInputUI) activity;
			if (dataInput.isCreateInstance())
				return dataInputUIReveive((DataInputUI) activity);
			else
				return dealWithDataInputUI((DataInputUI) activity); 
				
		}  else if (activity instanceof ScopeUI) {
			return dealWithScopeUI((ScopeUI) activity);
		}

		return super.extensionActivity2XML(activity);
	}

	private Element dataInputUIReveive(DataInputUI activity) {
		Element activityElement = createBPELElement("receive");

		activityElement.setAttribute("partnerLink", bpel.getPartnerLinkUserEvent().getName());

		activityElement.setAttribute("operation",
					getOperationSignature(bpel.getEventInteractionManager().getStartingOperation()));

		activityElement.setAttribute("variable", bpel.getEventInteractionManager().getVariable(activity.getId()).getName());

		activityElement.setAttribute("createInstance", BPELUtils
					.boolean2XML(true));

		Correlations ci = BPELFactory.eINSTANCE.createCorrelations();
		Correlation cr = BPELFactory.eINSTANCE.createCorrelation();
		cr.setSet(bpel.getEventInteractionManager().getStartCorrelationSet());
		cr.setInitiate(CorrelationSection.YES);
		//cr.setPattern(CorrelationPattern.get(CorrelationPattern.REQUESTRESPONSE));
		ci.getChildren().add(cr);
		activityElement.appendChild(correlations2XML(ci));

		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	/**
	 * Deal with scope ui.
	 *
	 * @param activity the activity
	 * @return the element
	 */
	private Element dealWithScopeUI(ScopeUI activity) {
		Element activityElement = createBPELElement("scope");

		if (activity.isSetIsolated())
			activityElement.setAttribute("isolated", BPELUtils
					.boolean2XML(activity.getIsolated()));
		if (activity.isSetExitOnStandardFault())
			activityElement.setAttribute("exitOnStandardFault", BPELUtils
					.boolean2XML(activity.getExitOnStandardFault()));
		if (activity.getVariables() != null
				&& !activity.getVariables().getChildren().isEmpty())
			activityElement.appendChild(variables2XML(activity.getVariables()));
		if (activity.getCorrelationSets() != null
				&& !activity.getCorrelationSets().getChildren().isEmpty())
			activityElement.appendChild(correlationSets2XML(activity
					.getCorrelationSets()));
		if (activity.getPartnerLinks() != null
				&& !activity.getPartnerLinks().getChildren().isEmpty())
			activityElement.appendChild(partnerLinks2XML(activity
					.getPartnerLinks()));
		if (activity.getFaultHandlers() != null)
			activityElement.appendChild(faultHandlers2XML(activity
					.getFaultHandlers()));
		if (activity.getCompensationHandler() != null)
			activityElement.appendChild(compensationHandler2XML(activity
					.getCompensationHandler()));
		if (activity.getTerminationHandler() != null)
			activityElement.appendChild(terminationHandler2XML(activity
					.getTerminationHandler()));
		if (activity.getEventHandlers() != null)
			activityElement.appendChild(eventHandlerUi2XML((EventHandlerUI)activity
					.getEventHandlers()));
		if (activity.getMessageExchanges() != null
				&& !activity.getMessageExchanges().getChildren().isEmpty())
			activityElement.appendChild(messageExchanges2XML(activity
					.getMessageExchanges()));
		if (activity.getActivity() != null)
			activityElement.appendChild(activity2XML(activity.getActivity()));

		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	private Node eventHandlerUi2XML(EventHandlerUI eventHandler) {
		Element eventHandlerElement = createBPELElement("eventHandlers");

		for (Object name : eventHandler.getEvents()) {
			OnEvent onEvent = (OnEvent) name;
			eventHandlerElement.appendChild(onEvent2XML(onEvent));
		}
		for (Object name : eventHandler.getAlarm()) {
			OnAlarm onAlarm = (OnAlarm) name;
			eventHandlerElement.appendChild(onAlarm2XML(onAlarm));
		}
		for (Object name : eventHandler.getUserInteraction()) {
			EventInteractionManager genOpManager = bpel.getEventInteractionManager();
			OnUserEvent onUiEvent = (OnUserEvent) name;
			onUiEvent.setElement(eventHandlerElement);
			OnEvent userInteractionEvent = BPELFactory.eINSTANCE.createOnEvent();
			userInteractionEvent.setActivity(onUiEvent.getActivity());
			userInteractionEvent.setPartnerLink(bpel.getPartnerLinkUserEvent());
			userInteractionEvent.setOperation(bpel.getEventOperation());
			userInteractionEvent.setVariable(genOpManager.getVariable(onUiEvent.getId()));
			Correlations cc = BPELFactory.eINSTANCE.createCorrelations();
			Correlation processCorrelation = BPELFactory.eINSTANCE.createCorrelation();
			processCorrelation.setInitiate(CorrelationSection.NO);
			CorrelationSet eventCorrelationSet = bpel.getEventInteractionManager().getCorrelationSet();
			processCorrelation.setSet(eventCorrelationSet);
			cc.getChildren().add(processCorrelation);
			userInteractionEvent.setCorrelations(cc);
			
			eventHandlerElement.appendChild(onEvent2XML(userInteractionEvent));
		}
		// serialize local namespace prefixes to XML
		serializePrefixes(eventHandler, eventHandlerElement);
		extensibleElement2XML(eventHandler, eventHandlerElement);
		return eventHandlerElement;
	}

	/**
	 * Deal with data output ui.
	 *
	 * @param activity the activity
	 * @return the element
	 */
	private Element dealWithDataOutputUI(DataOutputUI activity) {

		Sequence s = BPELFactory.eINSTANCE.createSequence();
		
		InteractionOperation op = bpel.getDataInteractionManager().getOperation(activity.getId());

		Assign assignbBefore = BPELFactory.eINSTANCE.createAssign();
		assignbBefore.setName("DataOutputConfiguration");
		
		DataItem[] dataItems = activity.getOutputItem().toArray(new DataItem[0]);
		
		//================== Initialization =====================
		Copy initCopy = createInitCopy(op, dataItems);
		
		//================== ROLE =====================
		Copy roleCopy = createCopyRole(activity, op);
		
		//================== ID =====================
		Copy idCopy = createCopyId(activity, op);
		
		//================== Process ID =====================
		Copy genCopy = createCopyProcessID(activity, op);
		
		//================== COPY DATA ITEM =====================
		List<Copy> dataItemCopies = new LinkedList<Copy>();
		if (dataItems != null)
			for (int i = 0; i < dataItems.length; i++) {
				DataItem dataItem = dataItems[i];
				Copy dataItemContentCopy = createCopyDataItemContentBefore(
						dataItem, i+1, op, "data", "data");
				Copy cid = createCopyDataItemIdBefore(
						dataItem, i+1, op, "data", "id");
				
				dataItemCopies.add(dataItemContentCopy);
				dataItemCopies.add(cid);
			}
		//================== Configuring the ASSIGN BEFORE =====================
		assignbBefore.getCopy().add(initCopy);
		assignbBefore.getCopy().add(roleCopy);
		assignbBefore.getCopy().add(idCopy);
		assignbBefore.getCopy().add(genCopy);
		assignbBefore.getCopy().addAll(dataItemCopies);
		
		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataOutput");
		i.setInputVariable(op.getInputVariable());
		i.setOutputVariable(op.getOutputVariable());
		i.setOperation(op.getOperation());
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		Correlations ci = BPELFactory.eINSTANCE.createCorrelations();
		for (Correlation cs : op.getCorrelationSet()) {
			ci.getChildren().add(cs);
		}
		i.setCorrelations(ci);
		
		//================== Configuring the SEQUENCE =====================
		s.getActivities().add(assignbBefore);
		s.getActivities().add(i);

		return super.sequence2XML(s);
	}

	//TODO refactory here with the createCopyDataItemContentBefore
	private Copy createCopyDataItemIdBefore(DataItem dataItem, int index,
			InteractionOperation op, String primaryNode, String secondaryNode) {
		String dataItemName = dataItem.getVariable().getName();
		
		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		String expression = "'"+dataItemName+"'";
		Expression fromExpr = BPELFactory.eINSTANCE.createExpression();
		f.setExpression(fromExpr);
		fromExpr.setBody(expression);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(primaryNode+"["+index+"]/"+secondaryNode);
		t.setQuery(toQuery);
		t.setVariable(op.getInputVariable());
		t.setPart(op.getInputOperationPart());
		
		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	private Copy createInitCopy(InteractionOperation op,
			final DataItem[] dataItems) {
		String[] dataItemTypes = parseDataItems(dataItems);
		
		Copy initCopy = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		To t = BPELFactory.eINSTANCE.createTo();
		t.setVariable(op.getInputVariable());
		t.setPart(op.getInputOperationPart());
		f.setLiteral(ExecutableTransUtil.
				createDefaultInitializer(t.getVariable(), t.getPart(), 
				dataItemTypes));
		initCopy.setFrom(f);
		initCopy.setTo(t);
		return initCopy;
	}

	private String[] parseDataItems(final DataItem[] dataItems) {
		String[] types;
		if (dataItems == null)
			types = new String[0];
		else {
			types = new String[dataItems.length];
			for (int i = 0; i < dataItems.length; i++) {
				types[i] = dataItems[i].getType().getName();
			}
		}
		return types;
	}

	/**
	 * Creates the copy process id.
	 *
	 * @param genOutputVar the gen output var
	 * @param genPat the gen pat
	 * @param inputVar the input var
	 * @param outputPart the output part
	 * @param string the string
	 * @return the copy
	 */
	private Copy createCopyProcessID(DataInteraction dataInteraction, InteractionOperation op) {
		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("processId");
		f.setQuery(toQuery);
		f.setVariable(op.getGenVariable());
		f.setPart(op.getGenOperationPart());
		
		To t = BPELFactory.eINSTANCE.createTo();
		toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("processId");
		t.setQuery(toQuery);
		t.setVariable(op.getInputVariable());
		t.setPart(op.getInputOperationPart());
		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	/**
	 * Creates the data item before copy.
	 *
	 * @param inputVar the input var
	 * @param prefix the prefix
	 * @param p the p
	 * @param cont the cont
	 * @param di the di
	 * @param primaryNode the primary node
	 * @param secondaryNode the secondary node
	 * @return the copy
	 */
	private Copy createCopyDataItemContentBefore(DataItem dataItem, int index, InteractionOperation op, String primaryNode, String secondaryNode) {
		String dataItemName = dataItem.getVariable().getName();
		
		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		String expression = "$"+dataItemName;
		Expression fromExpr = BPELFactory.eINSTANCE.createExpression();
		f.setExpression(fromExpr);
		fromExpr.setBody(expression);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(primaryNode+"["+index+"]/"+secondaryNode);
		t.setQuery(toQuery);
		t.setVariable(op.getInputVariable());
		t.setPart(op.getInputOperationPart());
		
		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	/**
	 * Creates the to part.
	 *
	 * @param inputVar the input var
	 * @param inputOperation the input operation
	 * @return the to
	 */
	private To createToPart(Variable inputVar, Operation inputOperation) {
		To t = BPELFactory.eINSTANCE.createTo();
		t.setVariable(inputVar);
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
		return t;
	}

	/**
	 * Creates the copy id.
	 *
	 * @param id the id
	 * @param inputVar the input var
	 * @param prefix the prefix
	 * @param inputOperation the input operation
	 * @return the copy
	 */
	private Copy createCopyId(DataInteraction dataInteraction, InteractionOperation op) {		
		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+dataInteraction.getId()+"'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("userInteracId");
		t.setQuery(toQuery);
		t.setVariable(op.getInputVariable());
		//FIXME Get the name from some other way or create a constant
		t.setPart(op.getInputOperationPart());
		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	/**
	 * Creates the copy role.
	 *
	 * @param inputVar the input var
	 * @param prefix the prefix
	 * @param inputOperation the input operation
	 * @param role the role
	 * @return the copy
	 */
	private Copy createCopyRole(DataInteraction dataInteraction, InteractionOperation op) {
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		UserRole role = dataInteraction.getUserRoles().get(0);
		e.setBody("'"+role.getRoleId()+"'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("role");
		t.setQuery(toQuery);
		t.setVariable(op.getInputVariable());
		t.setPart(op.getInputOperationPart());
		
		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	/**
	 * Deal with data selection ui.
	 *
	 * @param selctionActivity the activity
	 * @return the element
	 */
	private Element dealWithDataSelectionUI(DataSelectionUI activity) {
		Sequence s = BPELFactory.eINSTANCE.createSequence();
		
		InteractionOperation op = bpel.getDataInteractionManager().getOperation(activity.getId());

		//TODO when should I do it?
		//String prefix = BPELUtils.getNamespacePrefix(inputVar, 
		//inputVar.getMessageType().getQName().getNamespaceURI())+":";

		Assign assignBefore = BPELFactory.eINSTANCE.createAssign();
		assignBefore.setName("DataSelectionConfiguration");
		
		DataItem[] dataItems = activity.getOutputItem().toArray(new DataItem[0]);
		
		//================== Initialization =====================
		Copy initCopy = createInitCopy(op, dataItems);
		
		//================== ROLE =====================
		Copy roleCopy = createCopyRole(activity, op);
		
		//================== ID =====================
		Copy idCopy = createCopyId(activity, op);
		
		//================== Process ID =====================
		Copy genCopy = createCopyProcessID(activity, op);
		
		//================== COPY DATA ITEM =====================
		List<Copy> dataItemCopies = new LinkedList<Copy>();
		if (activity.getOutputItem() != null)
			for (int i = 0; i < dataItems.length; i++) {
				DataItem dataItem = dataItems[i];
				Copy dataItemContentCopy = createCopyDataItemContentBefore(dataItem, i+1, op, "data", "data");
				Copy cid = createCopyDataItemIdBefore(dataItem, i+1, op, "data", "id");

				dataItemCopies.add(dataItemContentCopy);
				dataItemCopies.add(cid);
			}
		//================== Configuring the ASSIGN BEFORE =====================
		assignBefore.getCopy().add(initCopy);
		assignBefore.getCopy().add(roleCopy);
		assignBefore.getCopy().add(idCopy);
		assignBefore.getCopy().add(genCopy);
		assignBefore.getCopy().addAll(dataItemCopies);

		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataSelection");
		i.setInputVariable(op.getInputVariable());
		i.setOutputVariable(op.getOutputVariable());
		i.setOperation(op.getOperation());
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		Correlations ci = BPELFactory.eINSTANCE.createCorrelations();
		for (Correlation cs : op.getCorrelationSet()) {
			ci.getChildren().add(cs);
		}
		i.setCorrelations(ci);
		
		//================== COPY DATA ITEM =====================
		List<Copy> dataItemCopiesAfter = new LinkedList<Copy>();
		if (activity.getInputItem() != null)
			for (DataItem di : activity.getInputItem()) {
				Copy dataItemContentCopy = createDataItemContentAfterCopy(di, op, "data", "data");
				dataItemCopiesAfter.add(dataItemContentCopy);
			}
		
		s.getActivities().add(assignBefore);
		s.getActivities().add(i);
		
		if (dataItemCopiesAfter.size() > 0) {
			Assign after = BPELFactory.eINSTANCE.createAssign();
			after.setName("ResponseToDataItems");
			after.getCopy().addAll(dataItemCopiesAfter);
			s.getActivities().add(after);
		}

		return super.sequence2XML(s);
	}

	private Copy createDataItemContentAfterCopy(DataItem di,
			InteractionOperation op, String primaryNode, String secondaryNode) {
		String dataItemName = di.getVariable().getName();
		
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(primaryNode+"[id='"+dataItemName+"']/"+secondaryNode);
		f.setQuery(toQuery);
		f.setVariable(op.getOutputVariable());
		f.setPart(op.getOutputOperationPart());

		To t = BPELFactory.eINSTANCE.createTo();
		t.setVariable(di.getVariable());
		
		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	/**
	 * Deal with data input ui.
	 *
	 * @param activity the activity
	 * @return the element
	 */
	private Element dealWithDataInputUI(DataInputUI activity) {
		Sequence s = BPELFactory.eINSTANCE.createSequence();
		
		InteractionOperation op = bpel.getDataInteractionManager().getOperation(activity.getId());
		System.out.println("op="+op);
		System.out.println("id="+activity.getId());

		//TODO when should I do it?
		//String prefix = BPELUtils.getNamespacePrefix(inputVar, 
		//inputVar.getMessageType().getQName().getNamespaceURI())+":";

		Assign assignBefore = BPELFactory.eINSTANCE.createAssign();
		assignBefore.setName("DataInputConfiguration");
		
		//================== Initialization =====================
		Copy initCopy = createInitCopy(op, null);
		
		//================== ROLE =====================
		Copy roleCopy = createCopyRole(activity, op);
		
		//================== ID =====================
		Copy idCopy = createCopyId(activity, op);
		
		//================== Process ID =====================
		Copy genCopy = createCopyProcessID(activity, op);

		//================== Configuring the ASSIGN BEFORE =====================
		assignBefore.getCopy().add(initCopy);
		assignBefore.getCopy().add(roleCopy);
		assignBefore.getCopy().add(idCopy);
		assignBefore.getCopy().add(genCopy);

		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataInput");
		i.setInputVariable(op.getInputVariable());
		i.setOutputVariable(op.getOutputVariable());
		i.setOperation(op.getOperation());
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		Correlations ci = BPELFactory.eINSTANCE.createCorrelations();
		for (Correlation cs : op.getCorrelationSet()) {
			ci.getChildren().add(cs);
		}
		i.setCorrelations(ci);
		
		//================== COPY DATA ITEM =====================
		List<Copy> dataItemCopiesAfter = new LinkedList<Copy>();
		if (activity.getInputItem() != null)
			for (DataItem di : activity.getInputItem()) {
				Copy dataItemContentCopy = createDataItemContentAfterCopy(di, op, "data", "data");
				dataItemCopiesAfter.add(dataItemContentCopy);
			}
		
		s.getActivities().add(assignBefore);
		s.getActivities().add(i);
		
		if (dataItemCopiesAfter.size() > 0) {
			Assign after = BPELFactory.eINSTANCE.createAssign();
			after.setName("ResponseToDataItems");
			after.getCopy().addAll(dataItemCopiesAfter);
			s.getActivities().add(after);
		}

		return super.sequence2XML(s);
	}

	/**
	 * Serialize prefixes.
	 *
	 * @param eObject the e object
	 * @param context the context
	 */
	private void serializePrefixes(EObject eObject, Element context) {
		INamespaceMap<String, String> nsMap = BPELUtils
				.getNamespaceMap(eObject);
		if (!nsMap.isEmpty()) {
			for( Map.Entry<String,String> entry : nsMap.entrySet()) {
				String prefix = entry.getKey();
				String namespace = entry.getValue();
				if (prefix.length() == 0)
					context.setAttributeNS(XSDConstants.XMLNS_URI_2000,
							"xmlns", namespace);
				else
					context.setAttributeNS(XSDConstants.XMLNS_URI_2000,
							"xmlns:" + prefix, namespace);
			}
		}
	}

}
