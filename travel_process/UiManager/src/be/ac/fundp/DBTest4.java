package be.ac.fundp;

import java.io.Serializable;

import org.hibernate.Session;

import be.ac.fundp.uimanager.UiManagerLogic;
import be.ac.fundp.uimanager.dao.Context;
import be.ac.fundp.uimanager.dao.DataItem;
import be.ac.fundp.uimanager.dao.Interaction;
import be.ac.fundp.uimanager.dao.InteractionType;
import be.ac.fundp.uimanager.dao.ItemType;
import be.ac.fundp.uimanager.dao.ProtocolType;
import be.ac.fundp.uimanager.dao.Role;
import be.ac.fundp.uimanager.dao.User;

public class DBTest4 {
	public static void main(String[] args) {
		UiManagerLogic logic = UiManagerLogic.getInstance();
		
		Session session = logic.configureSessionFactory.openSession();
		
		session.beginTransaction();
		Role role = new Role();
		role.setRoleId("employee");
		
		User user = new User();
		user.setUserId("neto");
		user.setPassword("neto");
		user.getRole().add(role);
		
		Context context = new Context();
		context.setIpAddress("10.0.1.2");
		context.setProtocolType(ProtocolType.Rest);
		user.setContext(context);
		
		session.saveOrUpdate(role);
		session.saveOrUpdate(user);
		session.saveOrUpdate(context);
		
		
		Interaction interaction = new Interaction();
		interaction.setInteractionId("ssfqdf");
		interaction.setFinished(false);
		
		session.saveOrUpdate(interaction);
		
		session.getTransaction().commit();
		
		session.beginTransaction();
		interaction = (Interaction) session.get(Interaction.class, interaction.getInteractionRealId());
		System.out.println("interaction="+interaction);
		DataItem item = new DataItem();
		item.setItemId("qsdfsqdfqsdf");
		item.setType(InteractionType.Input);
		item.setItemType(ItemType.text);
		item.setData((Serializable) "qsdqsd");
		interaction.getAvailableData().add(item);
		session.saveOrUpdate(item);
		
		DataItem item2 = new DataItem();
		item2.setItemId("qsdfsqdfqsdf");
		item2.setType(InteractionType.Input);
		item2.setItemType(ItemType.text);
		item2.setData((Serializable) "qsdqsd");
		interaction.getProvidedData().add(item2);
		session.saveOrUpdate(item2);
		
		session.saveOrUpdate(interaction);
		
		session.getTransaction().commit();
		
		session.beginTransaction();
		item = (DataItem) session.get(DataItem.class, item.getRealDataItemId());
		System.out.println("item="+item);
		System.out.println("content="+item.getData());
		session.getTransaction().commit();
		session.close();
		
		System.out.println("finished");
		
		//logic.requireInputInteracion("employee", "process11", "1");
	}
}
