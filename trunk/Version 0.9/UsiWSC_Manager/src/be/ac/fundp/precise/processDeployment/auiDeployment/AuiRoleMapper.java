package be.ac.fundp.precise.processDeployment.auiDeployment;

import java.util.Map;

/**
 * The Class AuiRoleMapper is responsible to keep the information about
 * one specific role in the UI-BPEL process.
 */
public class AuiRoleMapper {

	/** The role id in the UI-BPEL process. */
	private String role;
	
	/** The file name to the corresponding AUI description. */
	private String roleAuiFile;
	
	/** The dictionary that maps a user interaction to an entry in the AUI description. */
	private Map<String, String> uiMapping;

	/**
	 * Instantiates a new AuiRoleMapper.
	 *
	 * @param role the role id
	 * @param roleAuiFile the AUI file name
	 * @param uiMapping the dictionary that maps a user interaction to an entry in the AUI description
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