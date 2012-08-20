package be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.context;

import java.util.Map;


/**
 * The Interface UserContext defines the methods necessaries to provide the information to 
 * generate the code for the UsiXML pattern.
 */
public interface UserContext {
	
	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	String getPath();
	
	/**
	 * Gets the data interaction template.
	 *
	 * @return the data interaction template
	 */
	String getDataInteractionTemplate();
	
	/**
	 * Gets the data selection template.
	 *
	 * @return the data selection template
	 */
	String getDataSelectionTemplate();

	/**
	 * Gets the aux entries to configure the Velocity framework.
	 *
	 * @return the aux entries
	 */
	Map<String, String> getAuxEntries();

	/**
	 * Gets the file termination.
	 *
	 * @return the termination
	 */
	String getTermination();

}
