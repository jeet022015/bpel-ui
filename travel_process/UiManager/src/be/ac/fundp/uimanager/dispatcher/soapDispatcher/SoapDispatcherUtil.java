package be.ac.fundp.uimanager.dispatcher.soapDispatcher;

import java.util.LinkedList;
import java.util.List;

import be.ac.fundp.uimanager.dispatcher.soapDispatcher.impl.DataItemType;
import be.ac.fundp.uimanager.model.CoordinatedData;

public class SoapDispatcherUtil {

	public static List<CoordinatedData> dataItemType2ProvidedData(List<DataItemType> result) {
		List<CoordinatedData> resp = new LinkedList<CoordinatedData>();
		for (DataItemType aData : result) {
			CoordinatedData aProvidedData = new CoordinatedData();
			aProvidedData.setId(aData.getDataItemId());
			aProvidedData.setType(aData.getTypeName());
			aProvidedData.setContent(aData.getData());
			resp.add(aProvidedData);
		}
		return resp;
	}

	public static List<DataItemType> providedData2DataItemType(
			List<CoordinatedData> data) {
		List<DataItemType> resp = new LinkedList<DataItemType>();
		for (CoordinatedData aData : data) {
			DataItemType aProvidedData = new DataItemType();
			aProvidedData.setDataItemId(aData.getId());
			aProvidedData.setTypeName(aData.getType());
			aProvidedData.setData(aData.getContent());
			resp.add(aProvidedData);
		}
		return resp;
	}

}
