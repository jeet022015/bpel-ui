package be.ac.fundp.precise.processDeployment.auiDeployment;

import java.util.Map;

public interface CodeGenerator {

	Map<String, String> genCode(AuiRole auiRole, UserContext context);

}
