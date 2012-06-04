package be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator;

import java.io.IOException;
import java.util.Map;

import be.ac.fundp.precise.processDeployment.auiDeployment.AuiRoleMapper;

// TODO: Auto-generated Javadoc
/**
 * The Interface CodeGenerator.
 */
public interface CodeGenerator {

	/**
	 * Adapt.
	 *
	 * @param roleMapper the role mapper
	 * @param contextId the context id
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	String adapt(AuiRoleMapper roleMapper, String contextId)  throws IOException;

	/**
	 * Code adaptation.
	 *
	 * @param roleMapper the role mapper
	 * @param contextId the context id
	 * @return the map
	 */
	Map<String, String> codeAdaptation(AuiRoleMapper roleMapper,
			String contextId);

}
