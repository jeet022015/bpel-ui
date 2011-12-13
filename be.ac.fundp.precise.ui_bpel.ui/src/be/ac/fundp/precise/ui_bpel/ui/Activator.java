package be.ac.fundp.precise.ui_bpel.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import be.ac.fundp.precise.ui_bpel.ui.factories.ExtensionSampleUIAdapterFactory;
import be.edu.fundp.precise.uibpel.model.ModelPackage;

// TODO: Auto-generated Javadoc
/**
 * The activator class controls the plug-in life cycle.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	/** The Constant PLUGIN_ID. */
	public static final String PLUGIN_ID = "be.ac.fundp.precise.ui_bpel.ui";

	// The shared instance
	/** The plugin. */
	private static Activator plugin;
	
	/**
	 * The constructor.
	 */
	public Activator() {
		// Bugzilla 324115
		BPELUtil.registerAdapterFactory(ModelPackage.eINSTANCE, ExtensionSampleUIAdapterFactory.getInstance());
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#initializeImageRegistry(org.eclipse.jface.resource.ImageRegistry)
	 */
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		URL baseURL = getBundle().getEntry("/");
		createImageDescriptor(ExtensionSampleUIConstants.DEFAULT_ICON_16, baseURL);
		createImageDescriptor(ExtensionSampleUIConstants.DEFAULT_ICON_20, baseURL);
		
		createImageDescriptor(ExtensionSampleUIConstants.DATA_INPUT_ICON_16, baseURL);
		createImageDescriptor(ExtensionSampleUIConstants.DATA_INPUT_ICON_20, baseURL);
		
		createImageDescriptor(ExtensionSampleUIConstants.DATA_OUTPUT_ICON_16, baseURL);
		createImageDescriptor(ExtensionSampleUIConstants.DATA_OUTPUT_ICON_20, baseURL);
		
		createImageDescriptor(ExtensionSampleUIConstants.DATA_SELECTION_ICON_16, baseURL);
		createImageDescriptor(ExtensionSampleUIConstants.DATA_SELECTION_ICON_20, baseURL);
		
		createImageDescriptor(ExtensionSampleUIConstants.ON_USER_EVENT_ICON_16, baseURL);
		createImageDescriptor(ExtensionSampleUIConstants.ON_USER_EVENT_ICON_20, baseURL);
		
		createImageDescriptor(ExtensionSampleUIConstants.PICK_UI_ICON_16, baseURL);
		createImageDescriptor(ExtensionSampleUIConstants.PICK_UI_ICON_20, baseURL);
		
		createImageDescriptor(ExtensionSampleUIConstants.SCOPE_UI_ICON_16, baseURL);
		createImageDescriptor(ExtensionSampleUIConstants.SCOPE_UI_ICON_20, baseURL);
	}

	/**
	 * Creates the image descriptor.
	 *
	 * @param id the id
	 * @param baseURL the base url
	 */
	private void createImageDescriptor(String id, URL baseURL) {
		URL url = null;
		try {
			url = new URL(baseURL, "icons/" + id);
		} catch (MalformedURLException e) {
			getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, e.getLocalizedMessage()));
		}
		ImageDescriptor descriptor = ImageDescriptor.createFromURL(url);
		getImageRegistry().put(id, descriptor);
	}

	/**
	 * Gets the image descriptor.
	 *
	 * @param key the key
	 * @return the image descriptor
	 */
	public ImageDescriptor getImageDescriptor(String key) {
		return getImageRegistry().getDescriptor(key);
	}

}
