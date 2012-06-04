package be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.context;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import be.ac.fundp.precise.FileManager;


// TODO: Auto-generated Javadoc
/**
 * The Class HtmlContext.
 */
public class HtmlContext implements UserContext{
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "html";
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.context.UserContext#getPath()
	 */
	@Override
	public String getPath() {
		return "vm-templates-new";
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.context.UserContext#getDataInteractionTemplate()
	 */
	@Override
	public String getDataInteractionTemplate() {
		return "template-abstractData.vm";
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.context.UserContext#getDataSelectionTemplate()
	 */
	@Override
	public String getDataSelectionTemplate() {
		return "template-abstractSelection.vm";
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.context.UserContext#getAuxEntries()
	 */
	@Override
	public Map<String, String> getAuxEntries() {
		Map<String, String> htmlAux = new HashMap<String, String>();
		String [] auxFiles = {"jquery-1.7.2.js", "UsiWSCLogo.png", 
				"logo3.png", "logo.png", "main.css"};
		for (String entry : auxFiles) {
			htmlAux.put(entry, FileManager.getRootPath() + "codeContent"
						+ File.separator + entry);
		}
		return htmlAux;
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.context.UserContext#getTermination()
	 */
	@Override
	public String getTermination() {
		return ".html";
	}

}
