package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.CorrelationPattern;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.Receive;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.adapters.INamespaceMap;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.XSD2XMLGenerator;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.properties.CorrelationSection;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDConstants;
import org.w3c.dom.Element;

import be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL.manager.DataInteractionManager;
import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;
import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.ScopeUI;

/**
 * The Class WriterUiBpel.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class WriterUiBpel extends BPELWriter {

	/** The Constant EMPTY_STRING. */
	protected static final String EMPTY_STRING = null;
	
	/** The Constant HEAD_STRING. */
	protected static final String HEAD_STRING =  "xmlns:s1=\"http://www.w3.org/2001/XMLSchema-instance\" " +
 		    "xmlns:s2=\"http://www.w3.org/2001/XMLSchema\" " +
 		    "s1:type=\"s2:string\">";
	
	/** The Constant NL. */
	protected static final String NL = System.getProperty("line.separator");
	
	/** The bpel. */
	protected BpelUIUtil bpel;
	
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
	public WriterUiBpel(Process process, IFile iFile) throws CoreException, IOException {
		super();
		this.process = process;
		bpel = new BpelUIUtil();
		bpel.configureProcess(iFile, process);
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
			onEventElement.setAttribute("portType", qNameToString(onEvent,
					onEvent.getPortType().getQName()));
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
			onEventElement.setAttribute("messageType", qNameToString(onEvent,
					onEvent.getMessageType().getQName()));
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

		// TODO: Why do we have this? I don't think OnEvent is extensible.
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

		Operation genIdOperation = bpel.getGenIdOperation();
		
		Variable[] vars = bpel.getGenIdVar();
		
		Variable inputVar = vars[0].getName().startsWith(DataInteractionManager.
				getDefaultRequestNames(DataInteractionManager.GEN_ID_OPERATION)) ? vars[0] : vars[1];
		outputVarGen = vars[0].getName().startsWith(DataInteractionManager.
				getDefaultResponseNames(DataInteractionManager.GEN_ID_OPERATION)) ? vars[0] : vars[1];
		
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
		correlationSetsElement.appendChild(correlationSet2XML(bpel.getUserEventCorrelationSet()));
		return correlationSetsElement;
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#process2XML(org.eclipse.bpel.model.Process)
	 */
	protected Element process2XML(Process process) {
		
		//addInvoke(process.getActivity());
		
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

		if (process.getVariables() != null
				&& !process.getVariables().getChildren().isEmpty())
			processElement.appendChild(variables2XML(process.getVariables()));

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
		createDefaultInitializer(null, f, t, 0);
		c.setFrom(f);
		c.setTo(t);
		assignBefore.getCopy().add(c);
		return assignBefore;
	}

	private Invoke genIdInvoke(Operation genIdOperation, Variable inputVar) {
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataInput");
		i.setInputVariable(inputVar);
		i.setOutputVariable(outputVarGen);
		i.setOperation(genIdOperation);
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		
		
		Correlations cc = BPELFactory.eINSTANCE.createCorrelations();
		Correlation processCorrelation = BPELFactory.eINSTANCE.createCorrelation();
		processCorrelation.setInitiate(CorrelationSection.YES);
		processCorrelation.setSet(bpel.getUserEventCorrelationSet());
		processCorrelation.setPattern(CorrelationPattern.get(CorrelationPattern.RESPONSE));
		cc.getChildren().add(processCorrelation);
		i.setCorrelations(cc);
		return i;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#variables2XML(org.eclipse.bpel.model.Variables)
	 */
	protected Element variables2XML(Variables variables) {
		Element original = super.variables2XML(variables);
		//variables.getChildren().addAll(bpel.getUiVariables());
		for (Variable next : bpel.getUiVariables()) {
			original.appendChild(variable2XML(next));
		}
		return original;
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
			return dealWithDataInputUI((DataInputUI) activity);
		}  else if (activity instanceof ScopeUI) {
			return dealWithScopeUI((ScopeUI) activity);
		}

		return super.extensionActivity2XML(activity);
	}

	/**
	 * Deal with scope ui.
	 *
	 * @param activity the activity
	 * @return the element
	 */
	private Element dealWithScopeUI(ScopeUI activity) {
		EventHandlerUI uiHandler = (EventHandlerUI)activity.getEventHandlers();
		if (uiHandler != null) {
			for (OnUserEvent aOnUserEvent : uiHandler.getUserInteraction()) {
				OnEvent userInteractionEvent = BPELFactory.eINSTANCE.createOnEvent();
				
				userInteractionEvent.setActivity(aOnUserEvent.getActivity());
				
				userInteractionEvent.setPartnerLink(bpel.getPartnerLinkUserEvent());
				userInteractionEvent.setOperation(bpel.getEventOperation());
				userInteractionEvent.setVariable(bpel.getVariableForUserInteraction(aOnUserEvent.getId())[0]);
				Correlations cc = BPELFactory.eINSTANCE.createCorrelations();
				Correlation processCorrelation = BPELFactory.eINSTANCE.createCorrelation();
				processCorrelation.setInitiate(CorrelationSection.NO);
				processCorrelation.setSet(bpel.getUserEventCorrelationSet());
				cc.getChildren().add(processCorrelation);
				userInteractionEvent.setCorrelations(cc);
				uiHandler.getEvents().add(userInteractionEvent);
			}
		}
		return scope2XML(activity);
	}

	/**
	 * Deal with data output ui.
	 *
	 * @param activity the activity
	 * @return the element
	 */
	private Element dealWithDataOutputUI(DataOutputUI activity) {

		Sequence s = BPELFactory.eINSTANCE.createSequence();
		
		Variable[] vars = bpel.getVariableForUserInteraction(activity.getId());
		
		Variable inputVar = vars[0];
		
		//String prefix = BPELUtils.getNamespacePrefix(inputVar, 
		//inputVar.getMessageType().getQName().getNamespaceURI())+":";
		//TODO when should I do it?
		String prefix = "";

		Assign assignbBefore = BPELFactory.eINSTANCE.createAssign();
		assignbBefore.setName("DataOutputConfiguration");
		
		Operation inputOperation = bpel.getOutputOperation();
		Operation genOperation = bpel.getGenIdOperation();
		
		//================== Initialization =====================
		Copy initCopy = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		To t = createToPart(inputVar, inputOperation);
		createDefaultInitializer(null, f, t, activity.getOutputItem().size());
		initCopy.setFrom(f);
		initCopy.setTo(t);
		
		//================== ROLE =====================
		String role = activity.getUserRoles().size() > 0 ? activity.getUserRoles().get(0).getRoleId() : "roleDefault";

		Copy roleCopy = createCopyRole(inputVar, prefix, inputOperation, role);
		
		//================== ID =====================
		Copy idCoppy = createCopyId(activity.getId(), inputVar, prefix, inputOperation);
		
		//================== Process ID =====================
		Part genPart = (Part) genOperation.getInput().getMessage().getPart("parameters");
		Part outputPart = (Part) inputOperation.getInput().getMessage().getPart("parameters");
		Copy genCoppy = createCopyProcessID(outputVarGen,genPart, inputVar,outputPart, "processid");
		
		//================== COPY DATA ITEM =====================
		int cont = 1;
		List<Copy> dataItemCopies = new LinkedList<Copy>();
		for (DataItem di : activity.getOutputItem()) {
			Part p = (Part) inputOperation.getInput().getMessage().getPart("parameters");
			Copy c = createDataItemBeforeCopy(inputVar, prefix, p, cont, di, "data", "data");
			dataItemCopies.add(c);
			cont++;
		}

		//================== Configuring the ASSIGN BEFORE =====================
		assignbBefore.getCopy().add(initCopy);
		assignbBefore.getCopy().add(roleCopy);
		assignbBefore.getCopy().add(idCoppy);
		assignbBefore.getCopy().add(genCoppy);
		assignbBefore.getCopy().addAll(dataItemCopies);
		
		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataOutput");
		i.setInputVariable(inputVar);
		i.setOperation(inputOperation);
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		
		//================== Configuring the SEQUENCE =====================
		s.getActivities().add(assignbBefore);
		s.getActivities().add(i);

		return super.sequence2XML(s);
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
	private Copy createCopyProcessID(Variable genOutputVar, Part genPat, Variable inputVar,
			Part outputPart ,String string) {
		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("processId");
		f.setQuery(toQuery);
		f.setVariable(genOutputVar);
		f.setPart(genPat);
		
		To t = BPELFactory.eINSTANCE.createTo();
		toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(string);
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		//FIXME Get the name from some other way or create a constant
		t.setPart(outputPart);
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
	private Copy createDataItemBeforeCopy(Variable inputVar, String prefix,
			Part p, int cont, DataItem di, String primaryNode, String secondaryNode) {
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		String expression = "$"+di.getVariable().getName();
		Expression fromExpr = BPELFactory.eINSTANCE.createExpression();
		f.setExpression(fromExpr);
		fromExpr.setBody(expression);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+primaryNode+"["+cont+"]/"+secondaryNode);
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		t.setPart(p);
		
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
	private Copy createCopyId(String id, Variable inputVar,
			String prefix, Operation inputOperation) {		
		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+id+"'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+"userInteracId");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		//FIXME Get the name from some other way or create a constant
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
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
	private Copy createCopyRole(Variable inputVar, String prefix,
			Operation inputOperation, String role) {
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+role+"'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+"role");
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		//FIXME Get the name from some other way or create a constant
		t.setPart((Part) inputOperation.getInput().getMessage().getPart("parameters"));
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
	private Element dealWithDataSelectionUI(DataSelectionUI selctionActivity) {
		Sequence s = BPELFactory.eINSTANCE.createSequence();
		
		Variable[] vars = bpel.getVariableForUserInteraction(selctionActivity.getId());
		
		Variable inputVar = vars[0].getName().startsWith(DataInteractionManager.
				getDefaultRequestNames(DataInteractionManager.SELECTION_OPERATION)) ? vars[0] : vars[1];
		Variable outputVar = vars[0].getName().startsWith(DataInteractionManager.
				getDefaultResponseNames(DataInteractionManager.SELECTION_OPERATION)) ? vars[0] : vars[1];

		Assign assignBefore = BPELFactory.eINSTANCE.createAssign();
		assignBefore.setName("DataSelectionConfiguration");
		
		//String prefix = BPELUtils.getNamespacePrefix(inputVar, 
		//inputVar.getMessageType().getQName().getNamespaceURI())+":";
		//TODO when should i do it?
		String prefix = "";
		
		Operation selectionOperation = bpel.getSelectionOperation();
		Operation genOperation = bpel.getGenIdOperation();
		
		//================== Initialization =====================
		Copy initCopy = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		To t = createToPart(inputVar, selectionOperation);
		createDefaultInitializer(null, f, t, selctionActivity.getOutputItem().size());
		initCopy.setFrom(f);
		initCopy.setTo(t);
		assignBefore.getCopy().add(initCopy);
		
		//================== ROLE =====================
		String role = selctionActivity.getUserRoles().size() > 0 ? selctionActivity.getUserRoles().get(0).getRoleId() : "roleDefault";

		Copy roleCopy = createCopyRole(inputVar, prefix, selectionOperation, role);
		assignBefore.getCopy().add(roleCopy);
		
		//================== ID =====================
		Copy idCoppy = createCopyId(selctionActivity.getId(), inputVar, prefix, selectionOperation);
		assignBefore.getCopy().add(idCoppy);
		
		//================== Process ID =====================
		Part genPart = (Part) genOperation.getInput().getMessage().getPart("parameters");
		Part outputPart = (Part) selectionOperation.getInput().getMessage().getPart("parameters");
		Copy genCoppy = createCopyProcessID(outputVarGen,genPart, inputVar,outputPart, "processId");
		assignBefore.getCopy().add(genCoppy);
		
		//================== COPY DATA ITEM =====================
		int cont = 1;
		List<Copy> dataItemCopiesBefore = new LinkedList<Copy>();
		for (DataItem di : selctionActivity.getOutputItem()) {
			Part p = (Part) selectionOperation.getInput().getMessage().getPart("parameters");
			Copy c = createDataItemBeforeCopy(inputVar, prefix, p, cont, di, "data", "data");
			dataItemCopiesBefore.add(c);
			Copy cid = createIdDataItemBeforeCopy(inputVar, prefix, p, cont, di, "data", "id");
			dataItemCopiesBefore.add(cid);
			cont++;
		}
		
		if (dataItemCopiesBefore.size() > 0)
			assignBefore.getCopy().addAll(dataItemCopiesBefore);

		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataSelection");
		i.setInputVariable(inputVar);
		i.setOutputVariable(outputVar);
		i.setOperation(selectionOperation);
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		
		//================== COPY DATA ITEM =====================
		List<Copy> dataItemCopiesAfter = new LinkedList<Copy>();
		cont = 1;
		for (DataItem di : selctionActivity.getInputItem()) {
			Part p = (Part) selectionOperation.getOutput().getMessage().getPart("parameters");
			Copy c = createDataItemCopy(outputVar, prefix, p, cont, di, "return", "data");
			cont++;
			dataItemCopiesAfter.add(c);
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

	private Copy createIdDataItemBeforeCopy(Variable inputVar, String prefix,
			Part p, int cont, DataItem di, String primaryNode, String secondaryNode) {
		Copy c = BPELFactory.eINSTANCE.createCopy();
		
		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'"+di.getVariable().getName()+"'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+primaryNode+"["+cont+"]/"+secondaryNode);
		t.setQuery(toQuery);
		t.setVariable(inputVar);
		t.setPart(p);
		
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
		
		Variable[] vars = bpel.getVariableForUserInteraction(activity.getId());
		
		Variable inputVar = vars[0].getName().startsWith(DataInteractionManager.
				getDefaultRequestNames(DataInteractionManager.INPUT_OPERATION)) ? vars[0] : vars[1];
		Variable outputVar = vars[0].getName().startsWith(DataInteractionManager.
				getDefaultResponseNames(DataInteractionManager.INPUT_OPERATION)) ? vars[0] : vars[1];
				
		//String prefix = BPELUtils.getNamespacePrefix(inputVar, 
				//inputVar.getMessageType().getQName().getNamespaceURI());
		//TODO when do I must to do it?
		//definition.getPrefix
		//Ask it from BpelUIUtil
		String prefix = "";

		Assign assignBefore = BPELFactory.eINSTANCE.createAssign();
		assignBefore.setName("DataInputConfiguration");
		
		Operation inputOperation = bpel.getInputOperation();
		Operation genOperation = bpel.getGenIdOperation();
		
		//================== Initialization ====================
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		To t = createToPart(inputVar, inputOperation);
		createDefaultInitializer(null, f, t, 0);
		c.setFrom(f);
		c.setTo(t);
		assignBefore.getCopy().add(c);
				
		//================== ROLE =====================
		String role = activity.getUserRoles().size() > 0 ? activity.getUserRoles().get(0).getRoleId() : "roleDefault";

		c = createCopyRole(inputVar, prefix, inputOperation, role);
		assignBefore.getCopy().add(c);
		
		//================== Process ID =====================
		Part genPart = (Part) genOperation.getInput().getMessage().getPart("parameters");
		Part outputPart = (Part) inputOperation.getInput().getMessage().getPart("parameters");
		Copy genCoppy = createCopyProcessID(outputVarGen, genPart, inputVar, outputPart, "processId");
		assignBefore.getCopy().add(genCoppy);
		
		//================== ID =====================
		Copy idCoppy = createCopyId(activity.getId(), inputVar, prefix, inputOperation);
		assignBefore.getCopy().add(idCoppy);

		//================== INVOKE =====================
		Invoke i = BPELFactory.eINSTANCE.createInvoke();
		i.setName("InvokeDataInput");
		i.setInputVariable(inputVar);
		i.setOutputVariable(outputVar);
		i.setOperation(inputOperation);
		i.setPartnerLink(bpel.getPartnerLinkBPEL());
		
		//================== COPY DATA ITEM =====================
		List<Copy> copies = new LinkedList<Copy>();
		int cont = 1;
		for (DataItem di : activity.getInputItem()) {
			Part p = (Part) inputOperation.getOutput().getMessage().getPart("parameters");
			c = createDataItemCopy(outputVar, prefix, p, cont, di, "data", "data");
			cont++;
			copies.add(c);
		}
		
		//================== Configuring the SEQUENCE =====================
		s.getActivities().add(assignBefore);
		s.getActivities().add(i);
		
		if (copies.size() > 0) {
			Assign assignaAfter = BPELFactory.eINSTANCE.createAssign();
			assignaAfter.setName("ResponseToDataItems");
			assignaAfter.getCopy().addAll(copies);
			s.getActivities().add(assignaAfter);
		}

		return super.sequence2XML(s);
	}

	/**
	 * Creates the data item copy.
	 *
	 * @param outputVar the output var
	 * @param prefix the prefix
	 * @param part the part
	 * @param cont the cont
	 * @param di the di
	 * @param primaryNode the primary node
	 * @param secondaryNode the secondary node
	 * @return the copy
	 */
	private Copy createDataItemCopy(Variable outputVar, String prefix,
			Part part, int cont, DataItem di, String primaryNode, String secondaryNode) {
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(prefix+primaryNode+"["+cont+"]/"+prefix+secondaryNode);
		f.setQuery(toQuery);
		f.setVariable(outputVar);
		f.setPart(part);

		To t = BPELFactory.eINSTANCE.createTo();
		t.setVariable(di.getVariable());
		
		c.setFrom(f);
		c.setTo(t);
		return c;
	}
	
	
	/**
	 * Construct an appropriate XML literal initializer for the given "from" and "to" parts.
	 *
	 * @param bpelEditor the bpel editor
	 * @param from the from
	 * @param to the to
	 * @param dataItems the data items
	 * @return the string
	 */
	public static String createDefaultInitializer(BPELEditor bpelEditor, From from, To to, int dataItems) {
		String literal = EMPTY_STRING;
		if ( from!=null && to!=null) {
			literal = from.getLiteral();
			if (literal==null || literal.isEmpty()) {
				literal = createDefaultInitializer(bpelEditor, to.getVariable(), to.getPart(), dataItems);
				from.setLiteral(literal);
			}
		}
		return literal;
	}
	
	/**
	 * Construct an appropriate XML literal initializer for the given variable and message part.
	 *
	 * @param bpelEditor the bpel editor
	 * @param var - the variable to be initialized
	 * @param part - if the variable is defined as a message, this is the message part
	 * otherwise null
	 * @param dataItems the data items
	 * @return - XML string representing an intializer for the given variable
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	 * @see https://jira.jboss.org/browse/JBIDE-7351
	 */
	public static String createDefaultInitializer(BPELEditor bpelEditor, Variable var, Part part, int dataItems) {
		String fromString = EMPTY_STRING;
		try {
			String rootElement = null;
			String uriWSDL = null;

			// Variable is defined using "messageType"
			Message msg = (Message)var.getMessageType();
			if (msg != null) {
				//if (msg.eIsProxy()) {
					//FIXME it works???
					//msg = (Message)EmfModelQuery.resolveProxy(bpelEditor.getProcess(), msg);
				//}
				if (part==null) {
					Map parts = msg.getParts();
					if (parts!=null && !parts.isEmpty()) {
						Map.Entry entry = (Map.Entry)parts.entrySet().iterator().next();
						part = (Part)entry.getValue();
					}
				}
				if (part!=null) {
					XSDElementDeclaration declaration = part.getElementDeclaration();
					if (declaration != null) {
						uriWSDL = declaration.getSchema().getSchemaLocation();
						rootElement = declaration.getName();
					}
				}
			}

			// Variable is defined using "type"
			XSDTypeDefinition type = var.getType();
			if (type != null) {
				QName qname = new QName(type.getTargetNamespace(), type.getName());
				rootElement = qname.getLocalPart();
				uriWSDL = type.eResource().getURI().toString();
			}

			// Variable is defined using "element"
			XSDElementDeclaration element = var.getXSDElement();
			if (element != null) {
				QName qname = new QName(element.getTargetNamespace(), element
						.getName());
				rootElement = qname.getLocalPart();
				uriWSDL = element.eResource().getURI().toString();
			}

			XSD2XMLGenerator generator = new XSD2XMLGenerator(uriWSDL, rootElement);
			fromString = generator.createXML();
		}
		catch (Exception e) {
		}
		//fromString = fromString.replaceAll("", "");
		
		//TODO this regex is just to String type
		//this code replace the any xsi:type="anyType" by the representation of string
		//HEAD_STRING+ "Data" +tail
		String finalSt = fromString;
		Pattern pattern = Pattern.compile("<[a-zA-Z]*:?data>.*</[a-zA-Z]*:?data>", Pattern.DOTALL);;
		Matcher matcher = pattern.matcher(fromString);
		if (matcher.find()){
			String myShit = matcher.group();
			String tail = ("</"+ myShit.split("data")[1].replaceAll("\\s|<|>|"+NL, "") + "data>").trim();
			String head = myShit.replaceAll("xsi:type=\"anyType\"/>", HEAD_STRING+ "Data" +tail);
			
			String body = "";
			
			for (int i = 0; i < dataItems; i++) {
				body += head;
			}
			
			finalSt = pattern.split(fromString)[0] + body + pattern.split(fromString)[1];
		}
		return finalSt;
	}
	
	// public NamespacePrefixManager getNamespacePrefixManager() {
	// return bpelNamespacePrefixManager;
	// }
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
	
	/**
	 * Q name to string.
	 *
	 * @param eObject the e object
	 * @param qname the qname
	 * @return the string
	 */
	private String qNameToString(EObject eObject, QName qname) {
		EObject context = eObject;
		List<String> prefixes = null;
		String namespace = qname.getNamespaceURI();

		if (namespace == null || namespace.length() == 0) {
			return qname.getLocalPart();
		}

		// Transform BPEL namespaces to the latest version so that
		// references to the old namespace are not serialized.
		if (BPELConstants.isBPELNamespace(namespace)) {
			namespace = BPELConstants.NAMESPACE;
		}
		while (context != null) {
			INamespaceMap<String, String> prefixNSMap = BPELUtils
					.getNamespaceMap(context);
			prefixes = prefixNSMap.getReverse(namespace);
			if (!prefixes.isEmpty()) {
				String prefix = prefixes.get(0);
				if (!prefix.equals(""))
					return prefix + ":" + qname.getLocalPart();
				else
					return qname.getLocalPart();
			}
			context = context.eContainer();
		}
		// if a prefix is not found for the namespaceURI, create a new
		// prefix
		return addNewRootPrefix("ns", namespace) + ":" + qname.getLocalPart();
	}
	
	/**
	 * Adds the new root prefix.
	 *
	 * @param basePrefix the base prefix
	 * @param namespace the namespace
	 * @return the string
	 */
	private String addNewRootPrefix(String basePrefix, String namespace) {
		INamespaceMap<String, String> nsMap = BPELUtils
				.getNamespaceMap(process);

		List<String> prefixes = nsMap.getReverse(namespace);
		if (prefixes.isEmpty()) {
			int i = 0;
			String prefix = basePrefix;
			while (nsMap.containsKey(prefix)) {
				prefix = basePrefix + i;
				i++;
			}
			nsMap.put(prefix, namespace);
			return prefix;
		} else {
			return prefixes.get(0);
		}
	}
}
