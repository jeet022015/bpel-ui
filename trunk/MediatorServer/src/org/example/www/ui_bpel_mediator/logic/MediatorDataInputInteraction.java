package org.example.www.ui_bpel_mediator.logic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.io.IOUtils;
import org.example.www.ui_bpel_mediator.BooleanUIDataType;
import org.example.www.ui_bpel_mediator.DataUIType;
import org.example.www.ui_bpel_mediator.DateUIDataType;
import org.example.www.ui_bpel_mediator.IntUIDataType;
import org.example.www.ui_bpel_mediator.StringUIDataType;

public class MediatorDataInputInteraction {
	public DataUIType getInputData(String id) {
		DataUIType data = new DataUIType();
		try {
			InputStream is = new BufferedInputStream( new FileInputStream
				("/Users/Neto/Documents/workspaceWebservice4/MediatorServer/data/dataInputConf.json"));
			String s = IOUtils.toString(is);
			JSONObject json = (JSONObject) JSONSerializer.toJSON(s);
			JSONArray jarray = json.getJSONArray("dataInput");
			for (int i = 0; i < jarray.size(); i++) {
				JSONObject s2 = jarray.getJSONObject(i);
				if (s2.getJSONObject("id").equals(id)) {
					dealWithInput(data, s2);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	private void dealWithInput(DataUIType data, JSONObject s2) {
		JSONObject myData = s2.getJSONObject("data");
		JSONArray jarray = myData.getJSONArray("stringData");
		List<StringUIDataType> myDataResp = new ArrayList<StringUIDataType>();
		for (int i = 0; i < jarray.size(); i++) {
			StringUIDataType aData = new StringUIDataType();
			aData.setData(getDataFromUser());
			aData.setName(jarray.getString(i));
			myDataResp.add(aData);
		}
		data.setStringUIData((StringUIDataType[]) myDataResp.toArray());
		jarray = myData.getJSONArray("intData");
		List<IntUIDataType> myIntDataResp = new ArrayList<IntUIDataType>();
		for (int i = 0; i < jarray.size(); i++) {
			IntUIDataType aData = new IntUIDataType();
			aData.setData(getIntDataFromUser());
			aData.setName(jarray.getString(i));
			myIntDataResp.add(aData);
		}
		data.setIntUIData((IntUIDataType[]) myIntDataResp.toArray());
		jarray = myData.getJSONArray("booleanData");
		List<BooleanUIDataType> myBoolDataResp = new ArrayList<BooleanUIDataType>();
		for (int i = 0; i < jarray.size(); i++) {
			BooleanUIDataType aData = new BooleanUIDataType();
			aData.setData(getBoolDataFromUser());
			aData.setName(jarray.getString(i));
			myBoolDataResp.add(aData);
		}
		data.setBooleanUIData((BooleanUIDataType[]) myBoolDataResp.toArray());
		jarray = myData.getJSONArray("dateData");
		List<DateUIDataType> myDateDataResp = new ArrayList<DateUIDataType>();
		for (int i = 0; i < jarray.size(); i++) {
			DateUIDataType aData = new DateUIDataType();
			aData.setData(getDateDataFromUser());
			aData.setName(jarray.getString(i));
			myDateDataResp.add(aData);
		}
		data.setDateUIData((DateUIDataType[]) myDateDataResp.toArray());
	}
	
	private Date getDateDataFromUser() {
		Date today = GregorianCalendar.getInstance().getTime();
		return today;
	}

	private boolean getBoolDataFromUser() {
		return false;
	}

	private int getIntDataFromUser() {
		return 0;
	}

	private String getDataFromUser() {
		return "Stub";
	}

}
