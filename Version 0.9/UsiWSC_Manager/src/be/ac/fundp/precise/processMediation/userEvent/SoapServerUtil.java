package be.ac.fundp.precise.processMediation.userEvent;

import java.util.LinkedList;
import java.util.List;

import be.ac.fundp.precise.dataManagment.CoordinatedData;
import be.ac.fundp.precise.processMediation.userEvent.service.UiDataType;

/**
 * The Class SoapServerUtil convert the data provided
 * to the Web service (UiDataType) to the data class used on the Usi
 * Manager framework (CoordinatedData). We proposed this class in order to be
 * independent of any specific Web service.
 */
public class SoapServerUtil {


	/**
	 * Convert a list of CoordinatedData to a list of UiDataType.
	 *
	 * @param webServiceData the list of CoordinatedData.
	 * @return the list of UiDataType. The data type used by the
	 * Usi Manager framework.
	 */
	public static List<UiDataType> providedData2UiDataType(
			List<CoordinatedData> webServiceData) {
		List<UiDataType> dataValue = new LinkedList<UiDataType>();
		if (webServiceData != null)
			for (CoordinatedData pData : webServiceData) {
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

	/**
	 * Convert a list of UiDataType to a list of CoordinatedData.
	 *
	 * @param commonData the list of UiDataType to be converted
	 * @return the lis the list of CoordinatedData. The data type used by 
	 * the Web Service.
	 */
	public static List<CoordinatedData> uiDataType2ProvidedData(
			List<UiDataType> commonData) {
		List<CoordinatedData> dataValue = new LinkedList<CoordinatedData>();
		if (commonData != null)
			for (UiDataType pData : commonData) {
				CoordinatedData dataValueVal1 = new CoordinatedData();
				dataValueVal1.setId(pData.getId());
				dataValueVal1.setType(pData.getType());
				dataValueVal1.setContent(pData.getData());
				dataValue.add(dataValueVal1);
			}
		return dataValue;
	}
}
