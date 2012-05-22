package be.ac.fundp.precise.dataManagment.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import be.ac.fundp.precise.dataManagment.CoordinatedData;
import be.ac.fundp.precise.dataManagment.DataManager;
import be.ac.fundp.precise.dataManagment.hibernate.dao.Context;
import be.ac.fundp.precise.dataManagment.hibernate.dao.DataItem;
import be.ac.fundp.precise.dataManagment.hibernate.dao.Interaction;
import be.ac.fundp.precise.dataManagment.hibernate.dao.InteractionType;
import be.ac.fundp.precise.dataManagment.hibernate.dao.ItemType;
import be.ac.fundp.precise.dataManagment.hibernate.dao.Process;
import be.ac.fundp.precise.dataManagment.hibernate.dao.ProcessBind;
import be.ac.fundp.precise.dataManagment.hibernate.dao.ProcessBind.ProcessBindIdClass;
import be.ac.fundp.precise.dataManagment.hibernate.dao.ProtocolType;
import be.ac.fundp.precise.dataManagment.hibernate.dao.Role;
import be.ac.fundp.precise.dataManagment.hibernate.dao.User;

public class DataManagerHibernate implements DataManager{

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		configureSessionFactory = configuration
				.buildSessionFactory(serviceRegistry);
	}

	/** The configure session factory. */
	public static SessionFactory configureSessionFactory;
	
	@Override
	public synchronized void createRoleIfNecessary(String role) {
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

	@Override
	public synchronized void createProcessIfNecessary(String processId) {
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

	@Override
	public String getUser(String role, String processId) {
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

	private String createProcessBind(String role, ProcessBindIdClass bindClass,
			String processId) throws InterruptedException {
		ProcessBind processBind = new ProcessBind();
		processBind.setId(bindClass);
		String userId = null;
		createProcessIfNecessary(processId);
		do {
			userId = getUserId(role);
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

	private String getUserId(String role) {
		Session session = configureSessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<User> userList = session.createCriteria(User.class)
					.add(Restrictions.eq("isAvailable", true)).list();
			if (userList != null) {
				for (User anyUser : userList) {
					Role roleObj = (Role) session.get(Role.class, role);
					if (anyUser.getRole().contains(roleObj)) {
						String userId = anyUser.getUserId();
						session.beginTransaction();
						User user = (User) session.get(User.class, userId);
						user.setAvailable(false);
						session.saveOrUpdate(user);
						session.getTransaction().commit();
						return userId;
					}
				}
			}
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public int createInteraction(String processId, String userId,
			String userInteracId) {
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

	@Override
	public void providedInteractionData(int interactionRealId,
			List<CoordinatedData> response, InteractionType type) {
		Collection<DataItem> dataItems = new LinkedList<DataItem>();
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			for (CoordinatedData providedData : response) {
				DataItem item = new DataItem();
				item.setItemId(providedData.getId());
				item.setType(type);
				item.setItemType(ItemType.text);
				item.setData((Serializable) providedData.getContent());
				dataItems.add(item);
				session.saveOrUpdate(item);
			}
			Interaction interaction = (Interaction) session.get(Interaction.class,
					interactionRealId);
			interaction.getAvailableData().addAll(dataItems);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void releaseRole(String role, String processId) {
		String userId = getUser(role, processId);
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			User user = (User) session.get(User.class, userId);
			user.setAvailable(true);
			session.saveOrUpdate(user);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public ProtocolType getUserProtocolType(String userId) {
		Session session = configureSessionFactory.openSession();
		try {
			User user = (User) session.get(User.class, userId);
			return user.getContext().getProtocolType();
		} finally {
			session.close();
		}
	}

	@Override
	public String getIpAddress(String userId) {
		Session session = configureSessionFactory.openSession();
		try {
			User user = (User) session.get(User.class, userId);
			return user.getContext().getIpAddress();
		} finally {
			session.close();
		}
	}

	@Override
	public void finishProcess(String processId) {
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

	@Override
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

	@Override
	public void subscribe(String login, String password, String role,
			String newIpAddress) {
		User newUser = new User();
		Context newContext = new Context();
		createRoleIfNecessary(role);

		newContext.setIpAddress(newIpAddress);
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

}
