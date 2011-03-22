package be.edu.fundp.precisebpel_ui.ui.factories;

import org.eclipse.emf.common.notify.Adapter;

import be.edu.fundp.precise.bpel_ui.model.util.ModelAdapterFactory;
import be.edu.fundp.precisebpel_ui.ui.adapters.DataInputUIAdapter;
import be.edu.fundp.precisebpel_ui.ui.adapters.DataOutputUIAdapter;

public class BPEL_UIAdapterFactory extends ModelAdapterFactory {

	// Bugzilla 324115
	private static BPEL_UIAdapterFactory instance;
	private DataInputUIAdapter dataInputUIAdapter;
	private DataOutputUIAdapter dataOutputUIAdapter;
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
	
	@Override
	public Adapter createDataOutputUIAdapter() {
		if (this.dataOutputUIAdapter == null) {
			this.dataOutputUIAdapter = new DataOutputUIAdapter();
		}
		return this.dataOutputUIAdapter;
	}
	
}
