package org.eclipse.bpel.extensionssample.ui.factories;

import org.eclipse.bpel.extensionssample.ui.adapters.NewPickAdapter;
import org.eclipse.bpel.extensionssample.ui.adapters.OnUserEventAdapter;
import org.eclipse.emf.common.notify.Adapter;

import be.edu.fundp.bpel_ui.model.util.ModelAdapterFactory;

public class ExtensionSampleUIAdapterFactory extends ModelAdapterFactory {

	// Bugzilla 324115
	private static ExtensionSampleUIAdapterFactory instance;
	private NewPickAdapter newPickAdapter;
	private OnUserEventAdapter onUserEventAdapter;
	private ExtensionSampleUIAdapterFactory() {
		super();
	}
	
	public static ExtensionSampleUIAdapterFactory getInstance() {
		if (instance == null) {
			instance = new ExtensionSampleUIAdapterFactory();
		}
		return instance;
	}
	
	@Override
	public Adapter createNewPickAdapter() {
		if (this.newPickAdapter == null) {
			this.newPickAdapter = new NewPickAdapter();
		}
		return this.newPickAdapter;
	}
	
	@Override
	public Adapter createOnUserEventAdapter() {
		if (this.onUserEventAdapter == null) {
			this.onUserEventAdapter = new OnUserEventAdapter();
		}
		return this.onUserEventAdapter;
	}
	
}
