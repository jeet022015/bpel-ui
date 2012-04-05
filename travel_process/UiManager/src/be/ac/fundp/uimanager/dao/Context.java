package be.ac.fundp.uimanager.dao;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * The Class Context represents the user context
 * in the data base.
 */
@Entity(name="CONTEXTS")
public class Context {
	
	/** The context id. */
	@Id @GeneratedValue
	private int contextId;
	
	/** The ip address. */
	private String ipAddress;
	
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
	 * Gets the ip address.
	 *
	 * @return the ip address
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	
	/**
	 * Sets the ip address.
	 *
	 * @param ipAddress the new ip address
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
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
