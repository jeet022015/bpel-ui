package be.ac.fundp.uimanager.dao;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="CONTEXTS")
public class Context {
	
	@Id @GeneratedValue
	private int contextId;
	private String ipAddress;
	@Enumerated(EnumType.STRING)
	private ProtocolType protocolType;
	
	public int getContextId() {
		return contextId;
	}
	public void setContextId(int contextId) {
		this.contextId = contextId;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public ProtocolType getProtocolType() {
		return protocolType;
	}
	public void setProtocolType(ProtocolType protocolType) {
		this.protocolType = protocolType;
	}

}
