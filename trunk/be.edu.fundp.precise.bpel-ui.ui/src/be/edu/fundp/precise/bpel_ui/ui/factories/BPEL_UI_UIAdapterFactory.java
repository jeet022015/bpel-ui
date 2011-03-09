package be.edu.fundp.precise.bpel_ui.ui.factories;

import org.eclipse.emf.common.notify.Adapter;

import be.edu.fundp.precise.bpel_ui.ui.adapters.DataInputUIAdapter;
import be.edu.fundp.precise.bpel_ui.ui.adapters.DataOutputUIAdapter;
import be.edu.fundp.precise.bpel_ui.ui.adapters.DataSelectionUIAdapter;

import model.util.ModelAdapterFactory;


public class BPEL_UI_UIAdapterFactory  extends ModelAdapterFactory{
	// Bugzilla 324115
	private static BPEL_UI_UIAdapterFactory instance;
	private DataInputUIAdapter dataInputUIAdapter;
	private DataOutputUIAdapter dataOutputUIAdapter;
	private DataSelectionUIAdapter dataSelectionUIAdapter;
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


}
