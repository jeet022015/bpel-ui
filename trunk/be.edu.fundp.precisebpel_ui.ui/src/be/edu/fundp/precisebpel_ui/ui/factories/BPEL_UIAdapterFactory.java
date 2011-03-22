package be.edu.fundp.precisebpel_ui.ui.factories;

import org.eclipse.emf.common.notify.Adapter;

import be.edu.fundp.precise.bpel_ui.model.util.ModelAdapterFactory;
import be.edu.fundp.precisebpel_ui.ui.adapters.DataInputUIAdapter;

public class BPEL_UIAdapterFactory extends ModelAdapterFactory {

	// Bugzilla 324115
	private static BPEL_UIAdapterFactory instance;
	private DataInputUIAdapter dataInputUIAdapter;
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
	public Adapter createDataInputUIAdapter() {
		if (this.dataInputUIAdapter == null) {
			this.dataInputUIAdapter = new DataInputUIAdapter();
		}
		return this.dataInputUIAdapter;
	}
	
}
