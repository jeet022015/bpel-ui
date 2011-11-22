package be.ac.fundp.precise.uibpel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import be.ac.fundp.precise.uibpel.common.SubmittedContent;

public class UiJsonUtil {

	public static SubmittedContent[] collectData(JSONArray data) throws JSONException {
		if (data == null || data.length() == 0)
			return null;
		SubmittedContent[] result = new SubmittedContent[data.length()];
		
		for (int i = 0; i < data.length(); i++) {
			JSONObject aData = data.getJSONObject(i);
			result[i] = new SubmittedContent();
			result[i].setId(aData.getString("id"));
			result[i].setType(aData.getString("type"));
			result[i].setData(aData.get("content"));
		}
		return result;
	}

}
