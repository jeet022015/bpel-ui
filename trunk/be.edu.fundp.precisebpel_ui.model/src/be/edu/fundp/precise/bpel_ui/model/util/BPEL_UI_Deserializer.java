package be.edu.fundp.precise.bpel_ui.model.util;

import java.util.Map;

import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.extensions.BPELActivityDeserializer;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.bpel.model.util.ImportResolver;
import org.eclipse.bpel.model.util.ImportResolverRegistry;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import be.edu.fundp.precise.bpel_ui.model.DataInputUI;
import be.edu.fundp.precise.bpel_ui.model.DataOutputUI;
import be.edu.fundp.precise.bpel_ui.model.DataSelectionUI;
import be.edu.fundp.precise.bpel_ui.model.ModelFactory;
import be.edu.fundp.precise.bpel_ui.model.ModelPackage;

/*
 * Bug 120110 - this class has been updated to include a Variable
 * reference for the SampleSimpleActivity and a Variable definition
 * for the SampleStructuredActivity.
 */
public class BPEL_UI_Deserializer implements BPELActivityDeserializer {

	@Override
	public Activity unmarshall(QName elementType, Node node, Activity activity, Process process,
			Map nsMap, ExtensionRegistry extReg, URI uri, BPELReader bpelReader) {

		
		/*
		 * DataInputUI
		 */
		if (BPEL_UI_Constants.ND_DATA_SELECTION_UI.equals(elementType.getLocalPart())) {

			// create a new DataInputUI model object if not already created
			DataSelectionUI sa;
			Element saElement = (Element)node;
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
			if (activity instanceof DataSelectionUI) {
				sa = (DataSelectionUI)activity;
			}
			else {
				sa = ModelFactory.eINSTANCE
					.createDataSelectionUI();

				// attach the DOM node to our new activity
				sa.setElement(saElement);
			}
			
			// handle variable name: find this variable is in a visible scope
			String value = saElement.getAttribute("inputVariable");
			if (value!=null && !"".equals(value.trim())) {
				Variable[] vars = ModelHelper.getVisibleVariables(activity);
				for (int i=vars.length-1; i>=0; --i) {
					if (value.equals(vars[i].getName())) {
						sa.setInputVariable(vars[i]);
						break;
					}
				}
			}
			
			// handle variable name: find this variable is in a visible scope
			value = saElement.getAttribute("outputVariable");
			if (value!=null && !"".equals(value.trim())) {
				Variable[] vars = ModelHelper.getVisibleVariables(activity);
				for (int i=vars.length-1; i>=0; --i) {
					if (value.equals(vars[i].getName())) {
						sa.setOutputVariable(vars[i]);
						break;
					}
				}
			}
			
			//TODO UserRole

			return sa;
		}
		
		/*
		 * DataInputUI
		 */
		if (BPEL_UI_Constants.ND_DATA_INPUT_UI.equals(elementType.getLocalPart())) {

			// create a new DataInputUI model object if not already created
			DataInputUI sa;
			Element saElement = (Element)node;
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
			if (activity instanceof DataInputUI) {
				sa = (DataInputUI)activity;
			}
			else {
				sa = ModelFactory.eINSTANCE
					.createDataInputUI();

				// attach the DOM node to our new activity
				sa.setElement(saElement);
			}
			
			// handle variable name: find this variable is in a visible scope
			String value = saElement.getAttribute("inputVariable");
			if (value!=null && !"".equals(value.trim())) {
				Variable[] vars = ModelHelper.getVisibleVariables(activity);
				for (int i=vars.length-1; i>=0; --i) {
					if (value.equals(vars[i].getName())) {
						sa.setInputVariable(vars[i]);
						break;
					}
				}
			}
			
			//TODO UserRole

			return sa;
		}
		
		/*
		 * DataOutputUI
		 */
		if (BPEL_UI_Constants.ND_DATA_OUTPUT_UI.equals(elementType.getLocalPart())) {

			// create a new DataOutputUI model object if not already created
			DataOutputUI sa;
			Element saElement = (Element)node;
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
			if (activity instanceof DataOutputUI) {
				sa = (DataOutputUI)activity;
			}
			else {
				sa = ModelFactory.eINSTANCE
					.createDataOutputUI();

				// attach the DOM node to our new activity
				sa.setElement(saElement);
			}
			
			// handle variable name: find this variable is in a visible scope
			String value = saElement.getAttribute("outputVariable");
			if (value!=null && !"".equals(value.trim())) {
				Variable[] vars = ModelHelper.getVisibleVariables(activity);
				for (int i=vars.length-1; i>=0; --i) {
					if (value.equals(vars[i].getName())) {
						sa.setOutputVariable(vars[i]);
						break;
					}
				}
			}
			
			//TODO UserRole

			return sa;
		}

		System.err.println("Cannot handle this kind of element");
		return null;
	}

	static EObject scanImports( Process process, QName qname , String refType ) {
		
		EObject result = null;
		
		for(Object n : process.getImports()) {
            Import imp = (Import) n;                                    
            if (imp.getLocation() == null ) {
            	continue;
            }
            
    	    ImportResolver[] resolvers = ImportResolverRegistry.INSTANCE.getResolvers(imp.getImportType());
    	    for(ImportResolver r : resolvers) {
                result = r.resolve(imp, qname, null, refType);
                if (result != null) {
                	return result;
                }                
            }
    	    
        } 
        
        return null;
	}

}
