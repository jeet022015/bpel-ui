package be.ac.fundp.precise.ui_bpel.ui.popup.actions;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;

import org.usixml.aui.auiPackage.AbstractUIModel;

import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.AUIGenerator;
import be.ac.fundp.precise.ui_bpel.ui.transformation.executBPEL.WriterUiBpel;

public class PopupActionGenerateBPEL implements IObjectActionDelegate {

	private Shell shell = null;

	private ResourceSet resourceSet = new ResourceSetImpl();
	
	private AUIGenerator auiGen = new AUIGenerator();

	private IFile bpelFile = null;
	private Resource bpelResource = null;
	
	private WriterUiBpel newWriter;

	public PopupActionGenerateBPEL() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		IWorkbenchPartSite site = targetPart.getSite();
		shell = site.getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {

		// load BPEL,WSDL,XSDs
		Process process = loadBPEL();
		newWriter = new WriterUiBpel(process);

		if (process != null) {
			EList<Import> imports = process.getImports();
			Iterator<Import> importIterator = imports.iterator();
			while (importIterator.hasNext()) {
				Import current = importIterator.next();
				String relPath = current.getLocation();
			}
		}

		try {
			//String path = bpelFile.getParent().getFullPath().toOSString()+IPath.SEPARATOR+"newBPEL.test";
			String path ="/Users/Neto/Documents/runtime-EclipseApplication/NewUiBpel/bpelContent/newBPEL.test";
			//File f = bpelFile.getFullPath().toFile();
			File f = new File (path);
			OutputStream out = new BufferedOutputStream( new FileOutputStream(path));
			Map<?, ?> args =  new HashMap();
			newWriter.write((BPELResource) bpelResource, out, args);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//createAuiModel(process);

		MessageDialog.openInformation(shell, "BPEL Extensions UI Sample Plug-in",
				"Generated AUI for the Process: " + process.getName());
	}

	private void createAuiModel(Process process) {
		
		AbstractUIModel model = auiGen.createAUI(process);
		
		// Register the XMI resource factory for the .website extension
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("model", new XMIResourceFactoryImpl());

		// Create a resource
		String path = bpelFile.getParent().getFullPath().toOSString()+IPath.SEPARATOR+"AUI.model";
		Resource resource = getResourceSet().createResource(URI
				.createURI("platform:/resource"+path));

		resource.getContents().add(model);

		// Now save the content.
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof StructuredSelection) {
			StructuredSelection sSel = (StructuredSelection) selection;
			bpelFile = (IFile) sSel.getFirstElement();
		}
	}

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

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

}