package be.ac.fundp.precise.userManagment.restService;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.dataManagment.DataManagerFactory;
import be.ac.fundp.precise.dataManagment.hibernate.NewDataManagerHibernate;

public class RegistryProcessResource extends ServerResource {

	protected NewDataManagerHibernate uiManager = DataManagerFactory.hibernateDataManager();

    @Get
    public Representation getRole() {
    	String processId = (String) getRequestAttributes().get("process");
    	String login = (String) getRequestAttributes().get("login");
    	String roleId = (String) getRequestAttributes().get("role");
    	try {
			uiManager.registryUserInProcess(login, roleId, processId);
			return new StringRepresentation("Ok");
		} catch (Exception e) {
			e.printStackTrace();
			return new StringRepresentation("Fail");
		}
    }
}