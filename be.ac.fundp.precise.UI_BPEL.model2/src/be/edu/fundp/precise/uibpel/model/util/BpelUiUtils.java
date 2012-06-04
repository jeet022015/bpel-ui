package be.edu.fundp.precise.uibpel.model.util;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.adapters.INamespaceMap;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.w3c.dom.Node;

import be.edu.fundp.precise.uibpel.model.ModelPackage;

/**
 * The Class BpelUiUtils.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class BpelUiUtils {
	
	/** The id. */
	private static int id = 0;

	/**
	 * Adds the extensionsample namespace to the given process.
	 *
	 * @param process the process
	 * @return the preferred namespace prefix
	 */
	public static String addNamespace(Process process) {
		String nsPrefix = ModelPackage.eINSTANCE.getNsPrefix();
		String nsURI = ModelPackage.eINSTANCE.getNsURI();
		INamespaceMap<String, String> nsMap = BPELUtils.getNamespaceMap(process);
		nsMap.put(nsPrefix, nsURI);
		return nsPrefix;
	}
	
	/**
	 * Gets the new id.
	 *
	 * @return the new id
	 */
	public static int getNewId(){
		return id++;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param newStrId the new id
	 */
	public static void setId(String newStrId){
		try {
			int newId = Integer.parseInt(newStrId);
			if (newId > id)
				id = ++newId;
		} catch (NumberFormatException e) {
			
		}
	}

	/**
	 * Checks if is bpel ui element.
	 *
	 * @param node the node
	 * @return true, if is bpel ui element
	 */
	public static boolean isBpelUiElement(Node node) {
		return node != null && node.getNodeType() == Node.ELEMENT_NODE
				&& (BPELConstants.isBPELNamespace(node.getNamespaceURI()) || BpelUiConstants.isBPELNamespace(node.getNamespaceURI()));
	}

	/**
	 * Checks if is higher id.
	 *
	 * @param newStrId the new str id
	 * @return true, if is higher id
	 */
	public static boolean isHigherId(String newStrId) {
		try {
			int newId = Integer.parseInt(newStrId);
			if (newId > id){
				id = ++newId;
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}

}
