package be.ac.fundp.uimanager.dispatcher.restDispatcher;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import be.ac.fundp.uimanager.model.ProvidedData;

public class RestDispatcherUtil {

	public static final String DATA_TAG_JSON = "data";
	public static final String ID_TAG_JSON = "id";
	public static final String TYPE_TAG_JSON = "type";
	public static final String CONTENT_TAG_JSON = "content";
	
	public static JSONArray coordinatedData2JSON(List<ProvidedData> data) 
			throws JSONException {
		JSONArray arrayReturn = new JSONArray();
		if (data != null)
			for (ProvidedData providedData : data) {
				JSONObject aUiDataType = new JSONObject();
				aUiDataType.put(ID_TAG_JSON, providedData.getId());
				System.out.println("providedData Id: "+providedData.getId());
				aUiDataType.put(TYPE_TAG_JSON, providedData.getType());
				aUiDataType.put(CONTENT_TAG_JSON, providedData.getData());
				arrayReturn.put(aUiDataType);
			}
		return arrayReturn;
	}

	public static List<ProvidedData> JSON2CoordinatedData(JSONObject result) throws JSONException {
		List<ProvidedData> resp = new LinkedList<ProvidedData>();
		if (result != null){
			JSONArray data = result.getJSONArray(DATA_TAG_JSON);
			for (int i = 0; i < data.length(); i++) {
				JSONObject aData = data.getJSONObject(i);
				ProvidedData aProvidedData = new ProvidedData();
				aProvidedData.setId(aData.getString(ID_TAG_JSON));
				aProvidedData.setType(aData.getString(TYPE_TAG_JSON));
				aProvidedData.setData(aData.getString(CONTENT_TAG_JSON));
				resp.add(aProvidedData);
			}
		}
		return resp;
	}

}
