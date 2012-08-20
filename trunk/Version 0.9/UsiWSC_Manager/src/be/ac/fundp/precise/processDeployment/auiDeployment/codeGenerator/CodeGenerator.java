package be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator;

import java.io.IOException;
import java.util.Map;

import be.ac.fundp.precise.processDeployment.auiDeployment.AuiRoleMapper;

/**
 * The Interface CodeGenerator defines all methods necessaries to generate code.
 */
public interface CodeGenerator {

	/**
	 * This method adapt an AUI for a specific role in a specific context.
	 *
	 * @param roleMapper the AUIRoleMapper
	 * @param contextId the context id
	 * @return the path to the folder with all final codes.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	String adapt(AuiRoleMapper roleMapper, String contextId)  throws IOException;

	//TODO Is this method necessary?
	/**
	 * This method adapt an AUI for a specific role in a specific context.
	 *
	 * @param roleMapper the AUIRoleMapper
	 * @param contextId the context id
	 * @return a map identifying the path of each UI generated for an entry in the AUI description.
	 */
	Map<String, String> codeAdaptation(AuiRoleMapper roleMapper,
			String contextId);

}
