package be.edu.fundp.precise.uibpel.model.util;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.adapters.INamespaceMap;
import org.eclipse.bpel.model.util.BPELUtils;
import org.w3c.dom.Node;

import be.edu.fundp.precise.uibpel.model.ModelPackage;

public class BpelUiUtils {
	
	private static int id = 0;

	/**
	 * Adds the extensionsample namespace to the given process
	 * @param process
	 * @return the preferred namespace prefix
	 */
	public static String addNamespace(Process process) {
		String nsPrefix = ModelPackage.eINSTANCE.getNsPrefix();
		String nsURI = ModelPackage.eINSTANCE.getNsURI();
		INamespaceMap<String, String> nsMap = BPELUtils.getNamespaceMap(process);
		nsMap.put(nsPrefix, nsURI);
		return nsPrefix;
	}
	
	public static int getNewId(){
		return id++;
	}
	
	public static void setId(String newStrId){
		try {
			int newId = Integer.parseInt(newStrId);
			if (newId > id)
				id = ++newId;
			//TODO maybe it dont works
		} catch (NumberFormatException e) {
			
		}
	}

	//TODO
	public static boolean isBpelUiElement(Node node) {
		return true;
	}

}
