package be.edu.fundp.precise.uibpel.model.util;

import javax.wsdl.extensions.ExtensibilityElement;

import org.eclipse.bpel.model.Branches;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.CatchAll;
import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.CompletionCondition;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.Documentation;
import org.eclipse.bpel.model.Else;
import org.eclipse.bpel.model.ElseIf;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.Extension;
import org.eclipse.bpel.model.Extensions;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.FromPart;
import org.eclipse.bpel.model.FromParts;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Links;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.ServiceRef;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.ToPart;
import org.eclipse.bpel.model.ToParts;
import org.eclipse.bpel.model.Validate;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.UserRole;

/**
 * The Class BpelUIWriter.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class BpelUIWriter extends org.eclipse.bpel.model.resource.BPELWriter {
	
	/** The static doc. */
	private Document staticDoc;
	
	/** The my ser. */
	private BpelUiSerializer mySer = new BpelUiSerializer();

	/**
	 * Instantiates a new bpel ui writer.
	 *
	 * @param bpelResource the bpel resource
	 * @param document the document
	 */
	public BpelUIWriter(
			org.eclipse.bpel.model.resource.BPELResource bpelResource,
			Document document) {
		super(bpelResource, document);
		staticDoc = document;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#createBPELElement(java.lang.String)
	 */
	@Override
	protected Element createBPELElement(String tagName) {
		return super.createBPELElement(tagName);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#activity2XML(org.eclipse.bpel.model.Activity)
	 */
	@Override
	public Element activity2XML(org.eclipse.bpel.model.Activity activity) {
		return super.activity2XML(activity);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#variable2XML(org.eclipse.bpel.model.Variable)
	 */
	@Override
	protected Element variable2XML(Variable variable) {
		return super.variable2XML(variable);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#variables2XML(org.eclipse.bpel.model.Variables)
	 */
	@Override
	protected Element variables2XML(Variables variables) {
		return super.variables2XML(variables);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#completionCondition2XML(org.eclipse.bpel.model.CompletionCondition)
	 */
	@Override
	protected Element completionCondition2XML(
			CompletionCondition completionCondition) {
		return super.completionCondition2XML(completionCondition);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#expression2XML(org.eclipse.bpel.model.Expression, java.lang.String)
	 */
	@Override
	protected Element expression2XML(Expression expression, String elementName) {
		return super.expression2XML(expression, elementName);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#branches2XML(org.eclipse.bpel.model.Branches)
	 */
	@Override
	protected Element branches2XML(Branches branches) {
		return super.branches2XML(branches);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#extensibilityElement2XML(javax.wsdl.extensions.ExtensibilityElement)
	 */
	@Override
	protected Element extensibilityElement2XML(
			ExtensibilityElement extensibilityElement) {
		return super.extensibilityElement2XML(extensibilityElement);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#correlationSets2XML(org.eclipse.bpel.model.CorrelationSets)
	 */
	@Override
	protected Element correlationSets2XML(CorrelationSets correlationSets) {
		return super.correlationSets2XML(correlationSets);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#fromParts2XML(org.eclipse.bpel.model.FromParts)
	 */
	@Override
	protected Element fromParts2XML(FromParts fromParts) {
		return super.fromParts2XML(fromParts);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#fromPart2XML(org.eclipse.bpel.model.FromPart)
	 */
	@Override
	protected Element fromPart2XML(FromPart fromPart) {
		return super.fromPart2XML(fromPart);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#toParts2XML(org.eclipse.bpel.model.ToParts)
	 */
	@Override
	protected Element toParts2XML(ToParts toParts) {
		return super.toParts2XML(toParts);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#toPart2XML(org.eclipse.bpel.model.ToPart)
	 */
	@Override
	protected Element toPart2XML(ToPart toPart) {
		return super.toPart2XML(toPart);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#correlationSet2XML(org.eclipse.bpel.model.CorrelationSet)
	 */
	@Override
	protected Element correlationSet2XML(CorrelationSet correlationSet) {
		return super.correlationSet2XML(correlationSet);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#partnerLinks2XML(org.eclipse.bpel.model.PartnerLinks)
	 */
	@Override
	protected Element partnerLinks2XML(PartnerLinks partnerLinks) {
		return super.partnerLinks2XML(partnerLinks);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#messageExchanges2XML(org.eclipse.bpel.model.MessageExchanges)
	 */
	@Override
	protected Element messageExchanges2XML(MessageExchanges messageExchanges) {
		return super.messageExchanges2XML(messageExchanges);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#elseIf2XML(org.eclipse.bpel.model.ElseIf)
	 */
	@Override
	protected Element elseIf2XML(ElseIf elseIf) {
		return super.elseIf2XML(elseIf);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#else2XML(org.eclipse.bpel.model.Else)
	 */
	@Override
	protected Element else2XML(Else _else) {
		return super.else2XML(_else);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#onAlarm2XML(org.eclipse.bpel.model.OnAlarm)
	 */
	@Override
	protected Element onAlarm2XML(OnAlarm onAlarm) {
		return super.onAlarm2XML(onAlarm);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#onMessage2XML(org.eclipse.bpel.model.OnMessage)
	 */
	@Override
	protected Element onMessage2XML(OnMessage onMsg) {
		return super.onMessage2XML(onMsg);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#onEvent2XML(org.eclipse.bpel.model.OnEvent)
	 */
	@Override
	protected Element onEvent2XML(OnEvent onEvent) {
		return super.onEvent2XML(onEvent);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#copy2XML(org.eclipse.bpel.model.Copy)
	 */
	@Override
	protected Element copy2XML(Copy copy) {
		return super.copy2XML(copy);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#catch2XML(org.eclipse.bpel.model.Catch)
	 */
	@Override
	protected Element catch2XML(Catch _catch) {
		return super.catch2XML(_catch);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#catchAll2XML(org.eclipse.bpel.model.CatchAll)
	 */
	@Override
	protected Element catchAll2XML(CatchAll catchAll) {
		return super.catchAll2XML(catchAll);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#compensationHandler2XML(org.eclipse.bpel.model.CompensationHandler)
	 */
	@Override
	protected Element compensationHandler2XML(
			CompensationHandler compensationHandler) {
		return super.compensationHandler2XML(compensationHandler);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#to2XML(org.eclipse.bpel.model.To, org.w3c.dom.Element)
	 */
	@Override
	protected void to2XML(To to, Element toElement) {
		super.to2XML(to, toElement);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#from2XML(org.eclipse.bpel.model.From, org.w3c.dom.Element)
	 */
	@Override
	protected void from2XML(From from, Element fromElement) {
		super.from2XML(from, fromElement);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#eventHandler2XML(org.eclipse.bpel.model.EventHandler)
	 */
	@Override
	protected Element eventHandler2XML(EventHandler eventHandler) {
		return super.eventHandler2XML(eventHandler);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#partnerLink2XML(org.eclipse.bpel.model.PartnerLink)
	 */
	@Override
	protected Element partnerLink2XML(PartnerLink partnerLink) {
		return super.partnerLink2XML(partnerLink);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#messageExchange2XML(org.eclipse.bpel.model.MessageExchange)
	 */
	@Override
	protected Element messageExchange2XML(MessageExchange messageExchange) {
		return super.messageExchange2XML(messageExchange);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#validate2XML(org.eclipse.bpel.model.Validate)
	 */
	@Override
	protected Element validate2XML(Validate activity) {
		return super.validate2XML(activity);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#query2XML(org.eclipse.bpel.model.Query)
	 */
	@Override
	protected Element query2XML(Query query) {
		return super.query2XML(query);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#faultHandlers2XML(org.eclipse.bpel.model.FaultHandler)
	 */
	@Override
	protected Element faultHandlers2XML(FaultHandler faultHandler) {
		return super.faultHandlers2XML(faultHandler);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#faultHandler2XML(org.w3c.dom.Element, org.eclipse.bpel.model.FaultHandler)
	 */
	@Override
	protected void faultHandler2XML(Element parentElement,
			FaultHandler faultHandler) {
		super.faultHandler2XML(parentElement, faultHandler);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#import2XML(org.eclipse.bpel.model.Import)
	 */
	@Override
	protected Element import2XML(Import imp) {
		return super.import2XML(imp);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#correlation2XML(org.eclipse.bpel.model.Correlation)
	 */
	@Override
	protected Element correlation2XML(Correlation correlation) {
		return super.correlation2XML(correlation);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#correlations2XML(org.eclipse.bpel.model.Correlations)
	 */
	@Override
	protected Element correlations2XML(Correlations correlations) {
		return super.correlations2XML(correlations);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#properties2XML(org.eclipse.bpel.model.CorrelationSet)
	 */
	@Override
	protected String properties2XML(CorrelationSet correlationSet) {
		return super.properties2XML(correlationSet);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#link2XML(org.eclipse.bpel.model.Link)
	 */
	@Override
	protected Element link2XML(Link link) {
		return super.link2XML(link);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#links2XML(org.eclipse.bpel.model.Links)
	 */
	@Override
	protected Element links2XML(Links links) {
		return super.links2XML(links);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#extension2XML(org.eclipse.bpel.model.Extension)
	 */
	@Override
	protected Element extension2XML(Extension extension) {
		return super.extension2XML(extension);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#extensions2XML(org.eclipse.bpel.model.Extensions)
	 */
	@Override
	protected Element extensions2XML(Extensions extensions) {
		return super.extensions2XML(extensions);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#terminationHandler2XML(org.eclipse.bpel.model.TerminationHandler)
	 */
	@Override
	protected Element terminationHandler2XML(
			TerminationHandler terminationHandler) {
		return super.terminationHandler2XML(terminationHandler);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#source2XML(org.eclipse.bpel.model.Source)
	 */
	@Override
	protected Element source2XML(Source source) {
		return super.source2XML(source);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#sources2XML(org.eclipse.bpel.model.Sources)
	 */
	@Override
	protected Element sources2XML(Sources sources) {
		return super.sources2XML(sources);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#target2XML(org.eclipse.bpel.model.Target)
	 */
	@Override
	protected Element target2XML(Target target) {
		return super.target2XML(target);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#targets2XML(org.eclipse.bpel.model.Targets)
	 */
	@Override
	protected Element targets2XML(Targets targets) {
		return super.targets2XML(targets);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#serviceRef2XML(org.eclipse.bpel.model.ServiceRef)
	 */
	@Override
	protected Element serviceRef2XML(ServiceRef serviceRef) {
		return super.serviceRef2XML(serviceRef);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#serviceRefValue2XML(org.eclipse.bpel.model.ServiceRef)
	 */
	@Override
	protected Node serviceRefValue2XML(ServiceRef serviceRef) {
		return super.serviceRefValue2XML(serviceRef);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.model.resource.BPELWriter#documentation2XML(org.eclipse.bpel.model.Documentation)
	 */
	@Override
	protected Element documentation2XML(Documentation documentation) {
		return super.documentation2XML(documentation);
	}

	/**
	 * Data item2 xml.
	 *
	 * @param element the element
	 * @param type the type
	 * @return the element
	 */
	public Element dataItem2XML(DataItem element, String type) {
		//TODO WORKS?
		String namespace = element.eClass().getEPackage().getNsURI();
		Element elem = (Element) mySer.dataItem2XML(element, staticDoc,
				namespace, getResource().getProcess(), type);
		return elem;
	}

	/**
	 * On user event impl2 xml.
	 *
	 * @param element the element
	 * @param parent the parent
	 * @return the element
	 */
	public Element onUserEventImpl2XML(OnUserEvent element, Object parent) {
		String namespace = element.eClass().getEPackage().getNsURI();
		Element elem = (Element) mySer.onUserEvent2XML(element, staticDoc,
				namespace, getResource().getProcess(), this);
		return elem;
	}

	/**
	 * Event handler u i2 xml.
	 *
	 * @param element the element
	 * @return the element
	 */
	public Element eventHandlerUI2XML(EventHandlerUI element) {
		String namespace = element.eClass().getEPackage().getNsURI();
		Element elem = (Element) mySer.eventUIHandler2XML(element, staticDoc,
				namespace, getResource().getProcess(), this);
		return elem;
	}

	/**
	 * User rolel2 xml.
	 *
	 * @param element the element
	 * @param parent the parent
	 * @return the element
	 */
	public Element userRolel2XML(UserRole element, Object parent) {
		String namespace = element.eClass().getEPackage().getNsURI();
		Element elem = (Element) mySer.userRole2XML(element, staticDoc,
				namespace, getResource().getProcess(), this);
		return elem;
	}
}