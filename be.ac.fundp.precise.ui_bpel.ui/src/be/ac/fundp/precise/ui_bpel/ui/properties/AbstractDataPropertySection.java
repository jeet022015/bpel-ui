/*
 * 
 */
package be.ac.fundp.precise.ui_bpel.ui.properties;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.Section;

import be.ac.fundp.precise.ui_bpel.ui.properties.aux.DataItemCategorySection;
import be.ac.fundp.precise.ui_bpel.ui.properties.dialogs.DataItemDialog;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataType;
import be.edu.fundp.precise.uibpel.model.ModelFactory;

/**
 * The Class DataInputUIPropertySection generalize the activities to 
 * present Data Items.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
abstract class AbstractDataPropertySection extends BPELPropertySection {

	/** The current Data Item index. */
	protected static String CURRENT_INDEX_PROPERTY = "currentIndex";

	/** The Data Item section. */
	protected DataItemCategorySection fDataSection = new DataItemCategorySection();
	
	/** The current copy rule being edited. */
	protected DataItem fCurrentDataItem;

	/** The UI Data Item list. */
	protected org.eclipse.swt.widgets.List fDataItemList;

	/** The Data Item select composite. */
	protected Composite dataItemSelectComposite;

	/** The Data Item list viewer. */
	protected ListViewer fDataItemListViewer;

	/** The delete data item. */
	protected Button fDeleteDataItem;
	
	/** The move up. */
	protected Button fMoveUp;
	
	/** The move down. */
	protected Button fMoveDown;

	/** The main label. */
	protected Section mainLabel;

	/**
	 * Instantiates a new data input ui property section.
	 */
	public AbstractDataPropertySection() {
		super();
		
		fDataSection.fAllowedType = DataType.values();

	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#createAdapters()
	 */
	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
		/* model object */
		new MultiObjectAdapter() {

			@Override
			public void notify(Notification n) {

				adjustCopyRulesList();
				int indexDataItem = fixAdapter(n);
				if (indexDataItem != -1)
					selectCopyInList(indexDataItem);

			}
		}, };
	}
	
	/**
	 * Fix adapter to the current Data Item.
	 *
	 * @param n the Notification of the Property adaptation;
	 * @return the index of the Current Data Item
	 */
	abstract int fixAdapter(Notification n);

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#addAllAdapters()
	 */
	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		EList<DataItem> list = getDataItem();
		for (DataItem dataItem : list) {
			fAdapters[0].addToObject(dataItem);
		}
	}

	/**
	 * Gets the data item.
	 *
	 * @return the data item
	 */
	abstract EList<DataItem> getDataItem();

	/**
	 * Creates the copy select widgets.
	 *
	 * @param parent the parent Composite
	 */
	protected void createCopySelectWidgets(Composite parent) {

		FlatFormData data;

		final Composite c = dataItemSelectComposite = createFlatFormComposite(parent);
		
		mainLabel = fWidgetFactory.createSection(c, SWT.NONE); //$NON-NLS-1$

		mainLabel.setText(getLabel());

		Button insertCopy = fWidgetFactory.createButton(c,
				"New", SWT.PUSH);
		fDeleteDataItem = fWidgetFactory.createButton(c,
				Messages.AssignImplDetails_Delete__6, SWT.PUSH);
		fMoveUp = fWidgetFactory.createButton(c, "Move Up", SWT.PUSH);
		fMoveDown = fWidgetFactory.createButton(c, "Move Down", SWT.PUSH);

		fDataItemList = fWidgetFactory.createList(c, SWT.BORDER | SWT.V_SCROLL
				| SWT.SINGLE);

		int preferredWidth = 200;

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(0, preferredWidth);
		data.top = new FlatFormAttachment(0, 0);
		data.bottom = new FlatFormAttachment(100, 0);
		c.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(mainLabel, 0);
		data.bottom = new FlatFormAttachment(insertCopy,
				-IDetailsAreaConstants.VSPACE);
		fDataItemList.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(50, 0);
		data.bottom = new FlatFormAttachment(fMoveUp, 0);
		insertCopy.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(insertCopy, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.bottom = new FlatFormAttachment(fMoveDown, 0);
		fDeleteDataItem.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(50, 0);
		data.bottom = new FlatFormAttachment(100, 0);
		fMoveUp.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(fMoveUp, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.bottom = new FlatFormAttachment(100, 0);
		fMoveDown.setLayoutData(data);

		insertCopy.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {

				Shell shell = c.getShell();
				DataItemDialog dialog = new DataItemDialog(shell);
				DataItem id = dialog.open();
				
				if (id != null){
					Command cmd = getAddDataItemCommand(id);
					getCommandFramework().execute(wrapInShowContextCommand(cmd));
					refreshAdapters();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		fDeleteDataItem.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				Command cmd = getRemoveDataItemCommand();
				getCommandFramework().execute(wrapInShowContextCommand(cmd));
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		fDataItemList.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				int index = fDataItemList.getSelectionIndex();
				selectCopyInList(index);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		fMoveUp.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				//TODO implement it
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		fMoveDown.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				//TODO implement it
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

	}

	/**
	 * This method returns the label of the property.
	 *
	 * @return the label
	 */
	abstract String getLabel();
	
	/**
	 * This method returns the command to add the data items.
	 *
	 * @param id Data Item's id
	 * @return The command to add a data Item
	 */
	abstract Command getAddDataItemCommand(DataItem id);
	
	/**
	 * This method returns the command to remove the data items.
	 *
	 * @return The command to remove a data Item
	 */
	abstract Command getRemoveDataItemCommand();

	/**
	 * Creates the category section widgets.
	 *
	 * @param composite the parent composite
	 * @param section the Data Item section
	 */
	protected void createCategorySectionWidgets(Composite composite,
			final DataItemCategorySection section) {

		FlatFormData data;

		section.fComboLabel = fWidgetFactory.createLabel(composite,"Type:");
		section.fCombo = new Combo(composite, SWT.FLAT | SWT.BORDER
				| SWT.READ_ONLY);
		section.fNameFieldLabel = fWidgetFactory.createLabel(composite,"Name:");
		section.fNameField = fWidgetFactory.createLabel(composite, "");
		
		//createChangeTrackers(section.fNameField);
		
		//Name Field
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(
				section.fNameFieldLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(50,
				-IDetailsAreaConstants.CENTER_SPACE);
		data.top = new FlatFormAttachment(mainLabel, 0);
		section.fNameField.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(section.fNameField,
				-IDetailsAreaConstants.CENTER_SPACE);
		data.top = new FlatFormAttachment(section.fNameField, 0, SWT.CENTER);
		section.fNameFieldLabel.setLayoutData(data);
		
		//Combo Type
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(
				section.fComboLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(50,
				-IDetailsAreaConstants.CENTER_SPACE);
		data.top = new FlatFormAttachment(section.fNameField, 0);
		section.fCombo.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(section.fCombo,
				-IDetailsAreaConstants.CENTER_SPACE);
		data.top = new FlatFormAttachment(section.fCombo, 0, SWT.CENTER);
		section.fComboLabel.setLayoutData(data);
		

		for (DataType category : section.fAllowedType) {
			if (category != null) {
				section.fCombo.add(category.getName());
			}
		}

		section.fCombo.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				int index = section.fCombo.getSelectionIndex();

				updateCategorySelection(section, index, true);

			}

			// TODO: is this correct?
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		section.fOuterComposite = createFlatFormComposite(composite);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(section.fComboLabel, 0, SWT.LEFT);
		data.right = new FlatFormAttachment(section.fCombo, 0, SWT.RIGHT);
		data.top = new FlatFormAttachment(section.fCombo,
				IDetailsAreaConstants.VSPACE);
		data.bottom = new FlatFormAttachment(100, -25);
		section.fOuterComposite.setLayoutData(data);

	}

	/**
	 * This method asserts if extra space can be used.
	 *
	 * @return true, if successful
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
	 */
	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#createClient(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createClient(Composite parent) {

		Composite composite = createFlatFormComposite(parent);
		createCopySelectWidgets(composite);
		Composite mainComposite = createFlatFormComposite(composite);
		FlatFormData data = new FlatFormData();
		data.left = new FlatFormAttachment(dataItemSelectComposite,
				IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.bottom = new FlatFormAttachment(100, 0);
		mainComposite.setLayoutData(data);

		createCategorySectionWidgets(mainComposite, fDataSection);

	}

	// Total Hack until we have Copy objects in graphical editor
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#basicSetInput(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected void basicSetInput(EObject newInput) {

		saveUserContextToInput();

		super.basicSetInput(newInput);
		adjustCopyRulesList();

		restoreUserContextFromInput();
		
//		if (fFromSection.fCurrent != null) {
//			fFromSection.fCurrent.refresh();
//		}

	}

	/**
	 * Called when the copy rule changes or is created.
	 * 
	 */
	@SuppressWarnings("boxing")
	protected void selectCategoriesForInput() {

		if (fCurrentDataItem == null) {
			fDataSection.hideCurrent();
			return;
		}

		updateCategorySelection(fDataSection, fCurrentDataItem, false);

	}

	/**
	 * Refresh the property.
	 *
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
	}

	/**
	 * About to be hidden.
	 *
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#aboutToBeHidden()
	 */
	@Override
	public void aboutToBeHidden() {
		super.aboutToBeHidden();

//		if (fFromSection.fCurrent != null) {
//			fFromSection.fCurrent.aboutToBeHidden();
//		}

	}

	/**
	 * About to be shown.
	 *
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#aboutToBeShown()
	 */
	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
//		if (fFromSection.fCurrent != null) {
//			fFromSection.fCurrent.aboutToBeShown();
//		}
	}

	/**
	 * Adjust copy rules list.
	 */
	protected void adjustCopyRulesList() {
		EList<DataItem> inputItems = getDataItem();
		int sz = inputItems.size();
		int idx = fDataItemList.getSelectionIndex();
		String[] items = new String[sz];
		int i = 0;
		for (DataItem aDataItem : inputItems) {
			if (aDataItem.getVariable() != null){
				items[i] = aDataItem.getVariable().getName();
			} else {
				items[i] = "default name";
			}
			i++;
		}
		fDataItemList.setItems(items);
		if (idx != -1) {
			fDataItemList.setSelection(idx);
		}
		fDeleteDataItem.setEnabled(inputItems.size() > 0);
		fDataSection.fCombo.setEnabled(inputItems.size() > 0);
	}

	/**
	 * Update category selection.
	 *
	 * @param section the section
	 * @param index the index
	 * @param bVisual the b visual
	 */
	void updateCategorySelection(DataItemCategorySection section, int index,
			boolean bVisual) {
		fCurrentDataItem.setType(section.fAllowedType[index]);
		updateCategorySelection(section, fCurrentDataItem, bVisual);
	}

	/**
	 * Update category selection.
	 *
	 * @param section the section
	 * @param newCurrent the new current
	 * @param bVisual the b visual
	 */
	void updateCategorySelection(DataItemCategorySection section,
			DataItem newCurrent, boolean bVisual) {

		/** Hide current */
		section.hideCurrent();

		/** Update current to the one that picked from */
		section.fCurrent = newCurrent;
		section.ensureCategoryCompositeCreated();
		
		if (bVisual || fCurrentDataItem == null) {
			fCurrentDataItem = ModelFactory.eINSTANCE.createDataItem();
		}
		section.updateCombo();
		refreshAdapters();
	}

	/**
	 * Gets the user context.
	 *
	 * @return the user context
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@SuppressWarnings("boxing")
	@Override
	public Object getUserContext() {
		return getCurrentDataItemContext();
	}

	/**
	 * Gets the current data item context.
	 *
	 * @return the current data item context
	 */
	abstract Object getCurrentDataItemContext();

	/**
	 * Restore user context.
	 *
	 * @param userContext the user context
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@SuppressWarnings("boxing")
	@Override
	public void restoreUserContext(Object userContext) {

		int idx = 0;
		if (userContext instanceof Number) {
			Number num = (Number) userContext;
			idx = num.intValue();
		}

		selectCopyInList(idx);
	}

	/**
	 * Goto marker.
	 *
	 * @param marker the marker
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#gotoMarker(org.eclipse.core.resources.IMarker)
	 */
	@Override
	public void gotoMarker(IMarker marker) {
		// TODO: This code do nothing and sometime causes NPE (from==null), so
		// temporary disabled (Oleg)
		// String uriFragment =
		// marker.getAttribute(IBPELUIConstants.MARKER_ATT_FROM, EMPTY_STRING);
		// EObject from = fModelObject.eResource().getEObject(uriFragment);
		// EObject copy = from.eContainer();
		// currentCopyIndex = ((Assign)getModel()).getCopy().indexOf(copy);
		refresh();
	}

	/*
	 * Select copy, refresh buttons & categories
	 */
	/**
	 * Select copy in list.
	 *
	 * @param index the index
	 */
	private void selectCopyInList(int index) {
		EList<DataItem> list = getDataItem();
		if (index < 0 || index >= list.size()) {
			fCurrentDataItem = null;
			fMoveUp.setEnabled(false);
			fMoveDown.setEnabled(false);
		} else {
			fCurrentDataItem = list.get(index);
			fDataItemList.select(index);
			fMoveUp.setEnabled(index > 0);
			fMoveDown.setEnabled(index < fDataItemList.getItemCount() - 1);
		}
		selectCategoriesForInput();
	}
}
