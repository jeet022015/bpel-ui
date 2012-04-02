package be.ac.fundp.uimanager;

import java.io.Serializable;
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
import be.ac.fundp.uimanager.dispatcher.restDispatcher.RestDispacher;
import be.ac.fundp.uimanager.model.ProvidedData;


public class UiManagerLogic {
	
	static {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    configureSessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	static UiManagerLogic self;
	
	public static SessionFactory configureSessionFactory;
	
	private int counter = 1;
	
	private String HEAD_PROCESS = "Trip";
	
	protected UiManagerLogic(){
		Role role = new Role();
		role.setRoleId("manager");
		
		User user = new User();
		user.setUserId("philippe");
		user.setPassword("philippe");
		user.setAvailable(true);
		user.getRole().add(role);
		
		Context context = new Context();
		//http://localhost:8070/UsiXML-WebClient/restlet/test
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
	
	public static UiManagerLogic getInstance(){
		if (self == null)
			self = new UiManagerLogic();
		return self;
	}

	public Dispatcher getDispatcher(String role, String processId) {
		createRoleIfNecessary(role);
		createProcessIfNecessary(processId);
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		String userId = getUser(role, processId);
		User user = (User) session.get(User.class, userId);
		Dispatcher dis = getDispatcher(user.getContext());
		session.getTransaction().commit();
		session.close();
		return dis;
	}

	@SuppressWarnings("unchecked")
	private String getUser(String role, String processId) {
		User user = null;
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		ProcessBindIdClass idClass = new ProcessBindIdClass();
		Process process = (Process) session.get(Process.class, processId);
		Role roleObj = (Role) session.get(Role.class, role);
		idClass.setRole(roleObj);
		idClass.setProcess(process);
		//ProcessBind processBind = (ProcessBind) session.get(ProcessBind.class, idClass);
		ProcessBind processBind = (ProcessBind)session.createCriteria(ProcessBind.class)
				.add(Restrictions.eq("id", idClass)).uniqueResult();
		if (processBind == null) {
			processBind = new ProcessBind();
			processBind.setId(idClass);
			List<User> userList = null;
			do {
				session.getTransaction().commit();
				session.beginTransaction();
				userList = session.createCriteria(User.class)
						.add(Restrictions.eq("isAvailable", true)).list();

				if (userList != null){
					for (User anyUser : userList) {
						System.out.println("user="+anyUser.getUserId());
						for (Role roleAnyUser : anyUser.getRole()) {
							System.out.println("roleAnyUser="+roleAnyUser.getRoleId());
							System.out.println("ExpectedRole="+role);
							if (roleAnyUser.getRoleId().equalsIgnoreCase(role)){
								System.out.println("yeaaaaa");
								user = anyUser;
								user.setAvailable(false);
								session.saveOrUpdate(user);
								break;
							}
						}
					}
				}
				if (user == null) {
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} while (user == null);
		    
		    processBind.setUser(user);
		    process.getProcessBind().add(processBind);
		    session.saveOrUpdate(processBind);
		    session.saveOrUpdate(process);
		} else {
			user = processBind.getUser();
		}
		session.getTransaction().commit();
		session.close();
		return user.getUserId();
	}

	private void createRoleIfNecessary(String role) {
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		Role roleObj = (Role) session.get(Role.class, role);
		if (roleObj == null) {
			roleObj = new Role();
			roleObj.setRoleId(role);
			session.saveOrUpdate(roleObj);
		}
		session.getTransaction().commit();
		session.close();
	}

	private void createProcessIfNecessary(String processId) {
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		Process process = (Process) session.get(Process.class, processId);
		if (process == null) {
			process = new Process();
			process.setProcessId(processId);
			process.setFinished(false);
			session.saveOrUpdate(process);
		}
		session.getTransaction().commit();
		session.close();
	}
	
	private Dispatcher getDispatcher(Context context) {
		System.out.println("Context="+context);
		if (context.getProtocolType().equals(ProtocolType.Rest))
			return new RestDispacher(context.getIpAddress());
		return null;
	}

	public String generateId() {
		String uuid = UUID.randomUUID().toString();
		uuid = HEAD_PROCESS+counter+uuid;
		counter++;
		return uuid;
	}

	public void subscribe(String login, String password, String role, String ipAddress) {
		User newUser = new User();
		Context newContext = new Context();
		createRoleIfNecessary(role);
		
		newContext.setIpAddress(ipAddress);
		newContext.setProtocolType(ProtocolType.Rest);
		
		newUser.setPassword(password);
		newUser.setUserId(login);
		newUser.setContext(newContext);
		newUser.setAvailable(true);
		
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		Role userRole = (Role) session.get(Role.class, role);
		newUser.getRole().add(userRole);
		session.saveOrUpdate(newContext);
		session.saveOrUpdate(newUser);
		session.getTransaction().commit();
		session.close();
	}

	public String verifyUser(String login, String password) {
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, login);
		if (user != null && user.getPassword().equals(password)){
			return user.getRole().iterator().next().getRoleId();
		}
		session.getTransaction().commit();
		session.close();
		return null;
	}

	public void finishProcess(String role, String processId) {
		getDispatcher(role, processId).releaseAll(processId);
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		Process process = (Process) session.get(Process.class, processId);
		process.setFinished(true);
		session.saveOrUpdate(process);
		session.getTransaction().commit();
		session.close();
	}

	public List<ProvidedData> requireInputInteracion(String role,
			String processId, String userInteracId) {
		
		createRoleIfNecessary(role);
		createProcessIfNecessary(processId);
		
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();

		Interaction interaction = new Interaction();
		interaction.setInteractionId(userInteracId);
		interaction.setFinished(false);

		String userId = getUser(role, processId);
		User user = (User) session.get(User.class, userId);
		
		Process process = (Process) session.get(Process.class, processId);
		process.getInteractions().add(interaction);
		session.saveOrUpdate(interaction);
		session.saveOrUpdate(process);
		session.getTransaction().commit();
		
		List<ProvidedData> reponse = getDispatcher(user.getContext()).requireInputInteracion(processId, userInteracId, role);
		
		session.beginTransaction();
		interaction = (Interaction) session.get(Interaction.class, interaction.getInteractionRealId());
		
		for (ProvidedData providedData : reponse) {
			DataItem item = new DataItem();
			item.setItemId(providedData.getId());
			item.setType(InteractionType.Input);
			item.setItemType(ItemType.text);
			item.setData((Serializable) providedData.getData());
			interaction.getProvidedData().add(item);
			session.saveOrUpdate(item);
		}
		
		interaction.setFinished(true);
		
		session.saveOrUpdate(interaction);
		session.getTransaction().commit();
		session.close();
		return reponse;
	}

	public List<ProvidedData> requireSelectionInteracion(String processId,
			String userInteracId, List<ProvidedData> uiDataType2ProvidedData,
			String role) {
		Interaction interaction = new Interaction();
		interaction.setInteractionId(userInteracId);
		interaction.setFinished(false);
		
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		
		for (ProvidedData providedData : uiDataType2ProvidedData) {
			DataItem item = new DataItem();
			item.setItemId(providedData.getId());
			item.setType(InteractionType.Output);
			item.setItemType(ItemType.text);
			item.setData((Serializable) providedData.getData());
			interaction.getAvailableData().add(item);
			session.saveOrUpdate(item);
		}
		
		createRoleIfNecessary(role);
		createProcessIfNecessary(processId);
		
		String userId = getUser(role, processId);
		
		
		User user = (User) session.get(User.class, userId);
		Process process = (Process) session.get(Process.class, processId);
		session.saveOrUpdate(interaction);
		process.getInteractions().add(interaction);
		session.saveOrUpdate(process);
		session.getTransaction().commit();
		
		List<ProvidedData> reponse = getDispatcher(user.getContext()).requireSelectionInteracion(processId, userInteracId, uiDataType2ProvidedData, role);
		
		session.beginTransaction();
		interaction = (Interaction) session.get(Interaction.class, interaction.getInteractionRealId());
		
		for (ProvidedData providedData : reponse) {
			DataItem item = new DataItem();
			item.setItemId(providedData.getId());
			item.setType(InteractionType.Input);
			item.setItemType(ItemType.text);
			item.setData((Serializable) providedData.getData());
			interaction.getProvidedData().add(item);
			session.saveOrUpdate(item);
		}
		
		interaction.setFinished(true);
		session.saveOrUpdate(interaction);
		
		session.getTransaction().commit();
		session.close();
		
		return reponse;
	}

	public void requireOutputInteracion(String processId, String userInteracId,
			List<ProvidedData> uiDataType2ProvidedData, String role) {
		
		Interaction interaction = new Interaction();
		interaction.setInteractionId(userInteracId);
		interaction.setFinished(false);
		
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		
		for (ProvidedData providedData : uiDataType2ProvidedData) {
			DataItem item = new DataItem();
			item.setItemId(providedData.getId());
			item.setType(InteractionType.Output);
			item.setItemType(ItemType.text);
			item.setData((Serializable) providedData.getData());
			interaction.getAvailableData().add(item);
			session.saveOrUpdate(item);
		}
		
		createRoleIfNecessary(role);
		
		createProcessIfNecessary(processId);
		
		String userId = getUser(role, processId);
		
		User user = (User) session.get(User.class, userId);
		Process process = (Process) session.get(Process.class, processId);
		process.getInteractions().add(interaction);
		session.saveOrUpdate(interaction);
		session.saveOrUpdate(process);
		session.getTransaction().commit();
		session.close();
		
		getDispatcher(user.getContext()).requireOutputInteracion(processId, userInteracId, uiDataType2ProvidedData, role);
		
		if (userInteracId.equals("30") || userInteracId.equals("31")){
			releaseRole(role, processId);
		}
		
		if (userInteracId.equals("29") || userInteracId.equals("32")){
			finishProcess(role, processId);
			releaseRole(role, processId);
		}
	}

	private void releaseRole(String role, String processId) {
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		String userId = getUser(role, processId);
		User user = (User) session.get(User.class, userId);
		user.setAvailable(true);
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
		
	}
}
