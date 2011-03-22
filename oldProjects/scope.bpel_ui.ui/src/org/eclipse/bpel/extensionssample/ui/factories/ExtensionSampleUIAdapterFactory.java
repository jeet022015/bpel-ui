package org.eclipse.bpel.extensionssample.ui.factories;

import org.eclipse.bpel.extensionssample.ui.adapters.NewEventHandlerAdapter;
import org.eclipse.bpel.extensionssample.ui.adapters.NewScopeAdapter;
import org.eclipse.bpel.extensionssample.ui.adapters.OnUserEventAdapter;
import org.eclipse.emf.common.notify.Adapter;

import be.edu.fundp.bpel_ui.model.util.ModelAdapterFactory;

public class ExtensionSampleUIAdapterFactory extends ModelAdapterFactory {

	// Bugzilla 324115
	private static ExtensionSampleUIAdapterFactory instance;
	private OnUserEventAdapter onUserEventAdapter;
	private NewScopeAdapter newScopeAdapter;
	private NewEventHandlerAdapter newEventHandlerAdapter;
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
	public Adapter createOnUserEventAdapter() {
		if (this.onUserEventAdapter == null) {
			this.onUserEventAdapter = new OnUserEventAdapter();
		}
		return this.onUserEventAdapter;
	}
	
	@Override
	public Adapter createNewEventHandlerAdapter() {
		if (this.newEventHandlerAdapter == null) {
			this.newEventHandlerAdapter = new NewEventHandlerAdapter();
		}
		return this.newEventHandlerAdapter;
	}
	
	@Override
	public Adapter createNewScopeAdapter() {
		if (this.newScopeAdapter == null) {
			this.newScopeAdapter = new NewScopeAdapter();
		}
		return this.newScopeAdapter;
	}
	
}
