package be.ac.fundp;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;

import be.ac.fundp.uimanager.UiManagerLogic;
import be.ac.fundp.uimanager.dao.Process;
import be.ac.fundp.uimanager.dao.ProcessBind;
import be.ac.fundp.uimanager.dao.Role;
import be.ac.fundp.uimanager.dao.User;
import be.ac.fundp.uimanager.dao.ProcessBind.ProcessBindIdClass;

public class DBTest {
	public static void main(String[] args) {
		UiManagerLogic logic = UiManagerLogic.getInstance();
		Role roleObj = new Role();
		roleObj.setRoleId("employee");
		Session session = logic.configureSessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(roleObj);
		session.getTransaction().commit();
		//session.save(roleObj);
		
		Process process = new Process();
		process.setProcessId("processId2");
		process.setFinished(false);
		
		session.beginTransaction();
		session.saveOrUpdate(process);
		session.getTransaction().commit();
		
		ProcessBindIdClass idClass = new ProcessBindIdClass();
		idClass.setRole(roleObj);
		idClass.setProcess(process);
		
		ProcessBind processBind = new ProcessBind();
		processBind.setId(idClass);
		Query query = session.createQuery("from USERS");

		User user = null;
		
	    Iterator<?> i1 = query.list().iterator();
	    if (i1.hasNext())
	    	user = (User)i1.next();
	    
	    processBind.setUser(user);
	    
	    process.getProcessBind().add(processBind);
	    
		session.beginTransaction();
		session.saveOrUpdate(processBind);
		session.getTransaction().commit();
		session.close();
		//logic.subscribe("neto", "neto", "employee", "10.0.0.2");
	}
}
