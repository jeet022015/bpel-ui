package be.ac.fundp.uimanager.dispatcher.soapDispatcher;

import java.util.LinkedList;
import java.util.List;

import be.ac.fundp.uimanager.dispatcher.soapDispatcher.impl.DataItemType;
import be.ac.fundp.uimanager.model.ProvidedData;

public class SoapDispatcherUtil {

	public static List<ProvidedData> dataItemType2ProvidedData(List<DataItemType> result) {
		List<ProvidedData> resp = new LinkedList<ProvidedData>();
		for (DataItemType aData : result) {
			ProvidedData aProvidedData = new ProvidedData();
			aProvidedData.setId(aData.getDataItemId());
			aProvidedData.setType(aData.getTypeName());
			aProvidedData.setData(aData.getData());
			resp.add(aProvidedData);
		}
		return resp;
	}

	public static List<DataItemType> providedData2DataItemType(
			List<ProvidedData> data) {
		List<DataItemType> resp = new LinkedList<DataItemType>();
		for (ProvidedData aData : data) {
			DataItemType aProvidedData = new DataItemType();
			aProvidedData.setDataItemId(aData.getId());
			aProvidedData.setTypeName(aData.getType());
			aProvidedData.setData(aData.getData());
			resp.add(aProvidedData);
		}
		return resp;
	}

}
