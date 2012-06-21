package be.ac.fundp.precise.processMediation.startProcess;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import be.ac.fundp.precise.dataManagment.DataManager;
import be.ac.fundp.precise.dataManagment.DataManagerFactory;
import be.ac.fundp.precise.processMediation.startProcess.webService.ProcessOperations;
import be.ac.fundp.precise.processMediation.startProcess.webService.ProcessOperationsPortType;

public class StartingProcessResource extends ServerResource {
	/** The AuiDeploymentManager singleton. */
	protected DataManager manager = DataManagerFactory.hibernateDataManager();

    /**
     * Subscribe a user.
     *
     * @return the description of the subscription
     * @throws InterruptedException 
     */
    @Get
    public String subscribe() throws InterruptedException {
    	String login = (String) getRequestAttributes().get("login");
    	String process = (String) getRequestAttributes().get("process");
    	String processId = DataManager.idGen.genId();
    	manager.bindUserToProcess(login, process, processId);
    	ProcessOperations ss = new ProcessOperations();
    	ProcessOperationsPortType port = ss.getProcessOperationsSOAP11PortHttp();
        port.start(processId, process);
        return "started";
    }
}
