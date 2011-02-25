package be.edu.fundp.precise.bpel_ui.ui.factories;

import org.eclipse.emf.common.notify.Adapter;

import be.edu.fundp.precise.bpel_ui.ui.adapters.DataInputUIAdapter;

import model.util.ModelAdapterFactory;


public class BPEL_UI_UIAdapterFactory  extends ModelAdapterFactory{
	// Bugzilla 324115
	private static BPEL_UI_UIAdapterFactory instance;
	private DataInputUIAdapter sampleSimpleActivityAdapter;
	private BPEL_UI_UIAdapterFactory() {
		super();
	}
	
	public static BPEL_UI_UIAdapterFactory getInstance() {
		if (instance == null) {
			instance = new BPEL_UI_UIAdapterFactory();
		}
		return instance;
	}
		
	@Override
	public Adapter createDataInputUIAdapter() {
		if (this.sampleSimpleActivityAdapter == null) {
			this.sampleSimpleActivityAdapter = new DataInputUIAdapter();
		}
		return this.sampleSimpleActivityAdapter;
	}


}
