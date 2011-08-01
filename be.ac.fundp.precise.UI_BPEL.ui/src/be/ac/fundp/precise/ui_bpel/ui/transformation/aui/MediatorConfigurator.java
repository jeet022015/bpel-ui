package be.ac.fundp.precise.ui_bpel.ui.transformation.aui;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.usixml.aui.auiPackage.AbstractCompoundIU;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

public class MediatorConfigurator {
	
	//private JSONArray json;
	private JSONObject json;
	private PrintWriter out;
	private Set<HashMap<String, Object>> dataInput;
	private Set<HashMap<String, Object>> dataOutput;
	private Set<HashMap<String, Object>> dataSelection;
	
	public MediatorConfigurator (OutputStream outstream){
		out = new PrintWriter(outstream, true);
		//json = new JSONArray();
		json = new JSONObject();
		dataInput = new HashSet<HashMap<String, Object>>();
		dataOutput = new HashSet<HashMap<String, Object>>();
		dataSelection = new HashSet<HashMap<String, Object>>();
	}
	
	public void createDataInputConf(AbstractCompoundIU comp, DataInputUI inputActivity){
		HashMap<String, Object> dataInputMap = new HashMap<String, Object>();
		dataInputMap.put("UIid", inputActivity.getId());
		dataInputMap.put("ComponentID", comp.getId());
		dataInputMap.put("role", "my role");
		Map<String, Set<String>> dataItemMap = new HashMap<String, Set<String>>();
		for (DataItem dataItem : inputActivity.getData()) {
			Set<String> myData;
			if (dataItemMap.containsKey(dataItem.getType().getName())){
				myData = dataItemMap.get(dataItem.getType().getName());
			}else {
				myData = new HashSet<String>();
			}
			myData.add(dataItem.getDescription());
			dataItemMap.put(dataItem.getType().getName(), myData);
		}
		dataInputMap.put("data", dataItemMap);
		//dataInputMap.put("type", "dataInput");
		dataInput.add(dataInputMap);
		//json.add(dataInputMap);
	}
	
	public void finalize(){
		json.put("dataInput", dataInput);
		json.put("dataOutput", dataOutput);
		json.put("dataSelection", dataSelection);
		out.println(json);
		out.close();
	}

	public void createDataOutputConf(AbstractCompoundIU comp,
			DataOutputUI activity) {
		HashMap<String, Object> dataInputMap = new HashMap<String, Object>();
		dataInputMap.put("UIid", activity.getId());
		dataInputMap.put("ComponentID", comp.getId());
		dataInputMap.put("role", "my role");
		Map<String, String> dataItemMap = new HashMap<String, String>();
		for (DataItem dataItem : activity.getData()) {
			dataItemMap.put(dataItem.getType().getName(), dataItem.getDescription());
		}
		dataInputMap.put("data", dataItemMap);
		//dataInputMap.put("type", "dataOutput");
		dataOutput.add(dataInputMap);
		//json.add(dataInputMap);
	}

	public void createDataSelectionConf(AbstractCompoundIU comp,
			DataSelectionUI activity) {
		HashMap<String, Object> dataInputMap = new HashMap<String, Object>();
		dataInputMap.put("UIid", activity.getId());
		dataInputMap.put("ComponentID", comp.getId());
		dataInputMap.put("role", "my role");
		Map<String, String> dataItemMap = new HashMap<String, String>();
		for (DataItem dataItem : activity.getData()) {
			dataItemMap.put(dataItem.getType().getName(), dataItem.getDescription());
		}
		dataInputMap.put("selectable", dataItemMap);
		dataInputMap.put("type", "dataSelection");
		dataInputMap.put("min", activity.getMinCardinality());
		dataInputMap.put("max", activity.getMaxCardinality());
		//dataInputMap.put("type", "dataSelection");
		//json.add(dataInputMap);
		dataSelection.add(dataInputMap);
	}
}
