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

/**
 * The Class DataManagerHibernate.
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date May 22, 2012
 */
public class DataManagerHibernate implements DataManager {

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

	/**
	 * Creates the role.
	 * 
	 * @param roleId
	 *            the role id
	 */
	public synchronized void createRole(String roleId) {
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			Role newRole = (Role) session.get(Role.class, roleId);
			if (newRole == null) {
				newRole = new Role();
				newRole.setRoleId(roleId);
				session.saveOrUpdate(newRole);
			}
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	/**
	 * Creates the new process.
	 * 
	 * @param processId
	 *            the process' id
	 */
	public synchronized void createProcess(String processId) {
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			Process process = (Process) session.get(Process.class, processId);
			if (process == null) {
				process = new Process();
				process.setProcessId(processId);
				process.setFinished(false);
				session.saveOrUpdate(process);
			}
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	/**
	 * This method retrieves from the DB the user's id from the DB.
	 * 
	 * @param roleId
	 *            the role Id
	 * @param processId
	 *            the process Id
	 * @return the user Id
	 */
	private String boundUserFromDB(String roleId, String processId) {
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			ProcessBindIdClass idClass = new ProcessBindIdClass();
			Process process = getProcess(processId, session);
			Role roleObj = getRole(roleId, session);
			idClass.setRole(roleObj);
			idClass.setProcess(process);
			ProcessBind processBind = (ProcessBind) session
					.createCriteria(ProcessBind.class)
					.add(Restrictions.eq("id", idClass)).uniqueResult();
			if (processBind != null)
				return processBind.getUser().getUserId();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return null;
	}

	/**
	 * Gets the role.
	 * 
	 * @param roleId
	 *            the role id
	 * @param session
	 *            the session
	 * @return the role
	 */
	private Role getRole(String roleId, Session session) {
		Role roleObj = (Role) session.get(Role.class, roleId);
		if (roleObj == null) {
			createRole(roleId);
			roleObj = (Role) session.get(Role.class, roleId);
		}
		return roleObj;
	}

	/**
	 * Gets the process.
	 * 
	 * @param processId
	 *            the process id
	 * @param session
	 *            the session
	 * @return the process
	 */
	private Process getProcess(String processId, Session session) {
		Process process = (Process) session.get(Process.class, processId);
		if (process == null) {
			createProcess(processId);
			process = (Process) session.get(Process.class, processId);
		}
		return process;
	}

	/**
	 * This method binds a user with the specific role to a specific process.
	 * 
	 * @param role
	 *            the role
	 * @param processId
	 *            the process id
	 * @return the user Id
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	private String createProcessBind(String role, String processId)
			throws InterruptedException {

		String userId = null;
		do {
			userId = getAvailableUser(role);
			if (userId == null) {
				Thread.sleep(20000);
			}
		} while (userId == null);

		Session session = configureSessionFactory.openSession();
		session.beginTransaction();
		ProcessBind processBind = new ProcessBind();
		ProcessBindIdClass bindClass = new ProcessBindIdClass();
		Process process = getProcess(processId, session);
		Role userRole = getRole(role, session);
		bindClass.setRole(userRole);
		bindClass.setProcess(process);
		processBind.setId(bindClass);
		try {
			User user = (User) session.get(User.class, userId);
			processBind.setUser(user);
			process.getProcessBind().add(processBind);
			session.saveOrUpdate(processBind);
			session.saveOrUpdate(process);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return userId;
	}

	/**
	 * Gets an available user.
	 * 
	 * @param roleId
	 *            the role id
	 * @return the available user id
	 */
	private String getAvailableUser(String roleId) {
		Session session = configureSessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<User> userList = session.createCriteria(User.class)
					.add(Restrictions.eq("isAvailable", true)).list();
			if (userList == null)
				return null;

			for (User aUser : userList) {
				Role roleObj = getRole(roleId, session);
				if (aUser.getRole().contains(roleObj)) {
					setUnavailableUser(aUser.getUserId());
					return aUser.getUserId();
				}
			}
		} finally {
			session.close();
		}
		return null;
	}

	/**
	 * Sets the availability user property to false.
	 * 
	 * @param userId
	 *            the new unavailable user
	 */
	private void setUnavailableUser(String userId) {
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			User user = (User) session.get(User.class, userId);
			user.setAvailable(false);
			session.saveOrUpdate(user);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.ac.fundp.precise.dataManagment.DataManager#createInteraction(java.
	 * lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int createInteraction(String processId, String userId,
			String userInteracId) {
		Interaction interaction = new Interaction();
		interaction.setInteractionId(userInteracId);
		interaction.setFinished(false);
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			Process process = getProcess(processId, session);
			process.getInteractions().add(interaction);
			session.saveOrUpdate(interaction);
			session.saveOrUpdate(process);
			return interaction.getInteractionRealId();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.ac.fundp.precise.dataManagment.DataManager#providedInteractionData
	 * (int, java.util.List,
	 * be.ac.fundp.precise.dataManagment.hibernate.dao.InteractionType)
	 */
	@Override
	public void providedInteractionData(int interactionRealId,
			List<CoordinatedData> providedData, InteractionType type) {
		Collection<DataItem> dataItems = new LinkedList<DataItem>();
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			for (CoordinatedData anItem : providedData) {
				DataItem item = new DataItem();
				item.setItemId(anItem.getId());
				item.setType(type);
				item.setItemType(ItemType.text);
				item.setData((Serializable) anItem.getContent());
				dataItems.add(item);
				session.saveOrUpdate(item);
			}
			Interaction interaction = (Interaction) session.get(
					Interaction.class, interactionRealId);
			interaction.getAvailableData().addAll(dataItems);
			session.saveOrUpdate(interaction);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.ac.fundp.precise.dataManagment.DataManager#releaseRole(java.lang.String
	 * , java.lang.String)
	 */
	@Override
	public void releaseRole(String role, String processId) {
		String userId = getBoundUser(role, processId);
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			User user = (User) session.get(User.class, userId);
			user.setAvailable(true);
			session.saveOrUpdate(user);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.ac.fundp.precise.dataManagment.DataManager#getUserProtocolType(java
	 * .lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.ac.fundp.precise.dataManagment.DataManager#getIpAddress(java.lang.
	 * String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.ac.fundp.precise.dataManagment.DataManager#finishProcess(java.lang
	 * .String)
	 */
	@Override
	public void finishProcess(String processId) {
		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			Process process = (Process) session.get(Process.class, processId);
			process.setFinished(true);
			session.saveOrUpdate(process);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.ac.fundp.precise.dataManagment.DataManager#verifyUser(java.lang.String
	 * , java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.ac.fundp.precise.dataManagment.DataManager#subscribe(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void subscribe(String login, String password, String role,
			String newIpAddress) {
		User newUser = new User();
		Context newContext = new Context();
		createRole(role);

		newContext.setIpAddress(newIpAddress);
		newContext.setProtocolType(ProtocolType.Rest);

		newUser.setPassword(password);
		newUser.setUserId(login);
		newUser.setContext(newContext);
		newUser.setAvailable(true);

		Session session = configureSessionFactory.openSession();
		try {
			session.beginTransaction();
			Role roleObj = getRole(role, session);
			newUser.getRole().add(roleObj);
			session.saveOrUpdate(newContext);
			session.saveOrUpdate(newUser);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.ac.fundp.precise.dataManagment.DataManager#getBoundUser(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public String getBoundUser(String roleId, String processId) {
		Session session = configureSessionFactory.openSession();
		try {

			String boundUser = boundUserFromDB(roleId, processId);
			if (boundUser != null)
				return boundUser;
			else
				return createProcessBind(roleId, processId);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
}
