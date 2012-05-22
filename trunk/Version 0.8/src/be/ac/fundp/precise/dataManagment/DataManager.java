package be.ac.fundp.precise.dataManagment;

import java.util.List;

import be.ac.fundp.precise.dataManagment.hibernate.dao.InteractionType;
import be.ac.fundp.precise.dataManagment.hibernate.dao.ProtocolType;

public interface DataManager {

	static IdGenerator idGen = new  IdGenerator();
	
	void createRoleIfNecessary(String role);
	
	void createProcessIfNecessary(String processId);

	String getUser(String role, String processId);

	int createInteraction(String processId, String userId, String userInteracId);

	void providedInteractionData(int interactionRealId,
			List<CoordinatedData> response, InteractionType type);

	void releaseRole(String role, String processId);

	ProtocolType getUserProtocolType(String userId);

	String getIpAddress(String userId);

	void finishProcess(String processId);

	String verifyUser(String login, String password);

	void subscribe(String login, String password, String role,
			String newIpAddress);

}
