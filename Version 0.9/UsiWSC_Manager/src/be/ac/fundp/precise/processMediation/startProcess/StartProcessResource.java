package be.ac.fundp.precise.processMediation.startProcess;

import java.net.URL;

import javax.xml.namespace.QName;

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
	    	QName service = new QName("http://precise.fundp.ac.be/ProcessOperations/", "ProcessOperations"+process);
	    	String hostService = "http://localhost:8080/ode/processes/ProcessOperations"+process;
	    	URL url = new URL(hostService+"?wsdl");
	    	System.out.println("the host is: "+hostService);
	    	ProcessOperations ss = new ProcessOperations(url, service);
	    	ProcessOperationsPortType port = ss.getProcessOperationsSOAP11PortHttp(process);
	        port.start(processInstanceId, process);
//	    	ProcessOperations2Stub stub = new ProcessOperations2Stub(hostService);
//			Start s = new Start();
//			s.setProcessId(processInstanceId);
//			s.setProcessType(process);
//			stub.start(s);
	        return new StringRepresentation("started");
    	} catch (Exception e) {
			e.printStackTrace();
			return new StringRepresentation("error");
		}
    }
}
