package be.ac.fundp.precise.ui_bpel.ui.transformation.aui;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

import org.usixml.aui.auiPackage.AbstractCompoundIU;

import be.edu.fundp.precise.uibpel.model.DataInputUI;
import be.edu.fundp.precise.uibpel.model.DataItem;
import be.edu.fundp.precise.uibpel.model.DataOutputUI;
import be.edu.fundp.precise.uibpel.model.DataSelectionUI;

public class MediatorConfigurator {
	
	private JSONArray json;
	private PrintWriter out;
	
	public MediatorConfigurator (OutputStream outstream){
		out = new PrintWriter(outstream, true);
		json = new JSONArray();
	}
	
	public void createDataInputConf(AbstractCompoundIU comp, DataInputUI inputActivity){
		HashMap<String, Object> dataInputMap = new HashMap<String, Object>();
		dataInputMap.put("UIid", inputActivity.getId());
		dataInputMap.put("ComponentID", comp.getId());
		dataInputMap.put("role", "my role");
		Map<String, String> dataItemMap = new HashMap<String, String>();
		for (DataItem dataItem : inputActivity.getData()) {
			dataItemMap.put(dataItem.getType().getName(), dataItem.getDescription());
		}
		dataInputMap.put("data", dataItemMap);
		dataInputMap.put("type", "dataInput");
		json.add(dataInputMap);
	}
	
	public void finalize(){
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
		dataInputMap.put("type", "dataOutput");
		json.add(dataInputMap);
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
		dataInputMap.put("type", "dataSelection");
		json.add(dataInputMap);
	}
}
