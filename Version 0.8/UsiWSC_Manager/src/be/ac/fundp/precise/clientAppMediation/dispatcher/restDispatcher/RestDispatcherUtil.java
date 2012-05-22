package be.ac.fundp.precise.clientAppMediation.dispatcher.restDispatcher;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import be.ac.fundp.precise.dataManagment.CoordinatedData;

/**
 * This Class has some useful operations to parse the data provided to by rest services
 * and the UI Manager.
 */
public class RestDispatcherUtil {

	/** The Constant DATA_TAG_JSON. */
	public static final String DATA_TAG_JSON = "data";
	
	/** The Constant ID_TAG_JSON. */
	public static final String ID_TAG_JSON = "id";
	
	/** The Constant TYPE_TAG_JSON. */
	public static final String TYPE_TAG_JSON = "type";
	
	/** The Constant CONTENT_TAG_JSON. */
	public static final String CONTENT_TAG_JSON = "content";
	
	/**
	 * This method parses Coordinated Data to JSON.
	 *
	 * @param data the Coordinated Data.
	 * @return the JSONArray corresponding to the Coordinated Data passed 
	 * as parameter.
	 * @throws JSONException The JSONObject was malformed exception.
	 */
	public static JSONArray coordinatedData2JSON(List<CoordinatedData> data) 
			throws JSONException {
		JSONArray arrayReturn = new JSONArray();
		if (data != null)
			for (CoordinatedData providedData : data) {
				JSONObject aUiDataType = new JSONObject();
				aUiDataType.put(ID_TAG_JSON, providedData.getId());
				aUiDataType.put(TYPE_TAG_JSON, providedData.getType());
				aUiDataType.put(CONTENT_TAG_JSON, providedData.getContent());
				arrayReturn.put(aUiDataType);
			}
		return arrayReturn;
	}

	/**
	 * This method parses JSONObjects to Coordinated Data.
	 *
	 * @param jsonData the original JSON data.
	 * @return the Coordinated Data corresponding to the JSON data passed 
	 * as parameter.
	 * @throws JSONException The JSONObject was malformed exception.
	 */
	public static List<CoordinatedData> JSON2CoordinatedData(JSONObject jsonData) throws JSONException {
		List<CoordinatedData> resp = new LinkedList<CoordinatedData>();
		if (jsonData != null){
			JSONArray data = jsonData.getJSONArray(DATA_TAG_JSON);
			for (int i = 0; i < data.length(); i++) {
				JSONObject aData = data.getJSONObject(i);
				CoordinatedData aProvidedData = new CoordinatedData();
				aProvidedData.setId(aData.getString(ID_TAG_JSON));
				aProvidedData.setType(aData.getString(TYPE_TAG_JSON));
				aProvidedData.setContent(aData.getString(CONTENT_TAG_JSON));
				resp.add(aProvidedData);
			}
		}
		return resp;
	}

}
