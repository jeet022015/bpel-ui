package be.ac.fundp.uimanager.client.rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import be.ac.fundp.uimanager.InputOperationResponse;
import be.ac.fundp.uimanager.SelectionOperationResponse;
import be.ac.fundp.uimanager.UiDataType;

public class UiManagerRestUtil {

	public static InputOperationResponse parseJSON(JSONObject result) {
		InputOperationResponse resp = new InputOperationResponse();
		try {
			JSONArray data = result.getJSONArray("providedData");
			for (int i = 0; i < data.length(); i++) {
				JSONObject aData = data.getJSONObject(i);
				UiDataType aUiDataType = new UiDataType();
				aUiDataType.setId(aData.getString("id"));
				aUiDataType.setType(aData.getString("type"));
				aUiDataType.setData(aData.getString("content"));
				resp.addData(aUiDataType);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return new InputOperationResponse();
		}
		return resp;
	}

	public static JSONArray parseUiDataType(UiDataType[] data2) {
		JSONArray jsonArrayResult =  new JSONArray();
		try {
			for (int i = 0; i < data2.length; i++) {
				UiDataType d = data2[i];
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

	public static SelectionOperationResponse parseJSON_Selection(
			JSONObject result) {
		SelectionOperationResponse resp = new SelectionOperationResponse();
		try {
			JSONArray data = result.getJSONArray("providedData");
			for (int i = 0; i < data.length(); i++) {
				JSONObject aData = data.getJSONObject(i);
				UiDataType aUiDataType = new UiDataType();
				aUiDataType.setId(aData.getString("id"));
				aUiDataType.setType(aData.getString("type"));
				aUiDataType.setData(aData.getString("content"));
				resp.add_return(aUiDataType);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return new SelectionOperationResponse();
		}
		return resp;
	}

}
