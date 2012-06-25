package be.ac.fundp.precise.ui_bpel.ui.details.provider;

import org.eclipse.bpel.ui.details.tree.ITreeNode;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

/**
 * The Class DataInputFilter.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class DataInputFilter  extends ViewerFilter
implements IFilter
{

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
	 */
	@Override
	public boolean select(Object toTest) {
		return DataInputUI.class.isInstance(toTest) &&
				!DataSelectionUI.class.isInstance(toTest);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof ITreeNode) {
			return select ( ((ITreeNode)element).getModelObject() );			
		}
		return select ( element );
	}

}
