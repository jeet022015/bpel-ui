package be.edu.fundp.precisebpel_ui.ui.factories;

import org.eclipse.emf.common.notify.Adapter;

import be.edu.fundp.precise.bpel_ui.model.util.ModelAdapterFactory;
import be.edu.fundp.precisebpel_ui.ui.adapters.DataInputUIAdapter;
import be.edu.fundp.precisebpel_ui.ui.adapters.DataOutputUIAdapter;
import be.edu.fundp.precisebpel_ui.ui.adapters.DataSelectionUIAdapter;
import be.edu.fundp.precisebpel_ui.ui.adapters.EventHandlerUIAdapter;
import be.edu.fundp.precisebpel_ui.ui.adapters.ScopeUIAdapter;
import be.edu.fundp.precisebpel_ui.ui.adapters.OnUserEventAdapter;
import be.edu.fundp.precisebpel_ui.ui.adapters.PickUIAdapter;

public class BPEL_UIAdapterFactory extends ModelAdapterFactory {

	// Bugzilla 324115
	private static BPEL_UIAdapterFactory instance;
	private PickUIAdapter pickUIAdapter;
	private OnUserEventAdapter onUserEventAdapter;
	private DataInputUIAdapter dataInputUIAdapter;
	private DataSelectionUIAdapter dataSelectionUIAdapter;
	private DataOutputUIAdapter dataOutputUIAdapter;
	private ScopeUIAdapter scopeUIAdapter;
	private EventHandlerUIAdapter eventHandlerUIAdapter;
	
	private BPEL_UIAdapterFactory() {
		super();
	}
	
	public static BPEL_UIAdapterFactory getInstance() {
		if (instance == null) {
			instance = new BPEL_UIAdapterFactory();
		}
		return instance;
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
			this.dataSelectionUIAdapter = new DataSelectionUIAdapter();
		}
		return this.dataSelectionUIAdapter;
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
	
}
