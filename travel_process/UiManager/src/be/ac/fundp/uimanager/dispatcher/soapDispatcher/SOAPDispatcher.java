package be.ac.fundp.uimanager.dispatcher.soapDispatcher;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import be.ac.fundp.uimanager.dispatcher.Dispatcher;
import be.ac.fundp.uimanager.dispatcher.soapDispatcher.impl.DataItemType;
import be.ac.fundp.uimanager.dispatcher.soapDispatcher.impl.UIClient;
import be.ac.fundp.uimanager.dispatcher.soapDispatcher.impl.UIClient_Service;
import be.ac.fundp.uimanager.model.ProvidedData;

// TODO: Auto-generated Javadoc
/**
 * The Class SOAPDispatcher.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class SOAPDispatcher implements Dispatcher{
	
	public static final String DEFAULT_HOST = "http://localhost:8070/WebBrowserAppClient/services/UI-ClientSOAP?wsdl";
	
	/** The ui client. */
	protected UIClient uiClient;
	
	/**
	 * Instantiates a new sOAP dispatcher.
	 */
	public SOAPDispatcher(String host){

        UIClient_Service ss;
		try {
			ss = new UIClient_Service(new URL(host));
		} catch (MalformedURLException e) {
			ss = new UIClient_Service();
			e.printStackTrace();
		}
        uiClient = ss.getUIClientSOAP();
        Client cl = ClientProxy.getClient(uiClient);
        
        HTTPConduit http = (HTTPConduit) cl.getConduit();

        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(0);
        httpClientPolicy.setReceiveTimeout(0);
        http.setClient(httpClientPolicy);
	}
	
	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.client.Dispatcher#requireInputInteracion(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ProvidedData> requireInputInteracion(String processId,
			String userInteracId, String role) {
		List<DataItemType> emptyValue = Collections.emptyList();
		List<DataItemType> g = uiClient.requireSyncInteraction(userInteracId, emptyValue , role, processId);
		List<ProvidedData> listReturn = SoapDispatcherUtil.dataItemType2ProvidedData(g);
		return listReturn;
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.client.Dispatcher#requireOutputInteracion(java.lang.String, java.lang.String, java.util.List, java.lang.String)
	 */
	@Override
	public void requireOutputInteracion(String processid, String userInteracId,
			List<ProvidedData> data, String role) {
		uiClient.requireAssyncInteraction(userInteracId, SoapDispatcherUtil.providedData2DataItemType(data), role, processid);
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.client.Dispatcher#requireSelectionInteracion(java.lang.String, java.lang.String, java.util.List, java.lang.String)
	 */
	@Override
	public List<ProvidedData> requireSelectionInteracion(String processId,
			String userInteracId, List<ProvidedData> data, String role) {
		List<DataItemType> g = uiClient.requireSyncInteraction(userInteracId, SoapDispatcherUtil.providedData2DataItemType(data), role, processId);
		List<ProvidedData> listReturn = SoapDispatcherUtil.dataItemType2ProvidedData(g);
		return listReturn;
	}

	@Override
	public void releaseAll(String processId) {
		// TODO Auto-generated method stub
		
	}

}
