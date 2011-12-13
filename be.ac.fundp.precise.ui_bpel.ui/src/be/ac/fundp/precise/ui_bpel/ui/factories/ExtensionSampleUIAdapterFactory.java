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
import be.ac.fundp.precise.ui_bpel.ui.adapters.UserRoleAdapter;
import be.edu.fundp.precise.uibpel.model.util.ModelAdapterFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ExtensionSampleUIAdapter objects.
 */
public class ExtensionSampleUIAdapterFactory extends ModelAdapterFactory {

	// Bugzilla 324115
	/** The instance. */
	private static ExtensionSampleUIAdapterFactory instance;
	
	/** The data input ui adapter. */
	private DataInputUIAdapter dataInputUIAdapter;
	
	/** The data output ui adapter. */
	private DataOutputUIAdapter dataOutputUIAdapter;
	
	/** The data selection ui adapter. */
	private SelectionUIAdapter dataSelectionUIAdapter;
	
	/** The data item adapter. */
	private DataItemAdapter dataItemAdapter;
	
	/** The on user event adapter. */
	private OnUserEventAdapter onUserEventAdapter;
	
	/** The scope ui adapter. */
	private ScopeUIAdapter scopeUIAdapter;
	
	/** The event handler ui adapter. */
	private EventHandlerUIAdapter eventHandlerUIAdapter;
	
	/** The pick ui adapter. */
	private PickUIAdapter pickUIAdapter;
	
	/** The user role adapter. */
	private UserRoleAdapter userRoleAdapter;
	
	/**
	 * Instantiates a new extension sample ui adapter factory.
	 */
	private ExtensionSampleUIAdapterFactory() {
		super();
	}
	
	/**
	 * Gets the single instance of ExtensionSampleUIAdapterFactory.
	 *
	 * @return single instance of ExtensionSampleUIAdapterFactory
	 */
	public static ExtensionSampleUIAdapterFactory getInstance() {
		if (instance == null) {
			instance = new ExtensionSampleUIAdapterFactory();
		}
		return instance;
	}
		
	/* (non-Javadoc)
	 * @see be.edu.fundp.precise.uibpel.model.util.ModelAdapterFactory#createDataInputUIAdapter()
	 */
	@Override
	public Adapter createDataInputUIAdapter() {
		if (this.dataInputUIAdapter == null) {
			this.dataInputUIAdapter = new DataInputUIAdapter();
		}
		return this.dataInputUIAdapter;
	}
	
	/* (non-Javadoc)
	 * @see be.edu.fundp.precise.uibpel.model.util.ModelAdapterFactory#createDataOutputUIAdapter()
	 */
	@Override
	public Adapter createDataOutputUIAdapter() {
		if (this.dataOutputUIAdapter == null) {
			this.dataOutputUIAdapter = new DataOutputUIAdapter();
		}
		return this.dataOutputUIAdapter;
	}
	
	/* (non-Javadoc)
	 * @see be.edu.fundp.precise.uibpel.model.util.ModelAdapterFactory#createDataSelectionUIAdapter()
	 */
	@Override
	public Adapter createDataSelectionUIAdapter() {
		if (this.dataSelectionUIAdapter == null) {
			this.dataSelectionUIAdapter = new SelectionUIAdapter();
		}
		return this.dataSelectionUIAdapter;
	}
	
	/* (non-Javadoc)
	 * @see be.edu.fundp.precise.uibpel.model.util.ModelAdapterFactory#createDataItemAdapter()
	 */
	@Override
	public Adapter createDataItemAdapter () {
		if (this.dataItemAdapter == null) {
			this.dataItemAdapter = new DataItemAdapter();
		}
		return this.dataItemAdapter;
	}
	
	/* (non-Javadoc)
	 * @see be.edu.fundp.precise.uibpel.model.util.ModelAdapterFactory#createScopeUIAdapter()
	 */
	@Override
	public Adapter createScopeUIAdapter() {
		if (this.scopeUIAdapter == null) {
			this.scopeUIAdapter = new ScopeUIAdapter();
		}
		return this.scopeUIAdapter;
	}
	
	/* (non-Javadoc)
	 * @see be.edu.fundp.precise.uibpel.model.util.ModelAdapterFactory#createEventHandlerUIAdapter()
	 */
	@Override
	public Adapter createEventHandlerUIAdapter() {
		if (this.eventHandlerUIAdapter == null) {
			this.eventHandlerUIAdapter = new EventHandlerUIAdapter();
		}
		return this.eventHandlerUIAdapter;
	}
	
	/* (non-Javadoc)
	 * @see be.edu.fundp.precise.uibpel.model.util.ModelAdapterFactory#createPickUIAdapter()
	 */
	@Override
	public Adapter createPickUIAdapter() {
		if (this.pickUIAdapter == null) {
			this.pickUIAdapter = new PickUIAdapter();
		}
		return this.pickUIAdapter;
	}
	
	/* (non-Javadoc)
	 * @see be.edu.fundp.precise.uibpel.model.util.ModelAdapterFactory#createOnUserEventAdapter()
	 */
	@Override
	public Adapter createOnUserEventAdapter() {
		if (this.onUserEventAdapter == null) {
			this.onUserEventAdapter = new OnUserEventAdapter();
		}
		return this.onUserEventAdapter;
	}
	
	/* (non-Javadoc)
	 * @see be.edu.fundp.precise.uibpel.model.util.ModelAdapterFactory#createUserRoleAdapter()
	 */
	@Override
	public Adapter createUserRoleAdapter() {
		if (this.userRoleAdapter == null) {
			this.userRoleAdapter = new UserRoleAdapter();
		}
		return this.userRoleAdapter;
	}
}
