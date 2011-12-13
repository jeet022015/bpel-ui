package be.ac.fundp.uimanager;

import java.util.LinkedList;
import java.util.List;

import be.ac.fundp.uimanager.client.soap.implementation.DataItemType;
import be.ac.fundp.uimanager.provider.UiDataType;

// TODO: Auto-generated Javadoc
/**
 * The Class UiManagerUtil.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class UiManagerUtil {
	
	/** The Constant PROCESS_HEAD. */
	private static final String PROCESS_HEAD = "Order-";
	
	/** The process count. */
	private static int processCount = 0;

	/**
	 * New tail process.
	 *
	 * @return the int
	 */
	protected static int newTailProcess() {
		return processCount++;
	}
	
	/**
	 * Generate id.
	 *
	 * @return the string
	 */
	public static String generateId() {
		return PROCESS_HEAD+newTailProcess();
	}

	/**
	 * Parses the to ui data type.
	 *
	 * @param g the g
	 * @return the list
	 */
	public static List<UiDataType> parseToUiDataType(List<DataItemType> g) {
		List<UiDataType> listReturn = new LinkedList<UiDataType>();
		for (DataItemType item : g) {
			UiDataType aUiDataType = new UiDataType();
			aUiDataType.setId(item.getDataItemId());
			aUiDataType.setType(item.getTypeName());
			aUiDataType.setData(item.getData());
			listReturn.add(aUiDataType);
		}
		return listReturn;
	}

	/**
	 * Parses the to data item type.
	 *
	 * @param data the data
	 * @return the list
	 */
	public static List<DataItemType> parseToDataItemType(List<UiDataType> data) {
		List<DataItemType> listReturn = new LinkedList<DataItemType>();
		for (UiDataType item : data) {
			DataItemType aUiDataType = new DataItemType();
			aUiDataType.setDataItemId(item.getId());
			aUiDataType.setTypeName(item.getType());
			aUiDataType.setData(item.getData());
			listReturn.add(aUiDataType);
		}
		return listReturn;
	}

}
