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

import be.ac.fundp.precise.ui_bpel.ui.factories.BpelUiAdapterFactory;
import be.ac.fundp.precise.ui_bpel.ui.util.BpelUiConstants;
import be.edu.fundp.precise.uibpel.model.ModelPackage;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "be.ac.fundp.precise.UI_BPEL.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
		// Bugzilla 324115
		BPELUtil.registerAdapterFactory(ModelPackage.eINSTANCE, BpelUiAdapterFactory.getInstance());
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
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		URL baseURL = getBundle().getEntry("/");
		createImageDescriptor(BpelUiConstants.DEFAULT_ICON_16, baseURL);
		createImageDescriptor(BpelUiConstants.DEFAULT_ICON_20, baseURL);
	}
	
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

	public ImageDescriptor getImageDescriptor(String key) {
		return getImageRegistry().getDescriptor(key);
	}

}
