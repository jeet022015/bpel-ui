package be.ac.fundp;

import org.hibernate.Session;

import be.ac.fundp.uimanager.UiManagerLogic;
import be.ac.fundp.uimanager.dao.Process;
import be.ac.fundp.uimanager.dao.ProcessBind;
import be.ac.fundp.uimanager.dao.Role;
import be.ac.fundp.uimanager.dao.ProcessBind.ProcessBindIdClass;
import be.ac.fundp.uimanager.dispatcher.Dispatcher;

public class DBTest3 {
	public static void main(String[] args) {
		UiManagerLogic logic = UiManagerLogic.getInstance();
		Dispatcher d = null;
		//Dispatcher d = logic.getDispatcher("employee", "process1");
		System.out.println("Dispatcher="+d);
		
		Session session = logic.configureSessionFactory.openSession();
		
		session.beginTransaction();
		Process p = (Process)session.get(Process.class, "process1");
		Role role = (Role)session.get(Role.class, "employee");
		ProcessBindIdClass idClass = new ProcessBindIdClass();
		idClass.setRole(role);
		idClass.setProcess(p);
		ProcessBind processBind = (ProcessBind) session.get(ProcessBind.class, idClass);
		System.out.println("other process bind="+processBind);
		session.getTransaction().commit();
		session.close();
	}
}
