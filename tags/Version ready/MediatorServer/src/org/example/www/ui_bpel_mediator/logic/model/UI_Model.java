package org.example.www.ui_bpel_mediator.logic.model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.io.IOUtils;
import org.example.www.ui_bpel_mediator.logic.MediatorConstaints;
import org.example.www.ui_bpel_mediator.logic.model.elements.BooleanDataItem;
import org.example.www.ui_bpel_mediator.logic.model.elements.DataItem;
import org.example.www.ui_bpel_mediator.logic.model.elements.DateDataItem;
import org.example.www.ui_bpel_mediator.logic.model.elements.IntegerDataItem;
import org.example.www.ui_bpel_mediator.logic.model.elements.StringDataItem;
import org.example.www.ui_bpel_mediator.logic.model.elements.UI_Component;
import org.example.www.ui_bpel_mediator.logic.model.elements.UI_Representation;

public class UI_Model {
	
	private static UI_Model self;
	
	protected UI_Representation ui;
	
	protected UI_Model (){
		ui = new UI_Representation();
		
	}
	
	public static UI_Model getInstance(){
		if (self == null)
			self = new UI_Model();
		return self;
	}
	
	public void load() throws IOException{
			InputStream is = new BufferedInputStream( new FileInputStream ( MediatorConstaints.confPath));
					//TODO Change the location
					//"/Users/Neto/Documents/workspaceWebservice4/json_Project/data/mediator.conf"));

			String s = IOUtils.toString(is);
			JSONObject json = (JSONObject) JSONSerializer.toJSON(s);
			JSONArray jarray = json.getJSONArray("dataInput");
			for (int i = 0; i < jarray.size(); i++) {
				JSONObject jData = (JSONObject) jarray.get(i);
				int compID = (Integer) jData.get("ComponentID");
				UI_Component innerComp = ui.getComponent(compID);
				innerComp.addRole((String) jData.get("role"));
				String uiID = (String) jData.get("UIid");
				Set<DataItem> inputData = new HashSet<DataItem>();
				JSONObject jarrayData = jData.getJSONObject("data");
				if(jarrayData.containsKey("StringType")){
					JSONArray jarrayDataStr = jarrayData.getJSONArray("StringType");
					for (int j = 0; j < jarrayDataStr.size(); j++) {
						DataItem strItem = new StringDataItem((String)jarrayDataStr.get(j));
						inputData.add(strItem);
					}
				}
				if(jarrayData.containsKey("IntType")){
					JSONArray jarrayDataStr = jarrayData.getJSONArray("IntType");
					for (int j = 0; j < jarrayDataStr.size(); j++) {
						DataItem strItem = new IntegerDataItem((String)jarrayDataStr.get(j));
						inputData.add(strItem);
					}
				}
				if(jarrayData.containsKey("DataType")){
					JSONArray jarrayDataStr = jarrayData.getJSONArray("DataType");
					for (int j = 0; j < jarrayDataStr.size(); j++) {
						DataItem strItem = new DateDataItem((String)jarrayDataStr.get(j));
						inputData.add(strItem);
					}
				}
				if(jarrayData.containsKey("BooleanType")){
					JSONArray jarrayDataStr = jarrayData.getJSONArray("BooleanType");
					for (int j = 0; j < jarrayDataStr.size(); j++) {
						DataItem strItem = new BooleanDataItem((String)jarrayDataStr.get(j));
						inputData.add(strItem);
					}
				}
				innerComp.addDataInput(uiID, inputData);
			}
	}

	public UI_Component getComponent(String id) {
		return ui.getMyComponent(id);
	}

}
