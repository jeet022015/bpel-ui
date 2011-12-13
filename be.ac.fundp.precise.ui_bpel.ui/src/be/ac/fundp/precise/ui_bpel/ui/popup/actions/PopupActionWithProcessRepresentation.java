package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.util.Collections;

import org.eclipse.bpel.model.Process;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;

// TODO: Auto-generated Javadoc
/**
 * The Class PopupActionWithProcessRepresentation.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
abstract public class PopupActionWithProcessRepresentation  implements IObjectActionDelegate {
	
	/** The shell. */
	private Shell shell = null;

	/** The resource set. */
	private ResourceSet resourceSet = new ResourceSetImpl();

	/** The bpel file. */
	private IFile bpelFile = null;
	
	/** The bpel resource. */
	private Resource bpelResource = null;

	/**
	 * Instantiates a new popup action with process representation.
	 */
	public PopupActionWithProcessRepresentation() {
		super();
	}

	/**
	 * Sets the active part.
	 *
	 * @param action the action
	 * @param targetPart the target part
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		IWorkbenchPartSite site = targetPart.getSite();
		shell = site.getShell();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	abstract public void run(IAction action);

	/**
	 * Selection changed.
	 *
	 * @param action the action
	 * @param selection the selection
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof StructuredSelection) {
			StructuredSelection sSel = (StructuredSelection) selection;
			bpelFile = (IFile) sSel.getFirstElement();
		}
	}

	/**
	 * Load bpel.
	 *
	 * @return the process
	 */
	protected Process loadBPEL() {

		IPath fullProcessPath = bpelFile.getFullPath();
		URI uri = URI.createPlatformResourceURI(fullProcessPath.toString(), false);
		bpelResource = getResourceSet().getResource(uri, true);

		EcorePackage instance = EcorePackage.eINSTANCE;
		instance.eAdapters();

		try {
			bpelResource.load(Collections.EMPTY_MAP);
			EList<EObject> contents = bpelResource.getContents();
			if (!contents.isEmpty()) {
				return (Process) contents.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * Gets the resource set.
	 *
	 * @return the resource set
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	/**
	 * Gets the shell.
	 *
	 * @return the shell
	 */
	public Shell getShell() {
		return shell;
	}
	
	/**
	 * Gets the bpel file.
	 *
	 * @return the bpel file
	 */
	public IFile getBpelFile() {
		return bpelFile;
	}
	
	/**
	 * Gets the bpel resource.
	 *
	 * @return the bpel resource
	 */
	public Resource getBpelResource() {
		return bpelResource;
	}

}
