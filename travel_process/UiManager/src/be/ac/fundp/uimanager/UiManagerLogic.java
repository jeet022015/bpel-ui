package be.ac.fundp.uimanager;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import be.ac.fundp.uimanager.dao.Context;
import be.ac.fundp.uimanager.dao.Interaction;
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

	}
	
	public static UiManagerLogic getInstance(){
		if (self == null)
			self = new UiManagerLogic();
		return self;
	}

	public Dispatcher getDispatcher(String role, String processId) {
		createRoleIfNecessary(role);
		createProcessIfNecessary(processId);
		User user = getUser(role, processId);
		Dispatcher dis = getDispatcher(user.getContext());
		return dis;
	}

	@SuppressWarnings("unchecked")
	private User getUser(String role, String processId) {
		User user = null;
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		ProcessBindIdClass idClass = new ProcessBindIdClass();
		Process process = (Process) session.get(Process.class, processId);
		Role roleObj = (Role) session.get(Role.class, role);
		idClass.setRole(roleObj);
		idClass.setProcess(process);
		ProcessBind processBind = (ProcessBind) session.get(ProcessBind.class, idClass);
		if (processBind == null) {
			processBind = new ProcessBind();
			processBind.setId(idClass);
			List<User> userList = null;
			do {
				userList = session.createCriteria(User.class)
						.add(Restrictions.eq("isAvailable", true)).list();
				if (userList.isEmpty()) {
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					user = userList.get(0);
					user.setAvailable(false);
					session.saveOrUpdate(user);
				}
			} while (userList == null || userList.isEmpty());
		    
		    processBind.setUser(user);
		    process.getProcessBind().add(processBind);
		    session.saveOrUpdate(processBind);
		    session.saveOrUpdate(process);
		} else {
			user = processBind.getUser();
		}
		session.getTransaction().commit();
		session.close();
		return user;
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
		
		newContext.setIpAddress(ipAddress);
		newContext.setProtocolType(ProtocolType.Rest);
		
		newUser.setPassword(password);
		newUser.setUserId(login);
		newUser.setContext(newContext);
		newUser.setAvailable(true);
		
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(newContext);
		session.getTransaction().commit();
		
		session.beginTransaction();
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

	public void releaseInteracitons(String role, String processId) {
		getDispatcher(role, processId).releaseAll(processId);
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		User user = getUser(role, processId);
		User userToSave = (User) session.get(User.class, user.getUserId());
		Process process = (Process) session.get(Process.class, processId);
		process.setFinished(true);
		userToSave.setAvailable(true);
		session.saveOrUpdate(userToSave);
		session.saveOrUpdate(process);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<ProvidedData> requireInputInteracion(String role,
			String processId, String userInteracId) {
		
		createRoleIfNecessary(role);
		createProcessIfNecessary(processId);
		
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();

		Interaction interaction = new Interaction();
		interaction.setInteractionId(userInteracId);
		interaction.setFinished(false);

//		ProcessBindIdClass idClass = new ProcessBindIdClass();
//		idClass.setRole(roleObj);
//		idClass.setProcess(process);
//		ProcessBind processBind = (ProcessBind) session.get(ProcessBind.class, idClass);
//		if (processBind == null) {
//			processBind = new ProcessBind();
//			processBind.setId(idClass);
//			List<User> userList = null;
//			do {
//				userList = session.createCriteria(User.class)
//						.add(Restrictions.eq("isAvailable", true)).list();
//				if (userList.isEmpty()) {
//					try {
//						Thread.sleep(20000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				} else {
//					user = userList.get(0);
//					user.setAvailable(false);
//					session.saveOrUpdate(user);
//				}
//			} while (userList == null || userList.isEmpty());
//		    
//		    processBind.setUser(user);
//		    process.getProcessBind().add(processBind);
//		    session.saveOrUpdate(processBind);
//		    session.saveOrUpdate(process);
//		} else {
//			user = processBind.getUser();
//		}
		
		User user = getUser(role, processId);
		
		Process process = (Process) session.get(Process.class, processId);
		process.getInteractions().add(interaction);
		session.saveOrUpdate(interaction);
		session.saveOrUpdate(process);
		session.getTransaction().commit();
		
		List<ProvidedData> reponse = getDispatcher(user.getContext()).requireInputInteracion(processId, userInteracId, role);
		
		session.beginTransaction();
		
//		for (ProvidedData providedData : reponse) {
//			DataItem item = new DataItem();
//			item.setItemId(providedData.getId());
//			item.setType(InteractionType.Input);
//			item.setItemType(ItemType.text);
//			item.setData((Serializable) providedData.getData());
//			session.saveOrUpdate(item);
//			interaction.getProvidedData().add(item);
//		}
		
		interaction.setFinished(true);
		
		session.saveOrUpdate(interaction);
		session.saveOrUpdate(process);
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
		
//		for (ProvidedData providedData : uiDataType2ProvidedData) {
//			DataItem item = new DataItem();
//			item.setItemId(providedData.getId());
//			item.setType(InteractionType.Output);
//			item.setItemType(ItemType.text);
//			item.setData((Serializable) providedData.getData());
//			interaction.getAvailableData().add(item);
//		}
		
		createRoleIfNecessary(role);
		
		createProcessIfNecessary(processId);
		
		User user = getUser(role, processId);
		
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		Process process = (Process) session.get(Process.class, processId);
		session.saveOrUpdate(interaction);
		process.getInteractions().add(interaction);
		session.saveOrUpdate(process);
		session.getTransaction().commit();
		session.close();
		
		List<ProvidedData> reponse = getDispatcher(user.getContext()).requireSelectionInteracion(processId, userInteracId, uiDataType2ProvidedData, role);
		
//		for (ProvidedData providedData : reponse) {
//			DataItem item = new DataItem();
//			item.setItemId(providedData.getId());
//			item.setType(InteractionType.Input);
//			item.setItemType(ItemType.text);
//			item.setData((Serializable) providedData.getData());
//			interaction.getProvidedData().add(item);
//		}
		
//		session = configureSessionFactory.openSession();
//		session.beginTransaction();
//		session.saveOrUpdate(process);
//		session.getTransaction().commit();
//		session.close();
		
		return reponse;
	}

	public void requireOutputInteracion(String processId, String userInteracId,
			List<ProvidedData> uiDataType2ProvidedData, String role) {
		
		Interaction interaction = new Interaction();
		interaction.setInteractionId(userInteracId);
		interaction.setFinished(false);
		
//		for (ProvidedData providedData : uiDataType2ProvidedData) {
//			DataItem item = new DataItem();
//			item.setItemId(providedData.getId());
//			item.setType(InteractionType.Output);
//			item.setItemType(ItemType.text);
//			item.setData((Serializable) providedData.getData());
//			interaction.getAvailableData().add(item);
//		}
		
		createRoleIfNecessary(role);
		
		createProcessIfNecessary(processId);
		
		User user = getUser(role, processId);
		
		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		Process process = (Process) session.get(Process.class, processId);
		process.getInteractions().add(interaction);
		session.saveOrUpdate(interaction);
		session.saveOrUpdate(process);
		session.getTransaction().commit();
		session.close();
		
		getDispatcher(user.getContext()).requireOutputInteracion(processId, userInteracId, uiDataType2ProvidedData, role);
		
		if (userInteracId.equals("29"))
			releaseInteracitons(role, processId);
	}
}
