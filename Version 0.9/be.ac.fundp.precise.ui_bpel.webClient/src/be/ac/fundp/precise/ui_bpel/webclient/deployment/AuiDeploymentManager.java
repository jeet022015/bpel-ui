package be.ac.fundp.precise.ui_bpel.webclient.deployment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;

import net.lingala.zip4j.io.ZipOutputStream;
import net.lingala.zip4j.model.ZipParameters;

import org.apache.axiom.attachments.ByteArrayDataSource;

import be.ac.fundp.precise.ui_bpel.webclient.deployment.axisClient.ProcessDeployerServiceStub;
import be.ac.fundp.precise.ui_bpel.webclient.deployment.axisClient.ProcessDeployerServiceStub.AUI_Descripton;
import be.ac.fundp.precise.ui_bpel.webclient.deployment.axisClient.ProcessDeployerServiceStub.DeployAui;
import be.ac.fundp.precise.ui_bpel.webclient.deployment.axisClient.ProcessDeployerServiceStub.UiMappingType;

import com.google.common.io.ByteStreams;

public class AuiDeploymentManager {

	private String processName;
	private Map<String, Map<String, String>> conf;
	private Map<String, File> mapFile;

	public AuiDeploymentManager (String processName,  Map<String, File> mapFile, Map<String, Map<String, String>> conf){
		this.processName = processName;
		this.conf = conf;
		this.mapFile = mapFile;
	}
	
	public void deploy() throws FileNotFoundException, IOException{
		ProcessDeployerServiceStub test = new ProcessDeployerServiceStub();
		DeployAui uploadAUI0 = new DeployAui ();
		File zipFile = zipAuiPath();
		byte[] auiZip = ByteStreams.toByteArray(new FileInputStream(zipFile));
		ByteArrayDataSource rawData= new ByteArrayDataSource(auiZip);
		DataHandler param = new DataHandler(rawData);
		uploadAUI0.setFile(param);
		uploadAUI0.setProcessName(processName);
		AUI_Descripton[] param2 = getAuiDescriptor();
		uploadAUI0.setDescription(param2);
		test.deployAui(uploadAUI0);
	}

	private AUI_Descripton[] getAuiDescriptor() {
		List<AUI_Descripton> auiDesc = new ArrayList<AUI_Descripton>();
		
		for (String role : mapFile.keySet()) {
			AUI_Descripton employeeRole = new AUI_Descripton();
			employeeRole.setRole(role);
	        employeeRole.setAui_entry(mapFile.get(role).getName());
	        Map<String, String> roleMapping = conf.get(role);
	        UiMappingType[] mapping = new UiMappingType[roleMapping.keySet().size()];
	        int counter2 = 0;
	        for (String entry : roleMapping.keySet()) {
	        	UiMappingType aEntry = new UiMappingType();
	        	aEntry.setActivityId(entry);
	        	aEntry.setIuId(roleMapping.get(entry));
	        	mapping[counter2++] = aEntry;
			}
	        employeeRole.setUiMapping(mapping);
	        auiDesc.add(employeeRole);
		}
        return auiDesc.toArray(new AUI_Descripton[0]);
	}

	private File zipAuiPath() throws IOException {
		File zipTempFile = File.createTempFile("auizip", "zip");
		zipTempFile.deleteOnExit();
		ZipOutputStream outputStream = null;
		InputStream inputStream = null;
		
		try {
			// Prepare the files to be added
			ArrayList<File> filesToAdd = new ArrayList<File>();
			for (File file : mapFile.values()) {
				filesToAdd.add(file);
			}
			outputStream = new ZipOutputStream(new FileOutputStream(zipTempFile));
			ZipParameters parameters = new ZipParameters();
			for (int i = 0; i < filesToAdd.size(); i++) {
				File file = (File)filesToAdd.get(i);
				outputStream.putNextEntry(file,parameters);
				if (file.isDirectory()) {
					outputStream.closeEntry();
					continue;
				}
				inputStream = new FileInputStream(file);
				byte[] readBuff = new byte[4096];
				int readLen = -1;
				while ((readLen = inputStream.read(readBuff)) != -1) {
					outputStream.write(readBuff, 0, readLen);
				}
				outputStream.closeEntry();
				
				inputStream.close();
			}
			
			outputStream.finish();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return zipTempFile;
	}
}
