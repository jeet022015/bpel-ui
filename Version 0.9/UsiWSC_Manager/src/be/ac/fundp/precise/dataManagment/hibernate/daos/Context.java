package be.ac.fundp.precise.dataManagment.hibernate.daos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Class Context represents a context in a hibernate DB.
 */
@Entity(name="CONTEXT")
public class Context {

	/** The context id. */
	@Id @GeneratedValue
	private int contextId;

	/** The host address. */
	private String hostAddress;

	/** The protocol type. */
	@Enumerated(EnumType.STRING)
	private ProtocolType protocolType;

	/**
	 * Gets the context id.
	 *
	 * @return the context id
	 */
	public int getContextId() {
		return contextId;
	}

	/**
	 * Sets the context id.
	 *
	 * @param contextId the new context id
	 */
	public void setContextId(int contextId) {
		this.contextId = contextId;
	}

	/**
	 * Gets the host address.
	 *
	 * @return the host address
	 */
	public String getHostAddress() {
		return hostAddress;
	}

	/**
	 * Sets the host address.
	 *
	 * @param hostAddress the new host address
	 */
	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}

	/**
	 * Gets the protocol type.
	 *
	 * @return the protocol type
	 */
	public ProtocolType getProtocolType() {
		return protocolType;
	}

	/**
	 * Sets the protocol type.
	 *
	 * @param protocolType the new protocol type
	 */
	public void setProtocolType(ProtocolType protocolType) {
		this.protocolType = protocolType;
	}

}
