package be.ac.fundp.precise.uiwsc.webClient.model.codeManagment;

import java.nio.ByteBuffer;

/**
 * The Class CodeIndex represents a index that maps a process, a role, and a context
 * to the corresponding ui code.
 */
public class CodeIndex {

	/** The process id. */
	private String processId;
	
	/** The role id. */
	private String roleId;
	
	/** The context id. */
	private String contextId;

	/**
	 * Instantiates a new code index.
	 *
	 * @param processId the process id
	 * @param roleId the role id
	 * @param contextId the context id
	 */
	public CodeIndex(String processId, String roleId, String contextId) {
		this.processId = processId;
		this.roleId = roleId;
		this.contextId = contextId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		String concat = processId + 
						roleId + 
						contextId;
		ByteBuffer bb = ByteBuffer.wrap(concat.getBytes());
		return bb.getInt();
	}
	

	/**
	 * Gets the process id.
	 *
	 * @return the process id
	 */
	private String getProcess() {
		return processId;
	}
	
	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	private String getRole() {
		return roleId;
	}
	
	/**
	 * Gets the context id.
	 *
	 * @return the context id
	 */
	private String getContext() {
		return contextId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o){
		if (!(o instanceof CodeIndex))
			return false;
		CodeIndex indexComp = (CodeIndex)o;
		return  processId.equals(indexComp.getProcess()) &&
				roleId.equals(indexComp.getRole()) &&
				contextId.equals(indexComp.getContext());
	}
}
