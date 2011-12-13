package be.ac.fundp.uimanager.client.rest;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import be.ac.fundp.uimanager.provider.UiDataType;

// TODO: Auto-generated Javadoc
/**
 * The Class UiManagerRestUtil.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class UiManagerRestUtil {

	/**
	 * Parses the json.
	 *
	 * @param result the result
	 * @return the list
	 */
	public static List<UiDataType> parseJSON(JSONObject result) {
		List<UiDataType> resp = new LinkedList<UiDataType>();
		try {
			JSONArray data = result.getJSONArray("providedData");
			for (int i = 0; i < data.length(); i++) {
				JSONObject aData = data.getJSONObject(i);
				UiDataType aUiDataType = new UiDataType();
				aUiDataType.setId(aData.getString("id"));
				aUiDataType.setType(aData.getString("type"));
				aUiDataType.setData(aData.getString("content"));
				resp.add(aUiDataType);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return new LinkedList<UiDataType>();
		}
		return resp;
	}

	/**
	 * Parses the ui data type.
	 *
	 * @param data2 the data2
	 * @return the jSON array
	 */
	public static JSONArray parseUiDataType(List<UiDataType> data2) {
		JSONArray jsonArrayResult =  new JSONArray();
		try {
			for (UiDataType d : data2) {
				JSONObject aUiDataType = new JSONObject();
				aUiDataType.put("id", d.getId());
				aUiDataType.put("type", d.getType());
				aUiDataType.put("content", d.getData());
				jsonArrayResult.put(aUiDataType);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonArrayResult;
	}

	/**
	 * Parses the jso n_ selection.
	 *
	 * @param result the result
	 * @return the list
	 */
	public static List<UiDataType> parseJSON_Selection(JSONObject result) {
		List<UiDataType> resp = new LinkedList<UiDataType>();
		try {
			JSONArray data = result.getJSONArray("providedData");
			for (int i = 0; i < data.length(); i++) {
				JSONObject aData = data.getJSONObject(i);
				UiDataType aUiDataType = new UiDataType();
				aUiDataType.setId(aData.getString("id"));
				aUiDataType.setType(aData.getString("type"));
				aUiDataType.setData(aData.getString("content"));
				resp.add(aUiDataType);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return new LinkedList<UiDataType>();
		}
		return resp;
	}

}
