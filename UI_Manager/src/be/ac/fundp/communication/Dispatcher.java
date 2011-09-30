package be.ac.fundp.communication;

import java.rmi.RemoteException;

import be.ac.fundp.DataUIType;
import be.ac.fundp.InputOperationResponse;
import be.ac.fundp.SelectionOperationResponse;
import be.ac.fundp.webapp.client.UIClientStub;
import be.ac.fundp.webapp.client.UIClientStub.RequireAssyncInteraction;
import be.ac.fundp.webapp.client.UIClientStub.RequireSyncInteraction;
import be.ac.fundp.webapp.client.UIClientStub.RequireSyncInteractionResponse;
import be.ac.fundp.webapp.client.UIClientStub.UIDataType;

public class Dispatcher {

	protected static Dispatcher self;
	
	private Dispatcher(){
		
	}
	
	public static Dispatcher getInstance() {
		if (self == null)
			self = new Dispatcher();
		return self;
	}

	public void dispatchOutputOp(String id, DataUIType[] data) {
		try {
			UIClientStub clientWS =  new UIClientStub();
			RequireAssyncInteraction req = new RequireAssyncInteraction();
			req.setId(id);
			UIDataType[] param;
			if (data != null){
				param = new UIDataType[data.length];
				for (int i = 0; i < data.length; i++) {
					DataUIType dt = data[i];
					param[i] = new UIDataType();
					param[i].setId(dt.getId());
					param[i].setType(dt.getType());
					param[i].setData(dt.getData());
				}
			} else {
				param = new UIDataType[0];
			}
			req.setInputData(param);
			clientWS.requireAssyncInteraction(req);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public InputOperationResponse dispatchInputOp(String id) {
		InputOperationResponse response = new InputOperationResponse();
		try {
			UIClientStub clientWS =  new UIClientStub();
			RequireSyncInteraction req = new RequireSyncInteraction();
			req.setId(id);
			RequireSyncInteractionResponse clientRespo = clientWS.requireSyncInteraction(req);
			if (clientRespo != null && clientRespo.getOutData() != null){
				UIDataType[] clientItens = clientRespo.getOutData();
				DataUIType[] responseItens = new DataUIType[clientItens.length];
				for (int i = 0; i < clientItens.length; i++) {
					UIDataType aClientItem = clientItens[i];
					responseItens[i] = new DataUIType();
					responseItens[i].setId(aClientItem.getId());
					responseItens[i].setType(aClientItem.getType());
					responseItens[i].setData(aClientItem.getData());
				}
				response.set_return(responseItens);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public SelectionOperationResponse dispatchSelectionOp(String id, DataUIType[] data) {
		SelectionOperationResponse response = new SelectionOperationResponse();
		try {
			UIClientStub clientWS =  new UIClientStub();
			RequireSyncInteraction req = new RequireSyncInteraction();
			req.setId(id);
			UIDataType[] param;
			if (data != null){
				param = new UIDataType[data.length];
				for (int i = 0; i < data.length; i++) {
					DataUIType dt = data[i];
					param[i] = new UIDataType();
					param[i].setId(dt.getId());
					param[i].setType(dt.getType());
					param[i].setData(dt.getData());
					System.out.println("get = "+dt.getData());
				}
			} else {
				param = new UIDataType[0];
			}
			req.setInputData(param);
			RequireSyncInteractionResponse clientRespo = clientWS.requireSyncInteraction(req);
			if (clientRespo != null && clientRespo.getOutData() != null){
				UIDataType[] clientItens = clientRespo.getOutData();
				DataUIType[] responseItens = new DataUIType[clientItens.length];
				for (int i = 0; i < clientItens.length; i++) {
					UIDataType aClientItem = clientItens[i];
					System.out.println("here = "+aClientItem);
					responseItens[i] = new DataUIType();
					responseItens[i].setId(aClientItem.getId());
					responseItens[i].setType(aClientItem.getType());
					responseItens[i].setData(aClientItem.getData());
					System.out.println("data = "+aClientItem.getData().toString());
				}
				System.out.println("begin-set");
				response.set_return(responseItens);
				System.out.println("end-set");
			}
		} catch (Exception e) {
			System.out.println("shhhiiiiittttt");
			e.printStackTrace();
		}
		System.out.println("Ok");
		return response;
	}

}
