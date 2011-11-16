package be.ac.fundp.uimanager.client.soap;

import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

import be.ac.fundp.uimanager.InputOperationResponse;
import be.ac.fundp.uimanager.SelectionOperationResponse;
import be.ac.fundp.uimanager.UiDataType;
import be.ac.fundp.uimanager.client.Dispatcher;
import be.ac.fundp.uimanager.client.soap.UIClientStub.DataItemType;
import be.ac.fundp.uimanager.client.soap.UIClientStub.RequireAssyncInteraction;
import be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteraction;
import be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteractionResponse;

public class SOAPDispatcher implements Dispatcher{

	@Override
	public InputOperationResponse requireInputInteracion(String processId,
			String userInteracId, String role) {
		InputOperationResponse response = new InputOperationResponse();
		try {
			UIClientStub clientWS =  new UIClientStub();
			
			ServiceClient c = clientWS._getServiceClient();
			Options options = c.getOptions();
			int timeOutInMilliSeconds = 3600000;
			options.setProperty(HTTPConstants.SO_TIMEOUT, new Integer(timeOutInMilliSeconds ));
			options.setProperty(HTTPConstants.CONNECTION_TIMEOUT, new Integer(timeOutInMilliSeconds));
			
			RequireSyncInteraction req = new RequireSyncInteraction();
			req.setCuiId(userInteracId);
			req.setRole(role);
			RequireSyncInteractionResponse clientRespo = clientWS.requireSyncInteraction(req);
			if (clientRespo != null && clientRespo.getOutData() != null){
				DataItemType[] clientItens = clientRespo.getOutData();
				for (int i = 0; i < clientItens.length; i++) {
					DataItemType aClientItem = clientItens[i];
					UiDataType aUiDataType = new UiDataType();
					aUiDataType.setId(aClientItem.getDataItemId());
					aUiDataType.setType(aClientItem.getTypeName());
					aUiDataType.setData(aClientItem.getData());
					response.addData(aUiDataType);
				}
			}
		} catch (Exception e) {
			response.setData(new UiDataType[0]);
		}
		return response;
	}

	@Override
	public void requireOutputInteracion(String processid, String userInteracId,
			UiDataType[] data, String role) {
		try {
			UIClientStub clientWS =  new UIClientStub();
			RequireAssyncInteraction req = new RequireAssyncInteraction();
			req.setCuiId(userInteracId);
			req.setRole(role);
			DataItemType[] param = new DataItemType[0];
			if (data != null && data.length > 0){
				param = new DataItemType[data.length];
				for (int i = 0; i < data.length; i++) {
					param[i] = new DataItemType();
					param[i].setData(data[i].getData());
					param[i].setDataItemId(data[i].getId());
					param[i].setTypeName(data[i].getType());
				}
			}
			req.setInputData(param);
			clientWS.requireAssyncInteraction(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public SelectionOperationResponse requireSelectionInteracion(
			String processId, String userInteracId, UiDataType[] data, String role) {
		SelectionOperationResponse response = new SelectionOperationResponse();
		try {
			UIClientStub clientWS =  new UIClientStub();
			RequireSyncInteraction req = new RequireSyncInteraction();
			req.setCuiId(userInteracId);
			req.setRole(role);
			
			ServiceClient c = clientWS._getServiceClient();
			Options options = c.getOptions();
			int timeOutInMilliSeconds = 3600000;
			options.setProperty(HTTPConstants.SO_TIMEOUT, new Integer(timeOutInMilliSeconds ));
			options.setProperty(HTTPConstants.CONNECTION_TIMEOUT, new Integer(timeOutInMilliSeconds));
			
			DataItemType[] param = new DataItemType[0];
			if (data != null && data.length > 0){
				param = new DataItemType[data.length];
				for (int i = 0; i < data.length; i++) {
					param[i] = new DataItemType();
					param[i].setData(data[i].getData());
					param[i].setDataItemId(data[i].getId());
					param[i].setTypeName(data[i].getType());
				}
			}
			req.setInputData(param);
			RequireSyncInteractionResponse clientRespo = clientWS.requireSyncInteraction(req);
			if (clientRespo != null && clientRespo.getOutData() != null){
				DataItemType[] clientItens = clientRespo.getOutData();
				for (int i = 0; i < clientItens.length; i++) {
					DataItemType aClientItem = clientItens[i];
					UiDataType aUiDataType = new UiDataType();
					aUiDataType.setId(aClientItem.getDataItemId());
					aUiDataType.setType(aClientItem.getTypeName());
					aUiDataType.setData(aClientItem.getData());
					response.add_return(aUiDataType);
				}
			}
		} catch (Exception e) {
			response.set_return(new UiDataType[0]);
		}
		return response;
	}

}
