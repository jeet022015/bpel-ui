package be.ac.fundp.precise.processDeployment.auiDeployment;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class AuiRoleMapper.
 */
public class AuiRoleMapper {

	/** The role. */
	private String role;
	
	/** The role aui file. */
	private String roleAuiFile;
	
	/** The ui mapping. */
	private Map<String, String> uiMapping;

	/**
	 * Instantiates a new aui role mapper.
	 *
	 * @param role the role
	 * @param roleAuiFile the role aui file
	 * @param uiMapping the ui mapping
	 */
	public AuiRoleMapper(String role, String roleAuiFile,
			Map<String, String> uiMapping) {
		this.role = role;
		this.roleAuiFile = roleAuiFile;
		this.uiMapping = uiMapping;
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public String getRoleId() {
		return role;
	}

	/**
	 * Gets the aui file.
	 *
	 * @return the aui file
	 */
	public String getAuiFile() {
		return roleAuiFile;
	}

	/**
	 * Gets the ui mapper.
	 *
	 * @return the ui mapper
	 */
	public Map<String, String> getUiMapper() {
		return uiMapping;
	}

}
