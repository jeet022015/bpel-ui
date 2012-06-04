package be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.context;

import java.util.Map;


// TODO: Auto-generated Javadoc
/**
 * The Interface UserContext.
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
	 * Gets the aux entries.
	 *
	 * @return the aux entries
	 */
	Map<String, String> getAuxEntries();

	/**
	 * Gets the termination.
	 *
	 * @return the termination
	 */
	String getTermination();

}
