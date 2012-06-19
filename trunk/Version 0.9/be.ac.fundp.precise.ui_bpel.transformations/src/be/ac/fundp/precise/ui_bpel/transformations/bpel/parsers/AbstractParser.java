package be.ac.fundp.precise.ui_bpel.transformations.bpel.parsers;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;

import be.edu.fundp.precise.uibpel.model.DataInteraction;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.UserRole;

abstract class AbstractParser {
	abstract Variable getInputVar();

	abstract Variable getOutputVar();

	abstract Variable getOutputGenVar();

	abstract Part getOperationInputPart();

	abstract Part getOperationOutputPart();

	abstract Operation getOperationGenId();

	abstract CorrelationSet getProcessIdCorrelationSet();

	protected Variable createVariable(String variableName, Message message) {
		Variable newVariable = BPELFactory.eINSTANCE.createVariable();
		newVariable.setName(variableName);
		newVariable.setMessageType(message);
		return newVariable;
	}

	protected Copy createInitCopy(DataItem[] dataItems) {
		String[] dataItemTypes = parseDataItems(dataItems);

		Copy initCopy = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		To t = BPELFactory.eINSTANCE.createTo();
		t.setVariable(getInputVar());
		t.setPart(getOperationInputPart());
		f.setLiteral(ExecutableTransUtil.createDefaultInitializer(
				t.getVariable(), t.getPart(), dataItemTypes));
		initCopy.setFrom(f);
		initCopy.setTo(t);
		return initCopy;
	}

	protected Copy createCopyRole(DataInteraction dataInteraction) {
		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		UserRole role = dataInteraction.getUserRoles().get(0);
		e.setBody("'" + role.getRoleId() + "'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("role");
		t.setQuery(toQuery);
		t.setVariable(getInputVar());
		t.setPart(getOperationInputPart());

		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	protected Copy createCopyId(DataInteraction dataInteraction) {
		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		Expression e = BPELFactory.eINSTANCE.createExpression();
		e.setBody("'" + dataInteraction.getId() + "'");
		f.setExpression(e);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("userInteracId");
		t.setQuery(toQuery);
		t.setVariable(getInputVar());
		// FIXME Get the name from some other way or create a constant
		t.setPart(getOperationInputPart());
		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	protected Copy createCopyProcessID(DataInteraction dataInteraction,
			Part genPart) {
		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("processId");
		f.setQuery(toQuery);
		f.setVariable(getOutputGenVar());
		f.setPart(genPart);

		To t = BPELFactory.eINSTANCE.createTo();
		toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue("processId");
		t.setQuery(toQuery);
		t.setVariable(getInputVar());
		t.setPart(getOperationInputPart());
		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	protected Copy createCopyDataItemContentBefore(DataItem dataItem,
			int index, String primaryNode, String secondaryNode) {
		String dataItemName = dataItem.getVariable().getName();

		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		String expression = "$" + dataItemName;
		Expression fromExpr = BPELFactory.eINSTANCE.createExpression();
		f.setExpression(fromExpr);
		fromExpr.setBody(expression);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(primaryNode + "[" + index + "]/" + secondaryNode);
		t.setQuery(toQuery);
		t.setVariable(getInputVar());
		t.setPart(getOperationInputPart());

		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	protected Copy createCopyDataItemIdBefore(DataItem dataItem, int index,
			String primaryNode, String secondaryNode) {
		String dataItemName = dataItem.getVariable().getName();

		Copy c = BPELFactory.eINSTANCE.createCopy();
		From f = BPELFactory.eINSTANCE.createFrom();
		String expression = "'" + dataItemName + "'";
		Expression fromExpr = BPELFactory.eINSTANCE.createExpression();
		f.setExpression(fromExpr);
		fromExpr.setBody(expression);

		To t = BPELFactory.eINSTANCE.createTo();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(primaryNode + "[" + index + "]/" + secondaryNode);
		t.setQuery(toQuery);
		t.setVariable(getInputVar());
		t.setPart(getOperationInputPart());

		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	protected Copy createDataItemContentAfterCopy(DataItem di,
			String primaryNode, String secondaryNode) {
		String dataItemName = di.getVariable().getName();

		Copy c = BPELFactory.eINSTANCE.createCopy();

		From f = BPELFactory.eINSTANCE.createFrom();
		Query toQuery = BPELFactory.eINSTANCE.createQuery();
		toQuery.setQueryLanguage(BPELConstants.XMLNS_XPATH_QUERY_LANGUAGE);
		toQuery.setValue(primaryNode + "[id='" + dataItemName + "']/"
				+ secondaryNode);
		f.setQuery(toQuery);
		f.setVariable(getOutputVar());
		f.setPart(getOperationOutputPart());

		To t = BPELFactory.eINSTANCE.createTo();
		t.setVariable(di.getVariable());

		c.setFrom(f);
		c.setTo(t);
		return c;
	}

	private String[] parseDataItems(final DataItem[] dataItems) {
		String[] types;
		if (dataItems == null)
			types = new String[0];
		else {
			types = new String[dataItems.length];
			for (int i = 0; i < dataItems.length; i++) {
				types[i] = dataItems[i].getType().getName();
			}
		}
		return types;
	}
}
