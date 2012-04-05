package be.ac.fundp.uimanager;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import be.ac.fundp.uimanager.dao.Context;
import be.ac.fundp.uimanager.dao.DataItem;
import be.ac.fundp.uimanager.dao.Interaction;
import be.ac.fundp.uimanager.dao.InteractionType;
import be.ac.fundp.uimanager.dao.ItemType;
import be.ac.fundp.uimanager.dao.Process;
import be.ac.fundp.uimanager.dao.ProcessBind;
import be.ac.fundp.uimanager.dao.ProcessBind.ProcessBindIdClass;
import be.ac.fundp.uimanager.dao.ProtocolType;
import be.ac.fundp.uimanager.dao.Role;
import be.ac.fundp.uimanager.dao.User;
import be.ac.fundp.uimanager.dispatcher.Dispatcher;
import be.ac.fundp.uimanager.dispatcher.restDispatcher.RestDispatcher;
import be.ac.fundp.uimanager.model.CoordinatedData;

/**
 * The Class UiManagerLogic which manager the 
 * user interactions. This class is a singleton in order
 * to avoid the creation of multiples user interactions
 * for the same interactions.
 */
public class UiManagerLogic {

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		configureSessionFactory = configuration
				.buildSessionFactory(serviceRegistry);
	}

	/** The singleton instance. */
	static UiManagerLogic self;

	/** The configure session factory. */
	public static SessionFactory configureSessionFactory;

	/** The process counter. */
	private int counter = 1;

	/** The common head for any process. */
	private String HEAD_PROCESS = "Trip";

	/**
	 * Instantiates a new UiManagerLogic. It initializes the UiManager
	 * with the default users.
	 */
	protected UiManagerLogic() {
		Role role = new Role();
		role.setRoleId("manager");

		User user = new User();
		user.setUserId("philippe");
		user.setPassword("philippe");
		user.setAvailable(true);
		user.getRole().add(role);

		Context context = new Context();
		context.setIpAddress("http://localhost:8070/UsiXML-WebClient/restlet/uibpel/");
		context.setProtocolType(ProtocolType.Rest);
		user.setContext(context);

		Role role2 = new Role();
		role2.setRoleId("administrator");

		User user2 = new User();
		user2.setUserId("mohamed");
		user2.setPassword("mohamed");
		user2.setAvailable(true);
		user2.getRole().add(role2);

		Context context2 = new Context();
		context2.setIpAddress("http://localhost:8070/UsiXML-WebClient/restlet/uibpel/");
		context2.setProtocolType(ProtocolType.Rest);
		user2.setContext(context2);

		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(role);
		session.saveOrUpdate(context);
		session.saveOrUpdate(user);
		session.saveOrUpdate(role2);
		session.saveOrUpdate(context2);
		session.saveOrUpdate(user2);
		session.getTransaction().commit();
		session.close();

	}

	/**
	 * Gets the single instance of UiManagerLogic.
	 *
	 * @return single instance of UiManagerLogic
	 */
	public static UiManagerLogic getInstance() {
		if (self == null)
			self = new UiManagerLogic();
		return self;
	}

	/**
	 * This method gets the user's id with a specific
	 * role. If there is no user related to a process, this method
	 * binds a user to the process.
	 *
	 * @param role the role's id.
	 * @param processId the process's id.
	 * @return the user's id.
	 */
	private String getUser(String role, String processId) {
		Session session = configureSessionFactory.openSession();
		try {
			ProcessBindIdClass idClass = new ProcessBindIdClass();
			Process process = (Process) session.get(Process.class, processId);
			Role roleObj = (Role) session.get(Role.class, role);
			idClass.setRole(roleObj);
			idClass.setProcess(process);
			ProcessBind processBind = (ProcessBind) session
					.createCriteria(ProcessBind.class)
					.add(Restrictions.eq("id", idClass)).uniqueResult();
			if (processBind != null)
				return processBind.getUser().getUserId();
			else 
				return createProcessBind(role, idClass, processId);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	/**
	 * This method binds a user to the process.
	 * @param role the role's id.
	 * @param bindClass the the class that ties the process to a role.
	 * @param processId the process's id.
	 * @return the user's id tied to the process.
	 * @throws InterruptedException the interrupted exception
	 */
	@SuppressWarnings("unchecked")
	private String createProcessBind(String role, 
			ProcessBindIdClass bindClass, String processId) throws InterruptedException {
		ProcessBind processBind;
		processBind = new ProcessBind();
		processBind.setId(bindClass);
		String userId = null;
		createProcessIfNecessary(processId);
		OUTERMOST: do {
			Session session = configureSessionFactory.openSession();
			try {
				List<User> userList = session.createCriteria(User.class)
						.add(Restrictions.eq("isAvailable", true)).list();
						//.add(Restrictions.eq("role", true))
				System.out.println("userList="+userList);
				if (userList != null) {
					for (User anyUser : userList) {
						System.out.println("user="+anyUser.getUserId());
						Role roleObj = (Role) session.get(Role.class, role);
						if (anyUser.getRole().contains(roleObj)) {
							System.out.println("selectedUser="+anyUser.getUserId());
							userId = anyUser.getUserId();
							session.beginTransaction();
							User user = (User) session.get(User.class, userId);
							user.setAvailable(false);
							session.saveOrUpdate(user);
							session.getTransaction().commit();
							break OUTERMOST;
						}
					}
				}
			} finally {
				session.close();
			}
			
			if (userId == null) {
				Thread.sleep(20000);
			}
		} while (userId == null);

		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			User user = (User) session.get(User.class, userId);
			processBind.setUser(user);
			Process process = (Process) session.get(Process.class, processId);
			process.getProcessBind().add(processBind);
			session.saveOrUpdate(processBind);
			session.saveOrUpdate(process);
			session.getTransaction().commit();
		} finally {
			session.close();	
		}
		return userId;
	}

	/**
	 * Generate an id to a process.
	 *
	 * @return a unique process's id.
	 */
	public String generateId() {
		String uuid = UUID.randomUUID().toString();
		uuid = HEAD_PROCESS + counter + uuid;
		counter++;
		return uuid;
	}

	/**
	 * This method register a user in the data base.
	 *
	 * @param login the new user's login
	 * @param password the new user's password
	 * @param role the user's role.
	 * @param hostAddress the host of the current user's device.
	 */
	public void subscribe(String login, String password, String role,
			String hostAddress) {
		User newUser = new User();
		Context newContext = new Context();
		createRoleIfNecessary(role);

		newContext.setIpAddress(hostAddress);
		newContext.setProtocolType(ProtocolType.Rest);

		newUser.setPassword(password);
		newUser.setUserId(login);
		newUser.setContext(newContext);
		newUser.setAvailable(true);

		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			Role userRole = (Role) session.get(Role.class, role);
			newUser.getRole().add(userRole);
			session.saveOrUpdate(newContext);
			session.saveOrUpdate(newUser);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	/**
	 * This method verifies if there is a user in the data base.
	 *
	 * @param login the user's login
	 * @param password the user's password
	 * @return if the user exists and the password is correct, this 
	 * method returns the role of the user. Otherwise, it returns null. 
	 */
	public String verifyUser(String login, String password) {
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			User user = (User) session.get(User.class, login);
			if (user != null && user.getPassword().equals(password)) {
				return user.getRole().iterator().next().getRoleId();
			}
		} finally {
			session.close();
		}
		return null;
	}

	/**
	 * This process finalize a process.
	 *
	 * @param role the user'role.
	 * @param processId the process's id.
	 */
	public void finishProcess(String role, String processId) {
		getDispatcherByRole(role, processId).releaseAll(processId);
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			Process process = (Process) session.get(Process.class, processId);
			process.setFinished(true);
			session.saveOrUpdate(process);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	/**
	 * This method requires an input interaction.
	 *
	 * @param role the user'role.
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @return the data provided by the user.
	 */
	public List<CoordinatedData> requireInputInteraction(String role,
			String processId, String userInteracId) {

		createRoleIfNecessary(role);
		createProcessIfNecessary(processId);

		String userId = getUser(role, processId);
		int interactionRealId = createInteraction(processId, userId, userInteracId);
		List<CoordinatedData> reponse = getDispatcher(userId)
				.requireInputInteraction(processId, userInteracId, role);

		Session session = configureSessionFactory.openSession();
		try {
				
			session.beginTransaction();
			Interaction interaction = (Interaction) session.get(Interaction.class,
					interactionRealId);
	
			Collection<DataItem> persistedData =
					persistData(reponse, InteractionType.Input);

			interaction.getProvidedData().addAll(persistedData);
			interaction.setFinished(true);
			session.saveOrUpdate(interaction);
			session.getTransaction().commit();
			return reponse;
		} finally {
			if (userInteracId.equals("28") || userInteracId.equals("31")){
				releaseRole(role, processId);
			}
			session.close();
		}
	}

	/**
	 * This method requires a select interaction.
	 *
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @param selectableData the data which the user can select.
	 * @param role the user's role.
	 * @return the data selected by the user.
	 */
	public List<CoordinatedData> requireSelectionInteracion(String processId,
			String userInteracId, List<CoordinatedData> selectableData,
			String role) {
		createRoleIfNecessary(role);
		createProcessIfNecessary(processId);

		String userId = getUser(role, processId);
		int interactionRealId = createInteraction(processId, userId, userInteracId);

		Collection<DataItem> persistedDataIn =
				persistData(selectableData, InteractionType.Output);
		
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			Interaction interaction = (Interaction) session.get(Interaction.class,
					interactionRealId);
			interaction.getAvailableData().addAll(persistedDataIn);
			session.getTransaction().commit();
		} finally {
			session.close();
		}	

		List<CoordinatedData> reponse = getDispatcher(userId)
				.requireSelectionInteraction(processId, userInteracId,
				selectableData, role);
	
		session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			Interaction interaction = (Interaction) session.get(Interaction.class,
					interactionRealId);
	
			Collection<DataItem> persistedData = persistData(reponse,
					InteractionType.Input);
			interaction.getProvidedData().addAll(persistedData);
			interaction.setFinished(true);
			session.saveOrUpdate(interaction);
			session.getTransaction().commit();
			return reponse;
		} finally {
			if (userInteracId.equals("28") || userInteracId.equals("31")){
				releaseRole(role, processId);
			}
			session.close();
		}
		
	}

	/**
	 * This method requires an output interaction.
	 *
	 * @param processId the process's id.
	 * @param userInteracId the user interaction's id.
	 * @param outputData the data to be presented to the user.
	 * @param role the user's role.
	 */
	public void requireOutputInteracion(String processId, String userInteracId,
			List<CoordinatedData> outputData, String role) {

		createRoleIfNecessary(role);
		createProcessIfNecessary(processId);

		String userId = getUser(role, processId);
		int interactionRealId = createInteraction(processId, userId, userInteracId);

		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			Interaction interaction = (Interaction) session.get(Interaction.class,
					interactionRealId);
			Collection<DataItem> persistedDataIn =
					persistData(outputData, InteractionType.Output);
			interaction.getAvailableData().addAll(persistedDataIn);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		

		getDispatcher(userId).requireOutputInteraction(processId,
				userInteracId, outputData, role);

		if (userInteracId.equals("29") || userInteracId.equals("32")) {
			finishProcess(role, processId);
			releaseRole(role, processId);
		}
	}

	/**
	 * This method releases the user binded to a specific
	 * process and role.
	 *
	 * @param role the user'role.
	 * @param processId the process's id.
	 */
	private void releaseRole(String role, String processId) {
		String userId = getUser(role, processId);
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			System.out.println("RELEASE USER="+userId);
			User user = (User) session.get(User.class, userId);
			user.setAvailable(true);
			session.saveOrUpdate(user);
			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}
	
	/**
	 * This method persists some data items in the data base.
	 *
	 * @param data the data to be persisted.
	 * @param interactionType the interaction type.
	 * @return the collection of the persisted DataItems.
	 */
	private Collection<DataItem> persistData(List<CoordinatedData> data,
			InteractionType interactionType) {
		Collection<DataItem> dataItems = new LinkedList<DataItem>();
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			for (CoordinatedData providedData : data) {
				DataItem item = new DataItem();
				item.setItemId(providedData.getId());
				item.setType(interactionType);
				item.setItemType(ItemType.text);
				item.setData((Serializable) providedData.getContent());
				dataItems.add(item);
				session.saveOrUpdate(item);
			}
			session.getTransaction().commit();
			return dataItems;
		} finally {
			session.close();
		}
	}

	/**
	 * Creates the interaction.
	 *
	 * @param processId the process's id.
	 * @param userId the user's id.
	 * @param userInteracId the user interaction's id.
	 * @return the id of the created interaction.
	 */
	private int createInteraction(String processId, String userId, String userInteracId) {
		Interaction interaction = new Interaction();
		interaction.setInteractionId(userInteracId);
		interaction.setFinished(false);
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			Process process = (Process) session.get(Process.class, processId);
			process.getInteractions().add(interaction);
			session.saveOrUpdate(interaction);
			session.saveOrUpdate(process);
			session.getTransaction().commit();
			return interaction.getInteractionRealId();
		} finally {
			session.close();
		}
	}
	
	/**
	 * Creates the role if it does not exists in the Data Base.
	 *
	 * @param role a user'role.
	 */
	private void createRoleIfNecessary(String role) {
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			Role roleObj = (Role) session.get(Role.class, role);
			if (roleObj == null) {
				roleObj = new Role();
				roleObj.setRoleId(role);
				session.saveOrUpdate(roleObj);
			}
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Creates the process if it does not exists in the Data Base.
	 *
	 * @param processId the process's id.
	 */
	private void createProcessIfNecessary(String processId) {
		Session session = configureSessionFactory.openSession();
		try {
			Process process = (Process) session.get(Process.class, processId);
			if (process == null) {
				process = new Process();
				process.setProcessId(processId);
				process.setFinished(false);
				session.beginTransaction();
				session.saveOrUpdate(process);
				session.getTransaction().commit();
			}
		} finally {
			session.close();
		}
	}

	/**
	 * Gets the dispatcher.
	 *
	 * @param userId the user's id
	 * @return If the userId exists, it returns the corresponding
	 * Dispatcher. Otherwise, it returns null.
	 */
	private Dispatcher getDispatcher(String userId) {
		Session session = configureSessionFactory.openSession();
		try {
			User user = (User) session.get(User.class, userId);
			if (user.getContext().getProtocolType().equals(ProtocolType.Rest))
				return new RestDispatcher(user.getContext().getIpAddress());
			return null;
		} finally {
			session.close();
		}
	}

	/**
	 * Gets the dispatcher by role.
	 *
	 * @param role the role
	 * @param processId the process's id.
	 * @return the dispatcher by role
	 */
	private Dispatcher getDispatcherByRole(String role, String processId) {
		createRoleIfNecessary(role);
		createProcessIfNecessary(processId);

		String userId = getUser(role, processId);
		Dispatcher dis = getDispatcher(userId);
		return dis;
	}
}
