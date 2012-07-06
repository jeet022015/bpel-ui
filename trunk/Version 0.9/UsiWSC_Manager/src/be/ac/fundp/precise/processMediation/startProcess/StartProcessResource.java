package be.ac.fundp.precise.processMediation.startProcess;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.dataManagment.DataManagerFactory;
import be.ac.fundp.precise.dataManagment.hibernate.NewDataManagerHibernate;
import be.ac.fundp.precise.processMediation.startProcess.webService.ProcessOperations;
import be.ac.fundp.precise.processMediation.startProcess.webService.ProcessOperationsPortType;

public class StartProcessResource extends ServerResource {
	/** The AuiDeploymentManager singleton. */
	protected NewDataManagerHibernate manager = DataManagerFactory.hibernateDataManager();

    /**
     * Subscribe a user.
     *
     * @return the description of the subscription
     * @throws InterruptedException 
     */
    @Get
    public Representation startProcess() throws InterruptedException {
    	try {
	    	String login = (String) getRequestAttributes().get("login");
	    	String process = (String) getRequestAttributes().get("process");
	    	String processInstanceId;
				processInstanceId = manager.createProcessInstance(process);
	    	manager.bindStartingUser(login, processInstanceId);
	    	ProcessOperations ss = new ProcessOperations();
	    	ProcessOperationsPortType port = ss.getProcessOperationsSOAP11PortHttp();
	        port.start(processInstanceId, process);
	        return new StringRepresentation("started");
    	} catch (Exception e) {
			e.printStackTrace();
			return new StringRepresentation("error");
		}
    }
}
