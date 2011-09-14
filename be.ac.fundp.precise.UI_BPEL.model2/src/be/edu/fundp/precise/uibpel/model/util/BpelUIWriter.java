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

public class BpelUIWriter extends org.eclipse.bpel.model.resource.BPELWriter {
	private Document staticDoc;
	private BpelUiSerializer mySer = new BpelUiSerializer();

	public BpelUIWriter(
			org.eclipse.bpel.model.resource.BPELResource bpelResource,
			Document document) {
		super(bpelResource, document);
		staticDoc = document;
	}

	@Override
	protected Element createBPELElement(String tagName) {
		return super.createBPELElement(tagName);
	}

	@Override
	public Element activity2XML(org.eclipse.bpel.model.Activity activity) {
		return super.activity2XML(activity);
	}

	@Override
	protected Element variable2XML(Variable variable) {
		return super.variable2XML(variable);
	}

	@Override
	protected Element variables2XML(Variables variables) {
		return super.variables2XML(variables);
	}

	@Override
	protected Element completionCondition2XML(
			CompletionCondition completionCondition) {
		return super.completionCondition2XML(completionCondition);
	}

	@Override
	protected Element expression2XML(Expression expression, String elementName) {
		return super.expression2XML(expression, elementName);
	}

	@Override
	protected Element branches2XML(Branches branches) {
		return super.branches2XML(branches);
	}

	@Override
	protected Element extensibilityElement2XML(
			ExtensibilityElement extensibilityElement) {
		return super.extensibilityElement2XML(extensibilityElement);
	}

	@Override
	protected Element correlationSets2XML(CorrelationSets correlationSets) {
		return super.correlationSets2XML(correlationSets);
	}

	@Override
	protected Element fromParts2XML(FromParts fromParts) {
		return super.fromParts2XML(fromParts);
	}

	@Override
	protected Element fromPart2XML(FromPart fromPart) {
		return super.fromPart2XML(fromPart);
	}

	@Override
	protected Element toParts2XML(ToParts toParts) {
		return super.toParts2XML(toParts);
	}

	@Override
	protected Element toPart2XML(ToPart toPart) {
		return super.toPart2XML(toPart);
	}

	@Override
	protected Element correlationSet2XML(CorrelationSet correlationSet) {
		return super.correlationSet2XML(correlationSet);
	}

	@Override
	protected Element partnerLinks2XML(PartnerLinks partnerLinks) {
		return super.partnerLinks2XML(partnerLinks);
	}

	@Override
	protected Element messageExchanges2XML(MessageExchanges messageExchanges) {
		return super.messageExchanges2XML(messageExchanges);
	}

	@Override
	protected Element elseIf2XML(ElseIf elseIf) {
		return super.elseIf2XML(elseIf);
	}

	@Override
	protected Element else2XML(Else _else) {
		return super.else2XML(_else);
	}

	@Override
	protected Element onAlarm2XML(OnAlarm onAlarm) {
		return super.onAlarm2XML(onAlarm);
	}

	@Override
	protected Element onMessage2XML(OnMessage onMsg) {
		return super.onMessage2XML(onMsg);
	}

	@Override
	protected Element onEvent2XML(OnEvent onEvent) {
		return super.onEvent2XML(onEvent);
	}

	@Override
	protected Element copy2XML(Copy copy) {
		return super.copy2XML(copy);
	}

	@Override
	protected Element catch2XML(Catch _catch) {
		return super.catch2XML(_catch);
	}

	@Override
	protected Element catchAll2XML(CatchAll catchAll) {
		return super.catchAll2XML(catchAll);
	}

	@Override
	protected Element compensationHandler2XML(
			CompensationHandler compensationHandler) {
		return super.compensationHandler2XML(compensationHandler);
	}

	@Override
	protected void to2XML(To to, Element toElement) {
		super.to2XML(to, toElement);
	}

	@Override
	protected void from2XML(From from, Element fromElement) {
		super.from2XML(from, fromElement);
	}

	@Override
	protected Element eventHandler2XML(EventHandler eventHandler) {
		return super.eventHandler2XML(eventHandler);
	}

	@Override
	protected Element partnerLink2XML(PartnerLink partnerLink) {
		return super.partnerLink2XML(partnerLink);
	}

	@Override
	protected Element messageExchange2XML(MessageExchange messageExchange) {
		return super.messageExchange2XML(messageExchange);
	}

	@Override
	protected Element validate2XML(Validate activity) {
		return super.validate2XML(activity);
	}

	@Override
	protected Element query2XML(Query query) {
		return super.query2XML(query);
	}

	@Override
	protected Element faultHandlers2XML(FaultHandler faultHandler) {
		return super.faultHandlers2XML(faultHandler);
	}

	@Override
	protected void faultHandler2XML(Element parentElement,
			FaultHandler faultHandler) {
		super.faultHandler2XML(parentElement, faultHandler);
	}

	@Override
	protected Element import2XML(Import imp) {
		return super.import2XML(imp);
	}

	@Override
	protected Element correlation2XML(Correlation correlation) {
		return super.correlation2XML(correlation);
	}

	@Override
	protected Element correlations2XML(Correlations correlations) {
		return super.correlations2XML(correlations);
	}

	@Override
	protected String properties2XML(CorrelationSet correlationSet) {
		return super.properties2XML(correlationSet);
	}

	@Override
	protected Element link2XML(Link link) {
		return super.link2XML(link);
	}

	@Override
	protected Element links2XML(Links links) {
		return super.links2XML(links);
	}

	@Override
	protected Element extension2XML(Extension extension) {
		return super.extension2XML(extension);
	}

	@Override
	protected Element extensions2XML(Extensions extensions) {
		return super.extensions2XML(extensions);
	}

	@Override
	protected Element terminationHandler2XML(
			TerminationHandler terminationHandler) {
		return super.terminationHandler2XML(terminationHandler);
	}

	@Override
	protected Element source2XML(Source source) {
		return super.source2XML(source);
	}

	@Override
	protected Element sources2XML(Sources sources) {
		return super.sources2XML(sources);
	}

	@Override
	protected Element target2XML(Target target) {
		return super.target2XML(target);
	}

	@Override
	protected Element targets2XML(Targets targets) {
		return super.targets2XML(targets);
	}

	@Override
	protected Element serviceRef2XML(ServiceRef serviceRef) {
		return super.serviceRef2XML(serviceRef);
	}

	@Override
	protected Node serviceRefValue2XML(ServiceRef serviceRef) {
		return super.serviceRefValue2XML(serviceRef);
	}

	@Override
	protected Element documentation2XML(Documentation documentation) {
		return super.documentation2XML(documentation);
	}

	public Element dataItem2XML(DataItem element) {
		//TODO WORKS?
		String namespace = element.eClass().getEPackage().getNsURI();
		Element elem = (Element) mySer.dataItem2XML(element, staticDoc,
				namespace, getResource().getProcess(), BpelUiConstants.ND_INPUT_ITEM);
		return elem;
	}

	public Element onUserEventImpl2XML(OnUserEvent element) {
		String namespace = element.eClass().getEPackage().getNsURI();
		Element elem = (Element) mySer.onUserEvent2XML(element, staticDoc,
				namespace, getResource().getProcess(), this);
		return elem;
	}

	public Element eventHandlerUI2XML(EventHandlerUI element) {
		String namespace = element.eClass().getEPackage().getNsURI();
		Element elem = (Element) mySer.eventUIHandler2XML(element, staticDoc,
				namespace, getResource().getProcess(), this);
		return elem;
	}
}