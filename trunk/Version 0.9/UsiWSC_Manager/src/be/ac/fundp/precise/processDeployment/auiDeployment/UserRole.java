package be.ac.fundp.precise.processDeployment.auiDeployment;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRole.
 */
public class UserRole {

	/** The role id. */
	private String roleId;
	
	/** The aui entry. */
	private String auiEntry;

	/** The aui2cui. */
	private Map<String, String> aui2cui;

	/**
	 * Instantiates a new user role.
	 *
	 * @param role the role
	 * @param auiEntry the aui entry
	 * @param aui2cui the aui2cui
	 */
	public UserRole(String role, String auiEntry, Map<String, String> aui2cui) {
		this.roleId = role;
		this.auiEntry = auiEntry;
		this.aui2cui = aui2cui;
	}
	
	/**
	 * Gets the aui entry.
	 *
	 * @return the aui entry
	 */
	public String getAuiEntry(){
		return auiEntry;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole(){
		return roleId;
	}

	/**
	 * Gets the ui mapping.
	 *
	 * @return the ui mapping
	 */
	public Map<String, String> getUiMapping(){
		return aui2cui;
	}
}
