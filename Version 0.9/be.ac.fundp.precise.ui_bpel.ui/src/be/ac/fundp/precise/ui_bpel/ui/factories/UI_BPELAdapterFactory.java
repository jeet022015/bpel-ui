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

/**
 * The class <b>UI_BPELAdapterFactory</b> creates a <b>Adapter Factory</b> for the model.
 * It provides an adapter method for each class of the UI-BPEL model.
 */
public class UI_BPELAdapterFactory extends ModelAdapterFactory {

	/** The single instance of this class. */
	private static UI_BPELAdapterFactory instance;
	
	/** The adapter to DataInputUI class. */
	private DataInputUIAdapter dataInputUIAdapter;
	
	/** The adapter to DataOutputUI class. */
	private DataOutputUIAdapter dataOutputUIAdapter;
	
	/** The adapter to SelectionUI class. */
	private SelectionUIAdapter dataSelectionUIAdapter;
	
	/** The adapter to DataItem class. */
	private DataItemAdapter dataItemAdapter;
	
	/** The adapter to OnUserEvent class. */
	private OnUserEventAdapter onUserEventAdapter;
	
	/** The adapter to ScopeUI class. */
	private ScopeUIAdapter scopeUIAdapter;
	
	/** The adapter to EventHandlerUI class. */
	private EventHandlerUIAdapter eventHandlerUIAdapter;
	
	/** The adapter to PickUI class. */
	private PickUIAdapter pickUIAdapter;
	
	/** The adapter to UserRole class. */
	private UserRoleAdapter userRoleAdapter;
	
	/**
	 * Instantiates UI_BPEL Adapter factory. Following the 
	 * Singleton design pattern, this method must be private.
	 */
	private UI_BPELAdapterFactory() {
		super();
	}
	
	/**
	 * Gets the single instance of UI_BPELAdapterFactory.
	 *
	 * @return the single instance of UI_BPELAdapterFactory
	 */
	public static UI_BPELAdapterFactory getInstance() {
		if (instance == null) {
			instance = new UI_BPELAdapterFactory();
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
