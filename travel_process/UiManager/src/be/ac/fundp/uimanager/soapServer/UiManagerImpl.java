
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package be.ac.fundp.uimanager.soapServer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.ws.Holder;

import be.ac.fundp.uimanager.UiManagerLogic;
import be.ac.fundp.uimanager.model.ProvidedData;
import be.ac.fundp.uimanager.soapServer.util.SoapServerUtil;

/**
 * This class was generated by Apache CXF 2.5.0
 * 2012-02-29T14:26:35.464+01:00
 * Generated source version: 2.5.0
 * 
 */

@javax.jws.WebService(
                      serviceName = "UiManager",
                      portName = "UiManagerSOAP",
                      targetNamespace = "http://fundp.ac.be/UiManager/",
                      wsdlLocation = "http://localhost:8090/UiManager/services/UiManagerSOAP?wsdl",
                      endpointInterface = "be.ac.fundp.uimanager.soapServer.UiManager")
                      
public class UiManagerImpl implements UiManager {
	
	protected UiManagerLogic logic = UiManagerLogic.getInstance();

    private static final Logger LOG = Logger.getLogger(UiManagerImpl.class.getName());

    /* (non-Javadoc)
     * @see be.ac.fundp.uimanager.soapServer.UiManager#inputOperation(java.lang.String  userInteracId ,)java.lang.String  role ,)java.lang.String  processId ,)java.util.List<be.ac.fundp.uimanager.soapServer.UiDataType>  data )*
     */
    public void inputOperation(Holder<String> userInteracId, Holder<String> role, Holder<String> processId, Holder<List<UiDataType>> data) { 
        LOG.info("Executing operation inputOperation");
        System.out.println(userInteracId.value);
        System.out.println(role.value);
        System.out.println(processId.value);
        try {
        	List<ProvidedData> reponse = logic.getDispatcher(role.value).requireInputInteracion(processId.value, userInteracId.value, role.value);
        	data.value = SoapServerUtil.providedData2UiDataType(reponse);
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see be.ac.fundp.uimanager.soapServer.UiManager#selectionOperation(java.lang.String  userInteracId ,)java.lang.String  role ,)java.lang.String  processId ,)java.util.List<be.ac.fundp.uimanager.soapServer.UiDataType>  data )*
     */
    public List<UiDataType> selectionOperation(Holder<String> userInteracId, Holder<String> role, Holder<String> processId, List<UiDataType> data) { 
        LOG.info("Executing operation selectionOperation");
        System.out.println(userInteracId.value);
        System.out.println(role.value);
        System.out.println(processId.value);
        System.out.println(data);
        try {
        	List<ProvidedData> reponse = logic.getDispatcher(role.value).requireSelectionInteracion(processId.value, userInteracId.value, SoapServerUtil.uiDataType2ProvidedData(data), role.value);
            return SoapServerUtil.providedData2UiDataType(reponse);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see be.ac.fundp.uimanager.soapServer.UiManager#outputOperation(java.lang.String  userInteracId ,)java.lang.String  role ,)java.lang.String  processid ,)java.util.List<be.ac.fundp.uimanager.soapServer.UiDataType>  data )*
     */
    public void outputOperation(String userInteracId, String role, String processid, List<UiDataType> data) { 
        LOG.info("Executing operation outputOperation");
        System.out.println(userInteracId);
        System.out.println(role);
        System.out.println(processid);
        System.out.println(data);
        try {
        	logic.getDispatcher(role).requireOutputInteracion(processid, userInteracId, SoapServerUtil.uiDataType2ProvidedData(data), role);
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see be.ac.fundp.uimanager.soapServer.UiManager#generateProcessId(*
     */
    public String generateProcessId() { 
        LOG.info("Executing operation generateProcessId");
        try {
            return logic.generateId();
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see be.ac.fundp.uimanager.soapServer.UiManager#pendingActions(java.lang.String  role )*
     */
    public List<PendingInteraction> pendingActions(String role) { 
        LOG.info("Executing operation pendingActions");
        System.out.println(role);
        try {
            List<PendingInteraction> _return = new ArrayList<PendingInteraction>();
            PendingInteraction _returnVal1 = new PendingInteraction();
            _returnVal1.setProcessId("ProcessId1348654265");
            _returnVal1.setCuiId("CuiId-1547563632");
            _return.add(_returnVal1);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see be.ac.fundp.uimanager.soapServer.UiManager#registryRole(java.lang.String  role ,)java.lang.String  host )*
     */
    public void registryRole(String role, String host) { 
        LOG.info("Executing operation registryRole");
        System.out.println(role);
        System.out.println(host);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
