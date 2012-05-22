
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package be.ac.fundp.precise.processDeployment.webService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import be.ac.fundp.precise.processDeployment.auiDeployment.AuiDeploymentManager;

/**
 * This class was generated by Apache CXF 2.5.0
 * 2012-05-08T14:36:31.705+02:00
 * Generated source version: 2.5.0
 * 
 */

@javax.jws.WebService(
                      serviceName = "ProcessDeployerService",
                      portName = "ProcessDeployer",
                      targetNamespace = "http://precise.funpd.ac.be/AuiDeployer",
                      wsdlLocation = "http://localhost:8050/UsiWSC_Manager/services/ProcessDeployer?wsdl",
                      endpointInterface = "be.ac.fundp.precise.processDeployment.webService.ProcessDeployer")
                      
public class ProcessDeployerImpl implements ProcessDeployer {

    private static final Logger LOG = Logger.getLogger(ProcessDeployerImpl.class.getName());
    protected AuiDeploymentManager auiDeployer = AuiDeploymentManager.getInstance();

    /* (non-Javadoc)
     * @see be.ac.fundp.precise.processDeployment.webService.ProcessDeployer#deployAui(byte[]  file ,)java.util.List<be.ac.fundp.precise.processDeployment.webService.AUIDescripton>  description ,)java.lang.String  processName )*
     */
    public java.lang.String deployAui(byte[] file,java.util.List<be.ac.fundp.precise.processDeployment.webService.AUIDescripton> description,java.lang.String processName) { 
    	LOG.info("Executing operation deployAui");
        System.out.println(file);
        System.out.println(description);
        System.out.println(processName);
        try {
        	Map<String, String> auiDesc = parse (description);
        	Map<String, Map<String, String> > auiDesc2 = parse2 (description);
        	auiDeployer.deploy(processName, auiDesc, file, auiDesc2);
            java.lang.String _return = "_return1654334406";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see be.ac.fundp.precise.processDeployment.webService.ProcessDeployer#deployProcess(byte[]  auiZip ,)byte[]  processZip ,)java.lang.String  processId ,)java.util.List<be.ac.fundp.precise.processDeployment.webService.AUIDescripton>  uiDescription )*
     */
    public java.lang.String deployProcess(byte[] auiZip,byte[] processZip,java.lang.String processId,java.util.List<be.ac.fundp.precise.processDeployment.webService.AUIDescripton> uiDescription) { 
        LOG.info("Executing operation deployProcess");
        System.out.println(auiZip);
        System.out.println(processZip);
        System.out.println(processId);
        System.out.println(uiDescription);
        try {
            java.lang.String _return = "_return-1616670046";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    
    private Map<String, String> parse(List<AUIDescripton> descriptions) {
		Map<String, String> returnList = new HashMap<String, String>();
		for (AUIDescripton aDescription : descriptions) {
			returnList.put(aDescription.getAuiEntry(), aDescription.getRole());
		}
		return returnList;
	}
    
    private Map<String, Map<String, String>> parse2(
			List<AUIDescripton> description) {
    	Map<String, Map<String, String>> returnList = new HashMap<String, Map<String, String>>();
		for (AUIDescripton aDescription : description) {
			Map<String, String> uiMapping = new HashMap<String, String>();
			for (UiMappingType uiMappingInner : aDescription.getUiMapping()) {
				uiMapping.put(uiMappingInner.getActivityId(), uiMappingInner.getIuId());
			}
			returnList.put(aDescription.getRole(), uiMapping);
		}
		return returnList;
	}
}
