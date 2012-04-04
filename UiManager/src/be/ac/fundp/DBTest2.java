package be.ac.fundp;

import org.hibernate.Session;

import be.ac.fundp.uimanager.UiManagerLogic;
import be.ac.fundp.uimanager.dao.Process;
import be.ac.fundp.uimanager.dao.ProcessBind;
import be.ac.fundp.uimanager.dao.ProcessBind.ProcessBindIdClass;
import be.ac.fundp.uimanager.dao.Role;

public class DBTest2 {
	public static void main(String[] args) {
		UiManagerLogic logic = UiManagerLogic.getInstance();
		Session session = logic.configureSessionFactory.openSession();
		
		session.beginTransaction();
		Process p = (Process)session.get(Process.class, "processId");
		System.out.println("Process="+p);
		//System.out.println("Bind="+p.getProcessBind());
		
		ProcessBindIdClass idClass = new ProcessBindIdClass();
		Role roleObj = (Role)session.get(Role.class, "employee");
		Process process = (Process)session.get(Process.class, "processId");
		idClass.setRole(roleObj);
		idClass.setProcess(process);
		ProcessBind processBind = (ProcessBind) session.get(ProcessBind.class, idClass);
		System.out.println("other process bind="+processBind);
		session.getTransaction().commit();
		session.close();
		//logic.subscribe("neto", "neto", "employee", "10.0.0.2");
	}
}
