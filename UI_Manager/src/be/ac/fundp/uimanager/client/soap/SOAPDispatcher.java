package be.ac.fundp.uimanager.client.soap;

import java.util.LinkedList;
import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import be.ac.fundp.uimanager.UiManagerUtil;
import be.ac.fundp.uimanager.client.Dispatcher;
import be.ac.fundp.uimanager.client.soap.implementation.DataItemType;
import be.ac.fundp.uimanager.client.soap.implementation.UIClient;
import be.ac.fundp.uimanager.client.soap.implementation.UIClient_Service;
import be.ac.fundp.uimanager.provider.UiDataType;

// TODO: Auto-generated Javadoc
/**
 * The Class SOAPDispatcher.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class SOAPDispatcher implements Dispatcher{
	
	/** The ui client. */
	protected UIClient uiClient;
	
	/**
	 * Instantiates a new sOAP dispatcher.
	 */
	public SOAPDispatcher(){

        UIClient_Service ss = new UIClient_Service();
        uiClient = ss.getUIClientSOAP();
        Client cl = ClientProxy.getClient(uiClient);
        HTTPConduit http = (HTTPConduit) cl.getConduit();

        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(1800000);
        httpClientPolicy.setReceiveTimeout(1800000);
        http.setClient(httpClientPolicy);
	}
	
	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.client.Dispatcher#requireInputInteracion(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<UiDataType> requireInputInteracion(String processId,
			String userInteracId, String role) {
		List<DataItemType> emptyValue = new LinkedList<DataItemType>();
		List<DataItemType> g = uiClient.requireSyncInteraction(userInteracId, emptyValue, role, processId);
		List<UiDataType> listReturn = UiManagerUtil.parseToUiDataType(g);
		return listReturn;
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.client.Dispatcher#requireOutputInteracion(java.lang.String, java.lang.String, java.util.List, java.lang.String)
	 */
	@Override
	public void requireOutputInteracion(String processid, String userInteracId,
			List<UiDataType> data, String role) {
		uiClient.requireAssyncInteraction(userInteracId, UiManagerUtil.parseToDataItemType(data), role, processid);
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.uimanager.client.Dispatcher#requireSelectionInteracion(java.lang.String, java.lang.String, java.util.List, java.lang.String)
	 */
	@Override
	public List<UiDataType> requireSelectionInteracion(String processId,
			String userInteracId, List<UiDataType> data, String role) {
		List<DataItemType> g = uiClient.requireSyncInteraction(userInteracId, UiManagerUtil.parseToDataItemType(data), role, processId);
		List<UiDataType> listReturn = UiManagerUtil.parseToUiDataType(g);
		return listReturn;
	}

}
