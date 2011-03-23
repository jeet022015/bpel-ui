package be.edu.fundp.precisebpel_ui.ui.factories;

import org.eclipse.emf.common.notify.Adapter;

import be.edu.fundp.precise.bpel_ui.model.util.ModelAdapterFactory;
import be.edu.fundp.precisebpel_ui.ui.adapters.OnUserEventAdapter;
import be.edu.fundp.precisebpel_ui.ui.adapters.PickUIAdapter;

public class BPEL_UIAdapterFactory extends ModelAdapterFactory {

	// Bugzilla 324115
	private static BPEL_UIAdapterFactory instance;
	private PickUIAdapter pickUIAdapter;
	private OnUserEventAdapter onUserEventAdapter;
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
	
}
