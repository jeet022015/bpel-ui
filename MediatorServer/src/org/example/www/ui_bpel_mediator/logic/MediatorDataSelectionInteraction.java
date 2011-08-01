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

public class MediatorDataSelectionInteraction {
	public DataUIType getSelectionData(String id, DataUIType dataUIType) {
		DataUIType data = new DataUIType();
		try {
			InputStream is = new BufferedInputStream( new FileInputStream
				("/Users/Neto/Documents/workspaceWebservice4/MediatorServer/data/dataSelectionConf.json"));
			String s = IOUtils.toString(is);
			JSONObject json = (JSONObject) JSONSerializer.toJSON(s);
			JSONArray jarray = json.getJSONArray("dataSelection");
			for (int i = 0; i < jarray.size(); i++) {
				JSONObject s2 = jarray.getJSONObject(i);
				if (s2.getJSONObject("id").equals(id)) {
					dealWithSelection(data, s2, dataUIType);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	private void dealWithSelection(DataUIType data, JSONObject s2,
			DataUIType dataUIType) {
		JSONObject dataType = s2.getJSONObject("dataType");
		if (dataType.toString() != "stringData"){
			selectString (data, dataUIType, dataType.getJSONArray("Selectable"));
		}else if (dataType.toString() != "booleanData"){
			selectBoolean (data, dataUIType, dataType.getJSONArray("Selectable"));
		}else if (dataType.toString() != "intData"){
			selectInt (data, dataUIType, dataType.getJSONArray("Selectable"));
		}else if (dataType.toString() != "dateData"){
			selectDate (data, dataUIType, dataType.getJSONArray("Selectable"));
		}
	}

	private void selectDate(DataUIType data, DataUIType dataUIType,
			JSONArray jsonArray) {
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject s2 = jsonArray.getJSONObject(i);
			l.add(s2.toString());
		}
		List<String> selected = userSelect(l);
		List<DateUIDataType> myDateDataResp = new ArrayList<DateUIDataType>();
		for (String i: selected) {
			DateUIDataType aData = new DateUIDataType();
			aData.setData(getDateDataFromUser());
			aData.setName(i);
			myDateDataResp.add(aData);
		}
		data.setDateUIData((DateUIDataType[]) myDateDataResp.toArray());
	}

	private List<String> userSelect(List<String> l) {
		// TODO Auto-generated method stub
		return l;
	}

	private void selectInt(DataUIType data, DataUIType dataUIType,
			JSONArray jsonArray) {
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject s2 = jsonArray.getJSONObject(i);
			l.add(s2.toString());
		}
		List<String> selected = userSelect(l);
		List<IntUIDataType> myIntDataResp = new ArrayList<IntUIDataType>();
		for (String i : selected) {
			IntUIDataType aData = new IntUIDataType();
			aData.setData(Integer.parseInt(i));
			aData.setName(i);
			myIntDataResp.add(aData);
		}
		data.setIntUIData((IntUIDataType[]) myIntDataResp.toArray());
	}

	private void selectBoolean(DataUIType data, DataUIType dataUIType,
			JSONArray jsonArray) {
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject s2 = jsonArray.getJSONObject(i);
			l.add(s2.toString());
		}
		List<String> selected = userSelect(l);
		List<BooleanUIDataType> myBooleanDataResp = new ArrayList<BooleanUIDataType>();
		for (String i: selected) {
			BooleanUIDataType aData = new BooleanUIDataType();
			aData.setData(Boolean.parseBoolean(i));
			aData.setName(i);
			myBooleanDataResp.add(aData);
		}
		data.setBooleanUIData((BooleanUIDataType[]) myBooleanDataResp.toArray());
	}

	private void selectString(DataUIType data, DataUIType dataUIType,
			JSONArray jsonArray) {
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject s2 = jsonArray.getJSONObject(i);
			l.add(s2.toString());
		}
		List<String> selected = userSelect(l);
		List<StringUIDataType> myDataResp = new ArrayList<StringUIDataType>();
		for (String item : selected) {
			StringUIDataType aData = new StringUIDataType();
			aData.setData(item);
			aData.setName(item);
			myDataResp.add(aData);
		}
		data.setStringUIData((StringUIDataType[]) myDataResp.toArray());
	}
	
	private Date getDateDataFromUser() {
		Date today = GregorianCalendar.getInstance().getTime();
		return today;
	}
}
