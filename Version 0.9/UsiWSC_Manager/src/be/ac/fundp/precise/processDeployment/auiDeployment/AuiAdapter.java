package be.ac.fundp.precise.processDeployment.auiDeployment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.CodeGenerator;
import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.CodeGeneratorFactory;

/**
 * The Class AuiAdapter it is responsible to adapt a UI for a role and a specific
 * context.
 */
public class AuiAdapter {

	/** The role Id mapping. */
	private Map<String, AuiRoleMapper> roleMapping = new HashMap<String, AuiRoleMapper>();
	
	/** The code generator. */
	private CodeGenerator codeGen = CodeGeneratorFactory.codeGenUsiWSC();
	
	/**
	 * Adds a role.
	 *
	 * @param role a new role
	 */
	public void addRole(AuiRoleMapper role) {
		roleMapping.put(role.getRoleId(), role);
	}

	/**
	 * Adapt.
	 *
	 * @param role the role
	 * @param contextId the context id
	 * @return the path to the final code
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String adapt(String role, String contextId) throws IOException {
		AuiRoleMapper roleMapper = roleMapping.get(role);
		if (roleMapper == null)
			return null;
		String code = codeGen.adapt(roleMapper, contextId);
		System.out.println(code);
		return code;
	}

	/**
	 * Description of the adapted UI.
	 *
	 * @param role the role id
	 * @param contextId the context id
	 * @return a map describing for each activity ui the specific content in the 
	 * final code
	 */
	public Map<String, String> adaptationDesc(String role, String contextId) {
		AuiRoleMapper roleMapper = roleMapping.get(role);
		if (roleMapper == null)
			return null;
		return codeGen.codeAdaptation(roleMapper, contextId);
	}

}
