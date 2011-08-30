package be.ac.fundp.precise.ui_bpel.ui.factories;


import org.eclipse.emf.common.notify.Adapter;

import be.ac.fundp.precise.ui_bpel.ui.adapters.DataInputUIAdapter;
import be.ac.fundp.precise.ui_bpel.ui.adapters.DataItemAdapter;
import be.ac.fundp.precise.ui_bpel.ui.adapters.DataOutputUIAdapter;
import be.ac.fundp.precise.ui_bpel.ui.adapters.EventHandlerUIAdapter;
import be.ac.fundp.precise.ui_bpel.ui.adapters.OnUserEventAdapter;
import be.ac.fundp.precise.ui_bpel.ui.adapters.PickUIAdapter;
import be.ac.fundp.precise.ui_bpel.ui.adapters.ScopeUIAdapter;
import be.ac.fundp.precise.ui_bpel.ui.adapters.SelectionUIAdapter;
import be.edu.fundp.precise.uibpel.model.util.ModelAdapterFactory;

public class BpelUiAdapterFactory extends ModelAdapterFactory {

	// Bugzilla 324115
	private static BpelUiAdapterFactory instance;
	private DataInputUIAdapter dataInputUIAdapter;
	private DataOutputUIAdapter dataOutputUIAdapter;
	private SelectionUIAdapter dataSelectionUIAdapter;
	private DataItemAdapter dataItemAdapter;
	private OnUserEventAdapter onUserEventAdapter;
	private ScopeUIAdapter scopeUIAdapter;
	private EventHandlerUIAdapter eventHandlerUIAdapter;
	private PickUIAdapter pickUIAdapter;
	
	private BpelUiAdapterFactory() {
		super();
	}
	
	public static BpelUiAdapterFactory getInstance() {
		if (instance == null) {
			instance = new BpelUiAdapterFactory();
		}
		return instance;
	}
		
	@Override
	public Adapter createDataInputUIAdapter() {
		if (this.dataInputUIAdapter == null) {
			this.dataInputUIAdapter = new DataInputUIAdapter();
		}
		return this.dataInputUIAdapter;
	}
	
	@Override
	public Adapter createDataOutputUIAdapter() {
		if (this.dataOutputUIAdapter == null) {
			this.dataOutputUIAdapter = new DataOutputUIAdapter();
		}
		return this.dataOutputUIAdapter;
	}
	
	@Override
	public Adapter createDataSelectionUIAdapter() {
		if (this.dataSelectionUIAdapter == null) {
			this.dataSelectionUIAdapter = new SelectionUIAdapter();
		}
		return this.dataSelectionUIAdapter;
	}
	
	@Override
	public Adapter createDataItemAdapter () {
		if (this.dataItemAdapter == null) {
			this.dataItemAdapter = new DataItemAdapter();
		}
		return this.dataItemAdapter;
	}
	
	@Override
	public Adapter createScopeUIAdapter() {
		if (this.scopeUIAdapter == null) {
			this.scopeUIAdapter = new ScopeUIAdapter();
		}
		return this.scopeUIAdapter;
	}
	
	@Override
	public Adapter createEventHandlerUIAdapter() {
		if (this.eventHandlerUIAdapter == null) {
			this.eventHandlerUIAdapter = new EventHandlerUIAdapter();
		}
		return this.eventHandlerUIAdapter;
	}
	
	@Override
	public Adapter createPickUIAdapter() {
		if (this.pickUIAdapter == null) {
			this.pickUIAdapter = new PickUIAdapter();
		}
		return this.pickUIAdapter;
	}
	
	@Override
	public Adapter createOnUserEventAdapter() {
		if (this.onUserEventAdapter == null) {
			this.onUserEventAdapter = new OnUserEventAdapter();
		}
		return this.onUserEventAdapter;
	}
	
}
