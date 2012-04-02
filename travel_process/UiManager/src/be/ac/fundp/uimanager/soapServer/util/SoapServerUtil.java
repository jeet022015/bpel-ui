package be.ac.fundp.uimanager.soapServer.util;

import java.util.LinkedList;
import java.util.List;

import be.ac.fundp.uimanager.model.ProvidedData;
import be.ac.fundp.uimanager.soapServer.UiDataType;

public class SoapServerUtil {

	public static List<UiDataType> providedData2UiDataType(
			List<ProvidedData> reponse) {
		List<UiDataType> dataValue = new LinkedList<UiDataType>();
		if (reponse != null)
			for (ProvidedData pData : reponse) {
				System.out.println("the data provided");
				System.out.println("pData.getId()="+pData.getId());
				System.out.println("pData.getType()"+pData.getType());
				System.out.println("pData.getData()"+pData.getData());
				UiDataType dataValueVal1 = new UiDataType();
				dataValueVal1.setId(pData.getId());
				dataValueVal1.setType(pData.getType());
				dataValueVal1.setData(pData.getData());
				dataValue.add(dataValueVal1);
			}
		return dataValue;
	}

	public static List<ProvidedData> uiDataType2ProvidedData(
			List<UiDataType> data) {
		List<ProvidedData> dataValue = new LinkedList<ProvidedData>();
		if (data != null)
			for (UiDataType pData : data) {
				ProvidedData dataValueVal1 = new ProvidedData();
				dataValueVal1.setId(pData.getId());
				dataValueVal1.setType(pData.getType());
				dataValueVal1.setData(pData.getData());
				dataValue.add(dataValueVal1);
			}
		return dataValue;
	}

}
