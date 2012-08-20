package be.ac.fundp.precise.dataManagment.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import be.ac.fundp.precise.dataManagment.DataManager;
import be.ac.fundp.precise.dataManagment.hibernate.daos.BindingProcess;
import be.ac.fundp.precise.dataManagment.hibernate.daos.Context;
import be.ac.fundp.precise.dataManagment.hibernate.daos.Interaction;
import be.ac.fundp.precise.dataManagment.hibernate.daos.Process;
import be.ac.fundp.precise.dataManagment.hibernate.daos.ProcessInstance;
import be.ac.fundp.precise.dataManagment.hibernate.daos.ProtocolType;
import be.ac.fundp.precise.dataManagment.hibernate.daos.RegistredProcess;
import be.ac.fundp.precise.dataManagment.hibernate.daos.Role;
import be.ac.fundp.precise.dataManagment.hibernate.daos.User;

/**
 * The Class NewDataManagerHibernate.
 */
public class NewDataManagerHibernate {

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
	 * Subscribe user.
	 *
	 * @param login the login
	 * @param password the password
	 * @param hostAdress the host adress
	 * @throws Exception the exception
	 */
	public void subscribeUser (String login, String password, String hostAdress) throws Exception {
		Session session = configureSessionFactory.openSession();
		try {
			User newUser = null;
			try {
				newUser = (User) session.get(User.class, login);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (newUser != null) {
				throw new Exception("duplicated logins");
			} else {
				newUser = new User();
				newUser.setLogin(login);
				newUser.setPassword(password);
				Context context = new Context();
				context.setHostAddress(hostAdress);
				context.setProtocolType(ProtocolType.Rest);
				newUser.setContext(context);
				session.beginTransaction();
				session.save(context);
				session.save(newUser);
				session.getTransaction().commit();
			}
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Verify user.
	 *
	 * @param login the login
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean verifyUser (String login, String password){
		Session session = configureSessionFactory.openSession();
		try {
			User newUser = (User) session.get(User.class, login);
			if (newUser == null) {
				return false;
			}
			return newUser.getPassword().equals(password);
		} finally {
			session.flush();
			session.close();
		}
	}
	
	/**
	 * Registry user in process.
	 *
	 * @param login the login
	 * @param roleId the role id
	 * @param processId the process id
	 */
	public void registryUserInProcess (String login, String roleId, String processId) {
		Session session = configureSessionFactory.openSession();
		try {
			User newUser = (User) session.get(User.class, login);
			Process aProcess = (Process)session
					.createCriteria(Process.class)
					.add(Restrictions.eq("processId", processId)).uniqueResult();
			Role userRole = null;
			for (Role allowedRole : aProcess.getAllowedRole()) {
				if (allowedRole.getRoleId().equals(roleId)){
					userRole = allowedRole;
					break;
				}
			}
			@SuppressWarnings("rawtypes")
			List processBind = session
					.createCriteria(RegistredProcess.class)
					.add(Restrictions.eq("boundProcess", aProcess))
					.add(Restrictions.eq("role", userRole))
					.add(Restrictions.eq("ownerUser", newUser)).list();
			if (!processBind.isEmpty()){
				return;
			}
			RegistredProcess newRegistredProcess = new RegistredProcess();
			newRegistredProcess.setAvailable(true);
			newRegistredProcess.setBoundProcess(aProcess);
			newRegistredProcess.setRole(userRole);
			newRegistredProcess.setUser(newUser);
			session.beginTransaction();
			session.save(newRegistredProcess);
			session.getTransaction().commit();
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Gets the bind user.
	 *
	 * @param role the role
	 * @param processInstanceId the process instance id
	 * @return the bind user
	 * @throws Exception the exception
	 */
	public String getBindUser (String role, String processInstanceId) throws Exception {
		String userId = null;
		int roleId = -1;
		userId = getBoundUser(role, processInstanceId);
		if (userId != null)
			return userId; 
		//List processBind = Collections.emptyList();
		int aRegistredProcessId = -1;
		do{
			Session session = configureSessionFactory.openSession();
			ProcessInstance newProcessInst = (ProcessInstance) session.get(ProcessInstance.class, processInstanceId);
			Process parent = newProcessInst.getOwnProcess();
			Role userRole = null;
			for (Role aRole : parent.getAllowedRole()) {
				if (aRole.getRoleId().equals(role)){
					userRole = aRole;
					roleId = aRole.getRoleRealId();
					break;
				}
			}
			Criteria processBindCriteria = session
					.createCriteria(RegistredProcess.class)
					.add(Restrictions.eq("boundProcess", parent))
					.add(Restrictions.eq("role", userRole))
					.add(Restrictions.eq("available", true));

			@SuppressWarnings("rawtypes")
			List processBind2 = processBindCriteria.list();
			if (processBind2.size() > 0) {
				RegistredProcess aRegistredProcess = (RegistredProcess) processBind2.get(0);
				aRegistredProcessId = aRegistredProcess.getRegistredProcessId();
				System.out.println("user="+aRegistredProcess.getUser());
				userId = aRegistredProcess.getUser().getLogin();
			}
			session.close();
			Thread.sleep(6000);
		} while (aRegistredProcessId == -1);
		Session session = configureSessionFactory.openSession();
		ProcessInstance aProcessInst = (ProcessInstance) session.get(ProcessInstance.class, processInstanceId);
		RegistredProcess aRegistredProcess = (RegistredProcess) session.get(RegistredProcess.class, aRegistredProcessId);
		User aUser = (User) session.get(User.class, userId);
		Role userRole = (Role) session.get(Role.class, roleId);
		BindingProcess bindProcess = new BindingProcess();
		bindProcess.setProcessInstance(aProcessInst);
		bindProcess.setUser(aUser);
		bindProcess.setRole(userRole);
		bindProcess.setRegistredProcess(aRegistredProcess);
		aProcessInst.getProcessBinding().add(bindProcess);
		aRegistredProcess.setAvailable(false);
		session.beginTransaction();
		session.save(bindProcess);
		session.update(aProcessInst);
		session.update(aRegistredProcess);
		session.getTransaction().commit();
		session.close();
		return userId;
	}

	/**
	 * Gets the bound user.
	 *
	 * @param role the role
	 * @param processInstanceId the process instance id
	 * @return the bound user
	 */
	private String getBoundUser(String role, String processInstanceId) {
		Session session = configureSessionFactory.openSession();
		try {
			ProcessInstance aProcessInst = (ProcessInstance) session.get(ProcessInstance.class, processInstanceId);
			if (aProcessInst == null) {
				return null;
			}
			Role userRole = null;
			Process parent = (Process) session.get(Process.class, aProcessInst.getOwnProcess().getProcessRealId());
			for (Role aRole : parent.getAllowedRole()) {
				if (aRole.getRoleId().equals(role))
					userRole = aRole;
			}
			if (userRole == null) {
				return null;
			}
			BindingProcess processBind = (BindingProcess)session
					.createCriteria(BindingProcess.class)
					.add(Restrictions.eq("role", userRole))
					.add(Restrictions.eq("processInstance", aProcessInst)).uniqueResult();
			if (processBind == null)
				return null;
			return processBind.getUser().getLogin();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Bind user.
	 *
	 * @param userId the user id
	 * @param roleRealId the role real id
	 * @param processInstanceId the process instance id
	 * @param registredProcessId the registred process id
	 * @throws Exception the exception
	 */
	public void bindUser(String userId, int roleRealId, String processInstanceId, int registredProcessId) throws Exception {
		Session session = configureSessionFactory.openSession();
		try {
			User aUser = (User) session.get(User.class, userId);
			ProcessInstance aProcessInst = (ProcessInstance) session.get(ProcessInstance.class, processInstanceId);
			Role userRole = (Role) session.get(Role.class, roleRealId);
			RegistredProcess registredProcess = (RegistredProcess) session.get(RegistredProcess.class, registredProcessId);
			if (aProcessInst == null) {
				throw new Exception("process instance "+processInstanceId+": Not created");
			}
			if (aUser == null) {
				throw new Exception("user "+userId+": Not created");
			}
			if (userRole == null) {
				throw new Exception("role id "+roleRealId+": Not created");
			}
			@SuppressWarnings("rawtypes")
			List processBind = session
					.createCriteria(BindingProcess.class)
					.add(Restrictions.eq("user", aUser))
					.add(Restrictions.eq("role", userRole))
					.add(Restrictions.eq("processInstance", aProcessInst)).list();
			if (!processBind.isEmpty()){
				System.out.println("already bond.");
				return;
			}
			BindingProcess bindProcess = new BindingProcess();
			bindProcess.setProcessInstance(aProcessInst);
			bindProcess.setUser(aUser);
			bindProcess.setRole(userRole);
			bindProcess.setRegistredProcess(registredProcess);
			aProcessInst.getProcessBinding().add(bindProcess);
			session.beginTransaction();
			session.save(bindProcess);
			session.update(aProcessInst);
			session.getTransaction().commit();
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Creates the process.
	 *
	 * @param processId the process id
	 * @param roles the roles
	 * @param startingRoles the starting roles
	 * @param interactionMapping the interaction mapping
	 * @throws Exception the exception
	 */
	public void createProcess (String processId, List<String> roles, List<String> startingRoles, Map<String, List<String>> interactionMapping) throws Exception {
		Session session = configureSessionFactory.openSession();
		try {
			@SuppressWarnings("rawtypes")
			List processes = session
					.createCriteria(Process.class)
					.add(Restrictions.eq("processId", processId)).list();
			if (!processes.isEmpty()) {
				session.beginTransaction();
				for (Object objProcess : processes) {
					Process bdProcess = (Process)objProcess;
					session.delete(bdProcess);
				}
				session.getTransaction().commit();
			}
			session.beginTransaction();
			Process newProcess = new Process();
			newProcess.setProcessId(processId);
			session.saveOrUpdate(newProcess);
			session.getTransaction().commit();
			
			session.beginTransaction();
			for (String roleId : roles) {
				Role newRole = new Role();
				newRole.setRoleId(roleId);
				newRole.setStartable((Boolean)startingRoles.contains(roleId));
				newProcess.getAllowedRole().add(newRole);
				session.save(newRole);
			}
			for (String mappingId : interactionMapping.keySet()) {
				Interaction newInteracion = new Interaction();
				newInteracion.setInteractionId(mappingId);
				List<String> mapping = interactionMapping.get(mappingId);
				newInteracion.setAuiId(mapping.toArray(new String[0]));
				newProcess.getInteractions().add(newInteracion);
				session.save(newInteracion);
			}
			session.saveOrUpdate(newProcess);
			session.getTransaction().commit();
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Creates the process instance.
	 *
	 * @param processId the process id
	 * @return the string
	 * @throws Exception the exception
	 */
	public String createProcessInstance (String processId) throws Exception {
		Session session = configureSessionFactory.openSession();
		try {
			Process aProcess = (Process)session
					.createCriteria(Process.class)
					.add(Restrictions.eq("processId", processId)).uniqueResult();
			if (aProcess == null) {
				throw new Exception("process "+processId+": not available.");
			}
			String processInstanceId = DataManager.idGen.genId();
			ProcessInstance instance = new ProcessInstance();
			instance.setOwnProcess(aProcess);
			instance.setFinished(false);
			instance.setProcessInstanceId(processInstanceId);
			session.beginTransaction();
			session.save(instance);
			session.getTransaction().commit();
			return processInstanceId;
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Release role.
	 *
	 * @param roleId the role id
	 * @param processInstanceId the process instance id
	 */
	public void releaseRole(String roleId, String processInstanceId) {
		Session session = configureSessionFactory.openSession();
		try {
			ProcessInstance aProcessInst = (ProcessInstance) session.get(ProcessInstance.class, processInstanceId);
			for (BindingProcess bind : aProcessInst.getProcessBinding()) {
				if (bind.getRole().getRoleId().equals(roleId)){
					RegistredProcess rp = bind.getRegistredProcess();
					rp.setAvailable(true);
					session.beginTransaction();
					session.update(rp);
					session.getTransaction().commit();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Sets the user context.
	 *
	 * @param login the login
	 * @param host the host
	 * @param protocolType the protocol type
	 */
	public void setUserContext(String login, String host, ProtocolType protocolType) {
		Session session = configureSessionFactory.openSession();
		try {
			User aUser = (User) session.get(User.class, login);
			Context context = new Context();
			context.setHostAddress(host);
			context.setProtocolType(protocolType);
			aUser.setContext(context);
			session.beginTransaction();
			session.saveOrUpdate(context);
			session.saveOrUpdate(aUser);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Gets the user protocol type.
	 *
	 * @param login the login
	 * @return the user protocol type
	 * @throws Exception the exception
	 */
	public ProtocolType getUserProtocolType(String login) throws Exception {
		Session session = configureSessionFactory.openSession();
		try {
			User aUser = (User) session.get(User.class, login);
			Context c = aUser.getContext();
			return c.getProtocolType();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("user "+login+" dont exists!");
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Gets the ip address.
	 *
	 * @param login the login
	 * @return the ip address
	 * @throws Exception the exception
	 */
	public String getIpAddress(String login) throws Exception {
		Session session = configureSessionFactory.openSession();
		try {
			User aUser = (User) session.get(User.class, login);
			Context c = aUser.getContext();
			return c.getHostAddress();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("user "+login+" dont exists!");
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Finish process.
	 *
	 * @param processInsntanceId the process insntance id
	 * @throws Exception the exception
	 */
	public void finishProcess(String processInsntanceId) throws Exception {
		Session session = configureSessionFactory.openSession();
		try {
			ProcessInstance aProcess = (ProcessInstance) session.get(ProcessInstance.class, processInsntanceId);
			aProcess.setFinished(true);
			session.beginTransaction();
			for (BindingProcess bind : aProcess.getProcessBinding()) {
				RegistredProcess r = bind.getRegistredProcess();
				r.setAvailable(true);
				session.saveOrUpdate(r);
			}
			session.saveOrUpdate(aProcess);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Process Instance "+processInsntanceId+" dont exists!");
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Gets the available processes.
	 *
	 * @return the available processes
	 * @throws Exception the exception
	 */
	public List<String> getAvailableProcesses() throws Exception {
		List<String> processesIds = new ArrayList<String>();
		Session session = configureSessionFactory.openSession();
		try {
			@SuppressWarnings("rawtypes")
			List processes = session
					.createCriteria(Process.class).list();
			for (Object objProcess : processes) {
				Process p = (Process)objProcess;
				processesIds.add(p.getProcessId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Process dont exists!");
		} finally {
			session.flush();
			session.close();
		}
		return processesIds;
	}

	/**
	 * Gets the starting roles.
	 *
	 * @param processId the process id
	 * @return the starting roles
	 * @throws Exception the exception
	 */
	public List<String> getStartingRoles(String processId) throws Exception {
		List<String> roleIds = new ArrayList<String>();
		Session session = configureSessionFactory.openSession();
		try {
			Process aProcess = (Process)session
					.createCriteria(Process.class)
					.add(Restrictions.eq("processId", processId)).uniqueResult();
			for (Role aRole : aProcess.getAllowedRole()) {
				if (aRole.getStartable())
					roleIds.add(aRole.getRoleId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Process "+processId+" dont exists!");
		} finally {
			session.flush();
			session.close();
		}
		return roleIds;
	}

	/**
	 * Bind starting user.
	 *
	 * @param login the login
	 * @param processInstanceId the process instance id
	 * @throws Exception the exception
	 */
	public void bindStartingUser(String login, String processInstanceId) throws Exception {
		Session session = configureSessionFactory.openSession();
		int roleId;
		int registredProcessId;
		try {
			ProcessInstance aProcess = (ProcessInstance) session.get(ProcessInstance.class, processInstanceId);
			User aUser = (User) session.get(User.class, login);
			@SuppressWarnings("rawtypes")
			List processBind = session
					.createCriteria(RegistredProcess.class)
					.add(Restrictions.eq("boundProcess", aProcess.getOwnProcess()))
					.add(Restrictions.eq("ownerUser", aUser)).list();
			RegistredProcess registredProcess = (RegistredProcess) processBind.get(0);
			registredProcessId = registredProcess.getRegistredProcessId();
			roleId = registredProcess.getRole().getRoleRealId();
			BindingProcess bind = new BindingProcess();
			bind.setProcessInstance(aProcess);
			bind.setUser(aUser);
			bind.setRole(registredProcess.getRole());
			bind.setRegistredProcess(registredProcess);
			registredProcess.setAvailable(false);
			aProcess.getProcessBinding().add(bind);
			session.beginTransaction();
			session.save(bind);
			session.update(registredProcess);
			session.update(aProcess);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Process dont exists!");
		} finally {
			session.flush();
			session.close();
		}
		bindUser(login, roleId, processInstanceId, registredProcessId);
	}

	/**
	 * Gets the available role.
	 *
	 * @param processId the process id
	 * @return the available role
	 * @throws Exception the exception
	 */
	public List<String> getAvailableRole(String processId) throws Exception {
		Session session = configureSessionFactory.openSession();
		List<String> roles = new ArrayList<String>();
		try {
			Process aProcess = (Process)session
					.createCriteria(Process.class)
					.add(Restrictions.eq("processId", processId)).uniqueResult();
			for (Role aRole : aProcess.getAllowedRole()) {
				roles.add(aRole.getRoleId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Process "+processId+" dont exists!");
		} finally {
			session.flush();
			session.close();
		}
		return roles;
	}

	/**
	 * Gets the startable process.
	 *
	 * @param userId the user id
	 * @return the startable process
	 */
	public Collection<String> getStartableProcess(String userId) {
		Session session = configureSessionFactory.openSession();
		Set<String> processes = new HashSet<String>();
		User aUser = (User) session.get(User.class, userId);
		@SuppressWarnings("rawtypes")
		List processBind = session
				.createCriteria(RegistredProcess.class)
				.add(Restrictions.eq("ownerUser", aUser)).list();
		
		for (Object objRegProcess : processBind) {
			RegistredProcess regProcess = (RegistredProcess)objRegProcess;
			processes.add(regProcess.getBoundProcesse().getProcessId());
		}
		return processes;
	}

	/**
	 * Gets the process id.
	 *
	 * @param processInstanceId the process instance id
	 * @return the process id
	 */
	public String getProcessId(String processInstanceId) {
		Session session = configureSessionFactory.openSession();
		try {
			ProcessInstance aProcess = (ProcessInstance) session.get(ProcessInstance.class, processInstanceId);
			return aProcess.getOwnProcess().getProcessId();
		} finally {
			session.flush();
			session.close();
		}
	}
}