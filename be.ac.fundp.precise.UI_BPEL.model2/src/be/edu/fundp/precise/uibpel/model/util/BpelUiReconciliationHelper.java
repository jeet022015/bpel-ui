package be.edu.fundp.precise.uibpel.model.util;

import java.util.List;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.impl.BPELExtensibilityElementImpl;
import org.eclipse.bpel.model.impl.BPELExtensibleElementImpl;
import org.eclipse.bpel.model.impl.CorrelationSetsImpl;
import org.eclipse.bpel.model.impl.MessageExchangesImpl;
import org.eclipse.bpel.model.impl.PartnerLinksImpl;
import org.eclipse.bpel.model.impl.VariablesImpl;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ElementFactory;
import org.eclipse.bpel.model.util.ElementPlacer;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.WSDLElement;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.UserRole;

/**
 * The Class BpelUiReconciliationHelper.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class BpelUiReconciliationHelper extends ReconciliationHelper{
	
	/** The self. */
	protected static BpelUiReconciliationHelper self;
	
	/**
	 * Instantiates a new bpel ui reconciliation helper.
	 */
	protected BpelUiReconciliationHelper(){
		super();
	}
	
	/**
	 * Gets the single instance of BpelUiReconciliationHelper.
	 *
	 * @return single instance of BpelUiReconciliationHelper
	 */
	public static BpelUiReconciliationHelper getInstance(){
		if(self == null)
			self = new BpelUiReconciliationHelper();
		return self;
	}
	
	/**
	 * Adopt child.
	 *
	 * @param parent the parent
	 * @param children the children
	 * @param newChild the new child
	 * @param nodeName the node name
	 */
	public static void adoptChild(WSDLElement parent, List<? extends WSDLElement> children, WSDLElement newChild, String nodeName) {
		boolean oldUpdatingDom = myIsUpdatingDom(parent);
		try {
			mySetUpdatingDom(parent, true);
			
			if (isLoading(parent) || parent.getElement() == null) {
				return;
			}
			Element parseElement = parent.getElement();
			
			if (parent instanceof ExtensionActivity) {
				parseElement = getExtensionActivityChildElement(parseElement);
			}
			if (newChild.getElement() == null) {
				//I CHANGE HERE
				if (newChild instanceof DataItem){
					newChild.setElement(BpelUiElementFactory.getInstance().createElement(newChild, parent));
				} else if (newChild instanceof OnUserEvent){
					newChild.setElement(BpelUiElementFactory.getInstance().createElement(newChild, parent));
				} else if (newChild instanceof UserRole){
					newChild.setElement(BpelUiElementFactory.getInstance().createElement(newChild, parent));
				} else {
					newChild.setElement(ElementFactory.getInstance().createElement(newChild, parent));
				}
			}
			if (newChild.getElement().getParentNode() == parseElement) {
				// already in the dom tree
				return;
			}
			int index = children.indexOf(newChild);
			List<Element> domChildren;
			if (parent instanceof Sequence || parent instanceof Flow) {
				domChildren = getActivities(parseElement);
			} else {
				domChildren = ReconciliationHelper.getBPELChildElementsByLocalName(parseElement, nodeName);
			}
			if (index >= domChildren.size()) {
				ElementPlacer.placeChild(parent, newChild.getElement());
			} else {
				ElementPlacer.niceInsertBefore(parent, newChild.getElement(), domChildren.get(index));
			}
		} finally {
			mySetUpdatingDom(parent, oldUpdatingDom);
		}
	}

	/**
	 * Patch dom ui.
	 *
	 * @param child the child
	 * @param parent the parent
	 * @param parentElement the parent element
	 * @param before the before
	 * @param beforeElement the before element
	 */
	public void patchDomUI(EObject child, EObject parent, Node parentElement, EObject before, Node beforeElement) {
         if (child instanceof EventHandlerUI) {
	    	// fix https://bugs.eclipse.org/bugs/show_bug.cgi?id=330308
	    	EventHandler e = (EventHandlerUI)child;
	    	EList<OnEvent> _onEvent = e.getEvents();
	    	OnEvent on = _onEvent.get(0);
	    	Element onElement = ReconciliationHelper.getBPELChildElementByLocalName(e.getElement(), BPELConstants.ND_ON_EVENT);
	    	on.setElement(onElement);
	    	reconcile(on, onElement);
	    } if (child instanceof OnUserEvent) {
	    	OnUserEvent o = (OnUserEvent)child;
	    	Activity a = o.getActivity();
	    	Element s = ReconciliationHelper.getBPELChildElementByLocalName(o.getElement(), BPELConstants.ND_SCOPE);
	    	a.setElement(s);
	    	reconcile(a, s);
	    } else {
	    	super.patchDom(child, parent, parentElement, before, beforeElement);
	    }
	}
	
	
	/**
	 * My set updating dom.
	 *
	 * @param element the element
	 * @param updatingDOM the updating dom
	 */
	private static void mySetUpdatingDom(WSDLElement element, boolean updatingDOM) {
		if (element instanceof BPELExtensibleElementImpl) {
			((BPELExtensibleElementImpl) element).setUpdatingDOM(updatingDOM);			
		} else if (element instanceof BPELExtensibilityElementImpl) {
			((BPELExtensibilityElementImpl) element).setUpdatingDOM(updatingDOM);			
		}
	}

	/**
	 * My is updating dom.
	 *
	 * @param parent the parent
	 * @return true, if successful
	 */
	private static boolean myIsUpdatingDom(WSDLElement parent) {
		if (parent instanceof BPELExtensibleElementImpl) {
			return ((BPELExtensibleElementImpl) parent).isUpdatingDOM();			
		} else if (parent instanceof BPELExtensibilityElementImpl) {
			return ((BPELExtensibilityElementImpl) parent).isUpdatingDOM();			
		} 
		return false;
	}
	
	/**
	 * Orphan child.
	 *
	 * @param parent the parent
	 * @param child the child
	 */
	public static void orphanChild(WSDLElement parent, WSDLElement child) {
		boolean oldUpdatingDom = isUpdatingDom(parent);
		try {
			setUpdatingDom(parent, true);
			if (isLoading(parent) || parent.getElement() == null) {
				return;
			}
			if (parent.getElement() != null && child.getElement() != null
					&& child.getElement().getParentNode() == parent.getElement()) {
				parent.getElement().removeChild(child.getElement());
			}
			
			// We should delete enclosing element only if child has been 
			// deleted from GUI (parent.isReconciling == false)
			// If we delete child in source tab then parent should be kept intact 
	
			// Remove <variables> if there are no children
			if ((child instanceof Variable) && (((Variables) parent).getChildren().size() == 0) && !((VariablesImpl)parent).isReconciling()){
				if (parent.getContainer() instanceof Process)
					((Process) parent.getContainer()).setVariables(null);
				else if (parent.getContainer() instanceof Scope)
					((Scope) parent.getContainer()).setVariables(null);
				else
					throw new IllegalStateException();
			}
			// Remove <partnerlinks> if there are no children
			if ((child instanceof PartnerLink) && (((PartnerLinks) parent).getChildren().size() == 0) && !((PartnerLinksImpl)parent).isReconciling()){
				if (parent.getContainer() instanceof Process)
					((Process) parent.getContainer()).setPartnerLinks(null);
				else if (parent.getContainer() instanceof Scope)
					((Scope) parent.getContainer()).setPartnerLinks(null);
				else
					throw new IllegalStateException();
			}
			// Remove <correlationsets> if there are no children
			if ((child instanceof CorrelationSet) && (((CorrelationSets) parent).getChildren().size() == 0) && !((CorrelationSetsImpl)parent).isReconciling()){
				if (parent.getContainer() instanceof Process)
					((Process) parent.getContainer()).setCorrelationSets(null);
				else if (parent.getContainer() instanceof Scope)
					((Scope) parent.getContainer()).setCorrelationSets(null);
				else
					throw new IllegalStateException();
			}
			// Remove <messageExchanges> if there are no children
			if ((child instanceof MessageExchange) && (((MessageExchanges) parent).getChildren().size() == 0) && !((MessageExchangesImpl)parent).isReconciling()) {
				if (parent.getContainer() instanceof Process)
					((Process) parent.getContainer()).setMessageExchanges(null);
				else if (parent.getContainer() instanceof Scope)
					((Scope) parent.getContainer()).setMessageExchanges(null);
				else
					throw new IllegalStateException();
			}
			if (child instanceof Catch && parent instanceof Invoke) {								
				Invoke invoke = (Invoke)parent;
				FaultHandler faultHandler = invoke.getFaultHandler();
				if (faultHandler.getCatch().size() == 0 && faultHandler.getCatchAll() == null) {
					invoke.setFaultHandler(null);
				}
			}
		} finally {
			setUpdatingDom(parent, oldUpdatingDom);
		}
	}
	
	/**
	 * Replace child.
	 *
	 * @param parent the parent
	 * @param oldElement the old element
	 * @param newElement the new element
	 */
	public static void replaceChild(WSDLElement parent, WSDLElement oldElement,
			WSDLElement newElement) {
		boolean oldUpdatingDom = isUpdatingDom(parent);
		try {
			setUpdatingDom(parent, true);		
			
			if (isLoading(parent)) {
				return;
			}

			Element parseElement = parent.getElement();

			if (parent instanceof ExtensionActivity) {
				parseElement = getExtensionActivityChildElement(parseElement);
			}

			if (parseElement == null) {
				System.err.println("trying to replace child on null element: "
						+ parent.getClass());
				return;
			}
			if (oldElement == newElement) {
				return;
			}
			if (newElement != null) {
				if (newElement.getElement() == null) {
					//I CHANGE HERE
					if (newElement instanceof EventHandlerUI){
						newElement.setElement(BpelUiElementFactory.getInstance().createElement(newElement, parent));
					} else {
						Element newDomElement = ElementFactory.getInstance()
								.createElement(newElement, parent);
						if (newDomElement == null) {
							return;
						}
						newElement.setElement(newDomElement);
					}
				}
				if (oldElement != null
						&& oldElement.getElement() != null
						&& parseElement == oldElement.getElement()
								.getParentNode()) {
					parseElement.replaceChild(newElement.getElement(),
							oldElement.getElement());
				} else {
					ElementPlacer.placeChild(parent, newElement.getElement());
				}
			} else if (oldElement != null
					&& oldElement.getElement() != null
					&& parseElement == oldElement.getElement()
							.getParentNode()) {
				ElementPlacer.niceRemoveChild(parent, oldElement.getElement());
			}
		} finally {
			setUpdatingDom(parent, oldUpdatingDom);
		}
	}
	
	/**
	 * Checks if is updating dom.
	 *
	 * @param element the element
	 * @return true, if is updating dom
	 */
	static boolean isUpdatingDom(WSDLElement element) {
		if (element instanceof BPELExtensibleElementImpl) {
			return ((BPELExtensibleElementImpl) element).isUpdatingDOM();			
		} else if (element instanceof BPELExtensibilityElementImpl) {
			return ((BPELExtensibilityElementImpl) element).isUpdatingDOM();			
		} 
		return false;
	}
	
	/**
	 * Sets the updating dom.
	 *
	 * @param element the element
	 * @param updatingDOM the updating dom
	 */
	static void setUpdatingDom(WSDLElement element, boolean updatingDOM) {
		if (element instanceof BPELExtensibleElementImpl) {
			((BPELExtensibleElementImpl) element).setUpdatingDOM(updatingDOM);			
		} else if (element instanceof BPELExtensibilityElementImpl) {
			((BPELExtensibilityElementImpl) element).setUpdatingDOM(updatingDOM);			
		} 
	}

}
