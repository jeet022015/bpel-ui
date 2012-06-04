package be.edu.fundp.precise.uibpel.model.util;

import be.edu.fundp.precise.uibpel.model.ModelPackage;

/**
 * The Class BpelUiConstants.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class BpelUiConstants {

	// node names
	/** The Constant ND_DATA_INPUT_UI. */
	public static final String ND_DATA_INPUT_UI = "dataInputUI";
	
	/** The Constant ND_DATA_OUTPUT_UI. */
	public static final String ND_DATA_OUTPUT_UI = "dataOutputUI";
	
	/** The Constant ND_DATA_SELECTION_UI. */
	public static final String ND_DATA_SELECTION_UI = "dataSelectionUI";
	
	/** The Constant ND_USER_INTERACTION. */
	public static final String ND_USER_INTERACTION = "userInteraction";
	
	/** The Constant ND_DATA_ITEM. */
	public static final String ND_DATA_ITEM = "dataItem";
	
	/** The Constant ND_USER_ROLE. */
	public static final String ND_USER_ROLE = "userRole";
	
	/** The Constant ND_DATA. */
	public static final String ND_DATA = "data";
	
	/** The Constant ND_SCOPE_UI. */
	public static final String ND_SCOPE_UI = "scopeUI";
	
	/** The Constant ND_EVENT_UI_HANDLER. */
	public static final String ND_EVENT_UI_HANDLER = "eventUiHandler";
	
	/** The Constant ND_ON_USER_EVENT. */
	public static final String ND_ON_USER_EVENT = "onUserEvent";
	
	/** The Constant ND_PICK_UI. */
	public static final String ND_PICK_UI = "pickUI";
	
	/** The Constant ND_INPUT_ITEM. */
	public static final String ND_INPUT_ITEM = "inputItem";
	
	/** The Constant ND_OUTPUT_ITEM. */
	public static final String ND_OUTPUT_ITEM = "outputItem";

//	public static final String NS_PREFIX = "ex";
	/** The Constant NS_PREFIX. */
public static final String NS_PREFIX = ModelPackage.eINSTANCE.getNsPrefix();
	
	/** The Constant FUNDP_PRECISE_2011. */
	private static final String FUNDP_PRECISE_2011 = "http://fundp.ac.be/precise/";

	/**
	 * Checks if is bPEL namespace.
	 *
	 * @param namespace the namespace
	 * @return true, if is bPEL namespace
	 */
	public static boolean isBPELNamespace(String namespace) {
		return namespace != null
				&& ( (namespace.equals(FUNDP_PRECISE_2011)));
	}

}
