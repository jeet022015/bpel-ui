package be.ac.fundp.precise.processDeployment.auiDeployment;

import java.io.File;

public class AuiRole {
	
	protected String roleName;
	protected File fileName;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public File getFileName() {
		return fileName;
	}
	public void setFileName(File fileName) {
		this.fileName = fileName;
	}

}
