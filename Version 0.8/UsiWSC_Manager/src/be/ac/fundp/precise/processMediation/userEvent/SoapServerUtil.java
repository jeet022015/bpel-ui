package be.ac.fundp.precise.processMediation.userEvent;

import java.util.LinkedList;
import java.util.List;

import be.ac.fundp.precise.dataManagment.CoordinatedData;
import be.ac.fundp.precise.processMediation.userEvent.webService.UiDataType;


public class SoapServerUtil {


	public static List<UiDataType> providedData2UiDataType(
			List<CoordinatedData> reponse) {
		List<UiDataType> dataValue = new LinkedList<UiDataType>();
		if (reponse != null)
			for (CoordinatedData pData : reponse) {
				System.out.println("the data provided");
				System.out.println("pData.getId()="+pData.getId());
				System.out.println("pData.getType()"+pData.getType());
				System.out.println("pData.getData()"+pData.getContent());
				UiDataType dataValueVal1 = new UiDataType();
				dataValueVal1.setId(pData.getId());
				dataValueVal1.setType(pData.getType());
				dataValueVal1.setData(pData.getContent());
				dataValue.add(dataValueVal1);
			}
		return dataValue;
	}

	public static List<CoordinatedData> uiDataType2ProvidedData(
			List<UiDataType> data) {
		List<CoordinatedData> dataValue = new LinkedList<CoordinatedData>();
		if (data != null)
			for (UiDataType pData : data) {
				CoordinatedData dataValueVal1 = new CoordinatedData();
				dataValueVal1.setId(pData.getId());
				dataValueVal1.setType(pData.getType());
				dataValueVal1.setContent(pData.getData());
				dataValue.add(dataValueVal1);
			}
		return dataValue;
	}
}
