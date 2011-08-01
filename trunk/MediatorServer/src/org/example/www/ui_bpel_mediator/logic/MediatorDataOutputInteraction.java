package org.example.www.ui_bpel_mediator.logic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.io.IOUtils;
import org.example.www.ui_bpel_mediator.DataUIType;

public class MediatorDataOutputInteraction {
	
	public void sendData(String id, DataUIType dataUIType) {
		try {
			InputStream is = new BufferedInputStream( new FileInputStream
				("/Users/Neto/Documents/workspaceWebservice4/MediatorServer/data/dataOutputConf.json"));
			String s = IOUtils.toString(is);
			JSONObject json = (JSONObject) JSONSerializer.toJSON(s);
			JSONArray jarray = json.getJSONArray("dataSelection");
			for (int i = 0; i < jarray.size(); i++) {
				JSONObject s2 = jarray.getJSONObject(i);
				if (s2.getJSONObject("id").equals(id)) {
					sendData(s2, dataUIType);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendData(JSONObject s2, DataUIType dataUIType) {
		
	}

}
